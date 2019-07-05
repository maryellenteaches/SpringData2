package com.example.university.domain;


/**
 * Person encapsulates an individual's first and last name.
 * <p>
 * Created by maryellenbowman
 */
public class Person {

    private String firstName;

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
        return " firstName='" + firstName + '\'' +
                ", lastName='" + lastName + "\' ";
    }
}
