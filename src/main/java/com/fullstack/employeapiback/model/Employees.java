package com.fullstack.employeapiback.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employees {
    private long id;
    private String firstName;
    private String lastName;
    private String emailId;
}
