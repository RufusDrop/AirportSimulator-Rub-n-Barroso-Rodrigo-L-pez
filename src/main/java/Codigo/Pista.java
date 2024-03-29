package Codigo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Pista extends ZonaAeropuerto{
    private boolean estado;// true para abierto y false para cerrado
    private List<Thread> avion;
    private Lock control = new ReentrantLock();
    private Condition lleno = control.newCondition();
    private Condition vacio = control.newCondition();
    
    public Pista(){
        super(1);
        avion =  new CopyOnWriteArrayList<>();
        estado=true;
    }
    
    // Devuelve true si ha sido posible aterrizar y false si esta la pista cerrada (no ha sido posible)
    public boolean aterrizar (Avion a)throws InterruptedException{
        if (this.estado ) { 
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
    
    // Devuelve true si ha sido posible despegar y false si esta la pista cerrada (no ha sido posible)
    public boolean despegar(Avion a)throws InterruptedException{
        if (this.estado ){   
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
    
    public boolean getEstado(){
        return estado;
    }
    
    public void setEstado(boolean estado){
        this.estado=estado;
    }
}
