package org.example;

import java.util.Comparator;
import java.util.List;
import org.example.models.Course;

public class MatchListMain {

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

                boolean hasAllCoursesHigherThan150 = courses.stream()
                                .allMatch(course -> course.numberOfStudents() > 150);
                boolean areCoursesWithBadReviews = courses.stream()
                                .anyMatch(course -> course.reviewScore() <= 3);
                boolean areNotCoursesWithExcellentReviews = courses.stream()
                                .noneMatch(course -> course.reviewScore() == 7);

                var comparatorByNumberOfStudents = Comparator.comparing(Course::numberOfStudents, (nro1, nro2) -> {
                        return Integer.compare(nro1, nro2);
                });

                var sortedCoursesByNroOfStudents = courses.stream()
                                .sorted(comparatorByNumberOfStudents)
                                .toList();

                System.out.println("Has all courses with more than 150 students: " + hasAllCoursesHigherThan150);
                System.out.println("Are there courses with bad reviews: " + areCoursesWithBadReviews);
                System.out.println(
                                "Are not there courses with excellent reviews: " + areNotCoursesWithExcellentReviews);
                System.out.println("Sorted courses by number of students: " + sortedCoursesByNroOfStudents);
        }

}