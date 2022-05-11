package com.jurrego.back_app_banco.facade;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.jurrego.back_app_banco.entities.ClienteEntity;
import com.jurrego.back_app_banco.entities.ReferenciaEntity;
import com.jurrego.back_app_banco.persistence.AdministracionPersistenciaClientesInterface;
import com.jurrego.back_app_banco.persistence.AdministracionPersistenciaReferenciasInterface;

public class ClienteFacade {
	


    public ClienteEntity crearCliente(Long tipoIdentificacion, String numeroIdentificacion, String nombreCompleto, Date fechaNacimiento,
			AdministracionPersistenciaClientesInterface administracionClientes,
			AdministracionPersistenciaReferenciasInterface administracionReferencias) {
		ClienteEntity cliente = new ClienteEntity();
		cliente.setStrNombreCompleto(nombreCompleto);
		cliente.setStrNumeroIdentificacion(numeroIdentificacion);
		Optional<ReferenciaEntity> referencia;
		ReferenciaFacade referenciaFacade = new ReferenciaFacade();
		referencia = referenciaFacade.consultarReferencia(tipoIdentificacion, administracionReferencias);
		cliente.setStrTipoIdentificacion(referencia.get());
		cliente.setDtmFechaNacimiento(fechaNacimiento);
		administracionClientes.save(cliente);
		return cliente;
	}
	
	public List<ClienteEntity> consultarClientes(AdministracionPersistenciaClientesInterface administracionClientes){
		return administracionClientes.findAll();
	}
	
	public Optional<ClienteEntity> consultarCliente(Long idCliente,
			AdministracionPersistenciaClientesInterface administracionClientes) {
		return null;
	}
	
	public Optional<ClienteEntity> modificarCliente(Long idCliente, String tipoIdentificacion,
			String numeroIdentificacion, String nombreCompleto, String fechaNacimiento,
			AdministracionPersistenciaClientesInterface administracionClientes) {
		return null;
	}

}
