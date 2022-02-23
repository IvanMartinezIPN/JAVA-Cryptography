import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class mainframe extends JFrame {

	private static JPanel contentPane;
	private JTextField varn;
	private JTextField alpha;
	private JTextField beta;
	private static JTextField alphas;
	private JButton calcular;
	static double mcd=0,x=0,y=0;
	private static JTextField varp;
	private static JTextField betas;
	private static JTextField alphas2;
	private static JTextField varC;
	private static JTextField betas2;
	private static JTextField n1;
	private static JTextField n2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainframe frame = new mainframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public mainframe() {
		setTitle("Practica 2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Euclides", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 10, 602, 357);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Introduce N:");
		lblNewLabel.setBounds(10, 29, 105, 24);
		panel.add(lblNewLabel);
		
		varn = new JTextField();
		varn.setBounds(125, 32, 96, 19);
		panel.add(varn);/*variable de n*/
		varn.setColumns(10);
		
		JLabel lblIntroduceAlpha = new JLabel("Introduce alpha:");
		lblIntroduceAlpha.setBounds(10, 77, 105, 24);
		panel.add(lblIntroduceAlpha);
		
		alpha = new JTextField();
		alpha.setColumns(10);
		alpha.setBounds(125, 80, 96, 19);
		panel.add(alpha);/*variable de aplha*/
		
		JLabel textfield3 = new JLabel("Introduce beta:");
		textfield3.setBounds(10, 127, 105, 24);
		panel.add(textfield3);
		
		beta = new JTextField();
		beta.setColumns(10);
		beta.setBounds(125, 130, 96, 19);
		panel.add(beta);
		
		calcular = new JButton("calcular");
		calcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( !(varn.getText().isEmpty()) && !(Pattern.matches("[a-zA-Z]+", varn.getText())) ) {/*ER*/
					if(!(alpha.getText().isEmpty()) && !(Pattern.matches("[a-zA-Z]+", alpha.getText())) ) {
						if(!(beta.getText().isEmpty()) && !(Pattern.matches("[a-zA-Z]+", beta.getText()))) {
							int alphaTemp, betaTemp,nTemp;
							nTemp = Integer.parseInt(varn.getText());
							alphaTemp = Integer.parseInt(alpha.getText());
							betaTemp = Integer.parseInt(beta.getText());
							validar(nTemp,alphaTemp, betaTemp);/*manda*/
						} else {
							JOptionPane.showMessageDialog(contentPane, "Error, Beta no puedo estar vacio y deben ser solo numero (0-9)");
						}
					} else {
						JOptionPane.showMessageDialog(contentPane, "Error, Alpha no puede estar vacio y deben ser solo numero (0-9)");
					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "Error, N no puede estar vacio y deben ser solo numero (0-9)");
				}
				
			}
		});
		calcular.setBounds(362, 225, 85, 21);
		panel.add(calcular);
		
		JLabel lblNewLabel_1_1 = new JLabel("Salidas");
		lblNewLabel_1_1.setBounds(10, 161, 116, 23);
		panel.add(lblNewLabel_1_1);
		
		alphas = new JTextField();
		alphas.setColumns(10);
		alphas.setBounds(30, 191, 48, 19);
		panel.add(alphas);
		
		varp = new JTextField();
		varp.setBounds(88, 191, 54, 19);
		panel.add(varp);
		varp.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("C:");
		lblNewLabel_1.setBounds(10, 194, 15, 13);
		panel.add(lblNewLabel_1);
		
		betas = new JTextField();
		betas.setBounds(152, 191, 69, 19);
		panel.add(betas);
		betas.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("P:");
		lblNewLabel_2.setBounds(10, 229, 15, 13);
		panel.add(lblNewLabel_2);
		
		alphas2 = new JTextField();
		alphas2.setColumns(10);
		alphas2.setBounds(30, 226, 48, 19);
		panel.add(alphas2);
		
		varC = new JTextField();
		varC.setColumns(10);
		varC.setBounds(88, 226, 54, 19);
		panel.add(varC);
		
		betas2 = new JTextField();
		betas2.setColumns(10);
		betas2.setBounds(152, 226, 69, 19);
		panel.add(betas2);
		
		n1 = new JTextField();
		n1.setBounds(280, 191, 63, 19);
		panel.add(n1);
		n1.setColumns(10);
		
		JLabel jlabel1 = new JLabel("mod");
		jlabel1.setBounds(225, 194, 45, 13);
		panel.add(jlabel1);
		
		JLabel jlabel1_1 = new JLabel("mod");
		jlabel1_1.setBounds(225, 229, 45, 13);
		panel.add(jlabel1_1);
		
		n2 = new JTextField();
		n2.setBounds(280, 226, 63, 19);
		panel.add(n2);
		n2.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Equipo 10:");
		lblNewLabel_3.setBounds(384, 35, 63, 13);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Jeon Jeong Paola");
		lblNewLabel_4.setBounds(384, 58, 136, 13);
		panel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Mart\u00EDnez Alvarado Jos\u00E9 Iv\u00E1n");
		lblNewLabel_5.setBounds(384, 77, 168, 13);
		panel.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Profesora:");
		lblNewLabel_6.setBounds(384, 100, 116, 13);
		panel.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Cortez Duarte Nidia Asuncion");
		lblNewLabel_7.setBounds(384, 118, 178, 13);
		panel.add(lblNewLabel_7);
	}
	
	public static int validar(int nTemp, int alphaTemp, int betaTemp) {
		if (0 < betaTemp && betaTemp <= nTemp ) {
			if(mcdAlphaN(alphaTemp, nTemp) == 1) {
				long[] resultado = euclidesExt(alphaTemp, nTemp);
				alphas.setText(String.valueOf(alphaTemp));
				varp.setText(String.valueOf(resultado[1] + " +"));
				betas.setText(String.valueOf(betaTemp));
				n1.setText(String.valueOf(nTemp));
				alphas2.setText(String.valueOf(resultado[2]));
				varC.setText(String.valueOf(resultado[0] + " +" ));
				betas2.setText(String.valueOf("( " +"-"  + betaTemp + ")"));
				n2.setText(String.valueOf(nTemp));
				/*alphas.setText(String.valueOf("a: "+resultado[0] +" x2: "+ resultado[1] +" y2: "+ resultado[2]));*/
				/*euclidesext.setText(String.valueOf(euclidesExtendidoRe(alphaTemp,betaTemp,mcd,x,y)));*/
			} else {
				JOptionPane.showMessageDialog(contentPane, "Error MCD, no es = a 1. Ingrese un valor diferente");
			}
		} else {
			JOptionPane.showMessageDialog(contentPane, "Error BETA, no pertenece a N");
		}
			
		return 0;
	}
	
	public static int mcdAlphaN(int alphaTemp, int nTemp) {
		while ( alphaTemp != nTemp) {
			if (alphaTemp < nTemp) 
				nTemp = nTemp - alphaTemp;
			 else 
				alphaTemp = alphaTemp - nTemp;
		}
		return alphaTemp;
	}
	
	public static long[] euclidesExt(double alphaTemp, double nTemp) {
		long a = (long) alphaTemp, b = (long) nTemp;
		 long[] resp = new long[3];
		 long x=0,y=0,d=0;
		 if(b==0)
		 {
		  resp[0] = a; resp[1] = 1; resp[2] = 0;
		 } 
		 else
		 {
		  long x2 = 1, x1 = 0, y2 = 0, y1 = 1;
		  long q = 0, r = 0;
		  while(b>0)
		  {
		   q = (a/b);
		   r = a - q*b;
		   x = x2-q*x1;
		   y = y2 - q*y1;
		   a = b;
		   b = r;
		   x2 = x1;
		   x1 = x;
		   y2 = y1;
		   y1 = y;
		  }
		  resp[0] = a;
		  resp[1] = x2;
		  resp[2] = y2;
		    }
		 return resp;  
		
	}
	
	//mcd=0,x=0,y=0 en un inicio
	public static double euclidesExtendidoRe(double alphaTemp, double betaTemp,double mcd,double x, double y)
	{     
	        double x2=0.0,y2=0.0,x1=0.0,y1=0.0;
	        if (betaTemp == 0)  {  
	            mcd = alphaTemp;
	            x2 = 1;
	            y2 = 0;
	        }
	        else
	        {     
	            euclidesExtendidoRe (betaTemp,alphaTemp%betaTemp,mcd,x,y);
	            x1= x2; y1=y2; x2=y1;
	            y2=x1- (alphaTemp/betaTemp)*y1;   
	        }
	        return mcd;
	} 
}
