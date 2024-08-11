package com.Questionpapergeneration.Controller;

import com.Questionpapergeneration.Entity.Postproblem;
import com.Questionpapergeneration.Entity.Subject;
import com.Questionpapergeneration.Repository.PostproblemRepo;
import com.Questionpapergeneration.Repository.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class PostproblemController {
    @Autowired
    private PostproblemRepo postproblemRepo;
    @Autowired
    private RegistrationRepo registrationRepo;

    @PostMapping("/PostproblemTicket/{rid}")
    public ResponseEntity<?> PostproblemTicket(@RequestBody Postproblem obj, @PathVariable Integer rid)
    {
        var reg=registrationRepo.findById(rid).orElseThrow(()->new RuntimeException("Not found"));
        obj.setMember(reg);
        obj.setStatus("Pending");
        postproblemRepo.save(obj);
        return new ResponseEntity<>("Prblem post Successfully", HttpStatus.OK);
    }

    @GetMapping("/GetPostproblemTicket")
    public ResponseEntity<?> getPostproblemTicket()
    {
        var data=postproblemRepo.findAll();
        return new ResponseEntity<>(data,HttpStatus.OK);
    }

    @PutMapping("/Solveproblem/{id}")
    public ResponseEntity<?> Solveproblem(@PathVariable Integer id )
    {
        var data=postproblemRepo.findById(id).orElseThrow(()->new RuntimeException("Not found"));
        data.setStatus("Solved");
        postproblemRepo.save(data);
        return new ResponseEntity<>("Problem Solve Successfully",HttpStatus.OK);
    }

}
