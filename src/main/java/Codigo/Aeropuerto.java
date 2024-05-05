package Codigo;

import Interfaces.VentanaPrincipal;
import static java.lang.Math.random;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.DefaultListModel;

public class Aeropuerto {
    private String nombre;
    private int personas;
    private int id;
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
    private SafeSemaphore puertas;
    private SafeSemaphore pistas;
    private Log log ;
    private SafeSemaphore control;
    private VentanaPrincipal ventana;
    private GestorEstadoPrograma gestorEstado;
    private SafeSemaphore embarque;
    private SafeSemaphore desembarque;
    private SafeSemaphore mixtas;
    
    public Aeropuerto(String nombre,int id,Aerovia entrada,Aerovia salida,Log log,VentanaPrincipal ventana,GestorEstadoPrograma gestorEstado){
        this.nombre = nombre;
        this.id = id;
        this.personas = 0;
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
        puertas=new SafeSemaphore(6,true,gestorEstado);
        pistas=new SafeSemaphore(4,true,gestorEstado);
        this.log= log;
        control=new SafeSemaphore(1,true,gestorEstado);
        embarque = new SafeSemaphore(5,true,gestorEstado);
        desembarque = new SafeSemaphore(5,gestorEstado);
        mixtas = new SafeSemaphore(4,gestorEstado);
        this.ventana = ventana;
        this.gestorEstado = gestorEstado;
    }

    public void trasladoAeropuerto(Autobus bus){
        // Lógica específica del traslado desde la ciudad al aeropuerto
        try {
            gestorEstado.verificarEstado();
            /// Llegada a la parada del centro de la ciudad, tiempo aleatorio entre 2 y 5 segundos
            safeSleep(2000 + (int) (3000 * Math.random())); // Tiempo aleatorio entre 2 y 5 segundos
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre, "Llegada del autobus "+ bus.getID() +" a la parada del centro de "+this.nombre);
            
            gestorEstado.verificarEstado();
            // Subida de pasajeros en la ciudad, número aleatorio entre 0 y 50 pasajeros
            int pasajerosSubidos = (int) (51 * Math.random());
            bus.agregarPasajeros(pasajerosSubidos);
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre, "Autobus "+ bus.getID() +" recoge "+pasajerosSubidos+" pasajeros ");
            
