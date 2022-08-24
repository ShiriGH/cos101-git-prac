//GUIMath.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

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

        labelCW = new JLabel("Correct: " + str(CountC) + " Wrong: 0" + str(CountW));
        labelCW.setHorizontalAlignment(SwingConstants.CENTER);
        labelSum = new JLabel(str(FirstNum) + " + " + str(SecondNum) + " = ");
        labelSum = setHorizontalAlignment(SwingConstants.CENTER);

        textField = new JTextField(1);
        textField.setHorizontalAlignment(SwingConstants.CENTER);

        JButton button = new JButton("Submit");
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
            labelCW.setText("Correct: " + str(CountC) + " Wrong: " + str(CountW));
            FirstNum = random.nextInt(10);
            SecondNum = random.nextInt(10);
            labelSum.setText(str(FirstNum) + " + " + str(SecondNum));
        }
        else if(input != Sum){
            CountW++;
            labelCW.setText("Correct: " + str(CountC) + " Wrong: ") + str(CountW);
            FirstNum = random.nextInt(10);
            SecondNum = random.nextInt(10);
            labelSum.setText(str(FirstNum) + " + " + str(SecondNum))
        }
        else{
            labelCW.setText("ERROR");
            labelSum.setText("ERROR");
        }
    }


    public static void main(String args[]) {

        GUIMath gui = new GUIMath();
    }

}