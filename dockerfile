# Pull base container image from Microsoft container registry.
FROM mcr.microsoft.com/java/tomcat:8-zulu-ubuntu-tomcat-9

# Add groups/users.
RUN groupadd -r -f -g 997 tomcat
RUN useradd -r -g 997 -u 997 tomcat

# Copy application folders into the container.
COPY ["./MandatoryArtifacts/Content/", "/usr/local/tomcat/webapps/messaging-0.0.1-SNAPSHOT.war/"]
COPY ["./MandatoryArtifacts/server.xml", "/usr/local/tomcat/conf/server.xml"]
COPY ["./MandatoryArtifacts/lib", "/usr/local/tomcat/lib/"]
RUN chown -R tomcat:tomcat /usr/local/tomcat

# Download the monitoring agent for integrating with Application Insights.
ADD ["https://github.com/microsoft/ApplicationInsights-Java/releases/download/3.1.0/applicationinsights-agent-3.1.0.jar", "/opt/application-insights/applicationinsights-agent.jar"]
COPY ["./applicationinsights.json", "/opt/application-insights/applicationinsights.json"]
RUN chown -R tomcat:tomcat /opt/application-insights

# Assign user context to run the container.
COPY --chown=tomcat:tomcat ./Entryscript.sh /Entryscript.sh
USER tomcat:tomcat
RUN chmod +x /Entryscript.sh
ENTRYPOINT /Entryscript.sh
EXPOSE 8080
