import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pin extends JFrame implements ActionListener{

    JPasswordField t1,t2,t3;
    JButton b1,b2;
    JLabel l1,l2,l3;
    private String pin;

    Pin(String pin){
        this.pin=pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel jLabel = new JLabel(i3);
        jLabel.setBounds(0, 0, 960, 900);
        add(jLabel);


        l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setForeground(Color.WHITE);

        l2 = new JLabel("New PIN:");
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setForeground(Color.WHITE);

        l3 = new JLabel("Re-Enter New PIN:");
        l3.setFont(new Font("System", Font.BOLD, 16));
        l3.setForeground(Color.WHITE);

        t1 = new JPasswordField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));

        t2 = new JPasswordField();
        t2.setFont(new Font("Raleway", Font.BOLD, 25));

        b1 = new JButton("CHANGE");
        b2 = new JButton("BACK");

        b1.addActionListener(this);
        b2.addActionListener(this);

        setLayout(null);

        l1.setBounds(280,280,800,35);
        jLabel.add(l1);

        l2.setBounds(180,350,150,35);
        jLabel.add(l2);

        l3.setBounds(180,395,200,35);
        jLabel.add(l3);

        t1.setBounds(350,350,180,25);
        jLabel.add(t1);

        t2.setBounds(350,395,180,25);
        jLabel.add(t2);

        b1.setBounds(390,480,150,30);
        jLabel.add(b1);

        b2.setBounds(390,520,150,30);
        jLabel.add(b2);

        setSize(960,1080);
        setLocation(360,0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){

        try{

            String newPin = t1.getText();
            String rPin = t2.getText();

            if(!newPin.equals(rPin)){
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }

            if(ae.getSource()==b1){
                if (t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                }
                if (t2.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                }

                Conn c1 = new Conn();
                String q1 = "update bank set pin = '"+rPin+"' where pin = '"+pin+"' ";
                String q2 = "update login set pin = '"+rPin+"' where pin = '"+pin+"' ";
                String q3 = "update signup3 set pin = '"+rPin+"' where pin = '"+pin+"' ";

                c1.statement.executeUpdate(q1);
                c1.statement.executeUpdate(q2);
                c1.statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transaction(rPin).setVisible(true);

            }else if(ae.getSource()==b2){
                new Transaction(pin).setVisible(true);
                setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }




    public static void main(String[] args){
        new Pin("").setVisible(true);
    }
}
