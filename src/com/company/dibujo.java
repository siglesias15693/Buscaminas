package com.company;

import static com.company.game.tauler;

public class dibujo{

    public static void mostrarTablero() {
        System.out.print("         ");
        for (int i = 0; i < tauler.getCol(); i++) {
            System.out.print("___ ");
        }System.out.println();

        int n=tauler.getRow()+1;
        for (int i = 0; i < tauler.getRow(); i++) {
            n--;

            if (n>9){
                System.out.print("     "+n+" |");
            }else{
                System.out.print("     "+n+"  |");
            }


            for (int j = 0; j < tauler.getCol(); j++) {
                System.out.print(tauler.getCell(j,i).show());
                System.out.print("|");
            }

            System.out.println();
            if (i < tauler.getRow() -1) {
                System.out.print("        |");
                for (int p = 0; p < tauler.getCol() ; p++) {
                    if (p==tauler.getCol()-1){
                        System.out.print("--–");
                    }else{
                        System.out.print("--– ");
                    }
                }
                System.out.println("|");
            }
        }
        System.out.print("         ");
        for (int i = 1; i < tauler.getCol() + 1; i++) {
            System.out.print("¯¯¯ ");
        }
        System.out.println();

        System.out.print("          ");
        for (int i = 1; i < tauler.getCol() + 1; i++) {

            if (i>8){
                System.out.print(i + "  ");
            }else{
                System.out.print(i + "   ");
            }

        }System.out.println();


        System.out.println("=============================================||| N°Minas " + tauler.getTotalFlags() + "/" + tauler.getTotalMinas() + " |||");
        System.out.println("==============================  Espacios restantes:  "+tauler.getRestantes()+"   =====");
    }

}
