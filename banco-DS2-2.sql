--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.5
-- Dumped by pg_dump version 9.3.1
-- Started on 2015-05-26 07:58:47

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 1959 (class 1262 OID 12029)
-- Dependencies: 1958
-- Name: postgres; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- TOC entry 175 (class 3079 OID 11750)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1962 (class 0 OID 0)
-- Dependencies: 175
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 174 (class 3079 OID 16384)
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner: 
--

--CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- TOC entry 1963 (class 0 OID 0)
-- Dependencies: 174
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

--COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 170 (class 1259 OID 49253)
-- Name: dependente; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE dependente (
    id integer NOT NULL,
    nome character varying NOT NULL,
    sobrenome character varying NOT NULL,
    pessoa integer NOT NULL,
    CONSTRAINT dependente_nome_letras CHECK (((nome)::text ~ '^[a-zA-Z]+$'::text)),
    CONSTRAINT dependtente_sobrenome_letras_espacos CHECK (((sobrenome)::text ~ '^[a-zA-Z][a-zA-Z ]+[a-zA-Z]$|^[a-zA-Z]$'::text))
);


ALTER TABLE public.dependente OWNER TO postgres;

--
-- TOC entry 171 (class 1259 OID 49259)
-- Name: Dependente_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "Dependente_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Dependente_id_seq" OWNER TO postgres;

--
-- TOC entry 1964 (class 0 OID 0)
-- Dependencies: 171
-- Name: Dependente_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "Dependente_id_seq" OWNED BY dependente.id;


--
-- TOC entry 172 (class 1259 OID 49261)
-- Name: pessoa; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE pessoa (
    id integer NOT NULL,
    nome character varying NOT NULL,
    sobrenome character varying NOT NULL,
    CONSTRAINT pessoa_nome_letras CHECK (((nome)::text ~ '^[a-zA-Z]+$'::text)),
    CONSTRAINT pessoa_sobrenome_letras_espacos CHECK (((sobrenome)::text ~ '^[a-zA-Z][a-zA-Z ]+[a-zA-Z]$|^[a-zA-Z]$'::text))
);


ALTER TABLE public.pessoa OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 49269)
-- Name: Pessoa_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "Pessoa_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Pessoa_id_seq" OWNER TO postgres;

--
-- TOC entry 1965 (class 0 OID 0)
-- Dependencies: 173
-- Name: Pessoa_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "Pessoa_id_seq" OWNED BY pessoa.id;


--
-- TOC entry 1832 (class 2604 OID 49271)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dependente ALTER COLUMN id SET DEFAULT nextval('"Dependente_id_seq"'::regclass);


--
-- TOC entry 1835 (class 2604 OID 49272)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pessoa ALTER COLUMN id SET DEFAULT nextval('"Pessoa_id_seq"'::regclass);


--
-- TOC entry 1966 (class 0 OID 0)
-- Dependencies: 171
-- Name: Dependente_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"Dependente_id_seq"', 52, true);


--
-- TOC entry 1967 (class 0 OID 0)
-- Dependencies: 173
-- Name: Pessoa_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"Pessoa_id_seq"', 45, true);


--
-- TOC entry 1950 (class 0 OID 49253)
-- Dependencies: 170
-- Data for Name: dependente; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 1952 (class 0 OID 49261)
-- Dependencies: 172
-- Data for Name: pessoa; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO pessoa VALUES (45, 'aa', 'a');


--
-- TOC entry 1841 (class 2606 OID 49274)
-- Name: Pessoa_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY pessoa
    ADD CONSTRAINT "Pessoa_pk" PRIMARY KEY (id);


--
-- TOC entry 1839 (class 2606 OID 49276)
-- Name: dependente_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY dependente
    ADD CONSTRAINT dependente_pk PRIMARY KEY (id);


--
-- TOC entry 1842 (class 2606 OID 49277)
-- Name: dependente_pessoa_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY dependente
    ADD CONSTRAINT dependente_pessoa_fk FOREIGN KEY (pessoa) REFERENCES pessoa(id) ON DELETE CASCADE;


--
-- TOC entry 1961 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2015-05-26 07:58:47

--
-- PostgreSQL database dump complete
--

