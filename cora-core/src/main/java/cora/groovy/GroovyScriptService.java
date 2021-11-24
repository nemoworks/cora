package cora.groovy;

import cora.datafetcher.custom.CustomCoraRepository;

public interface GroovyScriptService {
    public void parseAndCache(String nodeType,String apiName,String script);

    public CustomCoraRepository getInstance(String nodeType, String name);
}
