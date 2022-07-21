package views;

import views.admin.JLeftPanel;
import views.admin.JNorthPanel;
import views.admin.JTableCenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class JMainPanel extends JPanel {

    private JNorthPanel jNorthPanel;
    private JTableCenter jTableCenter;
    private JLeftPanel jLeftPanel;
    public JMainPanel(ActionListener actionListener, MouseListener mouseListener) {
        this.setBackground(Constant.COLOR_WHITE);
        this.setLayout(new BorderLayout(0,0));
        this.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        initComponents(actionListener,mouseListener);
    }

    private void initComponents(ActionListener actionListener, MouseListener mouseListener) {
        jNorthPanel = new JNorthPanel(actionListener);
        this.add(jNorthPanel, BorderLayout.NORTH);

        jTableCenter = new JTableCenter(actionListener,mouseListener);
        this.add(jTableCenter,BorderLayout.CENTER);

        jLeftPanel = new JLeftPanel(actionListener);
        this.add(jLeftPanel,BorderLayout.WEST);
    }

    public void addRowsToTable(ArrayList<Object[]> matrix, String[] newHeaders){
        jTableCenter.addRowsToTable(matrix, newHeaders);
    }
    public void addElementToTable(ArrayList<Object[]> matrix){
        jTableCenter.addElementToTable(matrix);
    }

    public int getSelectedRow(Point point ){
        return jTableCenter.getSelectedRow(point);
    }

    public int getColumnCountTable(){
        return jTableCenter.getColumnCountTable();
    }

    public void setVisibleLeft(boolean visibleLeft){
        jLeftPanel.setVisibleLeft(visibleLeft);
    }

    public int getPositionLeft(){
        return jLeftPanel.getPositionLeft();
    }

    public void addElementToTable(Object[] vector){
        jTableCenter.addElementToTable(vector);
    }

}
