package com.company;

import static com.company.Main.*;

public class logic {
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
