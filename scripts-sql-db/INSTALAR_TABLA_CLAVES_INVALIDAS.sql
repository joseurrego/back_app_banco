CREATE TABLE admsem.tbl_claves_invalidas (
    num_id_clave_invalida NUMBER(3)
        CONSTRAINT cnn_claves_invalidas_01 NOT NULL,
    str_clave_invalida    VARCHAR2(4)
        CONSTRAINT cnn_claves_invalidas_02 NOT NULL,
    num_id_producto       NUMBER(8)
        CONSTRAINT cnn_claves_invalidas_03 NOT NULL
);

COMMENT ON TABLE admsem.tbl_claves_invalidas IS
    'Contiene todas las claves invalidas para asignar a un producto (numeros consecutivos, numero repetidos)';

COMMENT ON COLUMN admsem.tbl_claves_invalidas.num_id_clave_invalida IS
    'PK de Claves invalidas';

COMMENT ON COLUMN admsem.tbl_claves_invalidas.str_clave_invalida IS
    'Clave invalida para asignar a los productos';

COMMENT ON COLUMN admsem.tbl_claves_invalidas.num_id_producto IS
    'FK de productos';

ALTER TABLE admsem.tbl_claves_invalidas ADD CONSTRAINT pk_claves_invalidas PRIMARY KEY ( num_id_clave_invalida );

ALTER TABLE admsem.tbl_claves_invalidas ADD CONSTRAINT uk_claves_invalidas_01 UNIQUE ( str_clave_invalida );

ALTER TABLE admsem.tbl_claves_invalidas
    ADD CONSTRAINT fk_claves_invalidas_prdcts_01 FOREIGN KEY ( num_id_producto )
        REFERENCES admsem.tbl_productos ( num_id_producto );

CREATE SEQUENCE admsem.TBL_CLAVES_INVALIDAS_NUM_ID_CL 
START WITH 1 
    NOCACHE 
    ORDER ;

CREATE OR REPLACE TRIGGER ADMSEM.TBL_CLAVES_INVALIDAS_NUM_ID_CL 
BEFORE INSERT ON ADMSEM.TBL_CLAVES_INVALIDAS 
FOR EACH ROW 
WHEN (NEW.NUM_ID_CLAVE_INVALIDA IS NULL) 
BEGIN
:new.num_id_clave_invalida := admsem.tbl_claves_invalidas_num_id_cl.nextval;

end;
/