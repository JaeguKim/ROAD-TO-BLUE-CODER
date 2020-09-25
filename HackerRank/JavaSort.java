import java.util.*;

class Student implements Comparable<Student>{
	private int id;
	private String fname;
    private double cgpa;
    public String test;

	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
    }

    @Override
    public int compareTo(Student o) {
        if (cgpa != o.getCgpa()){
            return (cgpa - o.getCgpa()) > 0?-1:1;
        }
        else if (!fname.equals(o.getFname())){
            return fname.compareTo(o.getFname());
        }
        else {
            return id - o.getId();
        }
    }
}

//Complete the code
public class JavaSort
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		
		List<Student> studentList = new ArrayList<Student>();
		while(testCases>0){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();
			
			Student st = new Student(id, fname, cgpa);
			studentList.add(st);
			
			testCases--;
		}
        
        Collections.sort(studentList);
        /* Solution 2 */
        // Collections.sort(studentList,  Comparator.comparing(Student :: getCgpa).reversed().thenComparing(Student :: getFname).thenComparing(Student :: getId));
      	for(Student st: studentList){
			System.out.println(st.getFname());
		}
	}
}



