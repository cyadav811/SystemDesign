package com.assignment.penDesign;

public class OneTimeUsePen extends Pen {

	public OneTimeUsePen(Ink ink, Nib nib) {
		super(ink, nib);
	}

	@Override
	public void write() {
		System.out.println("We can write on simple plan paper");
		
	}

}
