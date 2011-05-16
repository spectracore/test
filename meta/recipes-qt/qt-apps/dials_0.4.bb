DESCRIPTION = "Sample Qt app"
LICENSE = "GPL"
SECTION = "Qt App"

PR = "r1"

DEPENDS = "qt4-embedded"

SRC_URI = "file://dials-0.4/dials-0.4.tar.bz2"
LIC_FILES_CHKSUM = "file://COPYING; md5=393a5ca445f6965873eca0259a17f833"


SRC_URI[md5sum] = "c181e899b37b8ef87351572da55a8237"
SRC_URI[sha256sum] = "f969b22887e1829e7f48f1b1267c5d2887cf990cdd27c2071aa0f2eef496f285"

inherit pkgconfig
#inherit qmake2 pkgconfig


do_configure_prepend() {

#export QMAKESPEC=${STAGING_DATADIR}/qtopia/mkspecs/${TARGET_OS}-oe-g++/qmake.conf
#export OE_QMAKE_INCDIR_QT=${STAGING_INCDIR}/qtopia
#${STAGING_BINDIR_NATIVE}/qmake2
export QMAKESPEC="${STAGING_DATADIR}/qtopia/mkspecs/${TARGET_OS}-oe-g++"
export OE_QMAKE_UIC="${STAGING_BINDIR_NATIVE}/uic4"
export OE_QMAKE_UIC3="${STAGING_BINDIR_NATIVE}/uic34"
export OE_QMAKE_MOC="${STAGING_BINDIR_NATIVE}/moc4"
export OE_QMAKE_RCC="${STAGING_BINDIR_NATIVE}/rcc4"
export OE_QMAKE_QDBUSCPP2XML="${STAGING_BINDIR_NATIVE}/qdbuscpp2xml4"
export OE_QMAKE_QDBUSXML2CPP="${STAGING_BINDIR_NATIVE}/qdbusxml2cpp4"
export OE_QMAKE_QMAKE="${STAGING_BINDIR_NATIVE}/qmake2"
export OE_QMAKE_LINK="${CXX}"
export OE_QMAKE_CXXFLAGS="${CXXFLAGS}"
export OE_QMAKE_INCDIR_QT="${STAGING_INCDIR}/qtopia"
export OE_QMAKE_LIBDIR_QT="${STAGING_LIBDIR}"
export OE_QMAKE_LIBS_QT="qt"
export OE_QMAKE_LIBS_X11="-lXext -lX11 -lm"
export OE_QMAKE_LIBS_X11SM="-lSM -lICE"
export OE_QMAKE_LRELEASE="${STAGING_BINDIR_NATIVE}/lrelease4"
export OE_QMAKE_LUPDATE="${STAGING_BINDIR_NATIVE}/lupdate4"
${STAGING_BINDIR_NATIVE}/qmake2
}

do_compile() {
export QMAKESPEC="${STAGING_DATADIR}/qtopia/mkspecs/${TARGET_OS}-oe-g++"
export OE_QMAKE_UIC="${STAGING_BINDIR_NATIVE}/uic4"
export OE_QMAKE_UIC3="${STAGING_BINDIR_NATIVE}/uic34"
export OE_QMAKE_MOC="${STAGING_BINDIR_NATIVE}/moc4"
export OE_QMAKE_RCC="${STAGING_BINDIR_NATIVE}/rcc4"
export OE_QMAKE_QDBUSCPP2XML="${STAGING_BINDIR_NATIVE}/qdbuscpp2xml4"
export OE_QMAKE_QDBUSXML2CPP="${STAGING_BINDIR_NATIVE}/qdbusxml2cpp4"
export OE_QMAKE_QMAKE="${STAGING_BINDIR_NATIVE}/qmake2"
export OE_QMAKE_LINK="${CXX}"
export OE_QMAKE_CXXFLAGS="${CXXFLAGS}"
export OE_QMAKE_INCDIR_QT="${STAGING_INCDIR}/qtopia"
export OE_QMAKE_LIBDIR_QT="${STAGING_LIBDIR}"
export OE_QMAKE_LIBS_QT="qt"
export OE_QMAKE_LIBS_X11="-lXext -lX11 -lm"
export OE_QMAKE_LIBS_X11SM="-lSM -lICE"
export OE_QMAKE_LRELEASE="${STAGING_BINDIR_NATIVE}/lrelease4"
export OE_QMAKE_LUPDATE="${STAGING_BINDIR_NATIVE}/lupdate4"
oe_runmake
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/${PN} ${D}${bindir}
}
