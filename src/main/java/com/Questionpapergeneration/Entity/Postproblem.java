package com.Questionpapergeneration.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Postproblem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postid;
    private String problem;
    private String status;
    @ManyToOne
    private Registration member;

}
