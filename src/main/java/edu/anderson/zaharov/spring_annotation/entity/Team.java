package edu.anderson.zaharov.spring_annotation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "team")
@NamedQueries({
        @NamedQuery(name = "Team.findById", query = "select distinct t from TeamName t where t.id = :id")
})

public class Team {

    private Long id;

    private Long teamNameId;

    private Long employerId;
}