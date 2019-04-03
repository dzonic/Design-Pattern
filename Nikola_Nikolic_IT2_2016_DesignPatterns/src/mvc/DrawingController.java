package mvc;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import circle.Circle;
import command.AddShape;
import command.BringToBack;
import command.BringToFront;
import command.Command;
import strategy.FileOperations;
import strategy.ImageStrategy;
import strategy.LogOperations;
import command.RemoveShape;
import command.SelectShape;
import command.SendToBack;
import command.SendToFront;
import command.UpdateCircle;
import command.UpdateHexagon;
import command.UpdateLine;
import command.UpdatePoint;
import command.UpdateRectangle;
import command.UpdateSquare;
import dialogs.CircleDialog;
import dialogs.HexagonDialog;
import dialogs.LineDialog;
import dialogs.PointDialog;
import dialogs.RectangleDialog;
import dialogs.SquareDialog;
import hexagon.Hexagon;
import hexagon.HexagonAdapter;
import line.Line;
import model.DrawingModel;
import point.Point;
import rectangle.Rectangle;
import shapes.Shape;

import square.Square;
import strategy.Strategy;
import rectangle.Rectangle;

public class DrawingController {

	private DrawingModel model;
	private DrawingFrame frame;
	private int selShape = 0;
	Stack<Command> undo = new Stack<Command>();
	Stack<Command> redo = new Stack<Command>();
	Stack<String> loadStack = new Stack<String>();
	private PointDialog pointDialog;
	private LineDialog lineDialog;
	private SquareDialog squareDialog;
	private RectangleDialog rectangleDialog;
	private CircleDialog circleDialog;
	private HexagonDialog hexagonDialog;
	private Point point;
	private Line line;
	private Square square;
	private Rectangle rectangle;
	private Circle circle;
	private HexagonAdapter hexagon;
	private boolean selected = false;
	private int x, y;
	private int click = 0;
	private Point t1;
	private Point t2;

	File file = null;

	public DrawingController(DrawingModel model, DrawingFrame frame) {
		this.model = model;
		this.frame = frame;
	}

	public void mouseClicked(MouseEvent e) {
		Command cmd = null;
		if (selShape == 1) {
			x = e.getX();
			y = e.getY();
			Point t = new Point(x, y);
			t.setBorderColor(frame.getBtnBorderColor().getBackground());
			cmd = new AddShape(model, t);
			frame.getDlmList().add(0,"Added => " + t);
			cmd.execute();
			undo.push(cmd);

		} else if (selShape == 2) {
			if (click == 0) {
				int x = e.getX();
				int y = e.getY();
				t1 = new Point(x, y);
				click++;
			} else if (click == 1) {
				int x = e.getX();
				int y = e.getY();
				t2 = new Point(x, y);

				Line l = new Line(t1, t2);
				l.setBorderColor(frame.getBtnBorderColor().getBackground());

				cmd = new AddShape(model, l);
				frame.getDlmList().add(0, "Added => " + l);
				click = 0;
				cmd.execute();
				undo.push(cmd);

			}
		} else if (selShape == 3) {
			x = e.getX();
			y = e.getY();
			circleDialog = new CircleDialog();
			circleDialog.getTxtXCenter().setText(String.valueOf(x));
			circleDialog.getTxtYCenter().setText(String.valueOf(y));
			circleDialog.getBtnInnerColor().setBackground(frame.getBtnInnerColor().getBackground());
			circleDialog.getBtnBorderColor().setBackground(frame.getBtnBorderColor().getBackground());

			circleDialog.getTxtXCenter().setEditable(false);
			circleDialog.getTxtYCenter().setEditable(false);
			circleDialog.getBtnInnerColor().setEnabled(false);
			circleDialog.getBtnBorderColor().setEnabled(false);

			circleDialog.setVisible(true);
			if (circleDialog.getCircleDialog() != null) {
				circle = circleDialog.getCircleDialog();
				cmd = new AddShape(model, circle);
				frame.getDlmList().add(0, "Added => " + circle);
				cmd.execute();
				undo.push(cmd);

			}
		} else if (selShape == 4) {
			x = e.getX();
			y = e.getY();
			squareDialog = new SquareDialog();
			squareDialog.getTxtXCoordinate().setText(String.valueOf(x));
			squareDialog.getTxtYCoordinate().setText(String.valueOf(y));
			squareDialog.getBtnBorderColor().setBackground(frame.getBtnBorderColor().getBackground());
			squareDialog.getBtnInnerColor().setBackground(frame.getBtnInnerColor().getBackground());

			squareDialog.getTxtXCoordinate().setEditable(false);
			squareDialog.getTxtYCoordinate().setEditable(false);
			squareDialog.getBtnBorderColor().setEnabled(false);
			squareDialog.getBtnInnerColor().setEnabled(false);

			squareDialog.setVisible(true);
			if (squareDialog.getSquareDialog() != null) {
				square = squareDialog.getSquareDialog(); 
				cmd = new AddShape(model, square); 
				frame.getDlmList().add(0, "Added => " + square); 
				cmd.execute();
				undo.push(cmd);

			}
		} else if (selShape == 5) {
			x = e.getX();
			y = e.getY();

			rectangleDialog = new RectangleDialog();
			rectangleDialog.getTxtXCoordinate().setText(String.valueOf(x));
			rectangleDialog.getTxtYCoordinate().setText(String.valueOf(y));
			rectangleDialog.getBtnBorderColor().setBackground(frame.getBtnBorderColor().getBackground());
			rectangleDialog.getBtnInnerColor().setBackground(frame.getBtnInnerColor().getBackground());

			rectangleDialog.getTxtXCoordinate().setEditable(false);
			rectangleDialog.getTxtYCoordinate().setEditable(false);
			rectangleDialog.getBtnBorderColor().setEnabled(false);
			rectangleDialog.getBtnInnerColor().setEnabled(false);

			rectangleDialog.setVisible(true);
			if (rectangleDialog.isOk()) {

				rectangle = rectangleDialog.getRectangleDialog();
				cmd = new AddShape(model, rectangle);
				frame.getDlmList().add(0, "Added => " + rectangle);
				cmd.execute();
				undo.push(cmd);

			}
		}

		else if (selShape == 6) {
			x = e.getX();
			y = e.getY();
			hexagonDialog = new HexagonDialog();
			hexagonDialog.getTxtXCenter().setText(String.valueOf(x));
			hexagonDialog.getTxtYCenter().setText(String.valueOf(y));
			hexagonDialog.getBtnInnerColor().setBackground(frame.getBtnInnerColor().getBackground());
			hexagonDialog.getBtnBorderColor().setBackground(frame.getBtnBorderColor().getBackground());

			hexagonDialog.getTxtXCenter().setEditable(false);
			hexagonDialog.getTxtYCenter().setEditable(false);
			hexagonDialog.getBtnInnerColor().setEnabled(false);
			hexagonDialog.getBtnBorderColor().setEnabled(false);

			hexagonDialog.setVisible(true);
			if (hexagonDialog.isOk()) {
				hexagon = hexagonDialog.getHexagonDialog();
				cmd = new AddShape(model, hexagon);
				frame.getDlmList().add(0, "Added => " + hexagon);
				cmd.execute();
				undo.push(cmd);

			}
		} else if (selShape == 0) {

			x = e.getX();
			y = e.getY();
			selected = false;

			for (int i = model.getAll().size() - 1; i >= 0; i--) {
				if (model.getAll().get(i).contains(x, y)) {
					if (!model.getAll().get(i).isSelected()) {

						selected = true;
						cmd = new SelectShape(model, model.getAll().get(i));
						frame.getDlmList().add(0, "Selected => " + model.getAll().get(i).toString());
						cmd.execute();
						undo.push(cmd);
						break;
					} else {
						cmd = new SelectShape(model, model.getAll().get(i));
						frame.getDlmList().add(0, "Deselected => " + model.getAll().get(i).toString());
						cmd.unexecute();
						undo.push(cmd);
						selected = true;
						break;
					}
				}
			}

			if (selected == false) {

				if (model.numberSelectedObject() > 1) {
					for (int i = model.getAll().size() - 1; i >= 0; i--) {
						if (model.getAll().get(i).isSelected()) {
							cmd = new SelectShape(model, model.getAll().get(i));
							cmd.unexecute();
							undo.push(cmd);

						}

					}
					frame.getDlmList().add(0, "Deselected => All selected objects");

				} else if (model.numberSelectedObject() == 1) {
					for (int i = 0; i < model.getAll().size(); i++) {
						if (model.getAll().get(i).isSelected()) {
							cmd = new SelectShape(model, model.getAll().get(i));
							frame.getDlmList().add(0, "Deselected => " + model.getAll().get(i));
							cmd.unexecute();
							undo.push(cmd);
							break;
						}
					}
				}
			}
		}
		model.notifyAllObservers();
	}

