CREATE TABLE ADMSEM.TBL_REFERENCIAS 
    (
    num_id_referencia          NUMBER(6) NOT NULL,
    str_dominio                VARCHAR2(100) NOT NULL,
    str_rango_valor            VARCHAR2(50) NOT NULL,
    str_descripcion            VARCHAR2(512) NOT NULL,
    str_estado                 VARCHAR2(1) NOT NULL,
    str_tipo_identificacion_fk VARCHAR2(2) AS ( CASE "STR_DOMINIO" WHEN 'DOM_TIPO_IDENTIFICACION' THEN CAST("STR_RANGO_VALOR" AS VARCHAR2(2)) END ) VIRTUAL , 
     STR_TIPO_PRODUCTO_FK       VARCHAR2 (3) AS ( CASE "STR_DOMINIO" WHEN 'DOM_TIPO_PRODUCTO' THEN CAST("STR_RANGO_VALOR" AS VARCHAR2(3)) END ) VIRTUAL , 
     STR_TIPO_CUENTA_FK         VARCHAR2 (3) AS ( CASE "STR_DOMINIO" WHEN 'DOM_TIPO_CUENTA' THEN CAST("STR_RANGO_VALOR" AS VARCHAR2(3)) END ) VIRTUAL , 
     STR_TIPO_CLAVE_FK          VARCHAR2 (2) AS ( CASE "STR_DOMINIO" WHEN 'DOM_TIPO_CLAVE' THEN CAST("STR_RANGO_VALOR" AS VARCHAR2(2)) END ) VIRTUAL );

COMMENT ON TABLE admsem.tbl_referencias IS
    'Tabla de referencia con todos los dominios de la base de datos';

COMMENT ON COLUMN admsem.tbl_referencias.num_id_referencia IS
    'PK de referencias';

COMMENT ON COLUMN admsem.tbl_referencias.str_dominio IS
    'Identificador del dominio correspondiente';

COMMENT ON COLUMN admsem.tbl_referencias.str_rango_valor IS
    'Valores de cada dominio';

COMMENT ON COLUMN admsem.tbl_referencias.str_descripcion IS
    'Descripcion de cada valor del  dominio';

COMMENT ON COLUMN admsem.tbl_referencias.str_estado IS
    'Estado del registro (A activo  o I inactivo)';

COMMENT ON COLUMN admsem.tbl_referencias.str_tipo_identificacion_fk IS
    'Dominio de tipos de identificación del cliente';

COMMENT ON COLUMN admsem.tbl_referencias.str_tipo_producto_fk IS
    'Dominio de tipos de productos ofertados por el banco';

COMMENT ON COLUMN admsem.tbl_referencias.str_tipo_cuenta_fk IS
    'Dominio de tipos de cuentas admitidas para el producto TJD - Tarjetas debito';

COMMENT ON COLUMN admsem.tbl_referencias.str_tipo_clave_fk IS
    'Dominio para los tipos de claves';

ALTER TABLE admsem.tbl_referencias ADD CONSTRAINT tbl_referencias_pk PRIMARY KEY ( num_id_referencia );

ALTER TABLE admsem.tbl_referencias ADD CONSTRAINT uk_referencias_01 UNIQUE ( str_rango_valor,
                                                                             str_dominio );

ALTER TABLE admsem.tbl_referencias ADD CONSTRAINT uk_referencias_02 UNIQUE ( str_tipo_identificacion_fk );

ALTER TABLE admsem.tbl_referencias ADD CONSTRAINT uk_referencias_03 UNIQUE ( str_tipo_producto_fk );

ALTER TABLE admsem.tbl_referencias ADD CONSTRAINT uk_referencias_04 UNIQUE ( str_tipo_cuenta_fk );

ALTER TABLE admsem.tbl_referencias ADD CONSTRAINT uk_referencias_05 UNIQUE ( str_tipo_clave_fk );

CREATE SEQUENCE admsem.TBL_REFERENCIAS_NUM_ID_REFEREN 
START WITH 1 
    NOCACHE 
    ORDER ;

CREATE OR REPLACE TRIGGER ADMSEM.TBL_REFERENCIAS_NUM_ID_REFEREN 
BEFORE INSERT ON ADMSEM.TBL_REFERENCIAS 
FOR EACH ROW 
WHEN (NEW.NUM_ID_REFERENCIA IS NULL) 
BEGIN
:new.num_id_referencia := admsem.tbl_referencias_num_id_referen.nextval;

end;
/



