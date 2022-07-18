package utilities;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utilities {

    public static String toDecimalFormat( double value ) {
        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
        df.applyPattern( "$ ##############,###.##" );
        String strValue = df.format( value );
        return strValue;
    }

    public static void getModelColumn(JTable jTable, int numCol, int minWidth, int maxWidth, int preferWidth) {
        TableColumn column;
        column = jTable.getColumnModel().getColumn(numCol);
        column.setPreferredWidth(preferWidth);
        column.setMaxWidth(maxWidth);
        column.setMinWidth(minWidth);
    }

    public static void moveRight(int start,int end,long sleep,int jump,JPanel panel) {
        (new Thread() {
            public void run() {
                for(int i = start; i <= end; i += jump) {
                    try {
                        Thread.sleep(sleep);
                        panel.setLocation(i, panel.getY());
                    } catch (Exception var3) {
                        var3.printStackTrace();
                    }
                }

            }
        }).start();
    }

    public static void moveLeft(int start,int end,long sleep,int jump,JPanel panel) {
        (new Thread() {
            public void run() {
                for(int i = start; i >= end; i -= jump) {
                    try {
                        Thread.sleep(sleep);
                        panel.setLocation(i, panel.getY());
                    } catch (Exception var3) {
                        var3.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
