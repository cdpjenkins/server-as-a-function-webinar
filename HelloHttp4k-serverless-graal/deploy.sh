#!/bin/bash
set -e

./gradlew clean shadowJar

docker run -v $(pwd):/source http4k/amazonlinux-java-graal-ce-lambda-runtime:amazonlinux2.0.20210326.0-java11-graalce21.1.0 build/libs/HelloHttp4k.jar build/distributions/HelloHttp4k.zip

pulumi up --yes --stack graalvm