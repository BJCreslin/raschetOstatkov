package models;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class TableTransfer extends AbstractTableModel {
    public ArrayList<String[]> getTableArrayList() {
        return tableArrayList;
    }

    ArrayList<String[]> tableArrayList;
    private static final int QANTITYCOLUMNS = 4;

    public static Map<Item, Integer> getMapCodeCount() {
        return mapCodeCount;
    }

    private static Map<Item, Integer> mapCodeCount;

    public TableTransfer(Map<Item, Integer> mapCodeCountt) {
        this.mapCodeCount = mapCodeCountt;
        tableArrayList = new ArrayList<>();
        for (Map.Entry<Item, Integer> entry : mapCodeCount.entrySet()) {
            String[] rowStringArray = new String[QANTITYCOLUMNS];
            rowStringArray[0] = Integer.toString(entry.getKey().getCode());
            rowStringArray[1] = entry.getKey().getName();
            rowStringArray[2] = Integer.toString(entry.getValue());
            rowStringArray[3] = entry.getKey().getGroupItem().getName();
            tableArrayList.add(rowStringArray);
        }
    }

    @Override
    public int getRowCount() {
        return tableArrayList.size();
    }

    @Override
    public int getColumnCount() {
        return QANTITYCOLUMNS;
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
            case 3:
                return "Группа";
        }
        return "";
    }


    public Set<String> getGroupsList() {
        Set<String> vectorFromRow = new TreeSet<>();
        for (String[] vector : tableArrayList) {
            vectorFromRow.add(vector[3]);
        }
        return vectorFromRow;
    }
}



