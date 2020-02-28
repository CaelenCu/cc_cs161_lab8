package main.java.classes;
abstract class Person{
//members
private int id;
private String firstName;
private String lastName;

//member methods

//Setters
public void setId(int i){
    id = i;
}
public void setFirstName(String arg){
    firstName = arg;
}
public void setLastName(String arg){
    lastName = arg;
}

//Getters
public int getId(){
    return id;
}
public String getFirstName(){
    return firstName;
}
public String getLastName(){
    return lastName;
}
}