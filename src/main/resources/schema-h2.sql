--
--  create a table to hold games
create table public.music
(
    music_id                integer primary key,
    music_title             character varying,
    music_artist            character varying,
    music_date_released     character varying,
    --TODO how to do genre in sql
    music_genre             character varying,
    music_num_tracks        numeric,
    music_price             numeric
);

drop sequence public.music_id_seq;

create sequence public.music_id_seq
    increment by 100
    minvalue 1
    maxvalue 2147483637
    start 1
    cache 100;





--
--  create a table to hold the users
create table public.application_user
(
    user_id        integer primary key,
    username        character varying,
    password        character varying,
    is_admin        bool
);

drop sequence public.application_user_id_seq;

create sequence public.application_user_id_seq
    increment by 100
    minvalue 1
    maxvalue 2147483637
    start 1
    cache 100;