import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//�p�۪���
public class Diamond extends GameObject{
	public Diamond(Main main, HealthPointBar HP_bar) {
		super(main, HP_bar, new ImageIcon("src/diamond.png"), 0);
		
		//�I���p�۴N���=>�����C��
		this.addMouseListener(
			new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					JOptionPane.showMessageDialog(main, String.format("Ĺ�F!\n����: %d", HP_bar.getValue()));
					main.endGame();
				}
			}
		);
	}
}
