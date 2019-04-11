package com.example.university;

import com.example.university.domain.*;
import com.example.university.repo.CourseRepository;
import com.example.university.repo.DepartmentRepository;
import com.example.university.repo.StaffRepository;
import com.example.university.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Spring Boot Class for the University Application.
 * On Startup Initialize Database with Students, Staff, Courses, and Departments.
 *
 * Created by maryellenbowman
 */
@SpringBootApplication
public class UniversityApplication implements CommandLineRunner{
	@Autowired
	StudentRepository studentRepository;

	@Autowired
	StaffRepository staffRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	public static void main(String[] args) {
		SpringApplication.run(UniversityApplication.class, args);
	}

    /**
     * Initialize the Database at application startup.
     *
     * @param strings
     * @throws Exception
     */
	@Override
	public void run(String... strings) throws Exception {
		//Students
		boolean fullTime = true;
		studentRepository.save(new Student(new Person("jane", "doe"), fullTime, 20));
		studentRepository.save(new Student(new Person("john", "doe"), fullTime, 22));
		studentRepository.save(new Student(new Person("mike", "smith"), fullTime, 18));
		studentRepository.save(new Student(new Person("ally", "kim"), !fullTime, 19));

		//Staff
		Staff deanJones = staffRepository.save(new Staff(new Person("John","Jones")));
		Staff deanMartin = staffRepository.save(new Staff(new Person("Matthew","Martin")));
		Staff profBrown =   staffRepository.save(new Staff(new Person ("James", "Brown")));
		Staff profMiller =   staffRepository.save(new Staff(new Person ("Judy", "Miller")));
		Staff profDavis =   staffRepository.save(new Staff(new Person ("James", "Davis")));
		Staff profMoore =   staffRepository.save(new Staff(new Person ("Allison", "Moore")));
		Staff profThomas =   staffRepository.save(new Staff(new Person ("Tom", "Thomas")));
		Staff profGreen =   staffRepository.save(new Staff(new Person ("Graham", "Green")));
		Staff profWhite=   staffRepository.save(new Staff(new Person ("Whitney", "White")));
		Staff profBlack =   staffRepository.save(new Staff(new Person ("Jack", "Black")));
		Staff profKing =   staffRepository.save(new Staff(new Person ("Queen", "King")));

		//Departments
		Department humanities = departmentRepository.save(new Department("Humanities", deanJones));
		Department naturalSciences = departmentRepository.save(new Department("Natural Sciences", deanMartin));
		Department socialSciences = departmentRepository.save(new Department("Social Sciences", deanJones));

		//Humanities Courses
		Course english101 = courseRepository.save(new Course("English 101", 3, profBlack, humanities));
		Course english202 = courseRepository.save(new Course("English 202", 3, profBlack, humanities));
		courseRepository.save(english202.addPrerequisite(english101));
		Course english201 = courseRepository.save(new Course("English 201", 3, profBrown, humanities));
		courseRepository.save(english201.addPrerequisite(english101));

		//Natural Science Courses
		Course chemistry = courseRepository.save(new Course("Chemistry",3, profDavis, naturalSciences));
		Course physics = courseRepository.save(new Course("Physics",3, profDavis, naturalSciences));
		courseRepository.save(physics.addPrerequisite(chemistry));
		Course cProgramming = courseRepository.save(new Course("C Programming",3, profMoore, naturalSciences));
		Course jProgramming = courseRepository.save(new Course("Java Programming",3, profMoore, naturalSciences));

		//Social Science Courses
		Course history101 = courseRepository.save(new Course("History 101",3, profMiller, socialSciences));
		Course anthro = courseRepository.save(new Course("Anthropology ",3, profKing, socialSciences));
		courseRepository.save(anthro.addPrerequisite(history101));
		Course sociology = courseRepository.save(new Course("Sociology",3, profKing, socialSciences));
		courseRepository.save(sociology.addPrerequisite(history101));
		Course psych = courseRepository.save(new Course("Psychology",3, profWhite, socialSciences));
		courseRepository.save(psych.addPrerequisite(history101).addPrerequisite(english101));

	}
}
