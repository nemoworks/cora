package cora.graph.coraCache;

import cora.util.SHAUtil;
import graphql.execution.ExecutionStepInfo;
import graphql.execution.ResultPath;
import org.apache.commons.lang.StringUtils;

import java.util.Map;
import java.util.Objects;

public class CacheKey {
    private ResultPath resultPath;
    private String key;

    public CacheKey(ResultPath resultPath, String key) {
        this.resultPath = resultPath;
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CacheKey cacheKey = (CacheKey) o;
        return StringUtils.equals(key, cacheKey.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultPath, key);
    }

    public static final class Builder{
        private ResultPath resultPath;
        private StringBuilder keyBuilder;
        public Builder(ExecutionStepInfo executionStepInfo){
            resultPath = executionStepInfo.getPath();
            keyBuilder = new StringBuilder();
            while(executionStepInfo.hasParent()){
                Map<String, Object> arguments = executionStepInfo.getArguments();
                String s = executionStepInfo.getPath().toString();
                String substring = s.substring(s.lastIndexOf("/"));
                keyBuilder.append(substring).append("(");
                arguments.keySet().forEach(key->{
                    keyBuilder.append(key).append(":").append(arguments.get(key)).append(",");
                });
                if(arguments.size()>0){
                    keyBuilder.deleteCharAt(keyBuilder.lastIndexOf(","));
                }
                keyBuilder.append(")");
                executionStepInfo = executionStepInfo.getParent();
            }
        }

        public CacheKey build(){
            String sha256 = SHAUtil.getStringSHA256(keyBuilder.toString());
            return new CacheKey(resultPath,sha256.substring(0,8));
        }
    }
}
