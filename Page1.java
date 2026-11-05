
package ZenCare;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.sql.*;
public class Page1 extends JFrame implements ActionListener {
	JPanel P,P1,P2,PH;
	JLabel h,U,M,v,I;
	JTextField ut;
	JPasswordField mt;
	JButton s,i;
	
	public Page1() {
		super();
		setTitle("ZenCare - Page Authentification");
		setSize(1000,600);
		setLocationRelativeTo(null); // Pour centrer la fenêtre
		Color bleuZen = new Color(0, 88, 128);
		Color black = new Color(0, 0, 0);

		
		 P=new JPanel(new BorderLayout());
		 P1=new JPanel(new FlowLayout(FlowLayout.CENTER));
		 P2=new JPanel(new GridLayout(9,1));
		 PH=new JPanel(new GridLayout(1,1));

        P.setBackground(new Color(255, 255, 255, 220));  
        P.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

		h=new JLabel(" Bienvenu sur ZenCare ");
		h.setFont(new Font("Segoe UI", Font.BOLD, 36));
		h.setForeground(bleuZen);

		U=new JLabel(" Numero de Telephone : ");
		U.setFont(new Font("Segoe UI", 1, 20));
		
		 M=new JLabel(" Password : ");
		 M.setFont(new Font("Segoe UI", 1, 20));
		 v = new JLabel("\n ");
		 i=new JButton("s'inscrire");
			i.setFont(new Font("Segoe UI", 1, 20));
	        i.setBackground(bleuZen);
			i.setForeground(black);
		 i.addActionListener(this);

		ImageIcon icon = new ImageIcon("C:\\Users\\onsgh\\OneDrive\\Desktop\\ZC.png");
		Image img = icon.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
		icon = new ImageIcon(img);
		
		
		ut=new JTextField();
		 I = new JLabel(icon);
		mt=new JPasswordField();
		s=new JButton("se connecter");
		s.setFont(new Font("Segoe UI", 1, 20));
        s.setBackground(bleuZen);
		s.setForeground(black);
		s.addActionListener(this);
		
		P1.add(I);
		PH.add(h);
		P2.add(U);
		P2.add(ut);
		P2.add(M);
		P2.add(mt);
		P2.add(v);
		P2.add(s);
		P2.add(i);
		P.add(PH,BorderLayout.NORTH);
		P.add(P1,BorderLayout.WEST);
		P.add(P2,BorderLayout.CENTER);

		this.setContentPane(P);	
		this.setVisible(true);
}
@Override		
		    public void actionPerformed(ActionEvent e) {
	if (e.getSource() == i) {
		new Page5();    
		this.dispose();}
	if (e.getSource() == s) {
		        String telephoneSaisi = ut.getText();
		        String motDePasseSaisi = new String(mt.getPassword());

		        try {
		            Connection con = Connexion.connecter(); 
		            
		            String sql = "SELECT * FROM malade WHERE Tel = ? AND Mdp = ?";
		            
		            PreparedStatement pst = con.prepareStatement(sql);
		            
		            pst.setInt(1, Integer.parseInt(telephoneSaisi));
		            pst.setString(2, motDePasseSaisi);
		            
		            ResultSet rs = pst.executeQuery();

		            if (rs.next()) {
		                String Prenom = rs.getString("Prenom");
		                JOptionPane.showMessageDialog(this, "Bienvenue " + Prenom + " Sur ZenCare");
		                
		                new Page2();  
		                this.dispose();
		            }
		            con.close();

		        } catch (NumberFormatException nfe) {
		            JOptionPane.showMessageDialog(this, "Le numéro de téléphone doit être valide.");
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(this, "Erreur de connexion : " + ex.getMessage());
		        }
		   
	}}
	


public static void main(String[]args) {
	new Page1();
}}


