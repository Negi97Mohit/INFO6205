package edu.neu.coe.info6205.union_find;

import java.util.Random;
import java.util.Scanner;

public class UF_Client {
    public static int count(int n){

        int countConnection = 0;
        //Connections counter
        UF_HWQUPC uf_hwqupc = new UF_HWQUPC(n);
        Random rand = new Random();
        while (uf_hwqupc.components() > 2) {
            countConnection++;
            int p1 = rand.nextInt(n-1);
            int p2 = rand.nextInt(n-1);
            //Random Pairs
            if(uf_hwqupc.connected(p1, p2)) continue;
            uf_hwqupc.union(p1, p2);
        }
        return countConnection;
    }

    public static void main(String[] args) {

        System.out.printf("%6s %6s %16s\n","No. Of Sites "," Mean ","Relation=(n*lg(n))/2");
        System.out.printf("---------------------------------\n");
        for (int n = 1000; n < 1000000; n *= 2) {
            int counter = 0;
            for (int j = 0; j < 10; j++)
                counter += UF_Client.count(n);
            //After finding the result in excel I added this column to print the relation results as well.
            System.out.printf("%7d | %7d | %8d |\n", n, counter / 10, (int) (n*Math.log(n)*0.5 ));
        }
    }
}
