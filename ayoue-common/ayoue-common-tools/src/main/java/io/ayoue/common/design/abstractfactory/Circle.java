package io.ayoue.common.design.abstractfactory;

/**
 * @category 圆
 * @author AYOU
 */
public class Circle implements Shape {
	@Override
	public void draw() {
		System.out.println("Inside Circle::draw() method.");
	}
}
