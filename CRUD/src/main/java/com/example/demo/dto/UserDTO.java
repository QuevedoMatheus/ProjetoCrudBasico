package com.example.demo.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;



public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private String name;
	private String cpf;
	private Double income;
	private Instant brithDate;
	private Integer children;
	
	
	
	public UserDTO() {
		
	}

	public UserDTO(Long id, String name, String cpf, Double income, Instant brithDate, Integer children) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.income = income;
		this.brithDate = brithDate;
		this.children = children;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public Instant getBrithDate() {
		return brithDate;
	}

	public void setBrithDate(Instant brithDate) {
		this.brithDate = brithDate;
	}

	public Integer getChildren() {
		return children;
	}

	public void setChildren(Integer children) {
		this.children = children;
	}
	
	


}