	public void btnModifyShape(ActionEvent e) {
		ListIterator<Shape> it1 = model.getAll().listIterator(model.getAll().size());
		Command cmd = null;
		while (it1.hasPrevious()) {
			Shape shape = (Shape) it1.previous();
			if (shape.isSelected() == true) {
				if (shape instanceof Point) {
					Point point = (Point) shape;
					pointDialog = new PointDialog();
					pointDialog.getTxtXCoordinate().setText(String.valueOf(point.getX()));
					pointDialog.getTxtYCoordinate().setText(String.valueOf(point.getY()));
					pointDialog.getBtnColor_1().setBackground(point.getBorderColor());
					pointDialog.setVisible(true);
					if (pointDialog.isOk()) {

						this.point = pointDialog.getPointDlg();
						this.point.setSelected(true);
						cmd = new UpdatePoint(point, this.point);
						frame.getTglbtnSelect().setSelected(true);
						frame.getDlmList().add(0, "Modified =>  OldState: " + point + " NewState: " + this.point);
						cmd.execute();
						undo.push(cmd);
					}

				} else if (shape instanceof Line) {
					Line line = (Line) shape;
					lineDialog = new LineDialog();
					lineDialog.getTxtXCoordinateStart().setText(String.valueOf(line.getpStart().getX()));
					lineDialog.getTxtYCoordinateStart().setText(String.valueOf(line.getpStart().getY()));
					lineDialog.getTxtXCoordinateEnd().setText(String.valueOf(line.getpEnd().getX()));
					lineDialog.getTxtYCoordinateEnd().setText(String.valueOf(line.getpEnd().getY()));
					lineDialog.getBtnColorLine().setBackground(line.getBorderColor());
					lineDialog.setVisible(true);
					if (lineDialog.isOk()) {

						this.line = lineDialog.getLineDialog();
						this.line.setSelected(true);
						cmd = new UpdateLine(line, this.line);
						frame.getTglbtnSelect().setSelected(true);
						frame.getDlmList().add(0, "Modified =>  OldState: " + line + " NewState: " + this.line);
						cmd.execute();
						undo.push(cmd);
					}

				} else if (shape instanceof Circle) {
					Circle circle = (Circle) shape;
					circleDialog = new CircleDialog();
					circleDialog.getTxtXCenter().setText(String.valueOf(circle.getCenter().getX()));
					circleDialog.getTxtYCenter().setText(String.valueOf(circle.getCenter().getY()));
					circleDialog.getTxtRadius().setText(String.valueOf(circle.getR()));
					circleDialog.getBtnBorderColor().setBackground(circle.getBorderColor());
					circleDialog.getBtnInnerColor().setBackground(circle.getClrInnerColor());
					circleDialog.setVisible(true);
					if (circleDialog.isOk()) {

						this.circle = circleDialog.getCircleDialog();
						this.circle.setSelected(true);
						frame.getTglbtnSelect().setSelected(true);
						cmd = new UpdateCircle(circle, this.circle);
						frame.getDlmList().add(0, "Modified => OldState: " + circle + " NewState: " + this.circle);
						cmd.execute();
						undo.push(cmd);
					}

				} else if (shape instanceof Rectangle) {
					Rectangle rectangle = (Rectangle) shape;
					rectangleDialog = new RectangleDialog();

					rectangleDialog.getTxtXCoordinate().setText(String.valueOf(rectangle.getUpperLeft().getX()));
					rectangleDialog.getTxtYCoordinate().setText(String.valueOf(rectangle.getUpperLeft().getY()));
					rectangleDialog.getTxtWidth().setText(String.valueOf(rectangle.getSideLength()));
					rectangleDialog.getTxtHeight().setText(String.valueOf(rectangle.getWidth()));
					rectangleDialog.getBtnBorderColor().setBackground(rectangle.getBorderColor());
					rectangleDialog.getBtnInnerColor().setBackground(rectangle.getClrInnerColor());
					rectangleDialog.setVisible(true);
					if (rectangleDialog.isOk()) {

						this.rectangle = rectangleDialog.getRectangleDialog();
						this.rectangle.setSelected(true);
						frame.getTglbtnSelect().setSelected(true);
						cmd = new UpdateRectangle(rectangle, this.rectangle);
						frame.getDlmList().add(0,
								"Modified => OldState: " + rectangle + " NewState: " + this.rectangle);
						cmd.execute();
						undo.push(cmd);
					}

				} else if (shape instanceof Square) {
					Square square = (Square) shape;
					squareDialog = new SquareDialog();

					squareDialog.getTxtXCoordinate().setText(String.valueOf(square.getUpperLeft().getX()));
					squareDialog.getTxtYCoordinate().setText(String.valueOf(square.getUpperLeft().getY()));
					squareDialog.getTxtSideLength().setText(String.valueOf(square.getSideLength()));
					squareDialog.getBtnBorderColor().setBackground(square.getBorderColor());
					squareDialog.getBtnInnerColor().setBackground(square.getClrInnerColor());
					squareDialog.setVisible(true);
					if (squareDialog.isOk()) {

						this.square = squareDialog.getSquareDialog();
						this.square.setSelected(true);
						frame.getTglbtnSelect().setSelected(true);
						cmd = new UpdateSquare(square, this.square);
						frame.getDlmList().add(0, "Modified => OldState: " + square + " NewState: " + this.square);
						cmd.execute();
						undo.push(cmd);

					}

				} else if (shape instanceof HexagonAdapter) {
					HexagonAdapter hexagonAdapter = (HexagonAdapter) shape;

					hexagonDialog = new HexagonDialog();
					hexagonDialog.getTxtXCenter().setText(String.valueOf(hexagonAdapter.getHexagon().getX()));
					hexagonDialog.getTxtYCenter().setText(String.valueOf(hexagonAdapter.getHexagon().getY()));
					hexagonDialog.getTxtRadius().setText(String.valueOf(hexagonAdapter.getHexagon().getR()));
					hexagonDialog.getBtnBorderColor().setBackground(hexagonAdapter.getHexagon().getBorderColor());
					hexagonDialog.getBtnInnerColor().setBackground(hexagonAdapter.getHexagon().getAreaColor());
					hexagonDialog.setVisible(true);
					if (hexagonDialog.isOk()) {

						this.hexagon = hexagonDialog.getHexagonDialog();
						this.hexagon.setSelected(true);
						frame.getTglbtnSelect().setSelected(true);
						cmd = new UpdateHexagon(hexagonAdapter, this.hexagon);
						frame.getDlmList().add(0,
								"Modified => OldState: " + hexagonAdapter + " NewState: " + this.hexagon);
						cmd.execute();
						undo.push(cmd);

					}

				}
			}

		}
		
	}

