#!/bin/sh

BASEDIR=$(dirname "$0")

mvn -f $BASEDIR clean install -Dmaven.test.skip 