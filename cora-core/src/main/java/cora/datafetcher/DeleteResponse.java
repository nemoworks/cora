package cora.datafetcher;

public class DeleteResponse {
    public enum ResultType{
        succeed,failed
    }
    private ResultType resultType;
    private String comments;

    public DeleteResponse(ResultType resultType, String comments) {
        this.resultType = resultType;
        this.comments = comments;
    }

    public ResultType getResultType() {
        return resultType;
    }

    public void setResultType(ResultType resultType) {
        this.resultType = resultType;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
