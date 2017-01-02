import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener {
	
	public JButton close, clear, submit, hex, dec, bin;
	public JTextArea outputScreen;
	public JTextField input;
	public int dataType;
	public String s;
	

	public static void main(String[] args) 
	{
		Main window = new Main();
		
		window.setTitle("Converter"); // Set title on window
        window.setSize(600, 400);     // Set size
        window.setResizable(false);    // Allow the window to be resized
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);      // Make the window visible
		
	}
	
	public Main()
	{
		getContentPane().setLayout(new BorderLayout());
		
		
		close = new JButton("Close");
		clear = new JButton("Clear");
		hex = new JButton("Hex");
		dec = new JButton("Dec");
		bin = new JButton("Bin");
		
		outputScreen = new JTextArea("Output");
		input = new JTextField("input");
		
		JPanel p1 = new JPanel();
		p1.setLayout(new BoxLayout(p1,BoxLayout.PAGE_AXIS));
		p1.add(Box.createRigidArea(new Dimension(110, 5)));
		p1.add(close);
		close.addActionListener(this);
		p1.add(Box.createRigidArea(new Dimension(110, 5)));
		p1.add(clear);
		clear.addActionListener(this);
		p1.add(Box.createRigidArea(new Dimension(110, 5)));
		p1.add(clear);
		clear.addActionListener(this);
		p1.add(Box.createRigidArea(new Dimension(110, 5)));
		p1.add(hex);
		hex.addActionListener(this);
		p1.add(Box.createRigidArea(new Dimension(110, 5)));
		p1.add(dec);
		dec.addActionListener(this);
		p1.add(Box.createRigidArea(new Dimension(110, 5)));
		p1.add(bin);
		bin.addActionListener(this);
		
		getContentPane().add(p1, BorderLayout.WEST);
		
		
		outputScreen = new JTextArea();
		JScrollPane scrollpane = new JScrollPane(outputScreen);
		getContentPane().add(scrollpane, BorderLayout.CENTER);
		
		input = new JTextField(40);
		submit = new JButton("Enter");
		submit.addActionListener(this);
		JPanel p2 = new JPanel();
		p2.setLayout(new BorderLayout());
        p2.add(input, BorderLayout.CENTER);
        p2.add(submit, BorderLayout.EAST);
        getContentPane().add(p2, BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == close)
		{
			System.exit(0);
		}
		else if (e.getSource() == clear)
		{
			outputScreen.setText("");
		}
		else if (e.getSource() == hex)
		{
			dataType = 0;
			outputScreen.append("\n Input mode changed to hexadecimal");
		}
		else if (e.getSource() == bin)
		{
			dataType = 1;
			outputScreen.append("\n Input mode changed to binary");
		}
		else if (e.getSource() == dec)
		{
			dataType = 2;
			outputScreen.append("\n Input mode changed to decimal");
		}
		else if(e.getSource() == submit)
			
			try{
		{
			s = input.getText();
			switch(dataType)
			{
			case 0:s = convertHex(s); break;
			case 1:s = convertBin(s); break;
			case 2:s = convertDec(s); break;
			}
		}
			
			input.setText("");
			outputScreen.append(s);
			}
		catch(NumberFormatException x){
			outputScreen.append("\n Invalid input");
		}
			
		
	}
	String convertHex(String input)
	{
		String output = ("\n hex: " + input + "\n dec: " + Long.toString(Long.parseLong(input,16)) + "\n bin: " + Long.toBinaryString(Long.parseLong(input,16)));
		return output;
	}
	String convertBin(String input)
	{
		String output = ("\n hex: " + Long.toHexString(Long.parseLong(input)) + "\n dec: " + Long.toString(Long.parseLong(input,2)) + "\n bin: " + input);
		return output;
	}
	String convertDec(String input)
	{
		String output = ("\n hex: " + Integer.toHexString(Integer.parseInt((input))) + "\n dec: " + input + "\n bin: " + Long.toString(Long.parseLong(input),2));
		return output;
	}
}
