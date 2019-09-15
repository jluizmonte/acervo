package br.com.acervo.util;

import javax.swing.UIManager;

/**
 * @author Michael Hagen
 */
public class GUIProperties {
	/**
	 * temas padrões
	 */
	public static final String PLAF_METAL = "javax.swing.plaf.metal.MetalLookAndFeel";
	public static final String PLAF_NIMBUS = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
	public static final String PLAF_MOTIF = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
	public static final String PLAF_SYSTEM = UIManager.getSystemLookAndFeelClassName();

	/**
	 * temas novos JTattoo
	 */
	public static final String PLAF_AERO = "com.jtattoo.plaf.aero.AeroLookAndFeel";
	public static final String PLAF_GRAPHITE = "com.jtattoo.plaf.graphite.GraphiteLookAndFeel";
	public static final String PLAF_MCWIN = "com.jtattoo.plaf.mcwin.McWinLookAndFeel";
	public static final String PLAF_NOIRE = "com.jtattoo.plaf.noire.NoireLookAndFeel";

	/**
	 * Temas Synthetica
	 */
	public static final String PLAF_SYNTHETICA_BLUE = "de.javasoft.plaf.synthetica.SyntheticaBlueLightLookAndFeel";
	public static final String PLAF_SYNTHETICA_BLACKSTEEL = "de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel";
	public static final String PLAF_SYNTHETICA_PLAIN = "de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel";

}
