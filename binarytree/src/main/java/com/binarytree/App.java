package com.binarytree;

import java.util.Random;

public class App {
    public static void InsertTime(BinaryTree trees, int n){
        Random rand = new Random();
        long initTime= System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            trees.insert(rand.nextInt(100));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Tempo de insercao: " + (endTime - initTime) + " ms");  
    }

    public static void InsertTimeAVL(AVLBinaryTree trees, int n){
        Random rand = new Random();
        long initTime= System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            trees.insert(rand.nextInt(100));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Tempo de insercao AVL: " + (endTime - initTime) + " ms");  
    }

    public static void RemoveTime(BinaryTree trees, int n){
        Random rand = new Random();
        long initTime= System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            trees.remove(rand.nextInt(100));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Tempo de remover: " + (endTime - initTime) + " ms");  
    }

    public static void RemoveTimeAVL(AVLBinaryTree trees, int n){
        Random rand = new Random();
        long initTime= System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            trees.remove(rand.nextInt(100));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Tempo de remover AVL: " + (endTime - initTime) + " ms");  
    }

    public static void findTime(BinaryTree trees, int n){
        Random rand = new Random();
        long initTime= System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            trees.find(rand.nextInt(100));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Tempo de achar: " + (endTime - initTime) + " ms");
    }

    public static void findTimeAVL(AVLBinaryTree trees, int n){
        Random rand = new Random();
        long initTime= System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            trees.find(rand.nextInt(100));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Tempo de achar AVL: " + (endTime - initTime) + " ms");
    }
    
    public static void main(String[] args) {
        int[] sizes = {100,500,1000,10000,20000};

        for (int size : sizes) {
            System.out.println("Comparando para " + size + " elementos:");

            AVLBinaryTree tree = new AVLBinaryTree();
            BinaryTree trees = new BinaryTree();
            Random x        = new Random();

            // long insertTime = 0;
            // long removeTime = 0;
            // long findTime   = 0;
            // int[] num       = new int[size];
            
            // long startTime = System.currentTimeMillis();
            // for (int i = 0; i < size; i++) {
            //     num[i] = x.nextInt(size);
            //     System.out.println(num[i]);
            //     tree.insert(num[i]);
            // } 
            // long endTime = System.currentTimeMillis();
            // insertTime = endTime - startTime;

            // startTime = System.currentTimeMillis();
            // for (int i = 0; i < 4; i++) {
            //     //System.out.println(num[x.nextInt(size)]+"/////////");
            //     tree.remove(num[x.nextInt(size)]);
            // } 
            // endTime = System.currentTimeMillis();
            // removeTime = endTime - startTime;

            // startTime = System.currentTimeMillis();
            // for (int i = 0; i < 4; i++) {
            //     tree.insert(num[x.nextInt(size)]);
            // } 
            // endTime = System.currentTimeMillis();
            // findTime = endTime - startTime;

            // System.out.printf("Teste tempos. Inserir: %.10f\nRemover: %.10f\nFind: %.10f\n", insertTime / 1000.0, removeTime / 1000.0, findTime / 1000.0);
            // tree.insert(4);
            // tree.insert(10);
            // tree.insert(5);
            // tree.insert(3);
            // tree.insert(9);
            // tree.insert(1);
            // tree.insert(7);
            // tree.insert(2);
            // tree.insert(8);
            // tree.insert(6);
            // tree.show();
            InsertTime(trees,size);
            RemoveTime(trees,x.nextInt(size));
            findTime(trees,x.nextInt(size));

            InsertTimeAVL(tree,size);
            RemoveTimeAVL(tree,x.nextInt(size));
            findTimeAVL(tree,x.nextInt(size));

        }
}
}
