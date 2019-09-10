package pl.wiktor.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Runner {


    public static void main(String[] args) throws Exception {

        Class cls = Class.forName("pl.wiktor.reflection.Tricky");

        Constructor con = cls.getDeclaredConstructor(String.class);

        con.setAccessible(true);

        Object obj = con.newInstance("JavaStart");

        Method method = cls.getDeclaredMethod("showText");

        method.invoke(obj);

    }


}
