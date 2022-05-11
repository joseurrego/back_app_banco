CREATE TABLE admsem.tbl_oficinas (
    num_id_oficina     NUMBER(5)
        CONSTRAINT cnn_oficinas_01 NOT NULL,
    str_codigo         VARCHAR2(10)
        CONSTRAINT cnn_oficinas_02 NOT NULL,
    str_nombre_oficina VARCHAR2(40)
        CONSTRAINT cnn_oficinas_03 NOT NULL,
    str_direccion      VARCHAR2(30)
        CONSTRAINT cnn_oficinas_04 NOT NULL,
    num_id_ciudad      NUMBER(4) NOT NULL
);

COMMENT ON TABLE admsem.tbl_oficinas IS
    'Contiene todas las oficinas del banco "ACME"';

COMMENT ON COLUMN admsem.tbl_oficinas.num_id_oficina IS
    'PK de oficinas';

COMMENT ON COLUMN admsem.tbl_oficinas.str_codigo IS
    'Codigo representativo de la oficina';

COMMENT ON COLUMN admsem.tbl_oficinas.str_nombre_oficina IS
    'Nombre de la oficina';

COMMENT ON COLUMN admsem.tbl_oficinas.str_direccion IS
    'Direccion de la ubicacion de la oficina';

COMMENT ON COLUMN admsem.tbl_oficinas.num_id_ciudad IS
    'FK de ciudades en la que se encuentra la oficina';

ALTER TABLE admsem.tbl_oficinas ADD CONSTRAINT pk_oficinas PRIMARY KEY ( num_id_oficina );

ALTER TABLE admsem.tbl_oficinas ADD CONSTRAINT uk_oficinas_01 UNIQUE ( str_codigo );

ALTER TABLE admsem.tbl_oficinas
    ADD CONSTRAINT fk_oficinas_ciudades_01 FOREIGN KEY ( num_id_ciudad )
        REFERENCES admsem.tbl_ciudades ( num_id_ciudad );

CREATE SEQUENCE admsem.TBL_OFICINAS_NUM_ID_OFICINA 
START WITH 1 
    NOCACHE 
    ORDER ;

CREATE OR REPLACE TRIGGER ADMSEM.TBL_OFICINAS_NUM_ID_OFICINA 
BEFORE INSERT ON ADMSEM.TBL_OFICINAS 
FOR EACH ROW 
WHEN (NEW.NUM_ID_OFICINA IS NULL) 
BEGIN
:new.num_id_oficina := admsem.tbl_oficinas_num_id_oficina.nextval;

end;
/
