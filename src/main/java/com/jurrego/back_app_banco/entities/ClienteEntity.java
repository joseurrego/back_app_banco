package com.jurrego.back_app_banco.entities;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "TBL_CLIENTES")
@NamedQueries({@NamedQuery(name="ClienteEntity.consultarCliente",
                           query="SELECT o FROM ClienteEntity o " +
                                "WHERE o.strTipoIdentificacion.strTipoIdentificacionFk = :strTipoIdentificacion " +
                                "AND o.strNumeroIdentificacion = :strNumeroIdentificacion")})
public class ClienteEntity {
    @Id
    @SequenceGenerator(name="idClientesGenerator", sequenceName = "TBL_CLIENTES_NUM_ID_CLIENTE", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idClientesGenerator")
    @Column(name="NUM_ID_CLIENTE", nullable=false)
    private Long numIdCliente;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "STR_TIPO_IDENTIFICACION", referencedColumnName = "STR_TIPO_IDENTIFICACION_FK", nullable = false)
    private ReferenciaEntity strTipoIdentificacion;
    
    @Column(name="STR_NUMERO_IDENTIFICACION", nullable=false, length=20)
    private String strNumeroIdentificacion;
    
    @Column(name="STR_NOMBRE_COMPLETO", nullable=false, length=40)
    private String strNombreCompleto;
    
    @Column(name="DTM_FECHA_NACIMIENTO", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtmFechaNacimiento;

    public ClienteEntity() {
    }

    public Long getNumIdCliente() {
        return numIdCliente;
    }

    public void setNumIdCliente(Long numIdCliente) {
        this.numIdCliente = numIdCliente;
    }

    public ReferenciaEntity getStrTipoIdentificacion() {
        return strTipoIdentificacion;
    }

    public void setStrTipoIdentificacion(ReferenciaEntity strTipoIdentificacion) {
        this.strTipoIdentificacion = strTipoIdentificacion;
    }

    public String getStrNumeroIdentificacion() {
        return strNumeroIdentificacion;
    }

    public void setStrNumeroIdentificacion(String strNumeroIdentificacion) {
        this.strNumeroIdentificacion = strNumeroIdentificacion;
    }

    public String getStrNombreCompleto() {
        return strNombreCompleto;
    }

    public void setStrNombreCompleto(String strNombreCompleto) {
        this.strNombreCompleto = strNombreCompleto;
    }

    public Date getDtmFechaNacimiento() {
        return dtmFechaNacimiento;
    }

    public void setDtmFechaNacimiento(Date dtmFechaNacimiento) {
        this.dtmFechaNacimiento = dtmFechaNacimiento;
    }

    @Override
    public String toString() {
        return "ClienteEntity{" + "numIdCliente=" + numIdCliente + ", strTipoIdentificacion=" + strTipoIdentificacion.getStrTipoIdentificacionFk() + ", strNumeroIdentificacion=" + strNumeroIdentificacion + ", strNombreCompleto=" + strNombreCompleto + ", dtmFechaNacimiento=" + dtmFechaNacimiento + '}';
    }

    
}
