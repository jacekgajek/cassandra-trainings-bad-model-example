# Bad Cassandra modeling example
Bad modeling example for Cassandra trainings. Contains:
- schema definition
- `cassandra-stress` schenarios
- sample Java application for data generation

To run all stress tests, including the semantive.generator.model Java application:

1. Build .jar file for the Java application data generator: `mvn package`
2. Make sure there that the 9042 port isn't occupied by a host service or another container.
3. Spin up a cassandra node and run stress tests: `docker-compose up --build`

