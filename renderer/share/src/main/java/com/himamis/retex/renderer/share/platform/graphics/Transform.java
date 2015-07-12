package com.himamis.retex.renderer.share.platform.graphics;

public interface Transform {

	public double getTranslateX();

	public double getTranslateY();

	public double getScaleX();

	public double getScaleY();

	public double getShearX();

	public double getShearY();

	public Transform createClone();

	public void scale(double sx, double sy);

	public void translate(double tx, double ty);

	public void shear(double sx, double sy);

}
