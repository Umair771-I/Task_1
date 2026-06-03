import java.util.TreeMap;
import java.util.TreeSet;

class CourseEnrollmentManager {

    private TreeMap<String, TreeSet<String>> courses;

    public CourseEnrollmentManager() {
        courses = new TreeMap<>();
    }

    public void addStudentToCourse(String course, String studentName) {

        courses.putIfAbsent(course, new TreeSet<>());

        courses.get(course).add(studentName);

        System.out.println(studentName + " enrolled in " + course);
    }

    public void removeStudentFromCourse(String course, String studentName) {

        if (courses.containsKey(course)) {

            if (courses.get(course).remove(studentName)) {
                System.out.println(studentName + " removed from " + course);
            } else {
                System.out.println(studentName + " not found in " + course);
            }

        } else {
            System.out.println("Course not found.");
        }
    }
    public boolean isStudentEnrolled(String course, String studentName) {

        return courses.containsKey(course)
                && courses.get(course).contains(studentName);
    }

    public void displayCourseRoster(String course) {

        if (!courses.containsKey(course)) {
            System.out.println("Course not found.");
            return;
        }

        System.out.println("Students enrolled in " + course + ":");

        for (String student : courses.get(course)) {
            System.out.println(student);
        }
    }
}

public class Task3 {
    public static void main(String[] args) {

        CourseEnrollmentManager manager = new CourseEnrollmentManager();

        manager.addStudentToCourse("Data Structures", "Ali");
        manager.addStudentToCourse("Data Structures", "Ahmed");
        manager.addStudentToCourse("Data Structures", "Bilal");

        manager.addStudentToCourse("Database Systems", "Hassan");
        manager.addStudentToCourse("Database Systems", "Zain");

        manager.displayCourseRoster("Data Structures");

        System.out.println();

        System.out.println(manager.isStudentEnrolled("Data Structures", "Bilal"));

        manager.removeStudentFromCourse("Data Structures", "Bilal");

        System.out.println();

        manager.displayCourseRoster("Data Structures");
    }
}