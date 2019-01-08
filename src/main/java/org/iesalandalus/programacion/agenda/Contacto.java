package org.iesalandalus.programacion.agenda;

public class Contacto {
	
	private static final String ER_TELEFONO = "[69][0-9]{8}";
	private static final String ER_CORREO = "\\w+[\\.\\w]*@\\w+[\\.\\w]*\\.\\w{2,5}\\b\\s?";
	
	private String nombre;
	private String telefono;
	private String correo;
	
	
	
	
	
	public String getNombre() {
		return nombre;
	}
	
	
	public void setNombre(String nombre) {
		
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

}
