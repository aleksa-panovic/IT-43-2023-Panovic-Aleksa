package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;
import geometry.Rectangle;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgRectangle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtWidth;
	private JTextField txtHeight;
	public boolean confirm;
	public Rectangle rect;
	private JButton btnInnerColor;
	private JButton btnOutlineColor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRectangle dialog = new DlgRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRectangle() {
		setTitle("ADD NEW OR MODIFY EXISTING RECTANGLE");
		setModal(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setBounds(100, 100, 500, 365);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(181, 242, 245));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblUpperLP = new JLabel("Upper left point");
			GridBagConstraints gbc_lblUpperLP = new GridBagConstraints();
			gbc_lblUpperLP.anchor = GridBagConstraints.WEST;
			gbc_lblUpperLP.insets = new Insets(0, 0, 10, 5);
			gbc_lblUpperLP.gridx = 0;
			gbc_lblUpperLP.gridy = 1;
			contentPanel.add(lblUpperLP, gbc_lblUpperLP);
		}
		{
			JLabel lblX = new JLabel("Enter the X coordinate: ");
			GridBagConstraints gbc_lblX = new GridBagConstraints();
			gbc_lblX.anchor = GridBagConstraints.WEST;
			gbc_lblX.insets = new Insets(0, 0, 25, 5);
			gbc_lblX.gridx = 0;
			gbc_lblX.gridy = 2;
			contentPanel.add(lblX, gbc_lblX);
		}
		{
			txtX = new JTextField();
			GridBagConstraints gbc_txtX = new GridBagConstraints();
			gbc_txtX.insets = new Insets(0, 0, 25, 5);
			gbc_txtX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtX.gridx = 1;
			gbc_txtX.gridy = 2;
			contentPanel.add(txtX, gbc_txtX);
			txtX.setColumns(10);
		}
		{
			JLabel lblY = new JLabel("Enter the Y coordinate: ");
			GridBagConstraints gbc_lblY = new GridBagConstraints();
			gbc_lblY.anchor = GridBagConstraints.WEST;
			gbc_lblY.insets = new Insets(0, 0, 25, 5);
			gbc_lblY.gridx = 0;
			gbc_lblY.gridy = 3;
			contentPanel.add(lblY, gbc_lblY);
		}
		{
			txtY = new JTextField();
			GridBagConstraints gbc_txtY = new GridBagConstraints();
			gbc_txtY.insets = new Insets(0, 0, 25, 5);
			gbc_txtY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtY.gridx = 1;
			gbc_txtY.gridy = 3;
			contentPanel.add(txtY, gbc_txtY);
			txtY.setColumns(10);
		}
		{
			JLabel lblWidth = new JLabel("Enter the width: ");
			GridBagConstraints gbc_lblWidth = new GridBagConstraints();
			gbc_lblWidth.anchor = GridBagConstraints.WEST;
			gbc_lblWidth.insets = new Insets(0, 0, 25, 5);
			gbc_lblWidth.gridx = 0;
			gbc_lblWidth.gridy = 4;
			contentPanel.add(lblWidth, gbc_lblWidth);
		}
		{
			txtWidth = new JTextField();
			GridBagConstraints gbc_txtWidth = new GridBagConstraints();
			gbc_txtWidth.insets = new Insets(0, 0, 25, 5);
			gbc_txtWidth.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtWidth.gridx = 1;
			gbc_txtWidth.gridy = 4;
			contentPanel.add(txtWidth, gbc_txtWidth);
			txtWidth.setColumns(10);
		}
		{
			JLabel lblHeight = new JLabel("Enter the height:");
			GridBagConstraints gbc_lblHeight = new GridBagConstraints();
			gbc_lblHeight.anchor = GridBagConstraints.WEST;
			gbc_lblHeight.insets = new Insets(0, 0, 25, 5);
			gbc_lblHeight.gridx = 0;
			gbc_lblHeight.gridy = 5;
			contentPanel.add(lblHeight, gbc_lblHeight);
		}
		{
			txtHeight = new JTextField();
			GridBagConstraints gbc_txtHeight = new GridBagConstraints();
			gbc_txtHeight.insets = new Insets(0, 0, 25, 5);
			gbc_txtHeight.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtHeight.gridx = 1;
			gbc_txtHeight.gridy = 5;
			contentPanel.add(txtHeight, gbc_txtHeight);
			txtHeight.setColumns(10);
		}
		{
			{
				btnInnerColor = new JButton("Inner Color");
				btnInnerColor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Color innerColor = JColorChooser.showDialog(null, "Choose inner color!", btnInnerColor.getBackground());
						if (innerColor != null)
							btnInnerColor.setBackground(innerColor);
					}
				});
				GridBagConstraints gbc_btnInnerColor = new GridBagConstraints();
				gbc_btnInnerColor.insets = new Insets(0, 0, 5, 5);
				btnInnerColor.setBackground(new Color(255,255,255));
				gbc_btnInnerColor.gridx = 1;
				gbc_btnInnerColor.gridy = 6;
				contentPanel.add(btnInnerColor, gbc_btnInnerColor);
			}
		}
		{
			btnOutlineColor = new JButton("Outline Color");
			btnOutlineColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Color outlineColor = JColorChooser.showDialog(null, "Choose outline color",
							btnOutlineColor.getBackground());
					if (outlineColor != null)
						btnOutlineColor.setBackground(outlineColor);
				}
			});
			GridBagConstraints gbc_btnOutlineColor = new GridBagConstraints();
			gbc_btnOutlineColor.insets = new Insets(0, 0, 0, 5);
			btnOutlineColor.setBackground(new Color(255,255,255));
			gbc_btnOutlineColor.gridx = 1;
			gbc_btnOutlineColor.gridy = 7;
			contentPanel.add(btnOutlineColor, gbc_btnOutlineColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.LEFT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setBackground(new Color(0, 255, 0));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							if (txtX.getText().trim().isEmpty() || txtY.getText().trim().isEmpty()
									|| txtHeight.getText().trim().isEmpty() || txtWidth.getText().trim().isEmpty()) {
								setConfirm(false);
								JOptionPane.showMessageDialog(null, "All values are required!", "Error",
										JOptionPane.ERROR_MESSAGE);
							} else {
								if (Integer.parseInt(txtWidth.getText().toString()) <= 0
										|| Integer.parseInt(txtHeight.getText().toString()) <= 0
										|| Integer.parseInt(txtX.getText().toString()) < 0
										|| Integer.parseInt(txtY.getText().toString()) < 0) {
									JOptionPane.showMessageDialog(null, "Insert values greater then 0!", "Error",
											JOptionPane.ERROR_MESSAGE);

								} else {
									rect = new Rectangle(
											new Point(Integer.parseInt(getTxtX().getText().toString()),
													Integer.parseInt(getTxtY().getText().toString())),
											Integer.parseInt(getTxtWidth().getText().toString()),
											Integer.parseInt(getTxtHeight().getText().toString()), false,
											btnOutlineColor.getBackground(), btnInnerColor.getBackground());

									setConfirm(true);
									setVisible(false);
								}
							}
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "Enter numbers only!", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setBackground(new Color(255, 0, 0));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public JTextField getTxtX() {
		return txtX;
	}

	public void setTxtX(JTextField txtX) {
		this.txtX = txtX;
	}

	public JTextField getTxtY() {
		return txtY;
	}

	public void setTxtY(JTextField txtY) {
		this.txtY = txtY;
	}

	public JTextField getTxtHeight() {
		return txtHeight;
	}

	public void setTxtHeight(JTextField txtHeight) {
		this.txtHeight = txtHeight;
	}

	public JTextField getTxtWidth() {
		return txtWidth;
	}

	public void setTxtWidth(JTextField txtWidth) {
		this.txtWidth = txtWidth;
	}

	public boolean isConfirm() {
		return confirm;
	}

	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}

	public Rectangle getRect() {
		return rect;
	}

	public void setRect(Rectangle rect) {
		this.rect = rect;
	}

	public JButton getBtnInnerColor() {
		return btnInnerColor;
	}

	public void setBtnInnerColor(JButton btnInnerColor) {
		this.btnInnerColor = btnInnerColor;
	}

	public JButton getBtnOutlineColor() {
		return btnOutlineColor;
	}

	public void setBtnOutlineColor(JButton btnOutlineColor) {
		this.btnOutlineColor = btnOutlineColor;
	}
}
