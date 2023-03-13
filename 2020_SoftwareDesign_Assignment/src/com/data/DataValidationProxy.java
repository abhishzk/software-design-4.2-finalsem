package com.data;

import java.util.List;

import com.clients.Message;
import com.contracts.IOperations;
import com.models.Teacher;

public class DataValidationProxy implements IOperations {
	private static final int PERSONAL_ID_LENGTH = 10;
	private static final String VALID_PERSONAL_ID_PATTERN = "[0-9]+";
	
	private IOperations teacherAdapter;
	
	public DataValidationProxy(IOperations teacherAdapter) {
		this.teacherAdapter = teacherAdapter;
	}
	
	@Override
	public void addTeacher(Teacher teacher) {
		if (this.isTeacherValid(teacher) && !this.isPersonalIDAlreadyExist(teacher.getPersonalID())) {
			this.teacherAdapter.addTeacher(teacher);
			Message.displaySuccessMessage("Saved!");
		}
	}
	
	@Override
	public List<Teacher> getAllTeachers() {
		return this.teacherAdapter.getAllTeachers();
	}
	
	@Override
	public Teacher getTeacher(int id) {
		if (this.isIDInRange(id)) {
			Teacher teacher = this.teacherAdapter.getTeacher(id);
			
			if (teacher != null) {
				return teacher;
			}
		}
		
		Message.displayWarningMessage("Could not find teacher with ID " + id);
		return null;
	}
	
	@Override
	public boolean updateTeacher(int id, Teacher teacher) {
		if (this.isIDInRange(id) && this.isTeacherValid(teacher) && this.getTeacher(id) != null) {
			
			if (this.teacherAdapter.updateTeacher(id, teacher)) {
				Message.displaySuccessMessage("Teacher updated!");
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public boolean deleteTeacher(int id) {
		if (this.isIDInRange(id) && this.getTeacher(id) != null) {
			
			if (this.teacherAdapter.deleteTeacher(id)) {
				Message.displaySuccessMessage("Teacher deleted!");
				return true;
			}
		}

		return false;
	}
	
	private boolean isTeacherValid(Teacher teacher) {
		if (teacher == null) {
			Message.displayWarningMessage("Teacher cannot be null!");
			return false;
		}
		else if (!teacher.getPersonalID().matches(VALID_PERSONAL_ID_PATTERN)) {
			Message.displayWarningMessage("Phone Number must contains only digits!");
			return false;
		}
		else if (teacher.getPersonalID().length() != PERSONAL_ID_LENGTH) {
			Message.displayWarningMessage("Phone Number must contains exactly 10 digits!");
			return false;
		}	
		
		return true;
	}

	private boolean isIDInRange(int id) {
		if (id > 0) {
			return true;
		}
		
		Message.displayWarningMessage("ID cannot be negative or zero!");
		return false;
	}
	
	
	private boolean isPersonalIDAlreadyExist(String personalID) {
		for (Teacher teacher : this.teacherAdapter.getAllTeachers()) {
			if (teacher.getPersonalID().equals(personalID)) {
				Message.displayWarningMessage("Phone Number already exists. It must be unique!");
				return true;
			}
		}
		
		return false;
	}
}
