package views.admin;

import controllers.Command;
import views.Constant;
import views.models.JModelButton;
import views.models.JModelButtonMenu;
import views.models.JModelLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JNorthPanel extends JPanel {

    private JModelButtonMenu jBMenu;
    private JModelButton products;

    public JNorthPanel(ActionListener actionListener) {
        this.setBackground(Constant.COLOR_GREEN_DARK_2);
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(2,30,2,5));
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        jBMenu = new JModelButtonMenu("",Constant.IMG_MENU,30,30);
        jBMenu.setActionCommand(Command.B_MENU.toString());
        jBMenu.addActionListener(actionListener);
        jBMenu.setColorNormal(Constant.COLOR_GREEN_DARK_2);
        jBMenu.setColorPressed(Constant.COLOR_GREEN_PRESSED);
        jBMenu.setColorHover(Constant.COLOR_GREEN_HOVER);
        this.add(jBMenu);

        add(Box.createRigidArea(new Dimension((int) (Constant.SCREEN_SIZE.getWidth()*0.01),0)));

        JModelLabel logo = new JModelLabel(Constant.IMG_BANNER,150,40);
        logo.setColorPaint(Constant.COLOR_GREEN_DARK_2);
        this.add(logo);
    }
}
