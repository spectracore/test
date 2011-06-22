DESCRIPTION = "ALSA Plugins"
HOMEPAGE = "http://www.alsa-project.org"
BUGTRACKER = "https://bugtrack.alsa-project.org/alsa-bug/login_page.php"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=7fbc338309ac38fefcd64b04bb903e34"

DEPENDS = "pulseaudio"
PR = "r0"

SRC_URI = "ftp://alsa-project.org/pub/plugins/${PN}-${PV}.tar.bz2"

SRC_URI[md5sum] = "a671f8102366c5b388133e948e1c85cb"
SRC_URI[sha256sum] = "5c1b2791ad33ef01f0f4f040004c931310da05e45aaa8d4146024c586f2b3183"


EXTRA_OECONF = "--disable-jack"

inherit autotools

PACKAGES = ${PN}

FILES_${PN} = "${libdir}/alsa-lib/lib*"
