package Codigo;

public class Autobus extends Thread{
    private String id;
    private int pasajeros;
    private Aeropuerto aeropuerto;
    
    public Autobus(String id,int pasajeros, Aeropuerto aeropuerto) {
        this.id= id;
        this.pasajeros=pasajeros;
        this.aeropuerto = aeropuerto;
    }
    
    public void run(){
        while (true) {
            //Proceso de traslado de pasajeros desde la ciudad hasta el aeropuerto
            aeropuerto.trasladoAeropuerto(this);
            //Proceso de traslado de pasajeros desde el aeropuerto hasta la ciudad
            aeropuerto.trasladoCiudad(this);
        }
    }
    
    public String getID() {
        return id;
    }
    
    public int getPasajeros() {
        return pasajeros;
    }
}
