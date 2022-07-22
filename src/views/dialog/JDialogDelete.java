package views.dialog;

import controllers.Command;
import utilities.Utilities;
import views.Constant;
import views.JMainWindows;
import views.models.JModelButton;
import views.models.JModelLabel;
import views.models.JModelTextField;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class JDialogDelete extends JDialog {

    private GridLayout gridLayout;
    private JModelTextField jCodeProduct;
    private JModelButton jbDelete,jBCancel;
    private JPanel jContainer;
    public JDialogDelete(ActionListener actionListener, JMainWindows jMainWindows) {
        this.setModal(true);
        setTitle(Constant.D_TXT_DELETE);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(Constant.COLOR_BLACK);
        this.setSize(new Dimension(450, 600));
        this.setResizable(false);
        this.setLocationRelativeTo(jMainWindows);
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        jContainer = new JPanel();
        gridLayout = new GridLayout(4,1);
        gridLayout.setVgap(20);
        jContainer.setLayout(gridLayout);
        jContainer.setBorder(new EmptyBorder(20,30,15,30));
        jContainer.setBackground(Constant.COLOR_GREEN_DARK_2);

        JModelLabel banner = new JModelLabel(Constant.IMG_BANNER,350,120);
        banner.setColorPaint(Constant.COLOR_GREEN_DARK_2);
        banner.setBackground(Constant.COLOR_GREEN_DARK_2);
        jContainer.add(banner);

        //Perimitir que solo ingrese 10 digitos del codigo.. o se putea
        jCodeProduct = new JModelTextField(Constant.CODE_PRODUCT,Constant.FONT_HELVETICA_15,Constant.COLOR_GREEN_DARK_2,Constant.COLOR_GRAY_LIGHT_1);
        jCodeProduct.validateNum(jCodeProduct);
        jCodeProduct.setBorder(BorderFactory.createTitledBorder(Constant.TXT_CODE));
        jContainer.add(jCodeProduct);


        jbDelete = new JModelButton(15, 15,Constant.TXT_DELETE,Constant.COLOR_GREEN, Constant.COLOR_WHITE,
                Constant.FONT_ARIAL_ROUNDER_15, Command.DIALOG_DELETE.toString(), actionListener );
        jbDelete.setColorPaint(Constant.COLOR_GREEN_DARK_2);
        jContainer.add(jbDelete);


        jBCancel = new JModelButton( 15, 15,Constant.TXT_CANCEL, Constant.COLOR_RED_LIGHT_1, Constant.COLOR_WHITE,
                Constant.FONT_ARIAL_ROUNDER_15, Command.CANCEL_DELETE.toString(), actionListener );
        jBCancel.setColorPaint(Constant.COLOR_GREEN_DARK_2);
        jContainer.add( jBCancel);

        this.add(jContainer);
    }

    public String getCodeProductDelete(){
        if (!jCodeProduct.getText().isEmpty()){
            return jCodeProduct.getText();
        }
        return "";
    }

    public void emptyCodeDelete(){
        jCodeProduct.setText("");
    }
}
