
ALTER TABLE public.autor
ADD CONSTRAINT unique_autor_email
UNIQUE  (email);