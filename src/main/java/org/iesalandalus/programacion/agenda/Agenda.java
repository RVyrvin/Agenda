package org.iesalandalus.programacion.agenda;

import javax.naming.OperationNotSupportedException;

public class Agenda {

	private static final int MAX_CONTACTOS = 3;
	
	private Contacto[] contactos;

	public Agenda() {
		contactos = new Contacto[MAX_CONTACTOS];
	}

	public int getNumContactos() {
		// contar cnumero de contactos;

		int numContactos = 0;
		
		for (Contacto contacto : contactos) {
			if (contacto != null)
				numContactos++;
		}

		return numContactos;
	}

	public Contacto[] getContactos() {
		Contacto[] cont = new Contacto[getNumContactos()];
		for (int index = 0; index < cont.length; index++) {
			if (contactos[index] != null)
				cont[index] = new Contacto(contactos[index].getNombre(), contactos[index].getTelefono(),
						contactos[index].getCorreo());
		}
		return cont;
	}

	public void anadir(Contacto contacto) throws OperationNotSupportedException {

		int index = buscarPrimerIndiceComprobandoExistencia(contacto);

		if (IndiceNoSuperaTamano(index)) {
			// conactos[index] = new Contacto(contacto.getNombre(), contacto.getTelefono(),
			// contacto.getCorreo());
			contactos[index] = contacto;
		} else {
			throw new OperationNotSupportedException("La agenda ya esta llena, no se puede añadir más comtactos.");
		}

	}

	private int buscarPrimerIndiceComprobandoExistencia(Contacto contacto) throws OperationNotSupportedException {

		int index = 0;

		while (IndiceNoSuperaTamano(index)) {
			if (contactos[index] == null)
				return index;
			else if (contactos[index].equals(contacto))
				throw new OperationNotSupportedException("Ya existe un contacto con ese nombre.");

			index++;
		}

		return index;
	}

	private boolean IndiceNoSuperaTamano(int indice) {
		return indice < MAX_CONTACTOS ? true : false;
	}

	public Contacto buscar(String nombre) {

		Contacto contacto = null;

		int index = buscarIndiceCliente(nombre);

		if (IndiceNoSuperaTamano(index)) {
			contacto = new Contacto(contactos[index].getNombre(), contactos[index].getTelefono(),
					contactos[index].getCorreo());
		}
		return contacto;
	}

	private int buscarIndiceCliente(String nombre) {
		int index = 0;
		boolean existContact = false;

		while (contactos[index] != null) {
			if (contactos[index].getNombre().equalsIgnoreCase(nombre)) {
				existContact = true;
				break;
			}
			index++;
		}
		return existContact ? index : Agenda.MAX_CONTACTOS;
	}

	private void desplazarUnaPosicionHaciaIzquierda(int index) {

		for (int i = index; i < Agenda.MAX_CONTACTOS; i++) {
			if (IndiceNoSuperaTamano(i + 1)) {
				contactos[i] = contactos[i + 1];
				contactos[i + 1] = null;
			} else {
				contactos[i] = null;
			}
		}

	}

	public void borrar(String nombre) throws OperationNotSupportedException {

		int index = buscarIndiceCliente(nombre);
		if (!IndiceNoSuperaTamano(index)) {
			throw new OperationNotSupportedException("El contacto a borrar no existe.");
		} else {
			contactos[index] = null;
			if ((index + 1) != MAX_CONTACTOS) {
				desplazarUnaPosicionHaciaIzquierda(index);
			}
		}

	}

	public int getMaxContactos() {
		return Agenda.MAX_CONTACTOS;
	}

}
