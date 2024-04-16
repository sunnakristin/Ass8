#!/bin/bash
# This script will use Maven to clean the current project, compile the source code and package it into a fat jar.

echo "Cleaning project..."
mvn clean

echo "Compiling and packaging the project..."
mvn compile assembly:single

echo "Build and package process completed."
