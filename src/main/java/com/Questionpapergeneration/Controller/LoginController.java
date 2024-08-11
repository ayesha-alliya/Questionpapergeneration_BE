package com.Questionpapergeneration.Controller;

import com.Questionpapergeneration.DTO.LoginDTO;
import com.Questionpapergeneration.Repository.AdminRepo;
import com.Questionpapergeneration.Repository.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")

public class LoginController {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private RegistrationRepo registrationRepo;

    @PostMapping("/LoginVerify")
    public ResponseEntity<?> LoginVerify(@RequestBody LoginDTO obj)
    {
        if(obj.getUsertype().equals("Admin"))
        {
            var user=adminRepo.findById(obj.getId()).orElseThrow(()->new RuntimeException("Not found"));
            if(user.getPassword().equals(obj.getPassword()))
            {
                return new ResponseEntity<>("Admin", HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<>("Incorrect Password", HttpStatus.OK);
            }

        }
        else
        {
            var reg=registrationRepo.findById(obj.getId()).orElseThrow(()->new RuntimeException("Not found"));
            if(reg.getPassword().equals(obj.getPassword()))
            {
                return new ResponseEntity<>("Member", HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<>("Incorrect Password", HttpStatus.OK);
            }
        }
    }

}
