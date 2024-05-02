package Codigo;

public class GestorEstadoPrograma {
    //Implementado con un monitor de mesa
    private boolean pausado = false;  // Estado inicial no pausado

    public synchronized void pausar() {
        pausado = true;
        notifyAll();  // Notifica a todos los hilos que pueden necesitar revisar el estado
    }

    public synchronized void reanudar() {
        pausado = false;
        notifyAll();  // Notifica a todos los hilos en espera que pueden continuar
    }

    public synchronized void verificarEstado() throws InterruptedException {
        while (pausado) {
            wait();  // Pone el hilo en espera si la simulación está pausada
        }
    }
}