package dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import point.Point;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class PointDialog extends JDialog {
	
	
	private JTextField txtXCoordinate;
	private JTextField txtYCoordinate;
	
	private Color color;
	
	private JLabel lblPoint_1;
	private JLabel lblXCoordinate;
	private JLabel lblYCoordinate;
	private JLabel lblColor_1;
	private JButton btnColor_1;
	private JButton btnOK_1;
	private JButton btnCancel_1;
	
	private Point pointDlg;
	
	private int x;
	private int y;
	
	private boolean ok;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PointDialog dialog = new PointDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PointDialog() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel mainPanel = new JPanel();
			getContentPane().add(mainPanel, BorderLayout.CENTER);
			{
				lblPoint_1 = new JLabel("Point");
				lblPoint_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			}
			{
				lblXCoordinate = new JLabel("X coordinate :");
				lblXCoordinate.setFont(new Font("Tahoma", Font.PLAIN, 13));
			}
			{
				txtXCoordinate = new JTextField();
				txtXCoordinate.setColumns(10);
			}
			{
				lblYCoordinate = new JLabel("Y coordinate :");
				lblYCoordinate.setFont(new Font("Tahoma", Font.PLAIN, 13));
			}
			{
				txtYCoordinate = new JTextField();
				txtYCoordinate.setColumns(10);
			}
			{
				lblColor_1 = new JLabel("Color");
				lblColor_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
			}
			{
				btnColor_1 = new JButton("");
				btnColor_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						color = JColorChooser.showDialog(null, "Choose color", color);
						if (color != null) {
							btnColor_1.setBackground(color);
						}
					}
				});
			}
			GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
			gl_mainPanel.setHorizontalGroup(
				gl_mainPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_mainPanel.createSequentialGroup()
						.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_mainPanel.createSequentialGroup()
								.addGap(118)
								.addComponent(lblXCoordinate)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
									.addComponent(lblPoint_1)
									.addComponent(txtXCoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_mainPanel.createSequentialGroup()
								.addGap(120)
								.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
									.addComponent(lblYCoordinate)
									.addGroup(gl_mainPanel.createSequentialGroup()
										.addGap(10)
										.addComponent(lblColor_1)))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
									.addComponent(btnColor_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(txtYCoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGap(157))
			);
			gl_mainPanel.setVerticalGroup(
				gl_mainPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_mainPanel.createSequentialGroup()
						.addGap(61)
						.addComponent(lblPoint_1)
						.addGap(31)
						.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtXCoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblXCoordinate))
						.addGap(5)
						.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblYCoordinate)
							.addComponent(txtYCoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
							.addComponent(lblColor_1)
							.addComponent(btnColor_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
			);
			mainPanel.setLayout(gl_mainPanel);
		}
		{
			JPanel buttonPanel = new JPanel();
			getContentPane().add(buttonPanel, BorderLayout.SOUTH);
			{
				btnOK_1 = new JButton("OK");
				getRootPane().setDefaultButton(btnOK_1);
				btnOK_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							pointDlg = new Point();
							pointDlg.setX(Integer.parseInt(getTxtXCoordinate().getText()));
							pointDlg.setY(Integer.parseInt(getTxtYCoordinate().getText()));
							pointDlg.setBorderColor(btnColor_1.getBackground());
							setOk(true);
							setVisible(false);
						} catch (Exception g) {
							JOptionPane.showMessageDialog(null, "You didn't input the number","Warning",JOptionPane.WARNING_MESSAGE);
							;
						}
					}
				});
			}
			{
				btnCancel_1 = new JButton("Cancel");
				btnCancel_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						pointDlg = null;
						setOk(false);
						setVisible(false);
					}
				});
				btnCancel_1.setActionCommand("Cancel");
			}
			GroupLayout gl_buttonPanel = new GroupLayout(buttonPanel);
			gl_buttonPanel.setHorizontalGroup(
				gl_buttonPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPanel.createSequentialGroup()
						.addGap(166)
						.addComponent(btnOK_1)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnCancel_1)
						.addGap(146))
			);
			gl_buttonPanel.setVerticalGroup(
				gl_buttonPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPanel.createSequentialGroup()
						.addGroup(gl_buttonPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnCancel_1)
							.addComponent(btnOK_1))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			buttonPanel.setLayout(gl_buttonPanel);
		}
	}

	public JTextField getTxtXCoordinate() {
		return txtXCoordinate;
	}

	public void setTxtXCoordinate(JTextField txtXCoordinate) {
		this.txtXCoordinate = txtXCoordinate;
	}

	public JTextField getTxtYCoordinate() {
		return txtYCoordinate;
	}

	public void setTxtYCoordinate(JTextField txtYCoordinate) {
		this.txtYCoordinate = txtYCoordinate;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public JLabel getLblPoint_1() {
		return lblPoint_1;
	}

	public void setLblPoint_1(JLabel lblPoint_1) {
		this.lblPoint_1 = lblPoint_1;
	}

	public JLabel getLblXCoordinate() {
		return lblXCoordinate;
	}

	public void setLblXCoordinate(JLabel lblXCoordinate) {
		this.lblXCoordinate = lblXCoordinate;
	}

	public JLabel getLblYCoordinate() {
		return lblYCoordinate;
	}

	public void setLblYCoordinate(JLabel lblYCoordinate) {
		this.lblYCoordinate = lblYCoordinate;
	}

	public JLabel getLblColor_1() {
		return lblColor_1;
	}

	public void setLblColor_1(JLabel lblColor_1) {
		this.lblColor_1 = lblColor_1;
	}

	public JButton getBtnColor_1() {
		return btnColor_1;
	}

	public void setBtnColor_1(JButton btnColor_1) {
		this.btnColor_1 = btnColor_1;
	}

	public JButton getBtnOK_1() {
		return btnOK_1;
	}

	public void setBtnOK_1(JButton btnOK_1) {
		this.btnOK_1 = btnOK_1;
	}

	public JButton getBtnCancel_1() {
		return btnCancel_1;
	}

	public void setBtnCancel_1(JButton btnCancel_1) {
		this.btnCancel_1 = btnCancel_1;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public Point getPointDlg() {
		return pointDlg;
	}

	public void setPointDlg(Point pointDlg) {
		this.pointDlg = pointDlg;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	

}
