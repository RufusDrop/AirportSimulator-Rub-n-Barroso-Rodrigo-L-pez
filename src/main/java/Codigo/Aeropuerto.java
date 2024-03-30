package Codigo;

import static java.lang.Math.random;
import java.util.Random;

public class Aeropuerto {
    private String nombre;
    private int personas;
    private Hangar hangar;
    private Taller taller;
    private PuertaEmbarque gate1;
    private PuertaEmbarque gate2;
    private PuertaEmbarque gate3;
    private PuertaEmbarque gate4;
    private PuertaEmbarque gate5;
    private PuertaEmbarque gate6;
    private Pista pista1;
    private Pista pista2;
    private Pista pista3;
    private Pista pista4;
    private AreaEstacionamiento areaEstacionamiento;
    private AreaRodaje areaRodaje;
    private Aerovia entrada;
    private Aerovia salida;
    
    public Aeropuerto(String nombre,Aerovia entrada,Aerovia salida){
        this.nombre = nombre;
        personas = 0;
        hangar = new Hangar();
        taller = new Taller();
        gate1 = new PuertaEmbarque('M');
        gate2 = new PuertaEmbarque('M');
        gate3 = new PuertaEmbarque('M');
        gate4 = new PuertaEmbarque('M');
        gate5 = new PuertaEmbarque('E');
        gate6 = new PuertaEmbarque('D');
        pista1 = new Pista();
        pista2 = new Pista();
        pista3 = new Pista();
        pista4 = new Pista();
        areaEstacionamiento = new AreaEstacionamiento();
        areaRodaje = new AreaRodaje();
        this.entrada = entrada;
        this.salida = salida;
    }

    public void trasladoAeropuerto(Autobus bus) {
        // Lógica específica del traslado desde la ciudad al aeropuerto
        try {
            /// Llegada a la parada del centro de la ciudad, tiempo aleatorio entre 2 y 5 segundos
            Thread.sleep(2000 + (int) (3000 * Math.random())); // Tiempo aleatorio entre 2 y 5 segundos

            // Subida de pasajeros en la ciudad, número aleatorio entre 0 y 50 pasajeros
            int pasajerosSubidos = (int) (51 * Math.random());
            bus.agregarPasajeros(pasajerosSubidos);

            // Viaje hacia el aeropuerto, tiempo aleatorio entre 5 y 10 segundos
            Thread.sleep(5000 + (int) (6000 * Math.random())); // Tiempo aleatorio entre 5 y 10 segundos

            // Llegada a la parada del aeropuerto, tiempo aleatorio entre 2 y 5 segundos
            bus.quitarPasajeros(pasajerosSubidos);
            personas=personas+pasajerosSubidos;//Proteger!!!
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
    }

    public void trasladoCiudad(Autobus bus) {
        try {
            // Espera a que suban nuevos pasajeros durante un tiempo aleatorio entre 2 y 5 segundos
            Thread.sleep(2000 + (int) (3000 * Math.random())); // Tiempo aleatorio entre 2 y 5 segundos

            // Se montan en el autobús un número aleatorio entre 0 y 50 pasajeros
            int pasajerosMontados = (int) (51 * Math.random());
            bus.agregarPasajeros(pasajerosMontados);
            personas =personas- pasajerosMontados;//Proteger!!!

            // El autobús inicia su marcha en dirección al centro de la ciudad, tiempo aleatorio entre 5 y 10 segundos
            Thread.sleep(5000 + (int) (5000 * Math.random())); // Tiempo aleatorio entre 5 y 10 segundos

            // Llegada a la parada del centro de la ciudad, donde bajarán los pasajeros
            bus.quitarPasajeros(pasajerosMontados);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    //si es true duerme y si es false actua como spawn
    public void accesoHangar(Avion avion, boolean b) {
        if (b){
           // Proceso final de reinicio del ciclo del avión depsues de un vuelo
        }else{
           //Proceso despues de la generación del avión
           hangar.accederHangar(avion);
           
        }
    }
    
    public void accederAreaEstacionamiento(Avion avion) throws InterruptedException {
        if (avion.getUbicacion()){
            //El avion se encuentra en el taller
            taller.salirTaller(avion);
            areaEstacionamiento.accederAreaEstacionamiento(avion);
        }else{
            //El avion se encuentra en el hangar
            hangar.salirHangar(avion);
            areaEstacionamiento.accederAreaEstacionamiento(avion);
            
        }
    }
    
    //Espera en el area de estacionamiento hasta que haya una gate libre 
    public void embarcar(Avion avion) {
        //Buscar una gate disponible ,gate1-gate5 incluidas
        
    }

    public void accederAreaRodaje(Avion avion) {
        
    }

    public void despegar(Avion avion) {
        
    }

    public void aterrizar(Avion avion) {
        
    }

    public void desembarcar(Avion avion) {
        
    }
    
    //si es true es inspeccion larga y si es false es revision
    public void inspeccion(Avion avion, boolean b) {
        
    }
    
    public PuertaEmbarque obtenerPuertaEmbarque(){
        Random random = new Random();
        int gate = random.nextInt(5) + 1;
        
        // Switch para elegir una puerta según el número aleatorio
        switch (gate) {
            case 1:
                return gate1;
            case 2:
                return gate2;
            case 3:
                return gate3;
            case 4:
                return gate4;
            case 5:
                return gate5;
            default:
                return gate1;
                
        } 
    }
}
