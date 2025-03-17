package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Bears")
public class BearController {

    @Autowired
    private BearsService service;


    @GetMapping("/all")
    public Object getAllBears() {
        return new ResponseEntity<>(service.getAllBears(), HttpStatus.OK);

    }

    @GetMapping("/{BearId}")
    public Object getOneBear(@PathVariable int bearId) {
        return new ResponseEntity<>(service.getBearsById(bearId), HttpStatus.OK);

    }

    @GetMapping("/name")
    public Object getBearsByName(@RequestParam(name = "search", defaultValue = "") String search) {
        return new ResponseEntity<>(service.getBearsByName(search), HttpStatus.OK);

    }


    @GetMapping("/description/{description}")
    public Object getBearsByDescription(@PathVariable String description) {
        return new ResponseEntity<>(service.getBearsByDescription(description), HttpStatus.OK);
    }



    @GetMapping("/age")
    public Object getAgeBears(@RequestParam(name = "age", defaultValue = "3.0") double age) {
        return new ResponseEntity<>(service.getAgeBears(age), HttpStatus.OK);

    }


    @PostMapping("/new")
    public Object addNewBears(@RequestBody Bears bears) {
        service.addNewBears(bears);
        return new ResponseEntity<>(service.getAllBears(), HttpStatus.CREATED);

    }


    @PutMapping("/update/{BearsId}")
    public Object updateBears(@PathVariable int BearsId, @RequestBody Bears bears) {
        service.updateBear(BearsId, bears);
        return new ResponseEntity<>(service.getBearsById(BearsId), HttpStatus.CREATED);

    }


    @DeleteMapping("/delete/{BearsId}")
    public Object deleteBearsById(@PathVariable int BearsId) {
        service.deleteBearsById(BearsId);
        return new ResponseEntity<>(service.getAllBears(), HttpStatus.OK);
    }
}
