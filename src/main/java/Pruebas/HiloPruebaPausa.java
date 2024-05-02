package Pruebas;

import Codigo.GestorEstadoPrograma;


public class HiloPruebaPausa extends Thread {
    private GestorEstadoPrograma gestorEstado;
    private int id;

    public HiloPruebaPausa(int id, GestorEstadoPrograma gestorEstado) {
        this.gestorEstado = gestorEstado;
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Hilo " + id + " comenzando.");
        try {
            safeSleep(6000);  // Dormir durante 6 segundos
            System.out.println("Hilo " + id + " finalizado.");
        } catch (InterruptedException e) {
            System.out.println("Hilo " + id + " interrumpido.");
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
                break; // Si se completa el tiempo de sueño, salimos del bucle
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
