# "Constrói" uma imagem a partir do Dockerfile padrão

docker build -t qwasolucoes/todo-app .

# Faz o upload da imagem para p dockerhub

docker push qwasolucoes/todo-app:latest

# Cria e executa um container de postgres

docker run -d -e POSTGRES_PASSWORD=passwd -e POSTGRES_DB=todo -p 5435:5432 --name postgresdb postgres


# Cria, executa um container do nosso todo-app, "linka" ao container do postgres e adiciona variáveis de ambiente
docker run --link postgresdb --env-file .env -p 8089:8080 qwasolucoes/todo-app:latest\


## link para o dockerhub
https://hub.docker.com/repository/docker/qwasolucoes/todo-app