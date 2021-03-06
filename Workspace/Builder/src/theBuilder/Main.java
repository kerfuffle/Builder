package theBuilder;

import java.util.Vector;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import theBuilder.Util.*;

import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glVertex2f;
import static org.lwjgl.opengl.GL11.*;

public class Main {

	static int width = 1000, height = 700;
	
	static Vector <Quad> objQuad = new Vector<Quad>(0, 1);
	static boolean holding = false;
	static int objHeld;
	
	public Main()
	{
		try
		{
			Display.setDisplayMode(new DisplayMode (1000, 700));
			Display.setTitle("Game Map Builder");
			Display.create();
		}
		catch(LWJGLException e)
		{
			e.printStackTrace();
		}


		initGL();

		while(!Display.isCloseRequested())
		{
			glClear(GL_COLOR_BUFFER_BIT);
			/*if (Util.checkKey(Keyboard.KEY_P))
			{
				addObj();
			}*/
			
			if (Util.checkKey(Keyboard.KEY_TAB))
			{
				if (Menu.hidden)
				{
					Menu.hidden = false;
				}
				else if (!Menu.hidden)
				{
					Menu.hidden = true;
				}			
			}
			
			if ((Keyboard.isKeyDown(Keyboard.KEY_RCONTROL) || Keyboard.isKeyDown(Keyboard.KEY_LCONTROL)) && Util.checkKey(Keyboard.KEY_DELETE) && !Menu.pop)
			{
				Menu.deletePrompt = true;
			}
			
			if (Keyboard.isKeyDown(Keyboard.KEY_RCONTROL) || Keyboard.isKeyDown(Keyboard.KEY_LCONTROL))
			{
				Menu.popHidden = true;
			}
			else
			{
				Menu.popHidden = false;
			}
			
			if (Menu.edit)
			{
				Menu.pop = true;
			}
			else
			{
				Menu.pop = false;
			}
			
			if (holding)
			{
				objQuad.get(objHeld).x = Mouse.getX() - (objQuad.get(objHeld).w/2);
				objQuad.get(objHeld).y = Mouse.getY() - (objQuad.get(objHeld).h/2);
				if (Util.checkMouse(0))
				{
					holding = false;
				}
			}

			
			
			
			for (int i = 0; i < objQuad.size(); i++)
			{
				objQuad.get(i).color = Util.assignColor(objQuad.get(i).color, 1, 1, 1);
				Util.setColor(objQuad.get(i).color);
				Util.quad(objQuad.get(i).x, objQuad.get(i).y, objQuad.get(i).w, objQuad.get(i).h);
			}
			
			
			if (Menu.deletePrompt)
			{
				Menu.deleteAll();
			}
			
			if (!Menu.MAIN)
			{
				Menu.checkRClick();
			}
			if (Menu.edit)
			{
				Menu.edit();
			}
			
			if (Menu.MAIN)
			{
				Menu.main();
			}
			else if (Menu.PLACE)
			{
				Menu.place();
			}
			else if (Menu.CUSTOM)
			{
				Menu.custom();
			}
			
			Display.update();
			Display.sync(100);			
		}
		if (Display.isCloseRequested())
		{
			Display.destroy();
		}
	}

	

	void initGL()
	{
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();		
		glOrtho(0, Display.getWidth(), 0, Display.getHeight(), -1, 1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
		
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

		glClearColor(0, 0, 0, 1);

		glDisable(GL_DEPTH_TEST);
	}
	
	
	public static void main(String[] args)
	{

		new Main();
	}
}
