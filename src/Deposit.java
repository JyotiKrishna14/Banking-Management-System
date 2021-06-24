import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    JTextField t1;
    JButton b1,b2,b3;
    JLabel l1;
    private String pin;

    Deposit(String pin){

        this.pin=pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel jLabel = new JLabel(i3);
        jLabel.setBounds(0, 0, 960, 900);
        add(jLabel);


        l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setForeground(Color.white);
        l1.setFont(new Font("System", Font.BOLD, 16));

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));

        b1 = new JButton("DEPOSIT");
        b2 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(190,290,400,35);
        jLabel.add(l1);

        t1.setBounds(190,350,320,40);
        jLabel.add(t1);

        b1.setBounds(390,480,150,30);
        jLabel.add(b1);

        b2.setBounds(390,520,150,30);
        jLabel.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setSize(960,1080);
        setUndecorated(true);
        setLocation(500,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        try{
            if(ae.getSource()==b1){
                String amount = t1.getText();
                Date date = new Date();
                if(t1.getText().equals("")){

                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");

                }else{

                    Conn c1 = new Conn();
                    c1.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Deposit', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposited Successfully");
                    setVisible(false);
                    new Transaction(pin).setVisible(true);

                }

            }else if(ae.getSource()==b2){

                setVisible(false);
                new Transaction(pin).setVisible(true);

            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){

        new Deposit("").setVisible(true);
    }

}
