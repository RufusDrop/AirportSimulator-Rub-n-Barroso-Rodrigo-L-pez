package Codigo;

import java.util.Random;
import Interfaces.VentanaPrincipal;
public class GestorAeropuerto {
    
    private final VentanaPrincipal ventana;
    private final GestorEstadoPrograma gestorEstado;
    private Thread[] buses = new Thread[40]; 
    private Thread[] aviones = new Thread[80]; 
   
    public GestorAeropuerto(VentanaPrincipal ventanaPrincipal) throws InterruptedException {
        //Log log = new Log();
        //log.writeLog("PRUEBA:Aeropuerto Madrid-Barajas", "PRUEBA:Avión AC-1423 es creado");
        
        /*//Prueba funcionamiento autobuses
        Log log = new Log();
        for(int i=0;i<5;i++){
            log.writeLog("PRUEBA:Aeropuerto Madrid-Barajas", " ");
        }
        log.writeLog("PRUEBA:Aeropuerto Madrid-Barajas", "******************************************");
        log.writeLog("PRUEBA:Aeropuerto Madrid-Barajas", "**************PRUEBAS AUTOBUSES***********");
        Aerovia mad_bar=new Aerovia();
        Aerovia bar_mad=new Aerovia();
        Aeropuerto madrid =new Aeropuerto("Madrid-Barajas",mad_bar,bar_mad,log);
        for (int i =0;i<100;i++){
        Autobus bus = new Autobus("Bus-"+(i+1),60,madrid);
        System.out.println("Bus-"+(i+1)+" creado.");
        bus.start();
        }*/
        
        /*
        //Prueba funcionamiento aviones
        Log log = new Log();
        for(int i=0;i<30;i++){
            log.writeLog("PRUEBA:Aeropuerto Aviones", " ");
        }
        log.writeLog("PRUEBA:Aeropuerto ", "******************************************");
        log.writeLog("PRUEBA:Aeropuerto ", "************** PRUEBAS AVIONES ***********");*/
        
        gestorEstado = new GestorEstadoPrograma();
        ventana = ventanaPrincipal;
        Log log = new Log();
        for(int i=0;i<30;i++){
            log.writeLog("PRUEBA:Aeropuerto ", " ");
        }
        log.writeLog("PRUEBA:Aeropuerto ", "******************************************");
            log.writeLog("PRUEBA:Aeropuerto ", "*********** PRUEBAS GENERALES ***********");
        
        
        Aerovia mad_bar=new Aerovia(ventana);
        Aerovia bar_mad=new Aerovia(ventana);
        Aeropuerto madrid =new Aeropuerto("Madrid-Barajas",1,mad_bar,bar_mad,log,ventana,gestorEstado);
        Aeropuerto barcelona =new Aeropuerto("Barcelona-El Prat",2,bar_mad,mad_bar,log,ventana,gestorEstado);
        
        /*friteLog("PRUEBA:Aeropuerto ", "Avión-"+i+" creado.");
                System.out.println("Avión-"+i+" creado.");
                aviones[i].start();
            }
        }
        or (int i =0;i<21;i++){
            Avion avion = new Avion("Avion-"+i,60,madrid,madrid,barcelona);
            log.writeLog("PRUEBA:Aeropuerto ", "Avión-"+i+" creado.");
            System.out.println("Avión-"+i+" creado.");
            avion.start();
        }*/
        
        
        for (int i =0;i<40;i++){
            if(i%2==0){
                buses[i] = new Autobus("Bus-"+(i+1),60,madrid);
                System.out.println("Bus-"+(i+1)+" creado.");
                buses[i].start();
            }
            else if(i%2==1){
                buses[i] = new Autobus("Bus-"+(i+1),60,barcelona);
                System.out.println("Bus-"+(i+1)+" creado.");
                buses[i].start();}
        }
        
        /*Avion avion = new Avion("Avion-1",60,madrid,madrid,barcelona);
        log.writeLog("PRUEBA:Aeropuerto ", "Avión-1 creado.");
        System.out.println("Avión-1 creado.");
        avion.start();*/
        
        for (int i =0;i<40;i++){
            if(i%2==0){
                aviones[i] = new Avion("Avion-"+i,60,madrid,madrid,barcelona);
                log.writeLog("PRUEBA:Aeropuerto ", "Avión-"+i+" creado.");
                System.out.println("Avión-"+i+" creado.");
                aviones[i].start();
            }
            else if(i%2==1){
                aviones[i] = new Avion("Avion-"+i,60,barcelona,madrid,barcelona);
                log.writeLog("PRUEBA:Aeropuerto ", "Avión-"+i+" creado.");
                System.out.println("Avión-"+i+" creado.");
                aviones[i].start();
            }
        }
        
        
        
//        
//        //Código main real
//        gestorEstado = new GestorEstadoPrograma();
//        ventana = ventanaPrincipal;
//        Log log = new Log();
//        Aerovia mad_bar=new Aerovia(ventana);
//        Aerovia bar_mad=new Aerovia(ventana);
//        Aeropuerto madrid =new Aeropuerto("Madrid-Barajas",1,mad_bar,bar_mad,log,ventana,gestorEstado);
//        Aeropuerto barcelona =new Aeropuerto("Barcelona-El Prat",2,bar_mad,mad_bar,log,ventana,gestorEstado);
//        
//        //Código de creación de autobuses
//        for (int i = 0; i < buses.length; i++) {
//            String identificador = generarIdentificador(i,true);
//            Aeropuerto aeropuerto = i % 2 == 0 ? madrid : barcelona; // Determina el aeropuerto
//
//            buses[i] = new Autobus(identificador, 50, aeropuerto);
//            buses[i].start();
//            Thread.sleep((long) ((0.5 + Math.random() * 0.5) * 1000));
//
//        }
//        
//        //Código creación aviones
//        for (int i = 0; i < aviones.length; i++) {
//            String identificador = generarIdentificador(i);
//            int capacidad = (int) (Math.random() * (300 - 100 + 1) + 100); // Capacidad aleatoria entre 100 y 300
//            Aeropuerto aeropuerto = i % 2 == 0 ? madrid : barcelona; // Determina el aeropuerto
//
//            aviones[i] = new Avion(identificador, capacidad, aeropuerto,madrid,barcelona);
//            aviones[i].start();
//            Thread.sleep(1000 + (int) (2000 * Math.random()));
//        }
//        
        
    }
    
    //Devuelve un id de avión (YY-XXXX) a partir de un int
    private static String generarIdentificador(int numero) {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rand = new Random();
        String codigo = "";
        codigo += letras.charAt(rand.nextInt(letras.length()));
        codigo += letras.charAt(rand.nextInt(letras.length()));
        codigo += "-";
        codigo += String.format("%04d", numero); // Formato de 4 dígitos con ceros a la izquierda
        return codigo;
    }
    
    //Devuelve un id de autobus (B-XXXX) a partir de un int
    private static String generarIdentificador(int numero,boolean bus) {
        return "B-" + String.format("%04d", numero); // Formato de 4 dígitos con ceros a la izquierda
    }
    
    public void pausar(){
        gestorEstado.pausar();
        for (Thread hilo : buses) {
            if (hilo != null && hilo.isAlive()) {
                hilo.interrupt();  // Interrumpir cada hilo para que maneje la pausa
            }
        }
        for (Thread hilo : aviones) {
            if (hilo != null && hilo.isAlive()) {
                hilo.interrupt();  // Interrumpir cada hilo para que maneje la pausa
            }
        }
    }
    public void reanudar(){
        gestorEstado.reanudar();
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
    
}
