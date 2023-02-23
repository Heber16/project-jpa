/**
 * 
 */
package com.buenmaestro.projectjpa.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.buenmaestro.projectjpa.dao.DisqueraDAO;
import com.buenmaestro.projectjpa.dao.impl.DisqueraDAOImpl;
import com.buenmaestro.projectjpa.entity.Disquera;

/**
 * @author heber
 *
 */
class DisqueraDAOImplTest {

	private DisqueraDAO disqueraDAO = new DisqueraDAOImpl();

	/**
	 * Test method for
	 * {@link com.buenmaestro.projectjpa.dao.impl.DisqueraDAOImpl#guardar(com.buenmaestro.projectjpa.entity.Disquera)}.
	 */
	@Test
	void testGuardar() {

		Disquera disquera = new Disquera();
		disquera.setDescripcion("Universal Music");
		disquera.setFechaCreacion(LocalDateTime.now());
		disquera.setEstatus(true);

		this.disqueraDAO.guardar(disquera);
	}

	/**
	 * Test method for
	 * {@link com.buenmaestro.projectjpa.dao.impl.DisqueraDAOImpl#actualizar(com.buenmaestro.projectjpa.entity.Disquera)}.
	 */
	@Test
	void testActualizar() {
		Disquera disqueraConsultada = this.disqueraDAO.consultarById(9L);

		disqueraConsultada.setDescripcion("Disquera StarMusic");

		this.disqueraDAO.actualizar(disqueraConsultada);
	}

	/**
	 * Test method for
	 * {@link com.buenmaestro.projectjpa.dao.impl.DisqueraDAOImpl#eliminar(com.buenmaestro.projectjpa.entity.Disquera)}.
	 */
	@Test
	void testEliminar() {
		Long id = 10L;
		this.disqueraDAO.eliminar(id);
	}

	/**
	 * Test method for
	 * {@link com.buenmaestro.projectjpa.dao.impl.DisqueraDAOImpl#consultar()}.
	 */
	@Test
	void testConsultar() {
		List<Disquera> disquerasConsultadas = this.disqueraDAO.consultar();
		assertTrue(disquerasConsultadas.size()>0);
		
		disquerasConsultadas.forEach(disquera ->{
			System.out.println("Disquera: " + disquera.getDescripcion());
		});
	}

	/**
	 * Test method for
	 * {@link com.buenmaestro.projectjpa.dao.impl.DisqueraDAOImpl#consultarById(java.lang.Long)}.
	 */
	@Test
	void testConsultarById() {
		Disquera disquera = this.disqueraDAO.consultarById(9L);

		System.out.println("Disquera: " + disquera.getDescripcion());
	}

}
