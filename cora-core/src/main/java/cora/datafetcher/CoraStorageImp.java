package cora.datafetcher;

import com.alibaba.fastjson.JSONObject;
import cora.graph.CoraGraph;
import cora.graph.CoraNode;
import cora.graph.coraCache.CacheKey;
import cora.graph.coraCache.JsonArrayCacheElement;
import cora.graph.coraCache.JsonCacheElement;
import cora.parser.JsonAST;
import graphql.execution.ExecutionStepInfo;
import graphql.execution.ResultPath;
import graphql.language.Document;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class CoraStorageImp implements CoraStorage<JSONObject> {

    private final CoraRepository<JSONObject> coraRepository;

    public CoraStorageImp(CoraRepository coraRepository) {
        this.coraRepository = coraRepository;
    }

    @Override
    public DataFetcher<JSONObject> getFetcher() {
        return dataFetcherEnvironment -> {
            ExecutionStepInfo executionStepInfo = dataFetcherEnvironment.getExecutionStepInfo();
            //build cacheKey
            CacheKey cacheKey = new CacheKey.Builder(executionStepInfo).build();
            //get coraNode Type
            String nodeType = ((GraphQLObjectType)dataFetcherEnvironment.getFieldType()).getName();
            //get data from cache by cacheKey
            if(CoraGraph.getCoraNode(nodeType).getCache().getIfPresent(cacheKey)!=null){
                return ((JsonCacheElement) CoraGraph.getCoraNode(nodeType).getCache().getIfPresent(cacheKey)).getElement();
            }
            if(dataFetcherEnvironment.getSource()!=null){
                String name = dataFetcherEnvironment.getFieldDefinition().getName();
                JSONObject source = dataFetcherEnvironment.getSource();
                ArrayList<String> ids = source.getObject(name, ArrayList.class);
                JSONObject jsonObject = coraRepository.queryNodeInstanceById(ids.get(0), null);
                //load data to cache
                CoraGraph.getCoraNode(nodeType).getCache().put(cacheKey,new JsonCacheElement(jsonObject));
                return jsonObject;
            }
            String id = dataFetcherEnvironment.getArgument("_id");
            JSONObject jsonObject = coraRepository.queryNodeInstanceById(id, null);
            CoraGraph.getCoraNode(nodeType).getCache().put(cacheKey,new JsonCacheElement(jsonObject));
            return jsonObject;
        };
    }

    @Override
    public DataFetcher<List<JSONObject>> getListFetcher() {
        return dataFetcherEnvironment -> {
            ExecutionStepInfo executionStepInfo = dataFetcherEnvironment.getExecutionStepInfo();
            //get cacheKey
            CacheKey cacheKey = new CacheKey.Builder(executionStepInfo).build();
            String nodeType = ((GraphQLObjectType) ((GraphQLList) dataFetcherEnvironment.getFieldType()).getWrappedType()).getName();
            if(CoraGraph.getCoraNode(nodeType).getCache().getIfPresent(cacheKey)!=null){
                return ((JsonArrayCacheElement) CoraGraph.getCoraNode(nodeType).getCache().getIfPresent(cacheKey)).getElement();
            }
            if(dataFetcherEnvironment.getArgument("where") != null){
                JSONObject filterContents = new JSONObject(dataFetcherEnvironment.getArgument("where"));
                List<JSONObject> jsonObjects = coraRepository.queryNodeInstanceList(nodeType, filterContents);
                CoraGraph.getCoraNode(nodeType).getCache().put(cacheKey,new JsonArrayCacheElement(jsonObjects));
                return jsonObjects;
            }
            if (dataFetcherEnvironment.getSource() != null) {
                String name = dataFetcherEnvironment.getFieldDefinition().getName();
                JSONObject source = dataFetcherEnvironment.getSource();
                ArrayList<String> ids = source.getObject(name, ArrayList.class);
                List<JSONObject> jsonObjects = coraRepository.queryNodeInstanceList(ids);
                CoraGraph.getCoraNode(nodeType).getCache().put(cacheKey,new JsonArrayCacheElement(jsonObjects));
                return jsonObjects;
            }
            List<JSONObject> jsonObjects = coraRepository.queryNodeInstanceList(nodeType);
            CoraGraph.getCoraNode(nodeType).getCache().put(cacheKey,new JsonArrayCacheElement(jsonObjects));
            return jsonObjects;
        };
    }

    @Override
    public DataFetcher<JSONObject> getCreator() {
        return dataFetcherEnvironment -> {
            JSONObject content = new JSONObject(dataFetcherEnvironment.getArgument("data"));
            String nodeType = ((GraphQLObjectType) dataFetcherEnvironment.getFieldType()).getName();
            this.removeCache(nodeType);
            return coraRepository.createNodeInstance(nodeType, content);
        };
    }

    public void removeCache(String nodeType){
        CoraGraph.getCoraNode(nodeType).getCache().invalidateAll();
        if(CoraGraph.getCoraNode(nodeType).getChildren().isEmpty())
            return;
        CoraGraph.getCoraNode(nodeType).getChildren().forEach(child->{
                this.removeCache(child);
        });
    }

    @Override
    public DataFetcher<JSONObject> getRemover() {
        return null;
    }
}
