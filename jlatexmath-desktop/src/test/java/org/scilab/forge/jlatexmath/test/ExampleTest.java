package org.scilab.forge.jlatexmath.test;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.scilab.forge.jlatexmath.ColorUtil;
import org.scilab.forge.jlatexmath.FactoryProviderDesktop;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;
import org.scilab.forge.jlatexmath.graphics.ImageD;
import org.scilab.forge.jlatexmath.platform.FactoryProvider;
import org.scilab.forge.jlatexmath.platform.graphics.Graphics2DInterface;
import org.scilab.forge.jlatexmath.platform.graphics.Image;
import org.scilab.forge.jlatexmath.platform.graphics.Insets;

public class ExampleTest {

	@BeforeClass
	public static void setFactory() {
		FactoryProvider.INSTANCE = new FactoryProviderDesktop();
	}

	@Test
	public void Example1() {
		String latex = "\\begin{array}{lr}\\mbox{\\textcolor{Blue}{Russian}}&\\mbox{\\textcolor{Melon}{Greek}}\\\\";
		latex += "\\mbox{" + "привет мир".toUpperCase() + "}&\\mbox{" + "γειά κόσμο".toUpperCase() + "}\\\\";
		latex += "\\mbox{привет мир}&\\mbox{γειά κόσμο}\\\\";
		latex += "\\mathbf{\\mbox{привет мир}}&\\mathbf{\\mbox{γειά κόσμο}}\\\\";
		latex += "\\mathit{\\mbox{привет мир}}&\\mathit{\\mbox{γειά κόσμο}}\\\\";
		latex += "\\mathsf{\\mbox{привет мир}}&\\mathsf{\\mbox{γειά κόσμο}}\\\\";
		latex += "\\mathtt{\\mbox{привет мир}}&\\mathtt{\\mbox{γειά κόσμο}}\\\\";
		latex += "\\mathbf{\\mathit{\\mbox{привет мир}}}&\\mathbf{\\mathit{\\mbox{γειά κόσμο}}}\\\\";
		latex += "\\mathbf{\\mathsf{\\mbox{привет мир}}}&\\mathbf{\\mathsf{\\mbox{γειά κόσμο}}}\\\\";
		latex += "\\mathsf{\\mathit{\\mbox{привет мир}}}&\\mathsf{\\mathit{\\mbox{γειά κόσμο}}}\\\\";
		latex += "&\\\\";
		latex += "\\mbox{\\textcolor{Salmon}{Bulgarian}}&\\mbox{\\textcolor{Tan}{Serbian}}\\\\";
		latex += "\\mbox{здравей свят}&\\mbox{Хелло уорлд}\\\\";
		latex += "&\\\\";
		latex += "\\mbox{\\textcolor{Turquoise}{Bielorussian}}&\\mbox{\\textcolor{LimeGreen}{Ukrainian}}\\\\";
		latex += "\\mbox{прывітаньне Свет}&\\mbox{привіт світ}\\\\";
		latex += "\\end{array}";
		doTest(latex, "Example1");
	}
	
	private void doTest(String latex, String exampleName) {
		TeXIcon icon = createTeXIcon(latex);
		Image image = createImage(icon);
		byte[] imageBytes = getImageBytes(image);
		byte[] expectedBytes = loadResourceFile(exampleName + ".png");
		Assert.assertArrayEquals(expectedBytes, imageBytes);
	}
	
	private TeXIcon createTeXIcon(String latex) {
		TeXFormula formula = null;
		try {
			formula = new TeXFormula(latex);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		TeXIcon icon = formula.new TeXIconBuilder().setStyle(TeXConstants.STYLE_DISPLAY).setSize(20).build();

		icon.setInsets(new Insets(5, 5, 5, 5));
		return icon;
	}

	private Image createImage(TeXIcon icon) {
		Image image = new ImageD(icon.getIconWidth(), icon.getIconHeight(), Image.TYPE_INT_ARGB);
		Graphics2DInterface g2 = image.createGraphics2D();
		g2.setColor(ColorUtil.WHITE);
		g2.fillRect(0, 0, icon.getIconWidth(), icon.getIconHeight());
		icon.paintIcon(null, g2, 0, 0);
		return image;
	}

	private byte[] getImageBytes(Image image) {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			ImageIO.write((BufferedImage) image, "png", os);
		} catch (IOException ex) {
		}
		return os.toByteArray();
	}

	private byte[] loadResourceFile(String name) {
		String path = ClassLoader.getSystemResource(name).getFile().substring(1);
		try {
			return Files.readAllBytes(Paths.get(path));
		} catch (IOException e) {
			return new byte[1];
		}
	}

}
