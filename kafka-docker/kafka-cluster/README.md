# Create docker volume folders for persistence
mkdir -p kafka-data/zookeeper-1/conf \
         kafka-data/zookeeper-1/logs \
         kafka-data/zookeeper-1/data \
         kafka-data/zookeeper-1/datalog \
         kafka-data/kafka-1/logs \
         kafka-data/kafka-1/data

# Run kafka cluster in docker
docker compose up