package org.xiao.rain.test.thread.guardedsuspension;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/**
 * 容器
 * Author: xiaojl
 * Date: 2021/9/20 22:36
 */
public class MessageContainer {
    
    private static int id = 0;
    
    private static Map<Integer, GuardedObject> container = new Hashtable<>();
    
    private static synchronized int getId () {
        return id++;
    }
    
    public static GuardedObject createGuardObject() {
        int id = getId();
        GuardedObject guardedObject = new GuardedObject(id);
        container.put(id, guardedObject);
        return guardedObject;
    }
    
    public static GuardedObject getGuardById(int id) {
        return container.get(id);
    }
    
    public static Set<Integer> getIds() {
        return container.keySet();
    }
     
}
