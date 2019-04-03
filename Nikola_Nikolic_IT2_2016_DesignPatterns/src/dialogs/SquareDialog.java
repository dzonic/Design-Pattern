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
import square.Square;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SquareDialog extends JDialog {

	private final JPanel mainPanel = new JPanel();
	private JButton btnOk;
	private JButton btnCancel;
	private JButton btnBorderColor;
	private JButton btnInnerColor;
	private JTextField txtXCoordinate;
	private JTextField txtYCoordinate;
	private JTextField txtSideLength;
	private JLabel lblSquare;
	private JLabel lblXCoordinate;
	private JLabel lblYCoordinate;
	private JLabel lblPointUpperLeft;
	private Color innerColor;
	private Color borderColor;
	
	private Square squareDialog;
	
	private boolean ok;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SquareDialog dialog = new SquareDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SquareDialog() {
		setBounds(100, 100, 449, 349);
		setModal(true);
		setBounds(100, 100, 404, 358);
		getContentPane().setLayout(new BorderLayout());
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		JLabel lblSquare = new JLabel("Square");
		lblSquare.setFont(new Font("Tahoma", Font.BOLD, 13));
		JLabel lblPointUpperLeft = new JLabel("Point upper left ");
		lblPointUpperLeft.setFont(new Font("Tahoma", Font.PLAIN, 12));
		JLabel lblXCoordinate = new JLabel("X Coordinate :");
		JLabel lblYCoordinate = new JLabel("Y Coordinate :");
		txtXCoordinate = new JTextField();
		txtXCoordinate.setColumns(10);
		txtYCoordinate = new JTextField();
		txtYCoordinate.setColumns(10);
		JLabel lblSideLength = new JLabel("Side length :");
		lblSideLength.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSideLength = new JTextField();
		txtSideLength.setColumns(10);
		JLabel lblBorderColor = new JLabel("Border Color :");
		JLabel lblInnerColor = new JLabel("Inner Color :");
		btnBorderColor = new JButton("");
		btnBorderColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borderColor = JColorChooser.showDialog(null, "Choose border color", borderColor);
				if (borderColor != null) {
					btnBorderColor.setBackground(borderColor);
				}
			}
		});
		btnInnerColor = new JButton("");
		btnInnerColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				innerColor = JColorChooser.showDialog(null, "Choose inner color",
						innerColor);
				if (innerColor != null) {
					btnInnerColor.setBackground(innerColor);
				}
			}
		});
		GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
		gl_mainPanel.setHorizontalGroup(
			gl_mainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mainPanel.createSequentialGroup()
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addGap(178)
							.addComponent(lblSquare))
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addGap(136)
							.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_mainPanel.createSequentialGroup()
									.addComponent(lblYCoordinate)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtYCoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_mainPanel.createSequentialGroup()
									.addComponent(lblXCoordinate)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtXCoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addGap(88)
							.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_mainPanel.createSequentialGroup()
									.addComponent(lblSideLength)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtSideLength, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblPointUpperLeft)
								.addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING)
									.addGroup(Alignment.LEADING, gl_mainPanel.createSequentialGroup()
										.addGap(14)
										.addComponent(lblInnerColor)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnInnerColor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGroup(Alignment.LEADING, gl_mainPanel.createSequentialGroup()
										.addGap(6)
										.addComponent(lblBorderColor)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnBorderColor, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))))))
					.addGap(129))
		);
		gl_mainPanel.setVerticalGroup(
			gl_mainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mainPanel.createSequentialGroup()
					.addComponent(lblSquare)
					.addGap(13)
					.addComponent(lblPointUpperLeft)
					.addGap(11)
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblXCoordinate)
						.addComponent(txtXCoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYCoordinate)
						.addComponent(txtYCoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSideLength)
						.addComponent(txtSideLength, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnBorderColor, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBorderColor))
					.addGap(18)
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnInnerColor, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblInnerColor))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		mainPanel.setLayout(gl_mainPanel);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnOk = new JButton("OK");
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						try {
							squareDialog = new Square();
							Point upperLeft = new Point(Integer.parseInt(getTxtXCoordinate().getText()),
									Integer.parseInt(getTxtYCoordinate().getText()));
							squareDialog.setUpperLeft(upperLeft);
							squareDialog.setSideLength(Integer.parseInt(getTxtSideLength().getText()));
							squareDialog.setBorderColor(btnBorderColor.getBackground());
							squareDialog.setClrInnerColor(btnInnerColor.getBackground());
							setModal(true);
							setOk(true);
							setVisible(false);

						} catch (Exception exception) {
							JOptionPane.showMessageDialog(null, "You didn't input the number","Warning",JOptionPane.WARNING_MESSAGE);
						}
					}
				});
				btnOk.setActionCommand("OK");
				getRootPane().setDefaultButton(btnOk);
			}
			{
				btnCancel = new JButton("Cancel");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						squareDialog = null;
						setOk(false);
					}
				});
				btnCancel.setActionCommand("Cancel");
			}
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGap(147)
						.addComponent(btnOk)
						.addGap(18)
						.addComponent(btnCancel)
						.addGap(157))
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_buttonPane.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnOk)
							.addComponent(btnCancel))
						.addContainerGap())
			);
			buttonPane.setLayout(gl_buttonPane);
		}
	}

	public JButton getBtnOk() {
		return btnOk;
	}

	public void setBtnOk(JButton btnOk) {
		this.btnOk = btnOk;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}

	public JButton getBtnBorderColor() {
		return btnBorderColor;
	}

	public void setBtnBorderColor(JButton btnBorderColor) {
		this.btnBorderColor = btnBorderColor;
	}

	public JButton getBtnInnerColor() {
		return btnInnerColor;
	}

	public void setBtnInnerColor(JButton btnInnerColor) {
		this.btnInnerColor = btnInnerColor;
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

	public JTextField getTxtSideLength() {
		return txtSideLength;
	}

	public void setTxtSideLength(JTextField txtSideLength) {
		this.txtSideLength = txtSideLength;
	}

	public JLabel getLblSquare() {
		return lblSquare;
	}

	public void setLblSquare(JLabel lblSquare) {
		this.lblSquare = lblSquare;
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

	public JLabel getLblPointUpperLeft() {
		return lblPointUpperLeft;
	}

	public void setLblPointUpperLeft(JLabel lblPointUpperLeft) {
		this.lblPointUpperLeft = lblPointUpperLeft;
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

	public Square getSquareDialog() {
		return squareDialog;
	}

	public void setSquareDialog(Square squareDialog) {
		this.squareDialog = squareDialog;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

}
