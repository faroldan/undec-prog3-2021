package model;

import exceptions.PilotoException;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Piloto extends PilotoException{
    private String cuil;
    private int legajo;
    private String apellido;
    private String nombre;
    private Date fechaNac;
    private static Pattern p= Pattern.compile("[[0-9]{2}-[0-9]{8}-[0-9]{1}]");
    private Matcher m;

    public Piloto(int plegajo, String pcuil, String papellido, String pnombre, Date pfechaNac) throws PilotoException {


        if(plegajo >= 0 && pcuil != null && papellido!= null && pnombre!= null && pfechaNac!= null){
             m= p.matcher(pcuil);
            if(m.find()){this.cuil = pcuil; } else { throw new PilotoException("El CUIL no posee el formato correcto");}
            this.apellido = papellido;
            this.nombre = pnombre;
            this.fechaNac = pfechaNac;
            this.legajo = plegajo;
        } else{throw new PilotoException(); }
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String pcuil) throws PilotoException {
        m= p.matcher(pcuil);
        if(m.find()){this.cuil = pcuil; } else { throw new PilotoException("El CUIL no posee el formato correcto");}
        this.cuil = cuil;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String papellido) {
        this.apellido = papellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String pnombre) {
        this.nombre = pnombre;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date pfechaNac) {
        this.fechaNac = pfechaNac;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }
}
