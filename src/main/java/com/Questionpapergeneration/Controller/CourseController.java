package com.Questionpapergeneration.Controller;

import com.Questionpapergeneration.Entity.Course;
import com.Questionpapergeneration.Repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class CourseController {

    @Autowired
    private CourseRepo courseRepo;

    @PostMapping("/Addcourse")
    public ResponseEntity<?> Addcourse(@RequestBody Course obj)
    {
        courseRepo.save(obj);
        return new ResponseEntity<>("Added Successfully", HttpStatus.OK);
    }

    @GetMapping("/Getcourse")
    public ResponseEntity<?> getcourse()
    {
        var course=courseRepo.findAll();
        return new ResponseEntity<>(course,HttpStatus.OK);
    }

}
