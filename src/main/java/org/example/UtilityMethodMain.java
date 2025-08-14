package org.example;

import java.util.Comparator;
import java.util.List;

import org.example.models.Course;

public class UtilityMethodMain {

    public static void main(String[] args) {

        var courses = List.of(
                new Course("Java Programming", "Programming", 5, 100),
                new Course("Python Programming", "Programming", 2, 80),
                new Course("Web Development", "Development", 5, 120),
                new Course("Data Science", "Data", 5, 150),
                new Course("Machine Learning", "Data", 3, 200),
                new Course("Cloud Computing", "Cloud", 5, 250),
                new Course("Cybersecurity", "Security", 5, 300),
                new Course("Blockchain Basics", "Blockchain", 5, 350));

        var firstThreeCourses = courses.stream()
                .limit(3)
                .toList();

        var skippedList = courses.stream()
                .skip(3)
                .toList();

        var untilABadCourse = courses.stream()
                .takeWhile(course -> course.reviewScore() > 3)
                .toList();

        var courseMaxNroStudents = courses.stream()
                .max(Comparator.comparingInt(Course::numberOfStudents));

        var courseMinNroStudents = courses.stream()
                .min(Comparator.comparingInt(Course::numberOfStudents));

        System.out.println("First three courses: " + firstThreeCourses);
        System.out.println("Skipped courses: " + skippedList);
        System.out.println("Courses until a bad review: " + untilABadCourse);
        System.out.println("Max number of students: " + courseMaxNroStudents);
        System.out.println("Min number of students: " + courseMinNroStudents);

    }

}
