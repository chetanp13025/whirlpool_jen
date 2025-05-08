package test; // Keep it in the 'test' package if you prefer

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.testng.annotations.Test;
import org.testng.Assert; // Import the Assert class for making assertions

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

public class Over_write_filetest extends Properties_wl {
    static String filePath = ".\\csv_file\\Whirlpool_file.csv";
    static Set<String> usedValues = new HashSet<>();
    public static ArrayList<String> CRMticket = new ArrayList<>();
    public static ArrayList<String> SRNs = new ArrayList<>();
    public static ArrayList<String> IRRDs = new ArrayList<>();
    public static ArrayList<String> IRDs = new ArrayList<>();
    public static ArrayList<String> tagLists = new ArrayList<>();
    public static String CRMTickets;

    @Test
    public void testWriteOperation() throws IOException, CsvException {
        String testFilePath = ".\\csv_file\\test_whirlpool.csv";
        try (FileWriter writer = new FileWriter(testFilePath)) {
            writer.write("col1,col2,col3,col4,col5,col6,col7,col8,col9,col10,col11,col12,col13,col14,col15,col16,col17,col18,col19,col20,col21\n");
            writer.write("initial1,initial2,initial3,initial4,initial5,initial6,val7,val8,val9,val10,val11,val12,val13,val14,val15,val16,val17,val18,initial_ird,initial_irrd,val21\n");
        }

        String originalFilePath = filePath;
        filePath = testFilePath;

        Write();

        try (CSVReader csvReader = new CSVReader(new FileReader(testFilePath))) {
            List<String[]> records = csvReader.readAll();
            Assert.assertEquals(records.size(), 2, "Should be header + 1 data row");
            Assert.assertTrue(records.get(1)[0].startsWith("5000CRM"), "CRM ticket should start with 5000CRM");
            Assert.assertTrue(records.get(1)[5].startsWith("SRN"), "SRN should start with SRN");
            Assert.assertTrue(records.get(1)[19].startsWith("IRRD"), "IRRD should start with IRRD");
            Assert.assertTrue(records.get(1)[20].startsWith("IRD"), "IRD should start with IRD");
            Assert.assertEquals(tagLists.size(), 1, "Should have one tag ID generated");
            Assert.assertTrue(tagLists.get(0).startsWith("t-") && tagLists.get(0).length() == 8, "Tag ID format is incorrect");
        } finally {
            filePath = originalFilePath;
            new java.io.File(testFilePath).delete();
        }
    }

    public static void Write() {
        Properties_wl.pro();
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = csvReader.readAll();
            csvReader.close();

            if (records.size() <= 1) {
                System.out.println("No records to overwrite!");
                return;
            }

            int existingRowCount = records.size() - 1;

            CRMticket.clear();
            SRNs.clear();
            IRRDs.clear();
            IRDs.clear();
            tagLists.clear();

            for (int i = 1; i <= existingRowCount; i++) {
                String[] record = records.get(i);
                String col0Value = "5000CRM" + generateUniqueRandomValue();
                String col5Value = "SRN" + generateUniqueRandomValue();
                String commonRandomValue = generateUniqueRandomValue();
                String col19Value = "IRRD" + commonRandomValue;
                String col20Value = "IRD" + commonRandomValue;
                String tagId = generateTagId();

                if (record.length > 0) {
                    record[0] = col0Value;
                    CRMticket.add(col0Value);
                    CRMTickets = String.join(",", CRMticket);
                }
                if (record.length > 5) {
                    record[5] = col5Value;
                    SRNs.add(col5Value);
                    Collections.reverse(SRNs);
                }
                if (record.length > 19) {
                    record[19] = col19Value;
                    IRRDs.add(col19Value);
                }
                if (record.length > 20) {
                    record[20] = col20Value;
                    IRDs.add(col20Value);
                }

                tagLists.add(tagId);
            }

            try (CSVWriter csvWriter = new CSVWriter(new FileWriter(filePath))) {
                csvWriter.writeAll(records);
            }

            System.out.println("Successfully overwritten " + existingRowCount + " records in:");
            System.out.println(tagLists);
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

    private static String generateUniqueRandomValue() {
        String uniqueValue;
        do {
            uniqueValue = String.valueOf(new Random().nextInt(100000000));
        } while (!usedValues.add(uniqueValue));
        return uniqueValue;
    }

    private static String generateTagId() {
        String alphanumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder tagId = new StringBuilder("t-");
        for (int j = 0; j < 6; j++) {
            int index = random.nextInt(alphanumeric.length());
            tagId.append(alphanumeric.charAt(index));
        }
        return tagId.toString();
    }
}