	public void btnDeletePressed(ActionEvent e) {
		Command cmd;
		int result;
		if (model.numberSelectedObject() == 1) {
			result = JOptionPane.showConfirmDialog(null, "Do you want to delete selected object ?", "Choose",
					JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				for (int i = model.getAll().size() - 1; i >= 0; i--) {
					if (model.getAll().get(i).isSelected()) {
						Shape shape = (Shape) model.getAll().get(i);
						cmd = new RemoveShape(model, shape);
						frame.getDlmList().add(0, "Deleted => " + shape);
						cmd.execute();
						undo.push(cmd);
						
					}
				}
			}
		} else if (model.numberSelectedObject() > 1) {
			result = JOptionPane.showConfirmDialog(null, "Do you want to delete all selected objects ?", "Choose",
					JOptionPane.YES_NO_OPTION);

			if (result == JOptionPane.YES_OPTION) {
				frame.getDlmList().add(0, "Deleted all selected objects ");
				for (int i = model.getAll().size() - 1; i >= 0; i--) {
					if (model.getAll().get(i).isSelected()) {
						Shape shape = (Shape) model.getAll().get(i);
						cmd = new RemoveShape(model, shape);
						cmd.execute();
						undo.push(cmd);
						
					}
				}
			}
		}

	}

	public void bringToBack() {

		int length = model.getAll().size();
		if (length > 1) {
			for (int i = length - 1; i >= 0; i--) {
				if (model.getAll().get(i).isSelected()) {
					if (i != 0) {
						Shape current = model.getAll().get(i);
						Command cmd = new BringToBack(model, current, i);
						cmd.execute();
						undo.push(cmd);
						model.notifyAllObservers();
						frame.getDlmList().add(0, "Bringed to back => " + model.getSelectedShape());
						return;
					}
				}
			}
		}
	}

	public void bringToFront() {
		int length = model.getAll().size();
		if (length > 1) {
			for (int i = 0; i < length; i++) {
				if (model.getAll().get(i).isSelected()) {
					if (i < length) {
						Shape current = model.getAll().get(i);
						Command cmd = new BringToFront(model, current, i);
						cmd.execute();
						undo.push(cmd);
						frame.getDlmList().add(0, "Bringed to front => " + model.getSelectedShape());
						model.notifyAllObservers();
						return;
					}
				}
			}
		}
	}

