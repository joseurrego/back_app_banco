CREATE TABLE admsem.tbl_productos (
    num_id_producto               NUMBER(8)
        CONSTRAINT cnn_productos_01 NOT NULL,
    str_numero_producto           VARCHAR2(16)
        CONSTRAINT cnn_producto_02 NOT NULL,
    str_tipo_producto             VARCHAR2(3)
        CONSTRAINT cnn_productos_03 NOT NULL,
    str_es_activo                 VARCHAR2(1)
        CONSTRAINT cnn_productos_04 NOT NULL,
    dtm_fecha_creacion            DATE
        CONSTRAINT cnn_productos_05 NOT NULL,
    dtm_fecha_vencimiento         DATE
        CONSTRAINT cnn_productos_06 NOT NULL,
    num_cantidad_intentos_fallids NUMBER(1)
        CONSTRAINT cnn_productos_07 NOT NULL,
    num_id_cliente                NUMBER(7)
        CONSTRAINT cnn_productos_08 NOT NULL,
    num_id_oficina                NUMBER(5)
        CONSTRAINT cnn_productos_09 NOT NULL
);

COMMENT ON TABLE admsem.tbl_productos IS
    'Esta tabla contiene cada uno de los productos que se han distribuido entre los clientes del banco ACME';

COMMENT ON COLUMN admsem.tbl_productos.num_id_producto IS
    'Id primary key de productos
';

COMMENT ON COLUMN admsem.tbl_productos.str_numero_producto IS
    'Numero de identificacion del producto';

COMMENT ON COLUMN admsem.tbl_productos.str_tipo_producto IS
    'Tipo de producto del cliente (TJD, ALO, ALE, CNB)';

COMMENT ON COLUMN admsem.tbl_productos.str_es_activo IS
    'Estatus del producto si esta activo o desactivo';

COMMENT ON COLUMN admsem.tbl_productos.dtm_fecha_creacion IS
    'Fecha de la creacion del producto formato MM/YY';

COMMENT ON COLUMN admsem.tbl_productos.dtm_fecha_vencimiento IS
    'Decha del vencimiento';

COMMENT ON COLUMN admsem.tbl_productos.num_cantidad_intentos_fallids IS
    'Cantidad de los intentos fallidos';

COMMENT ON COLUMN admsem.tbl_productos.num_id_cliente IS
    'FK del clientes, al que esta relacionado el registro del producto';

COMMENT ON COLUMN admsem.tbl_productos.num_id_oficina IS
    'FK de la oficina, al que pertenece el registro del producto';

ALTER TABLE admsem.tbl_productos ADD CONSTRAINT pk_productos PRIMARY KEY ( num_id_producto );

ALTER TABLE admsem.tbl_productos ADD CONSTRAINT uk_productos_01 UNIQUE ( str_numero_producto );

ALTER TABLE admsem.tbl_productos
    ADD CONSTRAINT fk_productos_clientes_01 FOREIGN KEY ( num_id_cliente )
        REFERENCES admsem.tbl_clientes ( num_id_cliente );

ALTER TABLE admsem.tbl_productos
    ADD CONSTRAINT fk_productos_oficinas_02 FOREIGN KEY ( num_id_oficina )
        REFERENCES admsem.tbl_oficinas ( num_id_oficina );

ALTER TABLE admsem.tbl_productos
    ADD CONSTRAINT fk_productos_referencias_03 FOREIGN KEY ( str_tipo_producto )
        REFERENCES admsem.tbl_referencias ( str_tipo_producto_fk );

CREATE SEQUENCE admsem.TBL_PRODUCTOS_NUM_ID_PRODUCTO 
START WITH 1 
    NOCACHE 
    ORDER ;

CREATE OR REPLACE TRIGGER ADMSEM.TBL_PRODUCTOS_NUM_ID_PRODUCTO 
BEFORE INSERT ON ADMSEM.TBL_PRODUCTOS 
FOR EACH ROW 
WHEN (NEW.NUM_ID_PRODUCTO IS NULL) 
BEGIN
:new.num_id_producto := admsem.tbl_productos_num_id_producto.nextval;

end;
/
