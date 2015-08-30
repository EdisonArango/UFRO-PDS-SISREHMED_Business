package control.webservices;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

import modelo.hospital.Box;
import modelo.hospital.Especialidad;
import modelo.hospital.HoraMedica;
import modelo.personas.Director;
import modelo.personas.Medico;
import modelo.personas.Paciente;
import modelo.personas.Persona;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.orm.PersistentException;

import control.servicios.Reporte;
import control.servicios.Reserva;
import control.util.Utilidades;

/**
 *
 * @author edisonarango
 */
public class SISREHMED_WS {

	/**
	 * Obtiene todas las especialidades
	 * @return Json con id y nombre de todas las especialidades
	 */
	public String obtenerEspecialidades(){
		Especialidad[] especialidades = new Especialidad[0];
		try {
			especialidades = Especialidad.obtenerTodasLasEspecialidades();
		} catch (Exception e) {
			return "Error";
		}
		JSONObject jo;
		JSONArray array = new JSONArray();
		for (int i = 0; i < especialidades.length; i++) {
			jo=new JSONObject();
			jo.put("id", especialidades[i].getId());
			jo.put("nombre", especialidades[i].getNombre());
			array.add(jo);
		}
		JSONObject joResult = new JSONObject();
		joResult.put("especialidades", array);
		return joResult.toJSONString();
	}
	
	public String obtenerTodosLosMedicos(){
		Medico[] medicos = new Medico[0];
		try {
			medicos = Medico.obtenerTodosLosMedicos();
		} catch (Exception e) {
			return "Error";
		}
		JSONObject jo;
		JSONArray array = new JSONArray();
		for (int i = 0; i < medicos.length; i++) {
			jo=new JSONObject();
			jo.put("id", medicos[i].getId());
			jo.put("nombre", medicos[i].getNombre()+" "+medicos[i].getApellido());
			array.add(jo);
		}
		JSONObject joResult = new JSONObject();
		joResult.put("medicos", array);
		return joResult.toJSONString();
	}
	
	public String obtenerTodosLosPacientes(){
		Paciente[] pacientes = new Paciente[0];
		try {
			pacientes = Paciente.obtenerTodosLosPacientes();
		} catch (Exception e) {
			return "Error";
		}
		JSONObject jo;
		JSONArray array = new JSONArray();
		for (int i = 0; i < pacientes.length; i++) {
			jo=new JSONObject();
			jo.put("id", pacientes[i].getId());
			jo.put("nombre", pacientes[i].getNombre()+" "+pacientes[i].getApellido());
			array.add(jo);
		}
		JSONObject joResult = new JSONObject();
		joResult.put("pacientes", array);
		return joResult.toJSONString();
	}
	
	public String buscarHoraAPSPorMedico (int idMedico, String fechaIn, String fechaFin) {
		ArrayList<HoraMedica> horasEncontradas = new ArrayList<>();
		try {
			horasEncontradas = Reserva.buscarHorasAPSPorMedico(idMedico, fechaIn, fechaFin);
		} catch (Exception e) {
			return "Error";
		}
		
		JSONObject jo;
		JSONArray array = new JSONArray();
		for (int i = 0; i < horasEncontradas.size(); i++) {
			jo=new JSONObject();
			jo.put("id", horasEncontradas.get(i).getId());
			jo.put("fecha", horasEncontradas.get(i).getFecha());
			jo.put("hora", horasEncontradas.get(i).getHora());
			jo.put("box", horasEncontradas.get(i).getBox().getNombre());
			array.add(jo);
		}
		JSONObject joResult = new JSONObject();
		joResult.put("horasEncontradas", array);
		return joResult.toJSONString();
	}
	
	public String buscarHoraAPSPorEspecialidad (int idEspecialidad, String fechaIn, String fechaFin){
		ArrayList<HoraMedica> horasEncontradas = new ArrayList<>();
		try {
			horasEncontradas = Reserva.buscarHorasAPSPorEspecialidad(idEspecialidad, fechaIn, fechaFin);
		} catch (Exception e) {
			return "Error";
		}
		
		JSONObject jo;
		JSONArray array = new JSONArray();
		for (int i = 0; i < horasEncontradas.size(); i++) {
			jo=new JSONObject();
			jo.put("id", horasEncontradas.get(i).getId());
			jo.put("fecha", horasEncontradas.get(i).getFecha());
			jo.put("hora", horasEncontradas.get(i).getHora());
			jo.put("medico", horasEncontradas.get(i).medico.getNombre()+" "+horasEncontradas.get(i).medico.getApellido());
			jo.put("box", horasEncontradas.get(i).getBox().getNombre());
			array.add(jo);
		}
		JSONObject joResult = new JSONObject();
		joResult.put("horasEncontradas", array);
		return joResult.toJSONString();
	}
	
