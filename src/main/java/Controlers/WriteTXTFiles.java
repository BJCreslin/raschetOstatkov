package Controlers;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class WriteTXTFiles {
    public static String NAMEOUTFILE = "out.txt";
    public static String PATHTOFILES = "\\\\Post\\креслин владимир\\перемещение\\";

    public static void saveTransferFile(HashMap<Integer, Integer> mapForOut) {

        try (OutputStreamWriter fileOutTXT = new OutputStreamWriter(new FileOutputStream(PATHTOFILES + NAMEOUTFILE, false),
                "UTF-16")) {
            if (mapForOut.size() > 0) {
                fileOutTXT.write("счет=10\n" +
                        "Дата=" + ConsoleCommand.dateOut() + "\n" +
                        "Клиент=8\n");
                for (Map.Entry<Integer, Integer> entry : mapForOut.entrySet()) {
                    fileOutTXT.write("Следтовар\n");
                    fileOutTXT.write("Количество=" + entry.getValue() + "\n");
                    fileOutTXT.write("Кодтовара=" + entry.getKey() + "\n");
                    fileOutTXT.write("Цена=308\n");
                }
            }
            fileOutTXT.flush();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void saveTransferFile(HashMap<Integer, Integer> mapForOut, String nammm) {

        try (OutputStreamWriter fileOutTXT = new OutputStreamWriter(new FileOutputStream(PATHTOFILES + nammm, false),
                "UTF-16")) {
            if (mapForOut.size() > 0) {
                fileOutTXT.write("счет=10\n" +
                        "Дата=" + ConsoleCommand.dateOut() + "\n" +
                        "Клиент=8\n");
                for (Map.Entry<Integer, Integer> entry : mapForOut.entrySet()) {
                    fileOutTXT.write("Следтовар\n");
                    fileOutTXT.write("Количество=" + entry.getValue() + "\n");
                    fileOutTXT.write("Кодтовара=" + entry.getKey() + "\n");
                    fileOutTXT.write("Цена=308\n");
                }
            }
            fileOutTXT.flush();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
