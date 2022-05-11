package com.company;

public class Cells {
    private boolean mina;
    private boolean rotated;
    private boolean flag;
    private int minas;

    public Cells(){
        mina=false;
        rotated=false;
        flag=false;
        minas=0;
    }

    public boolean isMina(){
        return (mina);
    }

    public boolean isUp(){
        return (rotated);
    }

    public int getMinas(){
        return (minas);
    }

    public boolean getFlag(){return flag;}


    public void setMina() {
        mina = true;
    }

    public void setMinas(){
        minas++;
    }

    public void setUp(){
        rotated=true;
    }

    public void setFlag(){
        flag=!flag;
    }

    public String show(){
        if (rotated){

            if(mina){
                return ("\033[41m X \u001B[0m");
            }else{
                switch (minas){
                    case 0:return ("\033[47m " + minas + " \u001B[0m");
                    case 1:return ("\033[44m " + minas + " \u001B[0m");
                    case 2:return ("\033[42m " + minas + " \u001B[0m");

                    default:return ("\033[45m " + minas + " \u001B[0m");
                }
            }

        }else if (flag){
            return ("\033[31m F \u001B[0m");
        }else{
            return ("   ");
        }
    }

}
