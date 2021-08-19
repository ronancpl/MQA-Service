/*
    This file is part of the MapleQuestAdvisor planning tool    
    Copyleft (L) 2020 - 2021 RonanLana

    GNU General Public License v3.0

    Permissions of this strong copyleft license are conditioned on making available complete
    source code of licensed works and modifications, which include larger works using a licensed
    work, under the same license. Copyright and license notices must be preserved. Contributors
    provide an express grant of patent rights.
 */
package mqaservice.csv;

import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author RonanLana
 */
public class CsvFileWriter {
    
    private static void writeCsvContent(PrintWriter printWriter, Object[][] csvFields) {
        for (Object[] row : csvFields) {
            for (Object s : row) {
                printWriter.print(s.toString() + ",");
            }
            printWriter.println();
        }
    }
    
    public static void writeCsv(String filePath, Object[] csvHeader, Object[][] csvRows) {
        try {
            PrintWriter printWriter = new PrintWriter(filePath, "UTF-8");
            
            writeCsvContent(printWriter, new Object[][]{csvHeader});
            writeCsvContent(printWriter, csvRows);

            printWriter.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }    
    }
    
}
