package LeetCode0311_SparseMatrixMultiplication;

import java.util.ArrayList;
import java.util.List;

public class SparseMatrixMultiplication {
	/*
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] product = new int[A.length][B[0].length];
        for(int i = 0; i < A.length; i++) {
            for(int k = 0; k < A[0].length; k++) {
                if(A[i][k] == 0) continue;
                for(int j = 0; j < B[0].length; j++) {
                    if(B[k][j] != 0) product[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return product;
    }*/
    
    class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] product = new int[A.length][B[0].length];
        List<Node> listA = new ArrayList<>();
        List<Node> listB = new ArrayList<>();
        
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                if(A[i][j] != 0) listA.add(new Node(i, j));
            }
        }
        
        for(int i = 0; i < B.length; i++) {
            for(int j = 0; j < B[0].length; j++) {
                if(B[i][j] != 0) listB.add(new Node(i, j));
            }
        }
        
        for(Node nodeA : listA) {
            for(Node nodeB : listB) {
                if(nodeA.y == nodeB.x) {
                    product[nodeA.x][nodeB.y] += A[nodeA.x][nodeA.y] * B[nodeB.x][nodeB.y];
                }
            }
        }
        
        return product;
    }
}
