CREATE TABLE admsem.tbl_clientes (
    num_id_cliente            NUMBER(7)
        CONSTRAINT cnn_cliente_01 NOT NULL,
    str_tipo_identificacion   VARCHAR2(2)
        CONSTRAINT cnn_cliente_02 NOT NULL,
    str_numero_identificacion VARCHAR2(20)
        CONSTRAINT cnn_cliente_03 NOT NULL,
    str_nombre_completo       VARCHAR2(40)
        CONSTRAINT cnn_clientes_04 NOT NULL,
    dtm_fecha_nacimiento      DATE
        CONSTRAINT cnn_cliente_05 NOT NULL
);

COMMENT ON TABLE admsem.tbl_clientes IS
    'Esta tabla hace referencia a todos los clientes que posee el banco "ACME"';

COMMENT ON COLUMN admsem.tbl_clientes.num_id_cliente IS
    'PK Incremental de Clientes';

COMMENT ON COLUMN admsem.tbl_clientes.str_tipo_identificacion IS
    'Tipo de identificación del cliente (CC, NT, CE, TI)';

COMMENT ON COLUMN admsem.tbl_clientes.str_numero_identificacion IS
    'Numero de identificación del cliente';

COMMENT ON COLUMN admsem.tbl_clientes.str_nombre_completo IS
    'Nombre completo del cliente';

COMMENT ON COLUMN admsem.tbl_clientes.dtm_fecha_nacimiento IS
    'Fecha del nacimiento del usuario cliente';

ALTER TABLE admsem.tbl_clientes ADD CONSTRAINT pk_clientes PRIMARY KEY ( num_id_cliente );

ALTER TABLE admsem.tbl_clientes ADD CONSTRAINT uk_clientes_01 UNIQUE ( str_numero_identificacion,
                                                                       str_tipo_identificacion );

ALTER TABLE admsem.tbl_clientes
    ADD CONSTRAINT fk_clientes_referencias_01 FOREIGN KEY ( str_tipo_identificacion )
        REFERENCES admsem.tbl_referencias ( str_tipo_identificacion_fk );

CREATE SEQUENCE admsem.TBL_CLIENTES_NUM_ID_CLIENTE 
START WITH 1 
    NOCACHE 
    ORDER ;

CREATE OR REPLACE TRIGGER ADMSEM.TBL_CLIENTES_NUM_ID_CLIENTE 
BEFORE INSERT ON ADMSEM.TBL_CLIENTES 
FOR EACH ROW 
WHEN (NEW.NUM_ID_CLIENTE IS NULL) 
BEGIN
:new.num_id_cliente := admsem.tbl_clientes_num_id_cliente.nextval;

end;
/
