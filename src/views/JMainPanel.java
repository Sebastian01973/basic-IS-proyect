package views;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class JMainPanel extends JPanel {

    public JMainPanel(ActionListener actionListener, MouseListener mouseListener) {
        this.setBackground(Constant.COLOR_GREEN);
    }
}
