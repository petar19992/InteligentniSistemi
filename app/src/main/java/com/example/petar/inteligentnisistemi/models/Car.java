package com.example.petar.inteligentnisistemi.models;

import java.io.Serializable;

public class Car implements Serializable
{

    /**
     *
     */
    private static final long serialVersionUID = -3478083415858828505L;

    long id;
    String regBr;
    String brand;
    Node positionNode1;
    Node positionNode2;
    Node lastNode;


    public Car()
    {
        super();
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
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


}
