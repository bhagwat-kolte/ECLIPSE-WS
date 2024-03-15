package com.amol.excelDemo.readdata;

import com.amol.excelDemo.sample.data.Employee;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
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
public class ReadEmployeeData {

    public List<Employee> getEmployeeData() throws IOException {
        List<Employee> employeeList = new ArrayList<>();
        FileInputStream fis = new FileInputStream(new File("C:\\Not\\Employee Sample Data.xlsx"));
        int i = 0;
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet=wb.getSheetAt(0);
        for(Row row: sheet){
            if(i > 0){
                Employee employee = new Employee();
                if(null != row.getCell(0))
                    employee.setEmployeeID(row.getCell(0).getStringCellValue());
                else
                    employee.setEmployeeID("");

                if(null != row.getCell(1))
                    employee.setFullName(row.getCell(1).getStringCellValue());
                else
                    employee.setFullName("");

                if(null != row.getCell(2))
                    employee.setJobTitle(row.getCell(2).getStringCellValue());
                else
                    employee.setJobTitle("");

                if(null != row.getCell(3))
                    employee.setDepartment(row.getCell(3).getStringCellValue());
                else
                    employee.setDepartment("");

                if(null != row.getCell(4))
                    employee.setBusinessUnit(row.getCell(4).getStringCellValue());
                else
                    employee.setBusinessUnit("");

                if(null != row.getCell(5))
                    employee.setGender(row.getCell(5).getStringCellValue());
                else
                    employee.setGender("");

                if(null != row.getCell(6))
                    employee.setEthnicity(row.getCell(6).getStringCellValue());
                else
                    employee.setEthnicity("");

                if(null != row.getCell(7))
                    employee.setAge((int) row.getCell(7).getNumericCellValue());
                else
                    employee.setAge(0);

                if(null != row.getCell(8))
                    employee.setHireDate((int)row.getCell(8).getNumericCellValue());
                else
                    employee.setHireDate(0);

                if(null != row.getCell(9))
                    employee.setAnnualSalary(row.getCell(9).getNumericCellValue());
                else
                    employee.setAnnualSalary(0.00);

                if(null != row.getCell(10))
                    employee.setBonus((int)row.getCell(10).getNumericCellValue());
                else
                    employee.setBonus(0);

                if(null != row.getCell(11))
                    employee.setCountry(row.getCell(11).getStringCellValue());
                else
                    employee.setCountry("");

                if(null != row.getCell(12))
                    employee.setCity(row.getCell(12).getStringCellValue());
                else
                    employee.setCity("");
                
                
                
                if(null != row.getCell(13) &&  row.getCell(13).getCellType() == CellType.NUMERIC)
                    employee.setExitDate((int)row.getCell(13).getNumericCellValue());
                else
                    employee.setExitDate(0);
                
                employeeList.add(employee);
            }
            i++;
        }
        fis.close();
        return employeeList;
    }
}