	public String buscarSusHorasMedicas (int idMedico, String fechaIn, String fechaFin) {
		ArrayList<HoraMedica> horasEncontradas = new ArrayList<>();
		try {
			horasEncontradas = Reserva.buscarSusHorasMedicas(idMedico, fechaIn, fechaFin);
		} catch (Exception e) {
			return "Error";
		}
		
		JSONObject jo;
		JSONArray array = new JSONArray();
		for (int i = 0; i < horasEncontradas.size(); i++) {
			jo=new JSONObject();
			jo.put("id", horasEncontradas.get(i).getId());
			jo.put("fecha", horasEncontradas.get(i).getFecha());
			jo.put("hora", horasEncontradas.get(i).getHora());
			jo.put("box", horasEncontradas.get(i).getBox().getNombre());
			if(horasEncontradas.get(i).horaReservada()){
				jo.put("reservado", "si");
				jo.put("paciente", horasEncontradas.get(i).paciente.getNombre()+" "+horasEncontradas.get(i).paciente.getApellido());
			}
			else{
				jo.put("reservado", "no");
			}
			if(horasEncontradas.get(i).horaEsAPS()){
				jo.put("tipo", "APS");
			}
			else{
				jo.put("tipo", "Control");
			}
			array.add(jo);
		}
		JSONObject joResult = new JSONObject();
		joResult.put("horasEncontradas", array);
		return joResult.toJSONString();
	}
	
	public String reservarHoraAPS (int idHoraMedica,int idPaciente){
		String respuesta;
		try {
			respuesta = Reserva.reservarHoraAPS(idHoraMedica, idPaciente);
			return respuesta;
		} catch (Exception e) {
			return "Error";
		}
	}
	
	/**
	 * Reserva horas de control
	 * @param horasMedicas String contenedor de ids de horas medicas en formato: id1,id2,id3
	 * @param idPaciente id del paciente con el cual reservar horas
	 * @return String con numero de reserva o de error
	 */
	public String reservarHoraControl (String idshorasMedicas,int idPaciente){
		String arrayHoras[] = idshorasMedicas.split(",");
		int idHoras[] = new int[arrayHoras.length];
		for (int i = 0; i < arrayHoras.length; i++) {
			if (Utilidades.isNumeric(arrayHoras[i])) {
				idHoras[i] = Integer.valueOf(arrayHoras[i]);
			}
			else{
				return "Error leyendo ids de horas médicas";
			}
		}
		String respuesta;
		try {
			respuesta = Reserva.reservarHoraControl(idHoras, idPaciente);
			return respuesta;
		} catch (Exception e) {
			return "Error";
		}
	}
	
	/**
	 * Obtiene todos los boxes
	 * @return Json con id y nombre de todos los boxes
	 */
	public String obtenerBoxes(){
		Box[] boxes = new Box[0];
		try {
			boxes = Box.obtenerTodosLosBoxes();
		} catch (Exception e) {
			return "Error";
		}
		JSONObject jo;
		JSONArray array = new JSONArray();
		for (int i = 0; i < boxes.length; i++) {
			jo=new JSONObject();
			jo.put("id", boxes[i].getId());
			jo.put("nombre", boxes[i].getNombre());
			array.add(jo);
		}
		JSONObject joResult = new JSONObject();
		joResult.put("boxes", array);
		return joResult.toJSONString();
	}
	
	public int obtenerPorcentajeOcupacionBox (int idBox,String fechaIn, String fechaFin){
		try {
			return Reporte.obtenerPorcentajeOcupacionDeBox(idBox, fechaIn, fechaFin);
		} catch (Exception e) {
			return -1;
		}
	}
	
	public int obtenerPorcentajeOcupacionMedico (int idMedico,String fechaIn, String fechaFin){
		try {
			return Reporte.obtenerPorcentajeOcupacionDeMedico(idMedico, fechaIn, fechaFin);
		} catch (Exception e) {
			return -1;
		}
	}
	
