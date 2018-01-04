
SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET search_path = public, pg_catalog;

INSERT INTO productreview VALUES (1, 2, 4, 'I liked it.', 3);
INSERT INTO productreview VALUES (2, 2, 1, 'Bence is more beautiful than this thing', 1);
INSERT INTO productreview VALUES (3, 2, 5, 'Fabulous', 4);
INSERT INTO productreview VALUES (4, 2, 4, 'Impressive. Most impressive.', 4);

SELECT pg_catalog.setval('productreview_id_seq', 4, true);
