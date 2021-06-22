import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Transaction extends JFrame implements ActionListener {

    JLabel l1;
    JButton b1,b2,b4,b5,b6,b7;

    Transaction(String pin){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 960, 900);
        add(l2);

        l1 = new JLabel("Please Select Your Transaction");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        b1 = new JButton("DEPOSIT");
        b2 = new JButton("CASH WITHDRAWL");
        //b3 = new JButton("FAST CASH");
        b4 = new JButton("MINI STATEMENT");
        b5 = new JButton("PIN CHANGE");
        b6 = new JButton("BALANCE ENQUIRY");
        b7 = new JButton("EXIT");

        /*b1 = new JButton("DEPOSIT");
        b1.setFont(new Font("System", Font.BOLD, 18));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);*/

        /*b2 = new JButton("CASH WITHDRAWL");
        b2.setFont(new Font("System", Font.BOLD, 18));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);*/

       /* b3 = new JButton("FAST CASH");
        b3.setFont(new Font("System", Font.BOLD, 18));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE); */

        /*b4 = new JButton("MINI STATEMENT");
        b4.setFont(new Font("System", Font.BOLD, 18));
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);*/

        /*b5 = new JButton("PIN CHANGE");
        b5.setFont(new Font("System", Font.BOLD, 18));
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);*/

        /*b6 = new JButton("BALANCE ENQUIRY");
        b6.setFont(new Font("System", Font.BOLD, 18));
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);*/

        /*b7 = new JButton("EXIT");
        b7.setFont(new Font("System", Font.BOLD, 18));
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);*/


        setLayout(null);

        l1.setBounds(235,320,700,35);
        l2.add(l1);

        b1.setBounds(170,410,150,30);
        l2.add(b1);

        b2.setBounds(390,410,150,30);
        l2.add(b2);

        /*b3.setBounds(170,543,150,35);
        l2.add(b3);*/

        b4.setBounds(170,450,150,30);
        l2.add(b4);

        b5.setBounds(390,450,150,30);
        l2.add(b5);

        b6.setBounds(170,490,150,30);
        l2.add(b6);

        b7.setBounds(390,490,150,30);
        l2.add(b7);


        b1.addActionListener(this);
        b2.addActionListener(this);
        //b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);


        getContentPane().setBackground(Color.WHITE);

        setSize(960,1080);
        setLocation(360,0);
        setUndecorated(true);
        setVisible(true);



    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b1){

            new Deposit().setVisible(true);
            setVisible(false);

        }
        else if(ae.getSource()==b2){

            new Withdrawl().setVisible(true);
            setVisible(false);

        }
       /* else if(ae.getSource()==b3){

            new FastCash().setVisible(true);
            setVisible(false);

        }*/
        else if(ae.getSource()==b4){


            new MiniStatement().setVisible(true);
            setVisible(false);

        }else if(ae.getSource()==b5){

            new Pin().setVisible(true);
            setVisible(false);

        }else if(ae.getSource()==b6){

            String pinn = JOptionPane.showInputDialog("Enter PIN");
            Conn c1 = new Conn();

            try {

                ResultSet rs = c1.s.executeQuery(" SELECT balance FROM bank ORDER BY pin  = '"+pinn+"' DESC LIMIT 1");

                if(rs.next()){

                    String balance = rs.getString("balance");

                    JOptionPane.showMessageDialog(null,"Your Account Balance is "+balance);

                }



            } catch (Exception e) {

                e.printStackTrace();

            }




        }else if(ae.getSource()==b7){

            System.exit(0);

        }




    }

    public static void main(String[] args){
        new Transaction("").setVisible(true);
    }
}
