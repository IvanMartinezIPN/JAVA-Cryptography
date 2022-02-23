import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.awt.event.ActionEvent;

public class mainframe extends JFrame {

	private JPanel contentPane;
	private JTextField llave;
	private JTextField vector;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	static SecretKey myDesKey;
	static Cipher desCipher;

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
 
	public static int ECB(String llaveTemp, byte[] vectorTemp, File archivoElegido) throws IOException, InvalidAlgorithmParameterException  {
			
			try{
				//SecretKey myDesKey;
				//Cipher desCipher;

			    KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
			    myDesKey = keygenerator.generateKey();
			    
			    AlgorithmParameterSpec paramSpec = new IvParameterSpec(vectorTemp);

			    // Create the cipher 
			    desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			    
			    // Initialize the cipher for encryption
			    desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
			    
			    //sensitive information
			    //byte[] text = "No body can see me".getBytes();
			    File inputFile = new File(archivoElegido.getAbsolutePath());
			    BufferedImage input = ImageIO.read(inputFile);
			    /*
			    byte [] text = extractBytes(new File(archivoElegido.getAbsolutePath()));

			    System.out.println("Text [Byte Format] : " + text);
			    System.out.println("Text : " + new String(text));
			   
			    // Encrypt the text
			    textEncrypted = desCipher.doFinal(text);

			    System.out.println("Text Encryted : " + textEncrypted);
			    */
			    FileOutputStream output = new FileOutputStream("C:\\Users\\josei\\Downloads\\Practica3Crypto\\image_eECB.bmp");
			   // FileOutputStream output = new FileOutputStream("C:\\Users\\Jeong Paola\\Desktop\\\\ImagenesP3DES\\image_eECB.bmp");
			    CipherOutputStream cos = new CipherOutputStream(output, desCipher);
			    // File outputFile = new File("image.png");
			    ImageIO.write(input, "BMP", cos);
			    cos.close();
			    
			    // Initialize the same cipher for decryption
			    //desCipher.init(Cipher.DECRYPT_MODE, myDesKey);

			    // Decrypt the text
			   // byte[] textDecrypted = desCipher.doFinal(textEncrypted);
			    
			    //System.out.println("Text Decryted : " + new String(textDecrypted));
			    
			}catch(NoSuchAlgorithmException e){
				e.printStackTrace();
			}catch(NoSuchPaddingException e){
				e.printStackTrace();
			}catch(InvalidKeyException e){
				e.printStackTrace();
			}
			return 0; 
		   
		}
	
