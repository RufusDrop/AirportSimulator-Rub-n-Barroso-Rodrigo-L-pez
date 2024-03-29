package Codigo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;

public class AreaRodaje extends ZonaAeropuerto{
    private List<Thread> aviones;
    private Semaphore control =new Semaphore(1);
    
    public AreaRodaje(){
        super(Integer.MAX_VALUE);
        aviones =  new CopyOnWriteArrayList<>();
    }
    
    public int getCapacidadActual(){
        return aviones.size();
    }
    
    public void accederAreaRodaje(Avion a)throws InterruptedException{
        try {
            control.acquire();
            aviones.add(a);}
        finally{ 
            control.release();}    
    }
    
    public void salirAreaRodaje(Avion a)throws InterruptedException{
        try {
            control.acquire();
            aviones.remove(a);}
        finally{ 
            control.release();}    
    }
}