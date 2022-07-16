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
}
