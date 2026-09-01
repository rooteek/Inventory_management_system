#!/bin/sh
set -e

# Dynamically bind Tomcat to $PORT provided by Render (default 8080 if not set)
if [ -n "$PORT" ]; then
  sed -i "s/port=\"8080\"/port=\"$PORT\"/g" /usr/local/tomcat/conf/server.xml
fi

exec catalina.sh run
