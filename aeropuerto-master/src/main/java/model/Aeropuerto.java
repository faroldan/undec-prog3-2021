package model;

import exceptions.AeropuertoException;
import exceptions.AvionException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Aeropuerto extends AeropuertoException{
    private String CodIATA;
    private String nombre;
    private String ciudad;
    private String CP;
    private static Pattern p=Pattern.compile("[[A-Z]{3}]");
    private Matcher m;
    public Aeropuerto(String pcodIATA, String pnombre, String pciudad, String pCP) throws AeropuertoException{

        if (pcodIATA!=null && pnombre!=null && pciudad!=null&& pCP!=null){
            m=p.matcher(pcodIATA);
            if (m.find()) {
                CodIATA = pcodIATA;
            }else{
                throw new AeropuertoException("El codigo IATA no posee el formato correcto");
            }
            this.nombre = pnombre;
            this.ciudad = pciudad;
            this.CP = pCP;
        }
        else {throw new AeropuertoException();}
    }

    public String getCodIATA() {
        return CodIATA;
    }

    public void setCodIATA(String pcodIATA)throws AeropuertoException {
        m=p.matcher(pcodIATA);
        if (m.find()) {
            CodIATA = pcodIATA;
        }else{
            throw new AeropuertoException("El codigo IATA no posee el formato correcto");
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String pnombre) {
        this.nombre = pnombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String pciudad) {
        this.ciudad = pciudad;
    }

    public String getCP() {
        return CP;
    }

    public void setCP(String pCP) {
        this.CP = pCP;
    }
}
