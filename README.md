# Calculator
A simple HTTP server application that exposes a calculator API.
The API enables user to do simple arithmetic operations: `add`, `subtract`, `multiply`, `divide` on two numbers.

## Requirements
- [ ] Containerize the application using Docker
- [ ] Define the infrastructure as code using **CDK** and **Kotlin**
- [ ] Run the containerized application in ECS using Fargate
- [ ] Expose the API to the public internet

## Building and running the application
The application uses [Gradle](https://gradle.org/) to build the application's JAR with it's dependencies (fat JAR / uber JAR).

The application can be built and run using the available shell scripts in the [scripts](./scripts/) directory

### Prerequisite
- Java: If you don't have Java installed, you can install one from [adoptium](https://adoptium.net/en-GB/)
- Gradle: This will be installed when running one of the scripts for the first time
- CDK: Check this [AWS documentation](https://docs.aws.amazon.com/cdk/v2/guide/getting_started.html#getting_started_install) for getting started with CDK

### Available scripts
There are helper shell scripts in the [scripts](./scripts/) directory.

Running the scripts for the first time will install Gradle.

- To run the unit tests of the application:
```sh
> ./scripts/test.sh     # runs all unit tests using Gradle's check task
```

- To build the application:
```sh
> ./scripts/build.sh    # creates a fat jar file in app/build/libs/app.jar
```

- To build and run the application:
```sh
> ./scripts/run.sh     # runs the build.sh script and runs the application using java -jar
> 09:00:00.000 [main] INFO  Main - Server started. Listening at port 8001
```

## API endpoints
Once the application server is up and running, the following endpoints should be available

### `/api/v1/health`
```sh
> curl --location --request GET 'http://localhost:8001/api/v1/health'
> OK
```

### `/api/v1/calculate`
```sh
> curl --location --request POST 'http://localhost:8001/api/v1/calculate' \
--header 'x-api-key: <API_KEY>' \
--header 'Content-Type: application/json' \
--data-raw '{
    "x": 1,
    "y": 3,
    "operation": "DIVIDE"
}'
> {"data":0.3333333333333333}
```

### `/api/v1/swagger.json`
```sh
> curl --location --request GET 'http://localhost:8001/api/v1/swagger.json'
```

## Documentation
A swagger documentation can be found in [swagger.json](./swagger.json)

## Building and running CDK

The [infra](./infra) project contains the infrastructure as code using CDK + Kotlin.

To run the CDK commands such as `synth`, `deploy`, etc.
```sh
> cd infra/
> cdk synth   # runs cdk synthesize command
```

## Libraries used
- [http4k](https://www.http4k.org/documentation/): for the server application
- [junit5](https://junit.org/junit5/docs/current/user-guide/): for unit testing
- [slf4j](https://www.slf4j.org/) and [logback](https://logback.qos.ch/): for logging
- [cdk](https://docs.aws.amazon.com/cdk/v2/guide/home.html): for the infrastructure as code

