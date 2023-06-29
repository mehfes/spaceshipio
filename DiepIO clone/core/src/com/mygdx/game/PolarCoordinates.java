package com.mygdx.game;

//this file is copy-pasted from one of my previous projects - superDpermn

public class PolarCoordinates{
	private double xEquivalent;
	private double yEquivalent;
	private double myAngle;
	private double myLength;
	public PolarCoordinates() {
		this.xEquivalent=0;
		this.yEquivalent=0;
		this.myAngle=0;
		this.myLength=0;
	}
	public PolarCoordinates vectorAdd(PolarCoordinates p) {
		PolarCoordinates t = new PolarCoordinates();
		t.setCartesian(this.getCartesian()[0]+p.getCartesian()[0],this.getCartesian()[0]+p.getCartesian()[0]);
		return t;
	}
	public PolarCoordinates(double angle,double distance) {
		this.myAngle = angle;
		this.myLength = distance;
		this.xEquivalent = Math.cos(angle)*distance;
		this.yEquivalent = Math.sin(angle)*distance;
	}
	public double[] getCartesian() {
		return new double[] {xEquivalent,yEquivalent};
	}
	public double[] getPolar() {
		return new double[] {myAngle,myLength};
	}
	public void setCartesian(double xCoord,double yCoord) {
		this.xEquivalent = xCoord;
		this.yEquivalent = yCoord;
		this.myLength = Math.sqrt(Math.pow(xCoord,2)+Math.pow(yCoord,2));
		if(xCoord==0) {this.myAngle = yCoord>0?Math.PI/2:Math.PI*1.5;}
		else if(yCoord==0) {this.myAngle = xCoord>0?0:Math.PI/2;}
		else if(xCoord<0){this.myAngle = Math.atan(yCoord/xCoord)+Math.PI;}
		else if(yCoord<0){this.myAngle = Math.atan(yCoord/xCoord)+2*Math.PI;}
		else {this.myAngle = Math.atan(yCoord/xCoord);}		
	}
	public void setPolar(double angle,double distance) {
		this.myAngle = angle;
		this.myLength = distance;
		this.xEquivalent = Math.cos(angle)*distance;
		this.yEquivalent = Math.sin(angle)*distance;
	}
	public void rotateCoord(double angle) {
		double finalAngle = myAngle+angle;
		while(finalAngle>=2*Math.PI) {finalAngle-=2*Math.PI;}
		while(finalAngle<0) {finalAngle+=2*Math.PI;}
		this.setPolar(finalAngle,myLength);
	}
	
	public double norm() {return myLength;}
	
	public double dotProduct(PolarCoordinates b) {
		return (this.getPolar()[1]*b.getPolar()[1])*Math.cos(this.getPolar()[0]-b.getPolar()[0]);
	}
	public PolarCoordinates vectorSubtract(PolarCoordinates otherVector) {
		PolarCoordinates t1 = new PolarCoordinates();
		double resX = this.xEquivalent-otherVector.getCartesian()[0];
		double resY = this.yEquivalent-otherVector.getCartesian()[1];
		t1.setCartesian(resX,resY);
		return t1;
	}
}