package com.example.university.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Mongo Document for a Department of study at the University.
 * <p>
 * Created by maryellenbowman
 */
@Document
public class Department {
    @Id
    private Integer id;

    private String name;

    @DBRef(db = "chair")
    private Staff chair;

    public Department(Integer id, String name, Staff chair) {
        this.id = id;
        this.name = name;
        this.chair = chair;
    }

    protected Department() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setChair(Staff chair) {
        this.chair = chair;
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
