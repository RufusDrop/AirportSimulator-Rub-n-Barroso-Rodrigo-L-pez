package Codigo;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Avion extends Thread{
    private String id;
    private int capacidadMaxima;
    private int pasajeros;
    private Aeropuerto aeropuerto;
    private int numVuelos;
    private boolean ubicacion;//si es true el avión esta en el taller y si es false esta en el hangar(por defecto)

    
    public Avion (String id,int pasajeros,Aeropuerto aeropuerto){
        this.id=id;
        this.pasajeros=pasajeros;
        this.aeropuerto = aeropuerto;
        numVuelos=0;
        ubicacion=false;
    }
    
    public void run() {
        //si es false actua como spawn
        aeropuerto.accesoHangar(this,false);
        while (true) {
            try {
                aeropuerto.accederAreaEstacionamiento(this);
            } catch (InterruptedException ex) {
                Logger.getLogger(Avion.class.getName()).log(Level.SEVERE, null, ex);
            }
            aeropuerto.embarcar(this);
            aeropuerto.accederAreaRodaje(this);
            aeropuerto.despegar(this);
            aeropuerto.aterrizar(this);
            aeropuerto.desembarcar(this);
            numVuelos++;
            if (numVuelos%15==0){
                // si es true es inspeccion larga y si es false es revision
                aeropuerto.inspeccion(this,true);
            }else{
                // si es true es inspeccion larga y si es false es revision
                aeropuerto.inspeccion(this,false);
            }
            Random random = new Random();
            if (random.nextDouble() < 0.5) {
                //si es true duerme 
                aeropuerto.accesoHangar(this,true);
            }else{
                //si no se queda en el taller
                ubicacion=true;
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
    
}
