package iofile;

/**
 *
 * @author mjnht_000
 */
import java.util.Scanner;
import java.io.*;

public class ListObjStudent {

    private String name;
    private int age;
    private int mark;
    private boolean flag = true;

    public static void main(String[] args) {
        ListObjStudent los = new ListObjStudent();
        los.menu();

    }

    public void menu() {
        ListObjStudent los = new ListObjStudent();
        Scanner scan = new Scanner(System.in);
        Student s;
        while (flag == true) {

            System.out.println("Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Loading list Student");
            System.out.println("3 .Exit");
            System.out.println("Enter your choice: ");

            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter name Sudent :");
                    String name = scan.next();
                    System.out.println("Enter age Sudent :");
                    int age = scan.nextInt();
                    System.out.println("Enter mark Sudent :");
                    int mark = scan.nextInt();

                    s = new Student(name, age, mark);
                    los.setStudent(s);

                    break;

                case 2:
                    System.out.println("List student: ");
                    System.out.println("------------------");
                    los.getStudent();

                    los.menu();
                    break;

                case 3:
                    System.exit(0);

                default:
                    System.out.println("Sorry, we don't have number your choice! ");
            }
        }
    }

    public void setStudent(Student stu) {
        try {

            FileOutputStream fw = new FileOutputStream("ListObjStudent", flag);
            ObjectOutputStream oos = new ObjectOutputStream(fw);

            oos.writeObject(stu);

            oos.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void getStudent() {
        try {
            //open
            FileInputStream fis = new FileInputStream("ListObjStudent");
            ObjectInputStream ois = new ObjectInputStream(fis);
            //read
            Object o = ois.readObject();
            System.out.println(o.toString());
            //close
            ois.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
