package sort;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Point;
import stack.DlgStack;

import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class FrmSort extends JFrame {

	private JPanel contentPane;
	DefaultListModel <Circle> dlm = new DefaultListModel<Circle>();
	ArrayList <Circle> list = new ArrayList<Circle>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSort frame = new FrmSort();		
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
	public FrmSort() {
		setTitle("Aleksa Panovic IT43/2023");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel plnCenter = new JPanel();
		contentPane.add(plnCenter, BorderLayout.CENTER);
		
		JList lstCircle = new JList();  
		plnCenter.add(lstCircle);
		lstCircle.setModel(dlm);		
		
		JScrollBar scrPnl = new JScrollBar(); 
		plnCenter.add(scrPnl);
		scrPnl.setBackground(new Color(0,0,0));
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.setBackground(new Color(181, 242, 245));
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBackground(new Color(244, 226, 133));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgStack dlgStack = new DlgStack();       
				dlgStack.setVisible(true); 
				if(dlgStack.confirmation)
				{
					try {
						int x = Integer.parseInt(dlgStack.getTxtX().getText()); 
						int y = Integer.parseInt(dlgStack.getTxtY().getText());
						int radius = Integer.parseInt(dlgStack.getTxtR().getText());
						
						Circle c = new Circle(new Point(x,y), radius); 
						
						dlm.add(0, c);
						list.add(c);
						
					}
					 catch(Exception NumberFormatException) {
						 
						 JOptionPane.showMessageDialog(null,"Please, insert values!");
						 
					 }
					
				}
			}
		});
		pnlSouth.add(btnAdd);
		
		JButton btnSort = new JButton("Sort");
		btnSort.setBackground(new Color(244, 162, 89));
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dlm.isEmpty()) {
					JOptionPane.showMessageDialog(null, "List is empty! ", "ERROR", JOptionPane.WARNING_MESSAGE);
				} else {
					
					list.sort(null);
					dlm.clear();
					for(int i=0; i<list.size();i++) { 
						dlm.addElement(list.get(i));
						
					}
				}
			}
		});
		pnlSouth.add(btnSort);
		
		JPanel pnlNorth = new JPanel();
		pnlNorth.setBackground(new Color(181, 242, 245));
		contentPane.add(pnlNorth, BorderLayout.NORTH);
		
		JLabel lblNorth = new JLabel("Stack with sort");
		lblNorth.setForeground(new Color(0, 0, 0));
		lblNorth.setFont(new Font("Montserrat Black", Font.BOLD , 25));
		pnlNorth.add(lblNorth);
	}

}
