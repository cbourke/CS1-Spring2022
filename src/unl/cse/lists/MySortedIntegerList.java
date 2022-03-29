package unl.cse.lists;

import java.util.Arrays;

import javax.lang.model.element.Element;

public class MySortedIntegerList {
	
	MyIntegerArrayList list;
	
	public MySortedIntegerList() {
		this.list = new MyIntegerArrayList();
	}
	
	public boolean containsElement(Integer x) {
		return this.list.containsElement(x);
	}

	public void addElement(Integer x) {
		
		//find the index at which the element x belongs...
		//TODO: refactor this...
		int index = 0;		
		for(int i=0; i<this.list.getSize(); i++) {
			if(this.list.getElementAtIndex(i) < x) {
				index++;
			}
		}
		this.list.addElementAtIndex(x, index);

	}
	
	public Integer getElementAtIndex(int index) {
		return this.list.getElementAtIndex(index);
	}
	
	public Integer removeElementAtIndex(int index) {
		return this.list.removeElementAtIndex(index);
	}
	
	public String toString() {
		return this.list.toString();
	}
	
}
