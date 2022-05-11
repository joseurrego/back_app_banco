package com.jurrego.back_app_banco.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.jurrego.back_app_banco.entities.ReferenciaEntity;

public interface AdministracionPersistenciaReferenciasInterface extends JpaRepository<ReferenciaEntity, Long>{

//	Optional<ReferenciaEntity> findById(long l);
//    List obtenerReferenciasTipoIdentificacion();
//    ReferenciaEntity obtenerUnTipoIdentificacion(String tipoIdentificacion);
//
//    void registrarReferencia(ReferenciaEntity referencia);
//    ReferenciaEntity actualizarReferencia(ReferenciaEntity referencia);
//    void eliminarReferencia(ReferenciaEntity referencia);
//    ReferenciaEntity consultarReferencia(String strDominio, String strRangoValor);
}