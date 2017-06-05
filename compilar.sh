#!/usr/bin/env bash

mkdir -p classes resultados

rm -rf classes/*

javac src/*.java -verbose -d classes/