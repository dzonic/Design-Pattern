package mvc;

import javax.swing.JPanel;

import mvc.DrawingController;
import mvc.DrawingView;

import java.awt.GridBagLayout;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JToggleButton;

public class ShapesView extends JPanel {
	private ButtonGroup shapes = new ButtonGroup();
	private JToggleButton tglbtnPoint;
	private JToggleButton tglbtnLine;
	private JToggleButton tglbtnSquare;
	private JToggleButton tglbtnRectangle;
	private JToggleButton tglbtnCircle;
	private JToggleButton tglbtnHexagon;
	private String color = "#f0f0f0";

	public ShapesView() {

		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.WEST);

		tglbtnPoint = new JToggleButton("");
		tglbtnPoint.setIcon(new ImageIcon(ShapesView.class.getResource("/icons/point.png")));
		tglbtnPoint.setBorder(null);
		tglbtnPoint.setBorderPainted(false);
		tglbtnPoint.setBackground(Color.decode(color));
		shapes.add(tglbtnPoint);

		tglbtnLine = new JToggleButton("");
		tglbtnLine.setIcon(new ImageIcon(ShapesView.class.getResource("/icons/line.png")));
		tglbtnLine.setBorder(null);
		tglbtnLine.setBorderPainted(false);

		tglbtnLine.setBackground(Color.decode(color));
		shapes.add(tglbtnLine);

		tglbtnSquare = new JToggleButton("");
		tglbtnSquare.setIcon(new ImageIcon(ShapesView.class.getResource("/icons/square.png")));
		shapes.add(tglbtnSquare);
		tglbtnSquare.setBorder(null);
		tglbtnSquare.setBorderPainted(false);
		tglbtnSquare.setBackground(Color.decode(color));

		tglbtnRectangle = new JToggleButton("");
		tglbtnRectangle.setIcon(new ImageIcon(ShapesView.class.getResource("/icons/rectangle.png")));
		shapes.add(tglbtnRectangle);
		tglbtnRectangle.setBorder(null);
		tglbtnRectangle.setBorderPainted(false);
		tglbtnRectangle.setBackground(Color.decode(color));

		tglbtnCircle = new JToggleButton("");
		tglbtnCircle.setIcon(new ImageIcon(ShapesView.class.getResource("/icons/circle.png")));
		shapes.add(tglbtnCircle);
		tglbtnCircle.setBorder(null);
		tglbtnCircle.setBorderPainted(false);
		tglbtnCircle.setBackground(Color.decode(color));

		tglbtnHexagon = new JToggleButton("");
		tglbtnHexagon.setIcon(new ImageIcon(ShapesView.class.getResource("/icons/Hexagon.png")));
		shapes.add(tglbtnHexagon);
		tglbtnHexagon.setBorder(null);
		tglbtnHexagon.setBorderPainted(false);
		tglbtnHexagon.setBackground(Color.decode(color));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(tglbtnRectangle, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
						.addComponent(tglbtnSquare, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
						.addComponent(tglbtnPoint, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
						.addComponent(tglbtnLine, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
						.addComponent(tglbtnCircle, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
						.addComponent(tglbtnHexagon, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(tglbtnPoint)
					.addGap(18)
					.addComponent(tglbtnLine)
					.addGap(14)
					.addComponent(tglbtnSquare)
					.addGap(18)
					.addComponent(tglbtnRectangle)
					.addGap(18)
					.addComponent(tglbtnCircle)
					.addGap(18)
					.addComponent(tglbtnHexagon)
					.addContainerGap(54, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);

		GridBagConstraints gbc_panelView = new GridBagConstraints();
		gbc_panelView.insets = new Insets(0, 0, 5, 0);
		gbc_panelView.fill = GridBagConstraints.BOTH;
		gbc_panelView.gridx = 0;
		gbc_panelView.gridy = 1;

	}

	public JToggleButton getTglbtnPoint() {
		return tglbtnPoint;
	}

	public void setTglbtnPoint(JToggleButton tglbtnPoint) {
		this.tglbtnPoint = tglbtnPoint;
	}

	public JToggleButton getTglbtnLine() {
		return tglbtnLine;
	}

	public void setTglbtnLine(JToggleButton tglbtnLine) {
		this.tglbtnLine = tglbtnLine;
	}

	public JToggleButton getTglbtnSquare() {
		return tglbtnSquare;
	}

	public void setTglbtnSquare(JToggleButton tglbtnSquare) {
		this.tglbtnSquare = tglbtnSquare;
	}

	public JToggleButton getTglbtnRectangle() {
		return tglbtnRectangle;
	}

	public void setTglbtnRectangle(JToggleButton tglbtnRectangle) {
		this.tglbtnRectangle = tglbtnRectangle;
	}

	public JToggleButton getTglbtnCircle() {
		return tglbtnCircle;
	}

	public void setTglbtnCircle(JToggleButton tglbtnCircle) {
		this.tglbtnCircle = tglbtnCircle;
	}

	public JToggleButton getTglbtnHexagon() {
		return tglbtnHexagon;
	}

	public void setTglbtnHexagon(JToggleButton tglbtnHexagon) {
		this.tglbtnHexagon = tglbtnHexagon;
	}

	public ButtonGroup getShapes() {
		return shapes;
	}

	public void setShapes(ButtonGroup shapes) {
		this.shapes = shapes;
	}
}
