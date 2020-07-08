# Bad Cassandra modeling example
Bad modeling example for Cassandra trainings. Contains:
- schema definition
- `cassandra-stress` schenarios
- sample Java application for data generation.

# Run instruction

1. Build .jar file for the Java application data generator: `mvn package`
2. Spin up cassandra node and run stress tests: `docker-compose up`