	public static int CBC(String llaveTemp, byte[] vectorTemp, File archivoElegido) throws IOException, InvalidAlgorithmParameterException  {
		
		try{
			//SecretKey myDesKey;
			//Cipher desCipher;

		    KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
		    myDesKey = keygenerator.generateKey();
		    
		    AlgorithmParameterSpec paramSpec = new IvParameterSpec(vectorTemp);

		    // Create the cipher 
		    desCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		    
		    // Initialize the cipher for encryption
		    desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
		    
		    //sensitive information
		    //byte[] text = "No body can see me".getBytes();
		    File inputFile = new File(archivoElegido.getAbsolutePath());
		    BufferedImage input = ImageIO.read(inputFile);
		    /*
		    byte [] text = extractBytes(new File(archivoElegido.getAbsolutePath()));

		    System.out.println("Text [Byte Format] : " + text);
		    System.out.println("Text : " + new String(text));
		   
		    // Encrypt the text
		    textEncrypted = desCipher.doFinal(text);

		    System.out.println("Text Encryted : " + textEncrypted);
		    */
		    FileOutputStream output = new FileOutputStream("C:\\Users\\josei\\Downloads\\Practica3Crypto\\image_eCBC.bmp");
		    CipherOutputStream cos = new CipherOutputStream(output, desCipher);
		    // File outputFile = new File("image.png");
		    ImageIO.write(input, "BMP", cos);
		    cos.close();
		    
		    // Initialize the same cipher for decryption
		    //desCipher.init(Cipher.DECRYPT_MODE, myDesKey);

		    // Decrypt the text
		   // byte[] textDecrypted = desCipher.doFinal(textEncrypted);
		    
		    //System.out.println("Text Decryted : " + new String(textDecrypted));
		    
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}catch(NoSuchPaddingException e){
			e.printStackTrace();
		}catch(InvalidKeyException e){
			e.printStackTrace();
		}
		return 0; 
	   
	}
	
public static int CFB(String llaveTemp, byte[] vectorTemp, File archivoElegido) throws IOException, InvalidAlgorithmParameterException  {
		
		try{
			SecretKey myDesKey;
			Cipher desCipher;
		    KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
		    myDesKey = keygenerator.generateKey();
		    
		    AlgorithmParameterSpec paramSpec = new IvParameterSpec(vectorTemp);

		    // Create the cipher 
		    desCipher = Cipher.getInstance("DES/CFB/PKCS5Padding");
		    
		    // Initialize the cipher for encryption
		    desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
		    
		    //sensitive information
		    //byte[] text = "No body can see me".getBytes();
		    File inputFile = new File(archivoElegido.getAbsolutePath());
		    BufferedImage input = ImageIO.read(inputFile);
		    /*
		    byte [] text = extractBytes(new File(archivoElegido.getAbsolutePath()));

		    System.out.println("Text [Byte Format] : " + text);
		    System.out.println("Text : " + new String(text));
		   
		    // Encrypt the text
		    textEncrypted = desCipher.doFinal(text);

		    System.out.println("Text Encryted : " + textEncrypted);
		    */
		    FileOutputStream output = new FileOutputStream("C:\\Users\\josei\\Downloads\\Practica3Crypto\\image_eCFB.bmp");
		    CipherOutputStream cos = new CipherOutputStream(output, desCipher);
		    // File outputFile = new File("image.png");
		    ImageIO.write(input, "BMP", cos);
		    cos.close();
		    
		    // Initialize the same cipher for decryption
		    //desCipher.init(Cipher.DECRYPT_MODE, myDesKey);

		    // Decrypt the text
		   // byte[] textDecrypted = desCipher.doFinal(textEncrypted);
		    
		    //System.out.println("Text Decryted : " + new String(textDecrypted));
		    
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}catch(NoSuchPaddingException e){
			e.printStackTrace();
		}catch(InvalidKeyException e){
			e.printStackTrace();
		}
		return 0; 
	   
	}

public static int OFB(String llaveTemp, byte[] vectorTemp, File archivoElegido) throws IOException, InvalidAlgorithmParameterException  {
	
	try{
		SecretKey myDesKey;
		Cipher desCipher;
	    KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
	    myDesKey = keygenerator.generateKey();
	    
	    AlgorithmParameterSpec paramSpec = new IvParameterSpec(vectorTemp);

	    // Create the cipher 
	    desCipher = Cipher.getInstance("DES/OFB/PKCS5Padding");
	    
	    // Initialize the cipher for encryption
	    desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
	    
	    //sensitive information
	    //byte[] text = "No body can see me".getBytes();
	    File inputFile = new File(archivoElegido.getAbsolutePath());
	    BufferedImage input = ImageIO.read(inputFile);
	    /*
	    byte [] text = extractBytes(new File(archivoElegido.getAbsolutePath()));

	    System.out.println("Text [Byte Format] : " + text);
	    System.out.println("Text : " + new String(text));
	   
	    // Encrypt the text
	    textEncrypted = desCipher.doFinal(text);

	    System.out.println("Text Encryted : " + textEncrypted);
	    */
	    FileOutputStream output = new FileOutputStream("C:\\Users\\josei\\Downloads\\Practica3Crypto\\image_eOFB.bmp");
	    CipherOutputStream cos = new CipherOutputStream(output, desCipher);
	    // File outputFile = new File("image.png");
	    ImageIO.write(input, "BMP", cos);
	    cos.close();
	    
	    // Initialize the same cipher for decryption
	    //desCipher.init(Cipher.DECRYPT_MODE, myDesKey);

	    // Decrypt the text
	   // byte[] textDecrypted = desCipher.doFinal(textEncrypted);
	    
	    //System.out.println("Text Decryted : " + new String(textDecrypted));
	    
	}catch(NoSuchAlgorithmException e){
		e.printStackTrace();
	}catch(NoSuchPaddingException e){
		e.printStackTrace();
	}catch(InvalidKeyException e){
		e.printStackTrace();
	}
	return 0; 
}
	
