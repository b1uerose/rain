package org.xiao.rain.test.spring.ioc.di.collaborators;

/**
 * Author: xiaojl
 * Date:2022-04-24 00:13
 */
public class Collaborators {
    
}

class CollaboratorsParent {
    String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CollaboratorsParent{" +
                "name='" + name + '\'' +
                '}';
    }
}

class CollaboratorsChild {
    
    private CollaboratorsParent parent;
    
    String name;

    public void setParent(CollaboratorsParent parent) {
        this.parent = parent;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CollaboratorsChild{" +
                "parent=" + parent +
                ", name='" + name + '\'' +
                '}';
    }
}
