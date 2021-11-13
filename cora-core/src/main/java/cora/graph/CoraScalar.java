package cora.graph;

import java.util.Arrays;
import java.util.List;

public class CoraScalar {
    public static List<String> getScalars() {
        return scalars;
    }

    private static final List<String> scalars = Arrays.asList("String", "Int", "Boolean", "Float");
}