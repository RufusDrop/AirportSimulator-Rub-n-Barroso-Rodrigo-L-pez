package Codigo;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Avion extends Thread{
    private String id;
    private int capacidadMaxima;
    private int pasajeros;
    private Aeropuerto aeropuertoActual;
    private Aeropuerto madrid;
    private Aeropuerto barcelona;
    private int numVuelos;
    private boolean ubicacion;//si es true el avión esta en el taller y si es false esta en el hangar(por defecto)

    
    public Avion (String id,int capacidadMaxima,Aeropuerto aeropuertoActual,Aeropuerto madrid,Aeropuerto barcelona){
        this.id=id;
        this.capacidadMaxima=capacidadMaxima;
        this.aeropuertoActual = aeropuertoActual;
        this.madrid = madrid;
        this.barcelona = barcelona;
        numVuelos=0;
        ubicacion=false;
        pasajeros=0;
    }
    
    public void run() {
        //si es false actua como spawn
        aeropuertoActual.accesoHangar(this);
        while (true) {
            try {
                aeropuertoActual.accederAreaEstacionamiento(this);
            
            aeropuertoActual.embarcar(this);
            aeropuertoActual.despegar(this);
            aeropuertoActual.aterrizar(this);
            aeropuertoActual.desembarcar(this);
            numVuelos++;
            if (numVuelos%15==0){
                // si es true es inspeccion larga y si es false es revision
                aeropuertoActual.inspeccion(this,true);
            }else{
                // si es true es inspeccion larga y si es false es revision
                aeropuertoActual.inspeccion(this,false);
            }
            Random random = new Random();
            if (random.nextDouble() < 0.5) {
                //si es true duerme 
                aeropuertoActual.accesoHangar(this);
            }else{
                //si no se queda en el taller
                ubicacion=true;
            }
            } catch (InterruptedException ex) {
                Logger.getLogger(Avion.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
        
        
    }
    
    public String getID() {
        return id;
    }
    
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
    
    public int getPasajeros() {
        return pasajeros;
    }
    
    public int getNumVuelos() {
        return numVuelos;
    }
    
    public boolean getUbicacion(){
        return ubicacion;
    }
    
    public void subir(int pasajeros){
        this.pasajeros=this.pasajeros+pasajeros;
    }
    
    public void bajar(){
        this.pasajeros=0;
    }
    
    public void cambiarAeropuerto() {
        if ("Madrid-Barajas".equals(this.aeropuertoActual.getNombre())) {
            this.aeropuertoActual = barcelona;
        } else if ("Barcelona-El Prat".equals(this.aeropuertoActual.getNombre())) {
            this.aeropuertoActual = madrid;
        }
    }
}
