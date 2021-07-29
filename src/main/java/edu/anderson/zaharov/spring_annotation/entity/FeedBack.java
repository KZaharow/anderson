package edu.anderson.zaharov.spring_annotation.entity;

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
@Table(name = "feedback")
public class FeedBack {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column
    private String text;

    @Column
    @Temporal(TemporalType.DATE)
    private Date date;

    @OneToOne(mappedBy = "feedBack")
    private Employer employer;
}
