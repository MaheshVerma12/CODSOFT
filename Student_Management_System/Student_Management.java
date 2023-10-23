import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.util.stream.Collectors;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class Student_Management extends Student {
    //Method to input the record of one student at a time in the Student_Database text file.
    Scanner scan = new Scanner(System.in);
    public void addStudent() {
        // Add a new student to the list
        System.out.println("Enter name of the student-");
        name = scan.nextLine();
        System.out.println("Enter Grade of student-");
        grade=scan.nextInt();
        scan.nextLine();
        System.out.println("Enter the address of student-");
        address= scan.nextLine();
        System.out.println("Enter the roll number of student-");
        rollNumber=scan.nextInt();
        try{BufferedWriter writer=new BufferedWriter(new FileWriter("Student_database.txt",true));
        writer.write(String.valueOf(rollNumber)+",");
        writer.write(name+",");
        writer.write(String.valueOf(grade)+",");
        writer.write(address);
        writer.write("\n");
        writer.close();
    }
        catch(IOException e){
            e.printStackTrace();
        }
    return; }
    

    private static Scanner x;
    
    public void editStudent(String rollNum) {
        // Method to edit a student record by roll number    
        Scanner scan=new Scanner(System.in);
        String tempRoll,tempName, tempGrade,tempAddress;
        System.out.println("Enter the new Roll No");
        int newRoll=scan.nextInt();
        scan.nextLine();
        System.out.println("Enter new Name -");
        String newName=scan.nextLine();
        System.out.println("Enter new grade ");
        int newGrade=scan.nextInt();
        scan.nextLine();
        System.out.println("Enter new address");
        String newAddress=scan.nextLine();
        String tempFile ="temp.txt";
        File oldFile=new File("Student_Database.txt");
        File newFile=new File(tempFile);
        String filepath="Student_database.txt";
        try{
            FileWriter fw=new FileWriter(tempFile,true);
            BufferedWriter bw=new BufferedWriter(fw);
            PrintWriter pw =new PrintWriter(bw);
            x=new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");
            while(x.hasNext()){
                tempRoll=x.next();
                tempName=x.next();
                tempGrade=x.next();
                tempAddress=x.next();
                if(tempRoll.equals(rollNum)){
                    pw.println(newRoll+","+newName+","+newGrade+","+newAddress+"\n");
                }
                else{
                    pw.println(tempRoll+","+tempName+","+tempGrade+","+tempAddress+"\n");
                }
            }
           x.close();
           pw.flush();
           pw.close();
           oldFile.delete();
           File dump =new File(filepath);
           newFile.renameTo(dump);
        }
        catch(Exception e){
            System.out.println("Error Occured!");
        }
        return;
    }

    
    
    
    
    
    public void display_all_students(){
try{    // Method to display all records in a file.
        BufferedReader reader=new BufferedReader(new FileReader("Student_Database.txt"));
        String line;
        while((line=reader.readLine())!=null)
        {
            System.out.println(line);
        }
        reader.close();
    }
catch(IOException e)
{
    e.printStackTrace();
}
return;
}
    
}
