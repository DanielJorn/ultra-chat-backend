@echo off

set DB_USERNAME=postgres
set DB_PASSWORD=postgres
set DB_URL=jdbc:postgresql://localhost:5432/ultra_chat
set DB_DIALECT=org.hibernate.dialect.PostgreSQL81Dialect

mvn compile|more

mvn exec:java^
	-Dexec.mainClass="ultra.chat.backend.UltraChatBackendApplication"^
	-DDB_USERNAME=%DB_USERNAME%^
	-DDB_PASSWORD=%DB_PASSWORD%^
	-DDB_URL=%DB_URL%^
	-DDB_DIALECT=%DB_DIALECT%