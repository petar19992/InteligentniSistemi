package com.example.petar.inteligentnisistemi.models;

import java.util.ArrayList;

/**
 * Created by petar on 9.10.16..
 */

public class Map {

    public ArrayList<Node> nodes;

    public Map()
    {
        nodes=new ArrayList<>();
    }
    public Node getNodeAt(int position)
    {
        if(nodes!=null&&nodes.size()>position)
        {
            return nodes.get(position);
        }
        return null;
    }

}
