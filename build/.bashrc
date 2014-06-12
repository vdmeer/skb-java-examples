#!/bin/bash
while IFS='
' read line
do
	if [[ ! $line == \#* ]] && [[ ! ${#line} == 0 ]] ; then
		VAR_NAME=`echo $line | awk -F " " '{print $1}'`
		VAR_VAL=`echo $line | awk -F " " '{print $2}'`
		export ${VAR_NAME}=${VAR_VAL}
	fi
done < build.env

system=`uname -o`
prj_home=`(cd ..;pwd)`

if [ "$system" == "Cygwin" ] ; then
	export PROJECT_HOME="/"`echo $prj_home | cut -d/ -f4-`
	export PROJECT_HOME_CYG=${prj_home}
	export PROJECT_HOME_DOS=`cygpath -t windows ${prj_home}`
	export IVY_HOME=${PROJECT_HOME_DOS}
	export ASCII_DOC_EXEC=${PROJECT_HOME_DOS}/build/bin/asciidoc.bat
else
	export PROJECT_HOME=${prj_home}
	export PROJECT_HOME_CYG=${prj_home}
	export PROJECT_HOME_DOS=${prj_home}
	export IVY_HOME=${prj_home}
	export ASCII_DOC_EXEC=`which asciidoc`
fi