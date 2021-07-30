package edu.anderson.zaharov.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {

    private Long id;

    private Long teamNameId;

    private Long employerId;
}