package logica;


import exceptions.AerolineaException;
import model.Aerolinea;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class GestorAerolinea {
    List<Aerolinea> aerolineas = new ArrayList<Aerolinea>();
    static private GestorAerolinea ga;

    private GestorAerolinea(ArrayList<Aerolinea> arrayList) {
        aerolineas = arrayList;
    }

    static public GestorAerolinea getInstance() {
        if (ga == null) {
            ga = new GestorAerolinea(new ArrayList<Aerolinea>());
        }
        return ga;

    }

    public boolean AgregarAerolinea(Aerolinea data) {
        if (aerolineas.size() == 0){
            aerolineas.add(data);
            return true;
        }
        else {
            for (Aerolinea control : aerolineas) {
                if (control.getCodIATA()!= data.getCodIATA()) {
                    aerolineas.add(data);
                    return true;
                } else
                    return false;
            }
            return false;
        }

    }



    public boolean ModificarAerolinea(Aerolinea mod, String cuit, String CodIATA, String nombre, Date fechaInicioAct){
        for (Aerolinea a: aerolineas){
            if (a == mod){
                    a.setCuit(cuit);
                    a.setCodIATA(CodIATA);
                    a.setNombre(nombre);
                    a.setFechaInicioAct(fechaInicioAct);
                return true;
            }
        }
        return false;
    }
    public boolean BorrarAerolinea(Aerolinea mod){

                return aerolineas.remove(mod);
    }
    //criterio de busqueda: nombre
    public Aerolinea TraerUnaAerolinea(String filtro) {
        for (Aerolinea a: aerolineas){
            if(a.getNombre()==filtro)
                    return a;
        }
        return null;
    }
    public List<Aerolinea> TraerTodasAerolinea(){

        return aerolineas;
    }
    //busca por parte del Nombre
    public List<Aerolinea> TraerPorCriterioAerolinea(String filtro){
        List<Aerolinea> ret= new ArrayList<Aerolinea>();
        for (Aerolinea a: aerolineas){
            if(a.getNombre().contains(filtro))
                 ret.add(a);
        }
        return ret;
    }
}
