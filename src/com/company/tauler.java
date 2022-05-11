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


}
