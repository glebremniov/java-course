FROM gradle:8.7-jdk21 as java-build

WORKDIR /home/gradle/src
# Add write permissions
COPY --chown=gradle:gradle . /home/gradle/src

# Build war file
RUN gradle war --no-daemon

FROM tomcat:9.0.88-jre21 as servlet-container

# Copy war file to tomcat folder structure
COPY --from=java-build /home/gradle/src/build/libs/lesson4.war /usr/local/tomcat/webapps/

# Serve Tomcat
EXPOSE 8080
CMD ["catalina.sh", "run"]
