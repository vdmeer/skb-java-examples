#!/bin/bash

# --> change DEMO_HOME to the root path of the demo
DEMO_HOME=##DEMO_HOME##

java -Dfile.encoding=UTF-8 -classpath "##DEMO_VAR##/etc##JAVA_CP_SEP####DEMO_VAR##/data##JAVA_CP_SEP####DEMO_VAR##/scripts##JAVA_CP_SEP####DEMO_VAR##/lib/java/antlr4-4.2.2.jar##JAVA_CP_SEP####DEMO_VAR##/lib/java/antlr4-annotations-4.2.2.jar##JAVA_CP_SEP####DEMO_VAR##/lib/java/antlr4-runtime-4.2.2.jar##JAVA_CP_SEP####DEMO_VAR##/lib/java/antlr-runtime-3.5.2.jar##JAVA_CP_SEP####DEMO_VAR##/lib/java/asciitable-0.0.3.jar##JAVA_CP_SEP####DEMO_VAR##/lib/java/asciitable-0.0.4-SNAPSHOT.jar##JAVA_CP_SEP####DEMO_VAR##/lib/java/commons-cli-1.2.jar##JAVA_CP_SEP####DEMO_VAR##/lib/java/commons-lang3-3.1.jar##JAVA_CP_SEP####DEMO_VAR##/lib/java/execs-0.0.3.jar##JAVA_CP_SEP####DEMO_VAR##/lib/java/execs-0.0.4-SNAPSHOT.jar##JAVA_CP_SEP####DEMO_VAR##/lib/java/hamcrest-core-1.3.jar##JAVA_CP_SEP####DEMO_VAR##/lib/java/junit-4.11.jar##JAVA_CP_SEP####DEMO_VAR##/lib/java/org.abego.treelayout.core-1.0.1.jar##JAVA_CP_SEP####DEMO_VAR##/lib/java/skb.base-0.0.3.jar##JAVA_CP_SEP####DEMO_VAR##/lib/java/skb.base-0.0.4-SNAPSHOT.jar##JAVA_CP_SEP####DEMO_VAR##/lib/java/slf4j-api-1.7.7.jar##JAVA_CP_SEP####DEMO_VAR##/lib/java/ST4-4.0.8.jar##JAVA_CP_SEP####DEMO_VAR##/lib/java/skb.examples-0.0.4-SNAPSHOT.jar" ##JAVA_MAIN_CLASS## $*

