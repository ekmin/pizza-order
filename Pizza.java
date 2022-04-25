import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
public class Pizza implements ActionListener{
JLabel l0,l1,l2;
JTextField tf1,tf2;
JCheckBox cb1,cb2,cb3,cb4,cb5;
JTextArea area;
JRadioButton r1,r2,r3;
JButton b;
Font font1 = new Font("SansSerif", Font.BOLD, 20);
Font font2 = new Font("SansSerif", Font.PLAIN, 20);

String s;
String pay;

Pizza() {
JFrame.setDefaultLookAndFeelDecorated(true);
JFrame f= new JFrame("Pizza Order");

l2=new JLabel("Order Pizza");
l2.setBounds(370,20,150,30);
l2.setFont(font1);


l0=new JLabel("Name");
l0.setBounds(450,70,100,30);
l1=new JLabel("Contact No");
l1.setBounds(450,140,100,30);


tf1 = new JTextField();
tf1.setBounds(450, 105, 160, 30);
tf2 = new JTextField();
tf2.setBounds(450, 175, 160, 30);

r1 = new JRadioButton("Small");
r1.setBounds(450,210,100,30);
r2 = new JRadioButton("Medium");
r2.setBounds(450,250,100,30);
r3 = new JRadioButton("Large");
r3.setBounds(450,290,100,30);
ButtonGroup bg=new ButtonGroup();
bg.add(r1);bg.add(r2);bg.add(r3);

cb1 = new JCheckBox("Pizza");
cb1.setBounds(640,105,100,30);
cb1.addActionListener(this);
cb2 = new JCheckBox("Garlic Bread");
cb2.setBounds(640,140,100,30);
cb2.addActionListener(this);
cb3 = new JCheckBox("Chicken Rice");
cb3.setBounds(640,175,100,30);
cb3.addActionListener(this);
cb4 = new JCheckBox("Chicken Fry");
cb4.setBounds(640,210,100,30);
cb4.addActionListener(this);
cb5 = new JCheckBox("Pasta");
cb5.setBounds(640,245,100,30);
cb5.addActionListener(this);

String payment[]={"Cash","Card","Cheque","QR Scan"};
JComboBox<String> cb = new JComboBox<String>(payment);
cb.setBounds(450,330,100,30);

s = (String)cb.getSelectedItem();

cb.addActionListener(new ActionListener() {
	 
    @Override
    public void actionPerformed(ActionEvent event) {
        JComboBox<String> combo = (JComboBox<String>) event.getSource();
        String selectedBook = (String) combo.getSelectedItem();
 
        if (selectedBook.equals("Cash")) {
            pay = "Cash";
        } else if (selectedBook.equals("Card")) {
            pay = "Card";
        }else if (selectedBook.equals("Cheque")) {
            pay = "Cheque";
        }else if (selectedBook.equals("QR Scan")) {
            pay = "QR Scan";
        }
    }
});

area=new JTextArea();
area.setBounds(20,75,400,350);
area.setEditable(false);
area.setFont(font2);

b=new JButton("Count Words");
b.setBounds(100,300,120,30);


f.add(l0);f.add(l1);f.add(l2);f.add(tf1);f.add(tf2);f.add(area);f.add(b);f.add(r1);f.add(r2);f.add(r3);f.add(cb1);f.add(cb2);f.add(cb3);f.add(cb4);f.add(cb5);f.add(cb);
f.setSize(800,500);
f.setLayout(null);
f.setVisible(true);
}

public void actionPerformed(ActionEvent e){
	String name = tf1.getText();
	String contact = tf2.getText();
	String size = "";
	String pizza= "";
	String bread= "";
	String rice= "";
	String fry= "";
	String pasta= "";
	
	if(pay == null) {
		JOptionPane.showMessageDialog(area,"Please selecet the payment method again");
	}
	
	if(r1.isSelected()) {
		size = "Small";

	}else if(r2.isSelected()) {
		size = "Medium";

	}else if(r3.isSelected()) {
		size = "Large";
		
	}else{
		JOptionPane.showMessageDialog(area,"Select the size before select the Food");
	
	}if(cb1.isSelected()) {
		pizza = " Pizza";

	}if(cb2.isSelected()) {
		bread = " Garlic Bread";
	
	}if(cb3.isSelected()) {
		rice = " Chicken Rice";
	
	}if(cb4.isSelected()) {
		fry = " Chicken Fry";
	
	}if(cb5.isSelected()) {
		pasta = " Pasta";
	}
	
	String data = "Customer name  : " + name + "\nContact Number  : " + contact + "\nPizza Size            : " + size + "\nItem ordered        :" + pizza + bread + rice + fry + pasta + "\nPayment Method : " + pay;
	
	area.setText(data);

}
public static void main(String[] args) {
new Pizza();
}
}