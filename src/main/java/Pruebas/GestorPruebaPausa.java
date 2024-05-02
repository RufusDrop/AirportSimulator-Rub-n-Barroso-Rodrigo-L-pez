package Pruebas;

import Codigo.GestorEstadoPrograma;

public class GestorPruebaPausa {
    public static void main(String[] args) throws InterruptedException {
        GestorEstadoPrograma gestorEstado = new GestorEstadoPrograma();
        Thread[] hilos = new Thread[1];

        // Crear y arrancar los hilos
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new HiloPruebaPausa(i, gestorEstado);
            hilos[i].start();
        }

        // Esperar 4 segundos antes de interrumpir todos los hilos
        Thread.sleep(2000);
        System.out.println("Interrupción");
        gestorEstado.pausar();  // Pausar todos los hilos
        for (Thread hilo : hilos) {
            hilo.interrupt();
        }

        // Espera adicional para simular la pausa
        Thread.sleep(5000);
        System.out.println("Dormido 5s");
        System.out.println("Reanudar");
        gestorEstado.reanudar();  // Reanudar todos los hilos

        // Espera para que los hilos finalicen correctamente su tiempo de sueño restante
        for (Thread hilo : hilos) {
            hilo.join();
        }
        System.out.println("Todos los hilos han completado su ejecución.");
    }
}
