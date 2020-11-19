package calculatrice;

import java.awt.Color;
import java.text.DecimalFormat;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.BorderLayout;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JEditorPane;
import javax.swing.JPasswordField;
import javax.swing.border.Border;

public class Calcul {

	private JFrame frame;
	private JTextField textDisplay;

	String operations = null;
	String answer;
	double firstnum;
	double secondnum;

	boolean num = true;
	String operateur = null;
	double chiffre1 = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calcul window = new Calcul();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calcul() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().setForeground(new Color(34, 30, 31));
		frame.getContentPane().setBackground(new Color(34, 30, 31));
		frame.getContentPane().setLayout(null);

		// ************************* "0" ******************************

		JButton btn0 = new JButton("0");
		btn0.setBackground(new Color(189, 190, 192));
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNum = textDisplay.getText() + btn0.getText();

				if (textDisplay.getText().equals("0")) {
					EnterNum = btn0.getText();
				}
				;

				writeScrean(EnterNum);
				// textDisplay.setText(EnterNum);
			}
		});
		btn0.setFont(new Font("Tahoma", Font.BOLD, 21));
		btn0.setBounds(20, 476, 59, 48);
		btn0.setBorder(new RoundBtn(20));
		frame.getContentPane().add(btn0);

		// ************************* "." ******************************

		JButton btnDot = new JButton(".");
		btnDot.setBackground(new Color(189, 190, 192));
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNum = textDisplay.getText() + btnDot.getText();

				if (textDisplay.getText().equals(".")) {
					EnterNum = btnDot.getText();
				}
				;

				writeScrean(EnterNum);
				// textDisplay.setText(EnterNum);
			}
		});
		btnDot.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnDot.setBounds(89, 476, 59, 48);
		btnDot.setBorder(new RoundBtn(20));
		frame.getContentPane().add(btnDot);

		// *************************/+/-*******************************

		JButton btnSign = new JButton("+/-");
		btnSign.setBackground(new Color(189, 190, 192));
		btnSign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				double value = Double.parseDouble(String.valueOf(textDisplay.getText()));
				value = value * (-1);
				textDisplay.setText(String.valueOf(value));
			}
		});
		btnSign.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnSign.setBounds(156, 476, 59, 48);
		btnSign.setMargin(new Insets(2, 5, 2, 5));
		frame.getContentPane().add(btnSign);

		// ************************* + *******************************

		JButton btnAdd = new JButton("+");
		btnAdd.setBackground(new Color(189, 190, 192));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcul();

				firstnum = readScreen();

				operations = "+";

			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnAdd.setBounds(223, 417, 59, 107);
		btnAdd.setBorder(new RoundBtn(20));
		frame.getContentPane().add(btnAdd);

		// ************************* = *******************************

		JButton btnEqual = new JButton("=");
		btnEqual.setBackground(new Color(189, 190, 192));
		btnEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				secondnum = Double.parseDouble(textDisplay.getText());

				calcul();

			}
		});
		btnEqual.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnEqual.setBounds(292, 476, 59, 48);
		btnEqual.setBorder(new RoundBtn(20));
		frame.getContentPane().add(btnEqual);

		// ************************* "1" *******************************

		JButton btn1 = new JButton("1");
		btn1.setBackground(new Color(189, 190, 192));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String EnterNum = textDisplay.getText() + btn1.getText();

				if (textDisplay.getText().equals("0")) {
					EnterNum = btn1.getText();
				}
				;

				textDisplay.setText(EnterNum);

			}
		});
		btn1.setFont(new Font("Tahoma", Font.BOLD, 21));
		btn1.setBounds(20, 417, 59, 48);
		btn1.setBorder(new RoundBtn(20));
		frame.getContentPane().add(btn1);

		// ************************* "2" *******************************

		JButton btn2 = new JButton("2");
		btn2.setBackground(new Color(189, 190, 192));
		btn2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (num == true) {// flag à faire
					textDisplay.setText("2");
					System.out.println("c'est un nouveau nombre");
				} else {
					String EnterNum = textDisplay.getText() + btn2.getText();

					if (textDisplay.getText().equals("0")) {
						EnterNum = btn2.getText();
					}

					textDisplay.setText(EnterNum);

				}
				num = false;
			}
		});
		btn2.setFont(new Font("Tahoma", Font.BOLD, 21));
		btn2.setBounds(89, 417, 59, 48);
		btn2.setBorder(new RoundBtn(20));
		frame.getContentPane().add(btn2);

		// ************************* "3" *******************************

		JButton btn3 = new JButton("3");
		btn3.setBackground(new Color(189, 190, 192));
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String EnterNum = textDisplay.getText() + btn3.getText();

				if (textDisplay.getText().equals("0")) {
					EnterNum = btn3.getText();
				}
				;

				textDisplay.setText(EnterNum);
			}
		});
		btn3.setFont(new Font("Tahoma", Font.BOLD, 21));
		btn3.setBounds(156, 417, 59, 48);
		btn3.setBorder(new RoundBtn(20));
		frame.getContentPane().add(btn3);

		// ************************* "-" *******************************

		JButton btnMin = new JButton("-");
		btnMin.setBackground(new Color(189, 190, 192));
		btnMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum = Double.parseDouble(textDisplay.getText());
				textDisplay.setText("");
				operations = "-";
			}
		});
		btnMin.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnMin.setBounds(292, 417, 59, 48);
		btnMin.setBorder(new RoundBtn(20));
		frame.getContentPane().add(btnMin);

		// ************************* "4" *******************************

		JButton btn4 = new JButton("4");
		btn4.setBackground(new Color(189, 190, 192));
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNum = textDisplay.getText() + btn4.getText();

				if (textDisplay.getText().equals("0")) {
					EnterNum = btn4.getText();
				}
				;

				textDisplay.setText(EnterNum);
			}
		});
		btn4.setFont(new Font("Tahoma", Font.BOLD, 21));
		btn4.setBounds(20, 358, 59, 48);
		btn4.setBorder(new RoundBtn(20));
		frame.getContentPane().add(btn4);

		// ************************* "5" *******************************

		JButton btn5 = new JButton("5");
		btn5.setBackground(new Color(189, 190, 192));
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNum = textDisplay.getText() + btn1.getText();

				if (textDisplay.getText().equals("0")) {
					EnterNum = btn5.getText();
				}
				;

				textDisplay.setText(EnterNum);
			}
		});
		btn5.setFont(new Font("Tahoma", Font.BOLD, 21));
		btn5.setBounds(89, 358, 59, 48);
		btn5.setBorder(new RoundBtn(20));
		frame.getContentPane().add(btn5);

		// ************************* "6" *******************************

		JButton btn6 = new JButton("6");
		btn6.setBackground(new Color(189, 190, 192));
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNum = textDisplay.getText() + btn6.getText();

				if (textDisplay.getText().equals("0")) {
					EnterNum = btn6.getText();
				}
				;

				textDisplay.setText(EnterNum);
			}
		});
		btn6.setFont(new Font("Tahoma", Font.BOLD, 21));
		btn6.setBounds(156, 358, 59, 48);
		btn6.setBorder(new RoundBtn(20));
		frame.getContentPane().add(btn6);

		// ************************* "*" *******************************

		JButton btnX = new JButton("*");
		btnX.setBackground(new Color(189, 190, 192));
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				firstnum = readScreen();
				// firstnum = Double.parseDouble(textDisplay.getText());
				textDisplay.setText("");
				operations = "*";
			}
		});
		btnX.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnX.setBounds(223, 358, 59, 48);
		btnX.setBorder(new RoundBtn(20));
		frame.getContentPane().add(btnX);

		// ************************* "/" ******************************

		JButton btnDiv = new JButton("\u00F7");
		btnDiv.setBackground(new Color(189, 190, 192));
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum = readScreen();
				// firstnum = Double.parseDouble(textDisplay.getText());
				textDisplay.setText("");
				operations = "/";
			}
		});
		btnDiv.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnDiv.setBounds(292, 358, 59, 48);
		btnDiv.setBorder(new RoundBtn(20));
		frame.getContentPane().add(btnDiv);

		// ************************* "7" ******************************

		JButton btn7 = new JButton("7");
		btn7.setBackground(new Color(189, 190, 192));
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNum = textDisplay.getText() + btn7.getText();

				if (textDisplay.getText().equals("0")) {
					EnterNum = btn7.getText();
				}
				;

				textDisplay.setText(EnterNum);
			}
		});
		btn7.setFont(new Font("Tahoma", Font.BOLD, 21));
		btn7.setBounds(20, 299, 59, 48);
		btn7.setBorder(new RoundBtn(20));
		frame.getContentPane().add(btn7);

		// ************************* "8" ******************************

		JButton btn8 = new JButton("8");
		btn8.setBackground(new Color(189, 190, 192));
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNum = textDisplay.getText() + btn8.getText();

				if (textDisplay.getText().equals("0")) {
					EnterNum = btn8.getText();
				}
				;

				textDisplay.setText(EnterNum);
			}
		});
		btn8.setFont(new Font("Tahoma", Font.BOLD, 21));
		btn8.setBounds(89, 299, 59, 48);
		btn8.setBorder(new RoundBtn(20));
		frame.getContentPane().add(btn8);

		// ************************* "9" ******************************

		JButton btn9 = new JButton("9");
		btn9.setBackground(new Color(189, 190, 192));
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNum = textDisplay.getText() + btn9.getText();

				if (textDisplay.getText().equals("0")) {
					EnterNum = btn9.getText();
				}
				;

				textDisplay.setText(EnterNum);
			}
		});
		btn9.setFont(new Font("Tahoma", Font.BOLD, 21));
		btn9.setBounds(156, 299, 59, 48);
		btn9.setBorder(new RoundBtn(20));
		frame.getContentPane().add(btn9);

		// ************************* "%" ******************************

		JButton btnPrctg = new JButton("%");
		btnPrctg.setBackground(new Color(189, 190, 192));
		btnPrctg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// fonction read screan et write

				double prctage_of = readScreen();
				double prctage = prctage_of / 100;

				textDisplay.setText("");
				textDisplay.setText(textDisplay.getText() + prctage);

			}

		});
		btnPrctg.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPrctg.setBounds(223, 299, 59, 48);

		frame.getContentPane().add(btnPrctg);

		// ************************* "\u221A" ******************************

		JButton btnRacineC = new JButton("\u221A");
		btnRacineC.setBackground(new Color(189, 190, 192));
		btnRacineC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double r = Math.sqrt(Double.parseDouble(textDisplay.getText()));
				textDisplay.setText("");
				textDisplay.setText(textDisplay.getText() + r);

			}
		});
		btnRacineC.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnRacineC.setBounds(292, 299, 59, 48);
		btnRacineC.setBorder(new RoundBtn(20));
		frame.getContentPane().add(btnRacineC);

		// ************************* "MRC" ******************************

		JButton btnMRC = new JButton("MRC");
		btnMRC.setBackground(new Color(189, 190, 192));
		btnMRC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnMRC.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMRC.setBounds(20, 233, 59, 48);

		btnMRC.setMargin(new Insets(0, 0, 0, 0));
		frame.getContentPane().add(btnMRC);

		// ************************* "M+" ******************************

		JButton btnMp = new JButton("M+");
		btnMp.setBackground(new Color(189, 190, 192));
		btnMp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnMp.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnMp.setBounds(89, 233, 59, 48);

		btnMp.setMargin(new Insets(2, 5, 2, 5));
		frame.getContentPane().add(btnMp);

		// ************************* "M-" ******************************

		JButton btnMm = new JButton("M-");
		btnMm.setBackground(new Color(189, 190, 192));
		btnMm.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnMm.setBounds(156, 233, 59, 48);

		btnMm.setMargin(new Insets(2, 5, 2, 5));
		frame.getContentPane().add(btnMm);

		// ************************* "CE" ******************************

		JButton btnCE = new JButton("CE");
		btnCE.setBackground(new Color(189, 190, 192));
		btnCE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String back = null;
				if (textDisplay.getText().length() > 0)
					;
				{

					StringBuilder strB = new StringBuilder(textDisplay.getText());
					strB.deleteCharAt(textDisplay.getText().length() - 1);
					back = strB.toString();
					textDisplay.setText(back);
				}
			}
		});
		btnCE.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnCE.setBounds(223, 233, 59, 48);

		frame.getContentPane().add(btnCE);

		// ************************* "ON" ******************************

		JButton btnON = new JButton("ON-C");
		btnON.setForeground(Color.WHITE);
		btnON.setBackground(new Color(255, 0, 0));

		btnON.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textDisplay.setText("");
			}
		});
		btnON.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnON.setBounds(292, 233, 59, 48);

		btnON.setMargin(new Insets(2, 0, 2, 0));

		frame.getContentPane().add(btnON);

		textDisplay = new JTextField();
		textDisplay.setBackground(new Color (157, 179, 192));
		textDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		textDisplay.setFont(new Font("Tahoma", Font.BOLD, 21));
		textDisplay.setBounds(32, 106, 307, 66);
		frame.getContentPane().add(textDisplay);
		textDisplay.setColumns(10);

		frame.setBackground(new Color(34, 30, 31));
		frame.setBounds(100, 100, 385, 609);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public double readScreen() {
		
		String s= textDisplay.getText().replace(',', '.');
		
		System.out.println("screen:" + s);
		
		return Double.parseDouble(s);
	}

	public void writeScrean(String s) {

		textDisplay.setText(s);
	}

	public void addCharScrean(char c) {
		String v = textDisplay.getText();
		textDisplay.setText(v + c);

	}

	public void addIntScrean(int i) {
		String v = textDisplay.getText();
		textDisplay.setText(v + i);
	}

	public void calcul() {
		System.out.println("1)F: " + firstnum + " s: " + secondnum + " num: " + num + " operation: " + operations);

		num = true;

		if (operations != null) {
			switch (operations) {
			case "+":
				firstnum += secondnum;
				break;
			case "-":
				firstnum -= secondnum;
				break;
			case "*":
				firstnum *= secondnum;
				break;
			case "/":
				firstnum /= secondnum;
				break;
			default:
				firstnum = secondnum;
			}

			operations = null;
			//answer = String.format("%.0f", firstnum);
			textDisplay.setText(answer);

		}
		System.out.println("2)F: " + firstnum + " s: " + secondnum + " num: " + num + " operation: " + operations);
	}

}
