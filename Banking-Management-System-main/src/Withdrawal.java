import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener{

    JTextField t1;
    JButton b1,b2;
    JLabel l1,l2;
    private String pin;

    Withdrawal(String pin){

        this.pin=pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel jLabel = new JLabel(i3);
        jLabel.setBounds(0, 0, 960, 900);
        add(jLabel);


        l1 = new JLabel("MAXIMUM WITHDRAWAL IS RS.10,000");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        l2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.BOLD, 16));

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));

        b1 = new JButton("WITHDRAW");
        b2 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(190,290,400,20);
        jLabel.add(l1);

        l2.setBounds(230,350,400,20);
        jLabel.add(l2);

        t1.setBounds(190,400,330,40);
        jLabel.add(t1);

        b1.setBounds(390,480,150,30);
        jLabel.add(b1);

        b2.setBounds(390,520,150,30);
        jLabel.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setSize(960,1080);
        setLocation(360,0);
        setUndecorated(true);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae){

        try{

            if(ae.getSource()==b1){
                String amount = t1.getText();
                Date date = new Date();
                if(t1.getText().equals("")){

                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");

                }else{

                    Conn c1 = new Conn();

                    ResultSet rs = c1.statement.executeQuery(" select * from bank where pin = '"+pin+"' ");
                    double balance = 0;

                    //Calculating total balance
                    while(rs.next()){
                        if(rs.getString("mode").equals("Deposit")){
                            balance += Integer.parseInt(rs.getString("amount"));
                        }else{
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    //to check if withdrawal amount is less than total balance
                    if(balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }

                    // updating database in withdrawal mode
                    c1.statement.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");

                    setVisible(false);
                    new Transaction(pin).setVisible(true);

                }

            }else if(ae.getSource()==b2){

                new Transaction("").setVisible(true);
                setVisible(false);

            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }



    public static void main(String[] args){

        new Withdrawal("").setVisible(true);
    }
}
