package dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hexagon.HexagonAdapter;
import hexagon.Hexagon;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HexagonDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton okButton;
	private JButton cancelButton;
	private JTextField txtXCenter;
	private JTextField txtYCenter;
	private JTextField txtRadius;

	private HexagonAdapter hexagonDialog;
	private Color innerColor;
	private Color borderColor;
	private boolean ok;
	private JButton btnInnerColor;
	private JButton btnBorderColor;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			HexagonDialog dialog = new HexagonDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public HexagonDialog() {
		setModal(true);
		setBounds(100, 100, 450, 337);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		JLabel lblHexagon = new JLabel("Hexagon");
		lblHexagon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JLabel lblCenter = new JLabel("Center :");
		lblCenter.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JLabel lblYCoordinate = new JLabel("Y coordinate");
		lblYCoordinate.setFont(new Font("Tahoma", Font.PLAIN, 11));
		JLabel lblXCoordinate = new JLabel("X coordinate");
		lblXCoordinate.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtXCenter = new JTextField();
		txtXCenter.setColumns(10);
		txtYCenter = new JTextField();
		txtYCenter.setColumns(10);
		JLabel lblInnerColor = new JLabel("Inner color");
		lblInnerColor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		JLabel lblBorderColor = new JLabel("Border color");
		lblBorderColor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		JLabel lblRadius = new JLabel("Radius");
		lblRadius.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtRadius = new JTextField();
		txtRadius.setColumns(10);
	    btnBorderColor = new JButton("");
		btnBorderColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borderColor = JColorChooser.showDialog(null, "Border color",borderColor);
				if(borderColor!=null) {
					btnBorderColor.setBackground(borderColor);
				}
			}
		});
	    btnInnerColor = new JButton("");
		btnInnerColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				innerColor = JColorChooser.showDialog(null, "Inner color", innerColor);
				if(innerColor!=null) {
					btnInnerColor.setBackground(innerColor);
				}
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(96)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCenter)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(33)
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblYCoordinate)
										.addComponent(lblXCoordinate))
									.addGap(26)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(txtXCenter, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
										.addComponent(txtYCenter, 0, 0, Short.MAX_VALUE)))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblInnerColor)
										.addComponent(lblBorderColor)
										.addComponent(lblRadius))
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(txtRadius, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
										.addComponent(btnBorderColor, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
										.addComponent(btnInnerColor, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))))
							.addGap(19)))
					.addGap(107))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(172, Short.MAX_VALUE)
					.addComponent(lblHexagon)
					.addGap(140))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblHexagon)
					.addGap(12)
					.addComponent(lblCenter)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblXCoordinate)
						.addComponent(txtXCenter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYCoordinate)
						.addComponent(txtYCenter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRadius))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblBorderColor)
						.addComponent(btnBorderColor, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnInnerColor, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblInnerColor))
					.addGap(32))
		);
		panel.setLayout(gl_panel);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 401, GroupLayout.PREFERRED_SIZE)
					.addGap(33))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(73, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							int x=Integer.parseInt(getTxtXCenter().getText());
							int y=Integer.parseInt(getTxtYCenter().getText());
							int r=Integer.parseInt(getTxtRadius().getText());
							hexagonDialog = new HexagonAdapter(x,y,r,btnBorderColor.getBackground(),btnInnerColor.getBackground());
							setVisible(false);
							setOk(true);
							}catch(Exception exception) {
								JOptionPane.showMessageDialog(null, "You didn't input the number","Warning",JOptionPane.WARNING_MESSAGE);
							}
					}
				});
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						hexagonDialog = null;
						setOk(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
			}
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGap(184)
						.addComponent(okButton)
						.addGap(18)
						.addComponent(cancelButton)
						.addGap(120))
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(okButton)
							.addComponent(cancelButton))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			buttonPane.setLayout(gl_buttonPane);
		}
	}

	public JButton getOkButton() {
		return okButton;
	}

	public void setOkButton(JButton okButton) {
		this.okButton = okButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}

	public JTextField getTxtXCenter() {
		return txtXCenter;
	}

	public void setTxtXCenter(JTextField txtXCenter) {
		this.txtXCenter = txtXCenter;
	}

	public JTextField getTxtYCenter() {
		return txtYCenter;
	}

	public void setTxtYCenter(JTextField txtYCenter) {
		this.txtYCenter = txtYCenter;
	}

	public JTextField getTxtRadius() {
		return txtRadius;
	}

	public void setTxtRadius(JTextField txtRadius) {
		this.txtRadius = txtRadius;
	}

	public HexagonAdapter getHexagonDialog() {
		return hexagonDialog;
	}

	public void setHexagonDialog(HexagonAdapter hexagonDialog) {
		this.hexagonDialog = hexagonDialog;
	}

	public Color getInnerColor() {
		return innerColor;
	}

	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public JButton getBtnInnerColor() {
		return btnInnerColor;
	}

	public void setBtnInnerColor(JButton btnInnerColor) {
		this.btnInnerColor = btnInnerColor;
	}

	public JButton getBtnBorderColor() {
		return btnBorderColor;
	}

	public void setBtnBorderColor(JButton btnBorderColor) {
		this.btnBorderColor = btnBorderColor;
	}

	public JPanel getContentPanel() {
		return contentPanel;
	}

}
