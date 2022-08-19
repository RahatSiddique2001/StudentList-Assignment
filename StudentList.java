
import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println(Constant.invalid);
            System.err.println(Constant.message);
            System.err.println(Constant.exit);
            System.exit(1);
        }
        if (args[0].equals(Constant.print)) {
            System.out.println(Constant.load);
            try {
                for (String student : readFile().readLine().split(Constant.comma)) {
                    System.out.println(student);
                }
            } catch (Exception e) {
            }
            System.out.println(Constant.loaded);
        } else if (args[0].equals(Constant.random)) {
            System.out.println(Constant.load);
            try {
                String nameOfStudents[] = readFile().readLine().split(Constant.comma);
                int randomnameOfStudents = new Random().nextInt(nameOfStudents.length);
                System.out.println(nameOfStudents[randomnameOfStudents]);
            } catch (Exception e) {
            }
            System.out.println(Constant.loaded);
        } else if (args[0].contains(Constant.add)) {
            System.out.println(Constant.load);
            try {
                BufferedWriter bufferedWriter = writeFile();
                String inputData = args[0].substring(1);
                String dateFormat = new SimpleDateFormat(Constant.dd).format(new Date());
                bufferedWriter.write(Constant.comma + inputData + Constant.lastUpdate + dateFormat);
                bufferedWriter.close();
            } catch (Exception e) {
            }
            System.out.println(Constant.loaded);
        } else if (args[0].contains(Constant.search)) {
            System.out.println(Constant.load);
            try {
                String nameOfStudents[] = readFile().readLine().split(Constant.comma);
				boolean found = false;
                for (String name : nameOfStudents) {
                    if (name.equals(args[0].substring(1))) {
                        System.out.println(Constant.found + args[0].substring(1));
						found = true;
                        break;
                    }
                }
				if (!found) System.out.println(Constant.notFound + args[0].substring(1));
            } catch (Exception e) {
            }
            System.out.println(Constant.loaded);
        } else if (args[0].contains(Constant.count)) {
            System.out.println(Constant.load);
            try {
                System.out.println(readFile().readLine().split(Constant.comma).length + Constant.word);
            } catch (Exception e) {
            }
            System.out.println(Constant.loaded);
        } else {
            System.err.println(Constant.invalid);
            System.err.println(Constant.exit);
            System.exit(2);
        }

    }

    private static BufferedReader readFile() throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(Constant.studentsList)));
        return bufferedReader;
    }

    private static BufferedWriter writeFile() throws IOException {
        BufferedWriter bufferedReader = new BufferedWriter(new FileWriter(Constant.studentsList, true));
        return bufferedReader;
    }

}
