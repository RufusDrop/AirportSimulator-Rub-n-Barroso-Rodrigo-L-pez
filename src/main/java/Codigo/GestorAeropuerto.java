package Codigo;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GestorAeropuerto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
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
        
        
        Log log = new Log();
        for(int i=0;i<30;i++){
            log.writeLog("PRUEBA:Aeropuerto ", " ");
        }
        log.writeLog("PRUEBA:Aeropuerto ", "******************************************");
            log.writeLog("PRUEBA:Aeropuerto ", "*********** PRUEBAS GENERALES ***********");
        
        
        Aerovia mad_bar=new Aerovia();
        Aerovia bar_mad=new Aerovia();
        Aeropuerto madrid =new Aeropuerto("Madrid-Barajas",mad_bar,bar_mad,log);
        Aeropuerto barcelona =new Aeropuerto("Barcelona-El Prat",bar_mad,mad_bar,log);
        
        /*for (int i =0;i<21;i++){
            Avion avion = new Avion("Avion-"+i,60,madrid,madrid,barcelona);
            log.writeLog("PRUEBA:Aeropuerto ", "Avión-"+i+" creado.");
            System.out.println("Avión-"+i+" creado.");
            avion.start();
        }*/
        
        for (int i =0;i<40;i++){
            if(i%2==0){
                Autobus bus = new Autobus("Bus-"+(i+1),60,madrid);
                System.out.println("Bus-"+(i+1)+" creado.");
                bus.start();
            }
            else if(i%2==1){
                Autobus bus = new Autobus("Bus-"+(i+1),60,barcelona);
                System.out.println("Bus-"+(i+1)+" creado.");
                bus.start();}
        }
        
        /*Avion avion = new Avion("Avion-1",60,madrid,madrid,barcelona);
        log.writeLog("PRUEBA:Aeropuerto ", "Avión-1 creado.");
        System.out.println("Avión-1 creado.");
        avion.start();*/
        
        
        for (int i =0;i<40;i++){
            if(i%2==0){
                Avion avion = new Avion("Avion-"+i,60,madrid,madrid,barcelona);
                log.writeLog("PRUEBA:Aeropuerto ", "Avión-"+i+" creado.");
                System.out.println("Avión-"+i+" creado.");
                avion.start();
            }
            else if(i%2==1){
                Avion avion = new Avion("Avion-"+i,60,barcelona,madrid,barcelona);
                log.writeLog("PRUEBA:Aeropuerto ", "Avión-"+i+" creado.");
                System.out.println("Avión-"+i+" creado.");
                avion.start();
            }
        }
        
        
        
        /*
        //Código main real
        
        Log log = new Log();
        Aerovia mad_bar=new Aerovia();
        Aerovia bar_mad=new Aerovia();
        Aeropuerto madrid =new Aeropuerto(3600,"Madrid-Barajas",mad_bar,bar_mad,log);
        Aeropuerto barcelona =new Aeropuerto(3600,"Barcelona-El Prat",bar_mad,mad_bar,log);
        
        //Código de creación de autobuses
        for (int i = 0; i < 4000; i++) {
            String identificador = generarIdentificador(i,true);
            Aeropuerto aeropuerto = i % 2 == 0 ? madrid : barcelona; // Determina el aeropuerto

            Autobus autobus = new Autobus(identificador, 50, aeropuerto);
            autobus.start();
            Thread.sleep((long) ((0.5 + Math.random() * 0.5) * 1000));

        }
        
        //Código creación aviones
        for (int i = 0; i < 8000; i++) {
            String identificador = generarIdentificador(i);
            int capacidad = (int) (Math.random() * (300 - 100 + 1) + 100); // Capacidad aleatoria entre 100 y 300
            Aeropuerto aeropuerto = i % 2 == 0 ? madrid : barcelona; // Determina el aeropuerto

            Avion avion = new Avion(identificador, capacidad, aeropuerto,madrid,barcelona);
            avion.start();
            Thread.sleep(1000 + (int) (2000 * Math.random()));
        }*/
        
        
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
    
}
