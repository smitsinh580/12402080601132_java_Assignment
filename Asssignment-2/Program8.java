
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Program8 extends JFrame implements ActionListener {

    JTextField principalField, rateField, timeField, resultField;
    JButton calculateBtn, clearBtn;

    Program8() {
        setTitle("Investment Calculator");

        // Labels
        JLabel l1 = new JLabel("Principal Amount:");
        JLabel l2 = new JLabel("Interest Rate (%):");
        JLabel l3 = new JLabel("Time (Years):");
        JLabel l4 = new JLabel("Total Amount:");

       
        principalField = new JTextField(10);
        rateField = new JTextField(10);
        timeField = new JTextField(10);
        resultField = new JTextField(10);
        resultField.setEditable(false);

        
        calculateBtn = new JButton("Calculate");
        clearBtn = new JButton("Clear");

       
        calculateBtn.addActionListener(this);
        clearBtn.addActionListener(this);

        
        setLayout(new GridLayout(5, 2, 10, 10));

        add(l1); add(principalField);
        add(l2); add(rateField);
        add(l3); add(timeField);
        add(l4); add(resultField);
        add(calculateBtn); add(clearBtn);

        
        setSize(350, 250);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Button actions
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == calculateBtn) {
                double p = Double.parseDouble(principalField.getText());
                double r = Double.parseDouble(rateField.getText());
                double t = Double.parseDouble(timeField.getText());

               
                double amount = p + (p * r * t) / 100;

                resultField.setText(String.valueOf(amount));
            }

            if (e.getSource() == clearBtn) {
                principalField.setText("");
                rateField.setText("");
                timeField.setText("");
                resultField.setText("");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers!");
        }
    }

    public static void main(String[] args) {
        new Program8();
    }
}
