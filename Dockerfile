FROM tomcat:9.0-jdk17-temurin

# Remove default Tomcat web applications
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy the built WAR file as ROOT.war so it serves at the root URL (/)
COPY dist/InventoryManagementSystem_dome.war /usr/local/tomcat/webapps/ROOT.war

# Copy and setup entrypoint script (ensure LF line endings & executable permissions)
COPY entrypoint.sh /entrypoint.sh
RUN sed -i 's/\r$//' /entrypoint.sh && chmod +x /entrypoint.sh

# Expose port (Render automatically routes web traffic)
EXPOSE 8080

ENTRYPOINT ["/entrypoint.sh"]
