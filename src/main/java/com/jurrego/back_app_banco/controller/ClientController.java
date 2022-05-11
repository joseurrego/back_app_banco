package com.jurrego.back_app_banco.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jurrego.back_app_banco.entities.ClienteEntity;
import com.jurrego.back_app_banco.facade.ClienteFacade;
import com.jurrego.back_app_banco.persistence.AdministracionPersistenciaClientesInterface;
import com.jurrego.back_app_banco.persistence.AdministracionPersistenciaReferenciasInterface;


@RestController
@CrossOrigin( origins = "*", allowedHeaders = "*")
@RequestMapping("/ControllerClients")
public class ClientController {
	
	ClienteFacade clienteFacade = new ClienteFacade();
	
	@Autowired
	private AdministracionPersistenciaClientesInterface administracionClientes;
	@Autowired
	private AdministracionPersistenciaReferenciasInterface administracionReferencias;

	@PostMapping("/crearCliente")
	public ClienteEntity crearCliente(@RequestParam("tipoIdentificacion") Long tipoIdentificacion, 
								@RequestParam("numeroIdentificacion") String numeroIdentificacion,
								@RequestParam("nombreCompleto") String nombreCompleto,
								@RequestParam("fechaNacimiento") String fechaNacimiento) {
		System.out.println("fecha nacimiento - "+fechaNacimiento);
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fechaNacimiento);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
		return clienteFacade.crearCliente(tipoIdentificacion, numeroIdentificacion, nombreCompleto, fechaDate, administracionClientes, administracionReferencias);
	}
	
	@GetMapping("/consultarClientes")
	public List<ClienteEntity> consultarClientes(){
		return clienteFacade.consultarClientes(administracionClientes);
	}
	
	@GetMapping("/consultarCliente")
	public Optional<ClienteEntity> consultarCliente(@RequestParam("idCliente") Long idCliente){
		return clienteFacade.consultarCliente(idCliente, administracionClientes);
	}
	
	@PutMapping("/modificarCliente")
	public Optional<ClienteEntity> modificarCliente(@RequestParam("idCliente") Long idCliente,
													@RequestParam("tipoIdentificacion") String tipoIdentificacion, 
													@RequestParam("numeroIdentificacion") String numeroIdentificacion,
													@RequestParam("nombreCompleto") String nombreCompleto,
													@RequestParam("fechaNacimiento") String fechaNacimiento){
		return clienteFacade.modificarCliente(idCliente, tipoIdentificacion, numeroIdentificacion, nombreCompleto, fechaNacimiento, administracionClientes);
	}
	
	// Delete cliente
}
