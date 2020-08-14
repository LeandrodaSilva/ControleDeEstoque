#!/bin/bash
PGPASSWORD=$POSTGRES_PASSWORD
psql --username $POSTGRES_USER --dbname $POSTGRES_DB -c "
  create user controle with encrypted password 'utfpr';
"
pg_restore --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" --verbose --clean --no-owner /docker-entrypoint-initdb.d/*.tar

# Controla quais comandos aparecerão no log do postgres
# Valores válidos: none (padrão), ddl, mod e all:
# - ddl -> CREATE, ALTER, e DROP
# - mod -> ddl + INSERT, UPDATE, DELETE, TRUNCATE e COPY FROM
echo "log_statement = 'mod'"  >> /var/lib/postgresql/data/postgresql.conf
