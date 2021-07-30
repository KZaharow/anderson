package edu.anderson.zaharov.entity;

import lombok.Data;

// all enmities configs are in xml
@Data
public class Company {

    private int companyId;
    private String companyName;
    private int addressId;
    private int contactId;
}
