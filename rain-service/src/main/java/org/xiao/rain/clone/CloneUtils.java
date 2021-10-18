package org.xiao.rain.clone;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Author: xiaojl
 * Date: 2021/8/23 23:16
 */
public class CloneUtils {

    /**
     * 深度克隆方法。参数对象必须实现序列化!
     * Utility for making deep copies (vs. clone()'s shallow copies) of objects.
     * Objects are first serialized and then deserialized. Error checking is
     * fairly minimal in this implementation. If an object is encountered that
     * cannot be serialized (or that references an object that cannot be
     * serialized) an error is printed to System.err and null is returned.
     * Depending on your specific application, it might make more sense to have
     * copy(...) re-throw the exception.
     *
     * @return a copy of the object, or null if the object cannot be serialized.
     */
    public static Object Deepcopy(Object orig) throws Exception {
        // Write the object out to a byte array
        FastByteArrayOutputStream fbos = new FastByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(fbos);
        out.writeObject(orig);
        out.flush();
        out.close();

        // Retrieve an input stream from the byte array and read
        // a copy of the object back in.
        ObjectInputStream in = new ObjectInputStream(fbos.getInputStream());
        Object obj = in.readObject();
        return obj;
    }
}
