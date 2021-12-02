package cora.datafetcher;


public interface QueryFilterMapper<T> {
    T equalOperation(String key,Object value);

    T andOperation(T[] fields);

    T orOperation(T[] fields);

    T gtOperation(String key,Object value);

    T ltOperation(String key,Object value);

    T neqOperation(String key,Object value);
}
