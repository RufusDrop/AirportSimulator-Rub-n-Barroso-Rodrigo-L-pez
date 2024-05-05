package Codigo;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Servidor extends Remote{
    
    int numPasajeros (int idAeropuerto)throws RemoteException;
    int numAvionesHangar (int idAeropuerto)throws RemoteException;
    int numAvionesTaller (int idAeropuerto)throws RemoteException;
    int numAvionesAEstacionamiento (int idAeropuerto)throws RemoteException;
    int numAvionesAreaRodaje (int idAeropuerto)throws RemoteException;
    List<Thread> avionesAerovia (int idAeropuerto)throws RemoteException;
    void cerrarPista (int numPista,int idAeropuerto)throws RemoteException;
    void abrirPista (int numPista,int idAeropuerto)throws RemoteException;
    
}
