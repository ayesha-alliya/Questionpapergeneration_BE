package com.Questionpapergeneration.Controller;

import com.Questionpapergeneration.Entity.Addquestion;
import com.Questionpapergeneration.Entity.Subject;
import com.Questionpapergeneration.Repository.AddquestionRepo;
import com.Questionpapergeneration.Repository.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class AddquestionController {

    @Autowired
    private AddquestionRepo addquestionRepo;

    @Autowired
    private SubjectRepo subjectRepo;
    @PostMapping("/Addquestions/{id}")
    public ResponseEntity<?> Addquestions(@RequestBody Addquestion obj,@PathVariable Integer id)
    {
        var sid=subjectRepo.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
        obj.setSubject(sid);
        addquestionRepo.save(obj);
        return new ResponseEntity<>("Added Successfully", HttpStatus.OK);
    }

    @GetMapping("/Getquestion")
    public ResponseEntity<?> Getquestion()
    {
        var quest=addquestionRepo.findAll();
        return new ResponseEntity<>(quest,HttpStatus.OK);
    }

}
