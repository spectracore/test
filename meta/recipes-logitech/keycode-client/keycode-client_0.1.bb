DESCRIPTION = "Keycode Client App"
SECTION = "demo"
LICENSE = "GPL"
PR = "r0"
DEPENDS += "libx11-trim libxtst libxext"

SRC_URI = "file://keycode-client.tar.bz2"

LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"

S = "${WORKDIR}/keycode-client"

inherit autotools pkgconfig

do_compile() {
	${CC} keycode_client.c -o keycode_client -lX11 -lXtst -lXext
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 keycode_client ${D}${bindir}
}


