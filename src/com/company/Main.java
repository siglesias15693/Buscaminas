package com.company;

import java.util.Scanner;

public class Main {

    private static String[][] tablero;
    private static int[][] tablerominas;
    private static int Columnas;
    private static int Filas;
    private static int minas;
    private static boolean running = true;
    private static int cassillasGiradas;
    private static int cassillasTotales;

    private static boolean verificador=true;
    private static String mensajeError= "";

    private static final Scanner lector = new Scanner(System.in);

    public static void mostrarTablero() {
        System.out.print("         ");
        for (int i = 0; i < Columnas; i++) {
            System.out.print("___ ");
        }System.out.println();

        int n=Filas+1;
        for (int i = 0; i < Filas; i++) {
            n--;
            System.out.print("     "+n+"  | ");
            for (int j = 0; j < Columnas; j++) {
                if (tablero[j][i].equals(" ")){
                    System.out.print(tablero[j][i]);
                }else {
                    if (tablerominas[j][i] < 0) {
                        System.out.print("\033[31m" + tablero[j][i] + "\u001B[0m");
                    }
                    if (tablerominas[j][i] == 0) {
                        System.out.print("\033[37m" + tablero[j][i] + "\u001B[0m");
                    }
                    if (tablerominas[j][i] == 1) {
                        System.out.print("\033[34m" + tablero[j][i] + "\u001B[0m");
                    }
                    if (tablerominas[j][i] == 2) {
                        System.out.print("\033[32m" + tablero[j][i] + "\u001B[0m");
                    }
                    if (tablerominas[j][i] > 2) {
                        System.out.print("\033[35m" + tablero[j][i] + "\u001B[0m");
                    }
                }

                System.out.print(" | ");
            }
            System.out.println();
            if (i < Filas -1) {
                System.out.print("        |");
                for (int p = 0; p < Columnas ; p++) {
                    if (p==Columnas-1){
                        System.out.print("--–");
                    }else{
                        System.out.print("--– ");
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


        System.out.println("=============================================||| N°Minas " + minas + " |||");
        System.out.println("============================   Espacios girados:  "+cassillasGiradas+"/"+cassillasTotales+"   =====");
    }

    public static void jugada( int x,int y) {
        if (tablero[x][y].equals(" ")){
            cassillasGiradas++;
            if (tablerominas[x][y] < 0) {
                tablero[x][y] = "X";
                mostrarTablero();
                System.out.print("\033[31mGAME OVER");
                running=false;
            } else {
                tablero[x][y] = String.valueOf(tablerominas[x][y]);
            }

            if (tablerominas[x][y] == 0) {
                esCero(x,y);
            }
        }

        comprovarVictoria();
    }

    public static void comprovarVictoria(){
        if (cassillasGiradas>=cassillasTotales){
            mostrarTablero();
            System.out.println("\033[32m¡¡¡Victoria!!!!!");
            running=false;
        }
    }

    public static void esCero(int x, int y){
        if (x - 1 >= 0 && y - 1 >= 0) {jugada(x-1,y-1);}

        if (x - 1 >= 0) {jugada(x-1,y);}

        if (x - 1 >= 0 && y + 1 < Filas) {jugada(x-1,y+1);}

        if (y - 1 >= 0 ) {jugada(x,y-1);}

        if (y + 1 < Filas ) {jugada(x,y+1);}

        if (x + 1 < Columnas && y - 1 >= 0 ) {jugada(x+1,y-1);}

        if (x + 1 < Columnas) {jugada(x+1,y);}

        if (x + 1 < Columnas && y + 1 < Filas) {jugada(x+1,y+1);}
    }

    public static void eleccion(){
        while (verificador) {
            System.out.println(mensajeError);
            mensajeError = "";

            System.out.print("Introduzca el numero de fila: ");
            int fila = lector.nextInt();
            fila=Filas-fila;

            System.out.print("Introduzca el numero de columna: ");
            int columna = lector.nextInt()-1;


            if (fila >= 0 && fila < Filas && columna >= 0 && columna < Columnas) {
                if (tablero[columna][fila].equals(" ")) {
                    jugada(columna, fila);
                    verificador = false;
                }else{
                    mensajeError = "\n\033[35m**ERROR:\u001B[0m Esta posicion ya esta verificada";
                }
            } else {
                mensajeError = "\n\033[35m**ERROR:\u001B[0m La fila o columna esta fuera de rango";
            }

        }
        verificador = true;
    }

    public static void play(){
        while (running) {
            mostrarTablero();
            eleccion();
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
        minas=10;
        Columnas=tablero.length;
        Filas=tablero[0].length;
        tablerominas= new int[Columnas][Filas];
        cassillasGiradas=0;
        cassillasTotales=(Columnas*Filas)-minas;

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
