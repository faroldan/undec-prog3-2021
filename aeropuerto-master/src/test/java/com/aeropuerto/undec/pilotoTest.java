package com.aeropuerto.undec;

import exceptions.PilotoException;
import logica.GestorPiloto;
import model.Piloto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
6.	Cargar un piloto nuevo
7.	Modificar un piloto existente
8.	Consultar pilotos
9.	Buscar un piloto por legajo
10.	Buscar pilotos por apellido
11.	Consultar horas de vuelo de un piloto

 */
public class pilotoTest {
    @Test
    public void gestorPiloto(){
        GestorPiloto gp = GestorPiloto.getInstance();
        GestorPiloto gp1 = GestorPiloto.getInstance();
        // assert
        Assertions.assertEquals(true, gp==gp1);
    }
    @Test
    public void cargarPiloto() throws PilotoException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha=sdf.parse("1980-01-20");

        GestorPiloto gp = GestorPiloto.getInstance();
        Piloto a = new Piloto(0, "23-45678394-5", "Boun","Voyage", fecha);

        assertEquals(true,gp.AgregarPiloto(a) );
    }
    @Test
    public void modificarPiloto() throws PilotoException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha=sdf.parse("1980-01-20");
        GestorPiloto gp = GestorPiloto.getInstance();
        Piloto a = new Piloto(0, "23-45678394-5", "Boun","Voyage", fecha);
        gp.AgregarPiloto(a);

        fecha = sdf.parse("1979-02-28");
        assertEquals(true,gp.ModificarPiloto(gp.TraerUnPiloto("23-45678394-5"),
                "23-45678394-5", "Boun","Voyage", fecha));
    }
    @Test
    public void consultarPilotos() throws PilotoException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha=sdf.parse("1980-01-20");
        GestorPiloto gp = GestorPiloto.getInstance();
        Piloto a = new Piloto(0, "23-45678394-5", "Boun","Voyage", fecha);
        gp.AgregarPiloto(a);
        a = new Piloto(1, "23-45555394-5", "Riparto","Oran", fecha);
        gp.AgregarPiloto(a);
        a = new Piloto(2, "22-45678224-3", "De La Olla","Pepe", fecha);
        gp.AgregarPiloto(a);
        a = new Piloto(3, "20-11178394-1", "Fruta","Mema", fecha);
        gp.AgregarPiloto(a);

        assertEquals(4,
                gp.TraerTodosPilotos().size());
    }
    @Test
    public void buscarPilotoXLegajo() throws PilotoException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha=sdf.parse("1980-01-20");
        GestorPiloto gp = GestorPiloto.getInstance();
        Piloto a = new Piloto(0, "23-45678394-5", "Boun","Voyage", fecha);
        gp.AgregarPiloto(a);
        a = new Piloto(1, "23-45555394-5", "Riparto","Oran", fecha);
        gp.AgregarPiloto(a);
        a = new Piloto(2, "22-45678224-3", "De La Olla","Pepe", fecha);
        gp.AgregarPiloto(a);
        a = new Piloto(3, "20-11178394-1", "Fruta","Mema", fecha);
        gp.AgregarPiloto(a);


        assertEquals("De La Olla", gp.TraerPorCriterioPiloto(2).getApellido());
    }
    @Test
    public void buscarPilotoXApellido() throws ParseException, PilotoException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha=sdf.parse("1980-01-20");
        GestorPiloto gp = GestorPiloto.getInstance();
        Piloto a = new Piloto(0, "23-45678394-5", "Boun","Voyage", fecha);
        gp.AgregarPiloto(a);
        a = new Piloto(1, "23-45555394-5", "Riparto","Oran", fecha);
        gp.AgregarPiloto(a);
        a = new Piloto(2, "22-45678224-3", "De La Olla","Pepe", fecha);
        gp.AgregarPiloto(a);
        a = new Piloto(3, "20-11178394-1", "Fruta","Mema", fecha);
        gp.AgregarPiloto(a);


        assertEquals("Riparto", gp.TraerPorCriterioPiloto("Riparto").getApellido());

    }
    @Test
    public void consultarHorasVuelo(){
    }
}
