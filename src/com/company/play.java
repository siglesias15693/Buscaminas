package com.company;

import java.util.Scanner;

import static com.company.Main.*;

public class play {

    public static final Scanner lector = new Scanner(System.in);

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
            System.out.print("Flag?[Y/N]: ");
            String f = lector.next();

            System.out.print("Introduzca el numero de fila: ");
            int fila = lector.nextInt();
            fila=Filas-fila;

            System.out.print("Introduzca el numero de columna: ");
            int columna = lector.nextInt()-1;



            boolean flag=false;
            if (f.equals("Y") | f.equals("y")){
                flag=true;
            }

            if (flag){
                flag(columna,fila);
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

    public static void flag(int c, int f){
        tablero[c][f].setFlag();
    }

}
