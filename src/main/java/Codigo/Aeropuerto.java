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
    private Semaphore pistas;
    private Log log ;
    private Semaphore control;
    
    public Aeropuerto(String nombre,Aerovia entrada,Aerovia salida,Log log){
        this.nombre = nombre;
        personas = 0;
        hangar = new Hangar();
        taller = new Taller();
        gate1 = new PuertaEmbarque('M',1);
        gate2 = new PuertaEmbarque('M',2);
        gate3 = new PuertaEmbarque('M',3);
        gate4 = new PuertaEmbarque('M',4);
        gate5 = new PuertaEmbarque('E',5);
        gate6 = new PuertaEmbarque('D',6);
        pista1 = new Pista(1);
        pista2 = new Pista(2);
        pista3 = new Pista(3);
        pista4 = new Pista(4);
        areaEstacionamiento = new AreaEstacionamiento();
        areaRodaje = new AreaRodaje();
        this.entrada = entrada;
        this.salida = salida;
        puertas=new Semaphore(5,true);
        pistas=new Semaphore(4,true);
        this.log= log;
        control=new Semaphore(1);
    }

    public void trasladoAeropuerto(Autobus bus) {
        // Lógica específica del traslado desde la ciudad al aeropuerto
        try {
            /// Llegada a la parada del centro de la ciudad, tiempo aleatorio entre 2 y 5 segundos
            Thread.sleep(2000 + (int) (3000 * Math.random())); // Tiempo aleatorio entre 2 y 5 segundos
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre, "Llegada del autobus "+ bus.getID() +" a la parada del centro de "+this.nombre);

            // Subida de pasajeros en la ciudad, número aleatorio entre 0 y 50 pasajeros
            int pasajerosSubidos = (int) (51 * Math.random());
            bus.agregarPasajeros(pasajerosSubidos);
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre, "Autobus "+ bus.getID() +" recoge "+pasajerosSubidos+" pasajeros ");

            // Viaje hacia el aeropuerto, tiempo aleatorio entre 5 y 10 segundos
            Thread.sleep(5000 + (int) (6000 * Math.random())); // Tiempo aleatorio entre 5 y 10 segundos
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre, "Llegada del autobus "+ bus.getID() +" al aeropuerto  de "+this.nombre);

            // Llegada a la parada del aeropuerto, tiempo aleatorio entre 2 y 5 segundos
            bus.quitarPasajeros(pasajerosSubidos);
            control.acquire();
            personas=personas+pasajerosSubidos;
            control.release();
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre, "Autobus "+ bus.getID() +" deja "+pasajerosSubidos+" pasajeros en el aeropuerto de "+this.nombre);
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre, "Hay "+personas+" personas en el aeropuerto");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
    }

    public void trasladoCiudad(Autobus bus) {
        try {
            // Espera a que suban nuevos pasajeros durante un tiempo aleatorio entre 2 y 5 segundos
            Thread.sleep(2000 + (int) (3000 * Math.random())); // Tiempo aleatorio entre 2 y 5 segundos
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre, "Llegada del autobus "+ bus.getID() +" al aeropuerto de  "+this.nombre);

            // Se montan en el autobús un número aleatorio entre 0 y 50 pasajeros
            int pasajerosMontados = (int) (51 * Math.random());
            bus.agregarPasajeros(Math.min(pasajerosMontados,personas));
            control.acquire();
            personas =personas- Math.min(pasajerosMontados,personas);
            control.release();
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre, "Autobus "+ bus.getID() +" retira "+Math.min(pasajerosMontados,personas)+" pasajeros del aeropuerto de "+this.nombre);
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre, "Hay "+personas+" personas en el aeropuerto");
            
            // El autobús inicia su marcha en dirección al centro de la ciudad, tiempo aleatorio entre 5 y 10 segundos
            Thread.sleep(5000 + (int) (5000 * Math.random())); // Tiempo aleatorio entre 5 y 10 segundos
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre, "Llegada del autobus "+ bus.getID() +" al centro de  "+this.nombre);
            
            // Llegada a la parada del centro de la ciudad, donde bajarán los pasajeros
            bus.quitarPasajeros(pasajerosMontados);
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre, "Se bajan "+pasajerosMontados +" pasajeros del autobus "+ bus.getID() );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    //si es true duerme y si es false actua como spawn
    public void accesoHangar(Avion avion) {
        hangar.accederHangar(avion);
        log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de entrar  al hangar ");
    }
    
    public void accederAreaEstacionamiento(Avion avion) throws InterruptedException {
        if (avion.getUbicacion()){
            //El avion viene del taller
            areaEstacionamiento.accederAreaEstacionamiento(avion);
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de entrar al Área de Estacionamiento");
        }else{
            //El avion se encuentra en el hangar
            hangar.salirHangar(avion);
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de salir del Hangar");
            areaEstacionamiento.accederAreaEstacionamiento(avion);
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de entrar al Área de Estacionamiento");
        }
    }
    
    
    public void embarcar(Avion avion) throws InterruptedException {
        PuertaEmbarque p;
        p = obtenerPuertaEmbarque(true);//Posible error si retorna null
        areaEstacionamiento.salirAreaEstacionamiento(avion);
        log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de salir del Área de Estacionamiento");
        
        p.embarcar(avion);
        log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" está empezando a embarcar");
        
        int pasajerosEmbarcados = Math.min(avion.getCapacidadMaxima(), personas);
        log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de embarcar "+pasajerosEmbarcados+" pasajeros");
        control.acquire();
        personas -= pasajerosEmbarcados;
        control.release();
        avion.subir(pasajerosEmbarcados);
        log.writeLog("PRUEBA:Aeropuerto "+ this.nombre, "Hay "+personas+" personas en el aeropuerto");
        Thread.sleep(1000 + (int) (2000 * Math.random())); // Tiempo aleatorio entre 1 y 3 segundos

        int intentos = 0;
        while (avion.getPasajeros() < avion.getCapacidadMaxima() && personas > 0 && intentos < 3) {

            Thread.sleep(1000 + (int) (4000 * Math.random())); // Tiempo aleatorio entre 1 y 5 segundos

            int restante = avion.getCapacidadMaxima() - avion.getPasajeros();
            int pasajeros = Math.min(restante, personas);
            control.acquire();
            personas -= pasajeros;
            control.release();
            avion.subir(pasajeros);
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"Al avión "+ avion.getID() +" se acaban de subir "+pasajeros+" pasajeros más");
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre, "Hay "+personas+" personas en el aeropuerto");
            Thread.sleep(1000 + (int) (2000 * Math.random())); // Tiempo aleatorio entre 1 y 3 segundos

            intentos++;
        }
    
        p.terminar_embarque(avion);
        log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" ha terminnado de embarcar");
        liberarPuertaEmbarque();
    }


    public void despegar(Avion avion) throws InterruptedException {
        areaRodaje.accederAreaRodaje(avion);
        log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de entrar al Área de Rodaje");
        Thread.sleep(1000 + (int) (4000 * Math.random())); // Tiempo aleatorio entre 1 y 5 segundos
        Pista p;
        
        // Bucle para intentar obtener una pista disponible
        do {
            p = obtenerPista();
            if (p == null) {
                Thread.sleep(1000); // Esperar 1 segundo antes de volver a intentar obtener una pista
            }
        } while (p == null);
        
        areaRodaje.salirAreaRodaje(avion);
        log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de salir del Área de Rodaje");
        p.accederPista(avion);
        log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de entrar a la Pista "+p.getNumPista());
        Thread.sleep(1000 + (int) (4000 * Math.random())); // Tiempo aleatorio entre 1 y 5 segundos
        
        //Despegue
        Thread.sleep(1000 + (int) (4000 * Math.random())); // Tiempo aleatorio entre 1 y 5 segundos
        p.abandonarPista(avion);
        log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de despegar del aeropuerto de "+this.nombre);
        liberarPista();
        salida.accederAerovia(avion);
        log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de acceder a la Aerovía");
        
        //Cambiar el aeropuerto en avion
        avion.cambiarAeropuerto();
        Thread.sleep(15000 + (int) (15000 * Math.random())); // Tiempo aleatorio entre 15 y 30 segundos
    }

    
    public void aterrizar(Avion avion) throws InterruptedException {
        while (true) {
            Pista pistaDisponible = obtenerPista();
            if (pistaDisponible != null) {
                entrada.salirAerovia(avion);
                log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de salir de la Aerovía ");
                
                // aterrizaje
                Thread.sleep(1000 + (int) (4000 * Math.random())); // Tiempo aleatorio entre 1 y 5 segundos
                pistaDisponible.accederPista(avion);
                log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de aterrizar en el aeropuerto de "+this.nombre);
                Thread.sleep(1000 + (int) (4000 * Math.random())); // Tiempo aleatorio entre 1 y 5 segundos
                
                pistaDisponible.abandonarPista(avion);
                log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de abandonar la Pista "+pistaDisponible.getNumPista());
                liberarPista();
                break; // Avión ha aterrizado, salir del bucle
            } else {
                // No hay pistas disponibles, dar un rodeo al aeropuerto
                Thread.sleep(1000 + (int) (5000 * Math.random())); // Tiempo aleatorio entre 1 y 5 segundos
            }
        }
    }

    public void desembarcar(Avion avion) throws InterruptedException {
        areaRodaje.accederAreaRodaje(avion);
        log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de entrar al Área de Rodaje");
        Thread.sleep(3000 + (int) (2000 * Math.random())); // Tiempo aleatorio entre 3 y 5 segundos
        
        PuertaEmbarque p;
        p=obtenerPuertaEmbarque(false);
        areaRodaje.salirAreaRodaje(avion);
        log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de salir del Área de Rodaje");
        p.desembarcar(avion);
        log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de acceder a la Puerta de Embarque "+p.getNumGate());
        
        //Se bajan los pasajeros
        log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de bajar a todos los pasajeros");
        control.acquire();
        personas += avion.getPasajeros();
        control.release();
        log.writeLog("PRUEBA:Aeropuerto "+ this.nombre, "Hay "+personas+" personas en el aeropuerto");
        
        avion.bajar();
        Thread.sleep(1000 + (int) (4000 * Math.random())); // Tiempo aleatorio entre 1 y 5 segundos
        p.terminar_desembarque(avion);
        log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de abandonar la Puerta de Embarque "+p.getNumGate());
        liberarPuertaEmbarque();
        areaEstacionamiento.accederAreaEstacionamiento(avion);
        log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de acceder al Área de Estacionamiento");
        Thread.sleep(1000 + (int) (4000 * Math.random())); // Tiempo aleatorio entre 1 y 5 segundos
    }
    
    //si es true es inspeccion larga y si es false es revision
    public void inspeccion(Avion avion, boolean b) throws InterruptedException {
        if (b){
            areaEstacionamiento.salirAreaEstacionamiento(avion);
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de salir del Área de Estacionamiento");
            //Inspeccion larga 
            taller.accederTaller(avion);
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de acceder al Taller");
            //Tiempo acceso taller
            Thread.sleep(1000); // Tiempo de un segundo
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" está pasando la inspección");
            //Tiempo revisión
            Thread.sleep(5000 + (int) (5000 * Math.random())); // Tiempo aleatorio entre 5 y 10 segundos
            taller.salirTaller(avion);
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de salir del Taller");
            //Tiempo salida taller
            Thread.sleep(1000); // Tiempo de un segundo
        }else{
            areaEstacionamiento.salirAreaEstacionamiento(avion);
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de salir del Área de Estacionamiento");
            //Inspeccion corta 
            taller.accederTaller(avion);
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de acceder al Taller");
            //Tiempo acceso taller
            Thread.sleep(1000); // Tiempo de un segundo
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" está pasando la revisión");
            //Tiempo revisión
            Thread.sleep(1000 + (int) (4000 * Math.random())); // Tiempo aleatorio entre 1 y 5 segundos
            taller.salirTaller(avion);
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de salir del Taller");
            //Tiempo salida taller
            Thread.sleep(1000); // Tiempo de un segundo
        }
    }
    
    public PuertaEmbarque obtenerPuertaEmbarque(boolean tipo) throws InterruptedException {
        // Si tipo es true es embarque y si es false es desembarque
        puertas.acquire();

        if (!gate1.estaOcupado()) {
            return gate1;
        } else if (!gate2.estaOcupado()) {
            return gate2;
        } else if (!gate3.estaOcupado()) {
            return gate3;
        } else if (!gate4.estaOcupado()) {
            return gate4;
        } else {
            if (tipo) {
                if (!gate5.estaOcupado()) {
                    return gate5;
                } else {
                    return null; // Si todas las puertas están ocupadas, devolvemos null
                }
            } else {
                if (!gate6.estaOcupado()) {
                    return gate6;
                } else {
                    return null; // Si todas las puertas están ocupadas, devolvemos null
                }
            }
        }
    }


    
    //Suelta la puerta de embarque
    public void liberarPuertaEmbarque(){
        puertas.release();
    }
    

    private Pista obtenerPista() throws InterruptedException {
        pistas.acquire();
        
        if (!pista1.estaOcupada() && pista1.estaAbierta()) {
            return pista1;
        } else if (!pista2.estaOcupada() && pista2.estaAbierta()) {
            return pista2;
        } else if (!pista3.estaOcupada() && pista3.estaAbierta()) {
            return pista3;
        } else if (!pista4.estaOcupada() && pista4.estaAbierta()) {
            return pista4;
        } else {
            return null;
        }
        
    }
    
    //Suelta la puerta de embarque
    public void liberarPista(){
        pistas.release();
    }
    
    public String getNombre(){
        return nombre;
    }
    
    //Espera en el area de estacionamiento hasta que haya una gate libre 
    //Cubrir el caso de que no haya el maximo para que la concurrencia no haga dar fallo
    /*public void embarcar(Avion avion) throws InterruptedException {
        //Buscar una gate disponible ,gate1-gate5 incluidas
        PuertaEmbarque p;
        p=obtenerPuertaEmbarque(true);
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
        p.terminar_embarque(avion);
        liberarPuertaEmbarque();
        
    }*/
    
    /*public Pista obtenerPistaDisponible() {
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
    }*/
    /*private PuertaEmbarque obtenerPuertaDesmbarque() throws InterruptedException {
        // Mirar si están ocupadas y devolver una 
        puertas2.acquire();

        if (!gate1.estaOcupado()) {
            return gate1;
        } else if (!gate2.estaOcupado()) {
            return gate2;
        } else if (!gate3.estaOcupado()) {
            return gate3;
        } else if (!gate4.estaOcupado()) {
            return gate4;
        } else if (!gate5.estaOcupado()) {
            return gate5;
        } else {
            return null; // Si todas las puertas están ocupadas, devolvemos null
        }
    }*/

    
    /*//Suelta la puerta de embarque
    public void liberarPuertaDesmbarque(){
        puertas2.release();
    }*/
    

}
