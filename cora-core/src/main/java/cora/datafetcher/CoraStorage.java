package cora.datafetcher;

import graphql.schema.DataFetcher;

import java.util.List;

public interface CoraStorage<T> {
    DataFetcher<T> getFetcher();
    DataFetcher<List<T>> getListFetcher();
    DataFetcher<T> getCreator();
    DataFetcher<T> getRemover();
}
