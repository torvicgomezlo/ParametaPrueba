package com.parameta.SOAPServer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import javax.jws.WebService;

@WebService(endpointInterface = "com.parameta.SOAPServer.ISOAPEmpleado")
public class SOAPEmpleadoImpl implements ISOAPEmpleado{

	@Override
	public void addEmpleado(Empleado empleado) {
		Empleado.getEmpleados().add(empleado);
		this.insertBDMysql(empleado);
	}
	
	@Override
	public List<Empleado> getEmpleados(){
		return Empleado.getEmpleados();
	}
	
	private void insertBDMysql(Empleado empleado) {
		try
        {
			System.out.println("empleado--->"+empleado);
			if(empleado!=null) {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con=DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/parameta","root","mysql");
	            System.out.println("Connected:::>>>"+con);
	            System.out.println("EMPLEADO::>>"+empleado.getNombres()+" "+empleado.getApellidos()+" "
	            		+ "\r\n IDENTIFICACION::>>"+empleado.getTipoDocumento()+" "+empleado.getNumeroDocumento()+" "
	            		+ "\r\n FECHA NACIMIENTO::>>"+empleado.getFechaNacimiento().toString()+" "
	    				+ "\r\n CARGO Y SALARIO::>>"+empleado.getCargo()+" - ["+empleado.getSalario()+"]"
						+ "\r\n FECHA VINCULACION::>>"+empleado.getFechaVinculacion().toString());
	            String insert = "insert into parameta.empleado (nombres, apellidos, fechaNacimiento, salario, "
	            		+ " tipoDocumento, numeroDocumento, fechaVinculacion, cargo) "
	            		+ " values (?,?,?,?,?,?,?,?) ";
	            PreparedStatement pStmt = con.prepareStatement(insert);
	            pStmt.setString(1,empleado.getNombres());
	            pStmt.setString(2,empleado.getApellidos());
	            pStmt.setDate(3,new Date(empleado.getFechaNacimiento().getTime()));
	            pStmt.setDouble(4,empleado.getSalario());
	            pStmt.setString(5,empleado.getTipoDocumento());
	            pStmt.setString(6,empleado.getNumeroDocumento());
	            pStmt.setDate(7,new Date(empleado.getFechaVinculacion().getTime()));
	            pStmt.setString(8,empleado.getCargo());
	            pStmt.execute();
	            con.close();
	            System.out.println("EMPLEADO::>>"+empleado.getNombres()+" "+empleado.getApellidos()+" "
	            		+ "\r\n IDENTIFICACION::>>"+empleado.getTipoDocumento()+" "+empleado.getNumeroDocumento()+" "
	            		+ "\r\n FECHA NACIMIENTO::>>"+empleado.getFechaNacimiento().toString()+" "
	    				+ "\r\n CARGO Y SALARIO::>>"+empleado.getCargo()+" - ["+empleado.getSalario()+"]"
						+ "\r\n FECHA VINCULACION::>>"+empleado.getFechaNacimiento().toString());            		
	            System.out.println("Connection Close:::>>"+con);  
			}
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
	}
	
	
}
