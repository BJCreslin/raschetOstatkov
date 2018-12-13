package models;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Map;

import static Controlers.ReaderXLSFile.mapCodeName;

public class TableTransfer extends AbstractTableModel {
    ArrayList<String[]> tableArrayList;

    public TableTransfer(Map<Item, Integer> mapCodeCount) {
        tableArrayList = new ArrayList<>();
        for (Map.Entry<Item, Integer> entry : mapCodeCount.entrySet()) {
            String[] rowStringArray = new String[3];
            rowStringArray[0] = Integer.toString(entry.getKey().getCode());
            rowStringArray[1] = entry.getKey().getName();
            rowStringArray[2] = Integer.toString(entry.getValue());
            tableArrayList.add(rowStringArray);
        }
    }

    @Override
    public int getRowCount() {
        return tableArrayList.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return tableArrayList.get(rowIndex)[columnIndex];
    }

    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Код";
            case 1:
                return "Название";
            case 2:
                return "Количество";
        }
        return "";
    }
}
