package org.iesalandalus.programacion.agenda;

public class Contacto {
	
	private static final String ER_TELEFONO = "[69][0-9]{8}";
	private static final String ER_CORREO = "\\w[.\\w]*@[a-zA-Z]+\\.[a-zA-Z]{2,5}";
	
	private String nombre;
	private String telefono;
	private String correo;
	
	
	public Contacto (String nombre, String telefono, String correo) {	
		
		setNombre(nombre);
		setTelefono(telefono);
		setCorreo(correo);
		
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	
	private void setNombre(String nombre) {
		
		if (nombre == null || nombre.equals("")) {
			throw new IllegalArgumentException("El nombre de un contacto no puede ser nulo o vacío.");
		} else {
			this.nombre = nombre;
		}
	}
	
	
	public String getTelefono() {
		return telefono;
	}
	
	
	public void setTelefono(String telefono) {
		
		if (telefono == null || telefono.equals("")) {
			throw new IllegalArgumentException("El teléfono de un contacto no puede ser nulo o vacío.");			
		} else {
			if (!telefono.matches(ER_TELEFONO)) {
				throw new IllegalArgumentException("El teléfono no tiene un formato válido.");
			} else {
				this.telefono = telefono;
			}
		}
	}
	
	
	public String getCorreo() {
		return correo;
	}
	
	
	public void setCorreo(String correo) {

		
		if (correo == null || correo.equals("")) {
			throw new IllegalArgumentException("El correo de un contacto no puede ser nulo o vacío.");
		} else {
			if (!correo.matches(ER_CORREO)) {
				throw new IllegalArgumentException("El correo no tiene un formato válido.");
				} else {
					this.correo = correo;
				}
		}
	}


	
	
	/**
	 * 1. Creamos instancia de la clase StrinBuilder y le asignamos el nombre que al cual 
	 * eleminamos espacios delante y detras por se a caso y convertimos todas las letras a las mayusculas
	 * 2. comprobamos el caracter, 
	 *    si es espacio en blanco, lo eleminamos y decimos que letra de la siguiente palabra va ser primera
	 *    en otro caso comprobamos 
	 *       si es la primera letra, decimos que ya la hemos pasado y guardamos la aumentando el indiceToDelete
	 *       si no es primera palabra, borramos este caracter.
	 *   
	 * @return iniciale del nombre
	 */
	
	private String getIniciales() {
		
		StringBuilder strbd = new StringBuilder(nombre.trim().toUpperCase());
		int numIndexes = strbd.length();
		boolean primeraLetra = true;
		int indexToDelete = 0;
		
		for (int i = 0; i < numIndexes; i++) {
			
			if (strbd.charAt(indexToDelete) == ' ' ) {
				primeraLetra=true;
				strbd.deleteCharAt(indexToDelete);
			} else {
				if (primeraLetra) {
					primeraLetra = false;
					indexToDelete++;
				} else {
					strbd.deleteCharAt(indexToDelete);
				}
			}
			
		}
		
		return strbd.toString();
	}
	
	@Override
	public String toString() {
		return getIniciales() + " [" + telefono + ", " + correo + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contacto other = (Contacto) obj;
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equalsIgnoreCase(other.nombre))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}	
	
	
}
