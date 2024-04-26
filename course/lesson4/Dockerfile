FROM tomcat:9.0.88-jre21

# Copy war file to tomcat folder structure
COPY ./build/libs/lesson4.war /usr/local/tomcat/webapps/

# Serve Tomcat
EXPOSE 8080
CMD ["catalina.sh", "run"]
