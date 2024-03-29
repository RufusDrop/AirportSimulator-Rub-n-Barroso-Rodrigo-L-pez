package Codigo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;

public class AreaEstacionamiento extends ZonaAeropuerto{
    private List<Thread> aviones;
    private Semaphore control =new Semaphore(1);
    
    public AreaEstacionamiento(){
        super(Integer.MAX_VALUE);
        aviones = new CopyOnWriteArrayList<>();
    }
    
    public int getCapacidadActual(){
        return aviones.size();
    }
    
    public void accederAreaEstacionamiento(Avion a)throws InterruptedException{
        try {
            control.acquire();
            aviones.add(a);}
        finally{ 
            control.release();}    
    }
    
    public void salirAreaEstacionamiento(Avion a)throws InterruptedException{
        try {
            control.acquire();
            aviones.remove(a);}
        finally{ 
            control.release();}    
    }
}
