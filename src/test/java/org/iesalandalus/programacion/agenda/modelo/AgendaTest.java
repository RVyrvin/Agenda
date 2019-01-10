package org.iesalandalus.programacion.agenda.modelo;

import static org.junit.Assert.*;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.agenda.Agenda;
import org.iesalandalus.programacion.agenda.Contacto;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AgendaTest {
	
	private static final String MENSAJE_EXCEPCION = "Debería haber saltado la excepción.";
	private static final String MENSAJE_NO_EXCEPCION = "No debería haber saltado la excepción.";


	public static Contacto contacto1, contacto2, contacto3;
	public Agenda agenda;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		contacto1 = new Contacto("Contacto1", "950111111", "a1@b.com");
		contacto2 = new Contacto("Contacto2", "950222222", "a2@b.com");
		contacto3 = new Contacto("Contacto3", "950333333", "a3@b.com");
	}
	
	@Before
	public void setUp() {
		agenda = new Agenda();
	}

	@Test
	public void anadirUnContactoTest() {
		try {
			agenda.anadir(contacto1);
		} catch (OperationNotSupportedException e) {
			fail(MENSAJE_NO_EXCEPCION);
		}
		assertEquals(1, agenda.getNumContactos());
	}
	
	@Test
	public void anadirContactoRepetidoTest() {
		try {
			agenda.anadir(contacto1);
			agenda.anadir(contacto1);
			fail(MENSAJE_EXCEPCION);
		} catch (OperationNotSupportedException e) {
			assertEquals("Ya existe un contacto con ese nombre.", e.getMessage());
		}
		assertEquals(1, agenda.getNumContactos());
	}
	
	@Test
	public void anadirDosContactosTest() {
		try {
			agenda.anadir(contacto1);
			agenda.anadir(contacto2);
		} catch (OperationNotSupportedException e) {
			fail(MENSAJE_NO_EXCEPCION);
		}
		assertEquals(2, agenda.getNumContactos());
	}

	@Test
	public void buscarContactoExistenteTest() {
		try {
			agenda.anadir(contacto1);
		} catch (OperationNotSupportedException e) {
			fail(MENSAJE_NO_EXCEPCION);
		}
		Contacto contacto = agenda.buscar(contacto1.getNombre());
		assertEquals("Contacto1", contacto.getNombre());
	}
	
	@Test
	public void buscarContactoNoExistenteTest() {
		try {
			agenda.anadir(contacto1);
		} catch (OperationNotSupportedException e) {
			fail(MENSAJE_NO_EXCEPCION);
		}
		Contacto contacto = agenda.buscar(contacto2.getNombre());
		assertNull(contacto);
	}
	/*
	@Test
	public void borrarContactoExistenteTest() {
		try {
			agenda.anadir(contacto1);
			agenda.borrar(contacto1.getNombre());
		} catch (OperationNotSupportedException e) {
			fail(MENSAJE_NO_EXCEPCION);
		}
		assertEquals(0, agenda.getNumContactos());
	}
	
	@Test
	public void borrarContactoNoExistenteTest() {
		try {
			agenda.anadir(contacto1);
			agenda.borrar(contacto2.getNombre());
		} catch (OperationNotSupportedException e) {
			assertEquals("El contacto a borrar no existe.", e.getMessage());
		}
		assertEquals(1, agenda.getNumContactos());
	}
	
	@Test
	public void borrarContactoAlPrincipioTest() {
		try {
			agenda.anadir(contacto1);
			agenda.anadir(contacto2);
			agenda.anadir(contacto3);
			agenda.borrar(contacto1.getNombre());
		} catch (OperationNotSupportedException e) {
			fail(MENSAJE_NO_EXCEPCION);
		}
		assertNull(agenda.buscar(contacto1.getNombre()));
		assertEquals(2, agenda.getNumContactos());
	}
	
	@Test
	public void borrarContactoEnMedioTest() {
		try {
			agenda.anadir(contacto1);
			agenda.anadir(contacto2);
			agenda.anadir(contacto3);
			agenda.borrar(contacto2.getNombre());
		} catch (OperationNotSupportedException e) {
			fail(MENSAJE_NO_EXCEPCION);
		}
		assertNull(agenda.buscar(contacto2.getNombre()));
		assertEquals(2, agenda.getNumContactos());
	}
	
	@Test
	public void borrarContactoAlFinalTest() {
		try {
			agenda.anadir(contacto1);
			agenda.anadir(contacto2);
			agenda.anadir(contacto3);
			agenda.borrar(contacto3.getNombre());
		} catch (OperationNotSupportedException e) {
			fail(MENSAJE_NO_EXCEPCION);
		}
		assertNull(agenda.buscar(contacto3.getNombre()));
		assertEquals(2, agenda.getNumContactos());
	}
*/
}
