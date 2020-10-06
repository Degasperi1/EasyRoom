/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import javax.swing.JFileChooser;

/**
 *
 * @author evand
 */
public class CSVUtils {

    public static void writeOneLine(String[] linha, String arquivo) {
        CSVWriter writer = null;
        try {
            writer = new CSVWriter(new FileWriter(arquivo, true),
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER);
            //Write the record to file
            writer.writeNext(linha);
            //close the writer
            writer.close();
        } catch (Exception e) {
            System.out.println("Erro ao exportar CSV: " + e.toString());
        }
    }

    public static String getDirPath() {
        String path = "";
        JFileChooser file = new JFileChooser();
        file.setMultiSelectionEnabled(false);
        file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        file.setFileHidingEnabled(false);
        if (file.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            java.io.File f = file.getSelectedFile();
            path = f.getPath();
        }

        return path;// substring com lastIndexOf("/");

    }
}
