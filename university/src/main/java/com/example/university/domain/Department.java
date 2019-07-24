package com.example.university.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * JDBC Entity for a Department of study at the University.
 * <p>
 * Created by maryellenbowman
 */
@Table(value = "DEPARTMENT")
public class Department {
    @Id
    private Integer id;

    private String name;

    private Chair chair;

    public Department(String name, Chair chair) {

        this.name = name;
        this.chair = chair;
    }

    public Department updateChair(Chair chair) {
        this.chair = chair;
        return this;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", chair=" + chair +
                '}';
    }
}
