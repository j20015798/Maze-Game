import java.awt.Color;
import javax.swing.JProgressBar;

//���
public class HealthPointBar extends JProgressBar{
	
	public HealthPointBar(int min, int max) {
		super(min, max);
		this.setValue(max);
		this.setForeground(Color.RED);
		this.setBorderPainted(false);
	}
	
}
