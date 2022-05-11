CREATE TABLE admsem.tbl_cuentas (
    num_id_cuenta     NUMBER(9)
        CONSTRAINT cnn_cuentas_01 NOT NULL,
    str_tipo_cuenta   VARCHAR2(3)
        CONSTRAINT cnn_cuentas_02 NOT NULL,
    str_numero_cuenta VARCHAR2(20)
        CONSTRAINT cnn_cuentas_03 NOT NULL,
    num_id_producto   NUMBER(8)
        CONSTRAINT cnn_cuentas_04 NOT NULL
);

COMMENT ON TABLE admsem.tbl_cuentas IS
    'Contiene las cuentas realcionadas con el producto (TJD) Tarjetas debito, que pueden ser cuenta corriente o de ahorros';

COMMENT ON COLUMN admsem.tbl_cuentas.num_id_cuenta IS
    'PK de Cuentas';

COMMENT ON COLUMN admsem.tbl_cuentas.str_tipo_cuenta IS
    'Tipo de la cuenta (Cuenta de ahorro o corriente)';

COMMENT ON COLUMN admsem.tbl_cuentas.str_numero_cuenta IS
    'Numero unico de cada cuenta';

COMMENT ON COLUMN admsem.tbl_cuentas.num_id_producto IS
    'FK del producto al que esta relacionado el registro de la cuenta';

CREATE SEQUENCE admsem.TBL_CUENTAS_NUM_ID_CUENTA_SEQ 
START WITH 1 
    NOCACHE 
    ORDER ;

CREATE OR REPLACE TRIGGER ADMSEM.TBL_CUENTAS_NUM_ID_CUENTA_TRG 
BEFORE INSERT ON ADMSEM.TBL_CUENTAS 
FOR EACH ROW 
WHEN (NEW.NUM_ID_CUENTA IS NULL) 
BEGIN
:new.num_id_cuenta := admsem.tbl_cuentas_num_id_cuenta_seq.nextval;

end;
/
