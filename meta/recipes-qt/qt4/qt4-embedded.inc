DESCRIPTION = "Qt is a versatile cross-platform application framework -- this is the embedded version."
SECTION = "libs"
LICENSE = "LGPLv2.1 | GPLv3"
PRIORITY = "optional"
HOMEPAGE = "http://qt.nokia.com"
DEPENDS += "directfb"
RDEPENDS += "tslib openssl"
INC_PR = "r26"

QT_BASE_NAME ?= "qt4-embedded"
QT_BASE_LIB  ?= "libqt-embedded"

# Set necessary variables in the profile
SRC_URI += "file://qte.sh"

QT_CONFIG_FLAGS += " \
    -embedded ${QT_ARCH} \
    -plugin-gfx-transformed -plugin-gfx-qvfb -plugin-gfx-vnc -plugin-gfx-directfb \
    -plugin-mouse-tslib -qt-mouse-pc -qt-mouse-qvfb -qt-mouse-linuxinput -qt-mouse-tslib \
    -qt-kbd-tty -qt-kbd-linuxinput -openssl \
    -DQT_KEYPAD_NAVIGATION \
    "

require qt4.inc

do_install_append() {
    install -d ${D}${sysconfdir}/profile.d/
    install -m 0755 ${WORKDIR}/qte.sh ${D}${sysconfdir}/profile.d/
}

FILES_${PN} += " ${sysconfdir}/profile.d/qte.sh"

inherit qt4e

