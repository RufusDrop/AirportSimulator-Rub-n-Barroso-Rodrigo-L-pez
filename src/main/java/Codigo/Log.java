package Codigo;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Log {
    private static final String LOG_FILE = "evolucionAeropuerto.txt";
    private Lock control = new ReentrantLock();
    private PrintWriter writer;

    public Log() {
        try {
            // FileWriter configurado para añadir texto al final del archivo existente
            writer = new PrintWriter(new FileWriter(LOG_FILE, true));
        } catch (IOException e) {
            System.err.println("Error al abrir el archivo de log: " + e.getMessage());
        }

        // Añadimos un shutdown hook para que se guarden los datos incluso parando el programa abruptamente
        Runtime.getRuntime().addShutdownHook(new Thread(() -> writer.close()));
    }

    // Método para escribir un evento en el log
    public void writeLog(String airport, String event) {
        control.lock(); // Control para la sección crítica
        try {
            LocalDateTime now = LocalDateTime.now();
            String timestamp = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            writer.println(timestamp + " - " + airport + " - " + event);
            writer.flush(); // Asegura que el texto se escribe en el archivo inmediatamente
        } finally {
            control.unlock();
        }
    }
}
