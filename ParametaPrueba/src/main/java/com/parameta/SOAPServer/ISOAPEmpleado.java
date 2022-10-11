package com.parameta.SOAPServer;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL)
public interface ISOAPEmpleado {

	@WebMethod
	public void addEmpleado(Empleado empleado);
	
	@WebMethod
	public List<Empleado> getEmpleados();
}
