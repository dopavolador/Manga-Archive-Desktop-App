
DROP TABLE autor CASCADE CONSTRAINTS;
DROP TABLE demografia CASCADE CONSTRAINTS;
DROP TABLE genero CASCADE CONSTRAINTS;
DROP TABLE manga CASCADE CONSTRAINTS;
DROP TABLE nacionalidad CASCADE CONSTRAINTS;
DROP TABLE tipo_genero CASCADE CONSTRAINTS;
DROP TABLE tomo CASCADE CONSTRAINTS;

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

CREATE TABLE tomo (
    manga_id NUMBER NOT NULL,
    tomo_num NUMBER NOT NULL,
    stock    NUMBER
);

ALTER TABLE tomo ADD CONSTRAINT pk_tom PRIMARY KEY ( manga_id,
                                                     tomo_num );

ALTER TABLE manga
    ADD CONSTRAINT fk_aut_man FOREIGN KEY ( autor_id )
        REFERENCES autor ( autor_id );

ALTER TABLE manga
    ADD CONSTRAINT fk_dem_man FOREIGN KEY ( demografia_id )
        REFERENCES demografia ( demografia_id );

ALTER TABLE tomo
    ADD CONSTRAINT fk_man_tom FOREIGN KEY ( manga_id )
        REFERENCES manga ( manga_id );

ALTER TABLE autor
    ADD CONSTRAINT fk_nac_aut FOREIGN KEY ( nacionalidad_id )
        REFERENCES nacionalidad ( nacionalidad_id );

ALTER TABLE genero
    ADD CONSTRAINT fk_tip_gen FOREIGN KEY ( tipo_genero_id )
        REFERENCES tipo_genero ( tipo_genero_id );

ALTER TABLE genero
    ADD CONSTRAINT pk_man_gen FOREIGN KEY ( manga_id )
        REFERENCES manga ( manga_id );