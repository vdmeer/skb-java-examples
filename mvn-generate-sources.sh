#!/usr/bin/env bash

rm src/main/java/de/vandermeer/skb/examples/asciilist/examples/*.java >& /dev/null
rm src/main/java/de/vandermeer/skb/examples/asciitable/examples/*.java >& /dev/null
rm src/main/java/de/vandermeer/skb/examples/asciiparagraph/examples/*.java >& /dev/null

mvn -P env-copyex generate-sources -q

if [ $? -eq 0 ]; then
	echo "    -> done"
	exit 0
else
	exit 255
fi
