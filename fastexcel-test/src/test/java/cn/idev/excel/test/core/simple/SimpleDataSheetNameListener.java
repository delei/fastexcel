package cn.idev.excel.test.core.simple;

import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.event.AnalysisEventListener;
import com.alibaba.fastjson2.JSON;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class SimpleDataSheetNameListener extends AnalysisEventListener<SimpleData> {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleDataSheetNameListener.class);
    List<SimpleData> list = new ArrayList<SimpleData>();

    @Override
    public void invoke(SimpleData data, AnalysisContext context) {
        list.add(data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        Assertions.assertEquals(list.size(), 1);
        Assertions.assertEquals(list.get(0).getName(), "张三");
        LOGGER.debug("First row:{}", JSON.toJSONString(list.get(0)));
    }
}
