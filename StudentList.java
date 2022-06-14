import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {

//		Check arguments
		if(args[0].equals("a")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader studentName = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
				String lineOfStudentName = studentName.readLine();
				String studentNameIndex[] = lineOfStudentName.split(",");
				for(String j : studentNameIndex) {
					System.out.println(j);
				}
			} catch (Exception e){

			}
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader studentName = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
				String lineOfStudentName = studentName.readLine();
				//System.out.println(lineOfStudentName);
				String studentNameIndex[] = lineOfStudentName.split(",");
				Random x = new Random();
				int y = x.nextInt(studentNameIndex.length);
				System.out.println(studentNameIndex[y]);
			} catch (Exception e){

			}
			System.out.println("Data Loaded.");
		}
		else if(args[0].contains("+")){
			System.out.println("Loading data ...");
			try {
				BufferedWriter studentName = new BufferedWriter(new FileWriter("students.txt", true));
				String t = args[0].substring(1);
				Date d = new Date();
				String df = "dd/mm/yyyy-hh:mm:ss a";
				DateFormat dateFormat = new SimpleDateFormat(df);
				String fd= dateFormat.format(d);
				studentName.write(", "+t+"\nList last updated on "+fd);
				studentName.close();
			} catch (Exception e){

			}
			System.out.println("Data Loaded.");
		}
		else if(args[0].contains("?")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader studentName = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
				String r = studentName.readLine();
				String studentNameIndex[] = r.split(",");
				boolean done = false;
				String t = args[0].substring(1);
				for(int idx = 0; idx<studentNameIndex.length && !done; idx++) {
					if(studentNameIndex[idx].equals(t)) {
						System.out.println("We found it!");
						done=true;
					}
				}
			} catch (Exception e){

			}
			System.out.println("Data Loaded.");
		}
		else if(args[0].contains("c")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader studentName = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
				String D = studentName.readLine();
				char a[] = D.toCharArray();
				boolean in_word = false;
				int count=0;
				for(char c:a) {
					if(c ==' ') {
						if (!in_word) {
							count++; in_word =true;
						}
						else {
							in_word=false;
						}
					}
				}
				System.out.println(count +" word(studentName) found " + a.length);
			} catch (Exception e){

			}
			System.out.println("Data Loaded.");
		}
		else {
			System.err.println("Wrong argumwent");
			System.err.println("Program exiting");
			System.exit(2);
		}
	}
}