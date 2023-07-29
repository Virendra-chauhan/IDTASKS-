// package JButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class CalculatorDemo implements ActionListener{
    private JFrame frame;
    private JTextArea t1;
    private JButton one,two,three,four,five,six,seven,eight,nine,zero,add,sub,div,multi,equal,point,btnC;

    //for store values...
    String s0,s1,s2;

    CalculatorDemo(){
        frame = new JFrame();
        frame.setSize(350,460);
        frame.setLayout(null);
        frame.setTitle("Calculator Demo");
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(java.awt.Color.gray);

        try {
			// set look and feel
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}


        t1 = new JTextArea();
        t1.setBounds(10, 10, 330, 50);
        t1.setFont(new Font("Arial", Font.BOLD, 20));
        t1.setLineWrap(true);
        frame.add(t1);

        seven = new JButton("7");
        seven.setBounds(10,80,60,50);
        seven.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(seven);

        eight = new JButton("8");
        eight.setBounds(100,80,60,50);
        eight.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(eight);

        nine = new JButton("9");
        nine.setBounds(190,80,60,50);
        nine.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(nine);

        add = new JButton("+");
        add.setBounds(280,80, 60,50);
        add.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(add);

        four = new JButton("4");
        four.setBounds(10,150,60,50);
        four.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(four);

        five = new JButton("5");
        five.setBounds(100,150,60,50);
        five.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(five);

        six = new JButton("6");
        six.setBounds(190,150,60,50);
        six.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(six);

        sub = new JButton("-");
        sub.setBounds(280,150, 60,50);
        sub.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(sub);

        one = new JButton("1");
        one.setBounds(10,220,60,50);
        one.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(one);

        two = new JButton("2");
        two.setBounds(100,220,60,50);
        two.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(two);

        three = new JButton("3");
        three.setBounds(190,220,60,50);
        three.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(three);

        multi = new JButton("*");
        multi.setBounds(280,220,60,50);
        multi.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(multi);

        zero = new JButton("0");
        zero.setBounds(10,290,60,50);
        zero.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(zero);

        point = new JButton(".");
        point.setBounds(100,290,60,50);
        point.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(point);

        div = new JButton("/");
        div.setBounds(190,290,60,50);
        div.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(div);

        equal = new JButton("=");
        equal.setBounds(280,290,60,50);
        equal.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(equal);

        btnC = new JButton("C");
        btnC.setBounds(10,360,330,50);
        btnC.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(btnC);

        zero.addActionListener(this);
        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        four.addActionListener(this);
        five.addActionListener(this);
        six.addActionListener(this);
        seven.addActionListener(this);
        eight.addActionListener(this);
        nine.addActionListener(this);
        point.addActionListener(this);
        equal.addActionListener(this);
        add.addActionListener(this);
        sub.addActionListener(this);
        multi.addActionListener(this);
        div.addActionListener(this);
        btnC.addActionListener(this);

        s0 = s1 = s2 = "";

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        // if value is numbers...
        if((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.'){
            if(s1.equals("")){
                s0 = s0 + s;  
            }
            else{
                s2 = s2 + s;
            }
            t1.setText(s0+s1+s2);
        }

        //For equal 
        else if (s.charAt(0) == '=') {
 
            double te;
 
            // store the value in 1st
            if (s1.equals("+"))
                te = (Double.parseDouble(s0) + Double.parseDouble(s2));
            else if (s1.equals("-"))
                te = (Double.parseDouble(s0) - Double.parseDouble(s2));
            else if (s1.equals("/"))
                te = (Double.parseDouble(s0) / Double.parseDouble(s2));
            else
                te = (Double.parseDouble(s0) * Double.parseDouble(s2));
 
            // set the value of text
            t1.setText(s0 + s1 + s2 + "=" + te);

            // convert it to string
            s0 = Double.toString(te);
 
            s1 = s2 = "";
        }

        // clear the letters
        else if (s.charAt(0) == 'C') {
            s0 = s1 = s2 = "";
            t1.setText(s0 + s1 + s2);
        }
        
        else {
            // if there was no operand
            if (s1.equals("") || s2.equals(""))
                s1 = s;
            // else evaluate
            else {
                double te;
 
                // store the value in 1st
                if (s1.equals("+"))
                    te = (Double.parseDouble(s0) + Double.parseDouble(s2));
                else if (s1.equals("-"))
                    te = (Double.parseDouble(s0) - Double.parseDouble(s2));
                else if (s1.equals("/"))
                    te = (Double.parseDouble(s0) / Double.parseDouble(s2));
                else
                    te = (Double.parseDouble(s0) * Double.parseDouble(s2));
 
                // convert it to string
                s0 = Double.toString(te);
 
                // place the operator
                s1 = s;
 
                // make the operand blank
                s2 = "";
            }
 
            // set the value of text
            t1.setText(s0 + s1 + s2);
        }


        
    }

    public static void main(String[] args) {
        CalculatorDemo cd = new CalculatorDemo();
    
    }

    
}
