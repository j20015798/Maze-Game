//�m�W:�\ã��
//�Ǹ�:108403036
//�t��:���2B

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main extends JFrame{
	HealthPointBar HP_Bar;
	JPanel map;
	Scanner input;
	
	public Main(){
		super("�q�y����");
		startGame();
	}
	
	public void startGame() {		
		map = new JPanel(new GridLayout(10, 10));

	
		HP_Bar = new HealthPointBar(0, 100);
		add(HP_Bar, BorderLayout.NORTH);
		HP_Bar.updateUI();
		
		Pattern pattern = Pattern.compile("\\s+");
		try {
			//Ū�J�a����
			Files.lines(Paths.get("src/map.txt"))
			     .map(line -> line.replaceAll("(?!')\\p{P}", ""))
			     .flatMap(line -> pattern.splitAsStream(line))
			     .mapToInt(Integer::parseInt)
			     //�P�_�Ӧ�m�O���򪫥�
			     .mapToObj(value -> {
					  switch(value) {
				  		case 1:
							return new Brickwall(Main.this, HP_Bar);
						case 2:
							return new Diamond(Main.this, HP_Bar);
						case 3:
							return new Ghost(Main.this, HP_Bar);
						default: 
							return new Road(Main.this, HP_Bar);
					  }			  
				  })
			     //�H���N�X�������R��
				  .map(gameObj -> { 
					  if(gameObj instanceof Brickwall)
						  return (Math.random()*100<15) ? new Heart(Main.this, HP_Bar) : gameObj;//���v15%�|�O�R��
					  else
						  return gameObj;
				  })
				  .forEach(gameObj->map.add(gameObj));
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		

		
		add(map, BorderLayout.CENTER);
		map.updateUI();
	}

	
	public void endGame() {
		
		if(JOptionPane.showConfirmDialog(this, "�A�Ӥ@��?", "�T��", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			map.removeAll();
			startGame();
					}else {
			System.exit(1);
		}
	}
	
	public static void main(String args[]) {
		Main main = new Main();
		
		main.setSize(1000, 1000);
		main.setResizable(false);
	    main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    main.setLocationRelativeTo(null);
	    main.setVisible(true);
	    
  		if(JOptionPane.showConfirmDialog(main, "�}�l�C��?", "�q�y����", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
  			System.exit(1);
  		}
	}
	
}
