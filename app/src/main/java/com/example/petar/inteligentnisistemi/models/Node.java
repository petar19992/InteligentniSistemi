package com.example.petar.inteligentnisistemi.models;

import java.io.Serializable;
import java.util.List;



public class Node implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -796884698615643293L;

	

	long id;
	String name;
	Integer xCoordinate;
	Integer yCoordinate;
	NodeType nodeType;
//	@OneToOne
//	Integer nodeTypeID;
//	Node connectedNode1;
//	Node connectedNode2;)
//	@ManyToMany(targetEntity=Node.class)
	List<ConnectedNode> connected;
//	List<Node> connected;
//	@ManyToMany(targetEntity=Node.class)
//	List<Integer> connected;
	
	
	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Node(long id) {
		super();
		this.id = id;
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
	public Integer getxCoordinate() {
		return xCoordinate;
	}
	public void setxCoordinate(Integer xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	public Integer getyCoordinate() {
		return yCoordinate;
	}
	public void setyCoordinate(Integer yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	public List<ConnectedNode> getConnected() {
		return connected;
	}
	public void setConnected(List<ConnectedNode> connected) {
		this.connected = connected;
	}
	public NodeType getNodeType() {
		return nodeType;
	}
	public void setNodeType(NodeType nodeType) {
		this.nodeType = nodeType;
	}

	@Override
	public String toString() {
		return "Node{" +
				"id=" + id +
				", name='" + name + '\'' +
				", xCoordinate=" + xCoordinate +
				", yCoordinate=" + yCoordinate +
				", nodeType=" + nodeType +
				", connected=" + connected +
				'}';
	}
}
