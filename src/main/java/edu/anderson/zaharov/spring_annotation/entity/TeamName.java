package edu.anderson.zaharov.spring_annotation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "team_name")
@NamedQueries({
        @NamedQuery(name = "TeamName.findById", query = "select distinct t from TeamName t where t.id = :id"),
        @NamedQuery(name = "TeamName.deleteById", query = "delete from TeamName t where t.id = :id")
})

public class TeamName {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column
    private String name;
}
