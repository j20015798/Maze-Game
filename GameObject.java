import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

//所有遊戲物件的父集合
public class GameObject extends JLabel{
	
	private int hpChange;//血量增減值
	private ImageIcon icon;//圖示
	
	public GameObject(Main main, HealthPointBar HP_bar ,ImageIcon icon, int hpChange) {
		super();
		this.hpChange = hpChange;
		this.icon = icon;
		this.setIcon(icon);
		
		
		this.addMouseListener(
			new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					//調整血量
					HP_bar.setValue(HP_bar.getValue() + getHpChange());
					
					//沒血就結束遊戲
					if(HP_bar.getValue() == 0){
						JOptionPane.showMessageDialog(main, "輸了哭哭");
						main.endGame();
					}
				}
			}
		);
		
	}

	public int getHpChange() {
		return hpChange;
	}

	public void setHpChange(int hpChange) {
		this.hpChange = hpChange;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	
}
