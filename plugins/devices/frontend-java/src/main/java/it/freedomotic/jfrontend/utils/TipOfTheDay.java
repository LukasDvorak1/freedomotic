/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.freedomotic.jfrontend.utils;

import it.freedomotic.app.Freedomotic;
import it.freedomotic.jfrontend.MainWindow;

import java.awt.Dimension;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ToolTipManager;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**
 *
 * @author enrico
 */
public class TipOfTheDay
        extends javax.swing.JFrame {

    private MainWindow main;
    private static String PAGE = "http://www.freedomotic.com/help/index.html";
    /**
     * Creates new form TipOfTheDay
     */
    public TipOfTheDay(MainWindow main) {
        initComponents();
        this.main = main;

        try {
            browser.setPage(new URL(PAGE));
            browser.setEditable(false);
            ToolTipManager.sharedInstance().registerComponent(browser);
            browser.addHyperlinkListener(new HyperlinkListener() {
                @Override
                public void hyperlinkUpdate(HyperlinkEvent e) {
                    if (HyperlinkEvent.EventType.ACTIVATED == e.getEventType()) {
                        try {
                            browser.setPage(e.getURL());
                        } catch (IOException e1) {
                            Freedomotic.logger.warning("Cannot open " + PAGE + " for reason: " + e1.getLocalizedMessage());
                        }
                    }
                }
            });
            setPreferredSize(new Dimension(800, 600));
            requestFocus();
            pack();
            setVisible(true);
        } catch (IOException ex) {
            Freedomotic.logger.warning("Cannot open " + PAGE + " for reason: " + ex.getLocalizedMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings( "unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(  )
    {
        jScrollPane1 = new javax.swing.JScrollPane(  );
        browser = new javax.swing.JTextPane(  );

        setDefaultCloseOperation( javax.swing.WindowConstants.DISPOSE_ON_CLOSE );
        setTitle( "Tip Of The Day" );

        jScrollPane1.setViewportView( browser );

        getContentPane(  ).add( jScrollPane1, java.awt.BorderLayout.CENTER );

        pack(  );
    } // </editor-fold>//GEN-END:initComponents
      // Variables declaration - do not modify//GEN-BEGIN:variables

    private javax.swing.JTextPane browser;
    private javax.swing.JScrollPane jScrollPane1;

    // End of variables declaration//GEN-END:variables
}
