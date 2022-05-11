package com.jurrego.back_app_banco.entities;

import javax.persistence.*;

@Entity
@Table(name = "TBL_CLAVES_INVALIDAS")
@NamedQueries({ @NamedQuery(name="ClaveInvalidaEntity.findClavesInvalidasByNumeroProducto",
                            query="SELECT o FROM ClaveInvalidaEntity o " +
                                    "WHERE o.producto.strNumeroProducto = :strNumeroProducto")})
public class ClaveInvalidaEntity {
    @Id
    @SequenceGenerator(name="idClavesInvalidasGenerator", sequenceName = "TBL_CLAVES_INVALIDAS_NUM_ID_CL", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idClavesInvalidasGenerator")
    @Column(name="NUM_ID_CLAVE_INVALIDA", nullable=false)
    private Long numIdClaveInvalida;
    
    @Column(name="STR_CLAVE_INVALIDA", nullable=false, length=4)
    private String strClaveInvalida;
    
    @JoinColumn(name="NUM_ID_PRODUCTO", referencedColumnName="NUM_ID_PRODUCTO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProductoEntity producto; 

    public ClaveInvalidaEntity() {
    }

    public Long getNumIdClaveInvalida() {
        return numIdClaveInvalida;
    }

    public void setNumIdClaveInvalida(Long numIdClaveInvalida) {
        this.numIdClaveInvalida = numIdClaveInvalida;
    }

    public String getStrClaveInvalida() {
        return strClaveInvalida;
    }

    public void setStrClaveInvalida(String strClaveInvalida) {
        this.strClaveInvalida = strClaveInvalida;
    }

    public ProductoEntity getProducto() {
        return producto;
    }

    public void setProducto(ProductoEntity producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "ClaveInvalidaEntity{" + "numIdClaveInvalida=" + numIdClaveInvalida + ", strClaveInvalida=" + strClaveInvalida + '}';
    }

    

    
}