	public void sendToFront() {
		Command cmd = new SendToFront(model);
		cmd.execute();
		model.notifyAllObservers();
		frame.getDlmList().add(0, "Moved one position to front");
		undo.push(cmd);
	}

	public void sendToBack() {
		Command cmd = new SendToBack(model);
		cmd.execute();
		undo.push(cmd);
		frame.getDlmList().add(0, "Moved one position to back");
		model.notifyAllObservers();
	}

	public boolean compare(Object o1) {
		if (o1 instanceof RemoveShape) {
			return true;
		} else {
			return false;
		}

	}

	public void undo() {

		try {
			Command cmd = undo.peek();
			frame.getDlmList().add(0, "Undo command ");
			if (!undo.isEmpty()) {
				frame.getBtnUndo().setEnabled(true);
			}

			if (compare(cmd)) {
				boolean commandRemove = true;
				while (commandRemove) {
					undo.peek().unexecute();
					redo.push(undo.pop());
					Command nextCommand = undo.peek();

					if (!compare(nextCommand)) {
						commandRemove = false;
					}
				}
			} else {
				undo.peek().unexecute();
				redo.push(undo.pop());
			}

			if (undo.isEmpty() && !redo.isEmpty()) {
				frame.getBtnUndo().setEnabled(false);
				frame.getBtnRedo().setEnabled(true);
			} else {
				frame.getBtnUndo().setEnabled(true);
				frame.getBtnRedo().setEnabled(true);
			}
		} catch (Exception error) {
			System.out.println(error.getStackTrace());
		}
		
	}

