--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.3
-- Dumped by pg_dump version 9.6.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: tws_storage; Type: SCHEMA; Schema: -; Owner: tws_server
--

CREATE SCHEMA tws_storage;


ALTER SCHEMA tws_storage OWNER TO tws_server;

SET search_path = tws_storage, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: comments; Type: TABLE; Schema: tws_storage; Owner: tws_server
--

CREATE TABLE comments (
    id bigint NOT NULL,
    comment character varying,
    user_name character varying,
    user_email character varying,
    element_id bigint,
    creation_date timestamp without time zone DEFAULT now() NOT NULL
);


ALTER TABLE comments OWNER TO tws_server;

--
-- Name: comments_id_seq; Type: SEQUENCE; Schema: tws_storage; Owner: tws_server
--

CREATE SEQUENCE comments_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE comments_id_seq OWNER TO tws_server;

--
-- Name: comments_id_seq; Type: SEQUENCE OWNED BY; Schema: tws_storage; Owner: tws_server
--

ALTER SEQUENCE comments_id_seq OWNED BY comments.id;


--
-- Name: element_picture; Type: TABLE; Schema: tws_storage; Owner: tws_server
--

CREATE TABLE element_picture (
    element_id bigint NOT NULL,
    picture_id bigint NOT NULL
);


ALTER TABLE element_picture OWNER TO tws_server;

--
-- Name: element_size_amount; Type: TABLE; Schema: tws_storage; Owner: tws_server
--

CREATE TABLE element_size_amount (
    id bigint NOT NULL,
    element_id bigint NOT NULL,
    size_id bigint NOT NULL,
    amount integer NOT NULL
);


ALTER TABLE element_size_amount OWNER TO tws_server;

--
-- Name: element_table; Type: TABLE; Schema: tws_storage; Owner: tws_server
--

CREATE TABLE element_table (
    id bigint NOT NULL,
    name character varying(255) NOT NULL,
    description character varying(255),
    comments bigint[],
    gender character varying(255) NOT NULL,
    creation_date timestamp without time zone NOT NULL,
    color bigint,
    type bigint NOT NULL,
    is_deleted boolean DEFAULT true,
    pictures bigint[],
    price numeric DEFAULT 0 NOT NULL,
    components character varying(255)
);


ALTER TABLE element_table OWNER TO tws_server;

--
-- Name: element_table_id_seq; Type: SEQUENCE; Schema: tws_storage; Owner: tws_server
--

CREATE SEQUENCE element_table_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE element_table_id_seq OWNER TO tws_server;

--
-- Name: element_table_id_seq; Type: SEQUENCE OWNED BY; Schema: tws_storage; Owner: tws_server
--

ALTER SEQUENCE element_table_id_seq OWNED BY element_table.id;


--
-- Name: picture_table; Type: TABLE; Schema: tws_storage; Owner: tws_server
--

CREATE TABLE picture_table (
    id bigint NOT NULL,
    name character varying(255) NOT NULL,
    picture bytea NOT NULL,
    element_id bigint
);


ALTER TABLE picture_table OWNER TO tws_server;

--
-- Name: picture_table_id_seq; Type: SEQUENCE; Schema: tws_storage; Owner: tws_server
--

CREATE SEQUENCE picture_table_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE picture_table_id_seq OWNER TO tws_server;

--
-- Name: picture_table_id_seq; Type: SEQUENCE OWNED BY; Schema: tws_storage; Owner: tws_server
--

ALTER SEQUENCE picture_table_id_seq OWNED BY picture_table.id;


--
-- Name: size_table; Type: TABLE; Schema: tws_storage; Owner: tws_server
--

