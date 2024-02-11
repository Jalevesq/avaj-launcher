#!/bin/sh

find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java avaj.app.App scenario.txt
# java avaj.app.App help