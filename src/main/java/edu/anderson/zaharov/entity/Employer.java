package edu.anderson.zaharov.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employer {

    private Long id;

    private String name;

    private String patronymic;
    private String eMail;
    private String tel;
    private Date birthday;
    private int experience;
    private Date employmentDate;
    private int projectId;
    private String workSkill;
    private String englishSkill;


    private String text;


}