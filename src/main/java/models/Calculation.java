package models;

import Controlers.ReaderXLSFile;
import Controlers.WriteTXTFiles;

import java.util.HashMap;
import java.util.Map;

public class Calculation {
    HashMap<Integer, Integer> mapOstatkiVystavka;
    HashMap<Integer, Integer> mapOstatkiCentral;
    HashMap<Item, Integer> mapOstatkiNeeded;

    public HashMap<Item, Integer> getMapTransfer() {
        return mapTransfer;
    }

    HashMap<Item, Integer> mapTransfer;
    HashMap<Integer, String> mapCodeName;
    double porogTransfer = 0.7;

    public Calculation() {
        mapOstatkiVystavka = ReaderXLSFile.getOstatkiVystavka();
        mapOstatkiCentral = ReaderXLSFile.getOstatkiCentral();
        mapOstatkiNeeded = ReaderXLSFile.getOstatkiNeeded();
        mapTransfer = new HashMap<>();
        System.out.println(mapOstatkiVystavka.size());
        System.out.println(mapOstatkiCentral.size());
        System.out.println(mapOstatkiNeeded.size());
    }


    public void start() {
        for (Map.Entry<Item, Integer> entry : mapOstatkiNeeded.entrySet()) {
            //System.out.println(entry.getKey());
            if (entry.getValue() > 0) {
                if (mapOstatkiCentral.containsKey(entry.getKey().getCode())) {
                    int ostatkiVystavka = 0;
                    if (mapOstatkiVystavka.containsKey(entry.getKey().getCode())) {
                        ostatkiVystavka = mapOstatkiVystavka.get(entry.getKey().getCode());
                    }
                    if (ostatkiVystavka < porogTransfer * entry.getValue()) {
                        int transferQuanity;
                        if (mapOstatkiCentral.get(entry.getKey().getCode()) > (entry.getValue() - ostatkiVystavka)) {
                            transferQuanity = entry.getValue() - ostatkiVystavka;
                        } else {
                            transferQuanity = mapOstatkiCentral.get(entry.getKey().getCode());
                        }
                        mapTransfer.put(entry.getKey(), transferQuanity);
                    }

                }
            }

            WriteTXTFiles.saveTransferFile(mapTransfer);
        }

    }
}
