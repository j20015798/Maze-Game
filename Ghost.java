import javax.swing.ImageIcon;


public class Ghost extends GameObject{
	
	public Ghost(Main main, HealthPointBar HP_bar) {
	
		super(main, HP_bar, new ImageIcon("src/ghost.png"), 0);
	}

}
