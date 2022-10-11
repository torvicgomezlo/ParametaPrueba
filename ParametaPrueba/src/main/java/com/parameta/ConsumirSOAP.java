package com.parameta;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.parameta.SOAPClient.Empleado;
import com.parameta.SOAPClient.ISOAPEmpleado;
import com.parameta.SOAPClient.SOAPEmpleadoImplService;

public class ConsumirSOAP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SOAPEmpleadoImplService empleado = new SOAPEmpleadoImplService();
		ISOAPEmpleado consumer = empleado.getSOAPEmpleadoImplPort();
		Empleado emp = new Empleado();
		emp.setNombres("Victor");
		emp.setApellidos("Gomez");
		Date currentDate = new Date();
		XMLGregorianCalendar xmlDate = null;
		GregorianCalendar gc = new GregorianCalendar(); 
		gc.setTime(currentDate);
		try {
			xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
		}catch (Exception e) {
            e.printStackTrace();
        }
		emp.setFechaNacimiento(xmlDate);
		emp.setSalario(7500236.55);
		emp.setTipoDocumento("CC");
		emp.setNumeroDocumento("74522123");
		emp.setFechaVinculacion(xmlDate);
		emp.setCargo("DESARROLLADRO JAVA");
		consumer.addEmpleado(emp);		
		for(Empleado item : consumer.getEmpleados())
			System.out.println("Empleado::>>"+item.getNombres()+" "+item.getApellidos()+" "+item.getFechaNacimiento().toString()+" "+item.getSalario());
	}

}
