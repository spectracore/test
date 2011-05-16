DESCRIPTION = "Google C++ Testing Framework"
LICENSE = "GOOGLE"
PR = "r0"

DEPENDS += "zip"

inherit cmake pkgconfig

SRC_URI = "http://googletest.googlecode.com/files/gtest-1.6.0.zip"
LIC_FILES_CHKSUM = "file://COPYING;md5=cbbd27594afd089daa160d3a16dd515a"

SRC_URI[md5sum] = "4577b49f2973c90bf9ba69aa8166b786"
SRC_URI[sha256sum] = "5ec97df8e75b4ee796604e74716d1b50582beba22c5502edd055a7e67a3965d8"

#do_unpack() {
#        unzip gtest-1.6.0.zip
#}

do_compile() {
#        mkdir -p ${}/gtest_build
#       cd ${WORKDIR}/gtest_build
#	echo 111111111111111111111111111111111111111111
#	pwd
#	echo "cmake -DGTEST_HAS_PTHREAD=1 ${S}"
        cmake -DGTEST_HAS_PTHREAD=1 ${S}    
#	echo 222222222222222222222222222222222222222222
        make
#	echo 333333333333333333333333333333333333333333
#	pwd
#	echo ${S}***********************************************************************
#	echo ${WORKDIR}*****************************************************************
}

do_install() {
        install -d ${D}/opt
        install -d ${D}/opt/gtest_build
	mv ${S}/CMakeCache.txt ${D}/opt/gtest_build/
	mv ${S}/CMakeFiles ${D}/opt/gtest_build/
	mv ${S}/cmake_install.cmake ${D}/opt/gtest_build/
	mv ${S}/libgtest.a ${D}/opt/gtest_build/
	mv ${S}/libgtest_main.a ${D}/opt/gtest_build/
	mv ${S}/Makefile ${D}/opt/gtest_build/
#        install -d ${D}/opt/gtest_build/CMakeFiles
#        install -d ${D}/opt/gtest_build/CMakeFiles/CMakeTmp
#        install -d ${D}/opt/gtest_build/CMakeFiles/CompilerIdC
#        install -d ${D}/opt/gtest_build/CMakeFiles/CompilerIdCXX
#        install -d ${D}/opt/gtest_build/CMakeFiles/gtest.dir
#        install -d ${D}/opt/gtest_build/CMakeFiles/gtest_main.dir
#        install -d ${D}/opt/gtest_build/CMakeFiles/gtest.dir/src
#        install -d ${D}/opt/gtest_build/CMakeFiles/gtest_main.dir/src
#	install -D ${S}/*.* ${D}/opt/gtest_build/
#	install -D ${S}/Makefile ${D}/opt/gtest_build/
#	install -D ${S}/CMakeFiles/*.cmake ${D}/opt/gtest_build/CMakeFiles/
#	install -D ${S}/CMakeFiles/*.log ${D}/opt/gtest_build/CMakeFiles/
#	install -D ${S}/CMakeFiles/*.bin ${D}/opt/gtest_build/CMakeFiles/
#	install -D ${S}/CMakeFiles/*.txt ${D}/opt/gtest_build/CMakeFiles/
#	install -D ${S}/CMakeFiles/*.marks ${D}/opt/gtest_build/CMakeFiles/
#	install -D ${S}/CMakeFiles/Makefile2 ${D}/opt/gtest_build/CMakeFiles/
#	install -D ${S}/CMakeFiles/cmake.check_cache ${D}/opt/gtest_build/CMakeFiles/
}

FILES_${PN} = /opt/*
