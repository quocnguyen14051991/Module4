package com.quocnguyen.ungdungblog.controller;

import com.quocnguyen.ungdungblog.entity.Digital;
import com.quocnguyen.ungdungblog.service.DigitalService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return new ResponseEntity<Digital>(digital,HttpStatus.FOUND);
    }

}
