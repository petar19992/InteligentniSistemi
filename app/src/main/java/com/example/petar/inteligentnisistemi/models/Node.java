package com.example.petar.inteligentnisistemi.models;

import java.util.Map;

import java.util.HashMap;
import java.util.Map;

public class Node
{

    private Integer id;
    private String name;
    private Integer xCoordinate;
    private Integer yCoordinate;
    private NodeType nodeType;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getXCoordinate()
    {
        return xCoordinate;
    }

    public void setXCoordinate(Integer xCoordinate)
    {
        this.xCoordinate = xCoordinate;
    }

    public Integer getYCoordinate()
    {
        return yCoordinate;
    }

    public void setYCoordinate(Integer yCoordinate)
    {
        this.yCoordinate = yCoordinate;
    }

    public NodeType getNodeType()
    {
        return nodeType;
    }

    public void setNodeType(NodeType nodeType)
    {
        this.nodeType = nodeType;
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