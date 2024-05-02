package Codigo;

import java.util.concurrent.Semaphore;


public class SafeSemaphore extends Semaphore {
    private GestorEstadoPrograma gestorEstado;
    public SafeSemaphore(int permits,GestorEstadoPrograma gestorEstado) {
        super(permits);
        this.gestorEstado = gestorEstado;
    }

    public SafeSemaphore(int permits, boolean fair,GestorEstadoPrograma gestorEstado) {
        super(permits, fair);
        this.gestorEstado = gestorEstado;
    }

    // Método para adquirir un permiso, maneja la Interrupción internamente
    public void safeAcquire() throws InterruptedException {
            while (true) {
                System.out.println("WHILE");
                try {
                    System.out.println("TRY");
                    acquire();
                    System.out.println("Hilo " + " ha adquirido el semáforo.");
                    break; // Si se adquiere el permiso, salimos del bucle
                } catch (InterruptedException e) {
                    System.out.println("Adquire Interrumpido");
                    gestorEstado.verificarEstado();
                    System.out.println("Estado verificado y reanudado");
                    // Aquí podrías decidir basado en el estado global si continuar intentando o no
                }
            }
        }  
}