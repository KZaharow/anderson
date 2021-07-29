package edu.anderson.zaharov.spring_annotation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    private Long id;

    private String name;

    private String costumer;

    private Date finishDate;

    private String methodology;

    private String projectManager;

    private Long teamNameId;
}
