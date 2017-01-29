package com.example.petar.inteligentnisistemi.models;

import java.util.List;

/**
 * Created by Miloš on 18/01/2017.
 */
public class Graph {

    List<Road> roads;
    List<Node> nodes;

    public List<Road> getRoads() {
        return roads;
    }

    public void setRoads(List<Road> roads) {
        this.roads = roads;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }
}
