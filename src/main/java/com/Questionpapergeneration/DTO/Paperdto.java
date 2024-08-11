package com.Questionpapergeneration.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Paperdto {
    private int aid;

    private String question;
    private int marks;
    private boolean alloted;
    private int pgid;

    private String qset;
    private int sid;

    private String subject;
    private int subject_sid;
}
