package com.amol.excelDemo.readdata;

import com.amol.excelDemo.sample.data.MachineProductData;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bhagwat Kolte
 */
public class ReadMachineProductData {

//    MachineProductData productData;
//    List<MachineProductData> productDataList;
//
//    public MachineProductData getProductData() {
//        return productData;
//    }
//
//    public void setProductData(MachineProductData productData) {
//        this.productData = productData;
//    }

//    public List<MachineProductData> getProductDataList() {
//        return productDataList;
//    }
//
//    public void setProductDataList(List<MachineProductData> productDataList) {
//        this.productDataList = productDataList;
//    }

    public List<MachineProductData> getMachineProductData() throws IOException {
    	List<MachineProductData> productDataList = new ArrayList<>();
        FileInputStream fis = new FileInputStream(new File("C:\\Not\\MachinePartData.xlsx"));
        int i = 0;
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet=wb.getSheetAt(0);
        for(Row row: sheet){
            if(i > 0){
            	MachineProductData productData = new MachineProductData();
                productData.setPartID((int) row.getCell(0).getNumericCellValue());
                productData.setMachineTraceID((long) row.getCell(1).getNumericCellValue());
                productData.setConfigMSRMTID((int) row.getCell(2).getNumericCellValue());
                productData.setSequenceNumber((int) row.getCell(3).getNumericCellValue());
                productData.setValue((int) row.getCell(4).getNumericCellValue());
                productData.setValueCount((int) row.getCell(5).getNumericCellValue());
                productData.setModifiedTime((String) row.getCell(6).getStringCellValue());
                productData.setChangeIndicator((String) row.getCell(7).getStringCellValue());
                productData.setMachineTraceID1((long) row.getCell(8).getNumericCellValue());
                productData.setMachineID((int) row.getCell(9).getNumericCellValue());
                productData.setDataSrcSysID((int) row.getCell(10).getNumericCellValue());
                productData.setTraceTypeID((int) row.getCell(11).getNumericCellValue());
                productData.setMachineLocationID((long) row.getCell(12).getNumericCellValue());
                productData.setStartTime((String) row.getCell(13).getStringCellValue());
                productData.setEndTime((String) row.getCell(14).getStringCellValue());
                productData.setStartEngineHours(row.getCell(15).getNumericCellValue());
                productData.setEndEngineHours(row.getCell(16).getNumericCellValue());
                productData.setStartLinearTime((long) row.getCell(17).getNumericCellValue());
                productData.setEndLinearTime((long) row.getCell(18).getNumericCellValue());
                productData.setMachineCoID((int) row.getCell(19).getNumericCellValue());
                productData.setModifiedTime1((String) row.getCell(20).getStringCellValue());
                productData.setModIndicator((String) row.getCell(21).getStringCellValue());
                productDataList.add(productData);
            }
            i++;
        }
        fis.close();
        return productDataList;
    }
}
