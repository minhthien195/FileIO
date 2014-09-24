package iofile;

/**
 *
 * @author mjnht_000
 */
import java.io.*;
import java.util.Scanner;

public class CopyFile {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter file copy: ");
        String fileToCopy = s.next();
        System.out.println("Enter the destination : ");
        String destination = s.next();
        CopyFile m = new CopyFile();
        m.copy(fileToCopy, destination);
    }

    public void copy(String filename, String destination) {
        String data = readData(filename);

        writeData(destination, data, filename);
    }

    public String readData(String filename) {
        FileInputStream fis = null;
        String data = "";
        String data2 = "";
        try {
            //open
            fis = new FileInputStream(filename);
            // read
            int c;
            while ((c = fis.read()) != -1) {
                if (c == 97) {
                    c = 100;
                } else 
                if (c == 98) {
                    c = 101;
                } else
                if (c == 99) {
                    c = 102;
                } 
                data += (char)c;
                data2 = data+"\n";
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return data2;
    }

    public void writeData(String destination, String data, String filename) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(destination + "\\" + filename);
            fos.write((data+"\n").getBytes());
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
