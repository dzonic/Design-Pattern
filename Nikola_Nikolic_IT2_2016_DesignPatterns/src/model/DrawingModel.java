package model;

import java.util.ArrayList;

import observer.Observable;
import observer.Observer;
import shapes.Shape;

public class DrawingModel implements Observable{

	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private ArrayList<Observer> observers = new ArrayList<>();

	public ArrayList<Shape> getAll() {
		return shapes;
	}
	
	public void setAll(ArrayList<Shape> shapes){
		this.shapes = shapes;
	}

	public void add(Shape s) {
		shapes.add(s);
	}

	public void remove(Shape s) {
		shapes.remove(s);
	}

	public Shape get(int i) {
		return shapes.get(i);
	}
	
	public int getIndex(Shape shape) {
		for(int i=0;i<shapes.size();i++) {
			if(shapes.get(i).equals(shape)) {
				return i;
			}
		}

		return -1;
	}
	public void select(Shape shape){
		for(int i=0;i<shapes.size();i++) {
			if(shapes.get(i).equals(shape)) {
				shapes.get(i).setSelected(true);
				
			}
		}
	}

	public void removeShapesList() {
		while(shapes.size()!=0) {
			shapes.remove(0);
		}
	}
	
	public void deselect(Shape shape) {
		for(int i=0;i<shapes.size();i++) {
			if(shapes.get(i).equals(shape)) {
				shapes.get(i).setSelected(false);
			}
		}
}
	public int numberSelectedObject() {
		int counter=0;
		for(int i=0;i<shapes.size();i++) {
			if(shapes.get(i).isSelected())
				counter++;
		}
		return counter;
	}
	
	public Shape getSelectedShape() {
		for(int i=0;i<shapes.size();i++) {
			if(shapes.get(i).isSelected())
				return shapes.get(i);
		}
		return null;
	}
	
	public int selectedLastShape() { 
		for(int i=shapes.size()-1;i>=0;i--) {
			if(shapes.get(i).isSelected() && i==0) {
				return 1;
			}
		}
		for(int i=0;i<shapes.size();i++) {
			if(shapes.get(i).isSelected() && i==shapes.size()-1) {
				return 2;
			}
		}
		return 0; 
	}
	public void change(int i, Shape shape) {
		shapes.remove(i);
		shapes.add(i, shape);
	}
	
	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
	}
	
	@Override
	public void deleteObserver(Observer observer) {
		observers.remove(observer);
	}
	
	
	public ArrayList<Observer> getObservers() {
		return observers;
	}
	
	@Override
	public void notifyAllObservers() {
		for(Observer observer : observers) {
			observer.ObserveButtons(numberSelectedObject(),getAll().size(),selectedLastShape());
		}
	} 

	public void setObservers(ArrayList<Observer> observers) {
		this.observers = observers;
	}
}
