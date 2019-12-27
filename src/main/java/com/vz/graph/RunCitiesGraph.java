package com.vz.graph;


import com.google.gson.Gson;

public class RunCitiesGraph {
    public static void main(String[] args) {
        Gson json = new Gson();
        //create an array of the class City objects
        City[] cities = {new City("Gdansk", 2), new City("Bydgoszcz", 3),
                new City("Torun", 3), new City("Warszawa", 2)};
        //to initialize the index and cost of "Gdansk"
        cities[0].index[0] = 2; cities[0].cost[0] = 1;
        cities[0].index[1] = 3; cities[0].cost[1] = 3;
        //to initialize the index and cost of "Bydgoszcz"
        cities[1].index[0] = 1; cities[1].cost[0] = 1;
        cities[1].index[1] = 3; cities[1].cost[1] = 1;
        cities[1].index[2] = 4; cities[1].cost[2] = 4;
        //to initialize the index and cost of "Torun"
        cities[2].index[0] = 1; cities[2].cost[0] = 3;
        cities[2].index[1] = 2; cities[2].cost[1] = 1;
        cities[2].index[2] = 4; cities[2].cost[2] = 1;
        //to initialize the index and cost of "Warszawa"
        cities[3].index[0] = 2; cities[3].cost[0] = 4;
        cities[3].index[1] = 3; cities[3].cost[1] = 1;

        int fromCity = 1; //This number you can change for a test
        int toCity = 4;   //This number you can change for a test

        int result = minCost(fromCity, toCity, cities);

        System.out.println(json.toJson(cities));
        System.out.println("--");
        System.out.println("From " + cities[fromCity - 1].name + " to " + cities[toCity - 1].name +
                " the minimum cost -> " + result + ".");

    }
//This function performances the Dijkstra's algorithm and returns a value minimum cost last point("finish")
    static int minCost(int start, int finish, City[] cities) {
        int[] point = new int[cities.length];
        boolean[] check = new boolean[cities.length];
        int min;
        for (int i = 0; i < cities.length; i++) {
            for (int j = 0; j < cities[start - 1].neighbors; j++) {
                if (check[cities[start - 1].index[j] - 1] == false && point[cities[start - 1].index[j] - 1] == 0
                        || point[cities[start - 1].index[j] - 1] > (point[start - 1] + cities[start - 1].cost[j])) {
                    point[cities[start - 1].index[j] - 1] = point[start - 1] + cities[start - 1].cost[j];
                }

            }
            check[start - 1] = true;
            min = point[cities[start - 1].index[0] - 1];
            int temp = cities[start - 1].index[0];
            for (int k = 0; k < cities[start - 1].neighbors; k++) {
                if (min == 0 || min > point[cities[start - 1].index[k] - 1]&&check[cities[start - 1].index[k] - 1]==false){
                    min = point[cities[start - 1].index[k] - 1];
                    temp = cities[start - 1].index[k];
                }

            }
            start = temp;

        }

        return point[finish - 1];
    }
}
