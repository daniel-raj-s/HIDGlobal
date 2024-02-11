# Use the base image with Maven, Java, and Chrome installed
FROM maven:3.8.4-jdk-11 AS build

# Install Chrome browser
RUN apt-get update && \
    apt-get install -y wget && \
    wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - && \
    echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google-chrome.list && \
    apt-get update && \
    apt-get install -y google-chrome-stable

# Set Chrome as the default browser for Selenium
ENV CHROME_BIN=/usr/bin/google-chrome
ENV CHROME_PATH=/usr/lib/chromium/

# Set working directory
WORKDIR /app

# Copy Maven project
COPY . .

ARG CHROME_DRIVER_VERSION=121.0.6167.85
RUN wget -q -O /tmp/chromedriver.zip https://edgedl.me.gvt1.com/edgedl/chrome/chrome-for-testing/$CHROME_DRIVER_VERSION/linux64/chromedriver-linux64.zip \
	&& unzip /tmp/chromedriver.zip -d /opt \
	&& rm /tmp/chromedriver.zip \
	&& ln -s /opt/chromedriver-linux64/chromedriver /usr/bin/chromedriver

RUN sed -i 's/--start-maximized/--headless/g' ./src/test/java/com/cucumber/utils/WebDriverSingleton.java
# Build your Maven project (assuming it's an automation testing project)
RUN mvn clean test -Dheadless=true 

# Final image
FROM openjdk:11-jre-slim

# Set working directory
WORKDIR /app

# Copy built files from the build stage (if needed)
COPY --from=build /app /app

# Specify the command to run your automated tests
CMD ["mvn", "test"]


