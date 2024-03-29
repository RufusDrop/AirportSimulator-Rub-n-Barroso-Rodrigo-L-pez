package Codigo;

import java.util.Random;

public class Avion extends Thread{
    private String id;
    private int capacidadMaxima;
    private int capacidad;
    private Aeropuerto aeropuerto;
    private int numVuelos;

    
    public Avion (String id,int capacidad,Aeropuerto aeropuerto){
        this.id=id;
        this.capacidad=capacidad;
        this.aeropuerto = aeropuerto;
        numVuelos=0;
    }
    
    public void run() {
        aeropuerto.accesoHangar(this,false);//si es false actua como spawn
        while (true) {
            aeropuerto.accederAreaEstacionamiento(this);
            aeropuerto.embarcar(this);
            aeropuerto.accederAreaRodaje(this);
            aeropuerto.despegar(this);
            aeropuerto.aterrizar(this);
            aeropuerto.desembarcar(this);
            numVuelos++;
            if (numVuelos%15==0){
                aeropuerto.inspeccion(this,true);// si es true en inspeccion larga y si es false es revision
            }else{
                aeropuerto.inspeccion(this,false);//si es true en inspeccion larga y si es false es revision
            }
            Random random = new Random();
            if (random.nextDouble() < 0.5) {
                aeropuerto.accesoHangar(this,true);//si es true duerme 
            }
       }
        
        
    }
    
    public String getID() {
        return id;
    }
    
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
    
    public int getCapacidad() {
        return capacidad;
    }
    
    public int getNumVuelos() {
        return numVuelos;
    }
}
