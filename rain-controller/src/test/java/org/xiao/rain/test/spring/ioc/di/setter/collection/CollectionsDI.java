package org.xiao.rain.test.spring.ioc.di.setter.collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Author: xiaojl
 * Date:2022-04-24 08:18
 */
public class CollectionsDI {
    
    private Properties properties;
    private List list;
    private Map map;
    private Set set;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setList(List list) {
        this.list = list;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public Properties getProperties() {
        return properties;
    }

    public List getList() {
        return list;
    }

    public Map getMap() {
        return map;
    }

    public Set getSet() {
        return set;
    }
}

