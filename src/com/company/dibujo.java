package com.company;

import static com.company.Main.*;

public class dibujo{

    public static void mostrarTablero() {
        System.out.print("         ");
        for (int i = 0; i < Columnas; i++) {
            System.out.print("___ ");
        }System.out.println();

        int n=Filas+1;
        for (int i = 0; i < Filas; i++) {
            n--;

            if (n>9){
                System.out.print("     "+n+" |");
            }else{
                System.out.print("     "+n+"  |");
            }


            for (int j = 0; j < Columnas; j++) {

                if (tablero[j][i].isUp()){

                    if(tablero[j][i].isMina()){
                        System.out.print("\033[41m X \u001B[0m");
                    }else{
                        switch (tablero[j][i].getMinas()){
                            case 0:System.out.print("\033[47m " + tablero[j][i].getMinas() + " \u001B[0m");break;
                            case 1:System.out.print("\033[44m " + tablero[j][i].getMinas() + " \u001B[0m");break;
                            case 2:System.out.print("\033[42m " + tablero[j][i].getMinas() + " \u001B[0m");break;

                            default:System.out.print("\033[45m " + tablero[j][i].getMinas() + " \u001B[0m");break;
                        }
                    }

                }else if (tablero[j][i].getFlag()){
                    System.out.print("\033[31m F \u001B[0m");
                }else{
                    System.out.print("   ");
                }

                System.out.print("|");
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

            if (i>8){
                System.out.print(i + "  ");
            }else{
                System.out.print(i + "   ");
            }

        }System.out.println();


        System.out.println("=============================================||| N°Minas " + minas + " |||");
        System.out.println("==============================  Espacios restantes:  "+(cassillasTotales-cassillasGiradas)+"   =====");
    }

}
