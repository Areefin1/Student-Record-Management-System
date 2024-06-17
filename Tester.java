import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileOutputStream;

public class Tester 
{
    public static Scanner scnr = new Scanner(System.in);



    public static void deleteStudent(StudentRecord STUDENTLIST, SortedLinkedList list) throws Exception
    {
        list.deleteSorted(STUDENTLIST);        
    }

    public static StudentRecord searchByID(SortedLinkedList STUDENTLIST) throws Exception 
    {
        String ID;
        System.out.println("Enter ID#: ");
        ID = scnr.next();

        StudentRecord studentToFind = STUDENTLIST.searchSortedByID(ID);
        return studentToFind;
    }

    public static StudentRecord searchByLastName(SortedLinkedList STUDENTLIST) throws Exception
    {
        String name;
        System.out.println("Enter last name: ");
        name = scnr.next();

        StudentRecord studentToFind = STUDENTLIST.searchSortedLastName(name);
        return studentToFind;
    }

    public static StudentRecord searchByFirstName(SortedLinkedList STUDENTLIST) throws Exception
    {
        String name;
        System.out.println("Enter first name: ");
        name = scnr.next();

        StudentRecord studentToFind = STUDENTLIST.searchSortedFirstName(name);
        return studentToFind;

    }

    public static StudentRecord searchByName(SortedLinkedList STUDENTLIST) throws Exception
    {
        String fname, lname;
        System.out.println("Enter first and last name: ");
        fname = scnr.next();
        lname = scnr.next();

        StudentRecord studentToFind = STUDENTLIST.searchSorted(new StudentRecord(fname, lname));
        return studentToFind;
    }

    public static void printFormatWithGPA()
    {
        System.out.printf("------------------------------------------------------%n");
        System.out.printf("                Current Student List                  %n");
        System.out.printf("------------------------------------------------------%n");
        System.out.printf("| %-10s | %-8s | %-4s |  %-3s  | %-2s |%n", "First Name", "Last Name", "Student ID", "GPA", "Cred");
        System.out.printf("------------------------------------------------------%n");
    }

    public static void printMainMenu()
    {
        System.out.printf("---------------------------------------%n");
        System.out.printf("               Main Menu:              %n");
        System.out.printf("        What would you like to do?     %n");
        System.out.printf("---------------------------------------%n");

        System.out.printf(" [SLOW] Search by Full name? press [1] %n");
        System.out.printf(" [SLOW] Search by Last name? press [2] %n");
        System.out.printf(" [SLOW] Search by First name? press [3]%n");
        System.out.printf(" [SLOW] Search by ID? press [4]        %n");
        System.out.printf(" Add new course? press [5]             %n");
        System.out.printf(" Add student? press [6]                %n");
        System.out.printf(" Delete existing student? press [7]    %n");
        System.out.printf(" [FAST!] Search by ID: press [8]       %n");
        System.out.printf(" Display currentlist info: press [9]   %n");
        System.out.printf(" Save file: press [10]                 %n");

    }

