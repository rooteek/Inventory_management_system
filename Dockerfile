FROM tomcat:9.0-jdk17-temurin

Remove default Tomcat web applications

RUN rm -rf /usr/local/tomcat/webapps/*

Copy the built WAR file as ROOT.war so it serves at the root URL (/)

COPY dist/InventoryManagementSystem_dome.war /usr/local/tomcat/webapps/ROOT.war

Expose default Tomcat port

EXPOSE 8080

Configure Tomcat port dynamically if Render injects $PORT, then start Tomcat

CMD ["sh", "-c", "if [ -n "$PORT" ]; then sed -i 's/port="8080"/port="'"$PORT"'"/g' /usr/local/tomcat/conf/server.xml; fi && catalina.sh run"]
