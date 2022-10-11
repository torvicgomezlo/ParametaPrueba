package com.parameta;

import javax.xml.ws.Endpoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.parameta.SOAPServer.SOAPEmpleadoImpl;

@SpringBootApplication
public class ParametaPruebaApplication {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:1799/WS/EmpleadoParameta", new SOAPEmpleadoImpl());
		SpringApplication.run(ParametaPruebaApplication.class, args);
	}

}
