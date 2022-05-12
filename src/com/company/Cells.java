package com.company;

public class Cells {
    private boolean mina;
    private boolean rotated;
    private boolean flag;
    private int minasArround;

    public Cells(){
        mina=false;
        rotated=false;
        flag=false;
        minasArround =0;
    }

    public boolean isMina(){
        return (mina);
    }

    public boolean isUp(){
        return (rotated);
    }

    public boolean isFlag(){return flag;}

    public int getMinasArround(){
        return (minasArround);
    }


    public void setMina() {
        mina = true;
    }

    public void setMinas(){
        minasArround++;
    }

    public void setUp(){
        rotated=true;
    }

    public void setFlag(){
        // compt flags
        flag=!flag;
    }

    public String show(){
        if (rotated){

            if(mina){
                return ("\033[41m X \u001B[0m");
            }else{
                switch (minasArround){
                    case 0:return ("\033[47m " + minasArround + " \u001B[0m");
                    case 1:return ("\033[44m " + minasArround + " \u001B[0m");
                    case 2:return ("\033[42m " + minasArround + " \u001B[0m");

                    default:return ("\033[45m " + minasArround + " \u001B[0m");
                }
            }

        }else if (flag){
            return ("\033[31m F \u001B[0m");
        }else{
            return ("   ");
        }
    }

}
