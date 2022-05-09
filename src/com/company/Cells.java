package com.company;

public class Cells {
    private boolean mina;
    private boolean arriva;
    private int minas;

    public Cells(){
        this.mina=false;
        this.arriva=false;
        this.minas=0;
    }

    public boolean isMina(){
        return (this.mina);
    }

    public boolean isUp(){
        return (this.arriva);
    }

    public int getMinas(){
        return (this.minas);
    }

    public void setMina() {
        this.mina = true;
    }

    public void setMinas(){
        this.minas++;
    }

    public void setUp(){
        this.arriva=true;
    }
}