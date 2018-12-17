package view.swing;

import Controlers.WriteTXTFiles;
import javafx.scene.control.RadioButton;
import models.Calculation;
import models.Item;
import models.TableTransfer;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.DefaultEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainScreen extends JFrame {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JPanel PanelConfiguration;
    private JButton StartCalculationButton;
    private JButton buttonSaveTransfer;
    private JTable tableTransfer;
    private JPanel panelTransfer;
    private JScrollPane jpanelTransfer;
    private JPanel panelcheckboxes;


    private Map<String, JCheckBox> mapGroups;
    private TableTransfer tableModel;


    public MainScreen() {
        super("Albert"); //Заголовок окна

        final Calculation calculation = new Calculation();


        setBounds(50, 50, 1600, 900); //Если не выставить
        //размер и положение
        //то окно будет мелкое и незаметное
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //это нужно для того чтобы при
        //закрытии окна закрывалась и программа,
        //иначе она останется висеть в процессах
        add(tabbedPane1);


        StartCalculationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                calculation.start();
                tableModel = new TableTransfer(calculation.getMapTransfer());

                tableTransfer.setModel(tableModel);
                System.out.println("hhh");


                // System.out.println(tableModel.getGroupsList().size()+"     c");
                // tableModel.getGroupsList().forEach(System.out::println);

                mapGroups = new HashMap<>();
                panelcheckboxes.setLayout(new BoxLayout(panelcheckboxes, BoxLayout.Y_AXIS));
                for (String groupName : tableModel.getGroupsList()) {
                    //  RadioButton radioButton = new RadioButton();
                    JCheckBox jCheckBox = new JCheckBox(groupName);
                    jCheckBox.setSelected(true);

                    jCheckBox.addItemListener(new ItemListener() {
                        @Override
                        public void itemStateChanged(ItemEvent e) {


                            Map<Item, Integer> mapForTable = calculation.getMapTransfer();
                            Map<Item, Integer> mapFortable2 = new HashMap<>();
                            for (Map.Entry<Item, Integer> entry : mapForTable.entrySet()) {
                                if ((mapGroups.containsKey(entry.getKey().getGroupItem().getName())) &&
                                        mapGroups.get(entry.getKey().getGroupItem().getName()).isSelected()) {
                                    mapFortable2.put(entry.getKey(), entry.getValue());
                                }

                            }
                            tableModel = new TableTransfer(mapFortable2);
                            tableTransfer.setModel(tableModel);
                        }

                    });


                    mapGroups.put(groupName, jCheckBox);


                    panelcheckboxes.add(jCheckBox);
                    // panelTransfer.add(new RadioButton());

                }
                jpanelTransfer.updateUI();
            }
        });

        /*Набор групп */
//        mapGroups = new HashMap<>();
//        for (Map.Entry<Item, Integer> entry : calculation.getMapTransfer().entrySet()) {
//            mapGroups.put(entry.getKey().getGroupItem().getName(), null);
//        }
//        System.out.println(mapGroups.size() + "      s");


        buttonSaveTransfer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WriteTXTFiles.saveTransferFile(TableTransfer.getMapCodeCount());
            }
        });


    }


}
