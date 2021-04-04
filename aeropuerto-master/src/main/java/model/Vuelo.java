package model;

import exceptions.AvionException;
import exceptions.PilotoException;
import exceptions.VuelosException;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vuelo extends VuelosException {

    private String codVuelo;
    private Date salida;
    private Date arribo;
    private String aeropuertoSalida;
    private String aeropuertoArribo;
    private String avion;
    private List<Piloto> tripulacion;
    private String aerolinea;
    private static Pattern p=Pattern.compile("[[A-Z]{2} [0-9]{4}]");
    private Matcher m=null;
    public Vuelo(String codVuelo, Date salida, Date arribo, String aeropuertoSalida, String aeropuertoArribo,
                 String avion, List<Piloto> tripulacion, String aerolinea) throws VuelosException, PilotoException {

        if (codVuelo !=null && salida!=null && arribo!=null&& aeropuertoSalida!=null&&
                aeropuertoArribo!=null && avion!=null && !tripulacion.isEmpty() && aerolinea!=null) {
            m= p.matcher(codVuelo);
            if(m.find()){this.codVuelo = codVuelo; } else { throw new PilotoException("El CUIL no posee el formato correcto");}

            this.salida = salida;
            this.arribo = arribo;
            this.aeropuertoSalida = aeropuertoSalida;
            this.aeropuertoArribo = aeropuertoArribo;
            this.avion = avion;
            this.tripulacion = tripulacion;
            this.aerolinea = aerolinea;
        }
        else{throw new VuelosException();}
    }

    public String getCodVuelo() {
        return codVuelo;
    }

    public void setCodVuelo(String codVuelo) {
        this.codVuelo = codVuelo;
    }

    public Date getSalida() {
        return salida;
    }

    public void setSalida(Date salida) {
        this.salida = salida;
    }

    public Date getArribo() {
        return arribo;
    }

    public void setArribo(Date arribo) {
        this.arribo = arribo;
    }

    public String getAeropuertoSalida() {
        return aeropuertoSalida;
    }

    public void setAeropuertoSalida(String aeropuertoSalida) {
        this.aeropuertoSalida = aeropuertoSalida;
    }

    public String getAeropuertoArribo() {
        return aeropuertoArribo;
    }

    public void setAeropuertoArribo(String aeropuertoArribo) {
        this.aeropuertoArribo = aeropuertoArribo;
    }

    public String getAvion() {
        return avion;
    }

    public void setAvion(String avion) {
        this.avion = avion;
    }

    public List<Piloto> getTripulacion() {
        return tripulacion;
    }

    public void setTripulacion(List<Piloto> tripulacion) {
        this.tripulacion = tripulacion;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }
}
