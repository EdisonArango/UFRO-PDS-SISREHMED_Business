package control.webservices;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

import modelo.hospital.Box;
import modelo.hospital.Especialidad;
import modelo.hospital.HoraMedica;
import modelo.personas.Medico;
import modelo.personas.Paciente;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
			jo.put("nombre", medicos[i].getNombre());
			array.add(jo);
		}
		JSONObject joResult = new JSONObject();
		joResult.put("medicos", array);
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
			System.out.println(jo.get("fecha"));
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
				jo.put("nombre", ((Medico)medico).getNombre());
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
				jo.put("nombre", ((Paciente)paciente).getNombre());
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

}
