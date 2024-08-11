package com.Questionpapergeneration.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Registration {

    @Id
    private int regid;

    private String name;
    private String email;
    private String phone;
    private String address;
    private String password;
    private String status;

    @OneToMany(mappedBy = "member")
    @JsonIgnore
    private List<Postproblem> postproblem;

}
