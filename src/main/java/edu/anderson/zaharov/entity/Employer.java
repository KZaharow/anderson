package edu.anderson.zaharov.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employer {

    private int id;

    private String name;

    private String surName;

    private String patronymic;

    private String mail;

    private String tel;

    private Date birthday;

    private int experience;

    private Date employmentDate;

    private String workSkill;

    private String englishSkill;

    private String skype;

    private int feedbackId;

    private int projectId;

    private int teamId;
}