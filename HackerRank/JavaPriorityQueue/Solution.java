import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * Create the Student and Priorities classes here.
 */

 class Student implements Comparable<Student> {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa){
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    public int getID() {
        return id;
    }

    public String getName(){
        return name;
    }

    public double getCGPA(){
        return cgpa;
    }

    @Override
    public int compareTo(Student o) {
        if (cgpa != o.getCGPA()){
            return o.getCGPA()-cgpa < 0 ? -1 : 1;
        }
        else if (!name.equals(o.getName())){
            return name.compareTo(o.getName());
        }
        else {
            return id-o.getID();
        }
    }

 }

class Priorities {

    private PriorityQueue<Student> pq;

    public Priorities(){
        pq = new PriorityQueue<>();
    }

    List<Student> getStudents(List<String> events){
        StringTokenizer tokenizer;
        for (String event : events){
            tokenizer = new StringTokenizer(event);
            String command = tokenizer.nextToken();
            if (command.equals("ENTER")){
                String name = tokenizer.nextToken();
                double cgpa = Double.parseDouble(tokenizer.nextToken());
                int id = Integer.parseInt(tokenizer.nextToken());
                pq.offer(new Student(id,name,cgpa));
            }    
            else if (command.equals("SERVED")){
                pq.poll();
            }
        }

        List<Student> list = new ArrayList<>();
        while (!pq.isEmpty())
            list.add(pq.poll());
        return list;
    }
}
 

public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}