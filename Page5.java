package ZenCare;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class Page5 extends JFrame implements ActionListener {
	JPanel P,P1,P2,PH;
	JLabel h,U,M,N,PR,DN,G,I;
	JTextField nt,prt,dnt,ut;
	JRadioButton F,H;
	JButton s;
	ButtonGroup bg;
	JPasswordField mt;
	
	public Page5() {
		super();
		setTitle("ZenCare - Page Inscription");
		setSize(1000,600);
		setLocationRelativeTo(null); // Pour centrer la fenêtre
		Color bleuZen = new Color(0, 88, 128);
		Color black = new Color(0, 0, 0);

		 P=new JPanel(new BorderLayout());
		P1=new JPanel(new FlowLayout(FlowLayout.CENTER));
		P2=new JPanel(new GridLayout(15,2));
		PH=new JPanel(new GridLayout(1,1));

        P.setBackground(new Color(255, 255, 255, 220));  
        P.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

		h=new JLabel(" Inscription sur ZenCare ");
		h.setFont(new Font("Arial", Font.BOLD, 36));
		h.setForeground(bleuZen);

		U=new JLabel(" Numero de telephone : ");
		U.setFont(new Font("Arial", 1, 14));
		
		M=new JLabel(" Password : ");
		M.setFont(new Font("Arial", 1, 14));
		N=new JLabel(" Nom: ");
		N.setFont(new Font("Arial", 1, 14));
		
		PR=new JLabel(" Prenom : ");
		PR.setFont(new Font("Arial", 1, 14));
		
		DN=new JLabel(" Date de Naissance : ");
		DN.setFont(new Font("Arial", 1, 14));
		
		G=new JLabel(" Sexe : ");
		G.setFont(new Font("Arial", 1, 14));
		
		
		new JLabel(" ");

		ImageIcon icon = new ImageIcon("C:\\Users\\onsgh\\OneDrive\\Desktop\\ZC.png");
		Image img = icon.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
		icon = new ImageIcon(img);
		
		nt=new JTextField();
		prt=new JTextField();
		dnt=new JTextField();
		F=new JRadioButton("Femme");
		H=new JRadioButton("Homme");
		bg=new ButtonGroup();
		
		bg.add(F);
		bg.add(H);
		ut=new JTextField();
		I=new JLabel(icon);
		mt=new JPasswordField();
		s=new JButton("S'insrire");
		s.setFont(new Font("Arial", 1, 20));
        s.setBackground(new Color(0, 102, 128));
		s.setForeground(black);

		s.addActionListener(this); 
            
		
        
		P1.add(I);
		PH.add(h);

		
		P2.add(N);
		P2.add(nt);

		
		P2.add(PR);
		P2.add(prt);
		
		P2.add(DN);
		P2.add(dnt);


		P2.add(G);
		P2.add(F);
		P2.add(H);
		P2.add(U);
		P2.add(ut);
		P2.add(M);
		P2.add(mt);
		P2.add(s);
		P.add(PH,BorderLayout.NORTH);
		P.add(P1,BorderLayout.WEST);
		P.add(P2,BorderLayout.CENTER);
		this.setContentPane(P);	
		this.setVisible(true);

	}
@Override 
public void actionPerformed(ActionEvent e) {
	String Nom = nt.getText();
    String Prenom = prt.getText();
    String Datenaiss = dnt.getText();
    String sexe="";
    if ( F.isSelected())
    	{sexe= "Femme" ;}
    else if (H.isSelected())
    	{sexe="Homme";}
    int tel = Integer.parseInt(ut.getText());
    String mdp = mt.getText();


    try {
        Connection con = Connexion.connecter();
        
        String sql = "INSERT INTO malade (Nom, Prenom, Datenaiss, Sexe, Tel, Mdp) VALUES (?, ?, ?, ?, ?, ?)";
        
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, Nom);
        pst.setString(2, Prenom);
        pst.setString(3, Datenaiss);
        pst.setString(4, sexe);
        pst.setInt(5, tel);
        pst.setString(6, mdp);
        int status = pst.executeUpdate();

        if (status > 0) {
            JOptionPane.showMessageDialog(this,"Compte ZenCare créé avec succès !");
            new Page1(); 
            this.dispose();
        }
        
        con.close();
    } catch (NumberFormatException nfe) {
        JOptionPane.showMessageDialog(this,"Le numéro de téléphone doit être composé uniquement de chiffres.");
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this,"Erreur lors de l'inscription : " + ex.getMessage());
    }
}
public static void main(String[]args) {
	new Page5();
}


}
