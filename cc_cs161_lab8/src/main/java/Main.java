//HEADER
//Program Name: Employee Data List
//Author: Caelen Curtiss
//Class: CS161 Winter 2020
//Date: 02/27/2020
//Description: Prints either selected employee or a complete list

package main.java;

//imports
import main.java.dam.Database;
import java.util.HashMap;
import java.util.ArrayList;
import main.java.dam.DamEmployee;
import main.java.classes.Employee;

class Main{
    public static void main(String[] args){
        //Store the connection parameters
        HashMap<String,String> params = new HashMap<String,String>();
        params.put("host", "192.154.227.17");
        params.put("instance", "CGCC");
        params.put("port", "1444");
        params.put("dbName", "AdventureWorks");
        params.put("integrated", "false");
        params.put("dbUser", "jdoe");
        params.put("dbPassword", "Password1234!");

        //init the database conenction
        Database.initDatabase(params);
        System.out.println(Database.getConnectionURL());
        ArrayList<Employee> employees = new DamEmployee().getEmployees("4");

        //prints Employeed information
        for(Employee e : employees){
            System.out.println(e.getFirstName() 
            + " " + e.getLastName()
            + ": " + e.getHireDate().toString());
        }
    }
}
/* FOOTER
Rob Walters: Wed Dec 05 00:00:00 PST 2007
*/
