package edu.anderson.zaharov.spring_annotation.entity;

import edu.anderson.zaharov.spring_annotation.enumeration.EnglishSkill;
import edu.anderson.zaharov.spring_annotation.enumeration.WorkSkill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employer")
public class Employer {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String surName;

    @Column
    private String patronymic;

    @Column
    private String eMail;

    @Column
    private String tel;

    @Column
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column
    private int experience;

    @Column
    @Temporal(TemporalType.DATE)
    private Date employmentDate;

    @Column
    private WorkSkill workSkill;

    @Column
    private EnglishSkill englishSkill;

    private String skype;

    @OneToOne
    @JoinColumn(name = "feedback_id", referencedColumnName = "id")
    private FeedBack feedBack;

    @OneToOne
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private Team team;
}