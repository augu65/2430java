package Investments;
/**
 * @author Jonah Stegman 

 * @studentNumber 0969112
 * @type assignment 3
 * @description this is a Investment program for buying and selling stocks and mutual funds
 */
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;

public class Portfolio {
	private JFrame frame;
	private int i;
	private ArrayList<Investment>array;

	private HashMap<String,ArrayList<Integer>> hash=new HashMap<String, ArrayList<Integer>>();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					Portfolio g = new Portfolio();
					g.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * constructor for Interface
	 */
	public Portfolio() {
		this.array=new ArrayList<>();

		window("Commands");
	}
	private void window(String s) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1800, 1200);
		frame.setTitle("Investment Portfolio");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		String[] cmd= {"Command","Buy","Sell", "Update", "GetGain", "Search", "Quit"};
		JComboBox<String> Com= new JComboBox<String>(cmd);
		Com.setSelectedItem(s);
		Com.setFont(new Font("Tahoma", Font.PLAIN, 50));
		Com.setBounds(0, 0, frame.getWidth()-30, 80);
		String str=(String) Com.getSelectedItem();
		if(str.equals("Command")) {
			start(frame);
		}
		Com.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{

				String str=(String) Com.getSelectedItem();
				if(str.equals("Command")) {
					frame.dispose();
					window("Command");
				}else if(str.equals("Buy")) {
					frame.dispose();
					window("Buy");
					buy(frame);

				}else if(str.equals("Sell")) {
					frame.dispose();
					window("Sell");
					sell(frame);
				}else if(str.equals("Update")) {
					frame.dispose();
					window("Update");
					Update(frame);
				}else if(str.equals("GetGain")) {
					frame.dispose();
					window("GetGain");
					GetGain(frame);
				}else if(str.equals("Search")) {
					frame.dispose();
					window("Search");
					Search(frame);
				}else if(str.equals("Quit")) {

					System.exit(0);
				}
			}

		});

		frame.getContentPane().add(Com);
	}
	public void start(JFrame frame) {
		JLabel text = new JLabel();
		text.setFont(new Font("Tahoma", Font.PLAIN, 50));
		text.setText("Welcome to Investment Portfolio.");
		JTextArea command=new JTextArea();
		command.setFont(new Font("Tahoma", Font.PLAIN, 50));
		command.setText("Choose a command from the \"Commands\" menu to buy or sell"
				+ " an investment, update prices for all investments, get gain for"
				+ " the portfolio, search for relivant investemnts, or quit the"
				+" program.");
		text.setBounds(50,300,frame.getWidth()-150,80);
		command.setBounds(50,600,frame.getWidth()-150,400);
		command.setWrapStyleWord(true);
		command.setEditable(false);
		command.setLineWrap(true);
		frame.getContentPane().add(text);
		frame.getContentPane().add(command);
	}
	/**
	 * gui for buy function
	 * @param frame [the jframe]
	 */
	public void buy(JFrame frame) {
		JLabel txt = new JLabel();
		txt.setText("Buying an investment");
		txt.setFont(new Font("Tahoma", Font.PLAIN, 40));
		txt.setBounds(20,100,700,70);
		JLabel type = new JLabel();
		type.setText("Type:");
		type.setFont(new Font("Tahoma", Font.PLAIN, 40));
		type.setBounds(100,190,150,70);
		JComboBox<String> cmbSI= new JComboBox<String>();
		cmbSI.addItem("Stock");
		cmbSI.addItem("Mutual Fund");
		cmbSI.setBounds(400,190,500,70);
		cmbSI.setFont(new Font("Tahoma", Font.PLAIN, 40));
		JLabel sLabel = new JLabel();
		sLabel.setText("Symbol:");
		sLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		sLabel.setBounds(100,290,300,70);
		JTextField symbol = new JTextField();
		symbol.setEditable(true);
		symbol.setBounds(400, 290, 300, 70);
		symbol.setFont(new Font("Tahoma", Font.PLAIN, 40));
		JLabel nLabel = new JLabel();
		nLabel.setText("Name:");
		nLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		nLabel.setBounds(100,390,300,70);
		JTextField name = new JTextField();
		name.setEditable(true);
		name.setBounds(400, 390, 600, 70);
		name.setFont(new Font("Tahoma", Font.PLAIN, 40));
		JLabel qLabel = new JLabel();
		qLabel.setText("Quantity:");
		qLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		qLabel.setBounds(100,490,300,70);
		JTextField quantity = new JTextField();
		quantity.setEditable(true);
		quantity.setBounds(400, 490, 200, 70);
		quantity.setFont(new Font("Tahoma", Font.PLAIN, 40));
		JLabel pLabel = new JLabel();
		pLabel.setText("Price:");
		pLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		pLabel.setBounds(100,590,300,70);
		JTextField price = new JTextField();
		price.setEditable(true);
		price.setBounds(400,590, 200, 70);
		price.setFont(new Font("Tahoma", Font.PLAIN, 40));
		JButton reset = new JButton();
		reset.setText("Reset");
		reset.setBounds(frame.getWidth()-500, 250, 300, 90);
		reset.setFont(new Font("Tahoma", Font.PLAIN, 40));
		JButton buy = new JButton();
		buy.setText("Buy");
		buy.setBounds(frame.getWidth()-500, 450, 300, 90);
		buy.setFont(new Font("Tahoma", Font.PLAIN, 40));
		JLabel msg = new JLabel();
		msg.setText("Messages");
		msg.setFont(new Font("Tahoma", Font.PLAIN, 40));
		msg.setBounds(20,700,700,70);
		JPanel mp = new JPanel ();
		JTextArea message = new JTextArea (5, 50);
		message.setEditable ( false );
		message.setFont(new Font("Tahoma", Font.PLAIN, 40));
		message.setBounds(20, 780, frame.getWidth()-70, 300);
		JScrollPane scroll = new JScrollPane ( message);
		scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		scroll.setHorizontalScrollBarPolicy ( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS );
		mp.add ( scroll );
		mp.setBackground(Color.WHITE);
		mp.setBounds(20, 780, frame.getWidth()-70, 300);
		frame.getContentPane().add(mp);
		frame.getContentPane().add(msg);
		frame.getContentPane().add(buy);
		frame.getContentPane().add(reset);
		frame.getContentPane().add(symbol);
		frame.getContentPane().add(cmbSI);
		frame.getContentPane().add(type);
		frame.getContentPane().add(sLabel);
		frame.getContentPane().add(nLabel);
		frame.getContentPane().add(qLabel);
		frame.getContentPane().add(pLabel);
		frame.getContentPane().add(name);
		frame.getContentPane().add(quantity);
		frame.getContentPane().add(price);
		frame.getContentPane().add(txt);
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				message.setText("");
				cmbSI.setSelectedItem("");
				symbol.setText("");
				name.setText("");
				price.setText("");
				quantity.setText("");
			}
		});
		buy.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				message.setText("");
				String type=(String) cmbSI.getSelectedItem();
				String symbolF=(String) symbol.getText();
				String nameF=(String) name.getText();
				String p=(String)price.getText();
				String q=(String) quantity.getText();
				if(p.equals(null)) {
					p="0";
				}
				if(q.equals(null)) {
					q="0";
				}
				try {
					double priceF=Double.parseDouble(p);
					int quantityF=Integer.parseInt(q);
					String error=Buy(type,symbolF,nameF,quantityF,priceF);
					message.setText(error);
					cmbSI.setSelectedItem("");
					symbol.setText("");
					name.setText("");
					price.setText("");
					quantity.setText("");
				}catch(NumberFormatException e2) {
					message.setText("Invalid Input!");
					cmbSI.setSelectedItem("");
					symbol.setText("");
					name.setText("");
					price.setText("");
					quantity.setText("");
				}	
			}
		});

	}
	public void sell(JFrame frame) {
		JLabel txt = new JLabel();
		txt.setText("Selling an investment");
		txt.setFont(new Font("Tahoma", Font.PLAIN, 40));
		txt.setBounds(20,100,700,70);

		JLabel sLabel = new JLabel();
		sLabel.setText("Symbol:");
		sLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		sLabel.setBounds(100,290,300,70);
		JTextField symbol = new JTextField();
		symbol.setEditable(true);
		symbol.setBounds(400, 290, 300, 70);
		symbol.setFont(new Font("Tahoma", Font.PLAIN, 40));
		JLabel qLabel = new JLabel();
		qLabel.setText("Quantity:");
		qLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		qLabel.setBounds(100,440,300,70);
		JTextField quantity = new JTextField();
		quantity.setEditable(true);
		quantity.setBounds(400, 440, 200, 70);
		quantity.setFont(new Font("Tahoma", Font.PLAIN, 40));
		JLabel pLabel = new JLabel();
		pLabel.setText("Price:");
		pLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		pLabel.setBounds(100,590,300,70);
		JTextField price = new JTextField();
		price.setBounds(400,590, 200, 70);
		price.setFont(new Font("Tahoma", Font.PLAIN, 40));
		JButton reset = new JButton();
		reset.setText("Reset");
		reset.setBounds(frame.getWidth()-500, 250, 300, 90);
		reset.setFont(new Font("Tahoma", Font.PLAIN, 40));
		JButton sell = new JButton();
		sell.setText("Sell");
		sell.setBounds(frame.getWidth()-500, 450, 300, 90);
		sell.setFont(new Font("Tahoma", Font.PLAIN, 40));
		JLabel msg = new JLabel();
		msg.setText("Messages");
		msg.setFont(new Font("Tahoma", Font.PLAIN, 40));
		msg.setBounds(20,700,700,70);
		JPanel mp = new JPanel ();
		JTextArea message = new JTextArea (5, 50);
		message.setEditable ( false );
		message.setFont(new Font("Tahoma", Font.PLAIN, 40));
		message.setBounds(20, 780, frame.getWidth()-70, 300);
		JScrollPane scroll = new JScrollPane ( message);
		scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		scroll.setHorizontalScrollBarPolicy ( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS );
		mp.add ( scroll );
		mp.setBackground(Color.WHITE);
		mp.setBounds(20, 780, frame.getWidth()-70, 300);
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				message.setText("");
				symbol.setText("");
				price.setText("");
				quantity.setText("");
			}
		});
		sell.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				message.setText("");
				String symbolF=(String) symbol.getText();
				String p=(String)price.getText();
				String q=(String) quantity.getText();
				if(p.equals(null)) {
					p="0";
				}
				if(q.equals(null)) {
					q="0";
				}
				try {
					double priceF=Double.parseDouble(p);
					int quantityF=Integer.parseInt(q);
					String error=Sell(symbolF,priceF,quantityF);
					if(error.contains("Sold")) {
						message.setText(error);
					}else {
						message.setText(error);
					}

				}catch(NumberFormatException e2) {
					message.setText("Invalid Input!");
					symbol.setText("");
					price.setText("");
					quantity.setText("");
				}	
			}
		});
		frame.getContentPane().add(mp);
		frame.getContentPane().add(msg);
		frame.getContentPane().add(sell);
		frame.getContentPane().add(reset);
		frame.getContentPane().add(symbol);
		frame.getContentPane().add(sLabel);
		frame.getContentPane().add(qLabel);
		frame.getContentPane().add(pLabel);
		frame.getContentPane().add(quantity);
		frame.getContentPane().add(price);
		frame.getContentPane().add(txt);
	}
	/**
	 * gui for update function
	 * @param frame[the jframe] 
	 */
	public void Update(JFrame frame) {
		i=0;
		JLabel txt = new JLabel();
		txt.setText("Updating investments");
		txt.setFont(new Font("Tahoma", Font.PLAIN, 40));
		txt.setBounds(20,100,700,70);
		JLabel sLabel = new JLabel();
		sLabel.setText("Symbol:");
		sLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		sLabel.setBounds(100,290,300,70);
		JTextField symbol = new JTextField();
		symbol.setEditable(false);
		symbol.setBounds(400, 290, 300, 70);
		symbol.setFont(new Font("Tahoma", Font.PLAIN, 40));
		JLabel nLabel = new JLabel();
		nLabel.setText("Name:");
		nLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		nLabel.setBounds(100,440,300,70);
		JTextField name = new JTextField();
		name.setEditable(false);
		name.setBounds(400, 440, 600, 70);
		name.setFont(new Font("Tahoma", Font.PLAIN, 40));
		JLabel pLabel = new JLabel();
		pLabel.setText("Price:");
		pLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		pLabel.setBounds(100,590,300,70);
		JTextField price = new JTextField();
		price.setEditable(true);
		price.setBounds(400,590, 200, 70);
		price.setFont(new Font("Tahoma", Font.PLAIN, 40));
		JButton prev= new JButton();
		prev.setText("Prev");
		prev.setBounds(frame.getWidth()-500, 250, 300, 90);
		prev.setFont(new Font("Tahoma", Font.PLAIN, 40));
		JButton next= new JButton();
		next.setText("Next");
		next.setBounds(frame.getWidth()-500, 425, 300, 90);
		next.setFont(new Font("Tahoma", Font.PLAIN, 40));
		JButton save = new JButton();
		save.setText("Save");
		save.setBounds(frame.getWidth()-500, 600, 300, 90);
		save.setFont(new Font("Tahoma", Font.PLAIN, 40));
		JLabel msg = new JLabel();
		msg.setText("Messages");
		msg.setFont(new Font("Tahoma", Font.PLAIN, 40));
		msg.setBounds(20,700,700,70);
		JPanel mp = new JPanel ();
		JTextArea message = new JTextArea (5, 50);
		message.setEditable (false);
		message.setFont(new Font("Tahoma", Font.PLAIN, 40));
		message.setBounds(20, 780, frame.getWidth()-70, 300);
		JScrollPane scroll = new JScrollPane ( message);
		scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		scroll.setHorizontalScrollBarPolicy ( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS );
		mp.add ( scroll );
		mp.setBackground(Color.WHITE);
		mp.setBounds(20, 780, frame.getWidth()-70, 300);
		Investment o=null;
		if(this.array.size()!=0) {
			if(i<0) {
				message.setText("Already at start of array.");
				i+=1;
			}else if(i>=this.array.size()) {
				message.setText ("Already at end of array.");
				i-=1;
			}else{
				o=array.get(i);

			}
		}else {
			message.setText( "No Stocks or Investments recorded.");
		}
		if(!(o==null)) {

			symbol.setText(o.getSymbol());
			name.setText(o.getName());
		}else {

			price.setEditable(false);
		}
		prev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Investment o=null;
				i-=1;
				if(array.size()!=0) {
					if(i<0) {
						message.setText("Already at start of array.");
						i+=1;
					}else if(i>=array.size()) {
						message.setText ("Already at end of array.");
						i-=1;
					}else{
						o=array.get(i);

					}
				}else {
					message.setText( "No Stocks or Investments recorded.");
				}
				if(!(o==null)) {

					symbol.setText(o.getSymbol());
					name.setText(o.getName());
				}

			} 
		});
		next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Investment o=null;
				i+=1;
				if(array.size()!=0) {
					if(i<0) {
						message.setText("Already at start of array.");
						i+=1;
					}else if(i>=array.size()) {
						message.setText ("Already at end of array.");
						i-=1;
					}else{
						o=array.get(i);

					}
				}else {
					message.setText( "No Stocks or Investments recorded.");
				}
				if(!(o==null)) {

					symbol.setText(o.getSymbol());
					name.setText(o.getName());
				}

			}
		});



		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{

				try {
					double prc=Double.parseDouble(price.getText());
					if(prc>0) {
						String str=Update(i,prc);
						message.setText(str);
						price.setText("");
					}else {
						message.setText("Please Enter a Valid Price");
						price.setText("");
					}
				}catch(NumberFormatException e2) {
					message.setText("Please Enter a Valid Price");
					price.setText("");
				}	 	
			}
		});
		frame.getContentPane().add(mp);
		frame.getContentPane().add(msg);
		frame.getContentPane().add(save);
		frame.getContentPane().add(prev);
		frame.getContentPane().add(next);
		frame.getContentPane().add(symbol);
		frame.getContentPane().add(sLabel);
		frame.getContentPane().add(nLabel);
		frame.getContentPane().add(pLabel);
		frame.getContentPane().add(name);
		frame.getContentPane().add(price);
		frame.getContentPane().add(txt);
	}
	/**
	 * gui for total gain function
	 * @param frame [the jframe]
	 */
	public void GetGain(JFrame frame) {
		JLabel txt = new JLabel();
		txt.setText("Getting total gain");
		txt.setFont(new Font("Tahoma", Font.PLAIN, 40));
		JLabel gLabel=new JLabel();
		txt.setBounds(20,100,700,70);
		gLabel.setText("Total gain:");
		gLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		gLabel.setBounds(100,190,300,70);
		JTextField gain = new JTextField();
		gain.setEditable(false);
		gain.setBounds(400, 190, 300, 70);
		gain.setFont(new Font("Tahoma", Font.PLAIN, 40));
		JLabel msg = new JLabel();
		msg.setText("Messages");
		msg.setFont(new Font("Tahoma", Font.PLAIN, 40));
		msg.setBounds(20,350,700,70);
		JPanel mp = new JPanel ();
		JTextArea message = new JTextArea (12, 50);
		message.setEditable ( false );
		message.setFont(new Font("Tahoma", Font.PLAIN, 40));
		message.setBounds(20, 420, frame.getWidth()-70, 700);
		JScrollPane scroll = new JScrollPane ( message);
		scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		scroll.setHorizontalScrollBarPolicy ( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS );
		mp.add ( scroll );
		mp.setBackground(Color.WHITE);
		mp.setBounds(20, 420, frame.getWidth()-70, 700);
		frame.getContentPane().add(mp);
		frame.getContentPane().add(msg);
		frame.getContentPane().add(txt);
		frame.getContentPane().add(gLabel);
		frame.getContentPane().add(gain);
		message.setText("");
		String response = getGain(message);

		if(response.equals("There is no stocks or mutual funds recorded.")) {
			message.setText("");
			message.setText(response);
		}else {
			gain.setText(response);
		}
	}
	/**
	 * Gui for search function
	 * @param frames [the jframe]
	 */
	public void Search(JFrame frames) {
		JLabel txt = new JLabel();
		txt.setText("Selling an investment");
		txt.setFont(new Font("Tahoma", Font.PLAIN, 40));
		txt.setBounds(20,100,700,70);
		JTextArea nLabel = new JTextArea();
		nLabel.setEditable(false);
		nLabel.setWrapStyleWord(true);
		nLabel.setLineWrap(true);
		nLabel.setText("Name keywords:");
		nLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		nLabel.setBounds(100,370,200,140);
		JTextField name = new JTextField();
		name.setEditable(true);
		name.setBounds(400, 390, 600, 70);
		name.setFont(new Font("Tahoma", Font.PLAIN, 40));
		JLabel sLabel = new JLabel();
		sLabel.setText("Symbol:");
		sLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		sLabel.setBounds(100,290,300,70);
		JTextField symbolF = new JTextField();
		symbolF.setEditable(true);
		symbolF.setBounds(400, 290, 300, 70);
		symbolF.setFont(new Font("Tahoma", Font.PLAIN, 40));
		JLabel lLabel = new JLabel();
		lLabel.setText("Low price:");
		lLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lLabel.setBounds(100,490,300,70);
		JTextField lprice = new JTextField();
		lprice.setEditable(true);
		lprice.setBounds(400, 490, 200, 70);
		lprice.setFont(new Font("Tahoma", Font.PLAIN, 40));
		JLabel hLabel = new JLabel();
		hLabel.setText("High price:");
		hLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		hLabel.setBounds(100,590,300,70);
		JTextField hprice = new JTextField();
		hprice.setEditable(true);
		hprice.setBounds(400,590, 200, 70);
		hprice.setFont(new Font("Tahoma", Font.PLAIN, 40));
		JButton reset = new JButton();
		reset.setText("Reset");
		reset.setBounds(frame.getWidth()-500, 250, 300, 90);
		reset.setFont(new Font("Tahoma", Font.PLAIN, 40));
		JButton search = new JButton();
		search.setText("Search");
		search.setBounds(frame.getWidth()-500, 450, 300, 90);
		search.setFont(new Font("Tahoma", Font.PLAIN, 40));
		JLabel msg = new JLabel();
		msg.setText("Messages");
		msg.setFont(new Font("Tahoma", Font.PLAIN, 40));
		msg.setBounds(20,700,700,70);
		JPanel mp = new JPanel ();
		JTextArea message = new JTextArea (5, 50);
		message.setEditable ( false );
		message.setFont(new Font("Tahoma", Font.PLAIN, 40));
		message.setBounds(20, 780, frame.getWidth()-70, 300);
		JScrollPane scroll = new JScrollPane ( message);
		scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		scroll.setHorizontalScrollBarPolicy ( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS );
		mp.add ( scroll );
		mp.setBackground(Color.WHITE);
		mp.setBounds(20, 780, frame.getWidth()-70, 300);
		frame.getContentPane().add(mp);
		frame.getContentPane().add(msg);
		frame.getContentPane().add(search);
		frame.getContentPane().add(reset);
		frame.getContentPane().add(symbolF);
		frame.getContentPane().add(sLabel);
		frame.getContentPane().add(lLabel);
		frame.getContentPane().add(hLabel);
		frame.getContentPane().add(hprice);
		frame.getContentPane().add(lprice);
		frame.getContentPane().add(txt);
		frame.getContentPane().add(nLabel);
		frame.getContentPane().add(name);
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				message.setText("");
				symbolF.setText("");
				name.setText("");
				hprice.setText("");
				lprice.setText("");
			}
		});
		search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				message.setText("");
				String symbolFl=(String) symbolF.getText();
				String nameF=(String) name.getText();
				String ph=(String)hprice.getText();
				String pl=(String) lprice.getText();
				if(pl.isEmpty()) {
					pl="0";
				}
				if(ph.isEmpty()) {
					ph="10000000000";
				}	

				try {
					double lpriceF=Double.parseDouble(pl);
					double hpriceF=Double.parseDouble(ph);
					String error=Search(symbolFl,nameF,lpriceF,hpriceF,message);
					if(error.equals("No Matches Found.")) {
						message.setText(error);
					}

				}catch(NumberFormatException e2) {
					message.setText("Invalid Input!");
					symbolF.setText("");
					name.setText("");
					hprice.setText("");
					lprice.setText("");
				}	

			}
		});
	}
	/**
	 * 
	 * @param symbolF
	 * @param nameF
	 * @param lpriceF
	 * @param hpriceF
	 * @return matches to the search
	 */
	private String Search(String symbolF, String nameF,double lpriceF,double hpriceF,JTextArea message) {
		ArrayList<Integer> o=new ArrayList<Integer>();
		ArrayList<Integer> s=new ArrayList<Integer>();
		ArrayList<Integer> p=new ArrayList<Integer>();
		message.setText("");
		if(!(nameF.isEmpty())) {
			hashMapSearch(nameF,o);
		}else {
			for(int i =0; i<array.size();i++) {
				o.add(i);
			}
		}
		if(!(symbolF.isEmpty())) {
			for(int i=0; i<array.size();i++) {
				String str=array.get(i).getSymbol();
				if(str.equalsIgnoreCase(symbolF)) {
					s.add(i);
				}
			}
		}else {
			for(int i =0; i<array.size();i++) {
				s.add(i);
			}
		}
		for(int i=0; i<array.size();i++) {
			double low=array.get(i).getPrice();
			
			if((low>=lpriceF)&&(low<=hpriceF)) {
				p.add(i);
			}
		}
		o.retainAll(s);
		o.retainAll(p);
		if(o.isEmpty()) {
			return ("No Matches Found.");
		}

		for(int i=0; i<o.size();i++) {
		
			message.append(array.get(o.get(i)).getSymbol()+" "+array.get(o.get(i)).getName()+" Matches the Search parameters\n");
		}
		return "";
	}
	/**
	 * getGain gets the total net gain for all assests at the given price 
	 * @return total gain or error message
	 */
	private String getGain(JTextArea message) {
		double bookValue=0, total=0,totalAll=0;
		/*
		 * outputs all of the stocks and mutual funds bought
		 */
		if(this.array.size()==0) {
			return "There is no stocks or mutual funds recorded.";
		}
		for(Investment obj:this.array) {
			if(obj.getClass()==Stock.class) {
				bookValue=obj.getPrice()*obj.getQuantity()-9.99;
				total=bookValue-obj.getBookValue();
				totalAll+=total;
			}else {
				bookValue=obj.getPrice()*obj.getQuantity()-45;
				total=bookValue-obj.getBookValue();

				totalAll+=total;
			}
			message.append("The Get Gain for "+obj.getName()+ " is $"+Math.round(total*100.0)/100.0+"\n");
		}

		String str= Double.toString(Math.round(totalAll*100.0)/100.0);
		return str;

	}

	/**
	 * update stocks and mutual funds
	 * @param o
	 * @param price
	 * @return error message
	 */
	private String Update(int j,double price) {
		int i=0;
		i=0;
		Investment o=this.array.get(j);
		if(o.getClass()==Stock.class) {

			Stock tempUpdate=new Stock(o.getSymbol(),o.getName(),o.getQuantity(),price,o.getBookValue());
			for(Investment obj: this.array) {
				if(obj.getName()==o.getName()&&obj.getSymbol()==o.getSymbol()) {
					this.array.set(i, tempUpdate);
				}
				i++;
			}
			return("Updated Stock "+o.getSymbol()+" "+o.getName()+"\n");
		}else {

			Mutual tempUpdate=new Mutual(o.getSymbol(),o.getName(),o.getQuantity(),price,o.getBookValue());
			for(Investment obj: this.array) {
				if(obj.getName()==o.getName()&&obj.getSymbol()==o.getSymbol()) {
					this.array.set(i, tempUpdate);
				}
				i++;
			}
			return("Updated Mutual Fund "+o.getSymbol()+" "+o.getName()+"\n");

		}


	}
	/**
	 * sell  stocks or mutual funds
	 * @param symbol
	 * @param price
	 * @param amount
	 * @return error message or sold
	 */
	private String Sell(String symbol,double price,int amount) {
		boolean check=true;
		int i=0;
		double total=0,totalF=0, bookValue=0;
		if(symbol.isEmpty()) {
			return("Please Enter a symbol.");
		}
		/*
		 * checks to see if symbol exists 
		 */
		for(Investment obj:this.array) {
			if(symbol.equalsIgnoreCase(obj.getSymbol())){
				check=false;
				break;
			}
		}	
		if(check==true) {
			return("No symbol found.");
		}
		Investment port=null;
		for(Investment p:this.array) {
			if(p.getSymbol().equalsIgnoreCase(symbol)) {
				port=p;
				break;
			}
			i++;
		}
		if(port.getClass()==Stock.class) {
			if(amount<=0||amount>port.getQuantity()) {
				return ("Quantity not within the range allowed.\n range must be between 1 and "+port.getQuantity());
			}
			totalF=amount*price-9.99;
			if(amount==port.getQuantity()) {
				this.array.remove(port);
				unHash();
			}else {
				total=port.getQuantity()-amount;
				bookValue=total*price+9.99;
				Stock obj=new Stock(port.getSymbol(),port.getName(),(int)total,port.getPrice(),bookValue);
				this.array.set(i, obj);
			}
		}else {
			if(amount<=0||amount>port.getQuantity()) {
				return ("Quantity not within the range allowed.\n range must be between 0 and "+port.getQuantity());
			}
			totalF=amount*price-45;
			if(amount==port.getQuantity()) {
				this.array.remove(port);
				unHash();
			}else {
				total=port.getQuantity()-amount;
				bookValue=total*price;
				Mutual obj=new Mutual(port.getSymbol(),port.getName(),(int)total,port.getPrice(),bookValue);
				this.array.set(i ,obj);
			}
		}
		return ("Sold "+symbol+" for a total of $"+totalF);

	}
	/**
	 * Buy a stock or mutual fund
	 * @param response
	 * @param symbol
	 * @param name
	 * @param amount
	 * @param price
	 * @return bought or error message
	 */
	private String Buy(String response,String symbol, String name, int amount, double price) {
		boolean check=false;
		double bookValue=0;
		if(symbol.isEmpty()) {

			return ("Please enter A symbol.\n");
		}
		if(symbol.isEmpty()) {

			return ("Please enter A name.\n");
		}

		/*
		 * checks if symbol exists
		 */
		for(Investment obj:this.array) {
			if(symbol.equalsIgnoreCase(obj.getSymbol())){
				if(name.equalsIgnoreCase(obj.getName())) {
					if(response.equalsIgnoreCase("Stock")) {
						Stock tmp=new Stock();
						if(obj.getClass()==tmp.getClass()){
							return (response+" has already been entered.\n");
						}else {
							check = true;
						}
					}else {
						Mutual tmp=new Mutual();
						if(obj.getClass()==tmp.getClass()) {
							return (response+" has already been entered.\n");
						}else {
							check = true;
						}
					}

				}else {
					return (response+ " has already been entered.\n");

				}
			}
		}
		if(amount<=0) {
			return("please Enter a valid quantity.\n");
		}
		if(price<=0) {
			return("please Enter a valid price.\n");
		}
		/*
		 * sets variables to proper format
		 */
		response=response.toLowerCase();
		symbol=symbol.toUpperCase();
		/*
		 * calculates bookValue for stock
		 */
		check=true;

		if(response.equals("stock")) {
			bookValue=amount*price+9.99;
			bookValue=Math.round(bookValue*100.0)/100.0;
			Stock temp = new Stock(symbol,name,amount,price,bookValue);
			for(Investment o:this.array) {
				if(o.getSymbol().equals(symbol)){
					if(o.getName().equalsIgnoreCase(name))	{
						check=false;// means it already exists
					}
				}
			}
			if(check==true) {
				array.add(temp);
				
				setMap(temp, array.size());
			}else {
				for(Investment o:this.array) {
					if(o.getSymbol().equals(symbol)) {
						o.setQuantity(amount+o.getQuantity());
						o.setPrice(price);
						o.setBookValue(bookValue+o.getBookValue());
					}
				}
				return ("Updating the "+ response +" "+name);
			}
		}
		/*
		 * calculates bookValue for mutual fund
		 */

		else {
			bookValue=amount*price;
			bookValue=Math.round(bookValue*100.0)/100.0;
			Mutual temp = new Mutual(symbol,name,amount,price,bookValue);
			for(Investment o:this.array) {
				if(o.getSymbol().equals(symbol)){
					if(o.getName().equalsIgnoreCase(name))	{
						check=false;// means it already exists
					}
				}
			}
			if(check==true) {
				array.add(temp);
				
				setMap(temp, array.size());
			}else {
				for(Investment o:this.array) {
					if(o.getSymbol().equals(symbol)) {
						o.setQuantity(amount+o.getQuantity());
						o.setPrice(price);
						o.setBookValue(bookValue+o.getBookValue());
					}
				}
				return ("Updating the "+ response +" "+name);
			}
		}
		return "Succesfully added!";
	}
	/**
	 * adds to HashMap
	 * @param port
	 * @param location
	 */
	private void setMap(Investment port, int location) {
		String str=port.getName();
		String sb[]=str.split("[\\s,/.&]");
		for(int j=0; j<sb.length;j++) {
			if(hash.get(sb[j])==null) {
				hash.put(sb[j],new ArrayList<Integer>());
			}
			boolean map=hash.get(sb[j]).contains(location);
			if(!map) {
				hash.get(sb[j]).add(location);
			}
		}

	}
	/**
	 * removes a element from the hashmap
	 */
	private void unHash() {
		for(int m=0; m<array.size();m++) {
			Investment port=array.get(m);
			String str=port.getName();
			String sB[]=str.split("[\\s,/.&]");
			int i=0;
			for(String ss:sB) {
				i++;
				if(i<sB.length) {
					if(ss.equalsIgnoreCase(sB[i])) {
						sB[i]="";
					}
				}
			}

			str=sB.toString();
			String s[]=str.split("[\\s,/.&]");
			for(int j=0; j<s.length;j++) {
				hash.computeIfAbsent(s[j],k->new ArrayList<>());
				hash.get(s[j]).add(m);


			}
		}

	}

	/**
	 * Search function for hashmap keyword
	 * @param str
	 */
	private void hashMapSearch(String str,ArrayList<Integer>o) {
		ArrayList<Integer> lAll = new ArrayList<>();
			ArrayList<Integer> lFinal = new ArrayList<>();
		String[] words = str.split("[\\s,/.&]");
		
		Set<String> kSet = hash.keySet();
		Iterator<String> iterate = kSet.iterator();
		
		int n = 0;
		int ctr = 0;
		for(int m=0;m<words.length;m++) {
			while(iterate.hasNext()) {
				String key = iterate.next();
				ArrayList<Integer> itHas = hash.get(key);
				for(int j=0;j<words.length;j++) {
					if(words[j].equalsIgnoreCase(key)) {

						for (int k=0;k<itHas.size();k++) {
							lAll.add(itHas.get(k));
						}
					}
				}
			}
		}
		if(words.length!=1) {
			for(int i=0;i<lAll.size();i++) {
				n = lAll.get(i);
				ctr = 0;
				for (int m=i+1;m<lAll.size();m++) {
					if (lAll.get(m) == n) {
						ctr++;
					}
				}
				if (ctr + 1 == words.length) {
					lFinal.add(n);
				}
			}
		} else {
			for (int i=0;i<lAll.size();i++) {
				lFinal.add(lAll.get(i));

			}
		}
		for(int i:lFinal) {
	
			o.add(i-1);
		}
	}
}

