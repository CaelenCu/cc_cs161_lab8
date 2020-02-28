package main.java.classes;
import java.util.Date;
public class Employee extends Person{
    //members
    private String jobTitle;
    private Date hireDate;

    //constructor
    public Employee(int i, String fn, String ln,  Date d, String jt){
        setId(i);
        setFirstName(fn);
        setLastName(ln);
        setHireDate(d);
        setJobTitle(jt);
        

    }
    //methods

    //setters
    public void setJobTitle(String arg){
        jobTitle = arg;
    }
    public void setHireDate(Date arg){
        hireDate = arg;
    }

    //getters
    public String getJobTitle(){
        return jobTitle;
    }
    public Date getHireDate(){
        return hireDate;
    }
}