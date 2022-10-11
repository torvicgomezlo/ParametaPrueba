package com.parameta.Negocio.Entity;

import java.io.Serializable;

public class mesajeRespuesta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String mensaje;
	private String codigo;
	private Object respuesta;
	
	public mesajeRespuesta() {
		
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Object getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(Object respuesta) {
		this.respuesta = respuesta;
	}
	
	

}
