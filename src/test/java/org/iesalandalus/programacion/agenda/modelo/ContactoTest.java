package org.iesalandalus.programacion.agenda.modelo;

import static org.junit.Assert.*;

import org.iesalandalus.programacion.agenda.Contacto;
import org.junit.Test;

public class ContactoTest {
	
	private static final String MENSAJE_EXCEPCION = "Debería haber saltado la excepción.";

	@Test
	public void constructorValidoTest() {
		Contacto contacto = new Contacto("José Ramón", "950112233", "joseramon.jimenez@iesalandalus.org");
		assertEquals("José Ramón", contacto.getNombre());
		assertEquals("950112233", contacto.getTelefono());
		assertEquals("joseramon.jimenez@iesalandalus.org", contacto.getCorreo());
		contacto = new Contacto("Andrés", "650112233", "andres66@servidor.com");
		assertEquals("Andrés", contacto.getNombre());
		assertEquals("650112233", contacto.getTelefono());
		assertEquals("andres66@servidor.com", contacto.getCorreo());
	}
	
	@Test
	public void constructorNombreNoValidoTest() {
		Contacto contacto = null;
		try {
			contacto = new Contacto(null, "950112233", "joseramon.jimenez@iesalandalus.org");
			fail(MENSAJE_EXCEPCION);
		} catch (IllegalArgumentException e) {
			assertEquals("El nombre de un contacto no puede ser nulo o vacío.", e.getMessage());
			assertNull(contacto);
		}
		try {
			contacto = new Contacto("", "950112233", "joseramon.jimenez@iesalandalus.org");
			fail(MENSAJE_EXCEPCION);
		} catch (IllegalArgumentException e) {
			assertEquals("El nombre de un contacto no puede ser nulo o vacío.", e.getMessage());
			assertNull(contacto);
		}
	}
	
	
	
	@Test
	public void constructorTelefonoNoValidoTest() {
		Contacto contacto = null;
		try {
			contacto = new Contacto("José Ramón", null, "joseramon.jimenez@iesalandalus.org");
			fail(MENSAJE_EXCEPCION);
		} catch (IllegalArgumentException e) {
			assertEquals("El teléfono de un contacto no puede ser nulo o vacío.", e.getMessage());
			assertNull(contacto);
		}
		try {
			contacto = new Contacto("José Ramón", "", "joseramon.jimenez@iesalandalus.org");
			fail(MENSAJE_EXCEPCION);
		} catch (IllegalArgumentException e) {
			assertEquals("El teléfono de un contacto no puede ser nulo o vacío.", e.getMessage());
			assertNull(contacto);
		}
		try {
			contacto = new Contacto("José Ramón", "555112233", "joseramon.jimenez@iesalandalus.org");
			fail(MENSAJE_EXCEPCION);
		} catch (IllegalArgumentException e) {
			assertEquals("El teléfono no tiene un formato válido.", e.getMessage());
			assertNull(contacto);
		}
		try {
			contacto = new Contacto("José Ramón", "95011223", "joseramon.jimenez@iesalandalus.org");
			fail(MENSAJE_EXCEPCION);
		} catch (IllegalArgumentException e) {
			assertEquals("El teléfono no tiene un formato válido.", e.getMessage());
			assertNull(contacto);
		}
		try {
			contacto = new Contacto("José Ramón", "9501122334", "joseramon.jimenez@iesalandalus.org");
			fail(MENSAJE_EXCEPCION);
		} catch (IllegalArgumentException e) {
			assertEquals("El teléfono no tiene un formato válido.", e.getMessage());
			assertNull(contacto);
		}
	}
	
	@Test
	public void constructorCorreoNoValidoTest() {
		Contacto contacto = null;
		try {
			contacto = new Contacto("José Ramón", "950112233", null);
			fail(MENSAJE_EXCEPCION);
		} catch (IllegalArgumentException e) {
			assertEquals("El correo de un contacto no puede ser nulo o vacío.", e.getMessage());
			assertNull(contacto);
		}
		try {
			contacto = new Contacto("José Ramón", "950112233", "");
			fail(MENSAJE_EXCEPCION);
		} catch (IllegalArgumentException e) {
			assertEquals("El correo de un contacto no puede ser nulo o vacío.", e.getMessage());
			assertNull(contacto);
		}
		try {
			contacto = new Contacto("José Ramón", "950112233", "joseramon.jimenez");
			fail(MENSAJE_EXCEPCION);
		} catch (IllegalArgumentException e) {
			assertEquals("El correo no tiene un formato válido.", e.getMessage());
			assertNull(contacto);
		}
		try {
			contacto = new Contacto("José Ramón", "950112233", "joseramon.jimenez@iesalandalus");
			fail(MENSAJE_EXCEPCION);
		} catch (IllegalArgumentException e) {
			assertEquals("El correo no tiene un formato válido.", e.getMessage());
			assertNull(contacto);
		}
		try {
			contacto = new Contacto("José Ramón", "950112233", "joseramon.jimenez@ies-alandalus.org");
			fail(MENSAJE_EXCEPCION);
		} catch (IllegalArgumentException e) {
			assertEquals("El correo no tiene un formato válido.", e.getMessage());
			assertNull(contacto);
		}
		try {
			contacto = new Contacto("José Ramón", "950112233", "joseramon.jimenez@iesalandalus1.org");
			fail(MENSAJE_EXCEPCION);
		} catch (IllegalArgumentException e) {
			assertEquals("El correo no tiene un formato válido.", e.getMessage());
			assertNull(contacto);
		}
	}
	
	//No pruebo los métodos get y set ya que están cubiertos en las pruebas anteriores
	
	@Test
	public void toStringTest() {
		Contacto contacto = new Contacto("José Ramón", "950112233", "joseramon.jimenez@iesalandalus.org");
		assertEquals("JR [950112233, joseramon.jimenez@iesalandalus.org]", contacto.toString());
		contacto = new Contacto("josé      ramón  jiménez", "950112233", "joseramon.jimenez@iesalandalus.org");
		assertEquals("JRJ [950112233, joseramon.jimenez@iesalandalus.org]", contacto.toString());
	}
	
	@Test
	public void igualdadTest() {
		Contacto contacto1 = new Contacto("José Ramón", "950112233", "joseramon.jimenez@iesalandalus.org");
		Contacto contacto2 = new Contacto("José Ramón", "999123123", "joseramon.jimenez@iesalandalus.org");
		Contacto contacto3 = new Contacto("josé ramón", "999123123", "joseramon.jimenez@iesalandalus.org");
		Contacto contacto4 = new Contacto("Jose Ramon", "999123123", "joseramon.jimenez@iesalandalus.org");
		assertNotEquals(contacto1, null);
		assertNotEquals(contacto1, "Prueba");
		assertNotEquals(contacto1, contacto4);
		assertNotEquals(contacto1, contacto2);
		assertNotEquals(contacto1, contacto3);
	}

}
