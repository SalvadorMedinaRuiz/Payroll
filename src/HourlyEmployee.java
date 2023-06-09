
/**
 Class Invariant: All objects have a name string, hire date, nonnegative 
 wage rate, and nonnegative number of hours worked. A name string of 
 "No name" indicates no real name specified yet. A hire date of Jan 1, 1000 
 indicates no real hire date specified yet.
*/
import java.io.Serializable;
public class HourlyEmployee implements Serializable 
{
    private String name;
	private double wageRate; 
    private double hours; //for the month
    private double weeklyPay;

    public HourlyEmployee( )
    {
    	name = "";
    	wageRate = 0;
        hours = 0;
        weeklyPay=0;
    }

    /**
     Precondition: Neither theName nor theDate is null; 
     theWageRate and theHours are nonnegative.
    */
    public HourlyEmployee(String theName, 
                       double theWageRate, double theHours)
    {
         name = theName;
         if ((theWageRate >= 0) && (theHours >= 0))
         {
             wageRate = theWageRate;
             hours = theHours;
         }
         else
         {
             System.out.println(
                       "Fatal Error: creating an illegal hourly employee.");
             System.exit(0);
         }
    }


    public double getRate( )
    {
        return wageRate;
    }

    public double getHours( )
    {
        return hours;
    }

    /**
     Returns the pay for the month.
    */
    public double getPay( )
    {
    	
    	weeklyPay = wageRate*hours;
    	
    	if(hours>40) {
    	hours= hours - 40;
    	weeklyPay= 1.5 * (wageRate*hours) + weeklyPay;
        
    	}
    	return weeklyPay;
    }

    /**
     Precondition: hoursWorked is nonnegative.
    */
    public void setHours(double hoursWorked)
    {
         if (hoursWorked >= 0)
             hours = hoursWorked;
         else
         {
             System.out.println("Fatal Error: Negative hours worked.");
             System.exit(0);
         }
     }

    /**
     Precondition: newWageRate is nonnegative.
    */
    public void setRate(double newWageRate)
    {
         if (newWageRate >= 0)
             wageRate = newWageRate;
         else
         {
             System.out.println("Fatal Error: Negative wage rate.");
             System.exit(0);
         }
    }

    public String toString( )
    {
        return ("Name: " + name +
                 "\n$" + wageRate + " per hour for " + hours + " hours");
    }
    
    public String getName() {
    	return name;
    }
 
    public boolean equals(HourlyEmployee other)
    {
       return (name.equals(other.name) 
                && wageRate == other.wageRate
                && hours == other.hours);
    }
}
