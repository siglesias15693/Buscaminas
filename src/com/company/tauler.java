package com.company;

public class tauler {

    private int col;
    public int row;
    public Cells[][] tablero;

    public tauler(int c, int r){
        col=c;
        row=r;

        tablero = new Cells[col][row];

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                tablero[i][j] = new Cells();
            }
        }
    }

    public Cells cell(int x, int y){
        return tablero[x][y];
    }

    public boolean isMina(int x, int y){
        return tablero[x][y].isMina();
    }

    public boolean isUp(int x, int y){
        return tablero[x][y].isUp();
    }

    public int getMinas(int x, int y){
        return tablero[x][y].getMinas();
    }

    public boolean getFlag(int x, int y){
        return tablero[x][y].getFlag();
    }



    public void setMina(int x, int y){
        tablero[x][y].setMina();
    }

    public void sumMinas(int x, int y){
        tablero[x][y].setMinas();
    }

    public void setUp(int x, int y){
        tablero[x][y].setUp();
    }

    public void setFlag(int x, int y){
        tablero[x][y].setFlag();
    }


}
