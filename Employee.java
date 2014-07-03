//----------------------------------------------------------------------------------
//Author:      Jason McMullen and Adam Reese
//Due Date:    12/9/13
//
//Program:     Employee
//Description: This class holds all the variables for employee; ID, first and last
//             name, and salary. Objects of this clas will hold those values until
//             called upon. The only value that can be changed after an employee
//             has been created is the salary, which is done with a set method.
//             Finally, Employee contains a compareTo method that compares Employees
//             based on their ID number. An integer will be returned describing
//             the relation between the two employee's ID numbers.
//----------------------------------------------------------------------------------

//needed for DecimalFormat
import java.text.*;

public class Employee implements Comparable
{

   //variable to hold the employee's id
   private int acctID;
   
   //variable to hold the employee's first name
   private String firstName;
   
   //variable to hold the employee's last name
   private String lastName;
   
   //variable to hold the employee's salary
   private double salary;
   
   //will be used to format the salary to be more familiar with US currency
   DecimalFormat pattern = new DecimalFormat("$0.00");
   
   
   /**
   * The non-default constructor of Employee. This method recieves all the
   * information that Employee will store when the object is created.
   */
   public Employee(int id, String lastName, String firstName, double amount)
   {
   
      acctID = id;
      this.lastName = lastName;
      this.firstName = firstName;
      salary = amount;
   
   }//end non-default constructor
   
   
   /**
   * getId returns the integer that reperesents the employee's ID
   */
   public int getId()
   {
   
      return acctID;
   
   }//end getId method
   
   
   /**
   * This method returns the employee's last name
   */
   public String getLastName()
   {
   
      return lastName;
   
   }//end getLastName method
   
   
   /**
   * This method returns the employee's first name
   */
   public String getFirstName()
   {
   
      return firstName;
   
   }//end getFirstName method
   
   
   /**
   * getSalary returns the employee's salary
   */
   public double getSalary()
   {
   
      return salary;
   
   }//end getSalary method
   
   
   /**
   * setSalary changes the employee's salary
   */
   public void setSalary(double amount)
   {
   
      salary = amount;
   
   }//end setSalary method
   
   
   /**
   * toString prints out all of the details of the employee. The format of the
   * string is a block/paragraph format:
   *
   * ID Number    First Name     Last Name      Salary
   */
   public String toString()
   {

      String string = String.format("%1$-10s %2$-10s %3$-12s %4$10s", acctID, 
                                    firstName, lastName, pattern.format(salary));      
      
      return string;
   
   }//end toString method
   
   
   /**
   * This method compares the values of two employee ID numbers, it will return an
   * integer indicating how they relate to each other. -1 if <, 1 if >, 0 if =.
   * This method requires an Object of type Employee to work correctly. If it does
   * not recieve an object of this type it will throw an error. If it is of the
   * corret type then it will return an integer.
   */
   public int compareTo(Object obj)
   {
            
      //makes sure the object is an instance of class Employee
      if(obj instanceof Employee)
      {
      
         //cast the object to type Employee
         Employee emp = (Employee)obj;
      
         int answer = 5;
               
         if(acctID > emp.getId())
         {
         
            answer = 1;
         
         }//end if statement
         else if(acctID < emp.getId())
         {
         
            answer = -1;
         
         }//end if statement
         else if(acctID == emp.getId())
         {
         
            answer = 0;
         
         }//end if statement
         
         return answer;
      
      }//end if statement
      
      //not an instance of class Employee, send error back to calling method
      else
      {
      
         throw new IllegalStateException("Not an object of Employee.");
      
      }//end else statement
   
   }//end compareTo method

}//end Employee class
