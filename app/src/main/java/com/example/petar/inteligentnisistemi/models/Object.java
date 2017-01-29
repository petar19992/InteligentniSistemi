package com.example.petar.inteligentnisistemi.models;

import java.io.Serializable;

public class Object implements Serializable{


	private static final long serialVersionUID = 3681419487480460951L;

	long id;
	String name;
	long node1Id;
	long node2Id;
	float distanceFromNode1;
	float distanceFromNode2;

	public Object() {
		super();
		// TODO Auto-generated constructor stub
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
	public float  getDistanceFromNode1() {
		return distanceFromNode1;
	}
	public void setDistanceFromNode1(float  distanceFromNode1) {
		this.distanceFromNode1 = distanceFromNode1;
	}
	public float  getDistanceFromNode2() {
		return distanceFromNode2;
	}
	public void setDistanceFromNode2(float  distanceFromNode2) {
		this.distanceFromNode2 = distanceFromNode2;
	}

	public long getNode1Id() {
		return node1Id;
	}

	public void setNode1Id(long node1Id) {
		this.node1Id = node1Id;
	}

	public long getNode2Id() {
		return node2Id;
	}

	public void setNode2Id(long node2Id) {
		this.node2Id = node2Id;
	}

	@Override
	public String toString() {
		return "Object{" +
				"id=" + id +
				", name='" + name + '\'' +
				", node1Id=" + node1Id +
				", node2Id=" + node2Id +
				", distanceFromNode1=" + distanceFromNode1 +
				", distanceFromNode2=" + distanceFromNode2 +
				'}';
	}
}
