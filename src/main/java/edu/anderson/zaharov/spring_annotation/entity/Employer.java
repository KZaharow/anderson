package edu.anderson.zaharov.spring_annotation.entity;

import edu.anderson.zaharov.spring_annotation.enumeration.EnglishSkill;
import edu.anderson.zaharov.spring_annotation.enumeration.WorkSkill;
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

    private String surName;

    private String patronymic;

    private String eMail;

    private String tel;

    private Date birthday;

    private int experience;

    private Date employmentDate;

    private int projectId;

    private WorkSkill workSkill;

    private EnglishSkill englishSkill;

    private String skype;

    private int feedbackId;
}