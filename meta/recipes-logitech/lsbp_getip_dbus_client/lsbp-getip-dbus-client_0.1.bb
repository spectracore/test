DESCRIPTION = "DBUS client program to get the IP of Black"
SECTION = "demo"
LICENSE = "GPL"
PR = "r0"
DEPENDS += "libx11-trim libxtst libxext dbus-glib"
SRC_URI = "file://lsbp_getip_dbus_client.tar.bz2"

LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833"
 
S = "${WORKDIR}/lsbp_getip_dbus_client"
 
inherit autotools pkgconfig
 
do_compile() {
          ${CC} lsbp_getip_client.c -o lsbp_getip_client -pthread -I${STAGING_LIBDIR_NATIVE}/dbus-1.0/include -I${STAGING_INCDIR_NATIVE}/dbus-1.0 -ldbus-1 -lpthread -lrt -lX11 -lXtst -lXext    
 
}
 
do_install() {
          install -d ${D}${bindir}
          install -m 0755 lsbp_getip_client ${D}${bindir}
}

