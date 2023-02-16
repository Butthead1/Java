package common;

import java.awt.*;
import java.awt.event.KeyEvent;

public class BaseElements {
    public static String Input(String name) {
        return "//*[@name='"+ name +"']["+ 1 +"]";
    }
    public static String Class(String name) {
        return "//*[@class='"+ name +"']";
    }
}

