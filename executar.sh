#!/bin/bash

in=$1
out=$2

(cd classes && java Main ${in} ${out})