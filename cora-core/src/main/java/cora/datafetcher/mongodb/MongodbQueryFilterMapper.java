package cora.datafetcher.mongodb;

import cora.datafetcher.QueryFilterMapper;
import org.springframework.data.mongodb.core.query.Criteria;


public class MongodbQueryFilterMapper implements QueryFilterMapper<Criteria> {
    @Override
    public Criteria equalOperation(String key, Object value) {
        return Criteria.where(key).is(value);
    }

    @Override
    public Criteria andOperation(Criteria[] fields) {
        return new Criteria().andOperator(fields);
    }
}
