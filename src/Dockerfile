FROM openjdk:18

# copy the packaged jar file into our docker image
COPY target/JavaHomeWork-1.0-SNAPSHOT.jar /JavaHomeWork.jar

# set the startup command to execute the jar file
CMD ["java", "-jar", "/JavaHomeWork.jar"]