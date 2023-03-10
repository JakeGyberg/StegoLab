import java.awt.*;

public class Steganography {

    /**
     * Clear the lower (rightmost) two bits in a pixel.
     * @param p
     */
    public static void clearLow(Pixel p) {
        p.setRed(p.getRed()/4*4);
        p.setGreen((p.getGreen()/4)*4);
        p.setBlue(p.getBlue()/4*4);

    }

    /** 
    * Sets the lower 2 bits in a pixel to the highest 2 bits in c 
    */
    public static void setLow (Pixel p, Color c) 
    {
        //System.out.println(p.getRed());
        int red = c.getRed()/64 + p.getRed()/4*4;
        int green = c.getGreen()/64 + p.getGreen()/4*4;
        int blue = c.getBlue()/64 + p.getBlue()/4*4;
        
        p.setRed(red);
        p.setGreen(green);
        p.setBlue(blue); 
        
    }

    // Testers
    public static Picture testClearLow(Picture p) {
        Picture np = new Picture(p);

        for (Pixel[] pix : np.getPixels2D()) {
            for (Pixel c : pix) {
                clearLow(c);
            }
        }

        return np;
    }

    public static Picture testSetLow(Picture p, Color c) {
        Picture newPic = new Picture(p);

        for (Pixel[] row : newPic.getPixels2D()) {
            for (Pixel col : row) {
                setLow(col, c);
            }
        }

        return newPic;
    }

    public static Picture revealPicture(Picture hidden) {
        Picture copy = new Picture(hidden);
        Pixel[][] pixels = copy.getPixels2D();
        Pixel[][] source = hidden.getPixels2D();
        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[0].length; c++) {
                Color col = source[r][c].getColor();
                /* To be Implemented */
            }
        }

        return copy;
    }
        

    public static void main(String[] args) {
        Picture beach = new Picture("beach.jpg"); 
        beach.explore(); 
        Picture copy2 = testSetLow(beach, Color.PINK); 
        copy2.explore(); 
        
        /*
         * Picture copy3 = revealPicture(copy2);
         * copy3.explore();
         */
    }
}