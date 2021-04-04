package model;

import exceptions.AvionException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Avion extends AvionException{
    private String matricula;
    private String modelo;
    private int capacidad;
    private int anio_fab;
    private static Pattern p=Pattern.compile("[[A-Z]{2}-[A-Z]{3}]");
    private Matcher m;
    public Avion(String pmatricula, String pmodelo, int pcapacidad, int panio_fab)  throws AvionException {

        if (pmatricula!=null && pmodelo!=null && pcapacidad > 0 && panio_fab >0){
            m=p.matcher(pmatricula);
            if (m.find()) {
                this.matricula = pmatricula;
            }else{
                throw new AvionException("La matricula no posee el formato correcto");
            }
            this.modelo = pmodelo;
            this.capacidad = pcapacidad;
            this.anio_fab = panio_fab;
        }
        else {throw new AvionException();}
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String pmatricula)  throws AvionException {
        m=p.matcher(pmatricula);
        if (m.find()) {
            this.matricula = pmatricula;
        }else{
            throw new AvionException("La matricula no posee el formato correcto");
        }

    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String pmodelo) {
        this.modelo = pmodelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int pcapacidad) {
        this.capacidad = pcapacidad;
    }

    public int getAnio_fab() {
        return anio_fab;
    }

    public void setAnio_fab(int panio_fab) {
        this.anio_fab = panio_fab;
    }
}
