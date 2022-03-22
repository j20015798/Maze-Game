import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

//�Ҧ��C�����󪺤����X
public class GameObject extends JLabel{
	
	private int hpChange;//��q�W���
	private ImageIcon icon;//�ϥ�
	
	public GameObject(Main main, HealthPointBar HP_bar ,ImageIcon icon, int hpChange) {
		super();
		this.hpChange = hpChange;
		this.icon = icon;
		this.setIcon(icon);
		
		
		this.addMouseListener(
			new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					//�վ��q
					HP_bar.setValue(HP_bar.getValue() + getHpChange());
					
					//�S��N�����C��
					if(HP_bar.getValue() == 0){
						JOptionPane.showMessageDialog(main, "��F����");
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
