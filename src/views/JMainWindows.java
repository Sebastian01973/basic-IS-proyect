package views;

import views.dialog.JDialogAdd;
import views.dialog.JDialogDelete;
import views.dialog.JDialogProduct;
import views.dialog.JDialogSearch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class JMainWindows extends JFrame {

    private JDialogProduct jDialogProduct;
    private JDialogAdd jDialogAdd;
    private JDialogSearch jDialogSearch;
    private JDialogDelete jDialogDelete;
    private JMainPanel jMainPanel;

    public JMainWindows(ActionListener actionListener, MouseListener mouseListener, WindowListener windowListener){
        this.addWindowListener(windowListener);
        this.setTitle("Veterinaria la nueva granja");
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setMaximumSize(Constant.SCREEN_SIZE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setMinimumSize(Constant.SCREEN_SIZE);
        initComponents(actionListener,mouseListener);
        this.setVisible(true);
    }

    private void initComponents(ActionListener actionListener, MouseListener mouseListener) {
        jDialogProduct = new JDialogProduct(actionListener,this);
        jDialogAdd = new JDialogAdd(actionListener,this);
        jDialogSearch = new JDialogSearch(actionListener,this);
        jDialogDelete = new JDialogDelete(actionListener,this);
        jMainPanel = new JMainPanel(actionListener,mouseListener);
        this.getContentPane().add(jMainPanel, BorderLayout.CENTER);
    }

    public String getCodeProductDelete(){
        return jDialogDelete.getCodeProductDelete();
    }

    public void emptyCodeDelete(){
        jDialogDelete.emptyCodeDelete();
    }

    public void addRowsToTable(ArrayList<Object[]> matrix, String[] newHeaders){
        jMainPanel.addRowsToTable(matrix, newHeaders);
    }
    public void addElementToTable(ArrayList<Object[]> matrix){
        jMainPanel.addElementToTable(matrix);
    }

    public void addObjectsProduct(Object[] objects){
        jDialogProduct.addObjectsProduct(objects);
    }

    public int getSelectedRow(Point point ){
        return jMainPanel.getSelectedRow(point);
    }

    public int getColumnCountTable(){
        return jMainPanel.getColumnCountTable();
    }

    public void setVisibleLeft(boolean visibleLeft){
        jMainPanel.setVisibleLeft(visibleLeft);
    }

    public int getPositionLeft(){
        return jMainPanel.getPositionLeft();
    }

    public void setVisibleDialogAdd(boolean status){
        jDialogAdd.setVisible(status);
    }

    public void setVisibleSearchDialog(boolean status){
        jDialogSearch.setVisible(status);
    }

    public void setVisibleDeleteDialog(boolean status){
        jDialogDelete.setVisible(status);
    }

    public void setVisibleDialogProduct(boolean status){
        jDialogProduct.setVisible(status);
    }

    public void resetDatesAddProduct() {
        jDialogAdd.resetDatesAddProduct();
    }

    public Object[] createProduct() {
        return jDialogAdd.createProduct();
    }

    public void addElementToTable(Object[] vector){
        jMainPanel.addElementToTable(vector);
    }

}
