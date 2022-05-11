package com.jurrego.back_app_banco.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

public class AdministracionPersistenciaReferencias {

    @PersistenceContext(unitName = "back_app_banco")
    private EntityManager em;


//    @Override
//    public List obtenerReferenciasTipoIdentificacion() {
//        return (List) em.createNamedQuery("ReferenciaEntity.findValoresTipoIdentificacion")
//                .getResultList();
//    }
//
//    @Override
//    public ReferenciaEntity obtenerUnTipoIdentificacion(String tipoIdentificacion) {
//        return (ReferenciaEntity) em.createNamedQuery("ReferenciaEntity.findValorTipoIdentificacion")
//          .setParameter("strTipoIdentificacion", tipoIdentificacion).getSingleResult();
//        
//    }
//
//    @Override
//    public void registrarReferencia(ReferenciaEntity referencia) {
//        em.persist(referencia);
//    }
//
//    @Override
//    public ReferenciaEntity actualizarReferencia(ReferenciaEntity referencia) {
//        
//        return em.merge(referencia);
//    }
//
//    @Override
//    public void eliminarReferencia(ReferenciaEntity referencia) {
//        em.remove(referencia);
//        
//    }
//
//    @Override
//    public ReferenciaEntity consultarReferencia(String strDominio, String strRangoValor) {
//        
//        return (ReferenciaEntity)em.createQuery("SELECT o FROM ReferenciaEntity o " +
//        "WHERE o.strDominio = :strDominio "+
//        "AND o.strRangoValor = :strRangoValor")
//        .setParameter("strDominio",strDominio)
//        .setParameter("strRangoValor",strRangoValor).getSingleResult();
//    }
}
