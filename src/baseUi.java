import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class baseUi {
    private JPanel     mainPanel;
    private JButton    itemFieldSet;
    private JLabel     farmingLabel;
    private JTextField itemEntryField;
    private JTextPane  currentItem;
    private JButton    incrementRunCount;
    private JButton    decrementRunCount;
    private JTextPane  runNum;
    private JButton    resetTextFields;
    private int        currentRunNumber;
    private String     runLabel = "Run: ";

    public baseUi() {

        //All action listeners perform given function on button press, this being ActionEvent e
        itemFieldSet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setItemEntryField();
            }
        });

        currentRunNumber = 0;

        incrementRunCount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentRunNumber < 0) currentRunNumber = 0;
                else currentRunNumber++;
                    runNum.setText(String.valueOf(runLabel + currentRunNumber));
            }
        });

        decrementRunCount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentRunNumber < 0) currentRunNumber = 0;
                else currentRunNumber--;
                    runNum.setText(String.valueOf(runLabel + currentRunNumber));
            }
        });

        resetTextFields.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentItem.setText("");
                itemEntryField.setText("");
                runNum.setText(runLabel);
            }
        });
    }

    public void setItemEntryField() {
        if (itemEntryField.isVisible()) {
            currentItem.setText(itemEntryField.getText());
            itemEntryField.setVisible(false);
                mainPanel.revalidate();
                mainPanel.repaint();
        } else if (!itemEntryField.isVisible()) {
            itemEntryField.setVisible(true);
                mainPanel.revalidate();
                mainPanel.repaint();
        } else {
            currentItem.setText("ERROR IN DISPLAYING ENTRY FIELD");
        }
    }

    private static JFrame createInterface() {
        JFrame tempFrame = new JFrame("Farming Counter");
            Dimension appSize = Toolkit.getDefaultToolkit().getScreenSize();
            tempFrame.setSize(appSize.width / 4, appSize.height / 4);//MAY NOT FIT ALL SCREEN SIZES PROPERLY
            tempFrame.setContentPane(new baseUi().mainPanel);
            tempFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return tempFrame;
    }

    public static void main(String[] args) {
        JFrame userInterface = createInterface();
        userInterface.setVisible(true);
    }

}