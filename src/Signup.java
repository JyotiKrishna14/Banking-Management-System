import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
// importing package for calender
import com.toedter.calendar.JDateChooser;
public class Signup extends JFrame implements ActionListener {

    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JRadioButton maleBtn,femaleBtn,r3,r4,r5;
    JButton b;
    JDateChooser jDateChooser;


    Random ran = new Random();
    long random = (ran.nextLong() % 9000L) + 1000L;
    long first = Math.abs(random);



    Signup(){

        setTitle("NEW ACCOUNT APPLICATION FORM");

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel jLabel = new JLabel(i3);
        jLabel.setBounds(20,0,100,100);
        add(jLabel);





        l1 = new JLabel("APPLICATION FORM NO. "+first);
        l1.setFont(new Font("Raleway", Font.BOLD, 38));

        l2 = new JLabel("Page 1: Personal Details");
        l2.setFont(new Font("Raleway", Font.BOLD, 22));

        l3 = new JLabel("Name:");
        l3.setFont(new Font("Raleway", Font.BOLD, 20));

        l4 = new JLabel("Father's Name:");
        l4.setFont(new Font("Raleway", Font.BOLD, 20));

        l5 = new JLabel("Date of Birth:");
        l5.setFont(new Font("Raleway", Font.BOLD, 20));

        l6 = new JLabel("Gender:");
        l6.setFont(new Font("Raleway", Font.BOLD, 20));

        l7 = new JLabel("Email Address:");
        l7.setFont(new Font("Raleway", Font.BOLD, 20));

        l8 = new JLabel("Marital Status:");
        l8.setFont(new Font("Raleway", Font.BOLD, 20));

        l9 = new JLabel("Address:");
        l9.setFont(new Font("Raleway", Font.BOLD, 20));

        l10 = new JLabel("City:");
        l10.setFont(new Font("Raleway", Font.BOLD, 20));

        l11 = new JLabel("Pin Code:");
        l11.setFont(new Font("Raleway", Font.BOLD, 20));

        l12 = new JLabel("State:");
        l12.setFont(new Font("Raleway", Font.BOLD, 20));

        l13 = new JLabel("Date");
        l13.setFont(new Font("Raleway", Font.BOLD, 14));

        l14 = new JLabel("Month");
        l14.setFont(new Font("Raleway", Font.BOLD, 14));

        l15 = new JLabel("Year");
        l15.setFont(new Font("Raleway", Font.BOLD, 14));


        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 14));

        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 14));

        t3 = new JTextField();
        t3.setFont(new Font("Raleway", Font.BOLD, 14));

        t4 = new JTextField();
        t4.setFont(new Font("Raleway", Font.BOLD, 14));

        t5 = new JTextField();
        t5.setFont(new Font("Raleway", Font.BOLD, 14));

        t6 = new JTextField();
        t6.setFont(new Font("Raleway", Font.BOLD, 14));

        t7 = new JTextField();
        t7.setFont(new Font("Raleway", Font.BOLD, 14));



        b = new JButton("Next");
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);

        maleBtn = new JRadioButton("Male");
        maleBtn.setFont(new Font("Raleway", Font.BOLD, 14));
        maleBtn.setBackground(Color.WHITE);

        femaleBtn = new JRadioButton("Female");
        femaleBtn.setFont(new Font("Raleway", Font.BOLD, 14));
        femaleBtn.setBackground(Color.WHITE);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(maleBtn);
        buttonGroup.add(femaleBtn);

        r3 = new JRadioButton("Married");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(Color.WHITE);

        r4 = new JRadioButton("Unmarried");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(Color.WHITE);

        r5 = new JRadioButton("Other");
        r5.setFont(new Font("Raleway", Font.BOLD, 14));
        r5.setBackground(Color.WHITE);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(r3);
        maritalGroup.add(r4);
        maritalGroup.add(r5);


        jDateChooser = new JDateChooser();
        jDateChooser.setForeground(new Color(105,105,105));

        setLayout(null);
        l1.setBounds(140,20,600,40);
        add(l1);

        l2.setBounds(290,70,600,30);
        add(l2);

        l3.setBounds(100,140,100,30);
        add(l3);

        t1.setBounds(300,140,400,30);
        add(t1);

        l4.setBounds(100,190,200,30);
        add(l4);

        t2.setBounds(300,190,400,30);
        add(t2);

        l5.setBounds(100,240,200,30);
        add(l5);

        jDateChooser.setBounds(300,240,400,30);
        add(jDateChooser);



        maleBtn.setBounds(300,290,60,30);
        add(maleBtn);

        femaleBtn.setBounds(450,290,90,30);
        add(femaleBtn);

        l7.setBounds(100,340,200,30);
        add(l7);

        t3.setBounds(300,340,400,30);
        add(t3);

        l8.setBounds(100,390,200,30);
        add(l8);

        r3.setBounds(300,390,100,30);
        add(r3);

        r4.setBounds(450,390,100,30);
        add(r4);

        r5.setBounds(635,390,100,30);
        add(r5);

        l9.setBounds(100,440,200,30);
        add(l9);

        t4.setBounds(300,440,400,30);
        add(t4);

        l10.setBounds(100,490,200,30);
        add(l10);

        t5.setBounds(300,490,400,30);
        add(t5);

        l11.setBounds(100,540,200,30);
        add(l11);

        t6.setBounds(300,540,400,30);
        add(t6);

        l12.setBounds(100,590,200,30);
        add(l12);

        t7.setBounds(300,590,400,30);
        add(t7);

        b.setBounds(620,660,80,30);
        add(b);

        b.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);

        setSize(850,785);
        setLocation(370,25);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        long customerId = first;
        String name = t1.getText();
        String fname = t2.getText();
        String date = ((JTextField)jDateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;

        if(maleBtn.isSelected()){
            gender = "Male";
        }
        else if(femaleBtn.isSelected()){
            gender = "Female";
        }

        String email = t3.getText();
        String marital = null;
        if(r3.isSelected()){
        marital = "Married";
    }else if(r4.isSelected()){
        marital = "Unmarried";
    }else if(r5.isSelected()){
        marital = "Other";
    }

        String address = t4.getText();
        String city = t5.getText();
        String pincode = t6.getText();
        String state = t7.getText();


        try{

        if(t6.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Fill all the required fields");
        }else{

            Conn c1 = new Conn();
            String q1 = "insert into signup values('"+customerId+"','"+name+"','"+fname+"','"+date+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
            c1.statement.executeUpdate(q1);

            new Signup2(customerId).setVisible(true);
            setVisible(false);
        }

    }catch(Exception ex){
        ex.printStackTrace();
    }

}


    public static void main(String[] args){
        new Signup().setVisible(true);
    }
}
