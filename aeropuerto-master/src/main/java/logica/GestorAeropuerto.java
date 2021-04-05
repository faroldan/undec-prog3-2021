package logica;

import exceptions.AeropuertoException;
import model.Aeropuerto;

import java.util.ArrayList;
import java.util.List;

public class GestorAeropuerto {
    List<Aeropuerto> aeropuertos= new ArrayList<Aeropuerto>();
    static private GestorAeropuerto ga;

    private GestorAeropuerto(ArrayList<Aeropuerto> arrayList) {
        aeropuertos = arrayList;
    }

    static public GestorAeropuerto getInstance() {
        if (ga == null) {
            ga = new GestorAeropuerto(new ArrayList<Aeropuerto>());
        }
        return ga;

    }

    public boolean AgregarAeropuerto(Aeropuerto data) {
        if (aeropuertos.size() == 0){
                aeropuertos.add(data);
                return true;
        }
        else {
            for (Aeropuerto control : aeropuertos) {
                if (control.getCodIATA() != data.getCodIATA()) {
                    aeropuertos.add(data);
                    return true;
                } else
                    return false;
            }
            return false;
        }

    }
    public boolean ModificarAeropuerto(Aeropuerto mod, String CodIATA, String nombre, String ciudad, String cp) throws AeropuertoException {
        for (Aeropuerto a: aeropuertos){
            if (a.getCodIATA() == mod.getCodIATA()){

                a.setCodIATA(CodIATA);
                a.setNombre(nombre);
                a.setCiudad(ciudad);
                a.setCP(cp);
                return true;
            }
        }
        return false;
    }
    public boolean BorrarAeropuerto(Aeropuerto mod) {
        for (Aeropuerto a : aeropuertos) {
            if(a.getCodIATA() == mod.getCodIATA())
                return aeropuertos.remove(mod);
        }
        return false;
    }
    //criterio de busqueda: nombre
    public Aeropuerto TraerUnAeropuerto(String filtro) {
        for (Aeropuerto a: aeropuertos){
            if(a.getNombre().contains(filtro)){
                return a;
            }
        }
        return null;
    }
    public List<Aeropuerto> TraerTodosAeropuertos(){

        return aeropuertos;
    }
    //busca por codigo IATA, siempre devuelve 1
    public Aeropuerto TraerPorCriterioAeropuerto(String filtro){

        for (Aeropuerto a: aeropuertos){
            if(a.getCodIATA() == filtro)
                return a;
        }
        return null;
    }
}
