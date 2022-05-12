package com.company;

public class game {

    public static boolean running = true;
    public static tauler tauler;

    public static void start() {
        interaction.dificulty();
        tauler = new tauler();
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
        while (m < tauler.getTotalMinas()) {
            int x = (int) (Math.random() * tauler.getCol());
            int y = (int) (Math.random() * tauler.getRow());

            if (!tauler.isMina(x,y)) {
                tauler.setMina(x,y);
                m++;
            }
        }
    }

    public static void assignarValores() {
        for (int x = 0; x < tauler.getCol(); x++) {
            for (int y = 0; y < tauler.getRow(); y++) {
                if (tauler.isMina(x,y)){

                    for (int i=-1;i<=1;i++){
                        for (int j=-1;j<=1;j++){
                            if (tauler.dentroRango(x+i,y+j)){
                                tauler.sumMinas(x+i,y+j);
                            }
                        }
                    }

                }
            }
        }
    }

    public static void esCero(int x, int y) {
        if ( x-1>=0 && y-1>=0 ) {
            interaction.jugada(x - 1, y - 1);
        }

        for (int i=-1;i<=1;i++){
            for (int j=-1;j<=1;j++){
                if (tauler.dentroRango(x+i,y+j)){
                    interaction.jugada(x+i,y+j);
                }
            }
        }

    }

    public static void gameover(){
        dibujo.mostrarTablero();
        System.out.print("\033[31mGAME OVER\u001B[0m");
        running=false;
    }

    public static void comprovarVictoria() {
        if (tauler.getTotalUp() >= tauler.getRestantes()) {
            dibujo.mostrarTablero();
            System.out.println("\033[32m¡¡¡Victoria!!!!!\u001B[0m");
            running = false;
        }
    }


}


