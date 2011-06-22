DESCRIPTION = "ALSA Utilities"
HOMEPAGE = "http://www.alsa-project.org"
BUGTRACKER = "https://bugtrack.alsa-project.org/alsa-bug/login_page.php"
SECTION = "console/utils"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=393a5ca445f6965873eca0259a17f833 \
                    file://alsactl/utils.c;beginline=1;endline=20;md5=fe9526b055e246b5558809a5ae25c0b9"
DEPENDS = "alsa-lib ncurses gettext alsa-scripts"
PR = "r0"

SRC_URI = "ftp://ftp.alsa-project.org/pub/utils/alsa-utils-${PV}.tar.bz2 \
           file://ncursesfix.patch;patch=1 "

SRC_URI[md5sum] = "cb0cf46029ac9549cf3a31bff6a4f4e1"
SRC_URI[sha256sum] = "b7d05e915e25f8540ad151c6dd558cf0fc1e9bb0ee23052d531c983666a1f7b0"

# lazy hack. needs proper fixing in gettext.m4, see
# http://bugs.openembedded.org/show_bug.cgi?id=2348
# please close bug and remove this comment when properly fixed
#
EXTRA_OECONF = "--disable-xmlto"
EXTRA_OECONF_linux-uclibc = "--disable-nls"
EXTRA_OECONF_linux-uclibcgnueabi = "--disable-nls"

inherit autotools
