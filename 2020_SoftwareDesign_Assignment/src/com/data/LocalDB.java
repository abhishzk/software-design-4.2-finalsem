package com.data;

import java.util.ArrayList;
import java.util.List;

import com.models.Department;
import com.models.Gender;
import com.models.Teacher;


public final class LocalDB {
	private static final Teacher[] DEFAULT_TEACHERS = {
		new Teacher("John", "Maron", "9874561230", Gender.Male, Department.Other),
		new Teacher("Alex", "Mahone", "9874561250", Gender.Male, Department.Art),
		new Teacher("Naevia", "DeCosta", "9632587410", Gender.Female, Department.Pharmaceutical),
		new Teacher("Maxwell", "Russell", "9563214720", Gender.Male, Department.Business),
		new Teacher("Julie", "Khan", "9556454555", Gender.Female, Department.Nursing),
		new Teacher("James", "David", "8089784651", Gender.Male, Department.Engineering)
	};
	
	private static LocalDB instance;
	private static int teacherID = 0;
	private List<Teacher> teachersTable;
	
	private LocalDB() {	
		this.teachersTable = new ArrayList<Teacher>();
		this.fillTeacherTableWithDefaultData();
	}
	
	public static LocalDB getInstance() { 
		if (instance == null) {
			instance = new LocalDB();
		}
		
		return instance;
	}
	
	/**
	 * Add new teacher into teachers table.
	 * @param entity - the new teacher to add.
	 */
	public void create(Object entity) {
		if (this.isEntityInstaneOfTeacher(entity)) {
			Teacher newTeacher = (Teacher)entity;
			newTeacher.setID(++teacherID);
			this.teachersTable.add(newTeacher);
		}
		else {
			throw new IllegalArgumentException("Invalid type of entity!");
		}
	}
	
	/**
	 * Returns the teachers table.
	 */
	public List<Teacher> read() {
		return this.teachersTable;
	};	
	
	/**
	 * Updates the concrete teacher.
	 * @param id - the id of the concrete teacher to update.
	 * @param entity - the concrete teacher to update.
	 * @return - true if the update is successful, false if not
	 */
	public boolean update(int id, Object entity) {
		Teacher entityTeacher = (Teacher)entity;
		
		for (Teacher teacherToUpdate : this.teachersTable) {
			if (teacherToUpdate.getID() == id) {
				
				teacherToUpdate.setFirstName(entityTeacher.getFirstName());
				teacherToUpdate.setLastName(entityTeacher.getLastName());
				teacherToUpdate.setPersonalID(entityTeacher.getPersonalID());
				teacherToUpdate.setGender(entityTeacher.getGender());
				teacherToUpdate.setCity(entityTeacher.getCity());
				
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Deletes the concrete teacher.
	 * @param entity - the teacher to delete.
	 * @return true if the teachers table does not contain the 
	 * deleted teacher, false if does 
	 */
	public boolean delete(Object entity) {
		Teacher teacherToDelete = (Teacher)entity;
		this.teachersTable.remove(teacherToDelete);
		return !this.teachersTable.contains(teacherToDelete);
	}
	
	/**
	 * Fills teachers table with default data.
	 */
	private void fillTeacherTableWithDefaultData() {
		for (Teacher teacher : DEFAULT_TEACHERS) {
			teacher.setID(++teacherID);
			this.teachersTable.add(teacher);
		}
	}
	
	/**
	 * Checks if the given entity is instance of the Teacher class.
	 * @param entity - the concrete teacher to check.
	 * @return true if the given entity is from the Teacher class, false if not
	 */
	private boolean isEntityInstaneOfTeacher(Object entity) {
		return (entity instanceof Teacher);
	}
}