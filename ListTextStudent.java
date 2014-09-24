
package iofile;
/**
 *
 * @author mjnht_000
 */
import java.io.*;
import java.util.Scanner;


public class ListTextStudent {

    private String name;
    private int age;
    private int mark;
    private boolean flag = true;
    
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
            
            FileWriter fw = new FileWriter("ListStudent", flag);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write("Name : " + name + "\n");
            bw.write("Age : " + age + "\n");
            bw.write("Mark : " + mark + "\n");
            bw.write("--------------------" + "\n");
            
            bw.flush();
            fw.flush();
            bw.close();
            
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void getStudent() {
        try {
            //open
            FileReader fr = new FileReader("ListStudent");
            BufferedReader br = new BufferedReader(fr);
            //read
            String c;
            while ((c = br.readLine()) != null) {
                System.out.print(br);
            }
            
            //close
            
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
