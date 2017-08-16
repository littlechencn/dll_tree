package cn.littlechen.dlltree.model;

public class TWineDllFileContain {
    private Integer id;

    private String dllName;

    private String fClass;

    private String fPath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDllName() {
        return dllName;
    }

    public void setDllName(String dllName) {
        this.dllName = dllName == null ? null : dllName.trim();
    }

    public String getfClass() {
        return fClass;
    }

    public void setfClass(String fClass) {
        this.fClass = fClass == null ? null : fClass.trim();
    }

    public String getfPath() {
        return fPath;
    }

    public void setfPath(String fPath) {
        this.fPath = fPath == null ? null : fPath.trim();
    }
}