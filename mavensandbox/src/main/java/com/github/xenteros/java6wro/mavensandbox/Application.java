package com.github.xenteros.java6wro.mavensandbox;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Application {

    public static void main(String[] args) throws IOException {
        CSVReader csvReader = new CSVReader(new FileReader("C:\\Users\\Ola\\IdeaProjects\\programowanie-java6wro\\mavensandbox\\src\\main\\resources\\example.csv"), ';');

        ColumnPositionMappingStrategy<Person> columnPositionMappingStrategy =
                new ColumnPositionMappingStrategy<>();
        columnPositionMappingStrategy.setType(Person.class);
        columnPositionMappingStrategy.setColumnMapping("firstName", "lastName", "age");
        CsvToBean<Person> csvToBean = new CsvToBean<>();
        List<Person> people = csvToBean.parse(columnPositionMappingStrategy, csvReader);

        for (Person person : people) {
            System.out.println(person);
        }

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Person example");
        for (int i = 0; i < people.size(); i++) {
            HSSFRow row = sheet.createRow(i);
            row.createCell(0).setCellValue(people.get(i).getFirstName());
            row.createCell(1).setCellValue(people.get(i).getLastName());
            row.createCell(2).setCellValue(people.get(i).getAge());
        }

        FileOutputStream fs = new FileOutputStream("person-example.xls");
        workbook.write(fs);
        workbook.close();

        PDDocument pdDocument = new PDDocument();
        PDPage page = new PDPage();
        pdDocument.addPage(page);
        PDPageContentStream contentStream = new PDPageContentStream(pdDocument, page);
        contentStream.beginText();
        contentStream.setFont(PDType1Font.COURIER_BOLD, 12);
        contentStream.showText("Hello PDF");
        contentStream.endText();
        contentStream.close();
        pdDocument.save("example.pdf");

//        for (String[] strings : csvReader.readAll()) {
//            for (String string : strings) {
//                System.out.print(string + " ");
//            }
//            System.out.println();
//        }
    }
}
