package com.utils;

        import org.apache.poi.ss.usermodel.Cell;
        import org.apache.poi.ss.usermodel.CellType;
        import org.apache.poi.xssf.usermodel.XSSFSheet;
        import org.apache.poi.xssf.usermodel.XSSFWorkbook;
        import org.testng.annotations.DataProvider;

        import java.io.FileInputStream;
        import java.io.IOException;
        import java.lang.annotation.Annotation;
        import java.lang.reflect.Method;
        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.Iterator;

public class TestDataProvider {

   /* public static String EXCEL_PATH;
    public static String EXCEL_SHEET_NAME;*/

    @DataProvider
    public static Iterator<Object[]> getData (Method method){

        ArrayList<Object[]> testData = new ArrayList<>();
        HashMap<String,Object> map ;
        try {
            FileInputStream fis = new FileInputStream(getExcelPath(method)[0]);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(getExcelPath(method)[1]);

            int rowCount = sheet.getLastRowNum();
            int columnCount = sheet.getRow(0).getLastCellNum();

            for (int i=1;i<=rowCount;i++){
                map = new HashMap<>();
                for(int j=0;j<columnCount;j++){
                    String headers = sheet.getRow(0).getCell(j).getStringCellValue();
                    Cell cell = sheet.getRow(i).getCell(j);

                    if (cell.getCellType() == CellType.STRING){
                        String values = cell.getStringCellValue();
                        map.put(headers,values);
                    } else if (cell.getCellType() == CellType.BOOLEAN){
                        boolean values = cell.getBooleanCellValue();
                        map.put(headers,values);
                    } else if (cell.getCellType() == CellType.NUMERIC){
                        long values = (long) cell.getNumericCellValue();
                        map.put(headers,values);
                    } else if (cell.getCellType() ==CellType.BLANK){
                        String values = "";
                        map.put(headers,values);
                    }
                }
                testData.add(new Object[]{map});
                System.gc();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return testData.iterator();
    }
    public static String[] getExcelPath(Method method) {
        String[] excelPath= new String[2];
        Annotation[] annotation = method.getAnnotations();
        for (Annotation value: annotation) {
            if (value.annotationType() == TestConfiguration.class) {
                Class<?>[] classes = method.getParameterTypes();
                try {
                    if (classes.length <= 0) {
                        excelPath[0] = (method.getDeclaringClass()
                                .getDeclaredMethod(method.getName()).getAnnotation(TestConfiguration.class))
                                .excelPath();
                        excelPath[1] = (method.getDeclaringClass()
                                .getDeclaredMethod(method.getName()).getAnnotation(TestConfiguration.class))
                                .excelSheet();
                    }
                    else {
                        excelPath[0] = (method.getDeclaringClass()
                                .getDeclaredMethod(method.getName(), classes).getAnnotation(TestConfiguration.class))
                                .excelPath();
                        excelPath[1] = (method.getDeclaringClass()
                                .getDeclaredMethod(method.getName(), classes).getAnnotation(TestConfiguration.class))
                                .excelSheet();
                    }
                } catch (NoSuchMethodException | SecurityException e) {
                    System.out.println(e);
                }
            }
        }
        return excelPath;
    }

}
