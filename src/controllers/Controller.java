package controllers;

import models.Store;
import views.JMainWindows;

import java.awt.event.*;
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
            default -> Logger.getGlobal().severe("Error");
        }
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
