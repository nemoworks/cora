package cora.graph;

public enum IngressType {
    QUERY("查询", 1), MUTATION("修改", 2);

    private String name;
    private Integer index;

    IngressType(String name, Integer index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
