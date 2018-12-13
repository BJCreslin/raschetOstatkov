package view.swing;

import models.Calculation;
import models.TableTransfer;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JFrame {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JPanel PanelConfiguration;
    private JButton StartCalculationButton;
    private JPanel TransferTable;
    private JButton buttonSaveTransfer;
    private JTable tableTransfer;

    public MainScreen() {
        super("Albert"); //Заголовок окна
        setBounds(50, 50, 1600, 900); //Если не выставить
        //размер и положение
        //то окно будет мелкое и незаметное
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //это нужно для того чтобы при
        //закрытии окна закрывалась и программа,
        //иначе она останется висеть в процессах
        add(tabbedPane1);

        buttonSaveTransfer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calculation calculation = new Calculation();
                calculation.start();
                tableTransfer.setModel(new TableTransfer(calculation.getMapTransfer()));
                System.out.println("hhh");
            }
        });
    }


}
