package com.wang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Employee {
    private int id;
    private String name;
    private String email;
    private int gender;//0-男 1-女
    private Department department;
    private Date birth;

    public Employee(int id, String name, String email, int gender, Department department, Date birth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.department = department;
        this.birth = birth!=null?birth:new Date();
    }
}
