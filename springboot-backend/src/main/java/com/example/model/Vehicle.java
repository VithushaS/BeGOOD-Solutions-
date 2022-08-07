package com.example.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle")

public class Vehicle {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
      private long id;
	  
	  @Column(name = "full_name" )
      private String fullname;
	  @Column(name = "no_plate" )
      private String noplate;
	  @Column(name = "type_v" )
      private String type;
      
      public Vehicle() {
    	  
      }
      
	public Vehicle(String fullname, String noplate, String type) {
		super();
		this.fullname = fullname;
		this.noplate = noplate;
		this.type = type;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFullName() {
		return fullname;
	}
	public void setFullName(String fullname) {
		this.fullname = fullname;
	}
	public String getNoplate() {
		return noplate;
	}
	public void setNoplate(String noplate) {
		this.noplate = noplate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
      
      
      
}
