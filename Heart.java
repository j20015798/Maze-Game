import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

//愛心
public class Heart extends GameObject{
	public Heart(Main main, HealthPointBar HP_bar) {
	
		super(main, HP_bar, new ImageIcon("src/heart.png"), +10);
		
		//移到愛心變道路
		this.addMouseListener(
			new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {					
					//換成道路
					Heart.this.setIcon(null);
					Heart.this.setHpChange(-5);//改成道路的血量影響值
					
					Heart.this.updateUI();
				}
			}
		);
	}
}
