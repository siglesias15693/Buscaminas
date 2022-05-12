package com.company;

import java.util.Scanner;

public class interaction {

    private static final Scanner lector = new Scanner(System.in);

    public static int[] dificulty(){
        int[][] dif = { {10, 10, 8} , {20, 16, 14}, {30, 22, 20}  };

        while (true){

            System.out.println(" Seleccione dificultad: ");
            System.out.println("      1-Facil ");
            System.out.println("      2-Normal ");
            System.out.println("      3-Dificil ");

            int d = lector.nextInt();
            if( ( d>= 1) && ( d <= 3)){ return dif[d-1];}

        }
    }

    public static int intoducirNum(){
        return lector.nextInt();
    }


    public static boolean intoducirFlag(){
        String f = lector.next();
        return ( f.equals("Y") | f.equals("y") );
    }

}
