import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//鑽石物件
public class Diamond extends GameObject{
	public Diamond(Main main, HealthPointBar HP_bar) {
		super(main, HP_bar, new ImageIcon("src/diamond.png"), 0);
		
		//碰到鑽石就獲勝=>結束遊戲
		this.addMouseListener(
			new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					JOptionPane.showMessageDialog(main, String.format("贏了!\n分數: %d", HP_bar.getValue()));
					main.endGame();
				}
			}
		);
	}
}
