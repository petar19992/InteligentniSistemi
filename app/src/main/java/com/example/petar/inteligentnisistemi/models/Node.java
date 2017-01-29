package com.example.petar.inteligentnisistemi.models;

import java.io.Serializable;
import java.lang.*;
import java.lang.Object;
import java.util.ArrayList;
import java.util.List;


public class Node implements Serializable{

	long id;
	String name;
	String longitude;
	String latitude;
	NodeType nodeType;

	public Node() {
		super();
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
	public String getLongitude()
	{
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public NodeType getNodeType() {
		return nodeType;
	}
	public void setNodeType(NodeType nodeType) {
		this.nodeType = nodeType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + (((Long)id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Long id = this.id;
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (id == null) {
			if ((Long)other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Node{" +
				"id=" + id +
				", name='" + name + '\'' +
				", longitude='" + longitude + '\'' +
				", latitude='" + latitude + '\'' +
				", nodeType=" + nodeType +
				'}';
	}

	/*************************************************************/
	public String getNodeForConnectionNodes()
	{
		return "{\n" +
				"\"name\": \""+name+"\",\n" +
				"\"nodeType\": {\n" +
				"\"name\":\""+nodeType.getName()+"\"\n" +
				"}\n" +
				"}";
	}

	public ArrayList<Node> connectedNodes=new ArrayList<>();
}
