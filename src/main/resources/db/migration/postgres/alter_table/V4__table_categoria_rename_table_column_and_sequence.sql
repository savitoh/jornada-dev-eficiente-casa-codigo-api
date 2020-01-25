ALTER TABLE category
RENAME TO categoria;

ALTER SEQUENCE category_category_id_seq RENAME TO categoria_categoria_id_seq;

ALTER TABLE categoria DROP CONSTRAINT category_pkey;

ALTER TABLE categoria RENAME COLUMN category_id TO categoria_id;

ALTER TABLE categoria ADD CONSTRAINT categoria_pkey PRIMARY KEY (categoria_id);


