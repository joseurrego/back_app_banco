package com.jurrego.back_app_banco.entities;

import javax.persistence.*;

@Entity
@Table(name = "TBL_CUENTAS")
@NamedQueries({ @NamedQuery(name="CuentaEntity.findCuentasTJDActiveByCliente",
                            query="SELECT o FROM CuentaEntity o " +
                                    "WHERE o.producto.cliente.strTipoIdentificacion.strTipoIdentificacionFk = :strTipoIdentificacion " +
                                    "AND o.producto.cliente.strNumeroIdentificacion = :strNumeroIdentificacion " +
                                    "AND o.producto.strTipoProducto.strTipoProductoFk = :strTipoProducto " +
                                    "AND o.producto.strEsActivo = :strEsActivo")})
public class CuentaEntity {
    @Id
    @SequenceGenerator(name="idCuentasGenerator", sequenceName = "TBL_CUENTAS_NUM_ID_CUENTA_SEQ", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idCuentasGenerator")
    @Column(name="NUM_ID_CUENTA", nullable=false)
    private Long numIdCuenta;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="STR_TIPO_CUENTA", referencedColumnName = "STR_TIPO_CUENTA_FK", nullable = false)
    private ReferenciaEntity strTipoCuenta;
    
    @Column(name="STR_NUMERO_CUENTA", nullable=false, length=20)
    private String strNumeroCuenta;
    
    @JoinColumn(name="NUM_ID_PRODUCTO", referencedColumnName="NUM_ID_PRODUCTO", nullable=false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProductoEntity producto;

    public CuentaEntity() {
    }

    public Long getNumIdCuenta() {
        return numIdCuenta;
    }

    public void setNumIdCuenta(Long numIdCuenta) {
        this.numIdCuenta = numIdCuenta;
    }

    public ReferenciaEntity getStrTipoCuenta() {
        return strTipoCuenta;
    }

    public void setStrTipoCuenta(ReferenciaEntity strTipoCuenta) {
        this.strTipoCuenta = strTipoCuenta;
    }

    public String getStrNumeroCuenta() {
        return strNumeroCuenta;
    }

    public void setStrNumeroCuenta(String strNumeroCuenta) {
        this.strNumeroCuenta = strNumeroCuenta;
    }

    public ProductoEntity getProducto() {
        return producto;
    }

    public void setProducto(ProductoEntity producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "CuentaEntity{" + "numIdCuenta=" + numIdCuenta + ", strTipoCuenta=" + strTipoCuenta.getStrTipoCuentaFk() + ", strNumeroCuenta=" + strNumeroCuenta + '}';
    }

    
}