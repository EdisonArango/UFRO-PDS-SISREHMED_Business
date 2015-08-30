package modelo.hospital;

import java.util.ArrayList;

import modelo.personas.Medico;
import modelo.personas.Paciente;
import modelo.personas.Persona;

import org.json.simple.JSONObject;
import org.orm.PersistentException;

import control.util.Utilidades;

public class HoraMedica {
	private int id;
	private int idReserva;
	private boolean esAPS;
	private String fecha;
	private String hora;
	public Paciente paciente;
	public Medico medico;
	public Box box;
	public Persona personaQueRegistra;

	public HoraMedica(int id, int idReserva, boolean esAPS, String fecha, String hora, Paciente paciente, Medico medico, Box box, Persona personaQueRegistra) {
		this.id = id;
		this.idReserva = idReserva;
		this.esAPS = esAPS;
		this.fecha = fecha;
		this.hora = hora;
		this.paciente = paciente;
		this.medico = medico;
		this.box = box;
		this.personaQueRegistra = personaQueRegistra;
	}
	
	public static String crearCupo (String fecha, String hora, String aps, String idMedico, String idBox){
		JSONObject respuesta = new JSONObject();
		try {
		modelo.orm.HoraMedica nuevaHora = modelo.orm.HoraMedicaDAO.createHoraMedica();
		nuevaHora.setFecha(fecha);
		nuevaHora.setHora(hora);
		nuevaHora.setEsAPS(Integer.valueOf(aps));
		nuevaHora.setMedico(modelo.orm.MedicoDAO.loadMedicoByQuery("id="+idMedico, null));
		nuevaHora.setBox(modelo.orm.BoxDAO.loadBoxByQuery("id="+idBox, null));
		modelo.orm.HoraMedicaDAO.save(nuevaHora);
		
		respuesta.put("mensaje", "success;Cupo creado!;Se ha creado el cupo correctamente");
		return respuesta.toJSONString();
		} catch (PersistentException e){
			respuesta.put("mensaje", "danger;Error!;Ha ocurrido un error, por favor intentelo de nuevo más tarde");
			return respuesta.toJSONString();
		}
	}
    
	public static HoraMedica cargarHoraMedicaPorId(int id) throws PersistentException{
        modelo.orm.HoraMedica horaMedicaORM = modelo.orm.HoraMedicaDAO.loadHoraMedicaByQuery("id="+id, null);
        return horaMedicaORMAHoraMedica(horaMedicaORM);
    }

	public boolean horaReservada() {
		return idReserva != -1;
	}

	public boolean horaEsAPS() {
		return esAPS;
	}


	public int guardarReserva(Paciente paciente,boolean registraPaciente) throws PersistentException {
		modelo.orm.Reserva reservaNueva = modelo.orm.ReservaDAO.createReserva();
		reservaNueva.setHoraMedica(horaMedicaAORM());
		reservaNueva.setPaciente(paciente.pacienteAORM());
		if (registraPaciente) {
			reservaNueva.setPersonaQueRegistra(paciente.personaAORM());
		}
		else{
			reservaNueva.setPersonaQueRegistra(medico.personaAORM());
		}
		modelo.orm.ReservaDAO.save(reservaNueva);
		return reservaNueva.getId();
	}
	
	public modelo.orm.HoraMedica horaMedicaAORM() throws PersistentException{
		return modelo.orm.HoraMedicaDAO.loadHoraMedicaByQuery("id="+id,null);
	}

