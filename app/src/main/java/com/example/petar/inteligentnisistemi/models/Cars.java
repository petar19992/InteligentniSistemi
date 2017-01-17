package com.example.petar.inteligentnisistemi.models;

import java.util.Map;

import java.util.HashMap;
import java.util.Map;

public class Cars
{

    private Integer id;
    private String regBr;
    private String brand;
    private Node positionNode1;
    private Node positionNode2;
    private Node lastNode;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getRegBr()
    {
        return regBr;
    }

    public void setRegBr(String regBr)
    {
        this.regBr = regBr;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public Node getPositionNode1()
    {
        return positionNode1;
    }

    public void setPositionNode1(Node positionNode1)
    {
        this.positionNode1 = positionNode1;
    }

    public Node getPositionNode2()
    {
        return positionNode2;
    }

    public void setPositionNode2(Node positionNode2)
    {
        this.positionNode2 = positionNode2;
    }

    public Node getLastNode()
    {
        return lastNode;
    }

    public void setLastNode(Node lastNode)
    {
        this.lastNode = lastNode;
    }

    public Map<String, Object> getAdditionalProperties()
    {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value)
    {
        this.additionalProperties.put(name, value);
    }

}