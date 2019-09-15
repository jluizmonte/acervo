package br.com.acervo.util;

import java.text.ParseException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import br.com.acervo.view.Login;
import de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel;

/**
 *
 * @author joseluiz
 */
public class AcervoLoader {

    public static void main(String[] args) {
        try {
            UIManager.put("Synthetica.window.decoration", Boolean.FALSE);
            UIManager.setLookAndFeel(new SyntheticaPlainLookAndFeel());
        } catch (ParseException | UnsupportedLookAndFeelException erro) {
        }
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }
}
