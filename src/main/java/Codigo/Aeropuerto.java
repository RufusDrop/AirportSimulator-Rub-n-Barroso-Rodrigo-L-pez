package Codigo;

import static java.lang.Math.random;

public class Aeropuerto {
    private String nombre;
    private int personas;
    private Hangar hangar;
    private Taller taller;
    private PuertaEmbarque puerta1;
    private PuertaEmbarque puerta2;
    private PuertaEmbarque puerta3;
    private PuertaEmbarque puerta4;
    private PuertaEmbarque puerta5;
    private PuertaEmbarque puerta6;
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
        puerta1 = new PuertaEmbarque('M');
        puerta2 = new PuertaEmbarque('M');
        puerta3 = new PuertaEmbarque('M');
        puerta4 = new PuertaEmbarque('M');
        puerta5 = new PuertaEmbarque('E');
        puerta6 = new PuertaEmbarque('D');
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
        /*   Pendiente de implementarlo 
        // Llegada a la parada del centro de la ciudad
        Thread.sleep(random.nextInt(4) + 2); // Tiempo aleatorio entre 2 y 5 segundos

        // Subida de pasajeros en la ciudad
        int pasajerosSubidos = random.nextInt(51);
        System.out.println("Se suben " + pasajerosSubidos + " pasajeros al autobús " + identificador + ".");
        aeropuerto.agregarPasajeros(pasajerosSubidos);

        // Viaje hacia el aeropuerto
        System.out.println("Autobús " + identificador + " inicia su marcha hacia el aeropuerto.");
        Thread.sleep(random.nextInt(6) + 5); // Tiempo aleatorio entre 5 y 10 segundos

        // Llegada a la parada del aeropuerto
        System.out.println("Autobús " + identificador + " llega a la parada del aeropuerto de " + ciudad + ".");
        aeropuerto.quitarPasajeros(pasajerosSubidos);
        Thread.sleep(random.nextInt(4) + 2); // Tiempo aleatorio entre 2 y 5 segundos
        */    
    }

    public void trasladoCiudad(Autobus bus) {
        
    }

    public void accesoHangar(Avion aThis, boolean b) {
        
    }

    public void accederAreaEstacionamiento(Avion aThis) {
        
    }

    public void embarcar(Avion aThis) {
        
    }

    public void accederAreaRodaje(Avion aThis) {
        
    }

    public void despegar(Avion aThis) {
        
    }

    public void aterrizar(Avion aThis) {
        
    }

    public void desembarcar(Avion aThis) {
        
    }

    public void inspeccion(Avion aThis, boolean b) {
        
    }
    
}
