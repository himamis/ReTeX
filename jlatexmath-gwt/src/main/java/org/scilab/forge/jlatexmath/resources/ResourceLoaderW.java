package org.scilab.forge.jlatexmath.resources;

import org.scilab.forge.jlatexmath.cyrillic.CyrillicRegistration;
import org.scilab.forge.jlatexmath.exception.ResourceParseException;
import org.scilab.forge.jlatexmath.greek.GreekRegistration;
import org.scilab.forge.jlatexmath.platform.resources.ResourceLoader;

import com.google.gwt.core.shared.GWT;

public class ResourceLoaderW implements ResourceLoader {

	private static final XmlResources XML_RESOURCES = GWT
			.create(XmlResources.class);

	@Override
	public Object loadResource(Object base, String path)
			throws ResourceParseException {
		// base object is either a class or null
		String fullPath = getPath((Class<?>) base) + path;
		return getResource(fullPath);
	}

	private String getPath(Class<?> clazz) {
		if (CyrillicRegistration.class.equals(clazz)) {
			return "cyrillic/";
		}
		if (GreekRegistration.class.equals(clazz)) {
			return "greek/";
		}
		return "";
	}

	/*
	 * This method was generated based on the available source xml at that time.
	 * Please regenerate this if you add/delete/rename xmls.
	 */
	private static final String getResource(String source) {
		if (source.equals("cyrillic/fonts/jlm_cyrillic.map.xml")) {
			return XML_RESOURCES.fontsjlm_cyrillic_map().getText();
		}
		if (source.equals("cyrillic/fonts/jlm_wnbx10.xml")) {
			return XML_RESOURCES.fontsjlm_wnbx10().getText();
		}
		if (source.equals("cyrillic/fonts/jlm_wnbxti10.xml")) {
			return XML_RESOURCES.fontsjlm_wnbxti10().getText();
		}
		if (source.equals("cyrillic/fonts/jlm_wnr10.xml")) {
			return XML_RESOURCES.fontsjlm_wnr10().getText();
		}
		if (source.equals("cyrillic/fonts/jlm_wnss10.xml")) {
			return XML_RESOURCES.fontsjlm_wnss10().getText();
		}
		if (source.equals("cyrillic/fonts/jlm_wnssbx10.xml")) {
			return XML_RESOURCES.fontsjlm_wnssbx10().getText();
		}
		if (source.equals("cyrillic/fonts/jlm_wnssi10.xml")) {
			return XML_RESOURCES.fontsjlm_wnssi10().getText();
		}
		if (source.equals("cyrillic/fonts/jlm_wnti10.xml")) {
			return XML_RESOURCES.fontsjlm_wnti10().getText();
		}
		if (source.equals("cyrillic/fonts/jlm_wntt10.xml")) {
			return XML_RESOURCES.fontsjlm_wntt10().getText();
		}
		if (source.equals("cyrillic/fonts/language_cyrillic.xml")) {
			return XML_RESOURCES.fontslanguage_cyrillic().getText();
		}
		if (source.equals("cyrillic/fonts/mappings_cyrillic.xml")) {
			return XML_RESOURCES.fontsmappings_cyrillic().getText();
		}
		if (source.equals("cyrillic/fonts/symbols_cyrillic.xml")) {
			return XML_RESOURCES.fontssymbols_cyrillic().getText();
		}
		if (source.equals("DefaultTeXFont.xml")) {
			return XML_RESOURCES.DefaultTeXFont().getText();
		}
		if (source.equals("fonts/base/jlm_amsfonts.map.xml")) {
			return XML_RESOURCES.basejlm_amsfonts_map().getText();
		}
		if (source.equals("fonts/base/jlm_amssymb.map.xml")) {
			return XML_RESOURCES.basejlm_amssymb_map().getText();
		}
		if (source.equals("fonts/base/jlm_base.map.xml")) {
			return XML_RESOURCES.basejlm_base_map().getText();
		}
		if (source.equals("fonts/base/jlm_cmex10.xml")) {
			return XML_RESOURCES.basejlm_cmex10().getText();
		}
		if (source.equals("fonts/base/jlm_cmmi10.xml")) {
			return XML_RESOURCES.basejlm_cmmi10().getText();
		}
		if (source.equals("fonts/base/jlm_cmmi10_unchanged.xml")) {
			return XML_RESOURCES.basejlm_cmmi10_unchanged().getText();
		}
		if (source.equals("fonts/base/jlm_cmmib10.xml")) {
			return XML_RESOURCES.basejlm_cmmib10().getText();
		}
		if (source.equals("fonts/base/jlm_cmmib10_unchanged.xml")) {
			return XML_RESOURCES.basejlm_cmmib10_unchanged().getText();
		}
		if (source.equals("fonts/base/jlm_moustache.xml")) {
			return XML_RESOURCES.basejlm_moustache().getText();
		}
		if (source.equals("fonts/euler/jlm_eufb10.xml")) {
			return XML_RESOURCES.eulerjlm_eufb10().getText();
		}
		if (source.equals("fonts/euler/jlm_eufm10.xml")) {
			return XML_RESOURCES.eulerjlm_eufm10().getText();
		}
		if (source.equals("fonts/latin/jlm_cmr10.xml")) {
			return XML_RESOURCES.latinjlm_cmr10().getText();
		}
		if (source.equals("fonts/latin/jlm_jlmbi10.xml")) {
			return XML_RESOURCES.latinjlm_jlmbi10().getText();
		}
		if (source.equals("fonts/latin/jlm_jlmbx10.xml")) {
			return XML_RESOURCES.latinjlm_jlmbx10().getText();
		}
		if (source.equals("fonts/latin/jlm_jlmi10.xml")) {
			return XML_RESOURCES.latinjlm_jlmi10().getText();
		}
		if (source.equals("fonts/latin/jlm_jlmr10.xml")) {
			return XML_RESOURCES.latinjlm_jlmr10().getText();
		}
		if (source.equals("fonts/latin/jlm_jlmr10_unchanged.xml")) {
			return XML_RESOURCES.latinjlm_jlmr10_unchanged().getText();
		}
		if (source.equals("fonts/latin/jlm_jlmsb10.xml")) {
			return XML_RESOURCES.latinjlm_jlmsb10().getText();
		}
		if (source.equals("fonts/latin/jlm_jlmsbi10.xml")) {
			return XML_RESOURCES.latinjlm_jlmsbi10().getText();
		}
		if (source.equals("fonts/latin/jlm_jlmsi10.xml")) {
			return XML_RESOURCES.latinjlm_jlmsi10().getText();
		}
		if (source.equals("fonts/latin/jlm_jlmss10.xml")) {
			return XML_RESOURCES.latinjlm_jlmss10().getText();
		}
		if (source.equals("fonts/latin/jlm_jlmtt10.xml")) {
			return XML_RESOURCES.latinjlm_jlmtt10().getText();
		}
		if (source.equals("fonts/latin/optional/jlm_cmbx10.xml")) {
			return XML_RESOURCES.optionaljlm_cmbx10().getText();
		}
		if (source.equals("fonts/latin/optional/jlm_cmbxti10.xml")) {
			return XML_RESOURCES.optionaljlm_cmbxti10().getText();
		}
		if (source.equals("fonts/latin/optional/jlm_cmss10.xml")) {
			return XML_RESOURCES.optionaljlm_cmss10().getText();
		}
		if (source.equals("fonts/latin/optional/jlm_cmssbx10.xml")) {
			return XML_RESOURCES.optionaljlm_cmssbx10().getText();
		}
		if (source.equals("fonts/latin/optional/jlm_cmssi10.xml")) {
			return XML_RESOURCES.optionaljlm_cmssi10().getText();
		}
		if (source.equals("fonts/latin/optional/jlm_cmti10.xml")) {
			return XML_RESOURCES.optionaljlm_cmti10().getText();
		}
		if (source.equals("fonts/latin/optional/jlm_cmti10_unchanged.xml")) {
			return XML_RESOURCES.optionaljlm_cmti10_unchanged().getText();
		}
		if (source.equals("fonts/latin/optional/jlm_cmtt10.xml")) {
			return XML_RESOURCES.optionaljlm_cmtt10().getText();
		}
		if (source.equals("fonts/maths/jlm_cmbsy10.xml")) {
			return XML_RESOURCES.mathsjlm_cmbsy10().getText();
		}
		if (source.equals("fonts/maths/jlm_cmsy10.xml")) {
			return XML_RESOURCES.mathsjlm_cmsy10().getText();
		}
		if (source.equals("fonts/maths/jlm_msam10.xml")) {
			return XML_RESOURCES.mathsjlm_msam10().getText();
		}
		if (source.equals("fonts/maths/jlm_msbm10.xml")) {
			return XML_RESOURCES.mathsjlm_msbm10().getText();
		}
		if (source.equals("fonts/maths/jlm_rsfs10.xml")) {
			return XML_RESOURCES.mathsjlm_rsfs10().getText();
		}
		if (source.equals("fonts/maths/jlm_special.map.xml")) {
			return XML_RESOURCES.mathsjlm_special_map().getText();
		}
		if (source.equals("fonts/maths/jlm_special.xml")) {
			return XML_RESOURCES.mathsjlm_special().getText();
		}
		if (source.equals("fonts/maths/jlm_stmary10.xml")) {
			return XML_RESOURCES.mathsjlm_stmary10().getText();
		}
		if (source.equals("fonts/maths/jlm_stmaryrd.map.xml")) {
			return XML_RESOURCES.mathsjlm_stmaryrd_map().getText();
		}
		if (source.equals("fonts/maths/optional/jlm_dsrom10.xml")) {
			return XML_RESOURCES.optionaljlm_dsrom10().getText();
		}
		if (source.equals("GlueSettings.xml")) {
			return XML_RESOURCES.GlueSettings().getText();
		}
		if (source.equals("greek/fonts/jlm_fcmbipg.xml")) {
			return XML_RESOURCES.fontsjlm_fcmbipg().getText();
		}
		if (source.equals("greek/fonts/jlm_fcmbpg.xml")) {
			return XML_RESOURCES.fontsjlm_fcmbpg().getText();
		}
		if (source.equals("greek/fonts/jlm_fcmripg.xml")) {
			return XML_RESOURCES.fontsjlm_fcmripg().getText();
		}
		if (source.equals("greek/fonts/jlm_fcmrpg.xml")) {
			return XML_RESOURCES.fontsjlm_fcmrpg().getText();
		}
		if (source.equals("greek/fonts/jlm_fcsbpg.xml")) {
			return XML_RESOURCES.fontsjlm_fcsbpg().getText();
		}
		if (source.equals("greek/fonts/jlm_fcsropg.xml")) {
			return XML_RESOURCES.fontsjlm_fcsropg().getText();
		}
		if (source.equals("greek/fonts/jlm_fcsrpg.xml")) {
			return XML_RESOURCES.fontsjlm_fcsrpg().getText();
		}
		if (source.equals("greek/fonts/jlm_fctrpg.xml")) {
			return XML_RESOURCES.fontsjlm_fctrpg().getText();
		}
		if (source.equals("greek/fonts/jlm_greek.map.xml")) {
			return XML_RESOURCES.fontsjlm_greek_map().getText();
		}
		if (source.equals("greek/fonts/language_greek.xml")) {
			return XML_RESOURCES.fontslanguage_greek().getText();
		}
		if (source.equals("greek/fonts/mappings_greek.xml")) {
			return XML_RESOURCES.fontsmappings_greek().getText();
		}
		if (source.equals("greek/fonts/symbols_greek.xml")) {
			return XML_RESOURCES.fontssymbols_greek().getText();
		}
		if (source.equals("TeXFormulaSettings.xml")) {
			return XML_RESOURCES.TeXFormulaSettings().getText();
		}
		if (source.equals("TeXSymbols.xml")) {
			return XML_RESOURCES.TeXSymbols().getText();
		}
		throw new ResourceParseException(
				"Resource not found, please regenerate XmlResource file and ResourceLoader.getResource() methods");
	}
}
