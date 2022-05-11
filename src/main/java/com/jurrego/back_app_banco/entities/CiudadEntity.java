package com.jurrego.back_app_banco.entities;

import javax.persistence.*;

@Entity
@Table(name = "TBL_CIUDADES")
public class CiudadEntity {
    @Id
    @SequenceGenerator(name="idCiudadesGenerator", sequenceName = "TBL_CIUDADES_NUM_ID_CIUDAD_SEQ", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idCiudadesGenerator")
    @Column(name="NUM_ID_CIUDAD", nullable=false)
    private Long numIdCiudad;
    
    @Column(name="STR_CODIGO_DANE_CIUDAD", nullable=false, length=10)
    private String strCodigoDaneCiudad;
    
    
    @Column(name="STR_NOMBRE_CIUDAD", nullable=false, length=40)
    private String strNombreCiudad;
    
    
    @JoinColumn(name="NUM_ID_DEPARTAMENTO", referencedColumnName="NUM_ID_DEPARTAMENTO", nullable=false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private DepartamentoEntity departamento;


    public CiudadEntity() {
    }


    public Long getNumIdCiudad() {
        return numIdCiudad;
    }

    public void setNumIdCiudad(Long numIdCiudad) {
        this.numIdCiudad = numIdCiudad;
    }
    
    public String geStrCodigoDaneCiudad() {
        return strCodigoDaneCiudad;
    }

    public void setStrCodigoDaneCiudad(String strCodigoDaneCiudad) {
        this.strCodigoDaneCiudad = strCodigoDaneCiudad;
    }

    public String getStrNombreCiudad() {
        return strNombreCiudad;
    }

    public void setStrNombreCiudad(String strNombreCiudad) {
        this.strNombreCiudad = strNombreCiudad;
    }

    public DepartamentoEntity getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoEntity departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "CiudadEntity{" + "numIdCiudad=" + numIdCiudad + ", strCodigoDaneCiudad=" + strCodigoDaneCiudad + ", strNombreCiudad=" + strNombreCiudad + '}';
    }
    
    
}
