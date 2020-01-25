CREATE SEQUENCE public.category_category_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;


CREATE TABLE public.category
(
    category_id integer NOT NULL,
    nome character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT category_pkey PRIMARY KEY (category_id),
    CONSTRAINT unique_categoria_nome UNIQUE (nome)
);