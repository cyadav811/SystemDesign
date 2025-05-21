package com.assignment.penDesign;

public class BallPen extends Pen {
	private Refilable refilable;

	public BallPen(Ink ink, Nib nib,Refilable refilable) {
		super(ink, nib);
		this.refilable = refilable;
	}

	@Override
	public void write() {
		System.out.println("We can write on plan paper");
		
	}

	
	public void refil() {
		refilable.Refil();
	}
}
