package logica;

import exceptions.AvionException;
import model.Avion;

import java.util.ArrayList;
import java.util.List;

public class GestorAvion extends AvionException{
    List<Avion> aviones;
    static private GestorAvion ga;

    private GestorAvion(ArrayList<Avion> arrayList) {
        aviones = arrayList;
    }

    static public GestorAvion getInstance() {
        if (ga == null) {
            ga = new GestorAvion(new ArrayList<Avion>());
        }
        return ga;

    }
    public boolean AgregarAvion(Avion data) throws AvionException{
        if (aviones.size() == 0){
            return aviones.add(data);

        }
        else {
            for (Avion control : aviones) {
                if (control.getMatricula()!= data.getMatricula()) {
                    return aviones.add(data);

                } else
                    return false;
            }

        }
        return false;
    }
    public boolean ModificarAvion(Avion mod, String pmatricula, String pmodelo, int pcantidad, int panio_fab) throws AvionException {
        for (Avion a: aviones){
            if (a.getMatricula() == mod.getMatricula()){

                a.setMatricula(pmatricula);
                a.setModelo(pmodelo);
                a.setCapacidad(pcantidad);
                a.setAnio_fab(panio_fab);
                return true;
            }
        }
        return false;
    }
    public boolean BorrarAvion(Avion mod){
        for (Avion a : aviones) {
            if(a.getMatricula() == mod.getMatricula())
                return aviones.remove(mod);
        }
        return false;
    }
    //criterio de busqueda: matricula
    public Avion TraerUnAvion(String filtro) {
        for (Avion a: aviones){
            if(a.getMatricula() == filtro){
                return a;
            }
        }
        return null;
    }
    public List<Avion> TraerTodosAviones(){

        return aviones;
    }
    //busca por matricula, siempre devuelve 1
    public Avion TraerPorCriterioAvion(String filtro){

        for (Avion a: aviones){
            if(a.getMatricula() == filtro)
                return a;
        }
        return null;
    }
}