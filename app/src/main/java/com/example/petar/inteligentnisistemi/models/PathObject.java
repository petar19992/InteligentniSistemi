package com.example.petar.inteligentnisistemi.models;

import java.util.List;

/**
 * Created by Miloš on 25/01/2017.
 */
public class PathObject {

    List<Node> nodes;
    Integer weight;

    public PathObject() {
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "PathObject{" +
                "nodes=" + nodes +
                ", weight=" + weight +
                '}';
    }
}
