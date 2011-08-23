DESCRIPTION = "Sample Qt app"
LICENSE = "GPL"
SECTION = "Qt App"

PR = "r1"

DEPENDS = "qt4-embedded"

SRC_URI = "file://linuxxyz-1.0/linuxxyz-1.0.tar.bz2"

#LIC_FILES_CHKSUM = "file://linuxxyz-1.0/COPYING;md5=302d3a119c442de984cd703c3a986d7d"

PACKAGES = "${PN}"

SRC_URI[md5sum] = "c4dcaae89c7ad834710a74910b120e61"
SRC_URI[sha256sum] = "a91bd687d99c045af1f87f598d624d2bdf336ac6dad16c001b33f9b9bfa70a53"

#inherit pkgconfig
inherit qt4e pkgconfig

do_install() {
	install -d ${D}${libdir}/qtopia/plugins/mousedrivers
	install -D ${S}/libqlinuxxyzmousedriver.so  ${D}${libdir}/qtopia/plugins/mousedrivers
}

FILES_${PN} = "/usr/lib/qtopia/plugins/mousedrivers/libqlinuxxyzmousedriver.so"
 
