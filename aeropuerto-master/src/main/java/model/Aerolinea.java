package model;

import exceptions.AerolineaException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Aerolinea extends AerolineaException {

    private String cuit;
    private String CodIATA;
    private String nombre;
    private Date fechaInicioAct;

    public Aerolinea(String pcuit, String pCodIATA, String pnombre, Date pfechaInicioAct) throws AerolineaException {
        Pattern p = Pattern.compile("[[0-9]{2}-[0-9]{8}-[0-9]{1}]");
        Matcher m;
        if (pcuit != null ) {
            m = p.matcher(pcuit);
            if (m.find()) {
                this.cuit = pcuit;
            } else {
                throw new AerolineaException("El CUIT no posee el formato correcto");
            }
            if (pCodIATA!= null)
                    this.CodIATA = pCodIATA;
            else
                throw new AerolineaException("El CodIATA no puede ser nulo");
            if (pfechaInicioAct != null)
                this.fechaInicioAct = pfechaInicioAct;
            else
                throw new AerolineaException("La fecha de inicio de actividad no puede ser nula");
            if (pnombre != null)
                this.nombre = pnombre;
            else
                throw new AerolineaException("El nombre no puede ser nulo");
        }
        else {throw new AerolineaException();}
    }

    public void setCuit(String pcuit) {
        this.cuit = pcuit;
    }

    public void setCodIATA(String pcodIATA) {
        CodIATA = pcodIATA;
    }

    public void setNombre(String pnombre) {
        this.nombre = pnombre;
    }

    public void setFechaInicioAct(Date pfechaInicioAct) {
        this.fechaInicioAct = pfechaInicioAct;
    }

    public String getCuit() {
        return cuit;
    }

    public String getCodIATA() {
        return CodIATA;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechaInicioAct() {
        return fechaInicioAct;
    }
}