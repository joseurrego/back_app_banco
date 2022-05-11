package com.jurrego.back_app_banco.persistence;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class AdministracionPersistenciaClientes {

//    @PersistenceContext(unitName = "LOGICA_NEGOCIO")
//    private EntityManager em;

//
//    @Override
//    public void registrarCliente(ClienteEntity cliente) {
//        em.persist(cliente);
//    }
//
//    @Override
//    public ClienteEntity actualizarCliente(ClienteEntity cliente) {
//        return em.merge(cliente);
//    }
//
//
////    @Override
////    public void eliminarCliente(ClienteEntity cliente) {
////        em.remove(cliente);
////    }
//
//    @Override
//    public ClienteEntity consultarCliente(String tipoIdentificacion, String numeroIdentificacion) {
//        
//        return (ClienteEntity) em.createNamedQuery("ClienteEntity.consultarCliente")
//            .setParameter("strTipoIdentificacion", tipoIdentificacion)
//            .setParameter("strNumeroIdentificacion", numeroIdentificacion)
//            .getSingleResult();
//    }

//    @Override
//    public void actualizarClienteExecuted(String tipoIdentificacion, String numeroIdentificacion, String nombre) {
//        em.createQuery("UPDATE ClienteEntity o SET o.strNombreCompleto = :nombreCompleto " +
//          "WHERE o.strTipoIdentificacion.strTipoIdentificacionFk = :tipoIdentificacion " +
//          "AND o.strNumeroIdentificacion = :numeroIdentificacion")
//          .setParameter("nombreCompleto", nombre)
//          .setParameter("tipoIdentificacion", tipoIdentificacion)
//          .setParameter("numeroIdentificacion", numeroIdentificacion).executeUpdate();
//
//    }
}
