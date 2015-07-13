package com.himamis.retex.editor.desktop;

import com.himamis.retex.renderer.desktop.FactoryProviderDesktop;
import com.himamis.retex.renderer.share.platform.FactoryProvider;

import javax.swing.JFrame;

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
