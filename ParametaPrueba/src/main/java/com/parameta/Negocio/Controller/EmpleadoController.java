package com.parameta.Negocio.Controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

import javax.validation.Valid;
import javax.xml.datatype.DatatypeFactory;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parameta.Negocio.Entity.Empleado;
import com.parameta.Negocio.Entity.mesajeRespuesta;
import com.parameta.SOAPClient.ISOAPEmpleado;
import com.parameta.SOAPClient.SOAPEmpleadoImplService;

@Validated
@RestController
@RequestMapping({ "/parameta" })
public class EmpleadoController {

	@PostMapping("/empleado/") 
	public mesajeRespuesta agregarEmpleado(@Valid @RequestBody Empleado empleado) {
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("CREACION EMPLEADO!!!");
		mesajeRespuesta msj = new mesajeRespuesta();
		//Validar si es Mayor de Edad
		if(this.MayorDeEdad(empleado.getFechaNacimiento())) {
			SOAPEmpleadoImplService empleadoService = new SOAPEmpleadoImplService();
			ISOAPEmpleado consumer = empleadoService.getSOAPEmpleadoImplPort();
			com.parameta.SOAPClient.Empleado empleadoClientSOAP = this.castEmplRESTToEmplSOAP(empleado);
			consumer.addEmpleado(empleadoClientSOAP);
			msj.setMensaje("OK");
			msj.setCodigo("200");
			msj.setRespuesta(this.calcularFechas(empleado.getFechaNacimiento(), empleado.getFechaVinculacion()));
		}else {
			HashMap<String, String> ERROR = new HashMap<String, String>();
			ERROR.put("ERROR", "Empleado no es mayor de edad.");
			msj.setMensaje("ERROR");
			msj.setCodigo("400");
			msj.setRespuesta(ERROR);
		}
		System.out.println("FINAL CREACION EMPLEADO!!!");
		System.out.println("--------------------------------------------------------------------------");
		return msj;
	}
	
	private com.parameta.SOAPClient.Empleado castEmplRESTToEmplSOAP(com.parameta.Negocio.Entity.Empleado empleadoSOAP){
		com.parameta.SOAPClient.Empleado empleadoClientSOAP = new com.parameta.SOAPClient.Empleado();
		empleadoClientSOAP.setNombres(empleadoSOAP.getNombres());
		empleadoClientSOAP.setApellidos(empleadoSOAP.getApellidos());
		empleadoClientSOAP.setTipoDocumento(empleadoSOAP.getTipoDocumento());
		empleadoClientSOAP.setNumeroDocumento(empleadoSOAP.getNumeroDocumento());
		empleadoClientSOAP.setCargo(empleadoSOAP.getCargo());
		empleadoClientSOAP.setSalario(empleadoSOAP.getSalario());
		GregorianCalendar gcNacimiento = new GregorianCalendar(); 
		GregorianCalendar gcVinculacion = new GregorianCalendar();
		try {
			gcNacimiento.setTime(empleadoSOAP.getFechaNacimiento());
			empleadoClientSOAP.setFechaNacimiento(DatatypeFactory.newInstance().newXMLGregorianCalendar(gcNacimiento));
			gcVinculacion.setTime(empleadoSOAP.getFechaVinculacion());
			empleadoClientSOAP.setFechaVinculacion(DatatypeFactory.newInstance().newXMLGregorianCalendar(gcVinculacion));
		}catch (Exception e) {
            e.printStackTrace();
        }
		return empleadoClientSOAP; 
	}
	
	private boolean MayorDeEdad(Date fechaNacimiento) {
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		LocalDate fechaNacimiento = LocalDate.parse( , formatter);
		Period edad =  Period.between(LocalDate.of(
				fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear(), 
				fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getMonthValue(), 
				fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getDayOfMonth()),
				LocalDate.now());
		return edad.getYears()>=18?true:false;
	}
	
	private HashMap<String, String> calcularFechas(Date fechaNacimiento, Date fechaVinculacion){
		HashMap<String, String> calculoFechas = new HashMap<String, String>();
		Period tiempoVinculacion =  Period.between(LocalDate.of(
				fechaVinculacion.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear(), 
				fechaVinculacion.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getMonthValue(), 
				fechaVinculacion.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getDayOfMonth()), 
				LocalDate.now());
		calculoFechas.put("tiempoVinculacion", String.format("%d años, %d meses y %d días",
				tiempoVinculacion.getYears(), tiempoVinculacion.getMonths(), tiempoVinculacion.getDays()));
		Period edad =  Period.between(LocalDate.of(
				fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear(), 
				fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getMonthValue(), 
				fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getDayOfMonth()), 
				LocalDate.now());
		calculoFechas.put("edad", String.format("%d años, %d meses y %d días",
		        edad.getYears(), edad.getMonths(), edad.getDays()));
		return calculoFechas;
	}
}
