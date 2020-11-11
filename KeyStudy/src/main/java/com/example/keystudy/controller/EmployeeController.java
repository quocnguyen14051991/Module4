package com.example.keystudy.controller;

import com.example.keystudy.entity.employee.Division;
import com.example.keystudy.entity.employee.EducationDegree;
import com.example.keystudy.entity.employee.Employee;
import com.example.keystudy.entity.employee.PositionEmployee;
import com.example.keystudy.entity.user.Role;
import com.example.keystudy.entity.user.UserEntity;
import com.example.keystudy.entity.user.UserRole;
import com.example.keystudy.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    EducationDegreeService educationDegreeService;
    @Autowired
    PositionService positionService;
    @Autowired
    DivisionService divisionService;
    @Autowired
    UserEntityService userEntityService;
    @Autowired
    RoleService roleService;
    @Autowired
    UserRoleService userRoleService;

    @GetMapping({"", "/listEmployee"})
    public String listEmployee(Model model, @PageableDefault(size = 5) Pageable pageable, @RequestParam Optional<String> text) {
        String keywordOld = "";
        if (text.isPresent()) {
            keywordOld = text.get();
            Page<Employee> employees = this.employeeService.findByName(keywordOld, pageable);
            model.addAttribute("employees", employees);
        } else {
            Page<Employee> employees = this.employeeService.findAll(pageable);
            model.addAttribute("employees", employees);
        }
        model.addAttribute("keywordOld", keywordOld);
        return "employee";
    }

    @GetMapping("/create")
    public String createEmployee(Model model) {
        List<EducationDegree> educationDegrees = this.educationDegreeService.findAll();
        List<PositionEmployee> positions = this.positionService.findAll();
        List<Division> divisions = this.divisionService.findAll();
        List<Role> roles = this.roleService.findAll();
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("educationDegrees", educationDegrees);
        model.addAttribute("positions", positions);
        model.addAttribute("divisions", divisions);
        model.addAttribute("roles", roles);
        return "create-employee";
    }

    @PostMapping("/create")
    public String createEmployee(@Valid @ModelAttribute Employee employee, RedirectAttributes redirectAttributes, BindingResult bindingResult, Model model,@RequestParam String userEmployee
   , @RequestParam String passEmployee,@RequestParam String roleEmployee) {
        new Employee().validate(employee, bindingResult);
        if (bindingResult.hasErrors()) {

//            List<UserEntity> userEntities=this.userEntityService.findAll();
            List<EducationDegree> educationDegrees = this.educationDegreeService.findAll();
            List<PositionEmployee> positions = this.positionService.findAll();
            List<Division> divisions = this.divisionService.findAll();
            model.addAttribute("educationDegrees", educationDegrees);
            model.addAttribute("positions", positions);
            model.addAttribute("divisions", divisions);
            return "create-employee";
        }
        BCryptPasswordEncoder bCryptPasswordEncoder =new BCryptPasswordEncoder();
      passEmployee=  bCryptPasswordEncoder.encode(passEmployee);
        UserEntity userEntity = new UserEntity(userEmployee,passEmployee);
        this.userEntityService.save(userEntity);

        UserRole userRole =new UserRole();
//        userEntity.setEmployees(employee);

        employee.setUserEntity(userEntity);
        this.employeeService.save(employee);

        userRole.setUserEntity(userEntity);
        Role role = this.roleService.findByName(roleEmployee);
        userRole.setRole(role);

        this.userRoleService.save(userRole);

        redirectAttributes.addFlashAttribute("message", "create is ok");
        return "redirect:/employees/listEmployee";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        Employee employee = this.employeeService.findById(id);
        this.userEntityService.delete(employee.getUserEntity());
        redirectAttributes.addFlashAttribute("message", "delete is ok");
        return "redirect:/employees/listEmployee";
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable Integer id, Model model) {
        List<EducationDegree> educationDegrees = this.educationDegreeService.findAll();
        List<PositionEmployee> positions = this.positionService.findAll();
        List<Division> divisions = this.divisionService.findAll();
        Employee employee = this.employeeService.findById(id);
        model.addAttribute("educationDegrees", educationDegrees);
        model.addAttribute("positions", positions);
        model.addAttribute("divisions", divisions);
        model.addAttribute("employee", employee);

        return "edit-employee";
    }

    @PostMapping("/edit")
    public String editEmployee(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes) {
        this.employeeService.save(employee);
        redirectAttributes.addFlashAttribute("message", "edit is ok");
        return "redirect:/employees/listEmployee";
    }
}
