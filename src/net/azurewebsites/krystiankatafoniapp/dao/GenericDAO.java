package net.azurewebsites.krystiankatafoniapp.dao;

import java.io.Serializable;
import java.util.List;
/**
 * Interface for CRUD methods
 * @author Krystian Katafoni
 * @version 1.0
 * @since 2017-06-4
 */
public interface GenericDAO<T, PK extends Serializable> {
	//CRUD
	
	/**
	 * create new object in database
	 * @param newObject - object which will be create in db
	 * @return created object
	 * @throws NullPointerException
	 */
	T create(T newObject) throws NullPointerException;
	
	/**
	 * read object from database
	 * @param primaryKey - id of object in db
	 * @return read object
	 * @throws NullPointerException
	 */
	T read(PK primaryKey) throws NullPointerException;
	
	/**
	 * update object in database
	 * @param updateObject - object which will be updated
	 * @return result of operation
	 * @throws NullPointerException
	 */
	boolean update(T updateObject) throws NullPointerException;
	
	/**
	 * delete object in db
	 * @param key - id of object in db
	 * @return result of operation
	 * @throws NullPointerException
	 */
	boolean delete(PK key) throws NullPointerException;
	
	/**
	 * get list of all object of exact type from db
	 * @param key - id of user from database
	 * @return list of all objects
	 * @throws NullPointerException
	 */
	List<T> getAll(PK key) throws NullPointerException;
}
