package Pruebas;

import Codigo.GestorEstadoPrograma;
import Codigo.SafeSemaphore;
import java.util.concurrent.Semaphore;


public class HiloPruebaPausa extends Thread {
    private GestorEstadoPrograma gestorEstado;
    private int id;
    private SafeSemaphore safeSemaphore;
    private Semaphore semaphore = new Semaphore(1);

    public HiloPruebaPausa(int id, GestorEstadoPrograma gestorEstado,SafeSemaphore safeSemaphore) {
        this.gestorEstado = gestorEstado;
        this.id = id;
        this.safeSemaphore = safeSemaphore;
    }

    @Override
    public void run() {
//        PRUEBAS DE SAFESLEEP
//        System.out.println("Hilo " + id + " comenzando.");
//        try {
//            safeSleep(6000);  // Dormir durante 6 segundos
//            System.out.println("Hilo " + id + " finalizado.");
//        } catch (InterruptedException e) {
//            System.out.println("Hilo " + id + " interrumpido.");
//        }
//        PRUEBAS DE SAFESEMAPHORE
            try {
            System.out.println("Hilo " + id + " intentando adquirir el semáforo.");
            safeSemaphore.safeAcquire();
            
            // Simula algún trabajo
            safeSleep(6000);
            System.out.println("Hilo " + id + " liberando el semáforo.");
            safeSemaphore.release();
        } catch (InterruptedException e) {
            System.out.println("Hilo " + id + " interrumpido mientras esperaba o trabajaba.");
        }
    }
   

    public void safeSleep(long sleepMs) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        long sleptTime = 0;
        long timeLeft = sleepMs;

        while (sleptTime < sleepMs) {
            try {
                System.out.println("Dormido:"+sleptTime+" Restante:"+timeLeft);
                if (timeLeft > 0) {
                    Thread.sleep(timeLeft);
                }
                // Actualizamos sleptTime para salir del bucle si ya hemos dormido lo suficiente.
                sleptTime = System.currentTimeMillis() - startTime;
                System.out.println("Dormido:"+sleptTime+" Restante:"+0);
                break; // Si se completa el tiempo de suenno, salimos del bucle
            } catch (InterruptedException e) {
                // Actualizamos el tiempo dormido y el tiempo restante.
                sleptTime = System.currentTimeMillis() - startTime;
                timeLeft = sleepMs - sleptTime;
                System.out.println("Dormido:"+sleptTime+" Restante:"+timeLeft);
                // Verificar el estado de pausa
                gestorEstado.verificarEstado();
                // No es necesario limpiar la interrupción aquí, ya que el flag ya está limpio.
            }
        }
    }
}
