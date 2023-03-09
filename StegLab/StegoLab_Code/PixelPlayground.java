import java.awt.Color;

public class PixelPlayground {

    public static Picture zeroBlue(Picture pic)
    {
        Picture newPic = pic;
        return pic;
    }
    public static void main(String[] args)
    {
        Picture waterPic = new Picture("water.jpg");
        waterPic.explore();

        Picture beachPicNoBlue = zeroBlue(waterPic);
        beachPicNoBlue.explore();
    }
 
}
