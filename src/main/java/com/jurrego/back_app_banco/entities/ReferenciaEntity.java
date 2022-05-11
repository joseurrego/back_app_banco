package com.jurrego.back_app_banco.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "TBL_REFERENCIAS")
@NamedQueries({@NamedQuery( name= "ReferenciaEntity.findValoresTipoIdentificacion",// dejar uno general , y uno por cadadominio por temas de rendimiento
                            query ="SELECT o FROM ReferenciaEntity o WHERE o.strTipoIdentificacionFk IS NOT NULL"),
                @NamedQuery(name="ReferenciaEntity.findValorTipoIdentificacion",
                            query="SELECT o FROM ReferenciaEntity o WHERE o.strTipoIdentificacionFk = :strTipoIdentificacion")})
public class ReferenciaEntity implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name="idReferenciasGenerator", sequenceName = "TBL_REFERENCIAS_NUM_ID_REFEREN", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idReferenciasGenerator")
    @Column(name="NUM_ID_REFERENCIA", nullable=false)
    private Long numIdReferencia;
    
    @Column(name = "STR_DOMINIO", nullable = false, length = 100)
    private String strDominio;
    
    @Column(name = "STR_RANGO_VALOR", nullable = false, length = 50)
    private String strRangoValor;
    
    @Column(name = "STR_DESCRIPCION", nullable = false, length = 512)
    private String strDescripcion;
    
    @Column(name = "STR_ESTADO", nullable = false, length = 1)
    private String strEstado;
    
    @Column(name = "STR_TIPO_IDENTIFICACION_FK", length = 2,nullable = true, unique = true, insertable = false)
    private String strTipoIdentificacionFk;
    
    @Column(name = "STR_TIPO_PRODUCTO_FK", length = 3, nullable = true, unique = true,insertable = false)
    private String strTipoProductoFk;
    
    @Column(name = "STR_TIPO_CUENTA_FK", length = 40, nullable = true, unique = true,insertable = false)
    private String strTipoCuentaFk;
    
    @Column(name = "STR_TIPO_CLAVE_FK", length = 2, nullable = true, unique = true,insertable = false)
    private String strTipoClaveFk;



    public ReferenciaEntity() {
    }

    public Long getNumIdReferencia() {
        return numIdReferencia;
    }

    public void setNumIdReferencia(Long numIdReferencia) {
        this.numIdReferencia = numIdReferencia;
    }

    public String getStrDominio() {
        return strDominio;
    }

    public void setStrDominio(String strDominio) {
        this.strDominio = strDominio;
    }

    public String getStrRangoValor() {
        return strRangoValor;
    }

    public void setStrRangoValor(String strRangoValor) {
        this.strRangoValor = strRangoValor;
    }

    public String getStrDescripcion() {
        return strDescripcion;
    }

    public void setStrDescripcion(String strDescripcion) {
        this.strDescripcion = strDescripcion;
    }

    public String getStrEstado() {
        return strEstado;
    }

    public void setStrEstado(String strEstado) {
        this.strEstado = strEstado;
    }

    public String getStrTipoIdentificacionFk() {
        return strTipoIdentificacionFk;
    }

    public void setStrTipoIdentificacionFk(String strTipoIdentificacionFk) {
        this.strTipoIdentificacionFk = strTipoIdentificacionFk;
    }

    public String getStrTipoProductoFk() {
        return strTipoProductoFk;
    }

    public void setStrTipoProductoFk(String strTipoProductoFk) {
        this.strTipoProductoFk = strTipoProductoFk;
    }

    public String getStrTipoCuentaFk() {
        return strTipoCuentaFk;
    }

    public void setStrTipoCuentaFk(String strTipoCuentaFk) {
        this.strTipoCuentaFk = strTipoCuentaFk;
    }

    public String getStrTipoClaveFk() {
        return strTipoClaveFk;
    }

    public void setStrTipoClaveFk(String strTipoClaveFk) {
        this.strTipoClaveFk = strTipoClaveFk;
    }

    @Override
    public String toString() {
        return "ReferenciaEntity{" + "numIdReferencia=" + numIdReferencia + ", strDominio=" + strDominio + ", strRangoValor=" + strRangoValor + ", strDescripcion=" + strDescripcion + ", strEstado=" + strEstado + ", strTipoIdentificacionFk=" + strTipoIdentificacionFk + ", strTipoProductoFk=" + strTipoProductoFk + ", strTipoCuentaFk=" + strTipoCuentaFk + ", strTipoClaveFk=" + strTipoClaveFk + '}';
    }
    
    
}
