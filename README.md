# eureka-server

- Eureka Cluster
- Spring Security Basic


default username is 'hello' and password is 'word'

start single command:
java -jar target/eureka-server-0.0.1-SNAPSHOT.jar  --spring.profiles.active=eureka-server-single

start cluster command:
- java -jar eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=eureka-server-01
- java -jar eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=eureka-server-02
- java -jar eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=eureka-server-03