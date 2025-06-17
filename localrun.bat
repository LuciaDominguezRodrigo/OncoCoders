@echo off
setlocal

echo Levantando el servidor de traduccion (TranslationAPIServer)...
cd TranslationAPIServer
docker compose up -d
cd ..

echo Arrancando el backend Spring Boot en nueva ventana...
cd ProjectBackend
start cmd /k mvnw spring-boot:run
cd ..

echo Arrancando el frontend Angular en nueva ventana...
cd ProjectFrontend
start cmd /k "npm start"
cd ..

endlocal
