
import java.awt.Dimension;


public class MancalaTester {

    public static void main(String[] args) 
    {
        MancalaView MV = new MancalaView();
        MV.setSize(new Dimension(1000, 500));  
        MancalaController c = new MancalaController(3, MV);
        MV.setData(c);   
    }
}