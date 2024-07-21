package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin extends JFrame implements ActionListener {
    JButton b1,b2;
    JPasswordField P1,P2;
    String Pin;
    Pin(String pin){
        this.Pin=pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel label1 = new JLabel("CHANGE YOUR PIN");
        label1.setForeground(Color.white);
        label1.setFont(new Font("System",Font.BOLD,16));
        label1.setBounds(460,180,400,35);
        l3.add(label1);

        JLabel label2 = new JLabel("New PIN: ");
        label2.setForeground(Color.white);
        label2.setFont(new Font("System",Font.BOLD,16));
        label2.setBounds(430,220,150,35);
        l3.add(label2);

        P1= new JPasswordField();
        P1.setBackground(new Color(65,125,128));
        P1.setForeground(Color.white);
        P1.setBounds(600,220,180,25);
        P1.setFont(new Font("Raleways",Font.BOLD,22));
        l3.add(P1);


        JLabel label3 = new JLabel("Re-Enter New PIN: ");
        label3.setForeground(Color.white);
        label3.setFont(new Font("System",Font.BOLD,16));
        label3.setBounds(430,250,400,35);
        l3.add(label3);
        P2= new JPasswordField();
        P2.setBackground(new Color(65,125,128));
        P2.setForeground(Color.white);
        P2.setBounds(600,255,180,25);
        P2.setFont(new Font("Raleways",Font.BOLD,22));
        l3.add(P2);







        b1 = new JButton("CHANGE");
        b1.setBounds(700,362,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(700,406,150,35);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.white);
        b2. addActionListener(this);
        l3.add(b2);






        setSize(1550,1080);
        setLayout(null);
        setLocation(0,0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            String pin1=P1.getText();
            String pin2 = P2.getText();

            if (!pin1.equals(pin2)){
                JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                return;
            }
            if (e.getSource()==b1){
                if (P1.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Enter New PIN");
                    return;

                }
                if (P2.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Re-Enter New PIN");
                    return;

                }
                cone c = new cone();
                String q1 = "update bank set pin = '"+pin1+"' where pin = '"+Pin+"'";
                String q2 = "update login set pin = '"+pin1+"' where pin = '"+Pin+"'";
                String q3 = "update signup3 set pin = '"+pin1+"' where pin = '"+Pin+"'";

                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                c.statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null,"PIN changed successfully");
                setVisible(false);
                new main_Class(Pin);

            } else if (e.getSource()==b2) {
                new main_Class(Pin);
                setVisible(false);

            }

        }catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Pin("");

    }
}
