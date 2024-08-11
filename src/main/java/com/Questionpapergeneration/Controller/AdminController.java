package com.Questionpapergeneration.Controller;

import com.Questionpapergeneration.Entity.Admin;
import com.Questionpapergeneration.Repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class AdminController {

    @Autowired
    private AdminRepo adminRepo;

    @PutMapping("/Updatepassword")
    public ResponseEntity<?> updatepassword(@RequestBody Admin obj)
    {
        var update=adminRepo.findById(obj.getId()).orElseThrow(()->new RuntimeException("Not found"));
        update.setPassword(obj.getPassword());
        adminRepo.save(update);
        return new ResponseEntity<>("Password Updated Successfully", HttpStatus.OK);
    }
}
