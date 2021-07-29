package edu.anderson.zaharov.spring_annotation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column
    private Long teamNameId;

    @OneToMany(mappedBy = "team", cascade=CascadeType.ALL, orphanRemoval=true)
    private Set<Employer> employers;
}