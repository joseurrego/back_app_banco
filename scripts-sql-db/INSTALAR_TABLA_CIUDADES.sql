CREATE TABLE admsem.tbl_ciudades (
    num_id_ciudad          NUMBER(4) NOT NULL,
    str_codigo_dane_ciudad VARCHAR2(10) NOT NULL,
    str_nombre_ciudad      VARCHAR2(40)
        CONSTRAINT cnn_ciudades_02 NOT NULL,
    num_id_departamento    NUMBER(3) NOT NULL
);

COMMENT ON TABLE admsem.tbl_ciudades IS
    'Contiene todas las ciudades donde estan ubicadas las sedes del banco "ACME"';

COMMENT ON COLUMN admsem.tbl_ciudades.num_id_ciudad IS
    'Clave primaria incremental de la tabla Ciudades';

COMMENT ON COLUMN admsem.tbl_ciudades.str_codigo_dane_ciudad IS
    'Codigo unico asignado a una ciudad';

COMMENT ON COLUMN admsem.tbl_ciudades.str_nombre_ciudad IS
    'Ciudades donde pueden estar las oficinas del  banco';

ALTER TABLE admsem.tbl_ciudades ADD CONSTRAINT pk_ciudades PRIMARY KEY ( num_id_ciudad );

ALTER TABLE admsem.tbl_ciudades ADD CONSTRAINT uk_ciudades_01 UNIQUE ( str_nombre_ciudad );

ALTER TABLE admsem.tbl_ciudades
    ADD CONSTRAINT fk_ciudades_departamentos_01 FOREIGN KEY ( num_id_departamento )
        REFERENCES admsem.tbl_departamentos ( num_id_departamento );

CREATE SEQUENCE admsem.TBL_CIUDADES_NUM_ID_CIUDAD_SEQ 
START WITH 1 
    NOCACHE 
    ORDER ;

CREATE OR REPLACE TRIGGER ADMSEM.TBL_CIUDADES_NUM_ID_CIUDAD_TRG 
BEFORE INSERT ON ADMSEM.TBL_CIUDADES 
FOR EACH ROW 
WHEN (NEW.NUM_ID_CIUDAD IS NULL) 
BEGIN
:new.num_id_ciudad := admsem.tbl_ciudades_num_id_ciudad_seq.nextval;

end;
/
