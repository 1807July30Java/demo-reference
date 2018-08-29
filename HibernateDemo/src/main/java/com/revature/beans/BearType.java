package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BEAR_TYPE")
public class BearType {

	public BearType(String name) {
		super();
		this.name = name;
	}
	public BearType(int id,String name,String survivalProcedure) {
		super();
		this.survivalProcedure = survivalProcedure;
		this.id = id;
		this.name =name;
	}
	public BearType() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="typeSequence")
	@SequenceGenerator(allocationSize=25,name="typeSequence",sequenceName="SQ_BEAR_TYPE_PK")
	@Column(name="BEAR_TYPE_ID")
	private int id;
	@Column(name="BEAR_TYPE_NAME")
	private String name;
	@Column(name="SURVIVAL_PROC")
	private String survivalProcedure;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name =name;
	}
	@Override
	public String toString() {
		return "BearType [id=" + id + ",name=" +name + "]";
	}
	public String getSurvivalProcedure() {
		return survivalProcedure;
	}
	public void setSurvivalProcedure(String survivalProcedure) {
		this.survivalProcedure = survivalProcedure;
	}

	
}
