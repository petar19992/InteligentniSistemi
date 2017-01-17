package com.example.petar.inteligentnisistemi.models;

import java.util.*;

/**
 * Created by PETAR on 12/25/2016.
 */

public class NodeType
{
    private String name;
    private java.util.Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public java.util.Map<String, Object> getAdditionalProperties()
    {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value)
    {
        this.additionalProperties.put(name, value);
    }
}
