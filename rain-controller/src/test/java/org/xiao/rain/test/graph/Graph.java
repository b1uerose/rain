package org.xiao.rain.test.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 图
 * Author: xiaojl
 * Date:2022-02-23 23:39
 */
public class Graph {

    private List<String> vertexList = new ArrayList<>();
    private int[][] edgeArray;
    private int edgeCount;
    private boolean[] isVisited;

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.showGraph();

    }

    public Graph() {
        vertexList.add("A");
        vertexList.add("B");
        vertexList.add("C");
        vertexList.add("D");
        vertexList.add("E");
        edgeArray = new int[vertexList.size()][vertexList.size()];

        insertEdge("A", "B");
        insertEdge("C", "B");
        insertEdge("A", "C");
        insertEdge("E", "B");
        insertEdge("D", "B");
        isVisited = new boolean[vertexList.size()];
    }

    public void showGraph() {
        for (int[] edges : edgeArray) {
            System.out.println(Arrays.toString(edges));
        }
    }


    public void insertEdge(String vertex1, String vertex2) {
        int fisrtVertex = vertexList.indexOf(vertex1);
        int secVertex = vertexList.indexOf(vertex2);

        if (fisrtVertex == -1 || secVertex == -1) {
            return;
        }
        if (edgeArray[fisrtVertex][secVertex] == 0) {
            edgeArray[fisrtVertex][secVertex] = 1;
            edgeArray[secVertex][fisrtVertex] = 1;
            edgeCount++;
        }
    }
    
    private int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if(edgeArray[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }
    
    private int getNextNeighbor(int index, int vertexIndex) {
        for (int i = vertexIndex + 1; i < vertexList.size(); i++ ) {
            if (edgeArray[index][i] >0) {
                return i;
            }
        }
        return  -1;
    }
    
    public void depthFirstSearch(int index) {
        int adjacent = getFirstNeighbor(index);
        isVisited[index] = true;
        while (adjacent != -1) {
            if(!isVisited[adjacent]) {
                depthFirstSearch(adjacent);
            }
            adjacent = getNextNeighbor(index, adjacent);
        }
    }
    
    public void breadthFirstSearch(int index) {
        
        Deque<Integer> queue = new LinkedList<>();
        
        queue.add(index);
        
        while (!queue.isEmpty()) {
            int curIndex = queue.pollFirst();
            if (!isVisited[curIndex]) {
                //把所有未访问的节点放到队列中
                for (int i = 0; i < vertexList.size(); i++) {
                    if (edgeArray[curIndex][i] > 0) {
                        queue.push(i);
                    } 
                }
                
                
            }
            
            
        }
        
        
        
        
    }
    

    public void bfs() {
        Deque<String> queue = new LinkedList<>();
        List<String> existing = new ArrayList<>();
        search("A", existing);
    }

    public void search(String vertex, List<String> existing) {
        int index = vertexList.indexOf(vertex);
        for (int j = index + 1; j < vertexList.size(); j++) {

            if (edgeArray[index][j] == 1) {
                String nextVertex = vertexList.get(j);
                if (!existing.contains(nextVertex)) {
                    existing.add(nextVertex);
                    search(nextVertex, existing);
                }
            }
        }
    }

    public void dfs() {


    }

}
