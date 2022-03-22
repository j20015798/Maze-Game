import javax.swing.ImageIcon;


public class Brickwall extends GameObject{
	
	public Brickwall(Main main, HealthPointBar HP_bar) {
	
		super(main, HP_bar, new ImageIcon("src/brickwall.png"), -20);
	}

}
