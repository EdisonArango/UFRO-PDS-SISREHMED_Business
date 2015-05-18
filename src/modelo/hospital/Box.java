package modelo.hospital;

import java.util.ArrayList;

import org.orm.PersistentException;

public class Box {
	private int id;
	private String nombre;

    public Box(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public ArrayList<HoraMedica> obtenerHorasMedicas(String fechaIn,String fechaFin) throws PersistentException{
    	return HoraMedica.obtenerHorasMedicasDeBox(this, fechaIn, fechaFin);
    }
    
    public static Box[] obtenerTodosLosBoxes() throws PersistentException{
        modelo.orm.Box[] boxesORM = modelo.orm.BoxDAO.listBoxByQuery(null, null);
        Box[] boxes = new Box[boxesORM.length];
        for (int i = 0; i < boxesORM.length; i++) {
            boxes[i] = Box.boxORMABox(boxesORM[i]);
        }
        return boxes;
    }
    
    public static Box cargarBoxPorId(int id) throws PersistentException{
        modelo.orm.Box boxORM = modelo.orm.BoxDAO.loadBoxByQuery("id="+id, null);
        return boxORMABox(boxORM);
    }
    
        
    public static Box boxORMABox(modelo.orm.Box boxORM){
        return new Box(boxORM.getId(),boxORM.getNombre());
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