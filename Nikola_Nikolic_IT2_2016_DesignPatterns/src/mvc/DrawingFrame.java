package mvc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import java.awt.Dimension;

public class DrawingFrame extends JFrame {

	private DrawingView view = new DrawingView();
	private ShapesView sView = new ShapesView();
	private DrawingController controller;
	private JList logList;
	private DefaultListModel<String> dlmList = new DefaultListModel<String>();
	private JPanel panel = new JPanel();
	private JButton btnModify, btnDelete, btnUndo, btnRedo, btnBorderColor, btnInnerColor;
	private JButton btnSendToBack;
	private JButton btnSendToFront;
	private JButton btnBringToBack;
	private JButton btnBringToFront;
	private Color color;
	private JButton btnLoad;
	private JButton btnSave;
	private JButton btnOpen;
	private JToggleButton tglbtnSelect;
	private String colors = "#f0f0f0";
	

	public DrawingView getView() {
		return view;
	}

	public void setController(DrawingController controller) {
		this.controller = controller;

	}

	public DrawingFrame() {
		
		

		getContentPane().add(view, BorderLayout.CENTER);
		getContentPane().add(sView, BorderLayout.WEST);
		 btnModify= new JButton(""); 
		 btnModify.setIcon(new ImageIcon(DrawingFrame.class.getResource("/icons/modify.png")));
		 btnModify.setEnabled(false);
		 btnModify.setBorder(null);
		 btnModify.setBorderPainted(false);
		 btnModify.setBackground(Color.decode(colors));
		  
		  btnDelete= new JButton(""); 
		  btnDelete.setIcon(new ImageIcon(DrawingFrame.class.getResource("/icons/delete.png")));
		  btnDelete.setEnabled(false);
		  btnDelete.setBorder(null);
		  btnDelete.setBorderPainted(false);
		  btnDelete.setBackground(Color.decode(colors));
		  
		  btnUndo= new JButton(""); 
		  btnUndo.setIcon(new ImageIcon(DrawingFrame.class.getResource("/icons/undo.png")));
		  btnUndo.setBorder(null);
		  btnUndo.setBorderPainted(false);
		  btnUndo.setBackground(Color.decode(colors));
		 
		  btnUndo.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		controller.undo();
		  	}
		  });btnUndo.setEnabled(false);
		  
		  btnRedo= new JButton(""); 
		  btnRedo.setBorder(null);
		  btnRedo.setBorderPainted(false);
		  btnRedo.setBackground(Color.decode(colors));
		  
		  
		  btnRedo.setIcon(new ImageIcon(DrawingFrame.class.getResource("/icons/redo.png")));
		  btnRedo.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent arg0) {
		  		controller.redo();
		  	}
		  });btnRedo.setEnabled(false);
		  
		  btnSendToBack =new JButton("Send to Back");
		  btnSendToBack.setEnabled(false);
		  btnSendToBack.setBackground(Color.WHITE);
		  
		  btnSendToBack.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		controller.sendToBack();
		  	}
		  });
		  
		  btnSendToFront =new JButton("Send to Front");
		  btnSendToFront.setBackground(Color.WHITE);
		  
		  btnSendToFront.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		controller.sendToFront();
		  	}
		  });
		  btnSendToFront.setEnabled(false);
		  
		  btnBringToFront = new JButton("Bring to Front");
		  btnBringToFront.setBackground(Color.WHITE);
		 
		  btnBringToFront.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		controller.bringToFront();
		  	}
		  });
		  btnBringToFront.setEnabled(false);
		  
		  btnBringToBack = new JButton("Bring to Back");
		  btnBringToBack.setBackground(Color.WHITE);
		  btnBringToBack.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		controller.bringToBack();
		  	}
		  });
		  btnBringToBack.setEnabled(false);
		 
         tglbtnSelect = new JToggleButton("");  
         tglbtnSelect.setBorder(null);
         tglbtnSelect.setBorderPainted(false);
         tglbtnSelect.setBackground(Color.decode(colors));
 		
		sView.getShapes().add(tglbtnSelect);

		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.SOUTH);

		logList = new JList<String>(dlmList);
		scrollPane.setViewportView(logList);
		

		getContentPane().add(panel, BorderLayout.NORTH);

		JLabel lblBorderColor = new JLabel("Border color:");

		JLabel lblInnerColor = new JLabel("Inner color :");

		btnBorderColor = new JButton("");
		btnBorderColor.setMinimumSize(new Dimension(20, 6));
		btnBorderColor.setPreferredSize(new Dimension(25, 6));
		btnBorderColor.setMaximumSize(new Dimension(20, 6));
		btnBorderColor.setBackground(color.BLACK);
		btnBorderColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = JColorChooser.showDialog(null, "Choose color", color);
				if (color != null) {
					btnBorderColor.setBackground(color);
				}

			}
		});

		btnInnerColor = new JButton("");
		btnInnerColor.setBackground(color.WHITE);
		btnInnerColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = JColorChooser.showDialog(null, "Choose color", color);
				if (color != null) {
					btnInnerColor.setBackground(color);
				}
			}
		});

		getBtnModify().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.btnModifyShape(e);
			}
		});
		
		 btnOpen = new JButton("");
		 btnOpen.setIcon(new ImageIcon(DrawingFrame.class.getResource("/icons/open.png")));
		 btnOpen.setVerticalAlignment(SwingConstants.BOTTOM);
		 btnOpen.setHorizontalAlignment(SwingConstants.RIGHT);
		 btnOpen.setBorder(null);
		 btnOpen.setBorderPainted(false);
		 btnOpen.setBackground(Color.decode(colors));
		 btnOpen.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		controller.open();
		 	}
		 });
		
		 btnSave = new JButton("");
		 btnSave.setIcon(new ImageIcon(DrawingFrame.class.getResource("/icons/save.png")));
		 btnSave.setEnabled(false);
		 btnSave.setVerticalAlignment(SwingConstants.BOTTOM);
		 btnSave.setBorder(null);
		 btnSave.setBorderPainted(false);
		 btnSave.setBackground(Color.decode(colors));
		 btnSave.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		controller.save();
		 	}
		 });
		
		 btnLoad = new JButton("");
		 btnLoad.setIcon(new ImageIcon(DrawingFrame.class.getResource("/icons/load.png")));
		 btnLoad.setVerticalAlignment(SwingConstants.BOTTOM);
		 btnLoad.setBorder(null);
		 btnLoad.setBorderPainted(false);
		 btnLoad.setBackground(Color.decode(colors));
		 btnLoad.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		controller.load();
		 	}
		 });
		 
		 btnLoad.setEnabled(false);
		 
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnDelete, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(tglbtnSelect, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnModify, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(54)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnBringToBack)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(btnOpen)
									.addGap(18)
									.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnLoad)
									.addGap(36)
									.addComponent(btnSendToBack)))
							.addGap(36)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnSendToFront)
								.addComponent(btnBringToFront)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(47)
							.addComponent(btnUndo)
							.addGap(10)
							.addComponent(btnRedo)
							.addGap(56)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblBorderColor, Alignment.LEADING)
								.addComponent(lblInnerColor, Alignment.LEADING))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnBorderColor, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnInnerColor, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))))
					.addGap(128))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(tglbtnSelect, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnModify)
										.addGap(18))
									.addGroup(gl_panel.createSequentialGroup()
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
											.addComponent(btnSendToBack)
											.addComponent(btnSendToFront))
										.addGap(18)
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
											.addComponent(btnBringToBack)
											.addComponent(btnBringToFront))
										.addGap(50)))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnSave, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnLoad, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnDelete)
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnBorderColor, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblBorderColor))))
							.addGap(18))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnOpen)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblInnerColor)
							.addContainerGap())
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(btnInnerColor, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addGap(43))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(btnRedo, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
								.addContainerGap())
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(btnUndo, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
								.addContainerGap()))))
		);
		tglbtnSelect.setIcon(new ImageIcon(DrawingFrame.class.getResource("/icons/select.png")));

		
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.btnDeletePressed(e);
			}
		});
		tglbtnSelect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.tglbtnSelectPressed(e);
			}
		});
		panel.setLayout(gl_panel);

		view.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controller.mouseClicked(arg0);
				
			}
		});

		sView.getTglbtnPoint().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.tglbtnPointPressed(e);
			}
		});

		sView.getTglbtnLine().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.tglbtnLinePressed(e);
			}
		});

		sView.getTglbtnSquare().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.tglbtnSquarePressed(e);
			}
		});
		sView.getTglbtnRectangle().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.tglbtnRectanglePressed(e);
			}
		});
		sView.getTglbtnCircle().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.tglbtnCirclePressed(e);
			}
		});
		sView.getTglbtnHexagon().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.tglbtnHexagonPressed(e);
			}
		});
	}

	public JList getLogList() {
		return logList;
	}

	public void setLogList(JList logList) {
		this.logList = logList;
	}

	public DefaultListModel<String> getDlmList() {
		return dlmList;
	}

	public void setDlmList(DefaultListModel<String> dlmList) {
		this.dlmList = dlmList;
	}

	public ShapesView getsView() {
		return sView;
	}

	public void setsView(ShapesView sView) {
		this.sView = sView;
	}

	public DrawingController getController() {
		return controller;
	}

	public JPanel getPanel() {
		return panel;
	}

	public JButton getBtnModify() {
		return btnModify;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public JButton getBtnUndo() {
		return btnUndo;
	}

	public JButton getBtnRedo() {
		return btnRedo;
	}

	public JButton getBtnSendToBack() {
		return btnSendToBack;
	}

	public JButton getBtnSendToFront() {
		return btnSendToFront;
	}

	public JButton getBtnBringToBack() {
		return btnBringToBack;
	}

	public JButton getBtnBringToFront() {
		return btnBringToFront;
	}

	public void setView(DrawingView view) {
		this.view = view;
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

	public JToggleButton getTglbtnSelect() {
		return tglbtnSelect;
	}

	public void setTglbtnSelect(JToggleButton tglbtnSelect) {
		this.tglbtnSelect = tglbtnSelect;
	}

	public JButton getBtnLoad() {
		return btnLoad;
	}

	public void setBtnLoad(JButton btnLoad) {
		this.btnLoad = btnLoad;
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(JButton btnSave) {
		this.btnSave = btnSave;
	}

	public JButton getBtnOpen() {
		return btnOpen;
	}

	public void setBtnOpen(JButton btnOpen) {
		this.btnOpen = btnOpen;
	}
}
