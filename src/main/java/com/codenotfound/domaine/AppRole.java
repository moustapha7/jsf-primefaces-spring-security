package com.codenotfound.domaine;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class AppRole  implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
private Integer id;
private String role;

public AppRole() {
	super();
}


public Integer getId() {
	return id;
}


public void setId(Integer id) {
	this.id = id;
}


public String getRole() {
	return role;
}


public void setRole(String role) {
	this.role = role;
}


@Override
public String toString() {
	// TODO Auto-generated method stub
	return id+"-"+role;
}


}
