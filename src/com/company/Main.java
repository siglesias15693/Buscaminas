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

    public static boolean verificador=true;
    public static String mensajeError= "";

    public static final Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {

        dificulty();

        tablero = new Cells[Columnas][Filas];
        cassillasGiradas=0;
        cassillasTotales=(Columnas*Filas)-minas;


        //Se asigna un caracter por defecto al tablero
        for (int i = 0; i < Columnas; i++) {
            for (int j = 0; j < Filas; j++) {
                tablero[i][j] = new Cells();
            }
        }

        play();
    }

    public static void dificulty(){
        boolean didiculty=true;

        while (didiculty){
            System.out.println("Seleccione dificultad: ");
            System.out.println("        1-Facil ");
            System.out.println("        2-Normal ");
            System.out.println("        3-Dificil ");
            int d = lector.nextInt();

            if (d==1){
                minas=10;
                Columnas=10;
                Filas=8;
                didiculty=false;
            }

            if (d==2){
                minas=20;
                Columnas=16;
                Filas=14;
                didiculty=false;
            }

            if (d==3){
                minas=30;
                Columnas=22;
                Filas=20;
                didiculty=false;
            }


        }

    }

    public static void play(){
        assignarMinas();
        assignarValores();

        while (running) {
            dibujo.mostrarTablero();
            eleccion();
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
            jugada(x - 1, y - 1);
        }

        if (x - 1 >= 0) {
            jugada(x - 1, y);
        }

        if (x - 1 >= 0 && y + 1 < Filas) {
            jugada(x - 1, y + 1);
        }

        if (y - 1 >= 0) {
            jugada(x, y - 1);
        }

        if (y + 1 < Filas) {
            jugada(x, y + 1);
        }

        if (x + 1 < Columnas && y - 1 >= 0) {
            jugada(x + 1, y - 1);
        }

        if (x + 1 < Columnas) {
            jugada(x + 1, y);
        }

        if (x + 1 < Columnas && y + 1 < Filas) {
            jugada(x + 1, y + 1);
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


    ///////////////////////////////////////////////////////////////////////////////////////////////


    public static void jugada( int x,int y) {
        if (!tablero[x][y].isUp()){
            cassillasGiradas++;
            tablero[x][y].setUp();

            if (tablero[x][y].isMina()) {
                gameover();
            }

            if (tablero[x][y].getMinas() == 0) {
                esCero(x,y);
            }
        }

        comprovarVictoria();
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

            System.out.print("Flag?[Y/N]: ");
            String f = lector.next();

            boolean flag=false;
            if (f.equals("Y") | f.equals("y")){
                flag=true;
            }

            if (flag){
                tablero[columna][fila].setFlag();
                verificador = false;
            }else{
                if (fila >= 0 && fila < Filas && columna >= 0 && columna < Columnas) {
                    if (!tablero[columna][fila].isUp()) {
                        jugada(columna,fila);
                        verificador = false;
                    }else{
                        mensajeError = "\n\033[35m**ERROR:\u001B[0m Esta posicion ya esta verificada";
                    }
                } else {
                    mensajeError = "\n\033[35m**ERROR:\u001B[0m La fila o columna esta fuera de rango";
                }
            }
        }
        verificador = true;
    }

}


