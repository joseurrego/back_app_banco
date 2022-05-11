package com.jurrego.back_app_banco.entities;

import javax.persistence.*;

@Entity
@Table(name = "TBL_DEPARTAMENTOS")
public class DepartamentoEntity {
    @Id
    @SequenceGenerator(name="idDepartamentosGenerator", sequenceName = "TBL_DEPARTAMENTOS_NUM_ID_DEPAR", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idDepartamentosGenerator")
    @Column(name="NUM_ID_DEPARTAMENTO", nullable=false)
    private Long numIdDepartamento;
    
    @Column(name="STR_CODIGO_DANE_DEPARTAMENTO", nullable=false, length=10, unique = true)
    private String strCodigoDaneDepartamento;
    
    @Column(name="STR_NOMBRE_DEPARTAMENTO", nullable=false, length=40)
    private String strNombreDepartamento;

    public DepartamentoEntity() {
    }

    public Long getNumIdDepartamento() {
        return numIdDepartamento;
    }

    public void setNumIdDepartamento(Long numIdDepartamento) {
        this.numIdDepartamento = numIdDepartamento;
    }
    
    public String getStrCodigoDaneDepartamento() {
        return strCodigoDaneDepartamento;
    }

    public void setCodigoDaneDepartamento(String strCodigoDaneDepartamento) {
        this.strCodigoDaneDepartamento = strCodigoDaneDepartamento;
    }

    public String getStrNombreDepartamento() {
        return strNombreDepartamento;
    }

    public void setStrNombreDepartamento(String strNombreDepartamento) {
        this.strNombreDepartamento = strNombreDepartamento;
    }

    @Override
    public String toString() {
        return "DepartamentoEntity{" + "numIdDepartamento=" + numIdDepartamento + ", strCodigoDaneDepartamento=" + strCodigoDaneDepartamento + ", strNombreDepartamento=" + strNombreDepartamento + '}';
    }

    
    
}