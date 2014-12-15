@echo off

REM --> change DEMO_HOME to the root path of the demo
set DEMO_HOME=##DEMO_HOME##

%DEMO_HOME%\bin\##RUN_SCRIPT## ##EXEC_NAME## %1 %2 %3 %4 %5 %6 %7 %8 %9

