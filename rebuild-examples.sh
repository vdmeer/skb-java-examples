#!/usr/bin/env bash

rm src/main/java/de/vandermeer/skb/examples/asciilist/examples/*.java
rm src/main/java/de/vandermeer/skb/examples/asciitable/examples/*.java
rm src/main/java/de/vandermeer/skb/examples/asciiparagraph/examples/*.java

mvn -P env-copyex generate-sources
