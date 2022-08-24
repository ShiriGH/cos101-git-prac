import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GuiMath implements ActionListener{

    private int count = 0;
    private JLabel label;
    private JFrame frame;
    private JButton button;
    private JPanel panel;

    public GuiMath() {

        frame = new JFrame();
        
        button = new JButton("Click Me");
        button.addActionListener(this);

        label = new JLabel("Number of Click: 0");

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("GUI Math");
        frame.pack();
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        new GuiMath();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        label.setText("Number of Click: " + Integer.toString(count));
    }
}