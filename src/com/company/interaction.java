package com.company;

import static com.company.Main.*;
import java.util.Scanner;

public class interaction {

    public static final Scanner lector = new Scanner(System.in);

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

    public static void jugada( int x,int y) {
        if (!tauler.cell(x,y).isUp()){
            cassillasGiradas++;
            tauler.cell(x,y).setUp();

            if (tauler.isMina(x,y)) {
                gameover();
            }

            if (tauler.getMinas(x,y) == 0) {
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
                tauler.setFlag(columna,fila);
                verificador = false;
            }else{
                if (fila >= 0 && fila < Filas && columna >= 0 && columna < Columnas) {
                    if (!tauler.isUp(columna,fila)) {
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
