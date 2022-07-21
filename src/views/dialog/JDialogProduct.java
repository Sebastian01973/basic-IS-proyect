package views.dialog;

import controllers.Command;
import views.Constant;
import views.JMainWindows;
import views.models.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatter;
import java.awt.*;
import java.awt.event.ActionListener;

public class JDialogProduct extends JDialog {

    private JPanel jContainerProduct;
    private JModelLabel codeProduct;
    private JModelTextField nameProduct,descProduct;
    private JModelComboBox<Object> jCBType;
    private JSpinner units,prices;
    private JModelButton delete,modify,cancel;
    private GridModel gridModel;
    private Object[] objects;
    public JDialogProduct(ActionListener actionListener, JMainWindows jMainWindows) {
        this.setModal(true);
        this.objects = new Object[4];
        setTitle(Constant.D_TXT_PRODUCT);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(Constant.COLOR_GREEN_DARK_2);
        this.setSize(new Dimension(600,750));
        this.setResizable(false);
        this.setLocationRelativeTo(jMainWindows);
        initComponents(actionListener);
    }

    public void addObjectsProduct(Object[] objects){
        this.objects = objects;
        int code = Integer.parseInt(String.valueOf(objects[0]));
        String name = String.valueOf(objects[1]);
        int unit = Integer.parseInt(String.valueOf(objects[2]));
        double price = Double.parseDouble(String.valueOf(objects[3]));
        String typeProduct = String.valueOf(objects[4]);
        String description = String.valueOf(objects[5]);
        double calculate = Double.parseDouble(String.valueOf(objects[6]));

        System.out.println(code +" - "+name +" - "+unit+" - "+price +" - "+typeProduct+" - "+description +" - "+ calculate);

        nameProduct.setText(name);
        units.setValue(unit);
        prices.setValue(price);
        jCBType.setSelectedIndex(getSelectType(typeProduct));
        descProduct.setText(description);
    }

    public int getSelectType(String value){
        switch (value){
            case "CONCENTRATES": return 1;
            case "NECKLACES": return 2;
            case "HYGIENE_PRODUCT": return 3;
            case "MEDICINES": return 4;
            case "VACCINES": return 5;
            default: return -1;
        }
    }


    public Object[] modifyProduct(){
        if (jCBType.getSelectedIndex() != 0){
            return new Object[]{
                    nameProduct.getText(), prices.getValue(), jCBType.getSelectedIndex(),
                    units.getValue(), descProduct.getText()
            };
        }
        return null;
    }


    private void initComponents(ActionListener actionListener) {

        jContainerProduct = new JPanel();
        gridModel = new GridModel(jContainerProduct);
        jContainerProduct.setLayout(new GridBagLayout());
        jContainerProduct.setBorder(new EmptyBorder(0, 5, 0, 5));
        jContainerProduct.setBackground(Constant.COLOR_GREEN_DARK_2);

        gridModel.addExternalBorder(10, 10, 10, 20);

        JModelLabel logo = new JModelLabel(Constant.IMG_BANNER, 490, 120);
        logo.setColorPaint(Constant.COLOR_GREEN_DARK_2);
        logo.setBackground(Constant.COLOR_GREEN_DARK_2);
        jContainerProduct.add(logo, gridModel.insertComponent(0, 0, 4, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH));


        codeProduct = new JModelLabel("Codigo: 23",Constant.COLOR_GREEN_DARK_2,Constant.COLOR_WHITE,Constant.FONT_ARIAL_ROUNDER_30,new EmptyBorder(10,10,10,10));
        codeProduct.setColorPaint(Constant.COLOR_GREEN_DARK_2);
        codeProduct.setBackground(Constant.COLOR_GREEN_DARK_2);
        jContainerProduct.add(codeProduct,gridModel.insertComponent(1,3,1,1,1,GridBagConstraints.PAGE_START, GridBagConstraints.BOTH));

        gridModel.addExternalBorder(10, 10, 10, 20);

        nameProduct = new JModelTextField(Constant.NAME_PRODUCT, Constant.FONT_HELVETICA_15, Constant.COLOR_WHITE, Constant.COLOR_BLACK);
        nameProduct.validateText(nameProduct);
        nameProduct.setBorder(BorderFactory.createTitledBorder(Constant.TXT_PRODUCT));
        gridModel.addExternalBorder(10, 10, 10, 20);
        jContainerProduct.add(nameProduct, gridModel.insertComponent(2, 3, 1, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.HORIZONTAL));

        jCBType = new JModelComboBox<>(Constant.OPTIONS, Constant.ASSIGN_OPTION, Constant.FONT_HELVETICA_15);
        jContainerProduct.add(jCBType, gridModel.insertComponent(4, 3, 1, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.HORIZONTAL));

        prices = new JSpinner(new SpinnerNumberModel(1000, 1000, 10000000, 1000));
        ((DefaultFormatter) ((JSpinner.NumberEditor) prices.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);
        prices.setBorder(BorderFactory.createTitledBorder(Constant.TXT_PRICE));
        prices.setBackground(Constant.COLOR_WHITE);
        jContainerProduct.add(prices, gridModel.insertComponent(3, 3, 1, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.HORIZONTAL));


        units = new JSpinner(new SpinnerNumberModel(1, 1, 10000, 10));
        ((DefaultFormatter) ((JSpinner.NumberEditor) units.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);
        units.setBorder(BorderFactory.createTitledBorder(Constant.TXT_UNITS));
        units.setBackground(Constant.COLOR_WHITE);
        jContainerProduct.add(units, gridModel.insertComponent(5, 3, 1, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.HORIZONTAL));

        descProduct = new JModelTextField(Constant.DESCR_PRODUCT, Constant.FONT_HELVETICA_15, Constant.COLOR_WHITE, Constant.COLOR_BLACK);
        descProduct.setBorder(BorderFactory.createTitledBorder(Constant.TXT_DESCR));
        gridModel.addExternalBorder(10, 10, 10, 20);
        jContainerProduct.add(descProduct, gridModel.insertComponent(6, 3, 1, 2, 1, GridBagConstraints.PAGE_START, GridBagConstraints.HORIZONTAL));

        modify = new JModelButton(15,15,Constant.TXT_MODIFY,Constant.COLOR_ORANGE_1,Constant.COLOR_WHITE,Constant.FONT_ARIAL_ROUNDER_15, Command.MODIFY_PRODUCT.toString(),actionListener);
        modify.setColorPaint(Constant.COLOR_GREEN_DARK_2);
        modify.setBorder(BorderFactory.createEmptyBorder(10,20,10,10));
        gridModel.addExternalBorder(10,10,10,20);
        jContainerProduct.add(modify,gridModel.insertComponent(9,3,1,1,1,GridBagConstraints.PAGE_START, GridBagConstraints.HORIZONTAL));

        delete = new JModelButton(15,15,Constant.TXT_DELETE,Constant.COLOR_RED_LIGHT_1,Constant.COLOR_WHITE,Constant.FONT_ARIAL_ROUNDER_15,Command.JD_DELETE_PRODUCT.toString(),actionListener);
        delete.setColorPaint(Constant.COLOR_GREEN_DARK_2);
        delete.setBorder(BorderFactory.createEmptyBorder(10,20,10,10));
        gridModel.addExternalBorder(10,10,10,20);
        jContainerProduct.add(delete,gridModel.insertComponent(8,3,1,1,1,GridBagConstraints.PAGE_START, GridBagConstraints.HORIZONTAL));


        this.add(jContainerProduct);


    }
}
