package cora.datafetcher.mongodb;

import cora.datafetcher.QueryFilterMapper;
import org.springframework.data.mongodb.core.query.Criteria;


public class MongodbQueryFilterMapper implements QueryFilterMapper<Criteria> {
    @Override
    public Criteria equalOperation(String key, Object value) {
        Criteria.where(key).gt(value);
        return Criteria.where(key).is(value);
    }

    @Override
    public Criteria andOperation(Criteria[] fields) {
        return new Criteria().andOperator(fields);
    }

    @Override
    public Criteria orOperation(Criteria[] fields) {
        return new Criteria().orOperator(fields);
    }

    @Override
    public Criteria gtOperation(String key, Object value) {
        return Criteria.where(key).gt(value);
    }

    @Override
    public Criteria ltOperation(String key, Object value) {
        return Criteria.where(key).lt(value);
    }

    @Override
    public Criteria neqOperation(String key, Object value) {
        return Criteria.where(key).ne(value);
    }


}
