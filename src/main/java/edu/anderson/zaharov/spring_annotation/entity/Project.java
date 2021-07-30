package edu.anderson.zaharov.spring_annotation.entity;

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
@Table(name = "project")
@NamedQueries({
        @NamedQuery(name = "Project.findById", query = "select distinct p from Project p where p.id = :id")
})
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String costumer;

    @Column(name = "FINISH_DATE")
    private Date finishDate;

    @Column
    private String methodology;

    @Column(name = "PROJECT_MANAGER")
    private String projectManager;
}
