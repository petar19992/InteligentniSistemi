package com.example.petar.inteligentnisistemi.models;


public class NodeType {
	long id;
	String name;
	public NodeType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NodeType(String name) {
		super();
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "NodeType [id=" + id + ", Name=" + name + "]";
	}
	
}
