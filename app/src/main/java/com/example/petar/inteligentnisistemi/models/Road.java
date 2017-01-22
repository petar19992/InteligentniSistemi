package com.example.petar.inteligentnisistemi.models;

import java.io.Serializable;


public class Road implements Serializable{

	long id;
	String name;
	Node startNode;
	Node endNode;
	Integer weight;
	String directionType;
	
	public Road() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Road(long id) {
		super();
		this.id = id;
	}
	public Road(String name, Node startNode, Node endNode, Integer weight, String directionType) {
		super();
		this.name = name;
		this.startNode = startNode;
		this.endNode = endNode;
		this.weight = weight;
		this.directionType = directionType;
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
	public Node getStartNode() {
		return startNode;
	}
	public void setStartNode(Node startNode) {
		this.startNode = startNode;
	}
	public Node getEndNode() {
		return endNode;
	}
	public void setEndNode(Node endNode) {
		this.endNode = endNode;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public String getDirectionType() {
		return directionType;
	}
	public void setDirectionType(String directionType) {
		this.directionType = directionType;
	}
	
	@Override
	public String toString() {
		return "Road [id=" + id + ", name=" + name + ", startNode=" + startNode + ", endNode=" + endNode + ", weight="
				+ weight + ", directionType=" + directionType + "]";
	}
	
}
