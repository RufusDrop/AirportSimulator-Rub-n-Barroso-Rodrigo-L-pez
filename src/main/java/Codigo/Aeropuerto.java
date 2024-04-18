package Codigo;

import static java.lang.Math.random;
import java.util.Random;
import java.util.concurrent.Semaphore;

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
    private Semaphore puertas;
    
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
        puertas=new Semaphore(5,true);
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
    //Cubrir el caso de que no haya el maximo para que la concurrencia no haga dar fallo
    public void embarcar(Avion avion) throws InterruptedException {
        //Buscar una gate disponible ,gate1-gate5 incluidas
        PuertaEmbarque p;
        p=obtenerPuertaEmbarque();
        areaEstacionamiento.salirAreaEstacionamiento(avion);//Si no sirve , sacarlo dentro de puerta de embarque 
        p.embarcar(avion);
        if (personas>=avion.getCapacidadMaxima()){
            personas=personas-avion.getCapacidadMaxima();//Proteger!!!
            avion.subir(avion.getCapacidadMaxima());
            Thread.sleep(1000 + (int) (2000 * Math.random())); // Tiempo aleatorio entre 1 y 3 segundos
        }else {
            int pasajeros=0;
            pasajeros=personas;
            personas=personas-pasajeros;//Proteger!!!
            avion.subir(pasajeros);
            Thread.sleep(1000 + (int) (2000 * Math.random())); // Tiempo aleatorio entre 1 y 3 segundos
            int cont=0;
            while (!(avion.getCapacidadMaxima()==avion.getPasajeros()) && cont<2){
                int restante=avion.getCapacidadMaxima()-avion.getPasajeros();
                Thread.sleep(1000 + (int) (4000 * Math.random())); // Tiempo aleatorio entre 1 y 5 segundos
                if(personas >= restante){ 
                    personas=personas-restante;//Proteger!!!
                    avion.subir(restante);
                    Thread.sleep(1000 + (int) (2000 * Math.random())); // Tiempo aleatorio entre 1 y 3 segundos
                    cont=3;
                }else{
                    int pasajeros2=0;
                    pasajeros2=personas;
                    personas=personas-pasajeros2;//Proteger!!!
                    avion.subir(pasajeros2);
                    Thread.sleep(1000 + (int) (2000 * Math.random())); // Tiempo aleatorio entre 1 y 3 segundos
                    cont+=1;
                }
            }
        }
        p.desembarcar(avion);
        liberarPuertaEmbarque();
        
    }

    public void despegar(Avion avion) throws InterruptedException {
        areaRodaje.accederAreaRodaje(avion);
        Thread.sleep(1000 + (int) (4000 * Math.random())); // Tiempo aleatorio entre 1 y 5 segundos
        Pista p;
        p=obtenerPista();
        p.accederPista(avion);
        Thread.sleep(1000 + (int) (4000 * Math.random())); // Tiempo aleatorio entre 1 y 5 segundos
        //Despegue
        Thread.sleep(1000 + (int) (4000 * Math.random())); // Tiempo aleatorio entre 1 y 5 segundos
        p.abandonarPista(avion);
        salida.accederAerovia(avion);
        Thread.sleep(15000 + (int) (15000 * Math.random())); // Tiempo aleatorio entre 15 y 30 segundos
    }


    public void aterrizar(Avion avion) throws InterruptedException {
        while (true) {
            Pista pistaDisponible = obtenerPistaDisponible();
            if (pistaDisponible != null) {
                entrada.salirAerovia(avion);
                // Simulate landing
                Thread.sleep(1000 + (int) (4000 * Math.random())); // Tiempo aleatorio entre 1 y 5 segundos
                pistaDisponible.accederPista(avion);
                // Simulate landing process
                Thread.sleep(1000 + (int) (4000 * Math.random())); // Tiempo aleatorio entre 1 y 5 segundos
                // Desembarque del avión
                desembarcar(avion);
                break; // Avión ha aterrizado, salir del bucle
            } else {
                // No hay pistas disponibles, dar un rodeo al aeropuerto
                Thread.sleep(1000 + (int) (5000 * Math.random())); // Tiempo aleatorio entre 1 y 5 segundos
            }
        }
    }

    public void desembarcar(Avion avion) {
        
    }
    
    //si es true es inspeccion larga y si es false es revision
    public void inspeccion(Avion avion, boolean b) {
        
    }
    
    public PuertaEmbarque obtenerPuertaEmbarque() throws InterruptedException{
        //Mirar si estan ocupadas y devolver una 
        puertas.acquire();
        switch (1) {
            case 1:
                if (!gate1.estaOcupado()) {
                    return gate1;
                }
            case 2:
                if (!gate2.estaOcupado()) {
                    return gate2;
                }
            case 3:
                if (!gate3.estaOcupado()) {
                    return gate3;
                }
            case 4:
                if (!gate4.estaOcupado()) {
                    return gate4;
                }
            case 5:
                if (!gate5.estaOcupado()) {
                    return gate5;
                }
            case 6:
                if (!gate6.estaOcupado()) {
                    return gate6;
                }
            default:
                return null; // Si todas las puertas están ocupadas, devolvemos null

        }

    }
    
    //Suelta la puerta de embarque
    public void liberarPuertaEmbarque(){
        puertas.release();
    }
    
    public Pista obtenerPistaDisponible() {
        // Iterar sobre las pistas y verificar si alguna está disponible
        // Si encuentra una pista disponible, la devuelve
        // Si ninguna pista está disponible, devuelve null
        if (!pista1.estaOcupada()) {
            return pista1;
        } else if (!pista2.estaOcupada()) {
            return pista2;
        } else if (!pista3.estaOcupada()) {
            return pista3;
        } else if (!pista4.estaOcupada()) {
            return pista4;
        } else {
            return null;
        }
    }

    private Pista obtenerPista() {
        
        return null;
        
    }
}