            gestorEstado.verificarEstado();
            // Viaje hacia el aeropuerto, tiempo aleatorio entre 5 y 10 segundos
            safeSleep(5000 + (int) (6000 * Math.random())); // Tiempo aleatorio entre 5 y 10 segundos
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre, "Llegada del autobus "+ bus.getID() +" al aeropuerto  de "+this.nombre);
            
            gestorEstado.verificarEstado();
            // Llegada a la parada del aeropuerto, tiempo aleatorio entre 2 y 5 segundos
            bus.quitarPasajeros(pasajerosSubidos);
            control.safeAcquire();
            personas=personas+pasajerosSubidos;
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre, "Autobus "+ bus.getID() +" deja "+pasajerosSubidos+" pasajeros en el aeropuerto de "+this.nombre);
            ventana.actualizarTransfersAeropuerto(bus.getID()+"("+pasajerosSubidos+")",id);
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre, "Hay "+personas+" personas en el aeropuerto de "+this.nombre);
            ventana.actualizarPasajeros(personas,id);
            control.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
    }

    public void trasladoCiudad(Autobus bus){
        try {
            gestorEstado.verificarEstado();
            // Espera a que suban nuevos pasajeros durante un tiempo aleatorio entre 2 y 5 segundos
            safeSleep(2000 + (int) (3000 * Math.random())); // Tiempo aleatorio entre 2 y 5 segundos
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre, "Llegada del autobus "+ bus.getID() +" al aeropuerto de  "+this.nombre);
            
            gestorEstado.verificarEstado();
            // Se montan en el autobús un número aleatorio entre 0 y 50 pasajeros
            int pasajerosMontados = (int) (51 * Math.random());
            bus.agregarPasajeros(Math.min(pasajerosMontados,personas));
            control.safeAcquire();
            personas =personas- Math.min(pasajerosMontados,personas);
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre, "Autobus "+ bus.getID() +" retira "+Math.min(pasajerosMontados,personas)+" pasajeros del aeropuerto de "+this.nombre);
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre, "Hay "+personas+" personas en el aeropuerto de "+this.nombre);
            ventana.actualizarPasajeros(personas,id);
            control.release();
            
            gestorEstado.verificarEstado();
            // El autobús inicia su marcha en dirección al centro de la ciudad, tiempo aleatorio entre 5 y 10 segundos
            safeSleep(5000 + (int) (5000 * Math.random())); // Tiempo aleatorio entre 5 y 10 segundos
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre, "Llegada del autobus "+ bus.getID() +" al centro de  "+this.nombre);
            
            gestorEstado.verificarEstado();
            // Llegada a la parada del centro de la ciudad, donde bajarán los pasajeros
            bus.quitarPasajeros(pasajerosMontados);
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre, "Se bajan "+pasajerosMontados +" pasajeros del autobus "+ bus.getID() );
            ventana.actualizarTransfersCiudad(bus.getID()+"("+pasajerosMontados+")",id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    //si es true duerme y si es false actua como spawn
    public void accesoHangar(Avion avion){
        try{
        gestorEstado.verificarEstado();
        hangar.accederHangar(avion);
        log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de entrar  al hangar ");
        ventana.añadirElemListaHangar(avion.getID(),id);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    
    public void accederAreaEstacionamiento(Avion avion) throws InterruptedException {
        gestorEstado.verificarEstado();
        if (avion.getUbicacion()){
            //El avion viene del taller
            areaEstacionamiento.accederAreaEstacionamiento(avion);
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de entrar al Área de Estacionamiento");
            ventana.añadirElemListaAreaEstacionamiento(avion.getID(),id);
        }else{
            //El avion se encuentra en el hangar
            hangar.salirHangar(avion);
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de salir del Hangar");
            ventana.eliminarElemListaHangar(avion.getID(),id);
            areaEstacionamiento.accederAreaEstacionamiento(avion);
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de entrar al Área de Estacionamiento");
            ventana.añadirElemListaAreaEstacionamiento(avion.getID(),id);
        }
    }
    
    
    public void embarcar(Avion avion) throws InterruptedException {
        gestorEstado.verificarEstado();
        PuertaEmbarque p;
        p = obtenerPuertaEmbarque(true);//Posible error si retorna null
        areaEstacionamiento.salirAreaEstacionamiento(avion);
        log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de salir del Área de Estacionamiento");
        ventana.eliminarElemListaAreaEstacionamiento(avion.getID(),id);
        
        p.embarcar(avion);
        log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" está empezando a embarcar en la Puerta de Embarque "+p.getNumGate());
        //Logica para actualizar los gates en la interfaz
        String text = "Embarque: "+avion.getID();
        actualizarGate(p.getNumGate(),text);
        int pasajerosEmbarcados = Math.min(avion.getCapacidadMaxima(), personas);
        log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de embarcar "+pasajerosEmbarcados+" pasajeros");
        control.safeAcquire();
        personas -= pasajerosEmbarcados;
        control.release();
        avion.subir(pasajerosEmbarcados);
        log.writeLog("PRUEBA:Aeropuerto "+ this.nombre, "Hay "+personas+" personas en el aeropuerto de "+this.nombre);
        ventana.actualizarPasajeros(personas,id);
        gestorEstado.verificarEstado();
        safeSleep(1000 + (int) (2000 * Math.random())); // Tiempo aleatorio entre 1 y 3 segundos

        int intentos = 0;
        while (avion.getPasajeros() < avion.getCapacidadMaxima() && personas > 0 && intentos < 3) {
            gestorEstado.verificarEstado();
            safeSleep(1000 + (int) (4000 * Math.random())); // Tiempo aleatorio entre 1 y 5 segundos

            int restante = avion.getCapacidadMaxima() - avion.getPasajeros();
            int pasajeros = Math.min(restante, personas);
            control.safeAcquire();
            personas -= pasajeros;
            ventana.actualizarPasajeros(personas,id);
            control.release();
            avion.subir(pasajeros);
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"Al avión "+ avion.getID() +" se acaban de subir "+pasajeros+" pasajeros más");
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre, "Hay "+personas+" personas en el aeropuerto de "+this.nombre);
            
            gestorEstado.verificarEstado();
            safeSleep(1000 + (int) (2000 * Math.random())); // Tiempo aleatorio entre 1 y 3 segundos

            intentos++;
        }
    
        p.terminar_embarque(avion);
        log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" abandona la Puerta de Embarque "+p.getNumGate());
        liberarPuertaEmbarque(true,p);
        //Logica para vaciar la puerta de embarque
        text = "";
        actualizarGate(p.getNumGate(),text);
    }


    public void despegar(Avion avion) throws InterruptedException {
        gestorEstado.verificarEstado();
        areaRodaje.accederAreaRodaje(avion);
        log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de entrar al Área de Rodaje");
        ventana.añadirElemListaAreaRodaje(avion.getID()+"("+avion.getPasajeros()+")",id);
        safeSleep(1000 + (int) (4000 * Math.random())); // Tiempo aleatorio entre 1 y 5 segundos
        Pista p;
        
        // Bucle para intentar obtener una pista disponible
        do {
            p = obtenerPista();
            if (p == null) {
                gestorEstado.verificarEstado();
                safeSleep(1000); // Esperar 1 segundo antes de volver a intentar obtener una pista
            }
        } while (p == null);
        
        areaRodaje.salirAreaRodaje(avion);
        log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de salir del Área de Rodaje");
        ventana.eliminarElemListaAreaRodaje(avion.getID()+"("+avion.getPasajeros()+")",id);
        p.accederPista(avion);
        log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de entrar a la Pista "+p.getNumPista());
        //Logica para actualizar la pista
        String text = "Despegue: "+avion.getID()+"("+avion.getPasajeros()+")";
        actualizarPista(p.getNumPista(),text);
        gestorEstado.verificarEstado();
        safeSleep(1000 + (int) (4000 * Math.random())); // Tiempo aleatorio entre 1 y 5 segundos
        
        //Despegue
        gestorEstado.verificarEstado();
        safeSleep(1000 + (int) (4000 * Math.random())); // Tiempo aleatorio entre 1 y 5 segundos
        p.abandonarPista(avion);
        log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de abandonar la Pista "+p.getNumPista());
        //Logica para actualizar la pista
        text = "";
        actualizarPista(p.getNumPista(),text);
        log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de despegar del aeropuerto de "+this.nombre);
        liberarPista();
        salida.accederAerovia(avion);
        log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de acceder a la Aerovía");
        // Logica para actualizar las aerovias en la interfaz
        if(id == 1){
            ventana.añadirElemListaAeroviaMadridBarcelona(avion.getID()+"("+avion.getPasajeros()+")");
        }else if(id==2){
            ventana.añadirElemListaAeroviaBarcelonaMadrid(avion.getID()+"("+avion.getPasajeros()+")");
        }
        
        
        //Cambiar el aeropuerto en avion
        avion.cambiarAeropuerto();
        gestorEstado.verificarEstado();
        safeSleep(15000 + (int) (15000 * Math.random())); // Tiempo aleatorio entre 15 y 30 segundos
    }

    
    public void aterrizar(Avion avion) throws InterruptedException {
        gestorEstado.verificarEstado();
        while (true) {
            Pista pistaDisponible = obtenerPista();
            if (pistaDisponible != null) {
                entrada.salirAerovia(avion);
                log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de salir de la Aerovía ");
                // Logica para actualizar las aerovias en la interfaz
                if(id == 2){
                    ventana.eliminarElemListaAeroviaMadridBarcelona(avion.getID()+"("+avion.getPasajeros()+")");
                }else if(id==1){
                    ventana.eliminarElemListaAeroviaBarcelonaMadrid(avion.getID()+"("+avion.getPasajeros()+")");
                }
                
                // aterrizaje
                gestorEstado.verificarEstado();
                safeSleep(1000 + (int) (4000 * Math.random())); // Tiempo aleatorio entre 1 y 5 segundos
                pistaDisponible.accederPista(avion);
                log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de aterrizar en el aeropuerto de "+this.nombre);
                log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de entrar a la Pista "+pistaDisponible.getNumPista());
                //Logica para actualizar la pista
                String text = "Aterrizaje: "+avion.getID()+"("+avion.getPasajeros()+")";
                actualizarPista(pistaDisponible.getNumPista(),text);
                
                gestorEstado.verificarEstado();
                safeSleep(1000 + (int) (4000 * Math.random())); // Tiempo aleatorio entre 1 y 5 segundos
                
                pistaDisponible.abandonarPista(avion);
                log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de abandonar la Pista "+pistaDisponible.getNumPista());
                //Logica para actualizar la pista
                text = "";
                actualizarPista(pistaDisponible.getNumPista(),text);
                liberarPista();
                break; // Avión ha aterrizado, salir del bucle
            } else {
                // No hay pistas disponibles, dar un rodeo al aeropuerto
                gestorEstado.verificarEstado();
                safeSleep(1000 + (int) (5000 * Math.random())); // Tiempo aleatorio entre 1 y 5 segundos
            }
        }
    }

    public void desembarcar(Avion avion) throws InterruptedException {
        gestorEstado.verificarEstado();
        areaRodaje.accederAreaRodaje(avion);
        log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de entrar al Área de Rodaje");
        ventana.añadirElemListaAreaRodaje(avion.getID()+"("+avion.getPasajeros()+")",id);
        gestorEstado.verificarEstado();
        safeSleep(3000 + (int) (2000 * Math.random())); // Tiempo aleatorio entre 3 y 5 segundos
        
        PuertaEmbarque p;
        p=obtenerPuertaEmbarque(false);
        areaRodaje.salirAreaRodaje(avion);
        log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de salir del Área de Rodaje");
        ventana.eliminarElemListaAreaRodaje(avion.getID()+"("+avion.getPasajeros()+")",id);
        p.desembarcar(avion);
        log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de acceder a la Puerta de Embarque "+p.getNumGate());
        //Logica para actualizar los gates en la interfaz
        String text = "Desembarque: "+avion.getID();
        actualizarGate(p.getNumGate(),text);
        //Se bajan los pasajeros
        log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de bajar a todos los pasajeros");
        control.safeAcquire();
        personas += avion.getPasajeros();
        control.release();
        log.writeLog("PRUEBA:Aeropuerto "+ this.nombre, "Hay "+personas+" personas en el aeropuerto de "+this.nombre);
        ventana.actualizarPasajeros(personas, id);
        
        avion.bajar();
        gestorEstado.verificarEstado();
        safeSleep(1000 + (int) (4000 * Math.random())); // Tiempo aleatorio entre 1 y 5 segundos
        p.terminar_desembarque(avion);
        log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de abandonar la Puerta de Embarque "+p.getNumGate());
        //Logica para actualizar los gates en la interfaz
        text = "";
        actualizarGate(p.getNumGate(),text);
        liberarPuertaEmbarque(false,p);
        areaEstacionamiento.accederAreaEstacionamiento(avion);
        log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de acceder al Área de Estacionamiento");
        ventana.añadirElemListaAreaEstacionamiento(avion.getID(),id);
        gestorEstado.verificarEstado();
        safeSleep(1000 + (int) (4000 * Math.random())); // Tiempo aleatorio entre 1 y 5 segundos
    }
    
    //si es true es inspeccion larga y si es false es revision
    public void inspeccion(Avion avion, boolean b) throws InterruptedException {
        gestorEstado.verificarEstado();
        if (b){
            areaEstacionamiento.salirAreaEstacionamiento(avion);
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de salir del Área de Estacionamiento");
            ventana.eliminarElemListaAreaEstacionamiento(avion.getID(),id);
            //Inspeccion larga 
            taller.accederTaller(avion);
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de acceder al Taller");
            ventana.añadirElemListaTaller(avion.getID(),id);
            //Tiempo acceso taller
            gestorEstado.verificarEstado();
            safeSleep(1000); // Tiempo de un segundo
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" está pasando la inspección");
            //Tiempo revisión
            gestorEstado.verificarEstado();
            safeSleep(5000 + (int) (5000 * Math.random())); // Tiempo aleatorio entre 5 y 10 segundos
            taller.salirTaller(avion);
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de salir del Taller");
            ventana.eliminarElemListaTaller(avion.getID(),id);
            //Tiempo salida taller
            gestorEstado.verificarEstado();
            safeSleep(1000); // Tiempo de un segundo
        }else{
            areaEstacionamiento.salirAreaEstacionamiento(avion);
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de salir del Área de Estacionamiento");
            ventana.eliminarElemListaAreaEstacionamiento(avion.getID(),id);
            //Inspeccion corta 
            taller.accederTaller(avion);
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de acceder al Taller");
            ventana.añadirElemListaTaller(avion.getID(),id);
            //Tiempo acceso taller
            gestorEstado.verificarEstado();
            safeSleep(1000); // Tiempo de un segundo
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" está pasando la revisión");
            //Tiempo revisión
            gestorEstado.verificarEstado();
            safeSleep(1000 + (int) (4000 * Math.random())); // Tiempo aleatorio entre 1 y 5 segundos
            taller.salirTaller(avion);
            log.writeLog("PRUEBA:Aeropuerto "+ this.nombre,"El avión "+ avion.getID() +" acaba de salir del Taller");
            ventana.eliminarElemListaTaller(avion.getID(),id);
            //Tiempo salida taller
            gestorEstado.verificarEstado();
            safeSleep(1000); // Tiempo de un segundo
        }
    }
    public void safeSleep(long sleepMs) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        long sleptTime = 0;
        long timeLeft = sleepMs;

        while (sleptTime < sleepMs) {
            try {
                if (timeLeft > 0) {
                    Thread.sleep(timeLeft);
                }
                break; // Si se completa el tiempo de sueño, salimos del bucle
            } catch (InterruptedException e) {
                // Actualizamos el tiempo dormido y el tiempo restante.
                sleptTime = System.currentTimeMillis() - startTime;
                timeLeft = sleepMs - sleptTime;
                // Verificar el estado de pausa
                gestorEstado.verificarEstado();
                // No es necesario limpiar la interrupción aquí, ya que el flag ya está limpio.
            }
        }
    }
    public PuertaEmbarque obtenerPuertaEmbarque(boolean tipo) throws InterruptedException {
        // Si tipo es true es embarque y si es false es desembarque
        puertas.safeAcquire(); 
        if(tipo){
            embarque.safeAcquire(); /////6 puertas 5 embarque 1espera, uno de los 
            if (!gate5.estaOcupado()) {
                    gate5.setOcupado(true);
                    return gate5;
                }
            else{
                return obtenerMixto();
            }
        }
        else{
            desembarque.safeAcquire();
            if (!gate6.estaOcupado()) {
                    gate6.setOcupado(true);
                    return gate6;
                }
            else{
                 return obtenerMixto();
             }
        }
   
    }
    public PuertaEmbarque obtenerMixto() throws InterruptedException {
        mixtas.safeAcquire();
        if (!gate1.estaOcupado()) {
            gate1.setOcupado(true);

            return gate1;
        } else if (!gate2.estaOcupado()) {
            gate2.setOcupado(true);
            return gate2;
        } else if (!gate3.estaOcupado()) {
            gate3.setOcupado(true);
            return gate3;
        } else if (!gate4.estaOcupado()) {
            gate4.setOcupado(true);
            return gate4;
        }
        return null; // Si todas las puertas están ocupadas, devolvemos null
    }


    
    //Suelta la puerta de embarque
    public void liberarPuertaEmbarque(boolean tipo,PuertaEmbarque p){
        if(p == gate1 ||p == gate2 ||p == gate3 ||p == gate4){
            mixtas.release();
        }
        if(tipo){
            embarque.release();
        }else{
            desembarque.release();
        }
       puertas.release();

        
    }
    

    private Pista obtenerPista() throws InterruptedException {
        pistas.safeAcquire();
        
        if (!pista1.estaOcupada() && pista1.estaAbierta()) {
            pista1.setOcupado(true);
            return pista1;
        } else if (!pista2.estaOcupada() && pista2.estaAbierta()) {
            pista2.setOcupado(true);
            return pista2;
        } else if (!pista3.estaOcupada() && pista3.estaAbierta()) {
            pista3.setOcupado(true);
            return pista3;
        } else if (!pista4.estaOcupada() && pista4.estaAbierta()) {
            pista4.setOcupado(true);
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
    
    public void actualizarGate(int gateNumber, String text) {
        switch (gateNumber) {
            case 1:
                ventana.actualizarGate1(text,id);
                break;
            case 2:
                ventana.actualizarGate2(text,id);
                break;
            case 3:
                ventana.actualizarGate3(text,id);
                break;
            case 4:
                ventana.actualizarGate4(text,id);
                break;
            case 5:
                ventana.actualizarGate5(text,id);
                break;
            case 6:
                ventana.actualizarGate6(text,id);
                break;
        }
    }
    
    public void actualizarPista(int numeroPista, String text) {
        switch (numeroPista) {
            case 1:
                ventana.actualizarPista1(text,id);
                break;
            case 2:
                ventana.actualizarPista2(text,id);
                break;
            case 3:
                ventana.actualizarPista3(text,id);
                break;
            case 4:
                ventana.actualizarPista4(text,id);
                break;
        }
    }
    
    public int getPasajeros(){
        return personas;
    }

    public int numAvionesHangar(){
        return hangar.getCapacidadActual();
    }
    
    public int numAvionesTaller(){
        return taller.getCapacidadActual();
    }
    
    public int numAvionesAEstacionamiento(){
        return areaEstacionamiento.getCapacidadActual();
    } 
    
    public int numAvionesAreaRodaje(){
        return areaRodaje.getCapacidadActual();
    } 
    
    public DefaultListModel avionesAerovia1(){
        List<Avion> aviones = entrada.getAviones();
        DefaultListModel model = new DefaultListModel();
        for (Avion avion : aviones) {
        model.addElement(avion.getId() + "(" + avion.getPasajeros() + ")");
        }
        return model;
    }
    
    public DefaultListModel avionesAerovia2(){
        List<Avion> aviones = salida.getAviones();
        DefaultListModel model = new DefaultListModel();
        for (Avion avion : aviones) {
        model.addElement(avion.getId() + "(" + avion.getPasajeros() + ")");
        }
        return model;
    }
    
    public void cerrarPista(int numeroPista) {
        switch (numeroPista) {
            case 1:
                pista1.setEstado(false);
                System.out.println("El estado es :"+pista1.getEstado());
                break;
            case 2:
                pista2.setEstado(false);
                break;
            case 3:
                pista3.setEstado(false);
                break;
            case 4:
                pista4.setEstado(false);
                break;
        }
    }
    
    public void abrirPista(int numeroPista) {
        switch (numeroPista) {
            case 1:
                pista1.setEstado(true);
                System.out.println("El estado es :"+pista1.getEstado());
                break;
            case 2:
                pista2.setEstado(true);
                break;
            case 3:
                pista3.setEstado(true);
                break;
            case 4:
                pista4.setEstado(true);
                break;
        }
    }
}
