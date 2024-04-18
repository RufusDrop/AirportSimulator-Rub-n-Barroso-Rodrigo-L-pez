package Codigo;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Avion extends Thread{
    private String id;
    private int capacidadMaxima;
    private int pasajeros;
    private Aeropuerto aeropuerto1;
    private Aeropuerto aeropuerto2;
    private int numVuelos;
    private boolean ubicacion;//si es true el avión esta en el taller y si es false esta en el hangar(por defecto)

    
    public Avion (String id,int capacidadMaxima,Aeropuerto aeropuerto1,Aeropuerto aeropuerto2){
        this.id=id;
        this.capacidadMaxima=capacidadMaxima;
        this.aeropuerto1 = aeropuerto1;
        this.aeropuerto2 = aeropuerto2;
        numVuelos=0;
        ubicacion=false;
        pasajeros=0;
    }
    
    public void run() {
        //si es false actua como spawn
        aeropuerto1.accesoHangar(this,false);
        while (true) {
            try {
                aeropuerto1.accederAreaEstacionamiento(this);
            
            aeropuerto1.embarcar(this);
            aeropuerto1.despegar(this);
            aeropuerto2.aterrizar(this);
            aeropuerto2.desembarcar(this);
            numVuelos++;
            if (numVuelos%15==0){
                // si es true es inspeccion larga y si es false es revision
                aeropuerto2.inspeccion(this,true);
            }else{
                // si es true es inspeccion larga y si es false es revision
                aeropuerto2.inspeccion(this,false);
            }
            Random random = new Random();
            if (random.nextDouble() < 0.5) {
                //si es true duerme 
                aeropuerto2.accesoHangar(this,true);
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
    
    public void bajar(int pasajeros){
        this.pasajeros=0;
    }
}
