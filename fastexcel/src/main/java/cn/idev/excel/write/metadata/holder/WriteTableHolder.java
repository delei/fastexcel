package cn.idev.excel.write.metadata.holder;

import cn.idev.excel.enums.HolderEnum;
import cn.idev.excel.write.metadata.WriteTable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * sheet holder
 *
 *
 */
@Getter
@Setter
@EqualsAndHashCode
public class WriteTableHolder extends AbstractWriteHolder {
    /***
     * poi sheet
     */
    private WriteSheetHolder parentWriteSheetHolder;
    /***
     * tableNo
     */
    private Integer tableNo;
    /**
     * current table param
     */
    private WriteTable writeTable;

    public WriteTableHolder(WriteTable writeTable, WriteSheetHolder writeSheetHolder) {
        super(writeTable, writeSheetHolder);
        this.parentWriteSheetHolder = writeSheetHolder;
        this.tableNo = writeTable.getTableNo();
        this.writeTable = writeTable;

        // init handler
        initHandler(writeTable, writeSheetHolder);
    }

    @Override
    public HolderEnum holderType() {
        return HolderEnum.TABLE;
    }
}
