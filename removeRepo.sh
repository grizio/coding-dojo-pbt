#!/usr/bin/env bash

curl --request DELETE --write "%{http_code} %{url_effective}\n" --user kneelnrise:Bomstom-49 --output /dev/null --silent https://oss.sonatype.org/content/repositories/snapshots/io/github/definiti/core_2.12