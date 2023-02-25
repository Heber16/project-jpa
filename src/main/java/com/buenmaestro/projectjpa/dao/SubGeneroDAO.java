/**
 * 
 */
package com.buenmaestro.projectjpa.dao;

import java.util.List;

import com.buenmaestro.projectjpa.entity.SubGenero;

/**
 * @author heber Interface DAO que realiza el CRUD con JPA para la tabla
 *         SubGenero
 */
public interface SubGeneroDAO {

	/**
	 * @author heber Metodo que permite guardar un subgenero
	 * @param subGenero {@link long} indentificador del subgenero a guardar
	 */
	void guardar(SubGenero subGenero);

	/**
	 * @author heber Metodo que permite actualizar un subgenero
	 * @param subGenero {@link subGenero} objeto a actualizar
	 */
	void actualizar(SubGenero subGenero);

	/**
	 * @author heber Metodo que permite guardar un subgenero por su identificador
	 * @param id {@link long} indentificador del subgenero a eliminar
	 */
	void eliminar(long id);

	/**
	 * @author heber Metodo que permite consultar la lista de subgeneros
	 * @return {@link list} lista de subgeneros consultados
	 */
	List<SubGenero> consultar();

	/**
	 * @author heber Metodo que permite consultar un subgenero a partir de su
	 *         identificador
	 * @param id {@link long} indentificador del subgenero a consultar
	 * @return {@link subgenero} un objeto subgenero consultado
	 */
	SubGenero consultarById(Long id);

}
