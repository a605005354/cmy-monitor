# Cmy Monitor
======================
This is a basic template that monitors anything you like with big data, You need to have Java installed.

JDK version: 11

Maven version: 3.6.3

Data Process: kafka -> flink -> hbase

Deployed environment with docker.

### Mysql Deploy
```
docker pull mysql:5.6
docker run -id \
-p 3307:3307 \
--name=container_mysql \
-v /usr/local/mysql/conf:/etc/mysql/conf.d \
-v /usr/local/mysql/logs:/logs \
-v /usr/local/mysql/data:/var/lib/mysql \
-e MYSQL_ROOT_PASSWORD=123456 \
mysql:5.6
```

### Kafka Deploy ###
```
docker pull wurstmeister/zookeeper
docker pull wurstmeister/kafka
```
docker-compose.yml
```
version: '3'
services:
  zookeeper:
    image: wurstmeister/zookeeper
    ports:
      - "2181:2181"
  kafka:
    image: wurstmeister/kafka
    depends_on: [ zookeeper ]
    ports:
      - "9092:9092"
    environment:
      KAFKA_ADVERTISED_HOST_NAME: localhost
      KAFKA_CREATE_TOPICS: "test"
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
    volumes:
      - /data/product/king_bigdata/data/kafka/docker.sock:/var/run/docker.sock
  kafka-manager:  
    image: sheepkiller/kafka-manager               
    environment:
        ZK_HOSTS: "zookeeper:2181"               
    ports:  
      - "9000:9000"                              
    depends_on:
      - zookeeper
      - kafka
```
docker build
```
1.docker-compose build  
2.docker-compose up -d  
```
# Cmy Monitor
======================
This is a basic template that monitors anything you like with big data, You need to have Java installed.

JDK version: 11

Maven version: 3.6.3

Data Process: kafka -> flink -> hbase

Deployed environment with docker.

### Mysql Deploy
```
docker pull mysql:5.6
docker run -id \
-p 3307:3307 \
--name=container_mysql \
-v /usr/local/mysql/conf:/etc/mysql/conf.d \
-v /usr/local/mysql/logs:/logs \
-v /usr/local/mysql/data:/var/lib/mysql \
-e MYSQL_ROOT_PASSWORD=123456 \
mysql:5.6
```

### Kafka Deploy ###
```
docker pull wurstmeister/zookeeper
docker pull wurstmeister/kafka
```
docker-compose.yml
```
version: '3'
services:
  zookeeper:
    image: wurstmeister/zookeeper
    ports:
      - "2181:2181"
  kafka:
    image: wurstmeister/kafka
    depends_on: [ zookeeper ]
    ports:
      - "9092:9092"
    environment:
      KAFKA_ADVERTISED_HOST_NAME: localhost
      KAFKA_CREATE_TOPICS: "test"
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
    volumes:
      - /data/product/king_bigdata/data/kafka/docker.sock:/var/run/docker.sock
  kafka-manager:  
    image: sheepkiller/kafka-manager               
    environment:
        ZK_HOSTS: "zookeeper:2181"               
    ports:  
      - "9000:9000"                              
    depends_on:
      - zookeeper
      - kafka
```
docker build
```
1.docker-compose build  
2.docker-compose up -d  
```
