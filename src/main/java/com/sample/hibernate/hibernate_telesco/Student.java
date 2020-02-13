package com.sample.hibernate.hibernate_telesco;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	
	@Id
	private int rollNum;
	private String name;
	private int marks;
	
	@ManyToMany(mappedBy="stud")
	private List<Laptop> lap=new ArrayList<Laptop>();
	
	public List<Laptop> getLap() {
		return lap;
	}
	
	public void setLap(List<Laptop> lap) {
		this.lap = lap;
	}
	/*	@OneToOne
	private Laptop lap;
	
	public Laptop getLap() {
		return lap;
	}
	public void setLap(Laptop lap) {
		this.lap = lap;
	}*/
	public int getRollNum() {
		return rollNum;
	}
	public void setRollNum(int rollNum) {
		this.rollNum = rollNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}

}