	public static int DECB(SecretKey myDesKey, Cipher desCipher) throws IOException, InvalidAlgorithmParameterException  {
		try{
			//SecretKey myDesKey;
			//Cipher desCipher;
			File archivoElegido = null;
			JFileChooser fc = new JFileChooser();
	        //Mostrar la ventana para abrir archivo y recoger la respuesta
	        //En el parámetro del showOpenDialog se indica la ventana
	        //  al que estará asociado. Con el valor this se asocia a la
	        //  ventana que la abre.
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Imágenes BMP", "bmp");
			fc.setFileFilter(filter);
	        int respuesta = fc.showOpenDialog(null);
	        //Comprobar si se ha pulsado Aceptar
	        if (respuesta == JFileChooser.APPROVE_OPTION) {
	            //Crear un objeto File con el archivo elegido
	        	 archivoElegido = fc.getSelectedFile();
				//Mostrar el nombre del archvivo en un campo de texto
	            //narch.setText(archivoElegido.getName());
	        }
	        
 		    File inputFile = new File(archivoElegido.getAbsolutePath());
		    BufferedImage input = ImageIO.read(inputFile);
		    // Initialize the same cipher for decryption
		    desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
		    
		    FileOutputStream output = new FileOutputStream("C:\\Users\\josei\\Downloads\\Practica3Crypto\\image_dECB.bmp");
		    CipherOutputStream cos = new CipherOutputStream(output, desCipher);
		    // File outputFile = new File("image.png");
		    ImageIO.write(input, "BMP", cos);
		    cos.close();

		    // Decrypt the text
		   //byte[] textDecrypted = desCipher.doFinal(textEncrypted);
		    
		}catch(InvalidKeyException e){
			e.printStackTrace();
		}
		return 0; 
	   
	}
	
	public static int DCBC(SecretKey myDesKey, Cipher desCipher) throws IOException, InvalidAlgorithmParameterException  {
		try{
			//SecretKey myDesKey;
			//Cipher desCipher;
			File archivoElegido = null;
			JFileChooser fc = new JFileChooser();
	        //Mostrar la ventana para abrir archivo y recoger la respuesta
	        //En el parámetro del showOpenDialog se indica la ventana
	        //  al que estará asociado. Con el valor this se asocia a la
	        //  ventana que la abre.
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Imágenes BMP", "bmp");
			fc.setFileFilter(filter);
	        int respuesta = fc.showOpenDialog(null);
	        //Comprobar si se ha pulsado Aceptar
	        if (respuesta == JFileChooser.APPROVE_OPTION) {
	            //Crear un objeto File con el archivo elegido
	        	 archivoElegido = fc.getSelectedFile();
				//Mostrar el nombre del archvivo en un campo de texto
	            //narch.setText(archivoElegido.getName());
	        }
	        
 		    File inputFile = new File(archivoElegido.getAbsolutePath());
		    BufferedImage input = ImageIO.read(inputFile);
		    // Initialize the same cipher for decryption
		    desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
		    
		    FileOutputStream output = new FileOutputStream("C:\\Users\\josei\\Downloads\\Practica3Crypto\\image_dCBC.bmp");
		    CipherOutputStream cos = new CipherOutputStream(output, desCipher);
		    // File outputFile = new File("image.png");
		    ImageIO.write(input, "BMP", cos);
		    cos.close();

		    // Decrypt the text
		   //byte[] textDecrypted = desCipher.doFinal(textEncrypted);
		    
		}catch(InvalidKeyException e){
			e.printStackTrace();
		}
		return 0; 
	   
	}
	
