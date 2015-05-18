/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package modelo.orm;

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class HoraMedicaDAO {
	public static HoraMedica loadHoraMedicaByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = modelo.orm.ORMSISREHMEDPersistentManager.instance().getSession();
			return loadHoraMedicaByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static HoraMedica getHoraMedicaByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = modelo.orm.ORMSISREHMEDPersistentManager.instance().getSession();
			return getHoraMedicaByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static HoraMedica loadHoraMedicaByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modelo.orm.ORMSISREHMEDPersistentManager.instance().getSession();
			return loadHoraMedicaByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static HoraMedica getHoraMedicaByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modelo.orm.ORMSISREHMEDPersistentManager.instance().getSession();
			return getHoraMedicaByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static HoraMedica loadHoraMedicaByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (HoraMedica) session.load(modelo.orm.HoraMedica.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static HoraMedica getHoraMedicaByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (HoraMedica) session.get(modelo.orm.HoraMedica.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static HoraMedica loadHoraMedicaByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (HoraMedica) session.load(modelo.orm.HoraMedica.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static HoraMedica getHoraMedicaByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (HoraMedica) session.get(modelo.orm.HoraMedica.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryHoraMedica(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modelo.orm.ORMSISREHMEDPersistentManager.instance().getSession();
			return queryHoraMedica(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryHoraMedica(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modelo.orm.ORMSISREHMEDPersistentManager.instance().getSession();
			return queryHoraMedica(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static HoraMedica[] listHoraMedicaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modelo.orm.ORMSISREHMEDPersistentManager.instance().getSession();
			return listHoraMedicaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static HoraMedica[] listHoraMedicaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modelo.orm.ORMSISREHMEDPersistentManager.instance().getSession();
			return listHoraMedicaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryHoraMedica(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modelo.orm.HoraMedica as HoraMedica");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryHoraMedica(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modelo.orm.HoraMedica as HoraMedica");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("HoraMedica", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static HoraMedica[] listHoraMedicaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryHoraMedica(session, condition, orderBy);
			return (HoraMedica[]) list.toArray(new HoraMedica[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static HoraMedica[] listHoraMedicaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryHoraMedica(session, condition, orderBy, lockMode);
			return (HoraMedica[]) list.toArray(new HoraMedica[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static HoraMedica loadHoraMedicaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modelo.orm.ORMSISREHMEDPersistentManager.instance().getSession();
			return loadHoraMedicaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static HoraMedica loadHoraMedicaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modelo.orm.ORMSISREHMEDPersistentManager.instance().getSession();
			return loadHoraMedicaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static HoraMedica loadHoraMedicaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		HoraMedica[] horaMedicas = listHoraMedicaByQuery(session, condition, orderBy);
		if (horaMedicas != null && horaMedicas.length > 0)
			return horaMedicas[0];
		else
			return null;
	}
	
	public static HoraMedica loadHoraMedicaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		HoraMedica[] horaMedicas = listHoraMedicaByQuery(session, condition, orderBy, lockMode);
		if (horaMedicas != null && horaMedicas.length > 0)
			return horaMedicas[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateHoraMedicaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modelo.orm.ORMSISREHMEDPersistentManager.instance().getSession();
			return iterateHoraMedicaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateHoraMedicaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modelo.orm.ORMSISREHMEDPersistentManager.instance().getSession();
			return iterateHoraMedicaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateHoraMedicaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modelo.orm.HoraMedica as HoraMedica");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateHoraMedicaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modelo.orm.HoraMedica as HoraMedica");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("HoraMedica", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static HoraMedica createHoraMedica() {
		return new modelo.orm.HoraMedica();
	}
	
	public static boolean save(modelo.orm.HoraMedica horaMedica) throws PersistentException {
		try {
			modelo.orm.ORMSISREHMEDPersistentManager.instance().saveObject(horaMedica);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(modelo.orm.HoraMedica horaMedica) throws PersistentException {
		try {
			modelo.orm.ORMSISREHMEDPersistentManager.instance().deleteObject(horaMedica);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(modelo.orm.HoraMedica horaMedica) throws PersistentException {
		try {
			modelo.orm.ORMSISREHMEDPersistentManager.instance().getSession().refresh(horaMedica);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(modelo.orm.HoraMedica horaMedica) throws PersistentException {
		try {
			modelo.orm.ORMSISREHMEDPersistentManager.instance().getSession().evict(horaMedica);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static HoraMedica loadHoraMedicaByCriteria(HoraMedicaCriteria horaMedicaCriteria) {
		HoraMedica[] horaMedicas = listHoraMedicaByCriteria(horaMedicaCriteria);
		if(horaMedicas == null || horaMedicas.length == 0) {
			return null;
		}
		return horaMedicas[0];
	}
	
	public static HoraMedica[] listHoraMedicaByCriteria(HoraMedicaCriteria horaMedicaCriteria) {
		return horaMedicaCriteria.listHoraMedica();
	}
}
