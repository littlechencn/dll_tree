package cn.littlechen.dlltree.model;

/**
 * Created by lenovo on 2017/8/16.
 */
public class DllTree {

    private String name;
    private  Object children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getChildren() {
        return children;
    }

    public void setChildren(Object children) {
        this.children = children;
    }
}
