
import java.awt.Dimension;
import java.awt.Toolkit;


public class MancalaTester {

    public static void main(String[] args) 
    {
        MancalaView MV = new MancalaView();
        MV.setSize(new Dimension(1440, 500));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        MV.setLocation(dim.width/2-MV.getSize().width/2, dim.height/2-MV.getSize().height/2);   
        MancalaController c = new MancalaController(3, MV);
        MV.setData(c);   
    }
}