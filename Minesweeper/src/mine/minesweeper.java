package mine;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.applet.Applet;
import java.util.Timer; 
import java.util.TimerTask;
import java.awt.image.*;
import javax.imageio.ImageIO;



import java.io.*;



public class minesweeper extends Applet implements  MouseListener {
	Label time, score;
	Graphics myG;
	int numRight, numFlagged;
	Canvas c;
	//int[][] graphx, graphy;
	mineBlock[][] blocks;
	boolean first=true;
	int gx, gy;
	boolean run=true;



	public void init(){
		c= new Canvas();

		c.setBackground(Color.black);

		c.setSize(270,270);
		this.setSize(320, 350);
		blocks= new mineBlock[9][9];

		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		ge.getAllFonts();

	





		int r=0;
		int i=0;
		while(i<9){

			while(r<9){
				blocks[i][r]= new mineBlock();
				r++;
			}
			r=0;
			i++;
		}



		//graphx= new int[9][9];
		//graphy= new int[9][9];
		setPlaces();
		c.addMouseListener(this);

		add(c);
		try {
			Thread.sleep(100);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}

		repaint();
	}


	public void paint(Graphics g){

		c.setLocation(25, 75);
		myG=c.getGraphics();


		myG.setColor(Color.white);

		int q=0;
		int a=30;

		while(q<8){

			myG.drawLine(a, 0, a, 270);
			myG.drawLine(0, a, 270, a);
			a=a+30;
			q++;
		}


	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {

		if(run){

			if(first){
				selectBombSpots();
				getValueNearAll();
				first=false;
			}

			getBlockSpot(e);
			//showAllYouCan(gx, gy);

			repaint();
		}
	}

	public void showAllYouCan(int you, int me){

		int h=you;
		int f=me;

		if(!(blocks[h][f].mine)){
			if(h!=8){
				if((blocks[h+1][f].value>0)&&!(blocks[h+1][f].mine)){
					blocks[h+1][f].paintBlock(myG);
				}
				else{
					blocks[h+1][f].paintBlock(myG);
					showAllYouCan(blocks[h+1][f].ox, blocks[h+1][f].oy);
				}
			}
			if(f!=8){
				if(blocks[h][f+1].value>0){
					blocks[h][f+1].paintBlock(myG);
				}
				else{
					blocks[h][f+1].paintBlock(myG);
					showAllYouCan(blocks[h][f+1].ox, blocks[h][f+1].oy);
				}
			}
			if(h!=0){
				if(blocks[h-1][f].value>0){
					blocks[h-1][f].paintBlock(myG);
				}
				else{
					blocks[h-1][f].paintBlock(myG);
					showAllYouCan(blocks[h-1][f].ox, blocks[h-1][f].oy);
				}
			}
			if(f!=0){
				if(blocks[h][f-1].value>0){
					blocks[h][f-1].paintBlock(myG);
				}
				else{
					blocks[h][f-1].paintBlock(myG);
					showAllYouCan(blocks[h][f-1].ox, blocks[h][f-1].oy);
				}
			}
			if((h!=8&&f!=8)){
				if(blocks[h+1][f+1].value>0){
					blocks[h+1][f+1].paintBlock(myG);
				}
				else{
					blocks[h+1][f+1].paintBlock(myG);
					showAllYouCan(blocks[h+1][f+1].ox, blocks[h+1][f+1].oy);
				}
			}
			if(h!=0&&f!=8){
				if(blocks[h-1][f+1].value>0){
					blocks[h-1][f+1].paintBlock(myG);
				}
				else{
					blocks[h-1][f+1].paintBlock(myG);
					showAllYouCan(blocks[h-1][f+1].ox, blocks[h-1][f+1].oy);
				}
			}
			if(h!=8&&f!=0){
				if(blocks[h+1][f-1].value>0){
					blocks[h+1][f-1].paintBlock(myG);
				}
				else{
					blocks[h+1][f-1].paintBlock(myG);
					showAllYouCan(blocks[h+1][f-1].ox, blocks[h+1][f-1].oy);
				}
			}
			if(h!=0&&f!=0){
				if(blocks[h-1][f-1].value>0){
					blocks[h-1][f-1].paintBlock(myG);
				}
				else{
					blocks[h-1][f-1].paintBlock(myG);
					showAllYouCan(blocks[h-1][f-1].ox, blocks[h-1][f-1].oy);
				}
			}
			//System.out.println((h+1)+", "+(f+1)+": "+blocks[h][f].value);
		}


	}

	public void getValueNearAll(){

		int h=0;
		int f=0;
		while(h<9){

			while(f<9){
				if(!(blocks[h][f].mine)){
					if(h!=8){
						if(blocks[h+1][f].mine){
							blocks[h][f].value++;
						}
					}
					if(f!=8){
						if(blocks[h][f+1].mine){
							blocks[h][f].value++;
						}
					}
					if(h!=0){
						if(blocks[h-1][f].mine){
							blocks[h][f].value++;
						}
					}
					if(f!=0){
						if(blocks[h][f-1].mine){
							blocks[h][f].value++;
						}
					}
					if((h!=8&&f!=8)){
						if(blocks[h+1][f+1].mine){
							blocks[h][f].value++;
						}
					}
					if(h!=0&&f!=8){
						if(blocks[h-1][f+1].mine){
							blocks[h][f].value++;
						}
					}
					if(h!=8&&f!=0){
						if(blocks[h+1][f-1].mine){
							blocks[h][f].value++;
						}
					}
					if(h!=0&&f!=0){
						if(blocks[h-1][f-1].mine){
							blocks[h][f].value++;
						}
					}
					//System.out.println((h+1)+", "+(f+1)+": "+blocks[h][f].value);
				}
				f++;

			}
			f=0;
			h++;
		}	


	}


	public void selectBombSpots(){
		int w=0;
		while(w<10){
			int bx=(int)(Math.random()*9);
			int by=(int)(Math.random()*9);
			if(!(by==gy&&bx==gx)&&(!blocks[bx][by].mine)){
				blocks[bx][by].mine=true;
				blocks[bx][by].value=69;
				//System.out.println(w);
				//System.out.println((bx+1)+", "+(by+1));
				w++;
				//System.out.println(w+" bomb(s) made at "+bx+", "+by);
			}
		}
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void setPlaces(){
		int u=0;
		int l=0;

		while(u<9){

			while(l<9){
				blocks[l][u].x=l*30;
				blocks[l][u].y=u*30;
				blocks[l][u].ox=l;
				blocks[l][u].oy=u;
				//System.out.println(j+": "+blocks[j].x+", "+blocks[j].y);
				//blocks[j].y=graphy[l][u];
				l++;
			}
			l=0;
			u++;
		}

	}

	public void getBlockSpot(MouseEvent e){

		int uno=e.getX();
		int dos=e.getY();
		int o=0;
		int g=0;
		//System.out.println("event coordinates: "+uno+ ", "+dos);
		boolean notDone=true;
		while(o<9&&notDone){
			while(g<9){
				//System.out.println(blocks[o].x+ ", "+blocks[o].y);
				if((uno>=blocks[o][g].x&&uno<(blocks[o][g].x+30))&&(dos>=blocks[o][g].y&&dos<(blocks[o][g].y+30))){
					if(e.getButton()==1&&!blocks[o][g].flagged){
						if(!blocks[o][g].mine){
							numRight++;
							System.out.println("Number of blocks correct= "+numRight);
							System.out.println("Number of blocks left= "+(71-numRight));
							blocks[o][g].paintBlock(myG);
						}

						else{
							blocks[o][g].paintBlock(myG);
							run=false;
							Font ofont = new Font("8bitOperatorPlus-Bold", Font.ROMAN_BASELINE, 30);
							myG.setFont(ofont);
							myG.setColor(Color.green);
							myG.drawString("You Lose", 50, 100);
							
						}

					}
					gx=o;
					gy=g;
					//System.out.println(e.getButton());
					if(e.getButton()==3){
						boolean guard=true;
						//System.out.println("found it");
						if(blocks[o][g].flagged){
							blocks[o][g].deflag(myG);
							numFlagged--;
							//System.out.println(2);
							guard=false;
						}
						if(!blocks[o][g].flagged&&numFlagged<10&&guard){
							blocks[o][g].flag(myG);
							numFlagged++;
							//System.out.println(1);
						}

					}
					notDone=false;


				}
				g++;
			}
			g=0;
			o++;
		}


	}





}





class mineBlock{


	int x,ox;
	int y, oy;
	int value;
	boolean uncovered=false;
	boolean mine=false;
	boolean flagged=false;
	int width=30;
	int height=30;



	public mineBlock(){

	}

	public void paintBlock(Graphics aG){
		if(mine){
			aG.setColor(Color.red);
		}
		else{
			aG.setColor(Color.gray);
		}
		aG.fillRect(x, y, width, height);
		uncovered=true;
		if(value>0){
			drawValue(aG);
		}
	}

	public void drawValue(Graphics aG){

		if(value==1){
			aG.setColor(Color.blue);
		}
		if(value==2){
			aG.setColor(Color.green);
		}
		if(value==3){
			aG.setColor(Color.red);
		}
		if(value==4){
			aG.setColor(Color.cyan);
		}
		if(value==5){
			aG.setColor(Color.magenta);
		}
		aG.drawString(String.valueOf(value), x+5, y+25);
		//System.out.println("should");
	}

	public void flag(Graphics aG){
		flagged=true;
		aG.setColor(Color.GREEN);

		aG.drawLine(x, y, x+width, y+height);
		aG.drawLine(x+width, y, x, y+height);
	}

	public void deflag(Graphics aG){
		flagged=false;
		aG.setColor(Color.black);

		aG.fillRect(x, y, width, height);

	}


}







