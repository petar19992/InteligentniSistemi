package com.example.petar.inteligentnisistemi.models;


import android.widget.ImageView;

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

    @Override
    public String toString()
    {
        return "{" +

                "\"regBr\": \"" + regBr + "5\"," +
                "\"positionNode1\": {" +

                "\"id\": " + positionNode1.getId() + "," +

                "\"name\": \"" + positionNode1.getName() + "\"," +

                "\"xCoordinate\": " + positionNode1.getLongitude() + "," +

                "\"yCoordinate\": " + positionNode1.getLatitude() + "," +

                "\"nodeType\": {" +

                "\"id\": " + positionNode1.getNodeType().getId() + "," +

                "\"name\": \"" + positionNode1.getNodeType().getName() + "\"" +

                "}" +

                "}," +

                "\"positionNode2\": {" +

                "\"id\": " + positionNode2.getId() + "," +

                "\"name\": \"" + positionNode2.getName() + "\"," +

                "\"xCoordinate\": " + positionNode2.getLongitude() + "," +

                "\"yCoordinate\": " + positionNode2.getLatitude() + "," +

                "\"nodeType\": {" +

                "\"id\": " + positionNode2.getNodeType().getId() + "," +

                "\"name\": \"" + positionNode2.getNodeType().getName() + "\"" +

                "}" +

                "}," +

                "\"lastNode\": {" +

                "\"id\": " + positionNode2.getId() + "," +

                "\"name\": \"" + positionNode2.getName() + "\"," +

                "\"xCoordinate\": " + positionNode2.getLongitude() + "," +

                "\"yCoordinate\": " + positionNode2.getLatitude() + "," +

                "\"nodeType\": {" +

                "\"id\": " + positionNode2.getNodeType().getId() + "," +

                "\"name\": \"" + positionNode2.getNodeType().getName() + "\"" +

                "}" +
                "}" +

                "}";
    }


    /******************************/
    /*public ImageView carOnMap;*/
}
