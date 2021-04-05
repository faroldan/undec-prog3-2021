package logica;


import exceptions.VuelosException;
import model.Vuelo;

import java.util.ArrayList;
import java.util.List;

public class GestorVuelo {
    List<Vuelo> vuelos = new ArrayList<Vuelo>();
    static private GestorVuelo gv;

    private GestorVuelo(ArrayList<Vuelo> arrayList) {
        vuelos = arrayList;
    }

    static public GestorVuelo getInstance() {
        if (gv == null) {
            gv = new GestorVuelo(new ArrayList<Vuelo>());
        }
        return gv;
    }

    public boolean AgregarVuelo(Vuelo data) {
        if (vuelos.size() == 0) {
            vuelos.add(data);
            return true;
        } else {
            for (Vuelo control : vuelos) {
                if (control.getCodVuelo() != data.getCodVuelo()) {
                    vuelos.add(data);
                    return true;
                } else
                    return false;
            }
            return false;
        }

        public boolean ModificarVuelo() throws
        VuelosException {

        }


    }

}
