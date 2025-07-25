package cn.idev.excel.read.listener;

import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.event.Listener;
import cn.idev.excel.metadata.CellExtra;
import cn.idev.excel.metadata.data.ReadCellData;
import cn.idev.excel.read.metadata.holder.ReadRowHolder;
import java.util.Map;

/**
 * Interface to listen for read results
 *
 *
 */
public interface ReadListener<T> extends Listener {
    /**
     * All listeners receive this method when any one Listener does an error report. If an exception is thrown here, the
     * entire read will terminate.
     *
     * @param exception
     * @param context
     * @throws Exception
     */
    default void onException(Exception exception, AnalysisContext context) throws Exception {
        throw exception;
    }

    /**
     * When analysis one head row trigger invoke function.
     *
     * @param headMap
     * @param context
     */
    default void invokeHead(Map<Integer, ReadCellData<?>> headMap, AnalysisContext context) {}

    /**
     * When analysis one row trigger invoke function.
     *
     * @param data    one row value. It is same as {@link AnalysisContext#readRowHolder()}
     * @param context analysis context
     */
    void invoke(T data, AnalysisContext context);

    /**
     * The current method is called when extra information is returned
     *
     * @param extra   extra information
     * @param context analysis context
     */
    default void extra(CellExtra extra, AnalysisContext context) {}

    /**
     * if have something to do after all analysis
     *
     * @param context
     */
    void doAfterAllAnalysed(AnalysisContext context);

    /**
     * Verify that there is another piece of data.You can stop the read by returning false
     *
     * @param context
     * @return
     */
    default boolean hasNext(AnalysisContext context) {
        if (context == null
                || context.readRowHolder() == null
                || context.readSheetHolder() == null
                || context.readSheetHolder().getReadSheet() == null
                || context.readWorkbookHolder().getReadWorkbook() == null) {
            return true;
        }
        ReadRowHolder readRowHolder = context.readRowHolder();
        int index = readRowHolder.getRowIndex();

        Integer limit = context.readSheetHolder().getReadSheet().getNumRows();
        if (limit == null) {
            limit = context.readWorkbookHolder().getReadWorkbook().getNumRows();
        }
        if (limit != null && index >= limit) {
            return false;
        }
        return true;
    }
}
