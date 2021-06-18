import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JLabel l1,l2,l3;
    JTextField jTextField;
    JPasswordField jPasswordField;
    JButton jButton1,jButton2,jButton3;
    Login(){


        setTitle("Banking Management System");
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel jLabel = new JLabel(i3);
        jLabel.setBounds(70,20,100,100);
        add(jLabel);

        l1 = new JLabel("WELCOME TO BANK");
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        l1.setBounds(200,40,450,40);
        add(l1);

        l2 = new JLabel("Card No:");
        l2.setFont(new Font("Raleway", Font.BOLD, 28));
        l2.setBounds(125,150,375,30);
        add(l2);

        jTextField = new JTextField(15);
        jTextField.setBounds(300,150,230,30);
        jTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(jTextField);

        l3 = new JLabel("PIN:");
        l3.setFont(new Font("Raleway", Font.BOLD, 28));
        l3.setBounds(125,220,375,30);
        add(l3);

        jPasswordField = new JPasswordField(15);
        jPasswordField.setFont(new Font("Arial", Font.BOLD, 14));
        jPasswordField.setBounds(300,220,230,30);
        add(jPasswordField);

        jButton1 = new JButton("SIGN IN");
        jButton1.setBackground(Color.BLACK);
        jButton1.setForeground(Color.WHITE);

        jButton2 = new JButton("CLEAR");
        jButton2.setBackground(Color.BLACK);
        jButton2.setForeground(Color.WHITE);

        jButton3 = new JButton("SIGN UP");
        jButton3.setBackground(Color.BLACK);
        jButton3.setForeground(Color.WHITE);

        setLayout(null);

        jButton1.setFont(new Font("Arial", Font.BOLD, 14));
        jButton1.setBounds(300,300,100,30);
        add(jButton1);

        jButton2.setFont(new Font("Arial", Font.BOLD, 14));
        jButton2.setBounds(430,300,100,30);
        add(jButton2);

        jButton3.setFont(new Font("Arial", Font.BOLD, 14));
        jButton3.setBounds(300,350,230,30);
        add(jButton3);

        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        jButton3.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);

        setSize(800,480);
        setLocation(550,200);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        try{
            if(ae.getSource()==jButton1){
                conn c1 = new conn();
                String cardno  = jTextField.getText();
                String pin  = jPasswordField.getText();
                String q  = "select * from login where cardno = '"+cardno+"' and pin = '"+pin+"'";

                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next()){
                    setVisible(false);
                    new Transaction().setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            }else if(ae.getSource()==jButton2){
                jTextField.setText("");
                jPasswordField.setText("");
            }else if(ae.getSource()==jButton3){
                setVisible(false);
                new Signup().setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){

        new Login().setVisible(true);
    }
}
