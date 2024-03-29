package Codigo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Hangar extends ZonaAeropuerto {
    private List<Thread> aviones;
    private Lock control = new ReentrantLock();
            
    public Hangar(){
        super(Integer.MAX_VALUE);
        aviones =  new CopyOnWriteArrayList<>();
    }
    
    public int getCapacidadActual(){
        return aviones.size();
    }
    
    public void accederHangar(Avion a){
        try {
            control.lock();
            aviones.add(a);}
        finally{ 
            control.unlock();}    
    }
    
    public void salirHangar(Avion a){
        try {
            control.lock();
            aviones.remove(a);}
        finally{ 
            control.unlock();}    
    }
}
