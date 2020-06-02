package com.models;

public class Teacher {
	private int id;
    private String firstName;
    private String lastName;
    private String personalID;
    private Gender gender;
    private Department department;
    
    public Teacher(String firstName, String lastName, String personalID, Gender gender, Department department) {
    	this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPersonalID(personalID);
        this.setGender(gender);
        this.setCity(department);
    }
    
    public Integer getID() {
    	return this.id;
    }
    
    public void setID(int id) {    	
    	if (id <= 0) {
    		throw new IndexOutOfBoundsException("ID cannot be zero or negative!");
    	}
    	
    	this.id = id;
    }
    
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
    	if (firstName.isEmpty() || firstName == null) {
    		throw new NullPointerException("First name cannot be null or empty!");
    	}
    	
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
    	if (lastName.isEmpty() || lastName == null) {
    		throw new NullPointerException("Last name cannot be null or empty!");
    	}
    	
        this.lastName = lastName;
    }
    
    public String getPersonalID() {
    	return this.personalID;
    }
    
    public void setPersonalID(String personalID) {
    	if (personalID.isEmpty() || personalID == null) {
    		throw new NullPointerException("Personal ID cannot be null or empty!");
    	}
    	
    	this.personalID = personalID;
    }
    
    public Gender getGender() {
    	return this.gender;
    }
    
    public void setGender(Gender gender) {
    	if (gender == null || gender == Gender.NotSelected) {
    		throw new NullPointerException("Gender cannot be null or not selected!");
    	}
    	 
    	this.gender = gender;
    }
    
    public Department getCity() {
    	return this.department;
    }
    
    public void setCity(Department department) {
    	if (department == null || department == Department.NotSelected) {
    		throw new NullPointerException("City cannot be null or not selected!");
    	}
    	 
    	this.department = department;
    }
    
    @Override
    public String toString() { 
        return this.firstName + " " + this.lastName + " " + this.personalID + " " + this.gender + " " + this.department;
    }
}
