package Codigo;

import java.util.concurrent.TimeUnit;

public class GestorAeropuerto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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

        Log log = new Log();
        Aerovia mad_bar=new Aerovia();
        Aerovia bar_mad=new Aerovia();
        Aeropuerto madrid =new Aeropuerto("Madrid-Barajas",mad_bar,bar_mad,log);
        Aeropuerto barcelona =new Aeropuerto("Barcelona-El Prat",bar_mad,mad_bar,log);
    }
    
}
