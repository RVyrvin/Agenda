package org.iesalandalus.programacion.agenda;

import javax.naming.OperationNotSupportedException;

public class Agenda {
	
	private static final int MAX_CONTACTOS = 5;	
	private int numContactos;	
	private Contacto[] contactos;
	
	
	public Agenda () {
		contactos = new Contacto[MAX_CONTACTOS];
	}

	public int getNumContactos() {
		//contar cnumero e contactos;
		int index = 0;
		numContactos = 0;
		
		while (contactos[index]!=null) {
			numContactos++;
			index++;
		}
		
		return numContactos;
	}

	public Contacto[] getContactos() {
		return contactos;
	}
	
	
	
	public void anadir (Contacto contacto) throws OperationNotSupportedException {
		
			int index = buscarPrimerIndiceComprobandoExistencia(contacto);	
			
			if (IndiceNoSuperaTamano(index)) {
				contactos[index] = new Contacto(contacto.getNombre(), contacto.getTelefono(), contacto.getCorreo());
			} else {
				throw new OperationNotSupportedException("El array está lleno");
			}
		
	}
	
	
	private int buscarPrimerIndiceComprobandoExistencia(Contacto contacto) throws OperationNotSupportedException {
				
		int indice = 0;
		boolean isFinded = false;
		
		do {
			if (contactos[indice]!=null) {
				if (contactos[indice].equals(contacto)) {
					//el contacto ya existe
					throw new OperationNotSupportedException("Ya existe un contacto con ese nombre.");
				}
				indice++;
			} else {
				isFinded = true;
			}
			
		} while (!isFinded);
		
		return indice;
	}
	
	private boolean IndiceNoSuperaTamano(int indice) { return indice < MAX_CONTACTOS ? true : false;}
	
	
	
	public Contacto buscar(String nombre) {

		Contacto contacto = null;

		int index = buscarIndiceCliente(nombre);

		if (index != -1) {
			contacto = new Contacto(contactos[index].getNombre(), contactos[index].getTelefono(),
					contactos[index].getCorreo());
		}
		return contacto;
	}
	
	
	private int buscarIndiceCliente (String nombre) {
		int index = 0;
		boolean existContact = false;
		
		while (contactos[index]!=null) {
			if (contactos[index].getNombre().equalsIgnoreCase(nombre)) {
				existContact = true;
				break;
			}
			index++;
		}
		return existContact ? index : -1; //vuelve -1 si no se ha encontrado contacto
	}
	
	
	private void desplazarUnaPosicionHaciaIzquierda(int index) {

		while (IndiceNoSuperaTamano(index) && (contactos[index + 1] != null)) {
			contactos[index] = new Contacto(contactos[index + 1].getNombre(), contactos[index + 1].getTelefono(),
					contactos[index + 1].getCorreo());
			contactos[index + 1] = null;
			index++;

		}

	}


	public void borrar(String nombre) throws OperationNotSupportedException {

		int index = buscarIndiceCliente(nombre);
		if (index == -1) {
			throw new OperationNotSupportedException("El contacto a borrar no existe.");
		} else {
			contactos[index] = null;
			if ((index + 1) != MAX_CONTACTOS) {
				desplazarUnaPosicionHaciaIzquierda(index);
			}
		}

	}

}
