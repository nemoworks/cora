package cora.datafetcher;

public interface NodeInstanceDestroyer {
    DeleteResponse deleteNodeInstanceById(String id);
}
