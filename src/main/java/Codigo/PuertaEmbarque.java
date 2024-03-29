package Codigo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PuertaEmbarque extends ZonaAeropuerto{
    private char funcion;// E embarque , D desembarque y M mixto
    private List<Thread> avion;
    private Lock control = new ReentrantLock();
    private Condition lleno = control.newCondition();
    private Condition vacio = control.newCondition();
    
    public PuertaEmbarque(){
        super(1);
        avion =  new CopyOnWriteArrayList<>();
    }
    
    // Devuelve true si ha sido posible embarcar y false si esta puerta no es de embarque
    public boolean embarcar(Avion a)throws InterruptedException{
        if (this.funcion == 'E' || this.funcion == 'M') { 
            control.lock();

            while (this.getCapacidadMaxima()== avion.size()){
                lleno.await();
            }
            try {    
                avion.add(a);
                vacio.signal();}
            finally{ 
                control.unlock();
                return true;}}
        else {return false;}
    }
    
    // Devuelve true si ha sido posible desembarcar y false si esta puerta no es de desembarque
    public boolean desembarcar(Avion a)throws InterruptedException{
        if (this.funcion == 'D' || this.funcion == 'M'){   
            control.lock();

            while (avion.size()==0){
                vacio.await();
            }
            try {    
                avion.remove(a);
                lleno.signal();}
            finally{ 
                control.unlock();
                return true;}}
        else {return false;}
    }
}
