#!/bin/bash

echo "@echo off" > bat.tpl
echo "" >> bat.tpl
echo "REM --> change DEMO_HOME to the root path of the demo" >> bat.tpl
echo "set DEMO_HOME=##DEMO_HOME##" >> bat.tpl
echo "" >> bat.tpl
cp bat.tpl DEMO.bat.tpl
cp bat.tpl run.bat.tpl
echo "%DEMO_HOME%\bin\##RUN_SCRIPT## ##EXEC_NAME## %1 %2 %3 %4 %5 %6 %7 %8 %9"  >> bat.tpl
echo "" >> bat.tpl


echo "#!/bin/bash" > sh.tpl
echo "" >> sh.tpl
echo "# --> change DEMO_HOME to the root path of the demo" >> sh.tpl
echo "DEMO_HOME=##DEMO_HOME##" >> sh.tpl
echo "" >> sh.tpl
cp sh.tpl DEMO.sh.tpl
cp sh.tpl run.sh.tpl
echo "\${DEMO_HOME}/bin/##RUN_SCRIPT## ##EXEC_NAME## \$*" >> sh.tpl
echo "" >> sh.tpl


echo "start \"abc\"       cmd /c %DEMO_HOME%\bin\bat\abc.bat ^&^& exit" >> DEMO.bat.tpl


echo "mintty --size 130,25 -p 10,360  -o ForegroundColour=255,128,255 -t ABC      \${DEMO_HOME}/bin/sh/abc.sh &" >> DEMO.sh.tpl


CP_ALL=
for i in `ls ../target/ext/lib/*.jar`
do
	ib=`basename ${i}`
	CP_ALL="${CP_ALL}##JAVA_CP_SEP####DEMO_VAR##/lib/java/${ib}"
done

CP_SELF=
for i in `ls  ../../../build/target/package-expanded/SKB-JAVA-EXAMPLES-0.0.3/dist/skb-examples-0.0.3.jar`
do
	ib=`basename ${i}`
	CP_SELF="${CP_SELF}##JAVA_CP_SEP####DEMO_VAR##/lib/java/${ib}"
done

CP_JAVA=`echo "##DEMO_VAR##/etc##JAVA_CP_SEP####DEMO_VAR##/data##JAVA_CP_SEP####DEMO_VAR##/scripts${CP_ALL}${CP_SELF}"`


echo "java -Dfile.encoding=UTF-8 -classpath \"${CP_JAVA}\" de.vandermeer.skb.examples.execs.SvcExec %1 %2 %3 %4 %5 %6 %7 %8 %9" >> run.bat.tpl
echo "" >> run.bat.tpl
echo "java -Dfile.encoding=UTF-8 -classpath \"${CP_JAVA}\" de.vandermeer.skb.examples.execs.SvcExec \$*" >> run.sh.tpl
echo "" >> run.sh.tpl
