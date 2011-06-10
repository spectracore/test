require recipes-core/images/poky-image-minimal.bb
IMAGE_INSTALL += "psplash tslib-calibrate dropbear laptop-mode-tools dials alsa-utils module-init-tools gtest omap3-sgx-modules libgles-omap3 dbus-glib"
LICENSE = "MIT"

# gstreamer gst-plugins-base gst-plugins-bad gst-plugins-good gst-ffmpeg gst-meta-base
