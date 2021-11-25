package cora.graph;

public class CustomIngress {
    private String nodeType;
    private String apiName;
    private String codeImpl;

    public CustomIngress(String nodeType, String apiName, String codeImpl) {
        this.nodeType = nodeType;
        this.apiName = apiName;
        this.codeImpl = codeImpl;
    }

    public CustomIngress() {
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getCodeImpl() {
        return codeImpl;
    }

    public void setCodeImpl(String codeImpl) {
        this.codeImpl = codeImpl;
    }
}
