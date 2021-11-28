package cora.datafetcher;


public interface QueryFilterMapper<T> {
    T equalOperation(String key,Object value);

    T andOperation(T[] fields);
}
