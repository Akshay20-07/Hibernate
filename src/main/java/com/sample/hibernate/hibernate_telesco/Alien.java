package com.sample.hibernate.hibernate_telesco;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Alien_Table")
public class Alien {

	@Id
	private int aId;
	
	private AlienName alienName;
	@Column(name="Alien_Color")
	private String color;
	
	@ManyToMany(mappedBy="laptop",fetch=FetchType.EAGER)
	private List<Laptop> lap=new ArrayList<Laptop>();
	
	public List<Laptop> getLap() {
		return lap;
	}
	
	public void setLap(List<Laptop> lap) {
		this.lap = lap;
	}

	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public AlienName getalienName() {
		return alienName;
	}
	public void setalienName(AlienName alienName) {
		this.alienName = alienName;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Alien [aId=" + aId + ", aName=" + alienName + ", color=" + color + "]";
	}
	
	
}
