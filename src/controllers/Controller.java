package controllers;

import models.Product;
import models.Store;
import utilities.Utilities;
import views.Constant;
import views.JMainWindows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Controller implements ActionListener, MouseListener, WindowListener {

    private JMainWindows jMainWindows;
    private Store store;

    public Controller() {
        jMainWindows = new JMainWindows(this,this,this);
        store = new Store();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Command.valueOf(e.getActionCommand())) {
            case B_MENU -> this.setleftPanel();
            case ADD_PRODUCT -> jMainWindows.setVisibleDialogAdd(true);
            case SEARCH_PRODUCT -> jMainWindows.setVisibleSearchDialog(true);
            case DELETE_PRODUCT -> jMainWindows.setVisibleDeleteDialog(true);
            case EXIT -> exitAdmin();
            case SAVE_PRODUCT -> saveProduct();
            case CANCEL_PRODUCT ->  cancelProduct();
            case CANCEL_DELETE -> {
                jMainWindows.setVisibleDeleteDialog(false);
                jMainWindows.emptyCodeDelete();
            }
            case DIALOG_DELETE -> this.deleteProduct();
            default -> Logger.getGlobal().severe("Error");
        }
    }

    private void deleteProduct() {
        int code = Integer.parseInt(jMainWindows.getCodeProductDelete());
        if (store.isExistProduct(code)){
            Product product = store.searchProduct(code);
            store.deleteProduct(product);
            loadProducts();
        }else{
            JOptionPane.showMessageDialog(jMainWindows,Constant.TXT_NOT_DELETE);
        }
        jMainWindows.setVisibleDeleteDialog(false);
    }

    private void loadProducts(){
        ArrayList<Object[]> products = store.getMatrixProducts();
        jMainWindows.addElementToTable(products);
    }

    private void cancelProduct() {
        jMainWindows.setVisibleDialogAdd(false);
        jMainWindows.resetDatesAddProduct();
    }

    private void saveProduct() {
        Object[] product = jMainWindows.createProduct();
        if (product != null) {
            int typeProduct = Integer.parseInt(String.valueOf(product[2]));
            if(typeProduct != 0){
                String nameProduct = String.valueOf(product[0]);
                double price = Double.parseDouble(String.valueOf(product[1]));
                int units = Integer.parseInt(String.valueOf(product[3]));
                String desc = String.valueOf(product[4]);

                //Crear el producto
                Product productAdd = store.createProduct(nameProduct,units,price,store.getType(typeProduct),desc);
                store.addProduct(productAdd);
                jMainWindows.addElementToTable(productAdd.toObjectvector());
                this.jMainWindows.setVisibleDialogAdd(false);
                JOptionPane.showMessageDialog(jMainWindows, Constant.TXT_ADD_PRODUCT);
                jMainWindows.resetDatesAddProduct();
            }else {
                JOptionPane.showMessageDialog(jMainWindows,Constant.TXT_NOT_TYPE_PRODUCT);
            }
        }else{
            JOptionPane.showMessageDialog(jMainWindows,Constant.TXT_NOT_ALL_TEXT);
        }

        //Test
        store.printProducts();
    }

    private void exitAdmin() {
        System.exit(0);
    }

    private void setleftPanel() {
        int position = jMainWindows.getPositionLeft();
        if (position > 0) {
            jMainWindows.setVisibleLeft(false);
        } else {
            jMainWindows.setVisibleLeft(true);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (jMainWindows.getColumnCountTable() == Constant.H_PRODUCTS.length){
            Point value = e.getPoint();
            int codeProduct = jMainWindows.getSelectedRow(value);
            Product product = store.searchProduct(codeProduct);
            Object[] objProduct = product.toObjectvector();
            jMainWindows.addObjectsProduct(objProduct);

            jMainWindows.setVisibleDialogProduct(true);
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
