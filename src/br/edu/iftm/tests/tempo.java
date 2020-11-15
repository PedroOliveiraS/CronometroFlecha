package br.edu.iftm.tests;
public class tempo implements Runnable {

    private boolean rodando = true;
    private boolean viva = true;
    private boolean reset = false;

    private Thread tempo;
    private int millisec = 0;
    private int secs = 58;
    private int mins = 9;
    private int hours = 3;
    Janela j = new Janela();

    public tempo() {

        
        new Thread(this).start();

    }

    @Override
    public void run() {

        if (this.viva) {
            j.setTimes(this.hours, this.mins, this.secs, this.millisec);
            while (this.rodando) {
                this.rodando = j.verificar();
                this.reset = j.verificar_stop();
                if(this.reset){
                    reset_all();
                }
                aguarde(this.tempo);
                this.secs += 1;
                if(this.secs >= 60){
                    this.secs = 0;
                    this.mins += 1;
                }else if (this.mins >= 60){
                    this.mins = 0;
                    this.hours += 1;
                }
                j.setTimes(this.hours, this.mins, this.secs, this.millisec);
                //System.out.println(this.hours +"/"+this.mins+"/"+this.secs+"/"+this.millisec);
            }
        }

    }
    //Função mais precisa em segundos
    /*public void aguarde(Thread t) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }*/

    //Função que conta miliseg mas com 2 milliseg de atraso
    public void aguarde(Thread t) {
        while(this.millisec < 1000){
            try {
                Thread.sleep(1);
                this.millisec += 1;
                j.setTimes(this.hours, this.mins, this.secs, this.millisec);
                //System.out.println(this.hours +"/"+this.mins+"/"+this.secs+"/"+this.millisec);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.millisec = 0;
    }

    public void reset_all(){
        if(this.reset ){
            this.millisec = 0;
            this.secs = 0;
            this.mins = 0;
            this.hours = 0;
            this.rodando = false;
            this.reset = false;
        }
    }
}