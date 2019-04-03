package dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import circle.Circle;
import point.Point;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CircleDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnOk;
	private JButton btnCancel;
	private JTextField txtXCenter;
	private JTextField txtYCenter;
	private JTextField txtRadius;
	private Color borderColor;
	private Color innerColor;
	private JButton btnInnerColor;
	private JButton btnBorderColor;
	private boolean ok;
	private Circle circleDialog;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CircleDialog dialog = new CircleDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CircleDialog() {
		setModal(true);
		setBounds(100, 100, 450, 347);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JLabel lblCircle = new JLabel("Circle");
		lblCircle.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblCenter = new JLabel("Center :");
		lblCenter.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JLabel lblXCoordinate = new JLabel("X coordinate :");

		JLabel lblYCoordinate = new JLabel("Y coordinate :");

		JLabel lblRadius = new JLabel("Radius");

		JLabel lblBorderColor = new JLabel("Border color");

		JLabel lblInnerColor = new JLabel("Inner color ");

		txtXCenter = new JTextField();
		txtXCenter.setColumns(10);

		txtYCenter = new JTextField();
		txtYCenter.setColumns(10);

		txtRadius = new JTextField();
		txtRadius.setColumns(10);

		btnBorderColor = new JButton("");
		btnBorderColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borderColor = JColorChooser.showDialog(null, "Edge color", borderColor);
				if (borderColor != null) {
					btnBorderColor.setBackground(borderColor);
				}
			}
		});

		btnInnerColor = new JButton("");
		btnInnerColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				innerColor = JColorChooser.showDialog(null, "Inside color", innerColor);
				if (innerColor != null) {
					btnInnerColor.setBackground(innerColor);
				}
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGroup(gl_contentPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(176).addComponent(lblCircle))
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(94).addComponent(lblCenter))
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(116)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPanel.createSequentialGroup().addComponent(lblXCoordinate)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(txtXCenter,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPanel.createSequentialGroup()
												.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
														.addComponent(lblYCoordinate).addComponent(lblRadius))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
														.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(txtYCenter, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_contentPanel.createSequentialGroup()
												.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
														.addComponent(lblBorderColor)
														.addGroup(gl_contentPanel.createSequentialGroup()
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(lblInnerColor)))
												.addGap(18)
												.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
														.addComponent(btnInnerColor, GroupLayout.DEFAULT_SIZE, 85,
																Short.MAX_VALUE)
														.addComponent(btnBorderColor, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
						.addGap(146)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPanel
				.createSequentialGroup().addContainerGap().addComponent(lblCircle)
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblCenter).addGap(18)
				.addGroup(gl_contentPanel
						.createParallelGroup(Alignment.BASELINE).addComponent(lblXCoordinate).addComponent(txtXCenter,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPanel
						.createParallelGroup(Alignment.BASELINE).addComponent(lblYCoordinate).addComponent(txtYCenter,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblRadius).addComponent(
						txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblBorderColor)
						.addComponent(btnBorderColor, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblInnerColor)
						.addComponent(btnInnerColor, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
				.addContainerGap()));
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnOk = new JButton("OK");
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							circleDialog = new Circle();
							Point center = new Point(Integer.parseInt(getTxtXCenter().getText()),
									Integer.parseInt(getTxtYCenter().getText()));
							circleDialog.setCenter(center);
							circleDialog.setR(Integer.parseInt(getTxtRadius().getText()));
							circleDialog.setBorderColor(btnBorderColor.getBackground());
							circleDialog.setClrInnerColor(btnInnerColor.getBackground());
							setModal(true);
							setOk(true);
							setVisible(false);
						} catch (Exception exc) {
							JOptionPane.showMessageDialog(null, "You didn't input the number", "Warning",
									JOptionPane.WARNING_MESSAGE);
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
						circleDialog = null;
						setOk(false);
					}
				});
				btnCancel.setActionCommand("Cancel");
			}
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup().addGap(169).addComponent(btnOk)
							.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnCancel).addGap(147)));
			gl_buttonPane
					.setVerticalGroup(gl_buttonPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_buttonPane.createSequentialGroup().addGap(5)
									.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE)
											.addComponent(btnCancel).addComponent(btnOk))
									.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
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

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public Color getInnerColor() {
		return innerColor;
	}

	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
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

	public Circle getCircleDialog() {
		return circleDialog;
	}

	public void setCircleDialog(Circle circleDialog) {
		this.circleDialog = circleDialog;
	}

	public JPanel getContentPanel() {
		return contentPanel;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}
}
