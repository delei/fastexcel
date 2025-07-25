package cn.idev.excel.converters.floatconverter;

import cn.idev.excel.converters.Converter;
import cn.idev.excel.converters.WriteConverterContext;
import cn.idev.excel.enums.CellDataTypeEnum;
import cn.idev.excel.metadata.GlobalConfiguration;
import cn.idev.excel.metadata.data.ReadCellData;
import cn.idev.excel.metadata.data.WriteCellData;
import cn.idev.excel.metadata.property.ExcelContentProperty;
import cn.idev.excel.util.NumberUtils;

/**
 * Float and number converter
 *
 *
 */
public class FloatNumberConverter implements Converter<Float> {

    @Override
    public Class<?> supportJavaTypeKey() {
        return Float.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.NUMBER;
    }

    @Override
    public Float convertToJavaData(
            ReadCellData<?> cellData, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) {
        return cellData.getNumberValue().floatValue();
    }

    @Override
    public WriteCellData<?> convertToExcelData(WriteConverterContext<Float> context) {
        return NumberUtils.formatToCellData(context.getValue(), context.getContentProperty());
    }
}
