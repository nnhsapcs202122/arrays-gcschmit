import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Dimension;
import javax.swing.JComponent;
import java.awt.geom.Line2D;

/**
 * Displays the map and draws the current tour and status on top of it.
 *      Also maps from lat/lng to coordinates in the context of this component. 
 * 
 * @author @gcschmit
 * @version 02jun2020
 */
public class Map extends JComponent 
{
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private static final double MIN_LAT = 50.19395025319712;
	private static final double MAX_LAT = 30.320009196592867;
	private static final double MIN_LNG = -103.57812500000001;
	private static final double MAX_LNG = -68.42187500000001;

    private BufferedImage mapImage;
    private Tour tour;
    private int gen;

    /**
     * Constructs a new Map.
     */
    public Map()
    {
        try
        {
            this.mapImage = ImageIO.read(new File("map.png"));
        }
        catch (IOException e)
        {
        }
    }
    
    /**
     * Overrides JComponent's getPreferredSize method to return a size large enough to
     *  encapsulate the map
     *
     * @returns the preferred size for the component
     * 
     */
    @Override
    public Dimension getPreferredSize()
    {
        // the component needs to be large enough to encapsulate the map
        return new Dimension(WIDTH, HEIGHT);
    }
    
    /**
     * Sets the tour and generation to display on this map to the specified tour and generation.
     *      These will be displayed the next time the paintComponent method is invoked by
     *      the run-time.
     * 
     * @param currentTour   the tour to display on this map 
     * @param generation    the generation to display on this map
     */
    public void setCurrentTour(Tour currentTour, int generation)
    {
        this.tour = currentTour;
        this.gen = generation;
        
        // ask the Java Run-Time to invoke the paintComponent method at the next opportunity
        this.repaint();
    }

    /**
     * This method is invoked by the Java Run-Time whenever the component needs to be redrawn.
     *  It does not need to be invoked explicitly. It draws both the map and the current tour.
     *  It will be invoked shortly after the setCurrentTour method is invoked.
     *
     * @param    g    the graphics object to be used for all graphics operations
     * 
     */
    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;

        // scale the Google map image file to this component
        g2.drawImage(this.mapImage, 0, 0, this.getWidth(), this.getHeight(),
                0, 0, 1600, 1200, null);

        drawTour(g2);

        // draw the current status (i.e., generation and current best tour)
        String status = String.format("Map [%3d] %s", gen, (this.tour == null ? "<null>" : tour));
        g2.setColor(Color.BLACK);
        g2.drawString(status, 200, 25);
    }
    
    private void drawTour(Graphics2D g2) 
    {
        if(this.tour == null)
        {
            return;
        }
            
        final int OFFSET = 20;
        City[] cities = this.tour.getCities();
        
        g2.setFont(new Font("SansSerif", Font.BOLD, 16));
        
        double x1, y1, x2, y2;
        for (int i = 0; i < cities.length; i++) 
        {
            x1 = Map.lngToX(cities[i].getLng(), this.getWidth());
            y1 = Map.latToY(cities[i].getLat(), this.getHeight());
            
            int nextCityIndex = i + 1;
            if(i == cities.length - 1) // loop back to the first city
            {
                nextCityIndex = 0;
            }
            
            x2 = Map.lngToX(cities[nextCityIndex].getLng(), this.getWidth());
            y2 = Map.latToY(cities[nextCityIndex].getLat(), this.getHeight());
            
            Line2D.Double path = new Line2D.Double(x1, y1, x2, y2);
            
            g2.setColor(Color.BLUE);
            g2.draw(path);
            g2.setColor(Color.RED);
            g2.drawString(Integer.toString(i), (float)(x1 - OFFSET), (float)(y1 + OFFSET));
        }
    }
    
    /**
     * Converts the specified longitude to the x coordinate in the context of this component
     * 
     * @param lng   the longitude value to convert
     * @return     the x coordinate that corresponds to the specified longitude
     */
    public static double lngToX(double lng, double width)
    {
        return (lng - MIN_LNG) / (MAX_LNG - MIN_LNG) * width;
    }
    
    /**
     * Converts the specified latitude to the y coordinate in the context of this component
     * 
     * @param lng   the latitude value to convert
     * @return     the y coordinate that corresponds to the specified latitude
     */
    public static double latToY(double lat, double height)
    {
        return (lat - MIN_LAT) / (MAX_LAT - MIN_LAT) * height;
    }
    
    
    
    
}