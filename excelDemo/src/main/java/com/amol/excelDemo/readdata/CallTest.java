package com.amol.excelDemo.readdata;

import com.amol.excelDemo.sample.data.Employee;
import com.amol.excelDemo.sample.data.MachineProductData;

import java.io.IOException;
import java.util.List;

/**
 * @author Bhagwat Kolte
 */
public class CallTest {
    public static void main(String[] args) throws IOException {
        ReadMachineProductData productData = new ReadMachineProductData();
        List<MachineProductData> list = productData.getMachineProductData();
        
        ReadEmployeeData employeeData = new ReadEmployeeData();
        List<Employee> employees = employeeData.getEmployeeData();
    }
}
