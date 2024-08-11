package com.Questionpapergeneration.Entity;

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

public class Papergenerater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pgid;

    private int aid;

    private String qset;

    private int sid;

}
