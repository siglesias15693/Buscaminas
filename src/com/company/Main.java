package com.company;

import java.util.Scanner;

public class Main{
    public static Cells[][] tablero;
    public static int Columnas;
    public static int Filas;
    public static int minas;
    public static int cassillasGiradas;
    public static int cassillasTotales;
    public static boolean running = true;
    public static Cells Cells;

    public static boolean verificador=true;
    public static String mensajeError= "";
    public static final Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {

        minas=10;
        Columnas=9;
        Filas=9;
        tablero = new Cells[Columnas][Filas];
        cassillasGiradas=0;
        cassillasTotales=(Columnas*Filas)-minas;


        //Se asigna un caracter por defecto al tablero
        for (int i = 0; i <= Columnas - 1; i++) {
            for (int j = 0; j <= Filas - 1; j++) {
                tablero[i][j] = new Cells();
            }
        }

        play();
    }

    public static void play(){
        assignarMinas();
        assignarValores();

        while (running) {
            dibujo.mostrarTablero();
            play.eleccion();
        }
    }

    public static void assignarMinas() {
        int m = 0;
        while (m < minas) {
            int x = (int) (Math.random() * Columnas);
            int y = (int) (Math.random() * Filas);

            if (!tablero[x][y].isMina()) {
                tablero[x][y].setMina();
                m++;
            }
        }
    }

    public static void assignarValores() {
        for (int x = 0; x < Columnas; x++) {
            for (int y = 0; y < Filas; y++) {
                if (tablero[x][y].isMina()){

                    if (x - 1 >= 0 && y - 1 >= 0) {
                        tablero[x - 1][y - 1].setMinas();
                    }

                    if (x - 1 >= 0) {
                        tablero[x - 1][y].setMinas();
                    }

                    if (x - 1 >= 0 && y + 1 < Filas) {
                        tablero[x - 1][y + 1].setMinas();
                    }

                    if (y - 1 >= 0) {
                        tablero[x][y - 1].setMinas();
                    }

                    if (y + 1 < Filas ) {
                        tablero[x][y + 1].setMinas();
                    }

                    if (x + 1 < Columnas && y - 1 >= 0 ) {
                        tablero[x + 1][y - 1].setMinas();
                    }

                    if (x + 1 < Columnas) {
                        tablero[x + 1][y].setMinas();
                    }

                    if (x + 1 < Columnas && y + 1 < Filas) {
                        tablero[x + 1][y + 1].setMinas();
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

