DESCRIPTION = "ALSA Configuration for PulseAudio."
HOMEPAGE = "http://www.pulseaudio.org"
LICENSE = "GPL"

LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"

DEPENDS = "alsa-plugins pulseaudio"

SRC_URI = "file://pulseaudio-alsa.tar.bz2"

SRC_URI[md5sum] = "0e42464fd937eb047ecdbdb07bba59fe"
SRC_URI[sha256sum] = "bd0909176c65a244b31d8cf25c88e607e80bbf50fcb9d9d77af99fb59a796cbf"

S = ${WORKDIR}/pulseaudio-alsa

do_install() {
	install -d ${D}/${sysconfdir}
	install -D ${S}/asound.conf ${D}/${sysconfdir}/
}

#PACKAGES += ${PN}

#FILES_${PN} += "${syscobfdir}/*"
