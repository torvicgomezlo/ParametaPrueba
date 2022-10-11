
package com.parameta.SOAPClient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.parameta.soapserver package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetEmpleadosResponse_QNAME = new QName("http://SOAPServer.parameta.com/", "getEmpleadosResponse");
    private final static QName _GetEmpleados_QNAME = new QName("http://SOAPServer.parameta.com/", "getEmpleados");
    private final static QName _AddEmpleado_QNAME = new QName("http://SOAPServer.parameta.com/", "addEmpleado");
    private final static QName _AddEmpleadoResponse_QNAME = new QName("http://SOAPServer.parameta.com/", "addEmpleadoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.parameta.soapserver
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddEmpleado }
     * 
     */
    public AddEmpleado createAddEmpleado() {
        return new AddEmpleado();
    }

    /**
     * Create an instance of {@link AddEmpleadoResponse }
     * 
     */
    public AddEmpleadoResponse createAddEmpleadoResponse() {
        return new AddEmpleadoResponse();
    }

    /**
     * Create an instance of {@link GetEmpleados }
     * 
     */
    public GetEmpleados createGetEmpleados() {
        return new GetEmpleados();
    }

    /**
     * Create an instance of {@link GetEmpleadosResponse }
     * 
     */
    public GetEmpleadosResponse createGetEmpleadosResponse() {
        return new GetEmpleadosResponse();
    }

    /**
     * Create an instance of {@link Empleado }
     * 
     */
    public Empleado createEmpleado() {
        return new Empleado();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmpleadosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SOAPServer.parameta.com/", name = "getEmpleadosResponse")
    public JAXBElement<GetEmpleadosResponse> createGetEmpleadosResponse(GetEmpleadosResponse value) {
        return new JAXBElement<GetEmpleadosResponse>(_GetEmpleadosResponse_QNAME, GetEmpleadosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmpleados }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SOAPServer.parameta.com/", name = "getEmpleados")
    public JAXBElement<GetEmpleados> createGetEmpleados(GetEmpleados value) {
        return new JAXBElement<GetEmpleados>(_GetEmpleados_QNAME, GetEmpleados.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddEmpleado }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SOAPServer.parameta.com/", name = "addEmpleado")
    public JAXBElement<AddEmpleado> createAddEmpleado(AddEmpleado value) {
        return new JAXBElement<AddEmpleado>(_AddEmpleado_QNAME, AddEmpleado.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddEmpleadoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SOAPServer.parameta.com/", name = "addEmpleadoResponse")
    public JAXBElement<AddEmpleadoResponse> createAddEmpleadoResponse(AddEmpleadoResponse value) {
        return new JAXBElement<AddEmpleadoResponse>(_AddEmpleadoResponse_QNAME, AddEmpleadoResponse.class, null, value);
    }

}
