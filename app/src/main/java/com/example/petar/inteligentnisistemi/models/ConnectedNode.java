package com.example.petar.inteligentnisistemi.models;

import java.io.Serializable;

/**
 * Created by Miloš on 12/01/2017.
 */

public class ConnectedNode implements Serializable {

    long id;
//    @JoinColumn(name="node_id")
    long nodeId;
//    @JoinColumn(name="node_id")
    long connectedNodeId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNodeId() {
        return nodeId;
    }

    public void setNodeId(long nodeId) {
        this.nodeId = nodeId;
    }

    public long getConnectedNodeId() {
        return connectedNodeId;
    }

    public void setConnectedNodeId(long connectedNodeId) {
        this.connectedNodeId = connectedNodeId;
    }

    @Override
    public String toString() {
        return "NodeConnected{" +
                "id=" + id +
                ", nodeId=" + nodeId +
                ", connectedNodeId=" + connectedNodeId +
                '}';
    }
}
