package com.quocnguyen.ungdungblog.controller;

import com.quocnguyen.ungdungblog.entity.Digital;
import com.quocnguyen.ungdungblog.service.DigitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/digital")
public class DigitalController {
    @Autowired
    DigitalService digitalService;

    @GetMapping("/listAll")
    public ResponseEntity<List<Digital>> listAllDigital() {
        List<Digital> digitalList = digitalService.findAll();
        return new ResponseEntity<List<Digital>>(digitalList, HttpStatus.OK);
    }

    @GetMapping("/listAllByLoad")
    public ResponseEntity<List<Digital>> listAll(@RequestParam Integer start,@RequestParam Integer limit) {
        Integer a=start;
        Integer b=limit;
        List<Digital> digitalList = digitalService.findAllByLoadMore(start,limit);
        return new ResponseEntity<List<Digital>>(digitalList,HttpStatus.OK);
    }

    @GetMapping("/searchByIdCategory/{id_category}")
    public ResponseEntity<List<Digital>> listSearch(@PathVariable("id_category") Integer id_category) {
        List<Digital> digitalList = digitalService.findById_Category(id_category);
        if (digitalList.equals("")) {
            return new ResponseEntity<List<Digital>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Digital>>(digitalList, HttpStatus.FOUND);
    }

    @GetMapping("/searchByIdDigital/{id_digital}")
    public ResponseEntity<Digital> digitalResponseEntity(@PathVariable("id_digital") Integer id_digital) {
        Digital digital = digitalService.findById(id_digital);
        if (digital == null) {

            return new ResponseEntity<Digital>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Digital>(digital, HttpStatus.FOUND);
    }

    @GetMapping("/searchByTitle/{search}")
    public ResponseEntity<List<Digital>> listDigitalByTitle(@PathVariable("search") String txtSearch) {
        List<Digital> digitalList = digitalService.findByTitle(txtSearch);
        if (digitalList.size() == 0) {
            return new ResponseEntity<List<Digital>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Digital>>(digitalList, HttpStatus.OK);
    }

}
