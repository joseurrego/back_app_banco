
package com.jurrego.back_app_banco.entities;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "TBL_PRODUCTOS")
@NamedQueries({@NamedQuery(name="ProductoEntity.findProductoByCliente" ,
                        query= "SELECT o " +
                                "FROM ProductoEntity o " +
                                "WHERE o.cliente.strTipoIdentificacion.strTipoIdentificacionFk = :strTipoIdentificacion " +
                                "AND o.cliente.strNumeroIdentificacion = :strNumeroIdentificacion")})
public class ProductoEntity {
    @Id
    @SequenceGenerator(name="idProductosGenerator", sequenceName = "TBL_PRODUCTOS_NUM_ID_PRODUCTO", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idProductosGenerator")
    @Column(name="NUM_ID_PRODUCTO", nullable=false)
    private Long numIdProducto;
    
    @Column(name="STR_NUMERO_PRODUCTO", nullable=false, length=20, unique = true)
    private String strNumeroProducto;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="STR_TIPO_PRODUCTO", referencedColumnName = "STR_TIPO_PRODUCTO_FK" , nullable = false)
    private ReferenciaEntity strTipoProducto;
    
    @Column(name="STR_ES_ACTIVO", nullable=false, length=1)
    private String strEsActivo;
    
    @Column(name="DTM_FECHA_CREACION", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtmFechaCreacion;
    
    @Column(name="DTM_FECHA_VENCIMIENTO", nullable=true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtmFechaVencimiento;
    
    @Column(name="NUM_CANTIDAD_INTENTOS_FALLIDS", nullable=true)
    private Long numCantidadIntentosFallidos;
    
    @JoinColumn(name="NUM_ID_CLIENTE", referencedColumnName="NUM_ID_CLIENTE", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ClienteEntity cliente;
    
    @JoinColumn(name="NUM_ID_OFICINA", referencedColumnName="NUM_ID_OFICINA", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private OficinaEntity oficina;

    public ProductoEntity() {
        //Constructor
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public Long getNumIdProducto() {
        return numIdProducto;
    }

    public void setNumIdProducto(Long numIdProducto) {
        this.numIdProducto = numIdProducto;
    }

    public String getStrNumeroProducto() {
        return strNumeroProducto;
    }

    public void setStrNumeroProducto(String strNumeroProducto) {
        this.strNumeroProducto = strNumeroProducto;
    }

    public ReferenciaEntity getStrTipoProducto() {
        return strTipoProducto;
    }

    public void setStrTipoProducto(ReferenciaEntity strTipoProducto) {
        this.strTipoProducto = strTipoProducto;
    }

    public String getStrEsActivo() {
        return strEsActivo;
    }

    public void setStrEsActivo(String strEsActivo) {
        this.strEsActivo = strEsActivo;
    }

    public Date getDtmFechaCreacion() {
        return dtmFechaCreacion;
    }

    public void setDtmFechaCreacion(Date dtmFechaCreacion) {
        this.dtmFechaCreacion = dtmFechaCreacion;
    }

    public Date getDtmFechaVencimiento() {
        return dtmFechaVencimiento;
    }

    public void setDtmFechaVencimiento(Date dtmFechaVencimiento) {
        this.dtmFechaVencimiento = dtmFechaVencimiento;
    }

    public Long getNumCantidadIntentosFallidos() {
        return numCantidadIntentosFallidos;
    }

    public void setNumCantidadIntentosFallidos(Long numCantidadIntentosFallidos) {
        this.numCantidadIntentosFallidos = numCantidadIntentosFallidos;
    }

    public OficinaEntity getOficina() {
        return oficina;
    }

    public void setOficina(OficinaEntity oficina) {
        this.oficina = oficina;
    }

    @Override
    public String toString() {
        return "ProductoEntity{" + "numIdProducto=" + numIdProducto + ", strNumeroProducto=" + strNumeroProducto + ", strTipoProducto=" + strTipoProducto.getStrTipoProductoFk() + ", strEsActivo=" + strEsActivo + ", dtmFechaCreacion=" + dtmFechaCreacion + ", dtmFechaVencimiento=" + dtmFechaVencimiento + ", numCantidadIntentosFallidos=" + numCantidadIntentosFallidos + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
}
