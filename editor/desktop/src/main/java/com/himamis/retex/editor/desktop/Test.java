package com.himamis.retex.editor.desktop;

import javax.swing.JFrame;

import org.scilab.forge.jlatexmath.FactoryProviderDesktop;
import org.scilab.forge.jlatexmath.platform.FactoryProvider;

public class Test {

	static {
		FactoryProvider.INSTANCE = new FactoryProviderDesktop();
	}

	public static void main(String[] args) {
		MathFieldD mathField = new MathFieldD();
		
		JFrame frame = new JFrame();

		frame.getContentPane().add(mathField);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
