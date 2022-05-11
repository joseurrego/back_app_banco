package com.jurrego.back_app_banco.facade;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import com.jurrego.back_app_banco.entities.ReferenciaEntity;
import com.jurrego.back_app_banco.persistence.AdministracionPersistenciaReferenciasInterface;

public class ReferenciaFacade {
	
	public Optional<ReferenciaEntity> consultarReferencia(Long id_referencia, AdministracionPersistenciaReferenciasInterface administracionReferencias) {
		return administracionReferencias.findById(id_referencia);
	}

}
