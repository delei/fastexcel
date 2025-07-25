package cn.idev.excel.converters.biginteger;

import cn.idev.excel.converters.Converter;
import cn.idev.excel.enums.CellDataTypeEnum;
import cn.idev.excel.metadata.GlobalConfiguration;
import cn.idev.excel.metadata.data.ReadCellData;
import cn.idev.excel.metadata.data.WriteCellData;
import cn.idev.excel.metadata.property.ExcelContentProperty;
import cn.idev.excel.util.NumberUtils;
import java.math.BigInteger;

/**
 * BigInteger and number converter
 *
 *
 */
public class BigIntegerNumberConverter implements Converter<BigInteger> {

    @Override
    public Class<BigInteger> supportJavaTypeKey() {
        return BigInteger.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.NUMBER;
    }

    @Override
    public BigInteger convertToJavaData(
            ReadCellData<?> cellData, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) {
        return cellData.getNumberValue().toBigInteger();
    }

    @Override
    public WriteCellData<?> convertToExcelData(
            BigInteger value, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) {
        return NumberUtils.formatToCellData(value, contentProperty);
    }
}
