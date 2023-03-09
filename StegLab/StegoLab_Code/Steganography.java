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

        public static Picture testClearLow(Picture p) {
            Picture np = new Picture(p);
            //Pixel[][] pixels = p.getPixels2D();
            for (Pixel[] pix : np.getPixels2D()) {
                for (Pixel c : pix) {
                    clearLow(c);
                }
            }
            return np;
        }

        /** 
        * Set the lower 2 bits in a pixel to the highest 2 bits in c 
        */
        public static void setLow (Pixel p, Color c) 
        {
            int red = c.getRed()/64 + p.getRed()/4*4;
            p.getRed()/64*64;
            
        }

        public static void main(String[] args) {
            Picture beach = new Picture("beach.jpg"); 
            beach.explore(); 
            Picture copy = testClearLow(beach); 
            copy.explore(); 
            
        }
}