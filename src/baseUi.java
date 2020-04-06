import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class baseUi {
    private JPanel mainPanel;
    private JButton itemSet;
    private JLabel farming;
    private JTextField itemCurr;
    private JTextPane item;
    private JButton inc;
    private JButton dec;
    private JTextPane runNum;
    private JButton reset;
    private int currRun;
    private String runLabel = "Run: ";

    public baseUi(){
        itemSet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){setItemEntryField();}
        });
        currRun = 0;
        inc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currRun<0)currRun = 0; else currRun++; runNum.setText(String.valueOf(runLabel + currRun));
            }
        });
        dec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currRun<0)currRun = 0;else currRun--; runNum.setText(String.valueOf(runLabel+currRun)); }
        });
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { item.setText("");
            itemCurr.setText("");runNum.setText(runLabel); }
        });
    }
    public void setItemEntryField ()
    {
        if (itemCurr.isVisible())
        { item.setText(itemCurr.getText());
        itemCurr.setVisible(false);
        mainPanel.revalidate();
        mainPanel.repaint();

        }
        else if (!itemCurr.isVisible())
        { itemCurr.setVisible(true);
        mainPanel.revalidate();
        mainPanel.repaint(); }
        else
        { item.setText("ERROR IN DISPLAYING ENTRY FIELD"); }
    }

    public static void main (String[] args) {
        JFrame frame = new JFrame ("Farming Counter");
    Dimension appSize = Toolkit.getDefaultToolkit().getScreenSize();
    frame.setSize(appSize.width/4,appSize.height/4);
    frame.setContentPane(new baseUi().mainPanel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    }

}
