DESCRIPTION = "Lib GLES libraries for the PowerVR SGX chipset found in the omap3 SoCs"
LICENSE = ""

# download required binary distribution from:
# http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/gfxsdk/latest/index_FDS.html
# see libgles-omap3.inc for detailed installation instructions

TI_BIN_UNPK_CMDS="Y: qY:workdir:Y"
require ti-eula-unpack.inc
#require ../ti/ti-eula-unpack.inc

SGXPV = "4_00_00_01"
IMGPV = "1.4.14.2616"
BINFILE := "Graphics_SDK_setuplinux_${SGXPV}.bin"

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/gfxsdk/${SGXPV}/exports/Graphics_SDK_setuplinux_${SGXPV}.bin"

SRC_URI[md5sum] = "a027002dcd7164df467b1a315788d5fd"
SRC_URI[sha256sum] = "62383d15e33adf9349afba063b0f2405a15aa6c4b0b5579b0abdf81db7580df7"

S = "${WORKDIR}/Graphics_SDK_${SGXPV}"
do_compile() {
}

do_install() {
        mkdir -p ${D}/usr/lib
        mkdir -p ${D}/usr/bin
        mkdir -p ${D}/usr/include
        mkdir -p ${D}/etc/init.d
        mkdir -p ${D}/etc/rcS.d

        cp ${S}/gfx_rel_es6.x/*.so ${D}/usr/lib
        cp ${S}/gfx_rel_es6.x/*.a ${D}/usr/lib
        cp ${S}/gfx_rel_es6.x/*.h ${D}/usr/include
	cp -r ${S}/GFX_Linux_SDK/OGLES/SDKPackage/Builds/OGLES/Include/* ${D}/usr/include/
	cp -r ${S}/GFX_Linux_SDK/OVG/SDKPackage/Builds/OVG/Include/* ${D}/usr/include/
        cp ${S}/gfx_rel_es6.x/eglinfo \
           ${S}/gfx_rel_es6.x/gl2info \
           ${S}/gfx_rel_es6.x/gles1test1 \
           ${S}/gfx_rel_es6.x/gles1_texture_stream \
           ${S}/gfx_rel_es6.x/gles2test1 \
           ${S}/gfx_rel_es6.x/gles2_texture_stream \
           ${S}/gfx_rel_es6.x/ovg_unit_test \
           ${S}/gfx_rel_es6.x/pdsasm \
           ${S}/gfx_rel_es6.x/pdump \
           ${S}/gfx_rel_es6.x/pvr2d_test \
           ${S}/gfx_rel_es6.x/pvrsrvinit \
           ${S}/gfx_rel_es6.x/services_test \
           ${S}/gfx_rel_es6.x/sgx_blit_test \
           ${S}/gfx_rel_es6.x/sgx_flip_test \
           ${S}/gfx_rel_es6.x/sgx_init_test \
           ${S}/gfx_rel_es6.x/sgx_render_flip_test \
           ${S}/gfx_rel_es6.x/xgles1test1 \
           ${S}/gfx_rel_es6.x/xmultiegltest \
           ${D}/usr/bin
        cp ${S}/gfx_rel_es6.x/rc.pvr ${D}/etc/init.d

        ln -s /etc/init.d/rc.pvr ${D}/etc/rcS.d/S56rc.pvr
}

FILES_${PN} = "/usr/* /etc/* "
