#!/bin/sh

if [ -e /dev/input/event0 ]
then
    QWS_MOUSE_PROTO=LinuxXyz:/dev/input/event0
    export QWS_MOUSE_PROTO
fi

export QWS_DISPLAY=powervr
