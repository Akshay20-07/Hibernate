package com.sample.hibernate.hibernate_cache;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="Alien_Table_Cache")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class AlienCache {

	@Id
	private int aId;
	
	private AlienNameCache alienName;
	@Column(name="Alien_Color")
	private String color;
	
/*	@ManyToMany(mappedBy="laptop",fetch=FetchType.EAGER)
	private List<Laptop> lap=new ArrayList<Laptop>();
	
	public List<Laptop> getLap() {
		return lap;
	}
	
	public void setLap(List<Laptop> lap) {
		this.lap = lap;
	}
*/
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public AlienNameCache getalienName() {
		return alienName;
	}
	public void setalienName(AlienNameCache alienName) {
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
