CREATE TABLE admsem.tbl_claves (
    num_id_clave       NUMBER(9)
        CONSTRAINT cnn_claves_01 NOT NULL,
    str_tipo_clave     VARCHAR2(2)
        CONSTRAINT cnn_claves_02 NOT NULL,
    str_clave          VARCHAR2(4)
        CONSTRAINT cnn_claves_03 NOT NULL,
    dtm_fecha_creacion DATE
        CONSTRAINT cnn_claves_04 NOT NULL,
    num_id_producto    NUMBER(8)
        CONSTRAINT cnn_claves_05 NOT NULL
);

COMMENT ON TABLE admsem.tbl_claves IS
    'Posee todas las claves realcionadas a cada productos, siendo la ultima vigentes y las 3 anteriores el historial';

COMMENT ON COLUMN admsem.tbl_claves.num_id_clave IS
    'PK de claves';

COMMENT ON COLUMN admsem.tbl_claves.str_tipo_clave IS
    'Tipo de clave (TT, CN, UN)';

COMMENT ON COLUMN admsem.tbl_claves.str_clave IS
    'Clave del producto asociado de amnera ofuscada';

COMMENT ON COLUMN admsem.tbl_claves.dtm_fecha_creacion IS
    'Fecha de la creacion de la clave';

COMMENT ON COLUMN admsem.tbl_claves.num_id_producto IS
    'FK de productos, al que esta relacionada el registro en claves';

ALTER TABLE admsem.tbl_claves ADD CONSTRAINT pk_claves PRIMARY KEY ( num_id_clave );

ALTER TABLE admsem.tbl_claves
    ADD CONSTRAINT uk_claves_01 UNIQUE ( num_id_producto,
                                         str_clave,
                                         str_tipo_clave );

ALTER TABLE admsem.tbl_claves
    ADD CONSTRAINT fk_claves_productos_01 FOREIGN KEY ( num_id_producto )
        REFERENCES admsem.tbl_productos ( num_id_producto );

ALTER TABLE admsem.tbl_claves
    ADD CONSTRAINT fk_claves_referencias_02 FOREIGN KEY ( str_tipo_clave )
        REFERENCES admsem.tbl_referencias ( str_tipo_clave_fk );

CREATE SEQUENCE admsem.TBL_CLAVES_NUM_ID_CLAVE_SEQ 
START WITH 1 
    NOCACHE 
    ORDER ;

CREATE OR REPLACE TRIGGER ADMSEM.TBL_CLAVES_NUM_ID_CLAVE_TRG 
BEFORE INSERT ON ADMSEM.TBL_CLAVES 
FOR EACH ROW 
WHEN (NEW.NUM_ID_CLAVE IS NULL) 
BEGIN
:new.num_id_clave := admsem.tbl_claves_num_id_clave_seq.nextval;

end;
/

