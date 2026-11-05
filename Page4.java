package ZenCare;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class Page4 extends JFrame  {
	JPanel P1,P2,P,PL,P3,D1,Im,Pmed1;
	JLabel j,t,I,b,date,med1,des,d;
	JCheckBox mat1,dej1,din1;
	
	
	
	public Page4() {
	super();
		setTitle("Bilan ZenCare ");
		setSize(800, 700);
		setLocationRelativeTo(null); // Pour centrer la fenêtre
        
    	// pour les couleurs 
		Color vertSante = new Color(3, 130, 34);
		
		 P1=new JPanel(new GridLayout(3,2));
		 P2=new JPanel(new GridLayout(2,1));
		 P=new JPanel(new GridLayout(3,1));
		 PL=new JPanel(new GridLayout(1,2));
		 P3=new JPanel(new GridLayout(1,1));

		//grid du p2
		 D1=new JPanel(new GridLayout(3,2));
		//partie description
		 des=new JLabel();
        des.setBorder(BorderFactory.createTitledBorder("Description"));//ecrire en haut des
        Border ligneBleue = BorderFactory.createLineBorder(vertSante, 2);
        TitledBorder titreBordure = BorderFactory.createTitledBorder(ligneBleue, " Observations du Patient ");
        titreBordure.setTitleColor(vertSante);
        titreBordure.setTitleFont(new Font("Arial", Font.ITALIC, 12));
        des.setBorder(titreBordure);
		
        ImageIcon icon = new ImageIcon("C:\\Users\\onsgh\\OneDrive\\Desktop\\ZC.png");
		Image img = icon.getImage().getScaledInstance(200,100, Image.SCALE_SMOOTH);
		icon = new ImageIcon(img);
		 I = new JLabel(icon);
		 Im = new JPanel(new BorderLayout());
		Im.add(I,BorderLayout.CENTER);

		
         b=new JLabel("Bilan Final: ");
		b.setFont(new Font("Arial", Font.BOLD, 14));
		b.setForeground(vertSante);
		b.setFont(new Font("Segoe UI", Font.BOLD, 18));
		
		 t=new JLabel("Traitement ");
		 t.setFont(new Font("Arial", 1, 26));

		 j=new JLabel("n jours");
		 j.setFont(new Font("Arial", 1, 26));


		//partie date
		  date=new JLabel ("Date");
		date.setFont(new Font("Arial", Font.BOLD, 20));
		date.setForeground(vertSante);
		date.setBackground(Color.WHITE); 

		
		  d=new JLabel(" ");
			d.setForeground(vertSante);
			d.setBackground(Color.WHITE); 
			 d.setFont(new Font("Arial", 1, 26));

		  
		 med1=new JLabel("  Medicament N° 1");
		med1.setFont(new Font("Segoe UI", Font.BOLD, 18));

		 Pmed1=new JPanel(new GridLayout(1,3));


		 mat1= new JCheckBox("Matin");
		 dej1= new JCheckBox("Dejeuner");
		 din1= new JCheckBox("Diner");

		 
		 
		 
		 
		Border blackLine = BorderFactory.createLineBorder(Color.BLACK);//creation ligne noir
		date.setBorder(blackLine);
		d.setBorder(blackLine);
		med1.setBorder(blackLine);//pour ajouter des bordures

		Pmed1.setBorder(blackLine);

		mat1.setBorder(blackLine); dej1.setBorder(blackLine); din1.setBorder(blackLine);
		
		
		
		
		try {
		    Connection con = Connexion.connecter();
		    java.sql.Statement st = con.createStatement();

		    String sql = "SELECT*FROM medicament ORDER BY id DESC LIMIT 1";
		    ResultSet rs = st.executeQuery(sql);

		    if (rs.next()) {
		        t.setText(rs.getString("Trait"));
		        j.setText(rs.getString("Dure"));
		        med1.setText(rs.getString("Nommed"));
		        des.setText(rs.getString("des"));
		        d.setText(rs.getString("Jour"));
		        String temps = rs.getString("Temps");
		         
		        if(temps!=null) {
		        if (temps.contains("Matin")) {mat1.setSelected(true);}
		        if (temps.contains("Dejeuner")) {dej1.setSelected(true);}
		        if (temps.contains("Diner")) {din1.setSelected(true);}
		        }
		        
		        mat1.setEnabled(false);
		        dej1.setEnabled(false);
		        din1.setEnabled(false);
		}

		    con.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}
		//ajout image au panel
		P1.add(b);
		P1.add(Im);
		PL.add(t);
		PL.add(j);
		P1.add(PL);
		//tableau
		D1.add(date);
		D1.add(d);
		D1.add(med1);
		Pmed1.add(mat1);
		Pmed1.add(dej1);
		Pmed1.add(din1);
		D1.add(Pmed1);

		P2.add(D1,BorderLayout.SOUTH);
		P3.add(des);

		P.add(P1,BorderLayout.NORTH);
		P.add(P2,BorderLayout.CENTER);
		P.add(P3,BorderLayout.SOUTH);

		this.add(P);
		this.setVisible(true);
	
	}
	public static void main(String[]args) {
		new Page4();
		
	}
}
