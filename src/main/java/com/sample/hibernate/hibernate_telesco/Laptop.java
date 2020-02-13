package com.sample.hibernate.hibernate_telesco;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Laptop {
	
	@Id
	private int lapId;
	private String lapName;
	
	/*@ManyToOne
	private Student stud;*/
	
	@ManyToMany
	private List<Student> stud=new ArrayList<Student>();
	
	
	public List<Student> getStudent() {
		return stud;
	}
	public void setStudent(List<Student> stud) {
		this.stud = stud;
	}
	public int getLapId() {
		return lapId;
	}
	public void setLapId(int lapId) {
		this.lapId = lapId;
	}
	public String getLapName() {
		return lapName;
	}
	public void setLapName(String lapName) {
		this.lapName = lapName;
	}

}
