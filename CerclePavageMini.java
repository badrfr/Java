import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class CerclePavageMini extends JPanel {
    private int rayon = 300; // Define the radius of the large circle
    private int smallCircleDiameter = 10; // Diameter of the small circles

    public CerclePavageMini() {
        // Adjust the preferred size according to your needs
        setPreferredSize(new Dimension(2 * rayon + 100, 2 * rayon + 100));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Improve rendering for better circle quality
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        // Draw the large circle as a base
        g2d.setColor(Color.black);
        g2d.fillOval(centerX - rayon, centerY - rayon, 2 * rayon, 2 * rayon);

        // Draw smaller circles inside the large circle
        for (int i = -rayon; i <= rayon; i += smallCircleDiameter) {
            for (int j = -rayon; j <= rayon; j += smallCircleDiameter) {
                double distance = Math.sqrt(i * i + j * j);
                float angle = (float) Math.atan2(j, i);
                if (distance <= rayon) {
                    // Opacity decreases with distance from the center
                    float opacity = 1.0f - (float) distance / rayon;
                    // Color hue varies with angle
                    float hue = (angle + (float) Math.PI) / (2 * (float) Math.PI);
                    Color color = Color.getHSBColor(hue, 1.0f, 1.0f);
                    g2d.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), (int) (opacity * 255)));
                    // Draw the small circle
                    g2d.fill(new Ellipse2D.Float(centerX + i - smallCircleDiameter / 2, centerY + j - smallCircleDiameter / 2, smallCircleDiameter, smallCircleDiameter));
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("CerclePavageMini");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            CerclePavageMini panel = new CerclePavageMini();
            frame.add(panel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
