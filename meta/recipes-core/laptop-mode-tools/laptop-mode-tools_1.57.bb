
DESCRIPTION = "Laptop mode is a kernel mode that allows you to extend the battery life of your laptop."

PR = "r0"

LICENSE = "GPL"
LIC_FILES_CHKSUM = "file://COPYING; md5=393a5ca445f6965873eca0259a17f833" 

SRC_URI ="http://samwel.tk/laptop_mode/tools/downloads/laptop-mode-tools_1.57.tar.gz"

SRC_URI[md5sum] = "1d9e4f4e3ff3f16d298e1653483f3f58"
SRC_URI[sha256sum] = "fbc73ef74bad3303ef88796e7dc9097557f190ffd7f3b61ac4b19ff59fa3f6da"

S=${WORKDIR}/laptop-mode-tools_1.57

DEPENDS = "bash hdparm"
inherit autotools pkgconfig







