//----------------------------------------------------------------------------------
//Author:      Jason McMullen and Adam Reese
//Due Date:    12/9/13
//
//Program:     Company
//Description: This program will require input from the user to run. The user will
//             be presented with a menu which the user must select an option for
//             the program to continue. The options include: 1.) Read from a file
//             and store employees in a binary tree, 2.) Add an employee to the
//             tree, 3.) Remove an employee from the tree, 4.) Retrieve an
//             employee, 5.) Update an employee, 6.) Display the firm's employees
//             in ascending order based on the employee ID, 7.) Quit. 
//----------------------------------------------------------------------------------

import java.util.*;
import java.io.*;

public class Company
{
   
   //the tree that will hold all of the employees
   private TreeBag empTree;
   
   //header for print
   private final String RECORD_STRING = String.format("%1$-10s %2$-10s %3$-12s %4$10s",
                                 "Id", "First Name", "Last Name", "Weekly Salary") + 
                                 "\n------------------------------------------------"; 


   /**
   * The menu method presents the user with a menu that they may select various 
   * options from. Each option will call a different method and execute the 
   * commands. The options are: 1.) Read from a file and store employees in a 
   * binary tree, 2.) Add an employee to the tree, 3.) Remove an employee from the
   * tree, 4.) Retrieve an employee, 5.) Update an employee, 6.) Display the firm's
   * employees in ascending order based on the employee ID, 7.) Quit.
   */
   public void menu(String st, PrintWriter pw)throws IOException
   {
      
      //showMenuList();
      
      StringTokenizer token = new StringTokenizer(st," -\t");
      int choice = Integer.parseInt(token.nextToken());
      
      int empID;
      String firstName, lastName;
      double salary;
      Employee employee;

      
      switch(choice)
      {
      
         case 1:
         
            //Create the tree
            empTree = new TreeBag();
            
            //Create the FileReader and link it to the file specified
            FileReader fr = new FileReader("Employees.txt");
            BufferedReader inFile = new BufferedReader(fr);
            
            //Get the first line of the file
            String line = inFile.readLine();
            
            //Create a StringTokenizer from the line of the file 
            StringTokenizer emp = new StringTokenizer(line," \t");
               
            //Set the employee variables to the information from the file
            empID = Integer.parseInt(emp.nextToken());
            firstName = emp.nextToken();
            lastName = emp.nextToken();
            salary = Double.parseDouble(emp.nextToken());
               
            //Create the employee
            employee = new Employee(empID, lastName, firstName, salary);
               
            //Add the employee to the tree
            empTree.add(employee);
               
            //Get the next line from the file
            line = inFile.readLine();
            
            while(line != null)
            {  
               //Create a StringTokenizer from the line of the file 
               emp = new StringTokenizer(line," \t");
               
               //Set the employee variables to the information from the file
               empID = Integer.parseInt(emp.nextToken());
               firstName = emp.nextToken();
               lastName = emp.nextToken();
               salary = Double.parseDouble(emp.nextToken());
               
               //Create the employee
               employee = new Employee(empID, lastName, firstName, salary);
               
               //Add the employee to the tree
               empTree.add(employee);
               
               //Get the next line from the file
               line = inFile.readLine();
            
            }//end while loop
            
            //print the tree
            pw.println(RECORD_STRING);
            empTree.display(empTree.getRoot(), pw);
            
            break;
         
         //-------------------------------------------------------------------      
         case 2:
         
            //add employee
            
            //if the tree is not constructed, construct it
            if(empTree == null)
               empTree = new TreeBag();
            
            //Get the employee's information
            empID = Integer.parseInt(token.nextToken());
            firstName = token.nextToken();
            lastName = token.nextToken();
            salary = Double.parseDouble(token.nextToken());
            
            //Create the employee
            employee = new Employee(empID, lastName, firstName, salary);
            
            //Add the employee to the Tree
            empTree.add(employee);
            
            //print the updated tree
            pw.println(RECORD_STRING);
            empTree.display(empTree.getRoot(), pw);
            
            break;
            
         //-------------------------------------------------------------------
                  
         case 3:
         
            //remove an employee
            
            //Get the ID of the employee to be deleted
            empID = Integer.parseInt(token.nextToken());
            
            //Create the employee with place holders for the name and salary
            employee = new Employee(empID, " ", " ", 0);
            
            //Remove the employee
            boolean answer = empTree.remove(employee);
            if(answer == true)
               pw.println("The employee has been removed from the system.");
            else
               pw.println("The employee could not be found.");
               
            //print the updated tree
            pw.println(RECORD_STRING);
            empTree.display(empTree.getRoot(), pw);
            
            break;
            
         //-------------------------------------------------------------------
            
         case 4:
         
            //retrieve an employee
            
            //Get the ID of the employee to be retrieved
            empID = Integer.parseInt(token.nextToken());
            
            //Create the employee with place holers for the name and salary
            employee = new Employee(empID, " ", " ", 0);
            
            //Retrieve the employee
            employee = (Employee)empTree.retrieve(employee, empTree.getRoot()); 
            
            //Print the employee if the employee was found
            if(employee != null)
               pw.println(employee.toString());
            else
               pw.println("Employee Not Found");

            
            break;
            
         //-------------------------------------------------------------------
            
         case 5:
         
            //update an employee
            
            //Get ID and Salary
            empID = Integer.parseInt(token.nextToken());
            salary = Double.parseDouble(token.nextToken());
            
            //Create the employee with place holers for the name and salary
            employee = new Employee(empID, " ", " ", 0);
            
            //Retrieve the employee
            employee = (Employee)empTree.retrieve(employee, empTree.getRoot());
            
            //Update the employee
            employee.setSalary(salary);
            
            //Place the updated employee in the tree
            empTree.add(employee);
            
            //Print the new employees information
            pw.println(employee.toString());
            
            break;
            
         //-------------------------------------------------------------------
            
         case 6:
         
            //display the firm's employees in ascending order using ID
            pw.println(RECORD_STRING);
            empTree.display(empTree.getRoot(), pw);
            
            
            
            break;
            
         //-------------------------------------------------------------------
            
         case 7:
         
            //Quit
            System.exit(0);
            
         break;
      
      }//end switch
   
   }//end menu method
   
   /**
   * This method only prints to the screen the menu the user will read from to 
   * make a selection. Expects no incoming data nor returns anything.
   */
   public void showMenuList()
   {
   
      System.out.println("1.) Read from a file and store employees in a binary tree.");
      System.out.println("2.) Add an employee to the tree.");
      System.out.println("3.) Remove an employee from the tree.");
      System.out.println("4.) Retrieve an employee.");
      System.out.println("5.) Update an employee.");
      System.out.println("6.) Display the firm's employees.");
      System.out.println("7.) Quit.");
   
   }//end showMenuList method

}//end Company class
