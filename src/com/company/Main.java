package com.company;

import java.util.Scanner;

public class Main {

    private static String[][] tablero;
    private static int[][] tablerominas;
    private static int Columnas;
    private static int Filas;
    private static int minas;
    private static boolean running = true;

    private static boolean verificador;
    private static String mensajeError= "";

    private static final Scanner lector = new Scanner(System.in);


    public static void mostrarTablero() {
        System.out.print("         ");
        for (int i = 0; i < Columnas; i++) {
            System.out.print("___ ");
        }System.out.println();

        for (int i = 0; i < Filas; i++) {
            System.out.print("        | ");
            for (int j = 0; j < Columnas; j++) {
                System.out.print(tablero[j][i]+" | ");
            }
            System.out.println();
            if (i < Filas -1) {
                System.out.print("        |");
                for (int p = 0; p < Columnas ; p++) {
                    if (p==Columnas-1){
                        System.out.print("-––");
                    }else{
                        System.out.print("-–– ");
                    }
                }
                System.out.println("|");
            }
        }
        System.out.print("         ");
        for (int i = 1; i < Columnas + 1; i++) {
            System.out.print("¯¯¯ ");
        }
        System.out.println();

        System.out.print("          ");
        for (int i = 1; i < Columnas + 1; i++) {
            System.out.print(i + "   ");
        }System.out.println();


        System.out.print("===============================================||| N° Minas" + minas + " |||");

    }

    public static void jugada(){

        int fila = lector.nextInt();
        int columna = lector.nextInt();

    }

    public static void play(){
        while (running){
            mostrarTablero();
            jugada();
        }
    }

    public static void assignarMinas(){
        int m =0;
        while (m<minas) {
            int x = (int) (Math.random() * Columnas);
            int y = (int) (Math.random() * Filas);

            if (tablerominas[x][y]==0) {
                tablerominas[x][y] = -1;
                m++;
            }
        }
    }

    public static void assignarValores(){
        for (int x=0;x<Columnas;x++){
            for (int y=0;y<Filas;y++){
                if (tablerominas[x][y]==-1){

                    if (x-1>=0 && y-1>=0 && tablerominas[x-1][y-1]!=-1){tablerominas[x-1][y-1]++;}

                    if (x-1>=0 && tablerominas[x-1][y]!=-1){tablerominas[x-1][y]++;}

                    if (x-1>=0 && y+1<Filas && tablerominas[x-1][y+1]!=-1){tablerominas[x-1][y+1]++;}

                    if (y-1>=0 && tablerominas[x][y-1]!=-1){tablerominas[x][y-1]++;}

                    if (y+1<Filas && tablerominas[x][y+1]!=-1){tablerominas[x][y+1]++;}

                    if (x+1<Columnas && y-1>=0 && tablerominas[x+1][y-1]!=-1){tablerominas[x+1][y-1]++;}

                    if (x+1<Columnas && tablerominas[x+1][y]!=-1){tablerominas[x+1][y]++;}

                    if (x+1<Columnas && y+1<Filas && tablerominas[x+1][y+1]!=-1){tablerominas[x+1][y+1]++;}

                }
            }
        }
    }

    public static void main(String[] args) {
        tablero = new String[9][9];
        minas=4;
        Columnas=tablero.length;
        Filas=tablero[0].length;
        tablerominas= new int[Columnas][Filas];

        //Se asigna un caracter por defecto al tablero
        for (int i = 0; i <= Columnas - 1; i++) {
            for (int j = 0; j <= Filas - 1; j++) {
                tablero[i][j] = " ";
                tablerominas[i][j]=0;
            }
        }

        //Se asigna las minas y valores al tablero
        assignarMinas();
        assignarValores();

        play();
    }

}
