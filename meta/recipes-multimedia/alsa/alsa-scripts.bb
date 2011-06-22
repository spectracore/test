DESCRIPTION = "ALSA initialisation scripts for BeagleBoard"
#SECTION = "console/utils"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"

PR = "r0"

SRC_URI = "file://alsa-scripts.tar.bz2"

S = ${WORKDIR}/alsa-scripts

SRC_URI[md5sum] = "7795d5dbe742f897b0df206e9ac6e161"
SRC_URI[sha256sum] = "ab41f661f1990f1cb3589fb43b4fefb83b333a485b7cd9d0c4ff289550a82d62"

inherit autotools

do_install() {
	install -d ${D}/usr
	install -d ${D}/usr/bin
	install -Dm755 ${S}/mods_snd alsa-init ${D}/${bindir}	
}
