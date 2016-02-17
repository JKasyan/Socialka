CREATE TYPE gender_enum AS ENUM ('m', 'w');
CREATE TYPE friend_status AS ENUM ('one', 'two', 'three');

CREATE SEQUENCE friends_id_friendship_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

CREATE SEQUENCE groups_id_group_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

CREATE SEQUENCE images_id_image_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

CREATE SEQUENCE small_images_id_image_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

CREATE SEQUENCE user_roles_user_role_id_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

CREATE SEQUENCE users_id_user_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

CREATE TABLE users
(
  id_user serial NOT NULL,
  email text,
  password text,
  name text,
  last_name text,
  gender gender_enum NOT NULL,
  enabled boolean NOT NULL,
  avatar_id integer NOT NULL,
  CONSTRAINT id_user_pk PRIMARY KEY (id_user),
  CONSTRAINT unique_avatar_id UNIQUE (avatar_id)
);

CREATE TABLE user_roles
(
  user_role_id serial NOT NULL,
  role text NOT NULL,
  id_user integer NOT NULL,
  CONSTRAINT user_roles_pkey PRIMARY KEY (user_role_id),
  CONSTRAINT user_roles_id_user_fkey FOREIGN KEY (id_user)
  REFERENCES users (id_user) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE small_images
(
  id_image serial NOT NULL,
  small_image_value bit(1)[] NOT NULL,
  CONSTRAINT small_images_pkey PRIMARY KEY (id_image),
  CONSTRAINT small_images_id_image_fkey FOREIGN KEY (id_image)
  REFERENCES images (id_image) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE images
(
  id_image serial NOT NULL,
  title text NOT NULL,
  image_value bit(1)[] NOT NULL,
  id_user integer NOT NULL,
  CONSTRAINT images_pkey PRIMARY KEY (id_image),
  CONSTRAINT images_id_user_fkey FOREIGN KEY (id_user)
  REFERENCES users (id_user) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE groups
(
  id_group serial NOT NULL,
  title text NOT NULL,
  description text,
  city character varying(20) NOT NULL,
  CONSTRAINT groups_pkey PRIMARY KEY (id_group),
  CONSTRAINT unique_title UNIQUE (title)
);

CREATE TABLE friends
(
  id_friendship serial NOT NULL,
  id_one integer NOT NULL,
  id_two integer NOT NULL,
  status friend_status NOT NULL,
  CONSTRAINT friends_pkey PRIMARY KEY (id_friendship),
  CONSTRAINT friends_id_one_fkey FOREIGN KEY (id_one)
  REFERENCES users (id_user) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT friends_id_two_fkey FOREIGN KEY (id_two)
  REFERENCES users (id_user) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
);
