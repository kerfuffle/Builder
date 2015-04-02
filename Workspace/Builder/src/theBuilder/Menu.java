package theBuilder;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Menu {

	static boolean MAIN = true;
	static boolean HELP, PLACE, CUSTOM, PROP;

	static boolean hidden;
	static boolean popHidden;
	static boolean pop;




	static void main()
	{
		float w = 300, h = 500;
		float x = (Main.width/2) - (w/2), y = (Main.height/2) - (h/2);

		float bx = x + 10, by = y + 10, bw = w - 20, bh = h - 20;

		float btnX = x + 50, btnW = 200, btnH = 50;

		float exitY = y + 25;
		boolean exitHover = false;

		float helpY = exitY + btnH + 50;
		boolean helpHover = false;

		float saveY = helpY + btnH + 50;
		boolean saveHover = false;

		float openY = saveY + btnH + 50;
		boolean openHover = false;

		float placeY = openY + btnH + 50;
		boolean placeHover = false;



		if (Util.onClick(btnX, placeY, btnW, btnH))
		{
			placeHover = true;
			PLACE = true;
			MAIN = false;
		}
		else if (Util.onHover(btnX, placeY, btnW, btnH))
		{
			placeHover = true;
		}
		else
		{
			placeHover = false;
		}


		if (Util.onClick(btnX, openY, btnW, btnH))
		{
			openHover = true;
			//open
		}
		else if (Util.onHover(btnX, openY, btnW, btnH))
		{
			openHover = true;
		}
		else
		{
			openHover = false;
		}

		if (Util.onClick(btnX, saveY, btnW, btnH))
		{
			saveHover = true;
			//save
		}
		else if (Util.onHover(btnX, saveY, btnW, btnH))
		{
			saveHover = true;
		}
		else
		{
			saveHover = false;
		}

		if (Util.onClick(btnX, helpY, btnW, btnH))
		{
			helpHover = true;
			HELP = true;
			MAIN = false;
		}
		else if (Util.onHover(btnX, helpY, btnW, btnH))
		{
			helpHover = true;
		}
		else
		{
			helpHover = false;
		}

		if (Util.onClick(btnX, exitY, btnW, btnH))
		{
			exitHover = true;
			System.exit(0);
		}
		else if (Util.onHover(btnX, exitY, btnW, btnH))
		{
			exitHover = true;
		}
		else
		{
			exitHover = false;
		}

		glColor3f(1, 0, 0);
		Util.quad(x, y, w, h);

		glColor3f(1, 1, 0);
		Util.quad(bx, by, bw, bh);


		if (exitHover)
		{
			glColor3f(1, 0, 0);
		}
		else
		{
			glColor3f(1, 0.502f, 0);
		}
		Util.quad(btnX, exitY, btnW, btnH);


		if (helpHover)
		{
			glColor3f(1, 0, 0);
		}
		else
		{
			glColor3f(1, 0.502f, 0);
		}
		Util.quad(btnX, helpY, btnW, btnH);


		if (saveHover)
		{
			glColor3f(1, 0, 0);
		}
		else
		{
			glColor3f(1, 0.502f, 0);
		}
		Util.quad(btnX, saveY, btnW, btnH);


		if (openHover)
		{
			glColor3f(1, 0, 0);
		}
		else
		{
			glColor3f(1, 0.502f, 0);
		}
		Util.quad(btnX, openY, btnW, btnH);


		if (placeHover)
		{
			glColor3f(1, 0, 0);
		}
		else
		{
			glColor3f(1, 0.502f, 0);
		}
		Util.quad(btnX, placeY, btnW, btnH);


		glColor3f(0, 0, 0);
		Util.drawString("Exit", btnX + 80, exitY + 20);
		Util.drawString("Help", btnX + 80, helpY + 20);
		Util.drawString("Save", btnX + 80, saveY + 20);
		Util.drawString("Open", btnX + 80, openY + 20);
		Util.drawString("Place", btnX + 80, placeY + 20);

	}

	static void place()
	{
		float w = 300, h = 500;
		float x = Main.width - w, y = (Main.height/2) - (h/2);

		float bx = x + 10, by = y + 10, bw = w - 10, bh = h - 20;

		float btnX = x + 50, btnW = 200, btnH = 50;

		float backY = y + 25;
		boolean backHover = false;

		float customY = backY + btnH + 50;
		boolean customHover = false;

		float propY = customY + btnH + 50;
		boolean propHover = false;

		float enemyY = propY + btnH + 50;
		boolean enemyHover = false;

		float playerY = enemyY + btnH + 50;
		boolean playerHover = false;


		for (int i = 0; i < Main.objQuad.size(); i++)
		{
			if (hidden)
			{
				if (Util.onClick(Main.objQuad.get(i).x, Main.objQuad.get(i).y, Main.objQuad.get(i).w, Main.objQuad.get(i).h))
				{
					Main.objHeld = i;
					Main.holding = true;
				}
			}
			else
			{
				if (Util.onClick(Main.objQuad.get(i).x, Main.objQuad.get(i).y, Main.objQuad.get(i).w, Main.objQuad.get(i).h) && !Util.onHover(x, y, w, h))
				{
					Main.objHeld = i;
					Main.holding = true;
				}
			}


		}


		if (!hidden)
		{
			if (Util.onClick(btnX, playerY, btnW, btnH))
			{
				playerHover = true;
				//player stuff
			}
			else if (Util.onHover(btnX, playerY, btnW, btnH))
			{
				playerHover = true;
			}
			else
			{
				playerHover = false;
			}

			if (Util.onClick(btnX, enemyY, btnW, btnH))
			{
				enemyHover = true;
				//enemy stuff
			}
			else if (Util.onHover(btnX, enemyY, btnW, btnH))
			{
				enemyHover = true;
			}
			else
			{
				enemyHover = false;
			}

			if (Util.onClick(btnX, propY, btnW, btnH))
			{
				propHover = true;
				PROP = true;
				PLACE = false;
			}
			else if (Util.onHover(btnX, propY, btnW, btnH))
			{
				propHover = true;
			}
			else
			{
				propHover = false;
			}

			if (Util.onClick(btnX, customY, btnW, btnH))
			{
				customHover = true;
				CUSTOM  = true;
				PLACE = false;
			}
			else if (Util.onHover(btnX, customY, btnW, btnH))
			{
				customHover = true;
			}
			else
			{
				customHover = false;
			}

			if (Util.onClick(btnX, backY, btnW, btnH))
			{
				backHover = true;
				MAIN = true;
				PLACE = false;
			}
			else if (Util.onHover(btnX, backY, btnW, btnH))
			{
				backHover = true;
			}
			else
			{
				backHover = false;
			}


			glColor3f(1, 0, 0);
			Util.quad(x, y, w, h);

			glColor3f(1, 1, 0);
			Util.quad(bx, by, bw, bh);

			if (playerHover)
			{
				glColor3f(1, 0, 0);
			}
			else
			{
				glColor3f(1, 0.502f, 0);
			}
			Util.quad(btnX, playerY, btnW, btnH);


			if (enemyHover)
			{
				glColor3f(1, 0, 0);
			}
			else
			{
				glColor3f(1, 0.502f, 0);
			}
			Util.quad(btnX, enemyY, btnW, btnH);


			if (propHover)
			{
				glColor3f(1, 0, 0);
			}
			else
			{
				glColor3f(1, 0.502f, 0);
			}
			Util.quad(btnX, propY, btnW, btnH);


			if (customHover)
			{
				glColor3f(1, 0, 0);
			}
			else
			{
				glColor3f(1, 0.502f, 0);
			}
			Util.quad(btnX, customY, btnW, btnH);


			if (backHover)
			{
				glColor3f(1, 0, 0);
			}
			else
			{
				glColor3f(1, 0.502f, 0);
			}
			Util.quad(btnX, backY, btnW, btnH);

			glColor3f(0, 0, 0);
			Util.drawString("Back", btnX + 80, backY + 20);
			Util.drawString("Custom", btnX + 75, customY + 20);
			Util.drawString("Prop", btnX + 80, propY + 20);
			Util.drawString("Enemy", btnX + 78, enemyY + 20);
			Util.drawString("Player", btnX + 75, playerY + 20);
		}



	}


	static String cusX = "0", cusY = "0", cusW = "0", cusH = "0";
	static char chX[] = cusX.toCharArray();
	static char chY[] = cusY.toCharArray();
	static char chW[] = cusW.toCharArray();
	static char chH[] = cusH.toCharArray();
	static boolean onX = false, onY = false, onW = false, onH = false;
	static int customX, customY, customW, customH;
	static void custom()
	{


		float w = 300, h = 250;
		float x = Main.width - w, y = (Main.height/2) - (h/2);

		float bx = x + 10, by = y + 10, bw = w - 10, bh = h - 20;

		float backX = x + 60, backY = y + 25, backW = 200, backH = 50;
		boolean backHover = false;

		float cW = 50, cH = 25;

		float xX = x + 50, xY = y + h - 50;
		float yX = xX + cW + 100, yY = y + h - 50;
		float wX = x + 50, wY = y + h - cH - 100;
		float hX = wX + cW + 100, hY = y + h - cH - 100;




		if (!hidden)
		{
			if (Util.onClick(backX, backY, backW, backH))
			{
				backHover = true;
				PLACE = true;
				CUSTOM = false;
			}
			else if (Util.onHover(backX, backY, backW, backH))
			{
				backHover = true;
			}
			else
			{
				backHover = false;
			}


			if (Util.onClick(xX, xY, cW, cH))
			{
				onX = true;
				onY = false;
				onW = false;
				onH = false;
			}
			else if (Util.onClick(yX, yY, cW, cH))
			{
				onX = false;
				onY = true;
				onW = false;
				onH = false;
			}
			else if (Util.onClick(wX, wY, cW, cH))
			{
				onX = false;
				onY = false;
				onW = true;
				onH = false;
			}
			else if (Util.onClick(hX, hY, cW, cH))
			{
				onX = false;
				onY = false;
				onW = false;
				onH = true;
			}
		}


		if (onX)
		{
			if (Util.checkKey(Keyboard.KEY_BACK))
			{
				if (cusX.length() != 0)
				{
					StringBuilder sb = new StringBuilder();
					sb.append(cusX);
					sb.deleteCharAt(cusX.length() - 1);
					cusX = sb.toString();
				}
			}
			else
			{
				if (cusX.length() < 4)
				{
					for (int i = 2; i <= 10; i++)
					{
						if (Util.checkKey(i))
						{
							int toAdd = i - 1;
							cusX += toAdd;
						}
					}
					if (Util.checkKey(Keyboard.KEY_0))
					{
						cusX += '0';
					}
				}
			}
		}

		if (onY)
		{
			if (Util.checkKey(Keyboard.KEY_BACK))
			{
				if (cusY.length() != 0)
				{
					StringBuilder sb = new StringBuilder();
					sb.append(cusY);
					sb.deleteCharAt(cusY.length() - 1);
					cusY = sb.toString();
				}
			}
			else
			{
				if (cusY.length() < 4)
				{
					for (int i = 2; i <= 10; i++)
					{
						if (Util.checkKey(i))
						{
							int toAdd = i - 1;
							cusY += toAdd;
						}
					}
					if (Util.checkKey(Keyboard.KEY_0))
					{
						cusY += '0';
					}
				}
			}
		}

		if (onW)
		{
			if (Util.checkKey(Keyboard.KEY_BACK))
			{
				if (cusW.length() != 0)
				{
					StringBuilder sb = new StringBuilder();
					sb.append(cusW);
					sb.deleteCharAt(cusW.length() - 1);
					cusW = sb.toString();
				}
			}
			else
			{
				if (cusW.length() < 4)
				{
					for (int i = 2; i <= 10; i++)
					{
						if (Util.checkKey(i))
						{
							int toAdd = i - 1;
							cusW += toAdd;
						}
					}
					if (Util.checkKey(Keyboard.KEY_0))
					{
						cusW += '0';
					}
				}
			}
		}

		if (onH)
		{
			if (Util.checkKey(Keyboard.KEY_BACK))
			{
				if (cusH.length() != 0)
				{
					StringBuilder sb = new StringBuilder();
					sb.append(cusH);
					sb.deleteCharAt(cusH.length() - 1);
					cusH = sb.toString();
				}
			}
			else
			{
				if (cusH.length() < 4)
				{
					for (int i = 2; i <= 10; i++)
					{
						if (Util.checkKey(i))
						{
							int toAdd = i - 1;
							cusH += toAdd;
						}
					}
					if (Util.checkKey(Keyboard.KEY_0))
					{
						cusH += '0';
					}
				}
			}
		}

		if (cusX.length() != 0)
		{
			customX = Integer.parseInt(cusX);
		}
		if (cusY.length() != 0)
		{
			customY = Integer.parseInt(cusY);
		}
		if (cusW.length() != 0)
		{
			customW = Integer.parseInt(cusW);
		}
		if (cusH.length() != 0)
		{
			customH = Integer.parseInt(cusH);
		}

		if (!Util.onHover(x, y, w, h) && !hidden)
		{
			cusX = String.valueOf(Mouse.getX());
			cusY = String.valueOf(Mouse.getY());
			if (Util.checkMouse(0) && !Util.onHover(x, y, w, h))
			{
				Util.addQuad(customX, customY, customW, customH);
			}
		}
		else if (hidden)
		{
			cusX = String.valueOf(Mouse.getX());
			cusY = String.valueOf(Mouse.getY());
			if (Util.checkMouse(0))
			{
				Util.addQuad(customX, customY, customW, customH);
			}
		}

		glColor4f(1, 1, 1, 0.7f);
		Util.quad(customX, customY, customW, customH);

		if (!hidden)
		{
			glColor3f(1, 0, 0);
			Util.quad(x, y, w, h);

			glColor3f(1, 1, 0);
			Util.quad(bx, by, bw, bh);

			glColor3f(1, 0, 0);
			if (onX)
			{
				Util.quad(xX - 5, xY - 5, cW + 10, cH + 10);
			}
			else if (onY)
			{
				Util.quad(yX - 5, yY - 5, cW + 10, cH + 10);
			}
			else if (onW)
			{
				Util.quad(wX - 5, wY - 5, cW + 10, cH + 10);
			}
			else if (onH)
			{
				Util.quad(hX - 5, hY - 5, cW + 10, cH + 10);
			}

			glColor3f(1, 1, 1);
			Util.quad(xX, xY, cW, cH);
			Util.quad(yX, yY, cW, cH);
			Util.quad(wX, wY, cW, cH);
			Util.quad(hX, hY, cW, cH);

			if (backHover)
			{
				glColor3f(1, 0, 0);
			}
			else
			{
				glColor3f(1, 0.502f, 0);
			}
			Util.quad(backX, backY, backW, backH);

			glColor3f(0, 0, 0);
			Util.drawString("X:", x + 25, y + h - 50);
			Util.drawString("Y:", xX + cW + 75, y + h - 50);
			Util.drawString("W:", x + 25, y + h - cH - 100);
			Util.drawString("H:", xX + cW + 75, y + h - cH - 100);
			Util.drawString("Back", backX + 80, backY + 20);
			Util.drawString(cusX, xX + 10, xY + 6);
			Util.drawString(cusY, yX + 10, yY + 6);
			Util.drawString(cusW, wX + 10, wY + 6);
			Util.drawString(cusH, hX + 10, hY + 6);

		}
	}


	static boolean showR = false;
	static float rX = 0, rY = 0;
	static int selected;
	static boolean edit = false;
	static void checkRClick()
	{
		float w = 100, h = 200;

		for (int i = 0; i < Main.objQuad.size(); i++)
		{
			if (Util.onRClick(Main.objQuad.get(i).x, Main.objQuad.get(i).y, Main.objQuad.get(i).w, Main.objQuad.get(i).h) && !Main.holding)
			{
				selected = i;
				if (Mouse.getY() < Main.height - h)
				{
					rX = Mouse.getX();
					rY = Mouse.getY();
				}
				else
				{
					rX = Mouse.getX();
					rY = Mouse.getY() - h;
				}

				showR = true;
			}
		}		

		if (showR)
		{
			//float closeY = rY, editY = rY + 25, colorY = 50, moveY = rY + 75, textY = rY + 100, collidingY = rY + 125, deleteY = rY + 175;
			float optY[] = {rY, rY + 25, rY + 50, rY + 75, rY + 100, rY + 125, rY + 150, rY + 175};
			float optH = 25;
			float markX = rX + 5, markY = -10, markWH = 10;

			for (int i = 0; i < optY.length; i++)
			{
				if (Util.onHover(rX, optY[i], w, optH))
				{
					markY = (float) (optY[i] + 7.5);
				}
			}

			if (Util.onClick(rX, optY[0], w, optH))
			{
				showR = false;
			}

			if (Util.onClick(rX, optY[1], w, optH))
			{
				initTempEdit();
				edit = true;
				showR = false;
			}

			if (Util.onClick(rX, optY[2], w, optH))
			{
				//color

			}

			if (Util.onClick(rX, optY[3], w, optH))
			{
				Main.holding = true;
				Main.objHeld = selected;
				showR = false;
			}

			if (Util.onClick(rX, optY[4], w, optH))
			{
				//text

			}

			if (Util.onClick(rX, optY[5], w, optH))
			{
				//colliding

			}

			if (Util.onClick(rX, optY[6], w, optH))
			{
				int t = 0;
				t = Main.objQuad.get(selected).w;
				Main.objQuad.get(selected).w = Main.objQuad.get(selected).h;
				Main.objQuad.get(selected).h = t;

			}

			if (Util.onClick(rX, optY[7], w, optH))
			{
				Util.deleteQuad(selected);
				showR = false;
			}






			glColor3f(0, 1, 1);
			Util.quad(rX, rY, w, h);

			for (int i = 25; i < 200; i += 25)
			{
				glColor3f(1, 0, 1);
				glBegin(GL_LINES);
				glVertex2f(rX, rY + i);
				glVertex2f(rX + w, rY + i);
				glEnd();	
			}




			glColor3f(1, 0, 0);
			Util.quad(markX, markY, markWH, markWH);


			glColor3f(0, 0, 0);
			Util.drawString("Close", rX + 25, 5 + optY[0]);
			Util.drawString("Edit", rX + 25, 5 + optY[1]);
			Util.drawString("Color", rX + 25,5 + optY[2]);
			Util.drawString("Move", rX + 25, 5 + optY[3]);
			Util.drawString("Text", rX + 25, 5 + optY[4]);
			Util.drawString("Colliding", rX + 25, 5 + optY[5]);
			Util.drawString("Rotate", rX + 25, 5 + optY[6]);
			Util.drawString("Delete", rX + 25, 5 + optY[7]);

			if (Util.checkMouse(0) && !Util.onHover(rX, rY, w, h))
			{
				showR = false;
			}

		}

	}

	static void initTempEdit()
	{
		tempX = String.valueOf(Main.objQuad.get(selected).x);
		tempY = String.valueOf(Main.objQuad.get(selected).y);
		tempW = String.valueOf(Main.objQuad.get(selected).w);
		tempH = String.valueOf(Main.objQuad.get(selected).h);
	}
	static String tempX, tempY, tempW, tempH;
	static void edit()
	{
		float w = 300, h = 250;
		float x = Main.width/2 - w/2, y = (Main.height/2) - (h/2);

		float bx = x + 10, by = y + 10, bw = w - 20, bh = h - 20;

		float backX = x + 50, backY = y + 25, backW = 200, backH = 50;
		boolean backHover = false;

		float cW = 50, cH = 25;

		float xX = x + 50, xY = y + h - 50;
		float yX = xX + cW + 100, yY = y + h - 50;
		float wX = x + 50, wY = y + h - cH - 100;
		float hX = wX + cW + 100, hY = y + h - cH - 100;

		if (!popHidden)
		{
			if (Util.onClick(backX, backY, backW, backH))
			{
				edit = false;
				backHover = true;
			}
			else if (Util.onHover(backX, backY, backW, backH))
			{
				backHover = true;
			}
			else
			{
				backHover = false;
			}


			if (Util.onClick(xX, xY, cW, cH))
			{
				onX = true;
				onY = false;
				onW = false;
				onH = false;
			}
			else if (Util.onClick(yX, yY, cW, cH))
			{
				onX = false;
				onY = true;
				onW = false;
				onH = false;
			}
			else if (Util.onClick(wX, wY, cW, cH))
			{
				onX = false;
				onY = false;
				onW = true;
				onH = false;
			}
			else if (Util.onClick(hX, hY, cW, cH))
			{
				onX = false;
				onY = false;
				onW = false;
				onH = true;
			}



			if (onX)
			{
				if (Util.checkKey(Keyboard.KEY_BACK))
				{
					if (tempX.length() != 0)
					{
						tempX = Util.backspace(tempX);
						/*StringBuilder sb = new StringBuilder();
						sb.append(tempX);
						sb.deleteCharAt(tempX.length() - 1);
						tempX = sb.toString();*/
						
					}
				}
				else
				{
					if (tempX.length() < 4)
					{
						for (int i = 2; i <= 10; i++)
						{
							if (Util.checkKey(i))
							{
								int toAdd = i - 1;
								tempX += toAdd;
							}
						}
						if (Util.checkKey(Keyboard.KEY_0))
						{
							tempX += '0';
						}
					}
				}
			}

			if (onY)
			{
				if (Util.checkKey(Keyboard.KEY_BACK))
				{
					if (tempY.length() != 0)
					{
						tempY = Util.backspace(tempY);
					}
				}
				else
				{
					if (tempY.length() < 4)
					{
						for (int i = 2; i <= 10; i++)
						{
							if (Util.checkKey(i))
							{
								int toAdd = i - 1;
								tempY += toAdd;
							}
						}
						if (Util.checkKey(Keyboard.KEY_0))
						{
							tempY += '0';
						}
					}
				}
			}

			if (onW)
			{
				if (Util.checkKey(Keyboard.KEY_BACK))
				{
					if (tempW.length() != 0)
					{
						tempW = Util.backspace(tempW);
					}
				}
				else
				{
					if (tempW.length() < 4)
					{
						for (int i = 2; i <= 10; i++)
						{
							if (Util.checkKey(i))
							{
								int toAdd = i - 1;
								tempW += toAdd;
							}
						}
						if (Util.checkKey(Keyboard.KEY_0))
						{
							tempW += '0';
						}
					}
				}
			}

			if (onH)
			{
				if (Util.checkKey(Keyboard.KEY_BACK))
				{
					if (tempH.length() != 0)
					{
						tempH = Util.backspace(tempH);
					}
				}
				else
				{
					if (tempH.length() < 4)
					{
						for (int i = 2; i <= 10; i++)
						{
							if (Util.checkKey(i))
							{
								int toAdd = i - 1;
								tempH += toAdd;
							}
						}
						if (Util.checkKey(Keyboard.KEY_0))
						{
							tempH += '0';
						}
					}
				}
			}

			glColor3f(1, 0, 0);
			Util.quad(x, y, w, h);

			glColor3f(1, 1, 0);
			Util.quad(bx, by, bw, bh);

			glColor3f(1, 0, 0);
			if (onX)
			{
				Util.quad(xX - 5, xY - 5, cW + 10, cH + 10);
			}
			else if (onY)
			{
				Util.quad(yX - 5, yY - 5, cW + 10, cH + 10);
			}
			else if (onW)
			{
				Util.quad(wX - 5, wY - 5, cW + 10, cH + 10);
			}
			else if (onH)
			{
				Util.quad(hX - 5, hY - 5, cW + 10, cH + 10);
			}

			glColor3f(1, 1, 1);
			Util.quad(xX, xY, cW, cH);
			Util.quad(yX, yY, cW, cH);
			Util.quad(wX, wY, cW, cH);
			Util.quad(hX, hY, cW, cH);

			if (backHover)
			{
				glColor3f(1, 0, 0);
			}
			else
			{
				glColor3f(1, 0.502f, 0);
			}
			Util.quad(backX, backY, backW, backH);

			glColor3f(0, 0, 0);
			Util.drawString("X:", x + 25, y + h - 50);
			Util.drawString("Y:", xX + cW + 75, y + h - 50);
			Util.drawString("W:", x + 25, y + h - cH - 100);
			Util.drawString("H:", xX + cW + 75, y + h - cH - 100);
			Util.drawString("Close", backX + 80, backY + 20);
			Util.drawString(tempX, xX + 10, xY + 6);
			Util.drawString(tempY, yX + 10, yY + 6);
			Util.drawString(tempW, wX + 10, wY + 6);
			Util.drawString(tempH, hX + 10, hY + 6);
		}
		if (tempX.length() != 0)
		{
			Main.objQuad.get(selected).x = Integer.parseInt(tempX);
		}
		if (tempY.length() != 0)
		{
			Main.objQuad.get(selected).y = Integer.parseInt(tempY);
		}
		if (tempW.length() != 0)
		{
			Main.objQuad.get(selected).w = Integer.parseInt(tempW);
		}
		if (tempH.length() != 0)
		{
			Main.objQuad.get(selected).h = Integer.parseInt(tempH);
		}

	}

	static void color()
	{
		float w = 300, h = 250;
		float x = Main.width/2 - w/2, y = (Main.height/2) - (h/2);

		float bx = x + 10, by = y + 10, bw = w - 20, bh = h - 20;

		float backX = x + 50, backY = y + 25, backW = 200, backH = 50;
		boolean backHover = false;
		
		float colorR[] = new float[255];
		float colorG[] = new float[255];
		float colorB[] = new float[255];
		
		for (int r = 0; r < 255; r++)
		{
			for (int g = 0; g < 255; g++)
			{
				for (int b = 0; b < 255; b++)
				{
					glBegin(GL_QUADS);
					glColor3f(colorR[r], 0, 0);
					glVertex2f(0, 0);
					glColor3f(0, colorG[g], 0);
					glVertex2f(0, 50);
					glColor3f(0, 0, colorB[b]);
					glVertex2f(50, 50);
					glColor3f(0, 0, 0);
					glVertex2f(50, 0);
					glEnd();
					
				}
			}
		}
		
		glColor3f(1, 0, 0);
		Util.quad(x, y, w, h);

		glColor3f(1, 1, 0);
		Util.quad(bx, by, bw, bh);
		
	}
	
	
	static boolean deletePrompt;
	static void deleteAll()
	{
		float w = 300, h = 200;
		float x = Main.width/2 - w/2, y = Main.height/2 - h/2;
		
		float bx = x + 10, by = y + 10, bw = w - 20, bh = h - 20;
		
		float buttY = y + 25, buttW = 100, buttH = 50;
		float yesX = x + 38, noX = yesX + buttW + 25;
		boolean yesHover = false, noHover = false;
		
		if (Util.onClick(yesX, buttY, buttW, buttH))
		{
			Util.deleteAllQuad();
			deletePrompt = false;
			yesHover = true;
		}
		else if (Util.onHover(yesX, buttY, buttW, buttH))
		{
			yesHover = true;
		}
		else
		{
			yesHover = false;
		}
		
		if (Util.onClick(noX, buttY, buttW, buttH))
		{
			deletePrompt = false;
			noHover = true;
		}
		else if (Util.onHover(noX, buttY, buttW, buttH))
		{
			noHover = true;
		}
		else
		{
			noHover = false;
		}
		
		
		glColor3f(1, 0, 0);
		Util.quad(x, y, w, h);
		
		glColor3f(1, 1, 0);
		Util.quad(bx, by, bw, bh);
		
		if (yesHover)
		{
			glColor3f(1, 0, 0);
		}
		else
		{
			glColor3f(1, 0.502f, 0);	
		}
		Util.quad(yesX, buttY, buttW, buttH);
		

		if (noHover)
		{
			glColor3f(1, 0, 0);
		}
		else
		{
			glColor3f(1, 0.502f, 0);
		}
		Util.quad(noX, buttY, buttW, buttH);
		
		glColor3f(0, 0, 0);
		Util.drawString("Yes", yesX + 35, buttY + 20);
		Util.drawString("No", noX + 38, buttY + 20);
		Util.drawString("Are you sure you want to", x + 30, y + h - 30);
		Util.drawString("delete everything?", x + 30, y + h - 48);
	}
}



