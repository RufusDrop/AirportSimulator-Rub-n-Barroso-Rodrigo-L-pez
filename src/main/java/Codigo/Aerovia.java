package Codigo;

import Interfaces.VentanaPrincipal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;

public class Aerovia extends ZonaAeropuerto{
    private List<Avion> aviones;
    private Semaphore control =new Semaphore(1);
    private VentanaPrincipal ventana;
    
    public Aerovia(VentanaPrincipal ventana){
        super(Integer.MAX_VALUE);
        aviones =  new CopyOnWriteArrayList<>();
        this.ventana = ventana;
    }
    
    public int getCapacidadActual(){
        return aviones.size();
    }
    
    public void accederAerovia(Avion a)throws InterruptedException{
        try {
            control.acquire();
            aviones.add(a);}
        finally{ 
            control.release();}    
    }
    
    public void salirAerovia(Avion a)throws InterruptedException{
        try {
            control.acquire();
            aviones.remove(a);}
        finally{ 
            control.release();}    
    }
    
    public List<Avion> getAviones(){
        return aviones;
    }
}