	public static int DCFB(SecretKey myDesKey, Cipher desCipher) throws IOException, InvalidAlgorithmParameterException  {
		try{
			//SecretKey myDesKey;
			//Cipher desCipher;
			File archivoElegido = null;
			JFileChooser fc = new JFileChooser();
	        //Mostrar la ventana para abrir archivo y recoger la respuesta
	        //En el parámetro del showOpenDialog se indica la ventana
	        //  al que estará asociado. Con el valor this se asocia a la
	        //  ventana que la abre.
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Imágenes BMP", "bmp");
			fc.setFileFilter(filter);
	        int respuesta = fc.showOpenDialog(null);
	        //Comprobar si se ha pulsado Aceptar
	        if (respuesta == JFileChooser.APPROVE_OPTION) {
	            //Crear un objeto File con el archivo elegido
	        	 archivoElegido = fc.getSelectedFile();
				//Mostrar el nombre del archvivo en un campo de texto
	            //narch.setText(archivoElegido.getName());
	        }
	        
 		    File inputFile = new File(archivoElegido.getAbsolutePath());
		    BufferedImage input = ImageIO.read(inputFile);
		    // Initialize the same cipher for decryption
		    desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
		    
		    FileOutputStream output = new FileOutputStream("C:\\Users\\josei\\Downloads\\Practica3Crypto\\image_dCFB.bmp");
		    CipherOutputStream cos = new CipherOutputStream(output, desCipher);
		    // File outputFile = new File("image.png");
		    ImageIO.write(input, "BMP", cos);
		    cos.close();

		    // Decrypt the text
		   //byte[] textDecrypted = desCipher.doFinal(textEncrypted);
		    
		}catch(InvalidKeyException e){
			e.printStackTrace();
		}
		return 0; 
	   
	}
	
	public static int DOFB(SecretKey myDesKey, Cipher desCipher) throws IOException, InvalidAlgorithmParameterException  {
		try{
			//SecretKey myDesKey;
			//Cipher desCipher;
			File archivoElegido = null;
			JFileChooser fc = new JFileChooser();
	        //Mostrar la ventana para abrir archivo y recoger la respuesta
	        //En el parámetro del showOpenDialog se indica la ventana
	        //  al que estará asociado. Con el valor this se asocia a la
	        //  ventana que la abre.
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Imágenes BMP", "bmp");
			fc.setFileFilter(filter);
	        int respuesta = fc.showOpenDialog(null);
	        //Comprobar si se ha pulsado Aceptar
	        if (respuesta == JFileChooser.APPROVE_OPTION) {
	            //Crear un objeto File con el archivo elegido
	        	 archivoElegido = fc.getSelectedFile();
				//Mostrar el nombre del archvivo en un campo de texto
	            //narch.setText(archivoElegido.getName());
	        }
	        
 		    File inputFile = new File(archivoElegido.getAbsolutePath());
		    BufferedImage input = ImageIO.read(inputFile);
		    // Initialize the same cipher for decryption
		    desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
		    
		    FileOutputStream output = new FileOutputStream("C:\\Users\\josei\\Downloads\\Practica3Crypto\\image_dOFB.bmp");
		    CipherOutputStream cos = new CipherOutputStream(output, desCipher);
		    // File outputFile = new File("image.png");
		    ImageIO.write(input, "BMP", cos);
		    cos.close();

		    // Decrypt the text
		   //byte[] textDecrypted = desCipher.doFinal(textEncrypted);
		    
		}catch(InvalidKeyException e){
			e.printStackTrace();
		}
		return 0; 
	   
	}




