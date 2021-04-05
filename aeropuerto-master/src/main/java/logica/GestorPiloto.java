package logica;

import exceptions.PilotoException;
import model.Piloto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestorPiloto extends PilotoException {
        List<Piloto> pilotos;
        static private GestorPiloto gp;

        private GestorPiloto(ArrayList<Piloto> arrayList) {
            pilotos = arrayList;
        }

        static public GestorPiloto getInstance() {
            if (gp == null) {
                gp = new GestorPiloto(new ArrayList<Piloto>());
            }
            return gp;

        }
        public boolean AgregarPiloto(Piloto data) throws PilotoException{
            if (pilotos.size() == 0){
                return pilotos.add(data);

            }
            else {
                for (Piloto control : pilotos) {
                    if (control.getCuil()!= data.getCuil()) {
                        return pilotos.add(data);

                    } else
                        return false;
                }

            }
            return false;
        }
        public boolean ModificarPiloto(Piloto mod, String pcuil, String papellido, String pnombre,
                                      Date fechaNac) throws PilotoException {
            for (Piloto p: pilotos){
                if (p.getCuil()== mod.getCuil()){

                    p.setCuil(pcuil);
                    p.setApellido(papellido);
                    p.setNombre(pnombre);
                    p.setFechaNac(fechaNac);
                    return true;
                }
            }
            return false;
        }
        public boolean BorrarPiloto(Piloto mod){
            for (Piloto p : pilotos) {
                if(p.getCuil() == mod.getCuil())
                    return pilotos.remove(mod);
            }
            return false;
        }
        //criterio de busqueda: Cuil
        public Piloto TraerUnPiloto(String filtro) {
            for (Piloto p: pilotos){
                if(p.getCuil() == filtro){
                    return p;
                }
            }
            return null;
        }
        public List<Piloto> TraerTodosPilotos(){

            return pilotos;
        }
        //busca por legajo, siempre devuelve 1
        public Piloto TraerPorCriterioPiloto(int filtro){

            for (Piloto p: pilotos){
                if(p.getLegajo()== filtro)
                    return p;
            }
            return null;
        }
        //busca por apellido, siempre devuelve 1
        public Piloto TraerPorCriterioPiloto(String filtro){

            for (Piloto p: pilotos){
                if(p.getApellido()== filtro)
                    return p;
            }
            return null;
        }
    }