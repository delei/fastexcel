package cn.idev.excel.test.core.parameter;

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
public class ParameterDataListener extends AnalysisEventListener<ParameterData> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ParameterDataListener.class);
    List<ParameterData> list = new ArrayList<ParameterData>();

    @Override
    public void invoke(ParameterData data, AnalysisContext context) {
        list.add(data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        Assertions.assertEquals(list.size(), 10);
        Assertions.assertEquals(list.get(0).getName(), "姓名0");
        Assertions.assertEquals((int) (context.readSheetHolder().getSheetNo()), 0);
        Assertions.assertEquals(
                context.readSheetHolder()
                        .getExcelReadHeadProperty()
                        .getHeadMap()
                        .get(0)
                        .getHeadNameList()
                        .get(0),
                "姓名");
        LOGGER.debug("First row:{}", JSON.toJSONString(list.get(0)));
    }
}
