package com.company;

public class play extends Main{

    public static void jugada( int x,int y) {
        if (tablero[x][y].equals("   ")){
            cassillasGiradas++;
            if (tablerominas[x][y] < 0) {
                tablero[x][y] = "X";
                logic.gameover();
            } else {
                tablero[x][y] = String.valueOf(tablerominas[x][y]);
            }

            if (tablerominas[x][y] == 0) {
                logic.esCero(x,y);
            }
        }

        logic.comprovarVictoria();
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
                if (tablero[columna][fila].equals("   ")) {
                    jugada(columna,fila);
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
            dibujo.mostrarTablero();
            eleccion();
        }
    }

}
