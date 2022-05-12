package com.company;

public class game {

    public static boolean running = true;
    public static tauler tauler;

    private static String mensajeError= "";

    public void start() {
        tauler = new tauler();
        play();
    }

    public void play(){
        assignarMinas();

        while (running) {
            dibujo.mostrarTablero(tauler);
            momentojugador();
        }
    }

    public static void assignarMinas() {
        int m = 0;
        while (m < tauler.getTotalMinas()) {
            int x = (int) (Math.random() * tauler.getCol());
            int y = (int) (Math.random() * tauler.getRow());

            if (!tauler.isMina(x,y)) {
                tauler.setMina(x,y);
                assignarValores(x,y);
                m++;
            }

        }
    }

    public static void assignarValores(int x, int y) {

        for (int i=-1;i<=1;i++){
            for (int j=-1;j<=1;j++){
                if (tauler.dentroRango(x+i,y+j)){
                    tauler.sumMinas(x+i,y+j);
                }
            }
        }

    }

    public static void jugada(int x, int y) {
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

    public static void momentojugador(){
        boolean bucle=true;

        System.out.println(mensajeError);
        mensajeError = "";

        while (bucle){
            System.out.print("        Introduzca el numero de fila: ");
            int row=tauler.getRow()-interaction.intoducirNum();

            System.out.print("        Introduzca el numero de columna: ");
            int col=interaction.intoducirNum()-1;

            System.out.print("        Flag?[Y/N]: ");
            boolean flag=interaction.intoducirFlag();

            if (tauler.dentroRango(col,row)) {
                if (!tauler.isUp(col,row)) {
                    if (flag){
                        tauler.setFlag(col,row);
                    }else {
                        jugada(col, row);
                    }
                    bucle = false;
                }else{
                    mensajeError = "\n\033[35m**ERROR:\u001B[0m Esta posicion ya esta verificada";
                }
            } else {
                mensajeError = "\n\033[35m**ERROR:\u001B[0m La fila o columna esta fuera de rango";
            }

        }

    }

    public static void esCero(int x, int y) {

        for (int i=-1;i<=1;i++){
            for (int j=-1;j<=1;j++){
                if (tauler.dentroRango(x+i,y+j)){
                    jugada(x+i,y+j);
                }
            }
        }

    }

    public static void gameover(){
        dibujo.mostrarTablero(tauler);
        System.out.print("\033[31mGAME OVER\u001B[0m");
        running=false;
    }

    public static void comprovarVictoria() {
        if (tauler.getTotalUp() >= tauler.getRestantes()) {
            dibujo.mostrarTablero(tauler);
            System.out.println("\033[32m¡¡¡Victoria!!!!!\u001B[0m");
            running = false;
        }
    }


}


