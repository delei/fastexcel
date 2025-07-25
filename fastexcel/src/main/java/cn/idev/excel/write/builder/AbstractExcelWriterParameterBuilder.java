package cn.idev.excel.write.builder;

import cn.idev.excel.metadata.AbstractParameterBuilder;
import cn.idev.excel.write.handler.WriteHandler;
import cn.idev.excel.write.metadata.WriteBasicParameter;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Build ExcelBuilder
 *
 *
 */
public abstract class AbstractExcelWriterParameterBuilder<
                T extends AbstractExcelWriterParameterBuilder, C extends WriteBasicParameter>
        extends AbstractParameterBuilder<T, C> {
    /**
     * Writes the head relative to the existing contents of the sheet. Indexes are zero-based.
     *
     * @param relativeHeadRowIndex
     * @return
     */
    public T relativeHeadRowIndex(Integer relativeHeadRowIndex) {
        parameter().setRelativeHeadRowIndex(relativeHeadRowIndex);
        return self();
    }

    /**
     * Need Head
     */
    public T needHead(Boolean needHead) {
        parameter().setNeedHead(needHead);
        return self();
    }

    /**
     * Custom write handler
     *
     * @param writeHandler
     * @return
     */
    public T registerWriteHandler(WriteHandler writeHandler) {
        if (parameter().getCustomWriteHandlerList() == null) {
            parameter().setCustomWriteHandlerList(new ArrayList<WriteHandler>());
        }
        parameter().getCustomWriteHandlerList().add(writeHandler);
        return self();
    }

    /**
     * Use the default style.Default is true.
     *
     * @param useDefaultStyle
     * @return
     */
    public T useDefaultStyle(Boolean useDefaultStyle) {
        parameter().setUseDefaultStyle(useDefaultStyle);
        return self();
    }

    /**
     * Whether to automatically merge headers.Default is true.
     *
     * @param automaticMergeHead
     * @return
     */
    public T automaticMergeHead(Boolean automaticMergeHead) {
        parameter().setAutomaticMergeHead(automaticMergeHead);
        return self();
    }

    /**
     * Ignore the custom columns.
     */
    public T excludeColumnIndexes(Collection<Integer> excludeColumnIndexes) {
        parameter().setExcludeColumnIndexes(excludeColumnIndexes);
        return self();
    }

    /**
     * Ignore the custom columns.
     *
     * @deprecated use {@link #excludeColumnFieldNames(Collection)}
     */
    public T excludeColumnFiledNames(Collection<String> excludeColumnFieldNames) {
        parameter().setExcludeColumnFieldNames(excludeColumnFieldNames);
        return self();
    }

    /**
     * Ignore the custom columns.
     */
    public T excludeColumnFieldNames(Collection<String> excludeColumnFieldNames) {
        parameter().setExcludeColumnFieldNames(excludeColumnFieldNames);
        return self();
    }

    /**
     * Only output the custom columns.
     */
    public T includeColumnIndexes(Collection<Integer> includeColumnIndexes) {
        parameter().setIncludeColumnIndexes(includeColumnIndexes);
        return self();
    }

    /**
     * Only output the custom columns.
     *
     * @deprecated use {@link  #includeColumnFieldNames(Collection)} spelling mistake
     */
    @Deprecated
    public T includeColumnFiledNames(Collection<String> includeColumnFieldNames) {
        parameter().setIncludeColumnFieldNames(includeColumnFieldNames);
        return self();
    }

    /**
     * Only output the custom columns.
     */
    public T includeColumnFieldNames(Collection<String> includeColumnFieldNames) {
        parameter().setIncludeColumnFieldNames(includeColumnFieldNames);
        return self();
    }

    /**
     * Data will be order by  {@link #includeColumnFieldNames} or  {@link #includeColumnIndexes}.
     *
     * default is false.
     *
     * @since 3.3.0
     **/
    public T orderByIncludeColumn(Boolean orderByIncludeColumn) {
        parameter().setOrderByIncludeColumn(orderByIncludeColumn);
        return self();
    }
}
