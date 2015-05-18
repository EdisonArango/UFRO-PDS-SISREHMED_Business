package pruebas;

import static org.junit.Assert.*;

import org.junit.Test;
import org.orm.PersistentException;

import control.servicios.Reserva;
import control.util.Utilidades;
import control.webservices.SISREHMED_WS;

public class PruebasJunit {

	@Test
	public void testWS() {
		String respuesta = new SISREHMED_WS().obtenerTodosLosMedicos();
		System.out.println(respuesta);
		assertTrue(respuesta!=null);
	}
	
	@Test
	public void testWSBoxes() {
		String respuesta = new SISREHMED_WS().obtenerBoxes();
		System.out.println(respuesta);
		assertTrue(respuesta!=null);
	}
	
	@Test
	public void testWSOcupacionBox() {
		int respuesta = new SISREHMED_WS().obtenerPorcentajeOcupacionBox(1, "10/04/2015", "10/06/2015");
		System.out.println(respuesta);
		assertTrue(respuesta==71);
	}
	
	@Test
	public void testWSOcupacionMedico() {
		int respuesta = new SISREHMED_WS().obtenerPorcentajeOcupacionMedico(1, "10/04/2015", "10/06/2015");
		System.out.println(respuesta);
		assertTrue(respuesta==80);
	}
	
	@Test
	public void testReservaNoEsAPS() throws PersistentException{
		String respuesta = Reserva.reservarHoraAPS(9, 1);
		assertTrue (respuesta=="Hora no es APS");
	}
	
	@Test
	public void testReservaAPSPacienteYaLaReservo() throws PersistentException{
		String respuesta = Reserva.reservarHoraAPS(10, 1);
		assertTrue (respuesta=="Paciente ya ha reservado la hora");
	}
	
	@Test
	public void testReservaAPSYaEstaReservada() throws PersistentException{
		String respuesta = Reserva.reservarHoraAPS(11, 2);
		assertTrue (respuesta=="La hora ya esta reservada");
	}
	
	@Test
	public void testReservaAPSPacienteConTopon() throws PersistentException{
		String respuesta = Reserva.reservarHoraAPS(12, 1);
		assertTrue (respuesta=="Paciente no esta libre en hora a reservar");
	}
	
	@Test
	public void testReservaAPSReservaCorrecta() throws PersistentException{
		String respuesta = Reserva.reservarHoraAPS(8, 2);
		System.out.println(respuesta);
		assertTrue (Utilidades.isNumeric(respuesta));
	}
	
	@Test
	public void testReservaControlReservaCorrecta() throws PersistentException{
		int[] enteros = {9,13};
		String respuesta = Reserva.reservarHoraControl(enteros, 2);
		System.out.println(respuesta);
		assertTrue (Utilidades.isNumeric(respuesta.split(",")[0]));
	}

}