	public static byte[] extractBytes(File imgPath) throws IOException {

        BufferedImage bufferedImage = ImageIO.read(imgPath);

        WritableRaster raster = bufferedImage.getRaster();
        DataBufferByte data = (DataBufferByte) raster.getDataBuffer();

        return (data.getData());
    }
	

    public static void saveFile(byte[] bytes) throws IOException {

        FileOutputStream fos = new FileOutputStream("src//test.jpg");
        fos.write(bytes);
        fos.close();

    }
	/**
	 * Create the frame.
	 */
	public mainframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 676, 421);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Vector de inicializacion:");
		lblNewLabel.setBounds(25, 104, 116, 23);
		panel.add(lblNewLabel);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(114, 212, 80, -66);
		panel.add(desktopPane);
		
		llave = new JTextField();
		llave.setBounds(168, 75, 116, 23);
		panel.add(llave);
		llave.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Ingresa la llave:");
		lblNewLabel_1.setBounds(25, 72, 97, 28);
		panel.add(lblNewLabel_1);
		
		vector = new JTextField();
		vector.setBounds(168, 104, 111, 23);
		panel.add(vector);
		vector.setColumns(10);
		
		JRadioButton rdbtnEcb = new JRadioButton("ECB");
		buttonGroup.add(rdbtnEcb);
		rdbtnEcb.setBounds(25, 152, 60, 21);
		panel.add(rdbtnEcb);
		
		JRadioButton rdbtnCbc = new JRadioButton("CBC");
		buttonGroup.add(rdbtnCbc);
		rdbtnCbc.setBounds(101, 152, 60, 23);
		panel.add(rdbtnCbc);
		
		JRadioButton rdbtnCfb = new JRadioButton("CFB");
		buttonGroup.add(rdbtnCfb);
		rdbtnCfb.setBounds(161, 151, 52, 23);
		panel.add(rdbtnCfb);
		
		JRadioButton rdbtnOfb = new JRadioButton("OFB");
		buttonGroup.add(rdbtnOfb);
		rdbtnOfb.setBounds(227, 152, 52, 23);
		panel.add(rdbtnOfb);
		
		JLabel narch = new JLabel("Archivo");
		narch.setBounds(25, 26, 129, 20);
		panel.add(narch);
		
		Button btncifrar = new Button("Cifrar");
		btncifrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File archivoElegido = null;
				JFileChooser fc = new JFileChooser();
		        //Mostrar la ventana para abrir archivo y recoger la respuesta
		        //En el parámetro del showOpenDialog se indica la ventana
		        //  al que estará asociado. Con el valor this se asocia a la
		        //  ventana que la abre.
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Imágenes BMP", "bmp");
				fc.setFileFilter(filter);
		        int respuesta = fc.showOpenDialog(null);
		        //Comprobar si se ha pulsado Aceptar
		        if (respuesta == JFileChooser.APPROVE_OPTION) {
		            //Crear un objeto File con el archivo elegido
		        	
		        	archivoElegido = fc.getSelectedFile();
					//Mostrar el nombre del archvivo en un campo de texto
		            narch.setText(archivoElegido.getName());
		        }
				if( !(llave.getText().isEmpty()) && !(vector.getText().isEmpty()) && rdbtnEcb.isSelected() ) {
					String llaveTemp = "";
					byte[] vectorTemp;
					//llaveTemp = Integer.parseInt(llave.getText());
					llaveTemp = llave.getText();
					final String comp = llaveTemp;
					if(comp.length()>8) {
						JOptionPane.showMessageDialog(contentPane, "Error la llave, es mayor a 8 bytes, intente de nuevo");
					}
					else {
						BigInteger bigInt = BigInteger.valueOf(Integer.parseInt(vector.getText()));  
						vectorTemp = bigInt.toByteArray();
						try {
						ECB(llaveTemp,vectorTemp,archivoElegido);
						} catch (IOException | InvalidAlgorithmParameterException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
					else if(!(llave.getText().isEmpty()) && !(vector.getText().isEmpty()) && rdbtnCbc.isSelected() ){
						String llaveTemp = "";
						byte[] vectorTemp;
						//llaveTemp = Integer.parseInt(llave.getText());
						llaveTemp = llave.getText();
						final String comp = llaveTemp;
						if(comp.length()>8) {
							JOptionPane.showMessageDialog(contentPane, "Error la llave, es mayor a 8 bytes, intente de nuevo");
						}
						else {
							BigInteger bigInt = BigInteger.valueOf(Integer.parseInt(vector.getText()));  
							vectorTemp = bigInt.toByteArray();
							try {
							CBC(llaveTemp,vectorTemp,archivoElegido);
							} catch (IOException | InvalidAlgorithmParameterException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					} 
					else if(!(llave.getText().isEmpty()) && !(vector.getText().isEmpty()) && rdbtnCfb.isSelected()) {
						String llaveTemp = "";
						byte[] vectorTemp;
						//llaveTemp = Integer.parseInt(llave.getText());
						llaveTemp = llave.getText();
						final String comp = llaveTemp;
						if(comp.length()>8) {
							JOptionPane.showMessageDialog(contentPane, "Error la llave, es mayor a 8 bytes, intente de nuevo");
						}
						else {
							BigInteger bigInt = BigInteger.valueOf(Integer.parseInt(vector.getText()));  
							vectorTemp = bigInt.toByteArray();
							try {
							CFB(llaveTemp,vectorTemp,archivoElegido);
							} catch (IOException | InvalidAlgorithmParameterException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
					else if(!(llave.getText().isEmpty()) && !(vector.getText().isEmpty()) && rdbtnOfb.isSelected()) {
						String llaveTemp = "";
						byte[] vectorTemp;
						//llaveTemp = Integer.parseInt(llave.getText());
						llaveTemp = llave.getText();
						final String comp = llaveTemp;
						if(comp.length()>8) {
							JOptionPane.showMessageDialog(contentPane, "Error la llave, es mayor a 8 bytes, intente de nuevo");
						}
						else {
							BigInteger bigInt = BigInteger.valueOf(Integer.parseInt(vector.getText()));  
							vectorTemp = bigInt.toByteArray();
							try {
							OFB(llaveTemp,vectorTemp,archivoElegido);
							} catch (IOException | InvalidAlgorithmParameterException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
					else  {
					JOptionPane.showMessageDialog(contentPane, "Error, no ha seleccionado un modo de operacion o hay campos vacios");
				}
			}
		});
		btncifrar.setForeground(Color.BLACK);
		btncifrar.setBounds(25, 197, 136, 42);
		panel.add(btncifrar);
		
		Button btncifrar_1 = new Button("Descifrar");
		btncifrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(llave.getText().isEmpty()) && !(vector.getText().isEmpty()) && rdbtnEcb.isSelected()) {
				try {
					DECB(myDesKey,desCipher);
				} catch (InvalidAlgorithmParameterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					}
				}
				else if(!(llave.getText().isEmpty()) && !(vector.getText().isEmpty()) && rdbtnCbc.isSelected()) {
					try {
						DCBC(myDesKey,desCipher);
					} catch (InvalidAlgorithmParameterException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						}
				}
				else if(!(llave.getText().isEmpty()) && !(vector.getText().isEmpty()) && rdbtnCfb.isSelected()) {
					try {
						DCFB(myDesKey,desCipher);
					} catch (InvalidAlgorithmParameterException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						}
				}
				else if(!(llave.getText().isEmpty()) && !(vector.getText().isEmpty()) && rdbtnOfb.isSelected()) {
					try {
						DOFB(myDesKey,desCipher);
					} catch (InvalidAlgorithmParameterException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						}
				}
				else  {
					JOptionPane.showMessageDialog(contentPane, "Error, no ha seleccionado un modo de operacion o hay campos vacios");
				}	
			}
		});
		btncifrar_1.setForeground(Color.BLACK);
		btncifrar_1.setBounds(211, 197, 136, 42);
		panel.add(btncifrar_1);
	}
}
