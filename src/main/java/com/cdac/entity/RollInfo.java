package com.cdac.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "tbl_rollinfo")
public class RollInfo {
	
	@Id
	@GeneratedValue
	private int rollId;
	private String rollDiscr;
	
	
	
	public int getRollId() {
		return rollId;
	}
	public void setRollId(int rollId) {
		this.rollId = rollId;
	}
	public String getRollDiscr() {
		return rollDiscr;
	}
	public void setRollDiscr(String rollDiscr) {
		this.rollDiscr = rollDiscr;
	}
	
	
}
