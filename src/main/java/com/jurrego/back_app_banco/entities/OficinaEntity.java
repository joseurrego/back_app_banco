package com.jurrego.back_app_banco.entities;

import javax.persistence.*;

@Entity
@Table(name = "TBL_OFICINAS")
public class OficinaEntity {
    @Id
    @SequenceGenerator(name="idOficinasGenerator", sequenceName = "TBL_OFICINAS_NUM_ID_OFICINA", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idOficinasGenerator")
    @Column(name="NUM_ID_OFICINA", nullable=false)
    private Long numIdOficina;
    
    @Column(name="STR_CODIGO", nullable=false, length=10 , unique = true)
    private String strCodigo;
    
    @Column(name="STR_NOMBRE_OFICINA", nullable=false, length=40)
    private String strNombreOficina;
    
    @Column(name="STR_DIRECCION", nullable=false, length=30)
    private String strDireccion;
    
    @JoinColumn(name="NUM_ID_CIUDAD", referencedColumnName="NUM_ID_CIUDAD", nullable=false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CiudadEntity ciudad;

    public OficinaEntity() {
    }

    public Long getNumIdOficina() {
        return numIdOficina;
    }

    public void setNumIdOficina(Long numIdOficina) {
        this.numIdOficina = numIdOficina;
    }

    public String getStrCodigo() {
        return strCodigo;
    }

    public void setStrCodigo(String strCodigo) {
        this.strCodigo = strCodigo;
    }

    public String getStrNombreOficina() {
        return strNombreOficina;
    }

    public void setStrNombreOficina(String strNombreOficina) {
        this.strNombreOficina = strNombreOficina;
    }

    public String getStrDireccion() {
        return strDireccion;
    }

    public void setStrDireccion(String strDireccion) {
        this.strDireccion = strDireccion;
    }

    public CiudadEntity getCiudad() {
        return ciudad;
    }

    public void setCiudad(CiudadEntity ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "OficinaEntity{" + "numIdOficina=" + numIdOficina + ", strCodigo=" + strCodigo + ", strNombreOficina=" + strNombreOficina + ", strDireccion=" + strDireccion + '}';
    }

    
    
}