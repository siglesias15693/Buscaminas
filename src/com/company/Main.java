package com.company;

import java.util.Scanner;

public class Main{
    public static String[][] tablero;
    public static int[][] tablerominas;
    public static int Columnas;
    public static int Filas;
    public static int minas;
    public static int cassillasGiradas;
    public static int cassillasTotales;
    public static boolean running = true;

    public static boolean verificador=true;
    public static String mensajeError= "";
    public static final Scanner lector = new Scanner(System.in);

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
                tablero[i][j] = "   ";
                tablerominas[i][j]=0;
            }
        }

        assignarMinas();
        assignarValores();
        play.play();
    }

    public static void assignarMinas() {
        int m = 0;
        while (m < minas) {
            int x = (int) (Math.random() * Columnas);
            int y = (int) (Math.random() * Filas);

            if (tablerominas[x][y] == 0) {
                tablerominas[x][y] = -1;
                m++;
            }
        }
    }

    public static void assignarValores() {
        for (int x = 0; x < Columnas; x++) {
            for (int y = 0; y < Filas; y++) {
                if (tablerominas[x][y] == -1) {

                    if (x - 1 >= 0 && y - 1 >= 0 && tablerominas[x - 1][y - 1] != -1) {
                        tablerominas[x - 1][y - 1]++;
                    }

                    if (x - 1 >= 0 && tablerominas[x - 1][y] != -1) {
                        tablerominas[x - 1][y]++;
                    }

                    if (x - 1 >= 0 && y + 1 < Filas && tablerominas[x - 1][y + 1] != -1) {
                        tablerominas[x - 1][y + 1]++;
                    }

                    if (y - 1 >= 0 && tablerominas[x][y - 1] != -1) {
                        tablerominas[x][y - 1]++;
                    }

                    if (y + 1 < Filas && tablerominas[x][y + 1] != -1) {
                        tablerominas[x][y + 1]++;
                    }

                    if (x + 1 < Columnas && y - 1 >= 0 && tablerominas[x + 1][y - 1] != -1) {
                        tablerominas[x + 1][y - 1]++;
                    }

                    if (x + 1 < Columnas && tablerominas[x + 1][y] != -1) {
                        tablerominas[x + 1][y]++;
                    }

                    if (x + 1 < Columnas && y + 1 < Filas && tablerominas[x + 1][y + 1] != -1) {
                        tablerominas[x + 1][y + 1]++;
                    }

                }
            }
        }
    }

    public static void esCero(int x, int y) {
        if (x - 1 >= 0 && y - 1 >= 0) {
            play.jugada(x - 1, y - 1);
        }

        if (x - 1 >= 0) {
            play.jugada(x - 1, y);
        }

        if (x - 1 >= 0 && y + 1 < Filas) {
            play.jugada(x - 1, y + 1);
        }

        if (y - 1 >= 0) {
            play.jugada(x, y - 1);
        }

        if (y + 1 < Filas) {
            play.jugada(x, y + 1);
        }

        if (x + 1 < Columnas && y - 1 >= 0) {
            play.jugada(x + 1, y - 1);
        }

        if (x + 1 < Columnas) {
            play.jugada(x + 1, y);
        }

        if (x + 1 < Columnas && y + 1 < Filas) {
            play.jugada(x + 1, y + 1);
        }
    }

    public static void gameover(){
        dibujo.mostrarTablero();
        System.out.print("\033[31mGAME OVER");
        running=false;
    }

    public static void comprovarVictoria() {
        if (cassillasGiradas >= cassillasTotales) {
            dibujo.mostrarTablero();
            System.out.println("\033[32m¡¡¡Victoria!!!!!");
            running = false;
        }
    }

}

