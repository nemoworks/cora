package cora.groovy.impl;

import cora.datafetcher.custom.CustomCoraRepository;
import cora.groovy.GroovyScriptService;
import cora.groovy.GroovyScriptTemplate;
import cora.util.SHAUtil;
import cora.util.VelocityTemplate;
import graphql.com.google.common.collect.Maps;
import groovy.lang.GroovyClassLoader;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class CustomCoraRepoFactory implements GroovyScriptService {

    private final GroovyScriptTemplate groovyScriptTemplate;

    private final GroovyClassLoader groovyClassLoader;

    private final Map<String, Map<String,Class<CustomCoraRepository>>> customCoraRepositoryMap = Maps.newConcurrentMap();
    private final Map<String,String> nameAndMd5 = Maps.newHashMap();

    public CustomCoraRepoFactory(GroovyScriptTemplate groovyScriptTemplate, GroovyClassLoader groovyClassLoader) {
        this.groovyScriptTemplate = groovyScriptTemplate;
        this.groovyClassLoader = groovyClassLoader;
    }

    @Override
    public void parseAndCache(String nodeType, String apiName, String script) {
        String scriptBuilder = this.groovyScriptTemplate.getScript("ScriptTemplate.groovyTemplate");
        Map<String,String> map = new HashMap<>();
        String scriptClassName = apiName;
        map.put("className",scriptClassName);
        //这一部分String的获取逻辑进行可配置化
        map.put("customCode",script);
        String fullScript = VelocityTemplate.build(scriptBuilder, map);
        String oldMd5 = nameAndMd5.get(nodeType+apiName);
        String newMd5 = SHAUtil.getStringSHA256(fullScript);
        if (oldMd5 != null && oldMd5.equals(newMd5)) {
            return;
        }
        Class<CustomCoraRepository> aClass = this.groovyClassLoader.parseClass(fullScript);
        customCoraRepositoryMap.computeIfAbsent(nodeType, k -> new HashMap<>());
        customCoraRepositoryMap.get(nodeType).put(apiName,aClass);
        nameAndMd5.put(nodeType+apiName,newMd5);
    }

    @Override
    public CustomCoraRepository getInstance(String nodeType,String name) {
        Class<CustomCoraRepository> aClass = customCoraRepositoryMap.get(nodeType).get(name);
        if(aClass == null){
            throw new IllegalArgumentException("load NodeInstanceFetcher failed");
        }
        try {
            return aClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}
