package Codigo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PuertaEmbarque extends ZonaAeropuerto{
    private char funcion;
    private List<Thread> avion;
    private Lock control = new ReentrantLock();
    private Condition lleno = control.newCondition();
    private Condition vacio = control.newCondition();
    
    public PuertaEmbarque(){
        super(1);
        avion = new ArrayList<>();
    }
    
    public void embarcar(Avion a)throws InterruptedException{
        control.lock();
        
        while (this.getCapacidadMaxima()== avion.size()){
            lleno.await();
        }
        try {    
            avion.add(a);
            vacio.signal();}
        finally{ 
            control.unlock();}    
    }
    
    public void desembarcar(Avion a)throws InterruptedException{
        control.lock();
        
        while (avion.size()==0){
            vacio.await();
        }
        try {    
            avion.remove(a);
            lleno.signal();}
        finally{ 
            control.unlock();}    
    }
}
