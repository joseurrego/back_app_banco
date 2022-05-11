package com.jurrego.back_app_banco.entities;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "TBL_CLAVES")
@NamedQueries( {@NamedQuery(name = "ProductoEntity.findClaveActivaByNumero",
                query = "SELECT o FROM ClaveEntity o " +
                        "WHERE o.producto.strNumeroProducto = :strNumeroProducto " +
                        "ORDER BY o.dtmFechaCreacion DESC"),

                @NamedQuery(name="ClaveEntity.findClavesByProducto" ,
                query="SELECT o FROM ClaveEntity o " +
                        "WHERE o.producto.strNumeroProducto = :strNumeroProducto " +
                        "ORDER BY o.dtmFechaCreacion")})
public class ClaveEntity {
    @Id
    @SequenceGenerator(name="idClavesGenerator", sequenceName = "TBL_CLAVES_NUM_ID_CLAVE_SEQ", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idClavesGenerator")
    @Column(name="NUM_ID_CLAVE", nullable=false)
    private Long numIdClave;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="STR_TIPO_CLAVE", referencedColumnName = "STR_TIPO_CLAVE_FK",nullable=false)
    private ReferenciaEntity strTipoClave;
    
    @Column(name="STR_CLAVE", nullable=false, length=4)
    private String strClave;
    
    @Column(name="DTM_FECHA_CREACION", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtmFechaCreacion;
    
    @JoinColumn(name="NUM_ID_PRODUCTO", referencedColumnName="NUM_ID_PRODUCTO", nullable=false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProductoEntity producto;

    public ClaveEntity() {
    }

    public Long getNumIdClave() {
        return numIdClave;
    }

    public void setNumIdClave(Long numIdClave) {
        this.numIdClave = numIdClave;
    }

    public ReferenciaEntity getStrTipoClave() {
        return strTipoClave;
    }

    public void setStrTipoClave(ReferenciaEntity strTipoClave) {
        this.strTipoClave = strTipoClave;
    }

    public String getStrClave() {
        return strClave;
    }

    public void setStrClave(String strClave) {
        this.strClave = strClave;
    }

    public Date getDtmFechaCreacion() {
        return dtmFechaCreacion;
    }

    public void setDtmFechaCreacion(Date dtmFechaCreacion) {
        this.dtmFechaCreacion = dtmFechaCreacion;
    }

    public ProductoEntity getProducto() {
        return producto;
    }

    public void setProducto(ProductoEntity producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "ClaveEntity{" + "numIdClave=" + numIdClave + ", strTipoClave=" + strTipoClave.getStrTipoClaveFk() + ", strClave=" + strClave + ", dtmFechaCreacion=" + dtmFechaCreacion + '}';
    }

    
    

}