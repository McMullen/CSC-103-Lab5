import java.util.*;
import java.io.*;

class TreeTest
{
  public static void main (String[] args)
  {
      try
      {
         FileWriter fileOut = new FileWriter("outEmployees.txt", true);
         PrintWriter pw = new PrintWriter(fileOut);
         Company company = new Company();
         pw.println ("create the tree from an input file Employee.txt");
         pw.println ("-----------------");
         company.menu("1 - Employee.txt", pw);
         pw.println ();
         pw.println ("----------------------------------------------------------------------------");
         pw.println ("add an employee to the tree");
         pw.println ("---------------------------------");
         company.menu("2 - 5290 George Truman 16110.68", pw);
         pw.println ();
         pw.println ("----------------------------------------------------------------------------");
         pw.println ("remove an employee from the tree");
         pw.println ("---------------------------------------");
         company.menu("3 - 4892", pw);
         pw.println ();
         pw.println ("----------------------------------------------------------------------------");
         pw.println ();
         pw.println ("retrieve an employee from the tree and print the employee record");
         pw.println ("-------------------------------------------------------------------------------");
         company.menu("4 - 3924", pw);
         pw.println ();
         pw.println ("----------------------------------------------------------------------------");
         pw.println ();
         pw.println ("update an employee from the tree and print the new ");
         pw.println ("---------------------------------------------------------------");
         company.menu("5 - 3924 20000.00", pw);
         pw.println ();
         pw.println ("----------------------------------------------------------------------------");
         pw.println ();
         pw.println ("display the tree ");
         pw.println ("--------------------");
         company.menu("6", pw);
         pw.println ("----------------------------------------------------------------------------");
         pw.println ();
         pw.println ();
         pw.close();
      }
      catch(IOException e)
      {
      
          System.out.println("That file does not exist");
        
      }//end catch
   }
}
