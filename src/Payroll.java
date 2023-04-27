// ****************************************************************************
//   Warning.java
// 
//   Reads employee data from a binary file and writes data to a text file.
// ****************************************************************************

import java.util.*;
import java.io.*;

public class Payroll
{
    // --------------------------------------------------------------------
    //   Reads employee data from a binary file of HourlyEmployee data,
    //   computes the weekly pay, then writes data to another file.
    // -------------------------------------------------------------------- 
    public static void main (String[] args)
    {
	HourlyEmployee emp;		
	double weeklyPay;            

	String inputName = "hourly.dat";
	String outputName = "payroll.txt";

	try (  
	    // Set up ObjecInputStream to input file
		ObjectInputStream inFile = new ObjectInputStream(new FileInputStream(inputName));
		// Set up the output file stream)
		PrintWriter outFile = new PrintWriter(new File (outputName));
		)
	    {
		
		// Print a header to the output file
		outFile.println ();
		outFile.println ("Weekly Payroll");
		outFile.println ();
		
		
		// Process the input file, one token at a time
		try
            {
                while (true)
				{
				// Read each HourlyEmployee object from the file
                	emp = (HourlyEmployee) inFile.readObject();
				// Calculate the weekly pay
                	weeklyPay = emp.getPay();
				// Write the employee's name and weekly pay to the output file
                	outFile.println("Employee's name: " + emp.getName() + " and Weekly Pay is: $" + weeklyPay);
				}
		    } 
		    //Add a catch for  EOFException
			catch (ClassNotFoundException ex) {
				System.out.println("Class not found");
			}
			catch (EOFException ex) {
				System.out.println("No more data in hourly.dat");
			}
		inFile.close();
		outFile.close();
	    }
	
		
	//Add a catch for each of the specified exceptions, and in each case 
	//give as specific a message as you can
	catch(FileNotFoundException ex) {
		System.out.println("File not found");
	}
	catch(IOException ex) {
		System.out.println("IOException");
	}
	
	//Close the output file in a finally block
	/*
	finally {
		outFile.close();
		inFile.close();
	}
	*/
    }
}
