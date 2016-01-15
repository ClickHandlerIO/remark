package remark.client.controls;

import elemental.dom.Element;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;

@JsType(isNative = true)
public class Ladda {

    @JsMethod(namespace = "Ladda")
    public native static Ladda create(Element element);

    public native void start();

    public native void stop();

    public native void toggle();

    public native void isLoading();

    public native void setProgress(double progress);
}
