package engineTester;

import org.lwjgl.opengl.Display;

import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.RawModel;
import renderEngine.Renderer;

public class MainGameLoop {

	public static void main(String[] args) {
		
		DisplayManager.createDisplay();
		
		Loader loader = new Loader();
		Renderer renderer = new Renderer();
		
		
		// OpenGL expects vertices to be defined counter clockwise by default
		float[] vertices = {
				
			//Left bottom triangle
				-0.5f, 0.5f, 0, //v0
				-0.5f, -0.5f, 0, //v1
				0.5f, -0.5f, 0, //v2
				0.5f, 0.5f, 0, //v3
				
		};
		int[] indices = {
				0, 1, 3, //v1
				3, 1, 2	//v2
		};
		
		RawModel model = loader.loadToVAO(vertices, indices);
		
		
		while(!Display.isCloseRequested()){
			renderer.prepare();
			
			//game logic
			//render 
			renderer.render(model);
			DisplayManager.updateDisplay();
		}
		
		loader.cleanUP();
		DisplayManager.closeDisplay();

	}

}
