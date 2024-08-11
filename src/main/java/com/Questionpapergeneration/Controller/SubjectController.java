package com.Questionpapergeneration.Controller;

import com.Questionpapergeneration.Entity.Subject;
import com.Questionpapergeneration.Repository.CourseRepo;
import com.Questionpapergeneration.Repository.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class SubjectController {

    @Autowired
    private SubjectRepo subjectRepo;

    @Autowired
    private CourseRepo courseRepo;

    @PostMapping("/Addsubject/{cid}")
    public ResponseEntity<?> Addsubject(@RequestBody Subject obj,@PathVariable Integer cid)
    {
        var course=courseRepo.findById(cid).orElseThrow(()->new RuntimeException("Not found"));
        obj.setCourse(course);

        subjectRepo.save(obj);
        return new ResponseEntity<>("Added Successfully", HttpStatus.OK);
    }

    @GetMapping("/GetSubject")
    public ResponseEntity<?> GetSubject()
    {
        var subject=subjectRepo.findAll();
        return new ResponseEntity<>(subject,HttpStatus.OK);
    }

}