	public void redo() {
		try {
			frame.getDlmList().add(0, "Redo command ");
			Command cmd = redo.peek(); 

			if (compare(cmd)) {
				boolean commandRemove = true; 
				while (commandRemove) {
					redo.peek().execute();
					undo.push(redo.pop());
					if (redo.isEmpty()) {
						commandRemove = false;
					} else {
						Command nextCommand = redo.peek();
						if (!compare(nextCommand)) {
							commandRemove = false; 
						}
					}
				}
			} else {
				redo.peek().execute();
				undo.push(redo.pop());
			}

			if (redo.isEmpty() && !undo.isEmpty()) {
				frame.getBtnUndo().setEnabled(true);
				frame.getBtnRedo().setEnabled(false);
			} else {
				frame.getBtnUndo().setEnabled(true);
				frame.getBtnRedo().setEnabled(true);
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
	}

	public void save() {
		JFileChooser fileChooser = new JFileChooser();
		File selectedFile = null;
		FileNameExtensionFilter filter = new FileNameExtensionFilter("log", "log");
		FileNameExtensionFilter filterPnt = new FileNameExtensionFilter("pnt", "pnt");

		fileChooser.setFileFilter(filter);
		fileChooser.addChoosableFileFilter(filterPnt);

		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

		int result = fileChooser.showSaveDialog(frame.getView());

		if (result == JFileChooser.APPROVE_OPTION) {

			FileOperations str = new FileOperations();

			if (fileChooser.getSelectedFile().getAbsolutePath().endsWith(".log")) {

				selectedFile = new File(fileChooser.getSelectedFile().toString());
				str.setFileOperations(new LogOperations(frame));
				str.saveFile(selectedFile);
			} else if (fileChooser.getSelectedFile().getAbsolutePath().endsWith(".pnt")) {
				selectedFile = new File(fileChooser.getSelectedFile().toString());
				str.setFileOperations(new ImageStrategy(frame));
				str.saveFile(selectedFile);
			}
		}
	}

	public void open() {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("log", "log");
		FileNameExtensionFilter filterPnt = new FileNameExtensionFilter("pnt", "pnt");

		fileChooser.setFileFilter(filter);
		fileChooser.addChoosableFileFilter(filterPnt);
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

		int result = fileChooser.showOpenDialog(frame.getView());

		File selectedFile = fileChooser.getSelectedFile();
		file = selectedFile;

		BufferedReader bufferRead = null;
		if (result == JFileChooser.APPROVE_OPTION) {

			model.removeShapesList();
			frame.getDlmList().removeAllElements();

			undo.clear();
			redo.clear();

			if (!fileChooser.getSelectedFile().getAbsolutePath().isEmpty()) {
				if (selectedFile.getAbsolutePath().endsWith(".log")) {
					try {

						File fileInput = fileChooser.getSelectedFile();
						bufferRead = new BufferedReader(new FileReader(fileInput.getPath()));

						String input = ""; 

						while ((input = bufferRead.readLine()) != null) {
							loadStack.push(input);
							input = ""; 
						}
						frame.getBtnLoad().setEnabled(true);
					} catch (Exception error) {
						error.getStackTrace();
					} finally {
						try {
							bufferRead.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}

				else if (selectedFile.getAbsolutePath().endsWith(".pnt")) {
					try {

						FileInputStream file = new FileInputStream(selectedFile);
						ObjectInputStream in = new ObjectInputStream(file);

						model.setAll((ArrayList<Shape>) in.readObject());
						

						in.close();
						file.close();
					}

					catch (IOException ex) {
						System.out.println("IOException is caught");
					}

					catch (ClassNotFoundException ex) {
						System.out.println("ClassNotFoundException" + " is caught");
					}
					
				}
				frame.getView().repaint();
			}
		}
	}

	public void load() {
		Command cmd = null;
		if (!frame.getController().getLoadStack().isEmpty()) {
			String log = frame.getController().getLoadStack().pop();
			if (frame.getController().getLoadStack().isEmpty()) {
				frame.getBtnLoad().setEnabled(false);
			}

			String[] splitInput = log.split(" ");

			if (splitInput[0].equals("Added")) {
				if (splitInput[2].equals("Point:")) {

					Point p = pointFromString(splitInput);
					cmd = new AddShape(model, p);
					cmd.execute();
					undo.push(cmd);
					frame.getDlmList().add(0, "Added => " + p.toString());
				} else if (splitInput[2].equals("Line:")) {

					Line l = lineFromString(splitInput);
					cmd = new AddShape(model, l);
					cmd.execute();
					undo.push(cmd);
					frame.getDlmList().add(0, "Added => " + l.toString());

				} else if (splitInput[2].equals("Square:")) {

					Square s = squareFromString(splitInput);
					cmd = new AddShape(model, s);
					cmd.execute();
					undo.push(cmd);
					frame.getDlmList().add(0, "Added => " + s.toString());
				} else if (splitInput[2].equals("Rectangle:")) {

					Rectangle r = rectangleFromString(splitInput);

					cmd = new AddShape(model, r);
					cmd.execute();
					undo.push(cmd);
					frame.getDlmList().add(0, "Added => " + r.toString());
				} else if (splitInput[2].equals("Circle:")) {

					Circle c = circleFromString(splitInput);
					cmd = new AddShape(model, c);
					cmd.execute();
					undo.push(cmd);
					frame.getDlmList().add(0, "Added => " + c.toString());
				} else if (splitInput[2].equals("Hexagon:")) {

					HexagonAdapter h = hexagonFromString(splitInput);
					cmd = new AddShape(model, h);
					cmd.execute();
					undo.push(cmd);
					frame.getDlmList().add(0, "Added => " + h.toString());
				}
			} else if (splitInput[0].equals("Selected")) {

				if (splitInput[2].equals("Point:")) {

					Point p = pointFromString(splitInput);
					cmd = new SelectShape(model, p);
					cmd.execute();
					undo.push(cmd);
					frame.getDlmList().add(0, "Selected => " + p.toString());
				} else if (splitInput[2].equals("Line:")) {

					Line l = lineFromString(splitInput);
					cmd = new SelectShape(model, l);
					cmd.execute();
					undo.push(cmd);
					frame.getDlmList().add(0, "Selected => " + l.toString());

				} else if (splitInput[2].equals("Square:")) {

					Square s = squareFromString(splitInput);
					cmd = new SelectShape(model, s);
					cmd.execute();
					undo.push(cmd);
					frame.getDlmList().add(0, "Selected => " + s.toString());
				} else if (splitInput[2].equals("Rectangle:")) {

					Rectangle r = rectangleFromString(splitInput);
					cmd = new SelectShape(model, r);
					cmd.execute();
					undo.push(cmd);
					frame.getDlmList().add(0, "Selected => " + r.toString());

				} else if (splitInput[2].equals("Circle:")) {

					Circle c = circleFromString(splitInput);

					cmd = new SelectShape(model, c);
					cmd.execute();
					undo.push(cmd);
					frame.getDlmList().add(0, "Selected => " + c.toString());

				} else if (splitInput[2].equals("Hexagon:")) {

					HexagonAdapter h = hexagonFromString(splitInput);
					cmd = new SelectShape(model, h);
					cmd.execute();
					undo.push(cmd);
					frame.getDlmList().add(0, "Selected => " + h.toString());
				}
			} else if (log.equals("Deselected --> All selected objects")) {

				for (int i = 0; i < model.getAll().size(); i++) {

					if (model.getAll().get(i).isSelected())
						cmd = new SelectShape(model, model.getAll().get(i));
					cmd.unexecute();
					undo.push(cmd);
					frame.getDlmList().add(0, "Deselected => " + model.getAll().get(i).toString());
				}
			} else if (splitInput[0].equals("Deselected")) {

				if (splitInput[2].equals("Point:")) {

					Point p = pointFromString(splitInput);
					cmd = new SelectShape(model, p);
					cmd.unexecute();
					undo.push(cmd);
					frame.getDlmList().add(0, "Deselected => " + p.toString());

				} else if (splitInput[2].equals("Line:")) {

					Line l = lineFromString(splitInput);
					cmd = new SelectShape(model, l);
					cmd.unexecute();
					undo.push(cmd);
					frame.getDlmList().add(0, "Deselected => " + l.toString());

				} else if (splitInput[2].equals("Square:")) {

					Square s = squareFromString(splitInput);
					cmd = new SelectShape(model, s);
					cmd.unexecute();
					undo.push(cmd);
					frame.getDlmList().add(0, "Deselected => " + s.toString());

				} else if (splitInput[2].equals("Rectangle:")) {

					Rectangle r = rectangleFromString(splitInput);
					cmd = new SelectShape(model, r);
					cmd.unexecute();
					undo.push(cmd);
					frame.getDlmList().add(0, "Deselected => " + r.toString());

				} else if (splitInput[2].equals("Circle:")) {

					Circle c = circleFromString(splitInput);
					cmd = new SelectShape(model, c);
					cmd.unexecute();
					undo.push(cmd);
					frame.getDlmList().add(0, "Deselected => " + c.toString());
				} else if (splitInput[2].equals("Hexagon:")) {

					HexagonAdapter h = hexagonFromString(splitInput);
					cmd = new SelectShape(model, h);
					cmd.unexecute();
					undo.push(cmd);
					frame.getDlmList().add(0, "Deselected => " + h.toString());
				}
			} else if (splitInput[0].equals("Modified")) {

				String[] stringObject = log.split("OldState: |NewState: ");

				String oldString = "Modified => " + stringObject[1];
				String newString = "Modified => " + stringObject[2];

				String[] oldObject = oldString.split(" ");
				String[] newObject = newString.split(" ");

				if (oldObject[2].equals("Point:")) {
					Point oldPoint = pointFromString(oldObject);
					Point newPoint = pointFromString(newObject);
					Point finalP = null;

					Iterator<Shape> it = model.getAll().iterator();

					while (it.hasNext()) {
						Shape s = it.next();
						if (s.equals(oldPoint)) {
							finalP = (Point) s;
						} 
					}
					newPoint.setSelected(true);
					cmd = new UpdatePoint(finalP, newPoint);
					frame.getDlmList().add(0, "Modified =>  OldState: " + finalP + " NewState: " + newPoint);
					cmd.execute();
					undo.push(cmd);

				} else if (oldObject[2].equals("Line:")) {

					Line oldLine = lineFromString(oldObject);
					Line newLine = lineFromString(newObject);
					Line finalL = null;

					Iterator<Shape> it = model.getAll().iterator();

					while (it.hasNext()) {
						Shape s = it.next();
						if (s.equals(oldLine)) {
							finalL = (Line) s;
						}
					}
					newLine.setSelected(true);
					cmd = new UpdateLine(finalL, newLine);
					frame.getDlmList().add(0, "Modified =>  OldState: " + finalL + " NewState: " + newLine);
					cmd.execute();
					undo.push(cmd);

				} else if (oldObject[2].equals("Square:")) {
					Square oldSquare = squareFromString(oldObject);
					Square newSquare = squareFromString(newObject);
					Square finalS = null;
					Iterator<Shape> it = model.getAll().iterator();

					while (it.hasNext()) {
						Shape s = it.next();
						if (s.equals(oldSquare)) {
							finalS = (Square) s;
						}
					}
					newSquare.setSelected(true);
					cmd = new UpdateSquare(finalS, newSquare);
					frame.getDlmList().add(0, "Modified =>  OldState: " + finalS + " NewState: " + newSquare);
					cmd.execute();
					undo.push(cmd);

				} else if (splitInput[3].equals("Rectangle:")) {

					Rectangle oldRectangle = rectangleFromString(oldObject);
					Rectangle newRectangle = rectangleFromString(newObject);
					Rectangle finalR = null;

					Iterator<Shape> it = model.getAll().iterator();

					while (it.hasNext()) {
						Shape s = it.next();
						if (s.equals(oldRectangle)) {
							finalR = (Rectangle) s;
						}
					}
					newRectangle.setSelected(true);
					cmd = new UpdateRectangle(finalR, newRectangle);
					frame.getDlmList().add(0, "Modified =>  OldState: " + finalR + " NewState: " + newRectangle);
					cmd.execute();
					undo.push(cmd);

				} else if (oldObject[2].equals("Circle:")) {

					Circle oldCircle = circleFromString(oldObject);
					Circle newCircle = circleFromString(newObject);
					Circle finalC = null;

					Iterator<Shape> it = model.getAll().iterator();

					while (it.hasNext()) {
						Shape s = it.next();
						if (s.equals(oldCircle)) {
							finalC = (Circle) s;
						}
					}
					newCircle.setSelected(true);
					frame.getDlmList().add(0, "Modified =>  OldState: " + finalC + " NewState: " + newCircle);
					cmd = new UpdateCircle(finalC, newCircle);
					cmd.execute();
					undo.push(cmd);

				} else if (splitInput[3].equals("Hexagon:")) {
					HexagonAdapter oldHexagon = hexagonFromString(oldObject);
					HexagonAdapter newHexagon = hexagonFromString(newObject);
					HexagonAdapter finalH = null;

					Iterator<Shape> it = model.getAll().iterator();

					while (it.hasNext()) {
						Shape s = it.next();
						if (s.equals(oldHexagon)) {
							finalH = (HexagonAdapter) s;
						}
					}
					newHexagon.setSelected(true);
					cmd = new UpdateHexagon(finalH, newHexagon);
					frame.getDlmList().add(0, "Modified =>  OldState: " + finalH + " NewState: " + newHexagon);
					cmd.execute();
					undo.push(cmd);

				}
			} else if (splitInput[0].equals("Deleted")) {

				if (splitInput[2].equals("Point:")) {
					Point p = pointFromString(splitInput);
					cmd = new RemoveShape(model, p);
					cmd.execute();
					frame.getDlmList().add(0, "Deleted => " + p.toString());
					undo.push(cmd);

				} else if (splitInput[2].equals("Line:")) {

					Line l = lineFromString(splitInput);
					cmd = new RemoveShape(model, l);
					cmd.execute();
					frame.getDlmList().add(0, "Deleted => " + l.toString());
					undo.push(cmd);

				} else if (splitInput[2].equals("Square:")) {

					Square s = squareFromString(splitInput);
					cmd = new RemoveShape(model, s);
					cmd.execute();
					frame.getDlmList().add(0, "Deleted => " + s.toString());
					undo.push(cmd);

				} else if (splitInput[2].equals("Rectangle:")) {

					Rectangle r = rectangleFromString(splitInput);
					cmd = new RemoveShape(model, r);
					cmd.execute();
					frame.getDlmList().add(0, "Deleted => " + r.toString());
					undo.push(cmd);

				} else if (splitInput[2].equals("Circle:")) {

					Circle c = circleFromString(splitInput);
					cmd = new RemoveShape(model, c);
					cmd.execute();
					frame.getDlmList().add(0, "Deleted => " + c.toString());
					undo.push(cmd);

				} else if (splitInput[2].equals("Hexagon:")) {

					HexagonAdapter h = hexagonFromString(splitInput);
					cmd = new RemoveShape(model, h);
					cmd.execute();
					undo.push(cmd);
					frame.getDlmList().add(0, "Deleted => " + h.toString());
				}
			} else if (splitInput[0].equals("Moved") && splitInput[4].equals("front")) {

				cmd = new SendToFront(model);
				cmd.execute();
				undo.push(cmd);
				frame.getDlmList().add(0, "Moved one position to front");

			} else if (splitInput[0].equals("Moved") && splitInput[4].equals("back")) {

				cmd = new SendToBack(model);
				cmd.execute();
				undo.push(cmd);
				frame.getDlmList().add(0, "Moved one position to back");
			} else if (splitInput[0].equals("Bringed") && splitInput[2].equals("back")) {

				String[] moveInput = new String[splitInput.length - 2];
				int j = 2;
				for (int i = 0; i < moveInput.length; i++) {
					moveInput[i] = splitInput[j];
					j++;
				}
				if (moveInput[2].equals("Point:")) {

					Point p = pointFromString(moveInput);
					p.setSelected(true);
					cmd = new BringToBack(model, p, model.getIndex(p));
					cmd.execute();
					undo.push(cmd);
					frame.getDlmList().add(0, "Bringed to back => " + p.toString());

				} else if (moveInput[2].equals("Line:")) {

					Line l = lineFromString(moveInput);
					l.setSelected(true);
					cmd = new BringToBack(model, l, model.getIndex(l));
					cmd.execute();
					undo.push(cmd);
					frame.getDlmList().add(0, "Bringed to back => " + l.toString());

				} else if (moveInput[2].equals("Square:")) {

					Square s = squareFromString(moveInput);
					s.setSelected(true);
					cmd = new BringToBack(model, s, model.getIndex(s));
					cmd.execute();
					undo.push(cmd);
					frame.getDlmList().add(0, "Bringed to back => " + s.toString());

				} else if (moveInput[2].equals("Rectangle:")) {

					Rectangle r = rectangleFromString(moveInput);
					r.setSelected(true);
					cmd = new BringToBack(model, r, model.getIndex(r));
					cmd.execute();
					undo.push(cmd);
					frame.getDlmList().add(0, "Bringed to back => " + r.toString());

				} else if (moveInput[2].equals("Circle:")) {

					Circle c = circleFromString(moveInput);
					c.setSelected(true);
					cmd = new BringToBack(model, c, model.getIndex(c));
					cmd.execute();
					undo.push(cmd);
					frame.getDlmList().add(0, "Bringed to back => " + c.toString());

				} else if (moveInput[2].equals("Hexagon:")) {

					HexagonAdapter h = hexagonFromString(moveInput);
					h.setSelected(true);
					cmd = new BringToBack(model, h, model.getIndex(h));
					cmd.execute();
					undo.push(cmd);
					frame.getDlmList().add(0, "Bringed to back => " + h.toString());
				}
			} else if (splitInput[0].equals("Bringed") && splitInput[2].equals("front")) {
				String[] moveInput = new String[splitInput.length - 2];
				int j = 2;
				for (int i = 0; i < moveInput.length; i++) {
					moveInput[i] = splitInput[j];
					j++;
				}
				for (String s : moveInput) {
					System.out.println(s);
				}
				if (moveInput[2].equals("Point:")) {
					Point p = pointFromString(moveInput);
					p.setSelected(true);
					cmd = new BringToFront(model, p, model.getIndex(p));
					cmd.execute();
					undo.push(cmd);
					frame.getDlmList().add(0, "Bringed to front => " + p.toString());

				} else if (moveInput[2].equals("Line:")) {
					Line l = lineFromString(moveInput);
					l.setSelected(true);
					cmd = new BringToFront(model, l, model.getIndex(l));
					cmd.execute();
					undo.push(cmd);
					frame.getDlmList().add(0, "Bringed to front => " + l.toString());

				} else if (moveInput[2].equals("Square:")) {
					Square s = squareFromString(moveInput);
					s.setSelected(true);
					cmd = new BringToFront(model, s, model.getIndex(s));
					cmd.execute();
					undo.push(cmd);
					frame.getDlmList().add(0, "Bringed to front => " + s.toString());

				} else if (moveInput[2].equals("Rectangle:")) {
					Rectangle r = rectangleFromString(moveInput);
					r.setSelected(true);
					cmd = new BringToFront(model, r, model.getIndex(r));
					cmd.execute();
					undo.push(cmd);
					frame.getDlmList().add(0, "Bringed to front => " + r.toString());

				} else if (moveInput[2].equals("Circle:")) {
					Circle c = circleFromString(moveInput);
					c.setSelected(true);
					cmd = new BringToFront(model, c, model.getIndex(c));
					cmd.execute();
					undo.push(cmd);
					frame.getDlmList().add(0, "Bringed to front => " + c.toString());

				} else if (moveInput[2].equals("Hexagon:")) {
					HexagonAdapter h = hexagonFromString(moveInput);
					h.setSelected(true);
					cmd = new BringToFront(model, h, model.getIndex(h));
					cmd.execute();
					undo.push(cmd);
					frame.getDlmList().add(0, "Bringed to front => " + h.toString());
				}
			} else if (log.equals("Undo command ")) {
				frame.getController().getUndo().peek().unexecute();
				frame.getController().getRedo().push(frame.getController().getUndo().pop());
				frame.getDlmList().add(0, "Undo command ");
			} else if (log.equals("Redo command ")) {
				frame.getController().getRedo().peek().execute();
				frame.getController().getUndo().push(frame.getController().getRedo().pop());
				frame.getDlmList().add(0, "Redo command ");
			} else {

				frame.getBtnLoad().setEnabled(false);
			}

		}
		model.notifyAllObservers();
	}

	public Point pointFromString(String[] input) {
		if (input[0].equals("Modified => ")) {
			String[] splitCoordinate = input[4].split("[)|\\,|\\(]");
			return new Point(Integer.valueOf(splitCoordinate[1]), Integer.valueOf(splitCoordinate[2]),
					Color.decode(input[6]));
		} else {
			String[] splitCoordinate = input[3].split("[)|\\,|\\(]");
			return new Point(Integer.valueOf(splitCoordinate[1]), Integer.valueOf(splitCoordinate[2]),
					Color.decode(input[5]));
		}
	}

	public Line lineFromString(String[] input) {
		if (input[0].equals("Modified")) {
			String[] splitCoordinateStart = input[3].split("[)|\\,|\\(]");
			String[] splitCoordinateEnd = input[4].split("[)|\\,|\\(]");

			return new Line(
					new Point(Integer.parseInt(splitCoordinateStart[1]), Integer.parseInt(splitCoordinateStart[2])),
					new Point(Integer.valueOf(splitCoordinateEnd[1]), Integer.valueOf(splitCoordinateEnd[2])),
					Color.decode(input[6]));

		} else {
			String[] splitCoordinateStart = input[3].split("[)|\\,|\\(]");
			String[] splitCoordinateEnd = input[4].split("[)|\\,|\\(]");

			return new Line(
					new Point(Integer.parseInt(splitCoordinateStart[1]), Integer.parseInt(splitCoordinateStart[2])),
					new Point(Integer.valueOf(splitCoordinateEnd[1]), Integer.valueOf(splitCoordinateEnd[2])),
					Color.decode(input[6]));
		}
	}

	public Square squareFromString(String[] input) {
		if (input[0].equals("Modified")) {
			String[] splitUpLeft = input[3].split("[)|\\,|\\(]");
			String[] splitPageLength = input[5].split(";");
			String[] splitBorderColor = input[8].split(";");

			return new Square(new Point(Integer.parseInt(splitUpLeft[1]), Integer.parseInt(splitUpLeft[2])),
					Integer.parseInt(splitPageLength[0]), Color.decode(splitBorderColor[0]), Color.decode(input[11]));
		} else {
			String[] splitUpLeft = input[3].split("[)|\\,|\\(]");
			String[] splitPageLength = input[5].split(";");
			String[] splitBorderColor = input[8].split(";");

			return new Square(new Point(Integer.parseInt(splitUpLeft[1]), Integer.parseInt(splitUpLeft[2])),
					Integer.parseInt(splitPageLength[0]), Color.decode(splitBorderColor[0]), Color.decode(input[11]));
		}
	}

	public Rectangle rectangleFromString(String[] input) {
		if (input[0].equals("Modified")) {
			String[] splitUpLeft = input[3].split("[)|\\,|\\(]");
			String[] splitHeight = input[5].split(";");
			String[] splitWidth = input[7].split(";");
			String[] splitBorderColor = input[10].split(";");

			return new Rectangle(new Point(Integer.parseInt(splitUpLeft[1]), Integer.parseInt(splitUpLeft[2])),
					Integer.parseInt(splitHeight[0]), Integer.parseInt(splitWidth[0]),
					Color.decode(splitBorderColor[0]), Color.decode(input[13]));
		} else {
			String[] splitUpLeft = input[3].split("[)|\\,|\\(]");
			String[] splitHeight = input[5].split(";");
			String[] splitWidth = input[7].split(";");
			String[] splitBorderColor = input[10].split(";");

			return new Rectangle(new Point(Integer.parseInt(splitUpLeft[1]), Integer.parseInt(splitUpLeft[2])),
					Integer.parseInt(splitHeight[0]), Integer.parseInt(splitWidth[0]),
					Color.decode(splitBorderColor[0]), Color.decode(input[13]));
		}
	}

	public Circle circleFromString(String[] input) {
		if (input[0].equals("Modified")) {
			String[] splitCenter = input[3].split("[)|\\,|\\(]");
			String[] splitRadius = input[5].split(";");
			String[] splitBorderColor = input[8].split(";");

			return new Circle(new Point(Integer.parseInt(splitCenter[1]), Integer.parseInt(splitCenter[2])),
					Integer.parseInt(splitRadius[0]), Color.decode(splitBorderColor[0]), Color.decode(input[11]));
		} else {
			String[] splitCenter = input[3].split("[)|\\,|\\(]");
			String[] splitRadius = input[5].split(";");
			String[] splitBorderColor = input[8].split(";");

			return new Circle(new Point(Integer.parseInt(splitCenter[1]), Integer.parseInt(splitCenter[2])),
					Integer.parseInt(splitRadius[0]), Color.decode(splitBorderColor[0]), Color.decode(input[11]));

		}
	}

	public HexagonAdapter hexagonFromString(String[] input) {
		if (input[0].equals("Modified")) {
			String[] splitCenter = input[3].split("[)|\\,|\\(]");
			String[] splitRadius = input[5].split(";");
			String[] splitBorderColor = input[8].split(";");

			return new HexagonAdapter(Integer.parseInt(splitCenter[1]), Integer.parseInt(splitCenter[2]),
					Integer.parseInt(splitRadius[0]), Color.decode(splitBorderColor[0]), Color.decode(input[11]));
		} else {
			String[] splitCenter = input[3].split("[)|\\,|\\(]");
			String[] splitRadius = input[5].split(";");
			String[] splitBorderColor = input[8].split(";");

			return new HexagonAdapter(Integer.parseInt(splitCenter[1]), Integer.parseInt(splitCenter[2]),
					Integer.parseInt(splitRadius[0]), Color.decode(splitBorderColor[0]), Color.decode(input[11]));
		}
	}

	public Stack<String> getLoadStack() {
		return loadStack;
	}

	public void setLoadStack(Stack<String> loadStack) {
		this.loadStack = loadStack;
	}

	public void tglbtnSelectPressed(ActionEvent e) {
		selShape = 0;
	}

	public void updateLog(String log) {
		frame.getDlmList().add(0, log);
	}

	public void tglbtnPointPressed(ActionEvent e) {
		selShape = 1;
	}

	public void tglbtnLinePressed(ActionEvent e) {
		selShape = 2;

	}

	public void tglbtnSquarePressed(ActionEvent e) {
		selShape = 4;

	}

	public void tglbtnRectanglePressed(ActionEvent e) {
		selShape = 5;
	}

	public void tglbtnCirclePressed(ActionEvent e) {
		selShape = 3;
	}

	public void tglbtnHexagonPressed(ActionEvent e) {
		selShape = 6;
	}

	public Stack<Command> getUndo() {
		return undo;
	}

	public void setUndo(Stack<Command> undo) {
		this.undo = undo;
	}

	public Stack<Command> getRedo() {
		return redo;
	}

	public void setRedo(Stack<Command> redo) {
		this.redo = redo;
	}
}
