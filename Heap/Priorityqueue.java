import java.util.*;

public class Priorityqueue {
    static class Student implements Comparable<Student> {
        String name;
        int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Student S2) {
            return this.age - S2.age; // Ascending by age
        }

        @Override
        public String toString() {
            return name + " (" + age + ")";
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();

        
        pq.add(new Student("Alice", 22));
        pq.add(new Student("Bob", 20));
        pq.add(new Student("Charlie", 25));

        while (!pq.isEmpty()) {
            System.out.println(pq.poll()); // Automatically sorted by age
        }
    }
}