	public static ArrayList<HoraMedica> obtenerHorasLibresMedico(Medico medico, String fechaIn, String fechaFin) throws PersistentException {
		ArrayList<String> fechasRango = Utilidades.diasDeRango(fechaIn, fechaFin);
		ArrayList<HoraMedica> horasMedicasRes = new ArrayList<>();
		for (String fechaActual : fechasRango) {
			String condicion = "idMedico="+medico.getId()+" and fecha='" + fechaActual+"'";
			modelo.orm.HoraMedica[] horasMedicas = modelo.orm.HoraMedicaDAO.listHoraMedicaByQuery(condicion, "fecha");
			for (modelo.orm.HoraMedica horaMedica : horasMedicas) {
				HoraMedica hora = HoraMedica.horaMedicaORMAHoraMedica(horaMedica);

				//Agrega la hora si es APS y si no está reservada (idReserva=-1)
				if (hora.horaEsAPS()&&!hora.horaReservada()) {
					horasMedicasRes.add(hora);
				}   
			}
		}
		return horasMedicasRes;
	}
	
	public static ArrayList<HoraMedica> obtenerHorasMedicasDeBox (Box box,String fechaIn,String fechaFin) throws PersistentException{
		ArrayList<String> fechasRango = Utilidades.diasDeRango(fechaIn, fechaFin);
		ArrayList<HoraMedica> horasMedicasRes = new ArrayList<>();
		for (String fechaActual : fechasRango) {
			String condicion = "idBox="+box.getId()+" and fecha='" + fechaActual+"'";
			modelo.orm.HoraMedica[] horasMedicas = modelo.orm.HoraMedicaDAO.listHoraMedicaByQuery(condicion, "fecha");
			for (modelo.orm.HoraMedica horaMedica : horasMedicas) {
				HoraMedica hora = HoraMedica.horaMedicaORMAHoraMedica(horaMedica);
				horasMedicasRes.add(hora);   
			}
		}
		return horasMedicasRes;
	}
	
	public static ArrayList<HoraMedica> obtenerHorasMedicasDeMedico (Medico medico,String fechaIn,String fechaFin) throws PersistentException{
		ArrayList<String> fechasRango = Utilidades.diasDeRango(fechaIn, fechaFin);
		ArrayList<HoraMedica> horasMedicasRes = new ArrayList<>();
		for (String fechaActual : fechasRango) {
			String condicion = "idMedico="+medico.getId()+" and fecha='" + fechaActual+"'";
			modelo.orm.HoraMedica[] horasMedicas = modelo.orm.HoraMedicaDAO.listHoraMedicaByQuery(condicion, "fecha");
			for (modelo.orm.HoraMedica horaMedica : horasMedicas) {
				HoraMedica hora = HoraMedica.horaMedicaORMAHoraMedica(horaMedica);
				horasMedicasRes.add(hora);   
			}
		}
		return horasMedicasRes;
	}
        
	public static HoraMedica horaMedicaORMAHoraMedica(modelo.orm.HoraMedica horaMedicaORM) throws PersistentException{
		modelo.orm.Reserva reserva = obtenerReserva(horaMedicaORM.getId());
		int idReserva = -1;
		Paciente paciente = null;
		Persona persona = null;
		Medico medico = Medico.medicoORMAMedico(horaMedicaORM.getMedico());
		Box box = Box.boxORMABox(horaMedicaORM.getBox());
		if (reserva!=null) {
			idReserva = reserva.getId();
			paciente = Paciente.pacienteORMAPaciente(reserva.getPaciente());
			persona = Persona.personaORMAPersona(reserva.getPersonaQueRegistra());
		}
		boolean aps =false;
		if (horaMedicaORM.getEsAPS()==1) {
			aps = true;
		}
		return new HoraMedica(horaMedicaORM.getId(), idReserva, aps, horaMedicaORM.getFecha(), horaMedicaORM.getHora(), paciente, medico, box, persona);
	}
        
	public static modelo.orm.Reserva obtenerReserva(int idHoraMedica) throws PersistentException{
		return modelo.orm.ReservaDAO.loadReservaByQuery("idHoraMedica="+idHoraMedica, null);
	}

        public int getId() {
            return id;
        }

        public int getIdReserva() {
            return idReserva;
        }

        public boolean isEsAPS() {
            return esAPS;
        }

        public String getFecha() {
            return fecha;
        }

        public String getHora() {
            return hora;
        }

        public Box getBox() {
            return box;
        }
        
        
}