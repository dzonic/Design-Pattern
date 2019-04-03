package dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import line.Line;
import point.Point;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LineDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton okButton;
	private JButton cancelButton;
	private JTextField txtXCoordinateStart;
	private JTextField txtYCoordinateStart;
	private JTextField txtXCoordinateEnd;
	private JTextField txtYCoordinateEnd;
	private JButton btnColorLine;
	private JLabel lblXCoordinateStart;
	private JLabel lblYCoordinateEnd;
	private JLabel lblYCoordinateStart;
	private JLabel lblXCoordinateEnd;
	
	private Color color;
	private Point pStart;
	private Point pEnd;
	private Line lineDialog;
	
	private boolean ok = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LineDialog dialog = new LineDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LineDialog() {
		//setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		setMinimumSize(new Dimension(430, 340));
		setBounds(100, 100, 556, 380);
		setModal(true);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblLine = new JLabel("Line");
		lblLine.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblStartPoint = new JLabel("Start point");
		lblStartPoint.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblEndPoint = new JLabel("End point");
		lblEndPoint.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblXCoordinateStart = new JLabel("X Coordinate:");
		
		JLabel lblYCoordinateStart = new JLabel("Y Coordinate :");
		
		JLabel lblXCoordinateEnd = new JLabel("X Coordinate :");
		
		JLabel lblYCoordinateEnd = new JLabel("Y Coordinate :");
		
		JLabel lblColor = new JLabel("Color :");
		
		txtXCoordinateStart = new JTextField();
		txtXCoordinateStart.setColumns(10);
		
		txtYCoordinateStart = new JTextField();
		txtYCoordinateStart.setColumns(10);
		
		txtXCoordinateEnd = new JTextField();
		txtXCoordinateEnd.setColumns(10);
		
		txtYCoordinateEnd = new JTextField();
		txtYCoordinateEnd.setColumns(10);
		
	    btnColorLine = new JButton("");
		btnColorLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = JColorChooser.showDialog(null, "Choose color", color);
				if (color != null) {
					btnColorLine.setBackground(color);
				}
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(184)
					.addComponent(lblLine)
					.addContainerGap(208, Short.MAX_VALUE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblStartPoint)
							.addPreferredGap(ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
							.addComponent(lblEndPoint)
							.addGap(90))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblXCoordinateStart)
								.addComponent(lblYCoordinateStart))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(txtXCoordinateStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtYCoordinateStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(52)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addComponent(lblYCoordinateEnd)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtYCoordinateEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addComponent(lblXCoordinateEnd)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtXCoordinateEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblColor)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnColorLine, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)))
							.addGap(7))))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLine)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStartPoint)
						.addComponent(lblEndPoint))
					.addGap(34)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblXCoordinateStart)
						.addComponent(lblXCoordinateEnd)
						.addComponent(txtXCoordinateStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtXCoordinateEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYCoordinateStart)
						.addComponent(lblYCoordinateEnd)
						.addComponent(txtYCoordinateStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtYCoordinateEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblColor)
						.addComponent(btnColorLine, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
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
							lineDialog = new Line();
							pStart = new Point(Integer.parseInt(getTxtXCoordinateStart().getText()),
									Integer.parseInt(getTxtYCoordinateStart().getText()));
							pEnd = new Point(Integer.parseInt(getTxtXCoordinateEnd().getText()),
									Integer.parseInt(getTxtYCoordinateEnd().getText()));
							lineDialog.setpStart(pStart);
							lineDialog.setpEnd(pEnd);
							lineDialog.setBorderColor(btnColorLine.getBackground());
							setOk(true);
							setVisible(false);
						} catch (Exception g) {
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
						lineDialog = null;
						setOk(false);
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
			}
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGap(169)
						.addComponent(okButton)
						.addGap(18)
						.addComponent(cancelButton)
						.addGap(135))
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_buttonPane.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(okButton)
							.addComponent(cancelButton))
						.addContainerGap())
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

	public JTextField getTxtXCoordinateStart() {
		return txtXCoordinateStart;
	}

	public void setTxtXCoordinateStart(JTextField txtXCoordinateStart) {
		this.txtXCoordinateStart = txtXCoordinateStart;
	}

	public JTextField getTxtYCoordinateStart() {
		return txtYCoordinateStart;
	}

	public void setTxtYCoordinateStart(JTextField txtYCoordinateStart) {
		this.txtYCoordinateStart = txtYCoordinateStart;
	}

	public JTextField getTxtXCoordinateEnd() {
		return txtXCoordinateEnd;
	}

	public void setTxtXCoordinateEnd(JTextField txtXCoordinateEnd) {
		this.txtXCoordinateEnd = txtXCoordinateEnd;
	}

	public JTextField getTxtYCoordinateEnd() {
		return txtYCoordinateEnd;
	}

	public void setTxtYCoordinateEnd(JTextField txtYCoordinateEnd) {
		this.txtYCoordinateEnd = txtYCoordinateEnd;
	}

	public JButton getBtnColorLine() {
		return btnColorLine;
	}

	public void setBtnColorLine(JButton btnColorLine) {
		this.btnColorLine = btnColorLine;
	}

	public JLabel getLblXCoordinateStart() {
		return lblXCoordinateStart;
	}

	public void setLblXCoordinateStart(JLabel lblXCoordinateStart) {
		this.lblXCoordinateStart = lblXCoordinateStart;
	}

	public JLabel getLblYCoordinateEnd() {
		return lblYCoordinateEnd;
	}

	public void setLblYCoordinateEnd(JLabel lblYCoordinateEnd) {
		this.lblYCoordinateEnd = lblYCoordinateEnd;
	}

	public JLabel getLblYCoordinateStart() {
		return lblYCoordinateStart;
	}

	public void setLblYCoordinateStart(JLabel lblYCoordinateStart) {
		this.lblYCoordinateStart = lblYCoordinateStart;
	}

	public JLabel getLblXCoordinateEnd() {
		return lblXCoordinateEnd;
	}

	public void setLblXCoordinateEnd(JLabel lblXCoordinateEnd) {
		this.lblXCoordinateEnd = lblXCoordinateEnd;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Point getpStart() {
		return pStart;
	}

	public void setpStart(Point pStart) {
		this.pStart = pStart;
	}

	public Point getpEnd() {
		return pEnd;
	}

	public void setpEnd(Point pEnd) {
		this.pEnd = pEnd;
	}

	public Line getLineDialog() {
		return lineDialog;
	}

	public void setLineDialog(Line lineDialog) {
		this.lineDialog = lineDialog;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public JPanel getContentPanel() {
		return contentPanel;
	}
}
