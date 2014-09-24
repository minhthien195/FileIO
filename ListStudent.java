//ex2

package iofile;
/**
 *
 * @author mjnht_000
 */
import java.io.BufferedOutputStream;
import java.util.Scanner;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.nio.Buffer;

public class ListStudent {

    private String name;
    private int age;
    private int mark;
    private boolean flag = true;
    private int a = 5; 
    
    public static void main(String[] args) {
        ListStudent ls = new ListStudent();
        ls.menu();
        
    }
    
    public void menu(){
        ListStudent ls = new ListStudent();
        Scanner scan = new Scanner(System.in);
        while(flag== true){
        
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
                
                ls.setStudent(name, age, mark);
                break;
                
            case 2:
                System.out.println("List student: ");
                System.out.println("------------------");
                ls.getStudent();
                ls.menu();
                break;
                
            case 3:
                System.exit(0);
                
            default : 
                System.out.println("Sorry, we don't have number your choice! ");
        }
        }
    }
    
    
    public void setStudent(String name, int age, int mark) {
        try {
            FileOutputStream os = new FileOutputStream("ListStudent");
            os.write(("Name : " + name + "\n").getBytes());
            os.write(("Age : " + age + "\n").getBytes());
            os.write(("Mark : " + mark + "\n").getBytes());

            os.write(("--------------------" + "\n").getBytes());
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void getStudent() {
        try {
            //open
            FileInputStream is = new FileInputStream("ListStudent");
            //read
            int c;
            while ((c = is.read()) != -1) {
                System.out.print((char) c);
            }
            //close
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
