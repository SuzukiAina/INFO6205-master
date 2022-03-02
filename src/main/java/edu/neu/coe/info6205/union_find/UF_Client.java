package edu.neu.coe.info6205.union_find;

import java.util.Random;
import java.util.Scanner;

public class UF_Client {
    public int count(int n){
        UF_HWQUPC uf_hwqupc=new UF_HWQUPC(n);
        int count=0;
        Random random=new Random();
        while(uf_hwqupc.components()>1){
            int x = random.nextInt(n);
            int y = random.nextInt(n);
            uf_hwqupc.connect(x, y);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Please enter n: ");
        Scanner scanner = new Scanner(System.in);
        int n =  scanner.nextInt();
        UF_Client uf_client=new UF_Client();
        scanner.close();
        int sum=0;
        for(int i=0;i<100;i++){
            sum+=uf_client.count(n);
        }
        int result=sum/100;
        System.out.println("Total Average Connection number is: "+result);
        System.out.println("lnN is: "+Math.log(n));
        System.out.println("Nln(N) is: "+n*Math.log(n));
        System.out.println("N^2 is: "+n*n);
    }
}
