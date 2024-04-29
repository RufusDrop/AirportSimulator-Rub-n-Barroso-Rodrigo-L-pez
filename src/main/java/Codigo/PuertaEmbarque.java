package Codigo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;


public class PuertaEmbarque extends ZonaAeropuerto{
    private boolean ocupado;//Si se esta usando esta en true 
    private char funcion;// E embarque , D desembarque y M mixto
    private List<Thread> avion;
    private Semaphore control;
    private Semaphore lleno;
    private Semaphore vacio;
    private int numGate;
    
    public PuertaEmbarque(char funcion,int numGate){
        super(1);
        avion =  new CopyOnWriteArrayList<>();
        this.funcion=funcion;
        control= new Semaphore(1);
        lleno= new Semaphore(1,true);
        vacio= new Semaphore(0,true);
        ocupado=false;
        this.numGate=numGate;
    }
    
    // Devuelve true si ha sido posible embarcar y false si esta puerta no es de embarque
    public boolean embarcar(Avion a)throws InterruptedException{
        if (this.funcion == 'E' || this.funcion == 'M' && !ocupado) { 
            lleno.acquire();
            try {
                control.acquire();//Bloqueo para modificar
                ocupado=true;
                avion.add(a);
                }
            finally{ 
                control.release();//Desbloqueo tras modifiar
                vacio.release();
                return true;}}
        else {return false;}
    }
    
    public boolean terminar_embarque(Avion a)throws InterruptedException{
        if (this.funcion == 'E' || this.funcion == 'M'){   
            vacio.acquire();
            try {
                control.acquire();//Bloqueo para modificar
                avion.remove(a);
                ocupado=false;
                }
            finally{ 
                control.release();//Desbloqueo tras modifiar
                lleno.release();
                return true;}}
        else {return false;}
    }
    
    public boolean desembarcar(Avion a)throws InterruptedException{
        if (this.funcion == 'D' || this.funcion == 'M' && !ocupado) { 
            lleno.acquire();
            try {
                control.acquire();//Bloqueo para modificar
                ocupado=true;
                avion.add(a);
                }
            finally{ 
                control.release();//Desbloqueo tras modifiar
                vacio.release();
                return true;}}
        else {return false;}
    }
    
    // Devuelve true si ha sido posible desembarcar y false si esta puerta no es de desembarque
    public boolean terminar_desembarque(Avion a)throws InterruptedException{
        if (this.funcion == 'D' || this.funcion == 'M'){   
            vacio.acquire();
            try {
                control.acquire();//Bloqueo para modificar
                avion.remove(a);
                ocupado=false;
                }
            finally{ 
                control.release();//Desbloqueo tras modifiar
                lleno.release();
                return true;}}
        else {return false;}
    }
    
    //Verifica el estado de la Puerta de embarque , devuelve true si esta ocupado
    public boolean estaOcupado() {
        return ocupado;
    }
    
    public int getNumGate() {
        return numGate;
    }
}
