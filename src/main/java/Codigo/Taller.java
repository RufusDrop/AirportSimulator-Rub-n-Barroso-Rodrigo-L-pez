package Codigo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;

public class Taller extends ZonaAeropuerto {
    private List<Thread> aviones;
    private Semaphore vacio = new Semaphore(0,true);
    private Semaphore lleno;
    private Semaphore control =new Semaphore(1);
    
    public Taller(){
        super(20);
        aviones =  new CopyOnWriteArrayList<>();
        lleno = new Semaphore(this.getCapacidadMaxima(),true);
    }
    
    public int getCapacidadActual(){
        return aviones.size();
    }
    
    public void accederTaller(Avion a)throws InterruptedException{
        lleno.acquire();
        control.acquire(); //Bloqueo: Comienza SC
        aviones.add(a);
        control.release(); //Desbloqueo: Finaliza SC
        vacio.release();   
    }
    
    public void salirTaller(Avion a)throws InterruptedException{
        vacio.acquire();
        control.acquire(); //Bloqueo: Comienza SC
        aviones.remove(a);
        control.release(); //Desbloqueo: Finaliza SC
        lleno.release();
    }
}