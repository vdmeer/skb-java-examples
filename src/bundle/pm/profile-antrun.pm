<profile>
    <id>env-copyex</id>
    <build>
        <plugins>

            <plugin>
                <artifactId>maven-antrun-plugin</artifactId>
                <version>1.8</version>
                <executions>

                    <!-- copy the ASCII List examples -->
                    <execution>
                        <id>env-copyex-asciilist</id>
                        <phase>generate-sources</phase>
                        <configuration>
                            <target>
                            <copy todir="src/main/java/de/vandermeer/skb/examples/asciilist/examples">
                                <fileset dir="../../ascii/list/src/test/java/de/vandermeer/asciilist/examples">
                                  <exclude name="Test_Examples.java"/>
                                </fileset>
                            </copy>
                            <replaceregexp byline="true" encoding="${encoding}">
                                <regexp pattern="package de.vandermeer.asciilist.examples;"/>
                                <substitution expression="package de.vandermeer.skb.examples.asciilist.examples;"/>
                                <fileset dir="src/main/java/de/vandermeer/skb/examples/asciilist/examples">
                                    <include name="*.java" />
                                </fileset>
                            </replaceregexp>
                                <replaceregexp byline="false" encoding="${encoding}">
                                    <regexp pattern=" \* @since(.*)"/>
                                    <substitution expression=" \*"/>
                                    <fileset dir="src/main/java/de/vandermeer/skb/examples/asciilist/examples" >
                                        <include name="*.java" />
                                    </fileset>
                            </replaceregexp>
                            <replaceregexp byline="false" encoding="${encoding}">
                                <regexp pattern=" \* @version(.*)"/>
                                <substitution expression=" \*"/>
                                <fileset dir="src/main/java/de/vandermeer/skb/examples/asciilist/examples" >
                                    <include name="*.java" />
                                </fileset>
                            </replaceregexp>
                        </target>
                        </configuration>
                        <goals>
                            <goal>run</goal>
                        </goals>
                    </execution>

                    <!-- copy the ASCII Table examples -->
                    <execution>
                        <id>env-copyex-asciitable</id>
                        <phase>generate-sources</phase>
                        <configuration>
                            <target>
                                <copy todir="src/main/java/de/vandermeer/skb/examples/asciitable/examples">
                                    <fileset dir="../../ascii/table/src/test/java/de/vandermeer/asciitable/examples">
                                      <exclude name="Test_Examples.java"/>
                                    </fileset>
                                </copy>
                                <replaceregexp byline="true" encoding="${encoding}">
                                    <regexp pattern="package de.vandermeer.asciitable.examples;"/>
                                    <substitution expression="package de.vandermeer.skb.examples.asciitable.examples;"/>
                                    <fileset dir="src/main/java/de/vandermeer/skb/examples/asciitable/examples">
                                        <include name="*.java" />
                                    </fileset>
                                </replaceregexp>
                                <replaceregexp byline="false" encoding="${encoding}">
                                    <regexp pattern=" \* @since(.*)"/>
                                    <substitution expression=" \*"/>
                                    <fileset dir="src/main/java/de/vandermeer/skb/examples/asciitable/examples" >
                                        <include name="*.java" />
                                    </fileset>
                                </replaceregexp>
                                <replaceregexp byline="false" encoding="${encoding}">
                                    <regexp pattern=" \* @version(.*)"/>
                                    <substitution expression=" \*"/>
                                    <fileset dir="src/main/java/de/vandermeer/skb/examples/asciitable/examples" >
                                        <include name="*.java" />
                                    </fileset>
                                </replaceregexp>
                            </target>
                        </configuration>
                        <goals>
                            <goal>run</goal>
                        </goals>
                    </execution>

                    <!-- copy the ASCII Paragraph examples -->
                    <execution>
                        <id>env-copyex-asciiparagraph</id>
                        <phase>generate-sources</phase>
                        <configuration>
                            <target>
                                <copy todir="src/main/java/de/vandermeer/skb/examples/asciiparagraph/examples">
                                    <fileset dir="../../ascii/paragraph/src/test/java/de/vandermeer/asciiparagraph/examples">
                                      <exclude name="Test_Examples.java"/>
                                    </fileset>
                                </copy>
                                <replaceregexp byline="true" encoding="${encoding}">
                                    <regexp pattern="package de.vandermeer.asciiparagraph.examples;"/>
                                    <substitution expression="package de.vandermeer.skb.examples.asciiparagraph.examples;"/>
                                    <fileset dir="src/main/java/de/vandermeer/skb/examples/asciiparagraph/examples">
                                        <include name="*.java" />
                                    </fileset>
                                </replaceregexp>
                                <replaceregexp byline="false" encoding="${encoding}">
                                    <regexp pattern=" \* @since(.*)"/>
                                    <substitution expression=" \*"/>
                                    <fileset dir="src/main/java/de/vandermeer/skb/examples/asciiparagraph/examples" >
                                        <include name="*.java" />
                                    </fileset>
                                </replaceregexp>
                                <replaceregexp byline="false" encoding="${encoding}">
                                    <regexp pattern=" \* @version(.*)"/>
                                    <substitution expression=" \*"/>
                                    <fileset dir="src/main/java/de/vandermeer/skb/examples/asciiparagraph/examples" >
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