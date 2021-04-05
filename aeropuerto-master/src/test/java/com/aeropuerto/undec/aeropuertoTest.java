package com.aeropuerto.undec;
import exceptions.AeropuertoException;
import logica.GestorAeropuerto;
import model.Aeropuerto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
15.	Cargar un aeropuerto nuevo
16.	Modificar un aeropuerto existente
17.	Consultar los aeropuertos
18.	Buscar aeropuerto por código IATA
*/
public class aeropuertoTest {
    @Test
    public void gestorAeropuerto() {
        GestorAeropuerto ga = GestorAeropuerto.getInstance();
        GestorAeropuerto ga1 = GestorAeropuerto.getInstance();
        // actual
        // assert
        assertEquals(true, ga==ga1);
    }

    @Test
    public void cargarAeropuerto() throws AeropuertoException {

        GestorAeropuerto ga = GestorAeropuerto.getInstance();
        Aeropuerto a = new Aeropuerto("EZE", "Ezeiza","Buenos Aires", "1802");
        ga.AgregarAeropuerto(a);
        assertTrue(true );
    }

    @Test
    public void modificarAeropuerto() throws AeropuertoException {

        GestorAeropuerto ga = GestorAeropuerto.getInstance();
        Aeropuerto a = new Aeropuerto("EZE", "Ezeiza","Buenos Aires", "1802");
        ga.AgregarAeropuerto(a);

        assertEquals("EZE", ga.TraerUnAeropuerto("Ezeiza").getCodIATA());
        assertEquals("Ezeiza", ga.TraerUnAeropuerto("Ezeiza").getNombre());
        assertEquals("Buenos Aires", ga.TraerUnAeropuerto("Ezeiza").getCiudad());
        assertEquals("1802", ga.TraerUnAeropuerto("Ezeiza").getCP());


        assertEquals(true,ga.ModificarAeropuerto(ga.TraerUnAeropuerto("Ezeiza"),"NEW",
                "Central Perk","New York","5100"));

    }

    @Test
    public void consultarAeropuertos() throws AeropuertoException{
        GestorAeropuerto ga = GestorAeropuerto.getInstance();
        Aeropuerto a = new Aeropuerto("EZE", "Ezeiza","Buenos Aires", "1802");
        ga.AgregarAeropuerto(a);
        a = new Aeropuerto("EZE", "Ezeiza","Buenos Aires", "1802");
        a=new Aeropuerto("NEW", "Central Perk","New York", "5100");
        ga.AgregarAeropuerto(a);
        a=new Aeropuerto("FRA", "Frankfurt","San Pablo-Viracopos", "6100");
        ga.AgregarAeropuerto(a);

        //assertEquals(1,ga.TraerTodosAeropuertos().size());
        assertEquals(3,ga.TraerTodosAeropuertos().size());

    }

    @Test
    public void buscarAeropuertoXCodigoIATA() throws AeropuertoException{
        GestorAeropuerto ga = GestorAeropuerto.getInstance();
        Aeropuerto a = new Aeropuerto("EZE", "Ezeiza","Buenos Aires", "1802");
        ga.AgregarAeropuerto(a);
        a=new Aeropuerto("NEW", "Central Perk","New York", "5100");
        ga.AgregarAeropuerto(a);
        a=new Aeropuerto("FRA", "Frankfurt","San Pablo-Viracopos", "6100");
        ga.AgregarAeropuerto(a);


        assertEquals("San Pablo-Viracopos", ga.TraerPorCriterioAeropuerto("FRA").getCiudad());
    }
}
