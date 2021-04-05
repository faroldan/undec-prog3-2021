package com.aeropuerto.undec;

import exceptions.AerolineaException;
import logica.GestorAerolinea;
import model.Aerolinea;
import org.junit.jupiter.api.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/*
12.	Cargar una aerolínea nueva
13.	Modificar una aerolínea existente
14.	Buscar aerolíneas por nombre
*/
public class aerolineaTest {


        @Test
        public void gestorAerolinea() {
                // arrange
                GestorAerolinea ga = GestorAerolinea.getInstance();
                GestorAerolinea ga1 = GestorAerolinea.getInstance();
                // actual
                // assert
                assertEquals(true, ga==ga1);
        }

        @Test
        public void cargarAerolinea() throws AerolineaException, ParseException {

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                GestorAerolinea ga = GestorAerolinea.getInstance();
                Date fecha =sdf.parse("1980-01-20");
                Aerolinea a = new Aerolinea("30-43728472-3", "AR","Austral",fecha);
                ga.AgregarAerolinea(a);
                assertTrue(true );

        }

        @Test
        public void ModificarAerolinea() throws AerolineaException,ParseException{

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                GestorAerolinea ga = GestorAerolinea.getInstance();
                Date fecha=sdf.parse("1980-01-20");
                Aerolinea a = new Aerolinea("30-43728472-3", "AR","Austral",fecha);
                ga.AgregarAerolinea(a);

                assertEquals("30-43728472-3", ga.TraerUnaAerolinea("Austral").getCuit());
                assertEquals("AR", ga.TraerUnaAerolinea("Austral").getCodIATA());
                assertEquals("Austral", ga.TraerUnaAerolinea("Austral").getNombre());
                assertEquals(fecha, ga.TraerUnaAerolinea("Austral").getFechaInicioAct());

                fecha =sdf.parse("1982-01-20");
                assertEquals(true,ga.ModificarAerolinea(ga.TraerUnaAerolinea("Austral"),"30-54738823-3","AR","Austral",fecha));


        }

        @Test
        public void BuscarAerolineaPorNombre() throws AerolineaException,ParseException{

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                GestorAerolinea ga = GestorAerolinea.getInstance();
                Date fecha=sdf.parse("1980-01-20");
                Aerolinea a = new Aerolinea("30-43728472-3", "AR","Austral",fecha);
                ga.AgregarAerolinea(a);

               assertEquals("30-43728472-3",ga.TraerUnaAerolinea("Austral").getCuit());
        }
}
