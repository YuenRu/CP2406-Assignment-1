package com.org.transport;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;


//Main window: Contains the settings of traffic light parameters, and the frequency of vehicles generated at the north and south intersections
public class SettingGui extends JFrame {
    static JTextField redText;
    static JTextField greenText;
    static JTextField delayText;
    static JTextField SNText;
    static JTextField EWText;


    public SettingGui() {
        getContentPane().setLayout(null);

        redText = new JTextField();
        redText.setBounds(400, 87, 86, 21);
        getContentPane().add(redText);
        redText.setColumns(10);

        //Set the start button. When you click the start button, draw a traffic map according to the set parameters.
        JButton startButton = new JButton("Start simulation");
        startButton.setBounds(165, 332, 200, 23);
        getContentPane().add(startButton);

        greenText = new JTextField();
        greenText.setBounds(400, 136, 86, 21);
        getContentPane().add(greenText);
        greenText.setColumns(10);

        JLabel redLabel = new JLabel("Red light duration");
        redLabel.setBounds(73, 90, 143, 15);
        getContentPane().add(redLabel);

        JLabel greenLabel = new JLabel("Green light duration");
        greenLabel.setBounds(73, 139, 143, 15);
        getContentPane().add(greenLabel);

        Component verticalGlue = Box.createVerticalGlue();
        verticalGlue.setBounds(62, 87, 1, 1);
        getContentPane().add(verticalGlue);

        delayText = new JTextField();
        delayText.setBounds(400, 181, 86, 21);
        getContentPane().add(delayText);
        delayText.setColumns(10);

        JLabel delayLabel = new JLabel("Green light delay time");
        delayLabel.setBounds(73, 184, 160, 15);
        getContentPane().add(delayLabel);

        JLabel lblNewLabel = new JLabel("Intersection between North and South intersections");
        lblNewLabel.setBounds(73, 235, 350, 15);
        getContentPane().add(lblNewLabel);

        SNText = new JTextField();
        SNText.setBounds(400, 232, 86, 21);
        getContentPane().add(SNText);
        SNText.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Vehicle gap at east-west intersection");
        lblNewLabel_1.setBounds(73, 282, 250, 15);
        getContentPane().add(lblNewLabel_1);

        EWText = new JTextField();
        EWText.setBounds(400, 279, 86, 21);
        getContentPane().add(EWText);
        EWText.setColumns(10);

        JLabel label = new JLabel("Traffic activity simulation system");
        label.setFont(new Font("Times New Roman", Font.BOLD, 16));
        label.setBounds(128, 33, 250, 15);
        getContentPane().add(label);


        this.setSize(600, 450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        SimpleListener ourListener = new SimpleListener();
        startButton.addActionListener(ourListener);
    }

    //Click on the start button. When the start button is clicked, the FrameDemo class of the new drawing window is created.
    private class SimpleListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            // TODO Auto-generated method stub

            FrameDemo demo = new FrameDemo();
        }

    }

    public static void main(String[] args) {
        SettingGui demo = new SettingGui();
    }
}