import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

//�R��
public class Heart extends GameObject{
	public Heart(Main main, HealthPointBar HP_bar) {
	
		super(main, HP_bar, new ImageIcon("src/heart.png"), +10);
		
		//����R���ܹD��
		this.addMouseListener(
			new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {					
					//�����D��
					Heart.this.setIcon(null);
					Heart.this.setHpChange(-5);//�令�D������q�v�T��
					
					Heart.this.updateUI();
				}
			}
		);
	}
}
