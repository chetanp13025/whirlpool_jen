package web;

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

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

public class Over_write_file extends Properties_wl{
	static String filePath = ".\\csv_file\\Whirlpool_file.csv";
    static Set<String> usedValues = new HashSet<>();

    // ArrayLists to store updated values
    public static ArrayList<String> CRMticket = new ArrayList<>();
    public static ArrayList<String> SRNs = new ArrayList<>();
    public static ArrayList<String> IRRDs = new ArrayList<>();
    public static ArrayList<String> IRDs = new ArrayList<>();
    public static ArrayList<String> tagLists = new ArrayList<>();
    public static String CRMTickets;
@Test
	public static void Write() {
	Properties_wl.pro();
	try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
        List<String[]> records = csvReader.readAll();
        csvReader.close();

        if (records.size() <= 1) {
            System.out.println("No records to overwrite!");
            return;
        }

        int existingRowCount = records.size() - 1; // Excluding header
        System.out.println("Existing records count: " + existingRowCount);

        // Clear ArrayLists before storing new values
        CRMticket.clear();
        SRNs.clear();
        IRRDs.clear();
        IRDs.clear();
        tagLists.clear();

        for (int i = 1; i <= existingRowCount; i++) { // Skip header row
            String[] record = records.get(i);

            // Generate unique values per row
            String col0Value = "5000CRM" + generateUniqueRandomValue();
            String col5Value = "SRN" + generateUniqueRandomValue();
            String commonRandomValue = generateUniqueRandomValue(); // Same for 19 & 20
            String col19Value = "IRRD" + commonRandomValue;
            String col20Value = "IRD" + commonRandomValue;
            String tagId = generateTagId(); // Generate unique tag ID

            // Overwrite specific columns only
            if (record.length > 0) {
                record[0] = col0Value;
                CRMticket.add(col0Value);
                CRMTickets = String.join(",",CRMticket);// Store in ArrayList
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
            
            // Store the generated tag ID
            tagLists.add(tagId);
            
        }

        // Write back the modified records
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
@Test
private static String generateTagId() {
    String alphanumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    Random random = new Random();
    StringBuilder tagId = new StringBuilder("t-");

    for (int j = 0; j < 6; j++) { // 6-character random tag ID
        int index = random.nextInt(alphanumeric.length());
        tagId.append(alphanumeric.charAt(index));
    }
    return tagId.toString();
}
}
