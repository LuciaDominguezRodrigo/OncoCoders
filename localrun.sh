#!/bin/bash
set -e

echo "Levantando el servidor de traducción (TranslationAPIServer)..."
cd TranslationAPIServer
docker compose up -d
cd ..

echo "Arrancando el backend Spring Boot en nueva ventana..."
cd ProjectBackend
gnome-terminal -- bash -c "./mvnw spring-boot:run; exec bash"
cd ..

echo "Arrancando el frontend Angular en nueva ventana..."
cd ProjectFrontend
gnome-terminal -- bash -c "npm start; exec bash"
cd ..