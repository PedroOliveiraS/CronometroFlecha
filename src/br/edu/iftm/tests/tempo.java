package br.edu.iftm.tests;
public class tempo implements Runnable {

    private boolean rodando = true;
    private boolean viva = true;
    private boolean reset = false;

    private Thread tempo;
    private long millisec = 0;
    private int secs = 0;
    private int mins = 0;
    private int hours = 0;
    Janela j = new Janela();

    public tempo() {

        new Thread(this).start();

    }

    public tempo(int horas,int minutos,int segundos, long millisegundos) {
        
        new Thread(this).start();
        this.hours = horas;
        this.mins = minutos;
        this.secs = segundos;
        this.millisec = millisegundos;

    }

    @Override
    public void run() {

        while (this.viva) {
            j.setTimes(this.hours, this.mins, this.secs, this.millisec);
            while (this.rodando) {
                this.rodando = j.verificar();
                this.reset = j.verificar_stop();
                if(this.reset){
                    reset_all();
                }

                aguarde(this.tempo);
                
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
    //Fun��o mais precisa em segundos
    /*public void aguarde(Thread t) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }*/

    //Fun��o que conta miliseg mas com 2 milliseg de atraso

    public void aguarde(Thread t) {
        while((this.millisec != 1000)&&(this.rodando)){
            try {
                
                Thread.sleep(1);
                this.millisec += 1;
                j.setTimes(this.hours, this.mins, this.secs, this.millisec);
                this.rodando = j.verificar();
                this.reset = j.verificar_stop();
                if(this.reset){
                    reset_all();
                }
                //System.out.println(this.hours +"/"+this.mins+"/"+this.secs+"/"+this.millisec);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(this.millisec == 1000){
            this.secs += 1;
            this.millisec = 0;
        }
        
    }

    public void reset_all(){
        
        this.millisec = 0;
        this.secs = 0;
        this.mins = 0;
        this.hours = 0;
        j.setTimes(this.hours, this.mins, this.secs, this.millisec);
        this.rodando = false;
        this.reset = false;
        
    }
}