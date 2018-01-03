
DROP SEQUENCE public.hibernate_sequence;

CREATE SEQUENCE public.hibernate_sequence
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 5
  CACHE 1;
ALTER TABLE public.hibernate_sequence
  OWNER TO bencepal;

INSERT INTO productreview VALUES (1, 2, 5, 'I liked it.', 3);
INSERT INTO productreview VALUES (2, 2, 3, 'I''m not.', 1);
INSERT INTO productreview VALUES (3, 2, 4, 'I liked it33', 4);
INSERT INTO productreview VALUES (4, 3, 4, 'I likssssssssssss', 4);



-- SELECT pg_catalog.setval('id_seq', 4, true);
