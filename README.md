# Sample Project Exploring Kotlinx RPC

## Modules

### API
Defines the interface for server and client

### Server
Ktor client Publishing Random numbers

### Client
Command line tool that can consume those published numbers

## Running

start the server with
``` shell
./gradlew server:run 
```

start the client with
``` shell
./gradlew client:run
```