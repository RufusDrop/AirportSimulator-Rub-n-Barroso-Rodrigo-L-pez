package Codigo;

import java.util.Random;
import Interfaces.VentanaPrincipal;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
public class GestorAeropuerto {
    
    private final VentanaPrincipal ventana;
    private final GestorEstadoPrograma gestorEstado;
    private Thread[] buses = new Thread[40]; 
    private Thread[] aviones = new Thread[80]; 
   
    public GestorAeropuerto(VentanaPrincipal ventanaPrincipal) throws InterruptedException {
        
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
               
        
        
        // Ejecutar la creación de los hilos en un nuevo hilo para evitar bloquear el flujo del programa mientras se van creando los hilos de forma escalonada
        new Thread(() -> {
            //Código de creación de autobuses
            for (int i = 0; i < buses.length; i++) {
                String identificador = generarIdentificador(i,true);
                Aeropuerto aeropuerto = i % 2 == 0 ? madrid : barcelona; // Determina el aeropuerto

                buses[i] = new Autobus(identificador, 50, aeropuerto);
                buses[i].start();
                try {
                    Thread.sleep((long) ((0.5 + Math.random() * 0.5) * 1000));
                } catch (InterruptedException ex) {
                    Logger.getLogger(GestorAeropuerto.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }).start();
        
        new Thread(() -> {
            //Código creación aviones
            for (int i = 0; i < aviones.length; i++) {
                String identificador = generarIdentificador(i);
                int capacidad = (int) (Math.random() * (300 - 100 + 1) + 100); // Capacidad aleatoria entre 100 y 300
                Aeropuerto aeropuerto = i % 2 == 0 ? madrid : barcelona; // Determina el aeropuerto

                aviones[i] = new Avion(identificador, capacidad, aeropuerto,madrid,barcelona);
                aviones[i].start();
                try {
                    Thread.sleep(1000 + (int) (2000 * Math.random()));
                } catch (InterruptedException ex) {
                    Logger.getLogger(GestorAeropuerto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  
        }).start();
        
           

        // Iniciar el servidor RMI
        iniciarServidorRMI(madrid,barcelona);
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
    
    // Método para iniciar el servidor RMI
    private void iniciarServidorRMI(Aeropuerto madrid ,Aeropuerto barcelona) {
        try {
            // Iniciar el servidor RMI en el puerto 1099
            Registry registry = LocateRegistry.createRegistry(1099);
            
            // Crear una instancia de la implementación de la interfaz remota
            ServidorImp servidor = new ServidorImp(madrid,barcelona);
            
            // Registrar la instancia en el registro RMI
            registry.rebind("Servidor", servidor);
            
            System.out.println("Servidor RMI iniciado...");
        } catch (Exception e) {
            System.err.println("Error en el servidor RMI: " + e.getMessage());
        }
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
}
