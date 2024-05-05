package Codigo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javax.swing.DefaultListModel;

public class ServidorImp extends UnicastRemoteObject implements Servidor{
    
    private Aeropuerto madrid;
    private Aeropuerto barcelona;
    
    public ServidorImp(Aeropuerto madrid,Aeropuerto barcelona) throws RemoteException {
        super();
        this.madrid=madrid;
        this.barcelona=barcelona;
    }
    
    @Override
    public int numPasajeros (int idAeropuerto)throws RemoteException{
        if (idAeropuerto==1){
            return numPasajerosMadrid();
        }
        else if (idAeropuerto==2){
            return numPasajerosBarcelona();
        }else {return -1;}
    }
    
    public int numPasajerosMadrid(){
        return madrid.getPasajeros();
    }
    
    public int numPasajerosBarcelona(){
        return barcelona.getPasajeros();
    }
    
    @Override
    public int numAvionesHangar (int idAeropuerto)throws RemoteException{
        if (idAeropuerto==1){
            return numAvionesHangarMadrid();
        }
        else if (idAeropuerto==2){
            return numAvionesHangarBarcelona();
        }else {return -1;}
    }
    
    public int numAvionesHangarMadrid(){
        return madrid.numAvionesHangar();
    }
    
    public int numAvionesHangarBarcelona(){
        return barcelona.numAvionesHangar();
    }
    
    @Override
    public int numAvionesTaller (int idAeropuerto)throws RemoteException{
        if (idAeropuerto==1){
            return numAvionesTallerMadrid();
        }
        else if (idAeropuerto==2){
            return numAvionesTallerBarcelona();
        }else {return -1;}
    }
    
    
    public int numAvionesTallerMadrid(){
        return madrid.numAvionesTaller();
    }
    
    public int numAvionesTallerBarcelona(){
        return barcelona.numAvionesTaller();
    }
    
    @Override
    public int numAvionesAEstacionamiento (int idAeropuerto)throws RemoteException{
        if (idAeropuerto==1){
            return numAvionesAEstacionamientoMadrid();
        }
        else if (idAeropuerto==2){
            return numAvionesAEstacionamientoBarcelona();
        }else {return -1;}
    }
    
    public int numAvionesAEstacionamientoMadrid(){
        return madrid.numAvionesAEstacionamiento();
    }
    
    public int numAvionesAEstacionamientoBarcelona(){
        return barcelona.numAvionesAEstacionamiento();
    }
    
    @Override
    public int numAvionesAreaRodaje (int idAeropuerto)throws RemoteException{
        if (idAeropuerto==1){
            return numAvionesAreaRodajeMadrid();
        }
        else if (idAeropuerto==2){
            return numAvionesAreaRodajeBarcelona();
        }else {return -1;}
    }
    
    public int numAvionesAreaRodajeMadrid(){
        return madrid.numAvionesAreaRodaje();
    }
    
    public int numAvionesAreaRodajeBarcelona(){
        return barcelona.numAvionesAreaRodaje();
    }

    @Override
    public DefaultListModel avionesAerovia (int idAeropuerto)throws RemoteException{
        if (idAeropuerto==1){
            return avionesAerovia1();
        }
        else if (idAeropuerto==2){
            return avionesAerovia2();
        }else {return null;}
        
    }
    
    public DefaultListModel avionesAerovia1(){
        return madrid.avionesAerovia1();
    }
    
    public DefaultListModel  avionesAerovia2(){
        return madrid.avionesAerovia2();
    }
    
    @Override
    public void cerrarPista (int numPista,int idAeropuerto)throws RemoteException{
        if (idAeropuerto==1){
            cerrarPistaMadrid(numPista);
        }
        else if (idAeropuerto==2){
            cerrarPistaBarcelona(numPista);
        }        
    }
    
    public void cerrarPistaMadrid(int numPista){
        madrid.cerrarPista(numPista);
    }
    
    public void cerrarPistaBarcelona(int numPista){
        barcelona.cerrarPista(numPista);
    }
    
    @Override
    public void abrirPista (int numPista,int idAeropuerto)throws RemoteException{
        if (idAeropuerto==1){
            abrirPistaMadrid(numPista);
        }
        else if (idAeropuerto==2){
            abrirPistaBarcelona(numPista);
        }
    }
    
    public void abrirPistaMadrid(int numPista){
        madrid.abrirPista(numPista);
    }
    
    public void abrirPistaBarcelona(int numPista){
        barcelona.abrirPista(numPista);
    }
    
}
