# Create docker volume folders for persistence
mkdir -p kafka-data/zookeeper-1/conf \
         kafka-data/zookeeper-1/logs \
         kafka-data/zookeeper-1/data \
         kafka-data/zookeeper-1/datalog \
         kafka-data/kafka-1/logs \
         kafka-data/kafka-1/data

### in windows
(mkdir kafka-data/zookeeper-1/conf) -And `
(mkdir kafka-data/zookeeper-1/logs) -And `
(mkdir kafka-data/zookeeper-1/data) -And `
(mkdir kafka-data/zookeeper-1/datalog) -And `
(mkdir kafka-data/kafka-1/logs) -And `
(mkdir kafka-data/kafka-1/data)


# Run kafka cluster in docker
docker compose up