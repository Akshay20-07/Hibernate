package com.sample.hibernate.hibernate_telesco;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Alien_Table")
public class Alien {

	@Id
	private int aId;
	
	private AlienName alienName;
	@Column(name="Alien_Color")
	private String color;

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
