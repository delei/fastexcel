package cn.idev.excel.cache;

import cn.idev.excel.context.AnalysisContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Putting temporary data directly into a map is a little more efficient but very memory intensive
 *
 *
 */
public class MapCache implements ReadCache {
    private final List<String> cache = new ArrayList<>();

    @Override
    public void init(AnalysisContext analysisContext) {}

    @Override
    public void put(String value) {
        cache.add(value);
    }

    @Override
    public String get(Integer key) {
        if (key == null || key < 0) {
            return null;
        }
        return cache.get(key);
    }

    @Override
    public void putFinished() {}

    @Override
    public void destroy() {}
}
