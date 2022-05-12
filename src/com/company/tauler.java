package com.company;

public class tauler {

    private final Cells[][] tablero;
    private int totalMinas;
    private static int col;
    private static int row;

    private int totalUp;
    private int totalFlags;

    public tauler(){

        int[] dif=interaction.dificulty();
        setTotalMinas(dif[0]);
        setCol(dif[1]);
        setRow(dif[2]);

        tablero = new Cells[col][row];

        totalUp =0;
        totalFlags=0;

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                tablero[i][j] = new Cells();
            }
        }

    }

    public int getCol(){return col;}
    public int getRow(){return row;}

    public Cells getCell(int x, int y){
        return tablero[x][y];
    }

    public boolean isMina(int x, int y){
        return tablero[x][y].isMina();
    }

    public boolean isUp(int x, int y){
        return tablero[x][y].isUp();
    }

    public int getMinasArround(int x, int y){
        return tablero[x][y].getMinasArround();
    }

    public int getTotalMinas(){return totalMinas;}
    public int getTotalFlags(){return totalFlags;}

    public int getTotalUp(){return totalUp;}



    public void setMina(int x, int y){
        tablero[x][y].setMina();
    }

    public void sumMinas(int x, int y){
        tablero[x][y].setMinas();
    }

    public void setUp(int x, int y){
        totalUp++;
        tablero[x][y].setUp();
    }

    public void setFlag(int x, int y){
        totalFlags += (tablero[x][y].isFlag())? -1:1;
        tablero[x][y].setFlag();
    }

    public int getRestantes(){
        return (col*row)-totalMinas;
    }


    public void setCol(int c){col=c;}
    public void setRow(int r){row=r;}
    public void setTotalMinas(int m){totalMinas=m;}



    public boolean dentroRango(int x ,int y){
        return  ( x>=0 && x<col && y>=0 && y<row );
    }
}
