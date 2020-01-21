CREATE SEQUENCE public.autor_autor_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

CREATE TABLE public.autor
(
    autor_id integer NOT NULL,
    nome character varying(50) COLLATE pg_catalog."default" NOT NULL,
    descricao character varying(400) COLLATE pg_catalog."default" NOT NULL,
    email character varying(256) COLLATE pg_catalog."default" NOT NULL,
    created_at timestamp without time zone NOT NULL DEFAULT now(),
    CONSTRAINT autor_pkey PRIMARY KEY (autor_id)
);