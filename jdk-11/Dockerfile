# Base image with Maven and JDK 11
FROM maven:3.9.6-openjdk-11

# Update and install essential tools
RUN apt-get update -qqy && apt-get install -qqy unzip gpg

# Google Chrome (Official Repo)
RUN apt-get update -qqy && apt-get install -qqy google-chrome-stable

# ChromeDriver (Official Repo)
RUN apt-get update -qqy && apt-get install -qqy chromium-chromedriver

# Cleanup
RUN apt-get clean && rm -rf /var/lib/apt/lists/* /var/cache/apt/*

# Create persistent data directory (optional)
RUN mkdir -p /data

# Set working directory
WORKDIR /app

# Copy project files (replace with your actual command)
COPY . .

# Install project dependencies
RUN mvn install -DskipTests

# Download additional resources (if needed)
# RUN wget https://example.com/resource.zip && unzip resource.zip -d /data

# Run Cucumber tests
CMD ["mvn", "clean", "test" "]