package modelo.hospital;

import modelo.personas.Medico;
import org.orm.PersistentException;

public class Especialidad {
	private int id;
	private String nombre;

    public Especialidad(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
        
        public static Especialidad[] obtenerTodasLasEspecialidades() throws PersistentException{
            modelo.orm.Especialidad[] especialidadesORM = modelo.orm.EspecialidadDAO.listEspecialidadByQuery(null, null);
            Especialidad[] especialidad = new Especialidad[especialidadesORM.length];
            for (int i = 0; i < especialidadesORM.length; i++) {
                especialidad[i] = Especialidad.especialidadORMAEspecialidad(especialidadesORM[i]);
            }
            return especialidad;
        }
        
        public static Especialidad cargarEspecialidadPorId(int id) throws PersistentException{
            modelo.orm.Especialidad especialidadORM = modelo.orm.EspecialidadDAO.loadEspecialidadByQuery("id="+id, null);
            return especialidadORMAEspecialidad(especialidadORM);
        }
        
        public static Especialidad especialidadORMAEspecialidad (modelo.orm.Especialidad especialidadORM){
            return new Especialidad(especialidadORM.getId(),especialidadORM.getNombre());
        }
        
        public Medico[] obtenerMedicosEspecialidad() throws PersistentException{
            modelo.orm.Medico[] medicosORM = modelo.orm.MedicoDAO.listMedicoByQuery("idEspecialidad="+id,null);
            Medico[] medicos = new Medico[medicosORM.length];
            for (int i = 0; i < medicosORM.length; i++) {
                medicos[i] = Medico.medicoORMAMedico(medicosORM[i]);
            }
            return medicos;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        
}