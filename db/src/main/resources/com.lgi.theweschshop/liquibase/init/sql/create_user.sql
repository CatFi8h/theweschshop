 do
            $do$
            BEGIN
            IF NOT EXISTS (SELECT * FROM pg_user WHERE usename = 'tws_server') THEN

            CREATE ROLE tws_server LOGIN
            ENCRYPTED PASSWORD 'md5a5e7a8b189bbf686f0f3777adf8dd573'
            NOSUPERUSER INHERIT NOCREATEDB NOCREATEROLE NOREPLICATION;

            END IF;
            END
            $do$