CREATE TABLE size_table (
    id bigint NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE size_table OWNER TO tws_server;

--
-- Name: size_table_id_seq; Type: SEQUENCE; Schema: tws_storage; Owner: tws_server
--

CREATE SEQUENCE size_table_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE size_table_id_seq OWNER TO tws_server;

--
-- Name: size_table_id_seq; Type: SEQUENCE OWNED BY; Schema: tws_storage; Owner: tws_server
--

ALTER SEQUENCE size_table_id_seq OWNED BY size_table.id;


--
-- Name: test_table; Type: TABLE; Schema: tws_storage; Owner: postgres
--

CREATE TABLE test_table (
    id bigint NOT NULL,
    name character varying
);


ALTER TABLE test_table OWNER TO postgres;

--
-- Name: type_table; Type: TABLE; Schema: tws_storage; Owner: tws_server
--

CREATE TABLE type_table (
    id bigint NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE type_table OWNER TO tws_server;

--
-- Name: type_table_id_seq; Type: SEQUENCE; Schema: tws_storage; Owner: tws_server
--

CREATE SEQUENCE type_table_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE type_table_id_seq OWNER TO tws_server;

--
-- Name: type_table_id_seq; Type: SEQUENCE OWNED BY; Schema: tws_storage; Owner: tws_server
--

ALTER SEQUENCE type_table_id_seq OWNED BY type_table.id;


--
-- Name: users; Type: TABLE; Schema: tws_storage; Owner: tws_server
--

CREATE TABLE users (
    id bigint NOT NULL,
    email character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    name character varying(255),
    surname character varying(255),
    phone character varying(255),
    user_role character varying(255)
);


ALTER TABLE users OWNER TO tws_server;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: tws_storage; Owner: tws_server
--

CREATE SEQUENCE users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE users_id_seq OWNER TO tws_server;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: tws_storage; Owner: tws_server
--

ALTER SEQUENCE users_id_seq OWNED BY users.id;


--
-- Name: comments id; Type: DEFAULT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY comments ALTER COLUMN id SET DEFAULT nextval('comments_id_seq'::regclass);


--
-- Name: element_table id; Type: DEFAULT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY element_table ALTER COLUMN id SET DEFAULT nextval('element_table_id_seq'::regclass);


--
-- Name: picture_table id; Type: DEFAULT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY picture_table ALTER COLUMN id SET DEFAULT nextval('picture_table_id_seq'::regclass);


--
-- Name: size_table id; Type: DEFAULT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY size_table ALTER COLUMN id SET DEFAULT nextval('size_table_id_seq'::regclass);


--
-- Name: type_table id; Type: DEFAULT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY type_table ALTER COLUMN id SET DEFAULT nextval('type_table_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY users ALTER COLUMN id SET DEFAULT nextval('users_id_seq'::regclass);


--
-- Data for Name: comments; Type: TABLE DATA; Schema: tws_storage; Owner: tws_server
--

COPY comments (id, comment, user_name, user_email, element_id, creation_date) FROM stdin;
\.


--
-- Name: comments_id_seq; Type: SEQUENCE SET; Schema: tws_storage; Owner: tws_server
--

SELECT pg_catalog.setval('comments_id_seq', 11, true);


--
-- Data for Name: element_picture; Type: TABLE DATA; Schema: tws_storage; Owner: tws_server
--

COPY element_picture (element_id, picture_id) FROM stdin;
\.


--
-- Data for Name: element_size_amount; Type: TABLE DATA; Schema: tws_storage; Owner: tws_server
--

COPY element_size_amount (id, element_id, size_id, amount) FROM stdin;
\.


--
-- Data for Name: element_table; Type: TABLE DATA; Schema: tws_storage; Owner: tws_server
--

COPY element_table (id, name, description, comments, gender, creation_date, color, type, is_deleted, pictures, price, components) FROM stdin;
1	Element1	description here	\N	male	2018-05-05 17:02:28.048	\N	1	t	\N	2134	\N
2	asdfasd	asdfsdfa	\N	male	2018-05-05 17:09:41.503	\N	1	t	\N	23423	\N
3	asdfasd	asdfasd	\N	male	2018-05-05 17:10:05.367	\N	1	t	\N	234	\N
4	test	test	\N	male	2018-05-10 08:41:50.862	\N	1	f	\N	345	\N
15	Shirt	asd;glhasdg;lahscnv	\N	male	2018-05-11 22:23:07.194	\N	1	f	\N	700	\N
\.


--
-- Name: element_table_id_seq; Type: SEQUENCE SET; Schema: tws_storage; Owner: tws_server
--

SELECT pg_catalog.setval('element_table_id_seq', 28, true);


--
-- Data for Name: picture_table; Type: TABLE DATA; Schema: tws_storage; Owner: tws_server
--

COPY picture_table (id, name, picture, element_id) FROM stdin;
\.


--
-- Name: picture_table_id_seq; Type: SEQUENCE SET; Schema: tws_storage; Owner: tws_server
--

SELECT pg_catalog.setval('picture_table_id_seq', 11, true);


--
-- Data for Name: size_table; Type: TABLE DATA; Schema: tws_storage; Owner: tws_server
--

COPY size_table (id, name) FROM stdin;
1	XL
\.


--
-- Name: size_table_id_seq; Type: SEQUENCE SET; Schema: tws_storage; Owner: tws_server
--

SELECT pg_catalog.setval('size_table_id_seq', 26, true);


--
-- Data for Name: test_table; Type: TABLE DATA; Schema: tws_storage; Owner: postgres
--

COPY test_table (id, name) FROM stdin;
\.


--
-- Data for Name: type_table; Type: TABLE DATA; Schema: tws_storage; Owner: tws_server
--

COPY type_table (id, name) FROM stdin;
1	Shirt
\.


--
-- Name: type_table_id_seq; Type: SEQUENCE SET; Schema: tws_storage; Owner: tws_server
--

SELECT pg_catalog.setval('type_table_id_seq', 25, true);


--
-- Data for Name: users; Type: TABLE DATA; Schema: tws_storage; Owner: tws_server
--

COPY users (id, email, password, name, surname, phone, user_role) FROM stdin;
\.


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: tws_storage; Owner: tws_server
--

SELECT pg_catalog.setval('users_id_seq', 1, false);


--
-- Name: element_size_amount element_size_amount_pkey; Type: CONSTRAINT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY element_size_amount
    ADD CONSTRAINT element_size_amount_pkey PRIMARY KEY (id);


--
-- Name: comments pk_comments; Type: CONSTRAINT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY comments
    ADD CONSTRAINT pk_comments PRIMARY KEY (id);


--
-- Name: element_table pk_element_table; Type: CONSTRAINT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY element_table
    ADD CONSTRAINT pk_element_table PRIMARY KEY (id);


--
-- Name: picture_table pk_picture_table; Type: CONSTRAINT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY picture_table
    ADD CONSTRAINT pk_picture_table PRIMARY KEY (id);


--
-- Name: size_table pk_size_table; Type: CONSTRAINT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY size_table
    ADD CONSTRAINT pk_size_table PRIMARY KEY (id);


--
-- Name: type_table pk_type_table; Type: CONSTRAINT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY type_table
    ADD CONSTRAINT pk_type_table PRIMARY KEY (id);


--
-- Name: users pk_users; Type: CONSTRAINT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY users
    ADD CONSTRAINT pk_users PRIMARY KEY (id);


--
-- Name: size_table size_name_unique; Type: CONSTRAINT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY size_table
    ADD CONSTRAINT size_name_unique UNIQUE (name);


--
-- Name: test_table test-pk; Type: CONSTRAINT; Schema: tws_storage; Owner: postgres
--

ALTER TABLE ONLY test_table
    ADD CONSTRAINT "test-pk" PRIMARY KEY (id);


--
-- Name: type_table type_name_unique; Type: CONSTRAINT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY type_table
    ADD CONSTRAINT type_name_unique UNIQUE (name);


--
-- Name: element_table fk_el_type; Type: FK CONSTRAINT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY element_table
    ADD CONSTRAINT fk_el_type FOREIGN KEY (type) REFERENCES type_table(id);


--
-- Name: element_size_amount fk_element_size_amount__element; Type: FK CONSTRAINT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY element_size_amount
    ADD CONSTRAINT fk_element_size_amount__element FOREIGN KEY (element_id) REFERENCES element_table(id);


--
-- Name: element_size_amount fk_element_size_amount__size; Type: FK CONSTRAINT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY element_size_amount
    ADD CONSTRAINT fk_element_size_amount__size FOREIGN KEY (size_id) REFERENCES size_table(id);


--
-- Name: element_picture fk_ep_element; Type: FK CONSTRAINT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY element_picture
    ADD CONSTRAINT fk_ep_element FOREIGN KEY (element_id) REFERENCES element_table(id);


--
-- Name: element_picture fk_ep_picture; Type: FK CONSTRAINT; Schema: tws_storage; Owner: tws_server
--

ALTER TABLE ONLY element_picture
    ADD CONSTRAINT fk_ep_picture FOREIGN KEY (picture_id) REFERENCES picture_table(id);


--
-- PostgreSQL database dump complete
--

