package com.company;

public class init {
    public static int Columnas;
    public static int Filas;
    public static int minas;
    public static int cassillasGiradas;
    public static int cassillasTotales;
    public static boolean running = true;

    public static tauler tauler;

    public static boolean verificador=true;
    public static String mensajeError= "";

    public static void start() {
        interaction.dificulty();

        tauler = new tauler(Columnas,Filas);

        cassillasGiradas=0;
        cassillasTotales=(Columnas*Filas)-minas;

        play();
    }

    public static void play(){
        assignarMinas();
        assignarValores();

        while (running) {
            dibujo.mostrarTablero();
            interaction.eleccion();
        }
    }

    public static void assignarMinas() {
        int m = 0;
        while (m < minas) {
            int x = (int) (Math.random() * Columnas);
            int y = (int) (Math.random() * Filas);

            if (!tauler.isMina(x,y)) {
                tauler.setMina(x,y);
                m++;
            }
        }
    }

    public static void assignarValores() {
        for (int x = 0; x < Columnas; x++) {
            for (int y = 0; y < Filas; y++) {
                if (tauler.isMina(x,y)){

                    if (x - 1 >= 0 && y - 1 >= 0) {
                        tauler.sumMinas(x-1,y-1);
                    }

                    if (x - 1 >= 0) {
                        tauler.sumMinas(x-1,y);
                    }

                    if (x - 1 >= 0 && y + 1 < Filas) {
                        tauler.sumMinas(x-1,y+1);
                    }

                    if (y - 1 >= 0) {
                        tauler.sumMinas(x,y-1);
                    }

                    if (y + 1 < Filas ) {
                        tauler.sumMinas(x,y+1);
                    }

                    if (x + 1 < Columnas && y - 1 >= 0 ) {
                        tauler.sumMinas(x+1,y-1);
                    }

                    if (x + 1 < Columnas) {
                        tauler.sumMinas(x+1,y);
                    }

                    if (x + 1 < Columnas && y + 1 < Filas) {
                        tauler.sumMinas(x+1,y+1);
                    }

                }
            }
        }
    }

    public static void esCero(int x, int y) {
        if (x - 1 >= 0 && y - 1 >= 0) {
            interaction.jugada(x - 1, y - 1);
        }

        if (x - 1 >= 0) {
            interaction.jugada(x - 1, y);
        }

        if (x - 1 >= 0 && y + 1 < Filas) {
            interaction.jugada(x - 1, y + 1);
        }

        if (y - 1 >= 0) {
            interaction.jugada(x, y - 1);
        }

        if (y + 1 < Filas) {
            interaction.jugada(x, y + 1);
        }

        if (x + 1 < Columnas && y - 1 >= 0) {
            interaction.jugada(x + 1, y - 1);
        }

        if (x + 1 < Columnas) {
            interaction.jugada(x + 1, y);
        }

        if (x + 1 < Columnas && y + 1 < Filas) {
            interaction.jugada(x + 1, y + 1);
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


