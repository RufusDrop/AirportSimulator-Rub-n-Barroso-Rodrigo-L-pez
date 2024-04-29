package Codigo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Pista extends ZonaAeropuerto{
    private boolean ocupado;//Si se esta usando esta en true
    private boolean estado;// true para abierto y false para cerrado
    private List<Thread> avion;
    private Lock control = new ReentrantLock();
    private Condition lleno = control.newCondition();
    private Condition vacio = control.newCondition();
    private  int numPista;
    
    public Pista(int numPista){
        super(1);
        avion =  new CopyOnWriteArrayList<>();
        estado=true;
        ocupado=false;
        this.numPista=numPista;
    }
    
    // Devuelve true si ha sido posible aterrizar y false si esta la pista cerrada (no ha sido posible)
    public boolean accederPista (Avion a)throws InterruptedException{
        if (this.estado && !ocupado) { 
            control.lock();

            while (this.getCapacidadMaxima()== avion.size()){
                lleno.await();
            }
            try {   
                ocupado=true;
                avion.add(a);
                vacio.signal();}
            finally{ 
                control.unlock();
                return true;}}
        else {return false;}
    }
    
    // Devuelve true si ha sido posible despegar y false si esta la pista cerrada (no ha sido posible)
    public boolean abandonarPista(Avion a)throws InterruptedException{
        if (this.estado ){   
            control.lock();

            while (avion.size()==0){
                vacio.await();
            }
            try {   
                avion.remove(a);
                ocupado=false;
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
        this.estado=estado;//Proteger!!
    }
    
    //Verifica el estado de la Puerta de embarque , devuelve true si esta ocupado
    public boolean estaOcupada() {
        return ocupado;
    }
    
        //Verifica el estado de la Puerta de embarque , devuelve true si esta ocupado
    public boolean estaAbierta() {
        return estado;
    }
    
    public int getNumPista() {
        return numPista;
    }
}
