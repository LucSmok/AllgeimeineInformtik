import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Diese Klasse implementiert ein Fenster, dass Sie ein Bild anzeigen lässt.
 * Die einzige im Rahmen der Übung relevante Methode ist der Konstruktor.
 *
 * @author Florian Brandherm
 * @version 04-29-2021
 */
public class BitmapFenster extends JPanel {

    JFrame frame;
    BufferedImage img;
    JButton speicherButton;

    /**
     * Der Konstruktur erstellt ein Fenster, welches ein Bild anzeigt.
     * @param bitmap Ein 2d-Array von Bildpunkten
     * @param verkleinern Falls true, wird das bild um 50% verkleinert, was eine Kantenglättung zur Folge hat.
     * @param farbig Falls true, wird das Bild in falschfarben eingefärbt. Anderenfalls wird ein Graustufenbild ausgegeban.
     */
    public BitmapFenster(int[][] bitmap, boolean verkleinern, boolean farbig) {
        frame = new JFrame("Mandelbrotmenge");
        frame.getContentPane().setBackground(Color.black);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
        frame.add(this);

        int bmp_width = bitmap.length;
        int bmp_height = bitmap[0].length;
        this.img = new BufferedImage(bmp_width,bmp_height,BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < bmp_width; ++x) {
            for (int y=0; y < bmp_height; ++y) {
                if (bitmap[x][y] == 255) {
                    this.img.setRGB(x, y, 0xFF000000);
                } else {
                    float value = bitmap[x][y]/254.0f;
                    int col;
                    if (farbig) {
                        col = Color.getHSBColor((float)Math.sqrt(value)+0.5f, 1.0f, 1.0f).getRGB();
                    } else {
                        col = Color.getHSBColor(1.0f, 0.0f, value).getRGB();
                    }
                    this.img.setRGB(x, y, col);
                }
            }
        }

        if (verkleinern) {
            AffineTransform at = new AffineTransform();
            at.scale(0.5, 0.5);
            AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
            this.img = scaleOp.filter(this.img, new BufferedImage(bmp_width/2, bmp_height/2, BufferedImage.TYPE_INT_RGB));
        }

        this.setPreferredSize(new Dimension(this.img.getWidth(), this.img.getHeight()));

        this.speicherButton = new JButton("Bild Speichern!");
        this.speicherButton.setSize(new Dimension(100,100));
        this.speicherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser speicherdialog = new JFileChooser();
                speicherdialog.setDialogTitle("Wählen Sie den Speicherort.");
                int nutzerauswahl = speicherdialog.showSaveDialog(frame);
                if (nutzerauswahl == JFileChooser.APPROVE_OPTION) {
                    String dateiname = speicherdialog.getSelectedFile().toString();
                    if (!dateiname.endsWith(".png"))
                        dateiname += ".png";
                    File datei = new File(dateiname);
                    try {
                        ImageIO.write(img, "png", datei);
                    } catch (IOException ex) {
                        System.err.println("Konnte das Bild nicht speichern!");
                        ex.printStackTrace();
                    }
                }
            }
        });
        this.speicherButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
        this.frame.add(this.speicherButton);
        this.doLayout();
        this.frame.pack();

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }

    /**
     * Zeichnet das Bild, wenn das Fenster neu gezeichnet wird.
     * Diese Methode wird automatisch vom Fenstermanager aufgerufen und
     * kann im Rahmen der Übung ignoriert werden.
     */
    public void paint(Graphics g) {
        g.drawImage(this.img,0,0,this.img.getWidth(),this.img.getHeight(),null);
    }

}
