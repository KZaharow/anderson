package edu.anderson.zaharov.spring_annotation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "team")
@NamedQueries({
        @NamedQuery(name = "Team.findById", query = "select distinct t from Team t where t.id = :id")
})
public class Team implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Employer> employers = new HashSet<>();

    public boolean addEmployer(Employer employer) {

        employer.setTeam(this);
        return getEmployers().add(employer);
    }
}