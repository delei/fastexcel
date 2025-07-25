package cn.idev.excel.write.handler;

import cn.idev.excel.write.metadata.holder.WriteSheetHolder;
import cn.idev.excel.write.metadata.holder.WriteWorkbookHolder;

/**
 * Abstract sheet write handler
 *
 *
 * @deprecated Please use it directly {@link SheetWriteHandler}
 **/
@Deprecated
public abstract class AbstractSheetWriteHandler implements SheetWriteHandler {
    @Override
    public void beforeSheetCreate(WriteWorkbookHolder writeWorkbookHolder, WriteSheetHolder writeSheetHolder) {}

    @Override
    public void afterSheetCreate(WriteWorkbookHolder writeWorkbookHolder, WriteSheetHolder writeSheetHolder) {}
}
