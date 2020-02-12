CREATE SEQUENCE public.livro_livro_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

CREATE TABLE public.livro (

 livro_id integer NOT NULL,
 titulo character varying(250) NOT NULL UNIQUE,
 resumo character varying(500) NOT NULL,
 sumario text,
 preco numeric(6,2) NOT NULL CHECK(preco >= 20.00),
 numero_paginas integer  NOT NULL CHECK(numero_paginas >= 100),
 isbn character varying(17)  NOT NULL,
 data_lancamento timestamp  without time zone  NOT NULL CHECK(data_lancamento > CURRENT_TIMESTAMP),
 categoria_id integer  NOT NULL,
 constraint livro_pkey PRIMARY KEY (livro_id),
 constraint ivro_categoria_id_fKey FOREIGN KEY (categoria_id)
    references public.categoria (categoria_id) MATCH SIMPLE
    ON UPDATE CASCADE
    ON DELETE RESTRICT

);