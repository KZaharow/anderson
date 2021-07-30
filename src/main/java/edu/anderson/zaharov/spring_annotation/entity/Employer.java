package edu.anderson.zaharov.spring_annotation.entity;

import edu.anderson.zaharov.spring_annotation.enumeration.EnglishSkill;
import edu.anderson.zaharov.spring_annotation.enumeration.WorkSkill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employer")
@NamedQueries({
        @NamedQuery(name = "Employer.findById", query = "select distinct e from Employer e where e.id = :id")
})
public class Employer implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String surName;

    @Column
    private String patronymic;

    @Column(name = "E_MAIL")
    private String eMail;

    @Column
    private String tel;

    @Column
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column
    private int experience;

    @Column(name = "EMPLOYMENT_DATA")
    @Temporal(TemporalType.DATE)
    private Date employmentDate;

    @Column(name = "WORK_SKILL")
    private WorkSkill workSkill;

    @Column(name = "ENGLISH_SKILL")
    private EnglishSkill englishSkill;

    @Column
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