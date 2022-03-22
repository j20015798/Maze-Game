//姓名:許瓊方
//學號:108403036
//系級:資管2B

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
		super("電流急急棒");
		startGame();
	}
	
	public void startGame() {		
		map = new JPanel(new GridLayout(10, 10));

	
		HP_Bar = new HealthPointBar(0, 100);
		add(HP_Bar, BorderLayout.NORTH);
		HP_Bar.updateUI();
		
		Pattern pattern = Pattern.compile("\\s+");
		try {
			//讀入地圖檔
			Files.lines(Paths.get("src/map.txt"))
			     .map(line -> line.replaceAll("(?!')\\p{P}", ""))
			     .flatMap(line -> pattern.splitAsStream(line))
			     .mapToInt(Integer::parseInt)
			     //判斷該位置是什麼物件
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
			     //隨機將幾個牆壁轉愛心
				  .map(gameObj -> { 
					  if(gameObj instanceof Brickwall)
						  return (Math.random()*100<15) ? new Heart(Main.this, HP_Bar) : gameObj;//機率15%會是愛心
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
		
		if(JOptionPane.showConfirmDialog(this, "再來一局?", "訊息", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
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
	    
  		if(JOptionPane.showConfirmDialog(main, "開始遊戲?", "電流急急棒", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
  			System.exit(1);
  		}
	}
	
}
