package Codigo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Pista extends ZonaAeropuerto{
    private boolean ocupado;//Si se esta usando esta en true
    private boolean estado;// true para abierto y false para cerrado
    private Lock control = new ReentrantLock();
    private  int numPista;
    
    public Pista(int numPista){
        super(1);
        estado=true;
        ocupado=false;
        this.numPista=numPista;
    }

    public boolean getEstado(){
        control.lock();
        try {
            return estado;
        } finally {
            control.unlock();
        }
    }
    
    public void setEstado(boolean estado) {
        control.lock();
        try {
            this.estado = estado;
        } finally {
            control.unlock();
        }
    }
    public void setOcupado(boolean ocupado) {
        control.lock();
        try{
        this.ocupado=ocupado;
        }finally{control.unlock();}
    }
    //Verifica el estado de la Puerta de embarque , devuelve true si esta ocupado
    public boolean getOcupado() {
        return ocupado;
    }
    
    
    public int getNumPista() {
        return numPista;
    }
}
