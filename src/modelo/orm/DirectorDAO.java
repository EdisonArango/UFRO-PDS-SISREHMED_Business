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

public class DirectorDAO {
	public static Director loadDirectorByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = modelo.orm.ORMSISREHMEDPersistentManager.instance().getSession();
			return loadDirectorByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Director getDirectorByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = modelo.orm.ORMSISREHMEDPersistentManager.instance().getSession();
			return getDirectorByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Director loadDirectorByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modelo.orm.ORMSISREHMEDPersistentManager.instance().getSession();
			return loadDirectorByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Director getDirectorByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modelo.orm.ORMSISREHMEDPersistentManager.instance().getSession();
			return getDirectorByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Director loadDirectorByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Director) session.load(modelo.orm.Director.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Director getDirectorByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Director) session.get(modelo.orm.Director.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Director loadDirectorByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Director) session.load(modelo.orm.Director.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Director getDirectorByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Director) session.get(modelo.orm.Director.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDirector(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modelo.orm.ORMSISREHMEDPersistentManager.instance().getSession();
			return queryDirector(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDirector(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modelo.orm.ORMSISREHMEDPersistentManager.instance().getSession();
			return queryDirector(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Director[] listDirectorByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modelo.orm.ORMSISREHMEDPersistentManager.instance().getSession();
			return listDirectorByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Director[] listDirectorByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modelo.orm.ORMSISREHMEDPersistentManager.instance().getSession();
			return listDirectorByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDirector(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modelo.orm.Director as Director");
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
	
	public static List queryDirector(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modelo.orm.Director as Director");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Director", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Director[] listDirectorByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryDirector(session, condition, orderBy);
			return (Director[]) list.toArray(new Director[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Director[] listDirectorByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryDirector(session, condition, orderBy, lockMode);
			return (Director[]) list.toArray(new Director[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Director loadDirectorByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modelo.orm.ORMSISREHMEDPersistentManager.instance().getSession();
			return loadDirectorByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Director loadDirectorByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modelo.orm.ORMSISREHMEDPersistentManager.instance().getSession();
			return loadDirectorByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Director loadDirectorByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Director[] directors = listDirectorByQuery(session, condition, orderBy);
		if (directors != null && directors.length > 0)
			return directors[0];
		else
			return null;
	}
	
	public static Director loadDirectorByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Director[] directors = listDirectorByQuery(session, condition, orderBy, lockMode);
		if (directors != null && directors.length > 0)
			return directors[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateDirectorByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = modelo.orm.ORMSISREHMEDPersistentManager.instance().getSession();
			return iterateDirectorByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDirectorByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = modelo.orm.ORMSISREHMEDPersistentManager.instance().getSession();
			return iterateDirectorByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDirectorByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modelo.orm.Director as Director");
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
	
	public static java.util.Iterator iterateDirectorByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From modelo.orm.Director as Director");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Director", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Director createDirector() {
		return new modelo.orm.Director();
	}
	
	public static boolean save(modelo.orm.Director director) throws PersistentException {
		try {
			modelo.orm.ORMSISREHMEDPersistentManager.instance().saveObject(director);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(modelo.orm.Director director) throws PersistentException {
		try {
			modelo.orm.ORMSISREHMEDPersistentManager.instance().deleteObject(director);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(modelo.orm.Director director) throws PersistentException {
		try {
			modelo.orm.ORMSISREHMEDPersistentManager.instance().getSession().refresh(director);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(modelo.orm.Director director) throws PersistentException {
		try {
			modelo.orm.ORMSISREHMEDPersistentManager.instance().getSession().evict(director);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Director loadDirectorByCriteria(DirectorCriteria directorCriteria) {
		Director[] directors = listDirectorByCriteria(directorCriteria);
		if(directors == null || directors.length == 0) {
			return null;
		}
		return directors[0];
	}
	
	public static Director[] listDirectorByCriteria(DirectorCriteria directorCriteria) {
		return directorCriteria.listDirector();
	}
}
