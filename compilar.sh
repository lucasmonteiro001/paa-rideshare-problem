#!/usr/bin/env bash

mkdir -p classes

rm -rf classes/*

javac src/*.java -verbose -d classes/