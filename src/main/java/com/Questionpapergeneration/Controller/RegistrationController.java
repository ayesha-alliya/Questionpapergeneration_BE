package com.Questionpapergeneration.Controller;

import com.Questionpapergeneration.Entity.Registration;
import com.Questionpapergeneration.Repository.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@CrossOrigin("*")

public class RegistrationController {

    @Autowired
    private RegistrationRepo registrationRepo;

    @PostMapping("/registration")
    public ResponseEntity<?> registration(@RequestBody Registration obj)
    {
        Random rand=new Random();
        int id=rand.nextInt(1000,9999);
        obj.setRegid(id);
        obj.setStatus("Pending");
        registrationRepo.save(obj);
        return new ResponseEntity<>(obj.getRegid(), HttpStatus.OK);
    }

    @PutMapping("/Approveusers/{id}")
    public ResponseEntity<?> Approveusers(@PathVariable Integer id )
    {
        var data=registrationRepo.findById(id).orElseThrow(()->new RuntimeException("Not found"));
        data.setStatus("Approved");
        registrationRepo.save(data);
        return new ResponseEntity<>("User Approved Successfully",HttpStatus.OK);
    }

    @GetMapping("/getusers/{id}")
    public ResponseEntity<?> getusers(@PathVariable Integer id)
    {
        var user=registrationRepo.findById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping("/getuser")
    public ResponseEntity<?> getuser()
    {
        var user=registrationRepo.findAll();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
}
