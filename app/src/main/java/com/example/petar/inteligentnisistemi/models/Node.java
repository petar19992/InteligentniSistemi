package com.example.petar.inteligentnisistemi.models;

import java.util.ArrayList;

/**
 * Created by petar on 9.10.16..
 */

//https://github.com/petar19992/InteligentniSistemi.git
public class Node {

    public int id;
    public String name;
    public float X;
    public float Y;

    public ArrayList<Edge> edges;
    public ArrayList<Integer> tmpEdges;

    public Node()
    {
        edges=new ArrayList<>();
        tmpEdges=new ArrayList<>();
    }
}
