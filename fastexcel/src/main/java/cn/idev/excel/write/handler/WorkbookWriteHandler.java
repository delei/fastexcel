package cn.idev.excel.write.handler;

import cn.idev.excel.write.handler.context.WorkbookWriteHandlerContext;
import cn.idev.excel.write.metadata.holder.WriteWorkbookHolder;

/**
 * intercepts handle Workbook creation
 *
 *
 */
public interface WorkbookWriteHandler extends WriteHandler {

    /**
     * Called before create the workbook
     *
     * @param context
     */
    default void beforeWorkbookCreate(WorkbookWriteHandlerContext context) {
        beforeWorkbookCreate();
    }

    /**
     * Called before create the workbook
     */
    default void beforeWorkbookCreate() {}

    /**
     * Called after the workbook is created
     *
     * @param context
     */
    default void afterWorkbookCreate(WorkbookWriteHandlerContext context) {
        afterWorkbookCreate(context.getWriteWorkbookHolder());
    }

    /**
     * Called after the workbook is created
     *
     * @param writeWorkbookHolder
     */
    default void afterWorkbookCreate(WriteWorkbookHolder writeWorkbookHolder) {}

    /**
     * Called after all operations on the workbook have been completed
     *
     * @param context
     */
    default void afterWorkbookDispose(WorkbookWriteHandlerContext context) {
        afterWorkbookDispose(context.getWriteWorkbookHolder());
    }

    /**
     * Called after all operations on the workbook have been completed
     *
     * @param writeWorkbookHolder
     */
    default void afterWorkbookDispose(WriteWorkbookHolder writeWorkbookHolder) {}
}
