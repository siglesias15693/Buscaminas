package com.company;

import static com.company.game.*;
import java.util.Scanner;

public class interaction {

    private static boolean verificador=true;
    private static String mensajeError= "";

    private static final Scanner lector = new Scanner(System.in);

    public static void dificulty(){
        boolean didiculty=true;

        while (didiculty){
            System.out.println("Seleccione dificultad: ");
            System.out.println("        1-Facil ");
            System.out.println("        2-Normal ");
            System.out.println("        3-Dificil ");
            int d = lector.nextInt();

            if (d==1){
                tauler.setTotalMinas(10);
                tauler.setCol(10);
                tauler.setRow(8);
                didiculty=false;
            }

            if (d==2){
                tauler.setTotalMinas(20);
                tauler.setCol(16);
                tauler.setRow(14);
                didiculty=false;
            }

            if (d==3){
                tauler.setTotalMinas(30);
                tauler.setCol(22);
                tauler.setRow(20);
                didiculty=false;
            }


        }

    }

    public static void jugada( int x,int y) {
        if (!tauler.getCell(x,y).isUp()){

            tauler.getCell(x,y).setUp();

            if (tauler.isMina(x,y)) {
                gameover();
            }

            if (tauler.getMinasArround(x,y) == 0) {
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
            fila=tauler.getRow()-fila;

            System.out.print("Introduzca el numero de columna: ");
            int columna = lector.nextInt()-1;

            System.out.print("Flag?[Y/N]: ");
            String f = lector.next();

            boolean flag=( f.equals("Y") | f.equals("y") );

            if (flag){
                tauler.setFlag(columna,fila);
                verificador = false;
            }else{
                try {
                    if (!tauler.isUp(columna,fila)) {
                        jugada(columna,fila);
                        verificador = false;
                    }else{
                        mensajeError = "\n\033[35m**ERROR:\u001B[0m Esta posicion ya esta verificada";
                    }
                } catch (Exception e){
                    mensajeError = "\n\033[35m**ERROR:\u001B[0m La fila o columna esta fuera de rango";
                }
            }
        }
        verificador = true;
    }

}
