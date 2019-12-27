package com.vz.graph;

public class City {
    protected String name;
    protected int neighbors;
    protected int[] index;
    protected int[] cost;

    public City(String name, int neighbors) {
        this.name = name;
        this.neighbors = neighbors;
        this.index = new int[neighbors];
        this.cost = new int[neighbors];
    }

}
