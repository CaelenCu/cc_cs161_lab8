package main.java.dam;

import java.util.ArrayList;
import main.java.classes.Employee;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DamEmployee extends SqlInterface{
//members
    
//methods
public ArrayList<Employee> getEmployees(String id){
    //instantiate employee list
    ArrayList<Employee> employees = new ArrayList<Employee>();
    //creates new string builder
    StringBuilder sb = new StringBuilder();
    //builds string
    sb.append("SELECT");
    sb.append(" P.BusinessEntityID,P.FirstName,P.LastName");
    sb.append(" ,E.HireDate,E.JobTitle");
    sb.append(" FROM");
    sb.append(" HumanResources.Employee AS E");
    sb.append(" JOIN Person.Person AS P");
    sb.append(" ON P.BusinessEntityID = E.BusinessEntityID");
    if(id != null){
        sb.append(" WHERE");
        sb.append(" E.BusinessEntityID=" + id);
    }
    //attempt data retrieval
    try(Connection con = getConnection(); Statement stmt = getStatement()){
        ResultSet rs = stmt.executeQuery(sb.toString());
        
        //check for all data fields in Employee
        while(rs.next()){
            Employee e = new Employee(
                rs.getInt("BusinessEntityID")
                ,rs.getString("FirstName") 
                ,rs.getString("LastName")
                ,getResultSetDate(rs, "HireDate")
                ,rs.getString("JobTitle")
                );
                //add employee to list
                employees.add(e);
        }
        //return the list of employees
        return employees;
    }
    catch(SQLException e){
        e.printStackTrace();
        return null;
    }
}
}