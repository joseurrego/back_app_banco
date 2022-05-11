package com.jurrego.back_app_banco.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jurrego.back_app_banco.entities.ReferenciaEntity;
import com.jurrego.back_app_banco.facade.ReferenciaFacade;
import com.jurrego.back_app_banco.persistence.AdministracionPersistenciaReferenciasInterface;


@RestController
@CrossOrigin( origins="*", allowedHeaders = "*")
@RequestMapping("/ControllerReferencias")
public class ReferenciaController {
	
	ReferenciaFacade referenciaFacade = new ReferenciaFacade();
	
	@Autowired
	AdministracionPersistenciaReferenciasInterface administracionReferencias;
	
	@GetMapping("/consultaReferencia")
	public Optional<ReferenciaEntity> consultarReferencia(@RequestParam("id_referencia") Long id_referencia) {
		return referenciaFacade.consultarReferencia(id_referencia, administracionReferencias);
	}

}
