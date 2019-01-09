package org.iesalandalus.programacion.agenda;

public class Agenda {
	
	private static final int MAX_CONTACTOS = 5;	
	private int numContactos;	
	private Contacto[] contactos;
	
	
	public Agenda () {
		contactos = new Contacto[MAX_CONTACTOS];
	}

	public int getNumContactos() {
		return numContactos;
	}

	public Contacto[] getContactos() {
		return contactos;
	}
	
	

}
