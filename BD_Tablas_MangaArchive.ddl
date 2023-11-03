-- Generado por Oracle SQL Developer Data Modeler 22.2.0.165.1149
--   en:        2023-11-03 11:32:26 CLST
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE autor (
    autor_id        NUMBER NOT NULL,
    nombre          VARCHAR2(100) NOT NULL,
    nacionalidad_id NUMBER NOT NULL
);

ALTER TABLE autor ADD CONSTRAINT pk_aut PRIMARY KEY ( autor_id );

CREATE TABLE demografia (
    demografia_id NUMBER NOT NULL,
    nombre        VARCHAR2(20) NOT NULL
);

ALTER TABLE demografia ADD CONSTRAINT pk_dem PRIMARY KEY ( demografia_id );

CREATE TABLE genero (
    manga_id       NUMBER NOT NULL,
    tipo_genero_id NUMBER NOT NULL
);

ALTER TABLE genero ADD CONSTRAINT pk_gen PRIMARY KEY ( tipo_genero_id,
                                                       manga_id );

CREATE TABLE manga (
    manga_id      NUMBER NOT NULL,
    titulo        VARCHAR2(100) NOT NULL,
    precio        NUMBER NOT NULL,
    stock         NUMBER,
    autor_id      NUMBER NOT NULL,
    demografia_id NUMBER NOT NULL
);

ALTER TABLE manga ADD CONSTRAINT pk_man PRIMARY KEY ( manga_id );

CREATE TABLE nacionalidad (
    nacionalidad_id NUMBER NOT NULL,
    nombre          VARCHAR2(100) NOT NULL
);

ALTER TABLE nacionalidad ADD CONSTRAINT pk_nac PRIMARY KEY ( nacionalidad_id );

CREATE TABLE tipo_genero (
    tipo_genero_id NUMBER NOT NULL,
    nombre_genero  VARCHAR2(20) NOT NULL
);

ALTER TABLE tipo_genero ADD CONSTRAINT pk_tip PRIMARY KEY ( tipo_genero_id );

ALTER TABLE manga
    ADD CONSTRAINT fk_aut_man FOREIGN KEY ( autor_id )
        REFERENCES autor ( autor_id );

ALTER TABLE manga
    ADD CONSTRAINT fk_dem_man FOREIGN KEY ( demografia_id )
        REFERENCES demografia ( demografia_id );

ALTER TABLE autor
    ADD CONSTRAINT fk_nac_aut FOREIGN KEY ( nacionalidad_id )
        REFERENCES nacionalidad ( nacionalidad_id );

ALTER TABLE genero
    ADD CONSTRAINT fk_tip_gen FOREIGN KEY ( tipo_genero_id )
        REFERENCES tipo_genero ( tipo_genero_id );

ALTER TABLE genero
    ADD CONSTRAINT pk_man_gen FOREIGN KEY ( manga_id )
        REFERENCES manga ( manga_id );



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             6
-- CREATE INDEX                             0
-- ALTER TABLE                             11
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