    public static void main(String[] args) throws Exception
    {   FileOutputStream fileStream = null;
        PrintWriter outFS = null;
        StudentRecord student1 = new StudentRecord(); 
        StudentRecord[] hash = new StudentRecord[100];
        SortedLinkedList list = new SortedLinkedList();
        FileInputStream fileByteStream = null;
        Scanner inFS = null; 
        String firstName, lastName, studentID;
        int choice, credits, newcredits;
        double gpa, newgpa;

        System.out.println();
        System.out.println();

        System.out.println("Enter a file to open: ");
        System.out.println();
        String fileName = scnr.next();
        System.out.println("Opening file...");
        System.out.println();
        fileByteStream = new FileInputStream(fileName);
        inFS = new Scanner(fileByteStream);


        while(inFS.hasNext())
        {
            firstName = inFS.next();
            lastName = inFS.next();
            studentID = inFS.next();
            gpa = inFS.nextDouble();
            credits = inFS.nextInt();

            student1 = new StudentRecord(firstName, lastName, studentID, gpa, credits);
            list.insertSorted(student1);

            int i = Integer.parseInt(studentID);
            i = i % 100;
            hash[i] = student1;
        }

        System.out.println("File opened sucessfully!");
        System.out.println();

        printMainMenu();

        System.out.println();
        System.out.println("Please choose options above otherwise press[0]");
        System.out.println();
        choice = scnr.nextInt();

        while(choice != 0)
        {
                
            switch(choice)
            {
            
                case 1:
                    try
                    {
                        System.out.println("Searching for a student by full name: ");
                        student1 = searchByName(list);
                        System.out.println();
                        printFormatWithGPA();
                        System.out.print(student1.toString());
                        System.out.printf("------------------------------------------------------%n");
                    }
                    catch(Exception excpt){System.out.println("Either Student NOT found or Mistyped!");} 
                    break;
                    
                case 2:
                    try
                    {
                        System.out.println("Searching for student by last name: ");
                        student1 = searchByLastName(list);
                        System.out.println();
                        printFormatWithGPA();
                        System.out.print(student1.toString());
                        System.out.printf("------------------------------------------------------%n");

                    }
                    catch(Exception excpt){System.out.println("Either Student NOT found or Mistyped!");} 
                    break;
                    
                case 3:
                    try
                    {
                        System.out.println("Searching for student by first name: ");
                        student1 = searchByFirstName(list);
                        System.out.println();
                        printFormatWithGPA();
                        System.out.print(student1.toString());
                        System.out.printf("------------------------------------------------------%n");
                    }
                    catch(Exception excpt){System.out.println("Either Student NOT found or Mistyped!");}
                    break;

                case 4:
                    try
                    {
                        System.out.println("Searching for a student by ID: ");
                        student1 = searchByID(list);
                        System.out.println();
                        printFormatWithGPA();
                        System.out.print(student1.toString());
                        System.out.printf("------------------------------------------------------%n");
                    }
                    catch(Exception excpt){System.out.println("Either Student NOT found or Mistyped!");}
                    break;
                    
                case 5:
                    try
                    {
                        System.out.println("Adding new course");
                        System.out.println("But before we add your new course, please enter your student ID: ");
                        student1 = searchByID(list);
                        System.out.println("Now enter your new grade and credits: ");
                        newgpa = scnr.nextDouble();
                        newcredits = scnr.nextInt();
                        student1.calcGPA(newgpa, newcredits);
                        System.out.println("Your grade has been updated!");
                        System.out.println();
                        printFormatWithGPA();
                        System.out.print(student1.toString());
                        System.out.printf("------------------------------------------------------%n");

                    } 
                    catch(Exception excpt){System.out.println("Either Student NOT found or Mistyped!");}
                    break; 

                case 6: 
                    try
                    {
                        System.out.println("Adding new Student: ");
                        System.out.println("please enter first name, last name, student ID, current gpa and current total credits: ");
                        firstName = scnr.next();
                        lastName = scnr.next();
                        studentID = scnr.next();
                        gpa = scnr.nextDouble();
                        credits = scnr.nextInt();
                        student1 = new StudentRecord(firstName, lastName, studentID, gpa, credits);
                        list.insertSorted(student1);
                        System.out.print("Added new Student!");
                    }
                    catch(Exception excpt){System.out.println("BAD Input!");}
                    break;

                case 7:
                    try
                    {
                        System.out.println("Deleting Student: ");
                        System.out.println("For security reasons, please enter FULL name and student ID: ");
                        firstName = scnr.next();
                        lastName = scnr.next();
                        studentID = scnr.next();
                        student1 = new StudentRecord(firstName, lastName, studentID);
                        deleteStudent(student1, list);
                        System.out.println("Student deleted!");

                    }
                    catch(Exception excpt){System.out.println("Either Student NOT found or Mistyped!");}
                    break;

                case 8: 
                    try
                    {
                        System.out.println("Quick search ID via hash table: ");
                        System.out.println("Please enter student ID: ");
                        studentID = scnr.next();
                        int i = Integer.parseInt(studentID);
                        i = i % 100;
                        System.out.println();
                        printFormatWithGPA();
                        System.out.print(hash[i].toString());
                        System.out.printf("------------------------------------------------------%n");
                    }
                    catch(Exception excpt){System.out.println("Either Student NOT found or Mistyped ID!");}
                    break;

                case 9:
                    System.out.println();
                    printFormatWithGPA();
                    System.out.print(list.toString());
                    System.out.printf("------------------------------------------------------%n");
                    System.out.println();
                    break;

                case 10:
                    System.out.println("File Saved!");
                    fileStream = new FileOutputStream("D:\\Documents\\212project\\student.txt");
                    outFS = new PrintWriter(fileStream);
                    outFS.println(list.printStudent());
                    outFS.close();
                    break;

                default:
                    System.out.println("Sorry, this option is not available. Please try other options: ");
                    printMainMenu();
                    choice = scnr.nextInt();
                    break;

            }
        try
        {
            System.out.println();
            printMainMenu();
            System.out.println();
            System.out.println("If you wish to discontinue, press[0] ");
            System.out.println("continue? ");
            choice = scnr.nextInt();
        }
        catch(Exception excpt){System.out.println("BAD Input! Please Choose options 1-10 or 0 to EXIT!");}

    }

    System.out.println("Closing file student.txt");

    inFS.close();
        
    fileByteStream.close();

        
    }
    
}
