package views.dialog;

import controllers.Command;
import utilities.Utilities;
import views.Constant;
import views.JMainWindows;
import views.models.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatter;
import java.awt.*;
import java.awt.event.ActionListener;

public class JDialogAdd extends JDialog {

    private JPanel jContainerAddProduct;

    private JModelTextField nameProduct;
    private JSpinner units, prices;
    private JModelComboBox<Object> jCBType;
    private JModelTextField descriptionProduct;

    private JModelButton createProduct;
    private JModelButton cancelProduct;

    private GridModel gridModel;

    public JDialogAdd(ActionListener actionListener, JMainWindows jMainWindows) {
        this.setModal(true);
        setTitle(Constant.ADD_PRODUCT);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(Constant.COLOR_GREEN_DARK_2);
        this.setSize(new Dimension(550, 650));
        this.setResizable(false);
        this.setLocationRelativeTo(jMainWindows);
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        jContainerAddProduct = new JPanel();
        gridModel = new GridModel(jContainerAddProduct);
        jContainerAddProduct.setLayout(new GridBagLayout());
        jContainerAddProduct.setBorder(new EmptyBorder(0, 5, 0, 5));
        jContainerAddProduct.setBackground(Constant.COLOR_GREEN_DARK_2);

        gridModel.addExternalBorder(10, 10, 10, 20);

        JModelLabel logo = new JModelLabel(Constant.IMG_BANNER, 490, 120);
        logo.setColorPaint(Constant.COLOR_GREEN_DARK_2);
        logo.setBackground(Constant.COLOR_GREEN_DARK_2);
        jContainerAddProduct.add(logo, gridModel.insertComponent(0, 3, 4, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.BOTH));

        gridModel.addExternalBorder(10, 10, 10, 20);

        nameProduct = new JModelTextField(Constant.NAME_PRODUCT, Constant.FONT_HELVETICA_15, Constant.COLOR_WHITE, Constant.COLOR_BLACK);
        nameProduct.validateText(nameProduct);
        nameProduct.setBorder(BorderFactory.createTitledBorder(Constant.TXT_PRODUCT));
        gridModel.addExternalBorder(10, 10, 10, 20);
        jContainerAddProduct.add(nameProduct, gridModel.insertComponent(1, 3, 1, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.HORIZONTAL));

        jCBType = new JModelComboBox<>(Constant.OPTIONS, Constant.ASSIGN_OPTION, Constant.FONT_HELVETICA_15);
        jContainerAddProduct.add(jCBType, gridModel.insertComponent(3, 3, 1, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.HORIZONTAL));

        prices = new JSpinner(new SpinnerNumberModel(1000, 1000, 10000000, 1000));
        ((DefaultFormatter) ((JSpinner.NumberEditor) prices.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);
        prices.setBorder(BorderFactory.createTitledBorder(Constant.TXT_PRICE));
        prices.setBackground(Constant.COLOR_WHITE);
        jContainerAddProduct.add(prices, gridModel.insertComponent(2, 3, 1, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.HORIZONTAL));


        units = new JSpinner(new SpinnerNumberModel(1, 1, 10000, 10));
        ((DefaultFormatter) ((JSpinner.NumberEditor) units.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);
        units.setBorder(BorderFactory.createTitledBorder(Constant.TXT_UNITS));
        units.setBackground(Constant.COLOR_WHITE);
        jContainerAddProduct.add(units, gridModel.insertComponent(4, 3, 1, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.HORIZONTAL));

        descriptionProduct = new JModelTextField(Constant.DESCR_PRODUCT, Constant.FONT_HELVETICA_15, Constant.COLOR_WHITE, Constant.COLOR_BLACK);
        descriptionProduct.setBorder(BorderFactory.createTitledBorder(Constant.TXT_DESCR));
        gridModel.addExternalBorder(10, 10, 10, 20);
        jContainerAddProduct.add(descriptionProduct, gridModel.insertComponent(5, 3, 1, 2, 1, GridBagConstraints.PAGE_START, GridBagConstraints.HORIZONTAL));

        createProduct = new JModelButton(15, 15, Constant.TXT_CREATE, Constant.COLOR_ORANGE_1, Constant.COLOR_WHITE, Constant.FONT_ARIAL_ROUNDER_15, Command.SAVE_PRODUCT.toString(), actionListener);
        createProduct.setColorPaint(Constant.COLOR_GREEN_DARK_2);
        createProduct.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));
        gridModel.addExternalBorder(10, 10, 10, 20);
        jContainerAddProduct.add(createProduct, gridModel.insertComponent(7, 0, 4, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.HORIZONTAL));

        cancelProduct = new JModelButton(15, 15, Constant.TXT_CANCEL, Constant.COLOR_RED_LIGHT_1, Constant.COLOR_WHITE, Constant.FONT_ARIAL_ROUNDER_15, Command.CANCEL_PRODUCT.toString(), actionListener);
        cancelProduct.setColorPaint(Constant.COLOR_GREEN_DARK_2);
        cancelProduct.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));
        gridModel.addExternalBorder(10, 10, 10, 20);
        jContainerAddProduct.add(cancelProduct, gridModel.insertComponent(8, 0, 4, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.HORIZONTAL));

        this.add(jContainerAddProduct);

    }

    public void resetDatesAddProduct() {
        nameProduct.setText("");
        descriptionProduct.setText("");
        jCBType.setSelectedIndex(0);
        prices.setValue(1000);
        units.setValue(1);
    }

    public Object[] createProduct() {
        if (!descriptionProduct.getText().isEmpty() && !nameProduct.getText().isEmpty()) {
            return new Object[]{
                    nameProduct.getText(), prices.getValue(), jCBType.getSelectedIndex(),
                    units.getValue(), descriptionProduct.getText()
            };
        }
        return null;
    }
}
