package org.jlatexmath.android.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;

import org.scilab.forge.jlatexmath.MacroInfo;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.exception.ResourceParseException;
import org.scilab.forge.jlatexmath.exception.XMLResourceParseException;
import org.scilab.forge.jlatexmath.platform.parser.PredefinedTeXFormulaParser;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.content.res.AssetManager;

public class PredefinedTeXFormulaParserA implements PredefinedTeXFormulaParser {
	
	private AssetManager mAssetManager;
	
	private static final String RESOURCE_DIR = "";
    
    private Element root;
    private String type;
        
    public PredefinedTeXFormulaParserA(AssetManager assetManager, InputStream file, String type) throws ResourceParseException {
        mAssetManager = assetManager;
    	try {
	    this.type = type;
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    factory.setIgnoringElementContentWhitespace(true);
	    factory.setIgnoringComments(true);
	    root = factory.newDocumentBuilder().parse(file).getDocumentElement();
	} catch (Exception e) { // JDOMException or IOException
            throw new XMLResourceParseException("", e);
        }
    }
    
    public PredefinedTeXFormulaParserA(AssetManager assetManager, String PredefFile, String type) throws ResourceParseException, IOException {
        this(assetManager, assetManager.open(PredefFile), type);
    }

    public void parse(Map predefinedTeXFormulas) {
        // get required string attribute
        String enabledAll = getAttrValueAndCheckIfNotNull("enabled", root);
        if ("true".equals(enabledAll)) { // parse formula's
            // iterate all "Font"-elements
	    NodeList list = root.getElementsByTagName(this.type);
            for (int i = 0; i < list.getLength(); i++) {
                Element formula = (Element)list.item(i);
                // get required string attribute
                String enabled = getAttrValueAndCheckIfNotNull("enabled", formula);
                if ("true".equals (enabled)) { // parse this formula
                    // get required string attribute
                    String name = getAttrValueAndCheckIfNotNull("name", formula);
                    
                    // parse and build the formula and add it to the table
                    if ("TeXFormula".equals(this.type))
			predefinedTeXFormulas.put(name, (TeXFormula) new TeXFormulaParserA(name, formula, this.type).parse());
		    else 
			predefinedTeXFormulas.put(name, (MacroInfo) new TeXFormulaParserA(name, formula, this.type).parse());
                }
            }
        }
    }

    private static String getAttrValueAndCheckIfNotNull(String attrName,
            Element element) throws ResourceParseException {
        String attrValue = element.getAttribute(attrName);
        if (attrValue.equals(""))
            throw new XMLResourceParseException(RESOURCE_NAME, element.getTagName(),
                    attrName, null);
        return attrValue;
    }

}
