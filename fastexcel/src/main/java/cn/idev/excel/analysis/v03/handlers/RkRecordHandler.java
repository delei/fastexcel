package cn.idev.excel.analysis.v03.handlers;

import cn.idev.excel.analysis.v03.IgnorableXlsRecordHandler;
import cn.idev.excel.context.xls.XlsReadContext;
import cn.idev.excel.metadata.data.ReadCellData;
import org.apache.poi.hssf.record.RKRecord;
import org.apache.poi.hssf.record.Record;

/**
 * Record handler
 */
public class RkRecordHandler extends AbstractXlsRecordHandler implements IgnorableXlsRecordHandler {

    @Override
    public void processRecord(XlsReadContext xlsReadContext, Record record) {
        RKRecord re = (RKRecord) record;
        xlsReadContext
                .xlsReadSheetHolder()
                .getCellMap()
                .put((int) re.getColumn(), ReadCellData.newEmptyInstance(re.getRow(), (int) re.getColumn()));
    }
}
