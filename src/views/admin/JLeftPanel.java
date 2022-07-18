package views.admin;

import controllers.Command;
import utilities.Utilities;
import views.Constant;
import views.models.JModelButton;
import views.models.JModelButtonMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JLeftPanel extends JPanel {

    private JModelButtonMenu[] jButtons;
    private String[] commands = {Command.ADD_PRODUCT.toString(),Command.SEARCH_PRODUCT.toString(), Command.DELETE_PRODUCT.toString()};

    private JModelButton exit;
    public JLeftPanel(ActionListener actionListener) {
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBackground(Constant.COLOR_WHITE);
        this.setBorder(BorderFactory.createEmptyBorder(30,20,5,0));
        initComponents(actionListener);
        this.setVisible(true);
    }

    private void initComponents(ActionListener actionListener) {
        add(Box.createRigidArea(new Dimension(0,(int)(Constant.SCREEN_SIZE.getHeight()*0.1))));
        jButtons = new JModelButtonMenu[3];
        for (int i = 0; i < commands.length; i++) {
            jButtons[i] = new JModelButtonMenu(Constant.TXT_MENU[i]);
            jButtons[i].setActionCommand(commands[i]);
            jButtons[i].addActionListener(actionListener);
            add(jButtons[i]);
            add(Box.createRigidArea(new Dimension(0,70)));
        }

        add(Box.createRigidArea(new Dimension(0,(int)(Constant.SCREEN_SIZE.getHeight()*0.2))));

        exit = new JModelButton(Constant.TXT_SIGN_OFF,Constant.FONT_ARIAL_ROUNDER_15,Constant.COLOR_WHITE,Constant.COLOR_BLUE_DARK_1);
        exit.setColorPaint(Constant.COLOR_WHITE);
        exit.setBorder(BorderFactory.createEmptyBorder(0,25,0,0));
        exit.setActionCommand(Command.EXIT.toString());
        exit.addActionListener(actionListener);
        this.add(exit);

    }

    public void setVisibleLeft(boolean visibleLeft){
        this.setVisible(visibleLeft);
    }

    public int getPositionLeft(){
        int position = this.getX();
        if (position > -1){
            Utilities.moveLeft(0,-188,2,2,this);
            return 1;
        }else {
            Utilities.moveRight(-188,0,2,2,this);
            return -1;
        }
    }
}
