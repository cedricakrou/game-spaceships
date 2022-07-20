package scene.frame;

import javax.swing.JFrame;

import scene.panel.ScenePanel;

@SuppressWarnings("serial")
public class SceneFrame extends JFrame 
{
	public static ScenePanel scenePanel;
	
	public SceneFrame() 
	{
		// TODO Auto-generated constructor stub
		scenePanel = new ScenePanel();
		
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		this.setResizable(false);
		this.setTitle("SPAACE  SHOOTER");
		this.setContentPane(scenePanel);
		this.setVisible(true);
	}

}
