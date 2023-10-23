import java.util.Scanner;

public class App {
    public static void main(String[] args){
       String exitConfirm="y";
       Scanner scan=new Scanner(System.in);
       Student_Management obj= new  Student_Management();
       int choice;
       String roll;
       while(exitConfirm !="n"){
        System.out.println("Welcome to Student Management System Console");
       System.out.println("Press 1 to Add student record to the file");
       System.out.println("Press 2 to edit a student record");
       System.out.println("Press 3 to view all the records of the file");
        choice=scan.nextInt();
        scan.nextLine();
        if(choice==1){
            obj.addStudent();
        }
        else if(choice==2) {
            System.out.println("Enter the roll number whose record is to be modified");
            roll=scan.nextLine();
            obj.editStudent(roll);
        }
        else
        {
            obj.display_all_students();
        }
        System.out.println("DO you want to continue (press y for yes and n for no)");
        exitConfirm=scan.nextLine();
       }
       scan.close();
        
    }

}
