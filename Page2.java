package ZenCare;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
public class Page2 extends JFrame implements ActionListener{ 
	JPanel P,P1,P2,P3,PH;
	JLabel h,Trait,Dure,Med,Dose,Matin,Midi,Diner,Avant,ACours,Apres,I;
	JTextField tt,dt,medt,dos;
	JCheckBox mat,mid,din;
	JRadioButton av,ac,ap;
	ButtonGroup bg;
	JButton s;
	
	
    public Page2(){
    	super();
    setTitle("ZenCare - Page donnes");
	setSize(1000,600);
	setLocationRelativeTo(null); 
	Color bleuZen = new Color(0, 88, 128);
	Color vertSante = new Color(3, 130, 34);
	Color black = new Color(0, 0, 0);


	 P=new JPanel(new BorderLayout());
	P1=new JPanel(new BorderLayout());
	P2=new JPanel(new GridLayout(9,1));
	P3=new JPanel(new GridLayout(6,2));


	 PH=new JPanel(new GridLayout(1,1));

    P.setBackground(new Color(255, 255, 255, 220));  
    P.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

	h=new JLabel(" Page de donnes sur ZenCare ");
	h.setFont(new Font("Arial", Font.BOLD, 36));
	h.setForeground(vertSante);
	
	Trait=new JLabel(" Nom du Traitement :  ");
	 tt = new JTextField();
	Trait.setFont(new Font("Arial", Font.BOLD, 24));
	Trait.setForeground(black);
	Trait.setBackground(Color.WHITE); 
	
	
	 Dure=new JLabel(" Durée Du Traiement :  ");
	 dt = new JTextField();
	Dure.setFont(new Font("Arial", Font.BOLD, 24));
	Dure.setForeground(black);
	Dure.setBackground(Color.WHITE); 
	
	 Med=new JLabel(" Nom du Medicament :  ");
	 medt = new JTextField();
	Med.setFont(new Font("Arial", Font.BOLD, 24));
	Med.setForeground(black);
	Med.setBackground(Color.WHITE); 
	
	
	 Dose=new JLabel(" Dosage:  ");
	 dos = new JTextField();
	Dose.setFont(new Font("Arial", Font.BOLD, 24));
	Dose.setForeground(black);
	Dose.setBackground(Color.WHITE); 
	
	
	 Matin=new JLabel("   Matin : ");
	Matin.setFont(new Font("Arial", Font.BOLD, 20));
	Matin.setForeground(bleuZen);
	 mat = new JCheckBox();
	
	
	 Midi=new JLabel("   Dejeuner : ");
	Midi.setFont(new Font("Arial", Font.BOLD, 20));
	Midi.setForeground(bleuZen);
	 mid = new JCheckBox();
	
	
	 Diner=new JLabel("   Diner : ");
	Diner.setFont(new Font("Arial", Font.BOLD, 20));
	Diner.setForeground(bleuZen);
	 din = new JCheckBox();
	
	 Avant=new JLabel("   Avant le Repas : ");
	Avant.setFont(new Font("Arial", Font.BOLD, 20));
	Avant.setForeground(bleuZen);
	av = new JRadioButton();
	
	 ACours=new JLabel("   Au Cours du Repas : ");
	ACours.setFont(new Font("Arial", Font.BOLD, 20));
	ACours.setForeground(bleuZen);
	 ac = new JRadioButton();
	
	 Apres=new JLabel("   Apres le Repas : ");
	Apres.setFont(new Font("Arial", Font.BOLD, 20));
	Apres.setForeground(bleuZen);
	 ap = new JRadioButton();
	
	 bg = new ButtonGroup();
	bg.add(av);
	bg.add(ac);
	bg.add(ap);
	
	 s=new JButton("Sauvgarder");
	s.setFont(new Font("Arial", Font.BOLD, 14));

	s.addActionListener(this);
	
	ImageIcon icon = new ImageIcon("C:\\Users\\onsgh\\OneDrive\\Desktop\\ZC.png");
	Image img = icon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
	icon = new ImageIcon(img);
	 I = new JLabel(icon);
    
	P1.add(I);
	PH.add(h);


	P3.add(Trait);
	P3.add(tt);
	P3.add(Dure);
	P3.add(dt);
	P3.add(Med);
	P3.add(medt);
	P3.add(Dose);
	P3.add(dos);
	

	P2.add(Matin);
	P2.add(mat);

	P2.add(Midi);
	P2.add(mid);
	
	P2.add(Diner);
	P2.add(din);
	
	
	P2.add(Avant);
	P2.add(av);
	P2.add(ACours);
	P2.add(ac);
	P2.add(Apres);
	P2.add(ap);
	P2.add(s);
	
	P.add(PH,BorderLayout.NORTH);
	P.add(P1,BorderLayout.WEST);
	P.add(P3,BorderLayout.CENTER);
	P.add(P2,BorderLayout.PAGE_END);

	this.setContentPane(P);	
	this.setVisible(true);}
	
@Override
        public void actionPerformed(ActionEvent e) {
        	String trait = tt.getText();
            String dure = dt.getText();
            String Nommed = medt.getText();
            int dose = Integer.parseInt(dos.getText());

            String jour ="" ;
    		if( mat.isSelected()) jour+= "Matin"; 
    		if( mid.isSelected()) jour+= "Midi"; 
    		if( din.isSelected()) jour+= "Diner"; 

    		String temps ="" ; 
    		if( av.isSelected()) temps= "Avant Repas"; 
    		else if( ac.isSelected()) temps= "Au Cours du Repas"; 
    		else if( ap.isSelected()) temps= "Apres le Repas"; 
    		else temps = "Non précisé";

            try {
                Connection con = Connexion.connecter();
                
                String sql = "INSERT INTO medicament (Trait, Dure, Nommed,Dose,Jour,Temps) VALUES (?, ?, ?, ?, ?,?)";
                
                PreparedStatement st = con.prepareStatement(sql);
                st.setString(1, trait);
                st.setString(2, dure);
                st.setString(3, Nommed);
                st.setInt(4, dose);
                st.setString(5, jour);
                st.setString(6, temps);

                int status = st.executeUpdate();

                if (status > 0) {
                    JOptionPane.showMessageDialog(this, "Donneés sauvgardées avec succès ");
                    new Page3(); 
                    this.dispose();
                
                con.close();}
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(this, "La Durée du taritement doit etre par chiffre .");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erreur lors de l'inscription : " + ex.getMessage());
            }
        
	

}
    	
    public static void main(String[] args){
        new Page2();
    

}}