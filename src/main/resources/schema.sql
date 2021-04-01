CREATE SEQUENCE IF NOT EXISTS assicurazioni_id_seq;
CREATE SEQUENCE IF NOT EXISTS avvocati_id_seq;
CREATE SEQUENCE IF NOT EXISTS dottori_id_seq;
CREATE SEQUENCE IF NOT EXISTS incarichi_id_seq;
CREATE SEQUENCE IF NOT EXISTS liquidatori_id_seq;
CREATE SEQUENCE IF NOT EXISTS sedi_id_seq;
CREATE SEQUENCE IF NOT EXISTS soggetti_id_seq;
CREATE SEQUENCE IF NOT EXISTS appuntamenti_id_seq;



CREATE TABLE IF NOT EXISTS public.assicurazioni
(
    id numeric NOT NULL,
    nome text COLLATE pg_catalog."default",
    email text COLLATE pg_catalog."default",
    telefono1 text COLLATE pg_catalog."default",
    telefono2 text COLLATE pg_catalog."default",
    indirizzo text COLLATE pg_catalog."default",
    cap numeric,
    partitaiva text COLLATE pg_catalog."default",
    codicefiscale text COLLATE pg_catalog."default",
    note text COLLATE pg_catalog."default",
    CONSTRAINT assicurazioni_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.avvocati
(
    id numeric NOT NULL,
    nome text COLLATE pg_catalog."default",
    cognome text COLLATE pg_catalog."default",
    titolo text COLLATE pg_catalog."default",
    indirizzo text COLLATE pg_catalog."default",
    cap numeric,
    email text COLLATE pg_catalog."default",
    pec text COLLATE pg_catalog."default",
    telefono1 text COLLATE pg_catalog."default",
    telefono2 text COLLATE pg_catalog."default",
    fax text COLLATE pg_catalog."default",
    note text COLLATE pg_catalog."default",
    CONSTRAINT avvocati_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.dottori
(
    id numeric NOT NULL,
    nome text COLLATE pg_catalog."default" NOT NULL,
    cognome text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT dottori_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.liquidatori
(
    id numeric NOT NULL,
    nome text COLLATE pg_catalog."default" NOT NULL,
    cognome text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT liquidatori_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.sedi
(
    id numeric NOT NULL,
    nome text COLLATE pg_catalog."default",
    indirizzo text COLLATE pg_catalog."default",
    cap numeric,
    CONSTRAINT sedi_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.soggetti
(
    telefono text COLLATE pg_catalog."default",
    sesso text COLLATE pg_catalog."default",
    note text COLLATE pg_catalog."default",
    nome text COLLATE pg_catalog."default" NOT NULL,
    luogonascita text COLLATE pg_catalog."default",
    indirizzo text COLLATE pg_catalog."default",
    id numeric NOT NULL,
    email text COLLATE pg_catalog."default",
    datanascita date,
    cognome text COLLATE pg_catalog."default" NOT NULL,
    codicefiscale text COLLATE pg_catalog."default",
    cap numeric,
    allegato bytea,
    CONSTRAINT soggetti_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.incarichi
(
    id numeric NOT NULL,
    numero_incarico text COLLATE pg_catalog."default",
    tipo text COLLATE pg_catalog."default",
    id_assicurazione numeric,
    id_liquidatore numeric,
    ambito text COLLATE pg_catalog."default",
    id_soggetto numeric,
    id_avvocato numeric,
    n_sinistro numeric,
    data_sinistro date,
    data_incarico date,
    note text COLLATE pg_catalog."default",
    id_dottore numeric,
    CONSTRAINT incarichi_pkey PRIMARY KEY (id),
    CONSTRAINT "assicurazioneFK" FOREIGN KEY (id_assicurazione)
        REFERENCES public.assicurazioni (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT "avvocatoFK" FOREIGN KEY (id_avvocato)
        REFERENCES public.avvocati (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT "dottoreFK" FOREIGN KEY (id_dottore)
        REFERENCES public.dottori (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT "liquidatoreFK" FOREIGN KEY (id_liquidatore)
        REFERENCES public.liquidatori (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT "soggettoFK" FOREIGN KEY (id_soggetto)
        REFERENCES public.soggetti (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

CREATE TABLE IF NOT EXISTS public.appuntamenti
(
    id numeric NOT NULL,
    id_studio numeric NOT NULL,
    data_appuntamento timestamp without time zone,
    durata numeric,
    id_incarico numeric NOT NULL,
    note text COLLATE pg_catalog."default",
    CONSTRAINT appuntamenti_pkey PRIMARY KEY (id),
    CONSTRAINT "incaricoFK" FOREIGN KEY (id_incarico)
        REFERENCES public.incarichi (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT "sedeFK" FOREIGN KEY (id_studio)
        REFERENCES public.sedi (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);