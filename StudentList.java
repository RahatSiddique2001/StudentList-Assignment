
import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {
		if(args.length  != 1){
			System.err.println(conts.invalid);
			System.err.println(conts.message);
			System.err.println(conts.exit);
			System.exit(1);
		}
		if(args[0].equals(conts.print)) {
			System.out.println(conts.load);
			try {
			for(String student : readFile().readLine().split(conts.comma)) {
				System.out.println(student);
			}
			} catch (Exception e){}
			System.out.println(conts.loaded);
		}
		else if(args[0].equals(conts.random)) {
			System.out.println(conts.load);
			try {
			String nameOfStudents[] = readFile().readLine().split(conts.comma);
			int randomnameOfStudents = new Random().nextInt(nameOfStudents.length);
			System.out.println(nameOfStudents[randomnameOfStudents]);
			} catch (Exception e){}
			System.out.println(conts.loaded);
		}
		else if(args[0].contains(conts.add)){
			System.out.println(conts.load);
			try {
			BufferedWriter bufferedWriter = writeFile();
			String inputData = args[0].substring(1);
	        String dateFormat = new SimpleDateFormat(conts.dd).format(new Date());
			bufferedWriter.write(conts.comma +inputData+ conts.lastUpdate +formatDate);
			bufferedWriter.close();
			} catch (Exception e){}
			System.out.println(conts.loaded);
		}
		else if(args[0].contains(conts.search)) {
			System.out.println(conts.load);
			try {
			String nameOfStudents[] = readFile().readLine().split(conts.comma);
			for(int index = 0; index<nameOfStudents.length; index++) {
				if(nameOfStudents[index].equals(args[0].substring(1))) {
					System.out.println(conts.found);
					break;
				}
			}
			} catch (Exception e){}
			System.out.println(conts.loaded);
		}
		else if(args[0].contains(conts.count)) {
			System.out.println(conts.load);
			try {
			System.out.println(readFile().readLine().split(conts.comma).length + conts.word);
			} catch (Exception e){}
			System.out.println(conts.loaded);
		}
		else{
			System.err.println(conts.invalid);
			System.err.println(conts.exit);
			System.exit(2);
		}

	}

	private static BufferedReader readFile() throws FileNotFoundException{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(conts.studentsList)));
		return bufferedReader;
	}
	private static BufferedWriter writeFile() throws IOException {
		BufferedWriter bufferedReader = new BufferedWriter(new FileWriter(conts.studentsList, true));
		return bufferedReader;
	}

}
