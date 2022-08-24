import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

class GUIMath implements ActionListener{

    private int FirstNum;
    private int SecondNum;
    private int Sum;
    private JFrame frame;
    private JLabel labelCW;
    private JLabel labelSum;
    private JPanel panel;
    private JTextField textField;
    private JButton button;
    private int CountC;
    private int CountW;

    public GUIMath(){
        Random random = new Random();
        FirstNum = random.nextInt(10);
        SecondNum = random.nextInt(10);
        Sum = FirstNum + SecondNum;
        CountC = 0;
        CountW = 0;

        frame = new JFrame("Gui Math");

        labelCW = new JLabel("Correct: " + Integer.toString(CountC) + " Wrong: " + Integer.toString(CountW));
        labelCW.setHorizontalAlignment(SwingConstants.CENTER);
        labelSum = new JLabel(Integer.toString(FirstNum) + " + " + Integer.toString(SecondNum) + " = ");
        labelSum.setHorizontalAlignment(SwingConstants.CENTER);

        textField = new JTextField(1);
        textField.setHorizontalAlignment(SwingConstants.CENTER);

        button = new JButton("Submit");
        button.addActionListener(this);
        
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0,1));
        panel.add(labelCW);
        panel.add(labelSum);
        panel.add(textField);
        panel.add(button);
        
        frame.add(panel, BorderLayout.NORTH);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int input = Integer.parseInt(textField.getText());
        if(input == Sum){
            CountC++;
            labelCW.setText("Correct: " + Integer.toString(CountC) + " Wrong: " + Integer.toString(CountW));
            Random random = new Random();
            FirstNum = random.nextInt(10);
            SecondNum = random.nextInt(10);
            labelSum.setText(Integer.toString(FirstNum) + " + " + Integer.toString(SecondNum));
        }
        else if(input != Sum){
            CountW++;
            labelCW.setText("Correct: " + Integer.toString(CountC) + " Wrong: " + Integer.toString(CountW));
            Random random = new Random();
            FirstNum = random.nextInt(10);
            SecondNum = random.nextInt(10);
            labelSum.setText(Integer.toString(FirstNum) + " + " + Integer.toString(SecondNum));
        }
        else{
            labelCW.setText("ERROR");
            labelSum.setText("ERROR");
        }
    }


    public static void main(String args[]) {

        new GUIMath();
    }

}