package com.example.university.view;

/**
 * Created by maryellenbowman .
 */
public class CourseView {
    private String name;
    private String instructorLastName;
    private String deptName;

    public CourseView(String name, String instructorLastName, String deptName) {
        this.name = name;
        this.instructorLastName = instructorLastName;
        this.deptName = deptName;
    }

    public String getName() {
        return name;
    }

    public String getInstructorLastName() {
        return instructorLastName;
    }

    public String getDeptName() {
        return deptName;
    }

    @Override
    public String toString() {
        return "CourseView{" +
                "name='" + name + '\'' +
                ", instructorLastName='" + instructorLastName + '\'' +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
