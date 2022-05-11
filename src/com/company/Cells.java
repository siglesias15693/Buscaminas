package com.company;

public class Cells {
    private boolean mina;
    private boolean rotated;
    private boolean flag;
    private int minas;

    public Cells(){
        this.mina=false;
        this.rotated=false;
        this.flag=false;
        this.minas=0;
    }

    public boolean isMina(){
        return (this.mina);
    }

    public boolean isUp(){
        return (this.rotated);
    }

    public int getMinas(){
        return (this.minas);
    }

    public boolean getFlag(){return flag;}


    public void setMina() {
        this.mina = true;
    }

    public void setMinas(){
        this.minas++;
    }

    public void setUp(){
        this.rotated=true;
    }

    public void setFlag(){
        this.flag=!flag;
    }
}
