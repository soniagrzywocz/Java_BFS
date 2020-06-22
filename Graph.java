package lab11;

import java.util.HashMap;
import java.util.LinkedList;

import java.io.File;
import java.util.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Graph {

    private int num_vertices;
    private LinkedList<Integer> adjacents[];
    private String colours[];
    private int distances[];
    private int adj[]; // the adjacent vertex to a particular vertex while travelling from source.


    Graph(int num) {
        num_vertices = num;
        adjacents = new LinkedList[num_vertices];
        for (int i = 0; i < num_vertices; ++i)
            adjacents[i] = new LinkedList();
        colours = new String[num_vertices];
        distances = new int[num_vertices];
        adj = new int[num_vertices];
    }

    void edge_addition(int u, int v) {
        adjacents[u].add(v);
    }

    void breadth_first_search(int source, int destination) {
//		boolean visited[] = new boolean[num_vertices]; // by default sets to false.

        for (int i = 0; i < num_vertices; i++) {
            colours[i] = "white";
            distances[i] = Integer.MAX_VALUE;
            adj[i] = -1;
        }

        colours[source] = "gray";
        distances[source] = 0;
        adj[source] = -1;

        // Create a queue for bfs
        LinkedList<Integer> queue = new LinkedList<Integer>();

        queue.add(source);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            int s = queue.poll();
//            System.out.print(s+" ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adjacents[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (colours[n] == "white") {
                    colours[n] = "gray";
                    distances[n] = distances[s] + 1;
                    adj[n] = s;
                    queue.add(n);
                }
            }

            colours[s] = "black";
        }
        System.out.println();
        System.out.println("printing path from " + source + " to " + destination);
        System.out.println();
        print_path(source, destination);
    }

    void print_path(int source, int destination) {
        if (source == destination) {
            System.out.println(source);
        } else if (adj[destination] == -1) {
            System.out.println("no path from " + source + " to " + destination + " exists");
        } else {
            print_path(source, adj[destination]);
            System.out.println(destination);
        }
    }

    void print_graph(int v) {
        System.out.println("printing graph");
        for (int i = 0; i < v; i++) {
            System.out.print(i + ": ");
            Iterator<Integer> j = adjacents[i].listIterator();
            while (j.hasNext()) {
                System.out.print(j.next() + " ");
            }
            System.out.println();
        }
        System.out.println("printing graph done");
    }
}
