package com.parameta.SOAPServer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class Empleado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombres;
	private String apellidos;
	private Date fechaNacimiento;
	private double salario;
	private String tipoDocumento;
	private String numeroDocumento;
	private Date fechaVinculacion;
	private String cargo;
	
	public static List<Empleado> empleados = new ArrayList<Empleado>(Arrays.asList(
				new Empleado("Pepito","Perez",new Date(), 355555.58, "CC", "7764569655", new Date(), "DESARROLLADOR" )
			));
	
	public Empleado() {
		super();		
	}

	public Empleado(String nombres, String apellidos, Date fechaNacimiento, double salario, 
			String tipoDocumento, String numeroDocumento, Date fechaVinculacion, String cargo) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.salario = salario;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.fechaVinculacion = fechaVinculacion;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public static List<Empleado> getEmpleados() {
		return empleados;
	}

	public static void setEmpleados(List<Empleado> empleados) {
		Empleado.empleados = empleados;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public Date getFechaVinculacion() {
		return fechaVinculacion;
	}

	public void setFechaVinculacion(Date fechaVinculacion) {
		this.fechaVinculacion = fechaVinculacion;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
}

