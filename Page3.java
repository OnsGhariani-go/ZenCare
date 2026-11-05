package ZenCare;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.sql.*;
public class Page3 extends JFrame {
	JPanel P,med,day,fin;
	JTextField des;
	JLabel matin,dejeuner,diner,t,m,j;
	JButton jt;
	JCheckBox mat,dej,din;
	
	public Page3() {
		super();
		setTitle(" ZenCare - Suivie medical");
		setSize(800,600);
		setLocationRelativeTo(null); // Pour centrer la fenêtre
		//couleurs
		Color bleuZen = new Color(0, 88, 128);
		Color vertSante = new Color(3, 130, 34);
		Color black = new Color(0, 0, 0);

		//panel general
		 P= new JPanel(new GridLayout(4,1));
		//panel titre et son label
		 t=new JLabel("Traitement... ");
		t.setForeground(black);
		t.setFont(new Font("Arial", 1, 24));
		j=new JLabel("n jours");
		 j.setFont(new Font("Arial", 1, 26));
		//panel medicament
		 med=new JPanel(new GridLayout(2,3));
		 m=new JLabel("Medicament N° : 1 ");
		m.setForeground(black);
		m.setFont(new Font("Arial", 1, 24));

		 day= new JPanel(new GridLayout(2,3));
		 matin=new JLabel("Le Matin :");
		matin.setFont(new Font("Arial", 1, 20));

		 dejeuner=new JLabel("Le Dejeuner");
		dejeuner.setFont(new Font("Arial", 1, 20));

		 diner=new JLabel("Le Diner");
		diner.setFont(new Font("Arial", 1, 20));

		 mat= new JCheckBox();
		 dej= new JCheckBox();
		 din= new JCheckBox();
		Border blackLine = BorderFactory.createLineBorder(Color.BLACK);
		
		day.setBorder(blackLine);
		med.add(m);
		med.setBorder(blackLine);
		day.add(matin);
		day.add(dejeuner);
		day.add(diner);
		day.add(mat);
		day.add(dej);
		day.add(din);
		med.add(day);
			
		//panel description
		 des=new JTextField();
		 Border ligneBleue = BorderFactory.createLineBorder(vertSante, 2);
	     TitledBorder titreBordure = BorderFactory.createTitledBorder(ligneBleue, " Observations du Patient ");
	     titreBordure.setTitleColor(vertSante);
	     titreBordure.setTitleFont(new Font("Arial", Font.ROMAN_BASELINE, 18));
	     des.setBorder(titreBordure);
		 fin=new JPanel(new GridLayout(1,2));
		
			jt= new JButton("Journée Terminée");
			jt.setFont(new Font("Arial", 1, 20));
	        jt.setBackground(bleuZen);
			jt.setForeground(black);
			jt.addActionListener(e -> {
			
		    try {
		        Connection con = Connexion.connecter();

		        String sql = "INSERT INTO medicament (Trait, Dure, Nommed, Dose, Jour, Temps, des) VALUES (?, ?, ?, ?, ?, ?, ?)";
		        PreparedStatement pst = con.prepareStatement(sql);

		       //on a ajouter date dans bilan
		        
		        LocalDate dateSysteme = LocalDate.now();
		        String dateString = dateSysteme.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		        
		        
		        
		        pst.setString(1, t.getText()); 
		        pst.setString(2,j.getText());               
		        pst.setString(3, m.getText());   
		        pst.setString(4,"1");           
		        pst.setString(5, dateString);      

		        // checkbox
		        String temps = "";
		        if (mat.isSelected()) temps += "Matin ";
		        if (dej.isSelected()) temps += "Dejeuner ";
		        if (din.isSelected()) temps += "Diner ";

		        pst.setString(6, temps);
		        pst.setString(7, des.getText());

		        pst.executeUpdate();

		        JOptionPane.showMessageDialog(null, "Données enregistrées !");
		        con.close();}

		      catch (Exception ex) {
		        ex.printStackTrace();}
			
		
		    new Page4();
		    dispose(); // ferme Page3
		});
		Connection con = Connexion.connecter();

		if (con == null) {
		    JOptionPane.showMessageDialog(null, "Erreur connexion BD !");
		    return;
		}
		
		try {
		    java.sql.Statement st = con.createStatement();

		    String sql = "SELECT * FROM medicament ORDER BY id DESC LIMIT 1";
		    ResultSet rs = st.executeQuery(sql);

		    if (rs.next()) {
		        t.setText(rs.getString("Trait"));
		        m.setText(rs.getString("Nommed"));
		        j.setText(rs.getString("Dure"));
		        String temps = rs.getString("Temps");

		        if (temps.contains("Matin")) {mat.setEnabled(false);}
		        if (temps.contains("Dejeuner")) {dej.setEnabled(false);}
		        if (temps.contains("Diner")) {din.setEnabled(false);}}


		    con.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}


		fin.add(jt);
		P.add(t);
		P.add(med);
		P.add(des);
		P.add(fin);
		this.add(P);
		this.setVisible(true);
	}
public static void main(String[]args) {
	new Page3();
}
}