	public String obtenerMedicosMasSolicitados (String fechaIn,String fechaFin){
		try {
			LinkedHashMap<Object,Integer> mapaMedicos = Reporte.obtenerMedicosMasSolicitados(fechaIn, fechaFin);
			Iterator<Object> keySetIterator = mapaMedicos.keySet().iterator();
			JSONObject jo;
			JSONArray array = new JSONArray();
			while(keySetIterator.hasNext()){
				Object medico = keySetIterator.next();
				jo=new JSONObject();
				jo.put("id", ((Medico)medico).getId());
				jo.put("nombre", ((Medico)medico).getNombre()+" "+((Medico)medico).getApellido());
				jo.put("cantidad", mapaMedicos.get(medico));
				array.add(jo);
			}
			JSONObject joResult = new JSONObject();
			joResult.put("medicos", array);
			return joResult.toJSONString();
		} catch (Exception e) {
			return "Error";
		}
	}
	
	public String obtenerPacientesQueMasReservan (String fechaIn,String fechaFin){
		try {
			LinkedHashMap<Object,Integer> mapaPacientes = Reporte.obtenerPacientesQueMasReservan(fechaIn, fechaFin);
			Iterator<Object> keySetIterator = mapaPacientes.keySet().iterator();
			JSONObject jo;
			JSONArray array = new JSONArray();
			while(keySetIterator.hasNext()){
				Object paciente = keySetIterator.next();
				jo=new JSONObject();
				jo.put("id", ((Paciente)paciente).getId());
				jo.put("nombre", ((Paciente)paciente).getNombre()+" "+((Paciente)paciente).getApellido());
				jo.put("cantidad", mapaPacientes.get(paciente));
				array.add(jo);
			}
			JSONObject joResult = new JSONObject();
			joResult.put("pacientes", array);
			return joResult.toJSONString();
		} catch (Exception e) {
			return "Error";
		}
	}
	
	public String obtenerNombreDeMedico (int idMedico){
		try {
			Medico medico = Medico.cargarMedicoPorId(idMedico);
			return medico.getNombre()+" "+medico.getApellido();
		} catch (Exception e) {
			return "Error";
		}
	}
	
	public String obtenerNombreDeBox (int idBox){
		try {
			return Box.cargarBoxPorId(idBox).getNombre();
		} catch (Exception e) {
			return "Error";
		}
	}
	
	public String loginPacienteFacebook (String datos){
		
		try{
			Object obj=JSONValue.parse(datos);
			JSONObject paciente = (JSONObject)obj;
			if (Paciente.noRegistradoFacebook(paciente.get("id").toString())){
				return Paciente.crearPacienteFacebook(paciente.get("id").toString(), paciente.get("first_name").toString(),
						paciente.get("last_name").toString(), paciente.get("email").toString());
			}
			else{
				return Paciente.cargarPacienteFacebook(paciente.get("id").toString());
			}
		} catch (Exception e) {
			JSONObject respuesta=new JSONObject();
			respuesta.put("mensaje", "danger;Error!;Sucedió un error en el registro");
			return respuesta.toJSONString();
		}
	}
	
	public String login (String usuario,String pass){
		try {
			JSONObject respuesta=new JSONObject();
			if(Persona.usuarioExiste(usuario)){
				if(Paciente.existe(usuario,pass)){
					respuesta = Paciente.login(usuario, pass);
					respuesta.put("rol", "paciente");
					respuesta.put("mensaje", "success;Login exitoso!; ");
				}
				else if(Medico.existe(usuario,pass)){
					respuesta = Medico.login(usuario, pass);
					respuesta.put("rol", "medico");
					respuesta.put("mensaje", "success;Login exitoso!; ");
				}
				else if(Director.existe(usuario,pass)){
					respuesta = Director.login(usuario, pass);
					respuesta.put("rol", "director");
					respuesta.put("mensaje", "success;Login exitoso!; ");
				}
				else if (Persona.existe(usuario,pass)){
					respuesta = Persona.login(usuario, pass);
					respuesta.put("rol", "administrador");
					respuesta.put("mensaje", "success;Login exitoso!; ");
				}
				else{
					respuesta.put("mensaje", "danger;Contraseña incorrecta!;La contraseña ingresada es incorrecta");
				}
				return respuesta.toJSONString();
			}
			else{
				System.out.println("Usuario no existe");
				respuesta.put("mensaje", "danger;Error!;Usuario no registrado");
				return respuesta.toJSONString();
			}
		} catch (Exception e) {
			e.printStackTrace();
			JSONObject respuesta=new JSONObject();
			respuesta.put("mensaje", "danger;Error!;Hubo un problema en el login, por favor, intente de nuevo");
			return respuesta.toJSONString();
		}
	}
	
	public String crearCupo (String fecha, String hora, String aps, String idMedico, String idBox){
		return HoraMedica.crearCupo(fecha, hora, aps, idMedico, idBox);
	}
	
//	public String eliminarCupo (){
//		
//	}
//	
//	public String modificarCupo (){
//		
//	}

}
