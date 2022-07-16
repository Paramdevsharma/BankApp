package coe528.project;

import java.io.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.*;

import static java.lang.System.out;


public class Recordclass {

    // Name of the associated file
    private String filename;
    public Recordclass(String n) {
        filename = n;

    }
    private static Recordclass instance;
    // Effects: Reads and prints the contents of the associated
    // file to the standard output.

    public String read() {
        try {
            FileInputStream fis = new FileInputStream(filename);
            Scanner sc = new Scanner(fis);
            //while(sc.hasNextLine()){

                return sc.nextLine();
            //}
            // Write the code here
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }
    public String userNameArray [] = new String[10000];
    int userNameCount;
    public String readamount() {
        try {
            FileInputStream fis = new FileInputStream(filename);
            Scanner sc = new Scanner(fis);
            //while(sc.hasNextLine()){
            sc.nextLine();
            return sc.nextLine();
            //}
            // Write the code here
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }

    public String readanum() {
        try {
            FileInputStream fis = new FileInputStream(filename);
            Scanner sc = new Scanner(fis);
            //while(sc.hasNextLine()){
            sc.nextLine();
            sc.nextLine();
            return sc.nextLine();
            //}
            // Write the code here
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }
    // Effects: Appends the specified message, msg, to the
    // associated file.
    public void write(String msg) {
        try {
            FileWriter data = new FileWriter(filename, true);
            PrintWriter pw = new PrintWriter(data);
            pw.println(msg);
            pw.close();
// Write the code here
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static Recordclass getInstance(){
        if (instance == null) {
            instance = new Recordclass("record.txt");
            return instance;
        }
        else
            return null;
    }
    public void check() {
        try {

            int k =0;
            FileInputStream fis = new FileInputStream(filename);
            System.out.print(fis);
            Scanner sc = new Scanner(fis);
            while(sc.hasNextLine()){
                String pad = sc.nextLine();
                userNameArray[k] = (pad);
                userNameCount++;
                k++ ;
            }
            sc.close();
// Write the code here
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    String s;
  public void cleared() throws IOException {
      FileWriter data = new FileWriter(filename);
      PrintWriter pw = new PrintWriter(data);
      pw.print("");
      pw.close();

  }
  public void deletefile(){
      try
      {
          Files.deleteIfExists(Paths.get(filename));
      }
      catch(IOException e)
      {
          System.out.println("No such file/directory exists");
      }
  }

    public static void main(String[] args) {


// Fill the blank below that obtains the sole instance
        // of the Record class.
        // (You should not invoke the Record constructor here.)
        Recordclass r = Recordclass.getInstance();
// Do not modify the code below
        r.write("Hello-1\n");
        r.write("Hello-2\n");
        System.out.println("Currently the file record.txt " +
                "contains the following lines:");
        r.read();
    }
}
