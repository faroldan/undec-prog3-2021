package com.aeropuerto.undec;

import exceptions.AeropuertoException;
import exceptions.AvionException;
import logica.GestorAeropuerto;
import logica.GestorAvion;
import logica.GestorVuelo;
import model.Aeropuerto;
import model.Avion;
import model.Vuelo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
/*
1.	Cargar un avión nuevo
2.	Modificar un avión existente
3.	Consultar los aviones
4.	Buscar un avión por matrícula
5.	Consultar horas de vuelo de un avión
* */

public class avionTest {
    @Test
    public void gestorAvion(){
        GestorAvion ga = GestorAvion.getInstance();
        GestorAvion ga1 = GestorAvion.getInstance();
        // assert
        Assertions.assertEquals(true, ga==ga1);
    }
    @Test
    public void cargarAvion() throws AvionException {

        GestorAvion ga = GestorAvion.getInstance();
        Avion a = new Avion("LV-FNL", "Boeing 737",120, 2010);

        assertEquals(true, ga.AgregarAvion(a)); // completar
    }
    @Test
    public void modificarAvion() throws AvionException {
        GestorAvion ga = GestorAvion.getInstance();
        Avion a = new Avion("LV-FNL", "Boeing 737",120, 2010);
        ga.AgregarAvion(a);

        assertEquals(true,ga.ModificarAvion(ga.TraerUnAvion("LV-FNL"),"LV-FNK",
                "Boeing 737",200,2010));

    }
    @Test
    public void consultarAviones() throws AvionException {
        GestorAvion ga = GestorAvion.getInstance();
        Avion a = new Avion("LV-FNL", "Boeing 737",120, 2010);
        ga.AgregarAvion(a);
        a = new Avion("LV-FNK", "Boeing 737",125, 2008);
        ga.AgregarAvion(a);
        a = new Avion("LV-FNI", "Boeing 737",100, 2007);
        ga.AgregarAvion(a);
        a = new Avion("LV-FVI", "Boeing 737",120, 2004);
        ga.AgregarAvion(a);

        assertEquals(4,ga.TraerTodosAviones().size());
    }
    @Test
    public void consultarXMatricula() throws AvionException {
        GestorAvion ga = GestorAvion.getInstance();
        Avion  a = new Avion("LV-FNK", "Boeing 737",125, 2008);
        ga.AgregarAvion(a);
        a = new Avion("LV-FNI", "Boeing 737",100, 2007);
        ga.AgregarAvion(a);
        a = new Avion("LV-FVI", "Boeing 737",120, 2004);
        ga.AgregarAvion(a);


        assertEquals("Boeing 737", ga.TraerPorCriterioAvion("LV-FVI").getModelo());
    }
    @Test
    public void consultarHorasAvion(){
    // necesito horas de vuelo de los vuelos realizados
    }
}
