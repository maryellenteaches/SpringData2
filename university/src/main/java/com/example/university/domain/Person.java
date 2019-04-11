package com.example.university.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Person encapsulates an individual's first and last name.
 *
 * Created by maryellenbowman
 */
@Embeddable
public class Person {
    @Column
    private String firstName;

    @Column
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    protected Person() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return  " firstName='" + firstName + '\'' +
                ", lastName='" + lastName + "\' ";
    }
}
