CREATE TABLE admsem.tbl_departamentos (
    num_id_departamento          NUMBER(3) NOT NULL,
    str_codigo_dane_departamento VARCHAR2(10)
        CONSTRAINT cnn_departamentos_01 NOT NULL,
    str_nombre_departamento      VARCHAR2(40)
        CONSTRAINT cnn_departamentos_02 NOT NULL
);

COMMENT ON TABLE admsem.tbl_departamentos IS
    'Contiene todos los departamentos donde estan ubicadas las ciudades de  las sedes del banco "ACME" ';

COMMENT ON COLUMN admsem.tbl_departamentos.str_codigo_dane_departamento IS
    'Pk Departamentos , codigo dane unico de departamentos';

COMMENT ON COLUMN admsem.tbl_departamentos.str_nombre_departamento IS
    'Departamento del dominio de accion del banco ACME';

ALTER TABLE admsem.tbl_departamentos ADD CONSTRAINT pk_departamentos PRIMARY KEY ( num_id_departamento );

ALTER TABLE admsem.tbl_departamentos ADD CONSTRAINT uk_departamentos_01 UNIQUE ( str_nombre_departamento );

CREATE SEQUENCE admsem.TBL_DEPARTAMENTOS_NUM_ID_DEPAR 
START WITH 1 
    NOCACHE 
    ORDER ;

CREATE OR REPLACE TRIGGER ADMSEM.TBL_DEPARTAMENTOS_NUM_ID_DEPAR 
BEFORE INSERT ON ADMSEM.TBL_DEPARTAMENTOS 
FOR EACH ROW 
WHEN (NEW.NUM_ID_DEPARTAMENTO IS NULL) 
BEGIN
:new.num_id_departamento := admsem.tbl_departamentos_num_id_depar.nextval;

end;
/

