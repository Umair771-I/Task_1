import java.util.Map;
import java.util.TreeMap;

class StudentScoreManager {
    private TreeMap<String, Integer> students;

    StudentScoreManager() {
        students = new TreeMap<>();
    }

    public void addOrUpdateScore(String name, int score) {
        students.put(name, score);
        System.out.println("Score added/updated for " + name);
    }

    public void removeStudent(String name) {
        if (students.remove(name) != null) {
            System.out.println(name + " removed.");
        } else {
            System.out.println("Student not found.");
        }
    }
    public Integer getScore(String name) {
        return students.get(name);
    }
    public void displayAllStudents() {
        System.out.println("\nStudent Records:");
        for (Map.Entry<String, Integer> entry : students.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public void displayStudentsInRange(String start, String end) {
        System.out.println("\nStudents between " + start + " and " + end + ":");

        for (Map.Entry<String, Integer> entry :
                students.subMap(start, true, end, true).entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}

public class Task2 {
    public static void main(String[] args) {
        StudentScoreManager manager = new StudentScoreManager();

        manager.addOrUpdateScore("Ali", 85);
        manager.addOrUpdateScore("Ahmed", 90);
        manager.addOrUpdateScore("Bilal", 78);
        manager.addOrUpdateScore("Hassan", 88);
        manager.addOrUpdateScore("Zain", 95);

        manager.displayAllStudents();

        System.out.println("\nScore of Bilal: " +manager.getScore("Bilal"));

        manager.displayStudentsInRange("A", "H");

        manager.removeStudent("Bilal");

        manager.displayAllStudents();
    }
}