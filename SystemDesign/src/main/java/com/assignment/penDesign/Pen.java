package com.assignment.penDesign;

public abstract class Pen implements Writable{

	private Ink ink;
	private Nib nib;
	
	public Pen(Ink ink,Nib nib) {
		this.ink = ink;
		this.nib = nib;
	}
	
	@Override
	public abstract void write() ;

}
