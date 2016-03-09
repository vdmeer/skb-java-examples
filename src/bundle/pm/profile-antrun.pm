<profile>
    <id>env-copyex</id>
    <build>
        <plugins>

            <plugin>
                <artifactId>maven-antrun-plugin</artifactId>
                <version>1.8</version>
                <executions>
                    <execution>
                        <phase>generate-sources</phase>
                        <configuration>
                            <target>

                            <!-- copy the ASCII List examples -->
                            <copy todir="src/main/java/de/vandermeer/skb/examples/asciilist">
                                <fileset dir="../../ascii/list/src/test/java/de/vandermeer/asciilist/examples">
                                  <exclude name="Test_Examples.java"/>
                                </fileset>
                            </copy>

                            <replaceregexp byline="true" encoding="${encoding}">
                                <regexp pattern="package de.vandermeer.asciilist.examples;"/>
                                <substitution expression="package de.vandermeer.skb.examples.asciilist;"/>
                                <fileset dir="src/main/java/de/vandermeer/skb/examples/asciilist" >
                                    <include name="*.java" />
                                </fileset>
                            </replaceregexp>

                            <replaceregexp byline="true" encoding="${encoding}">
                                <regexp pattern="import de.vandermeer.asciilist.StandardExample;"/>
                                <substitution expression="import de.vandermeer.skb.examples.StandardExample;"/>
                                <fileset dir="src/main/java/de/vandermeer/skb/examples/asciilist" >
                                    <include name="*.java" />
                                </fileset>
                            </replaceregexp>

                        </target>
                    </configuration>
                    <goals>
                        <goal>run</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>

        </plugins>
    </build>
</profile>