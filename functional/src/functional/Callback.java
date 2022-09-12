package functional;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Callback {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Employee Name: ");

        // name of the employee
        String Employee = sc.next();

        // Store the employee name in an object temp
        Class<?> temp = Class.forName("functional." + Employee);

        // Create the new object of the class whose name is in temp
        // Interface Salary's reference is now referencing the new object created above
        Salary reference = (Salary)temp.getDeclaredConstructor().newInstance();

        //Call the method to calculate net salary and pass interface reference - this is a callback.
        //Here reference refers to the function Person_Salary() of both Jack and Michelle's classes

        Calculate_Salary(reference);
        sc.close();
	}
	
	static void Calculate_Salary(Salary E_Salary){
        // calculate Salary Deduction Which is 10 percent
        double salary_deduction = E_Salary.Person_Salary() * 0.1;

        // The gross salary
        double gross_salary = E_Salary.Person_Salary();

        // Calculate the net salary
        double net_salary = gross_salary - salary_deduction;

        // Show the net salary
        System.out.println("The Net Salary of Employee is =" + net_salary);
    }
}


