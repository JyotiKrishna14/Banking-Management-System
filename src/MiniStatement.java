import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener{


    JButton b1;
    JLabel cardNo,bankName, jlabelStatement,bal;

    MiniStatement(String pin){
        super("Mini Statement");
        getContentPane().setBackground(Color.WHITE);
        setSize(400,600);
        setLocation(20,20);

        cardNo = new JLabel();
        cardNo.setBounds(20,80,400,20);
        add(cardNo);

        bankName = new JLabel("Indian Bank");
        bankName.setBounds(150, 20, 100, 20);
        add(bankName);

        jlabelStatement = new JLabel();
        jlabelStatement.setBounds(20, 100, 300, 200);
        add(jlabelStatement);

        bal = new JLabel();
        bal.setBounds(20, 470, 300, 20);
        add(bal);

        try{
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("select * from login where pin = '"+ pin +"'");
            while(rs.next()){
                cardNo.setText("Card Number:    " + rs.getString("cardno").substring(0, 4) + "XXXXXXXX" + rs.getString("cardno").substring(12));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        try{
            double balance = 0;
            Conn c1  = new Conn();
            ResultSet rs = c1.statement.executeQuery("SELECT * FROM bank where pin = '"+ pin +"'");
            while(rs.next()){
                jlabelStatement.setText(jlabelStatement.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("mode") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("mode").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            bal.setText("Your total Balance is Rs "+balance);
        }catch(Exception e){
            e.printStackTrace();
        }

        setLayout(null);
        b1 = new JButton("Exit");
        add(b1);

        b1.addActionListener(this);

        //cardNo.setBounds(20, 140, 400, 200);
        b1.setBounds(20, 500, 100, 25);
    }
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }

    public static void main(String[] args){
        new MiniStatement("").setVisible(true);
    }

}