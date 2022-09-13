/*JUstin Chai
Mr.Tully
Period 2
 */
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.ArrayList;


public class WumpusPanel extends JPanel implements KeyListener
{
    public static final int PLAYING=0;
    public static final int DEAD=1;
    public static final int WON=2;
    public int status;
    public WumpusPlayer player;
    public WumpusMap map;
    private BufferedImage floor;
    private BufferedImage arrow;
    private BufferedImage fog;
    private BufferedImage gold;
    private BufferedImage ladder;
    private BufferedImage pit;
    private BufferedImage breeze;
    private BufferedImage wumpus;
    private BufferedImage deadWumpus;
    private BufferedImage stench;
    private BufferedImage playerUp;
    private BufferedImage playerDown;
    private BufferedImage playerLeft;
    private BufferedImage playerRight;
private boolean checked;
 private ArrayList <String> messages = new ArrayList<String>();

    public WumpusPanel ()
    {


        super();
        try
        {
            floor = ImageIO.read((new File("Wumpus World Images\\Floor.gif ")));
            arrow = ImageIO.read((new File("Wumpus World Images\\arrow.gif")));
            breeze = ImageIO.read((new File("Wumpus World Images\\breeze.gif ")));
            deadWumpus = ImageIO.read((new File("Wumpus World Images\\deadWumpus.GIF")));
            gold = ImageIO.read((new File("Wumpus World Images\\gold.gif ")));
            ladder = ImageIO.read((new File("Wumpus World Images\\ladder.gif")));
            pit = ImageIO.read((new File("Wumpus World Images\\pit.gif")));
            playerDown = ImageIO.read((new File("Wumpus World Images\\playerDown.png")));
            playerLeft = ImageIO.read((new File("Wumpus World Images\\playerLeft.png")));
            playerRight = ImageIO.read((new File("Wumpus World Images\\playerRight.png")));
            playerUp = ImageIO.read((new File("Wumpus World Images\\playerUp.png")));
            stench = ImageIO.read((new File("Wumpus World Images\\stench.gif ")));
            wumpus = ImageIO.read((new File("Wumpus World Images\\wumpus.gif")));

        }
        catch(Exception e)
        {
            System.out.println("Error Loading Images: " + e.getMessage());
            e.printStackTrace();
        }
        setSize(800,800); // width,height
        addKeyListener(this);
        reset();
    }
    public void reset() {
        status=PLAYING;
         map= new WumpusMap();
        player=new WumpusPlayer();
        player.setColPosition(map.getLadderCol());
        player.setRowPosition(map.getLadderRow());
        checked=false;
    }
    public void paint(Graphics g)
    {

        //messages.add("You smeel a stench.");
        //messages.add("You see a glimmer.");
        //messages.add("You bump into a ladder.");
        //messages.add("You feel down a pit to your death.");
        //messages.add("You are eaten by the Wumpus.");
        //messages.add("You hear a scream.");
            //messages.add("You feel a breeze.");


        g.setColor(Color.GRAY);
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(Color.BLACK);
        //g.fillRect(75,25,600,600);
g.fillRect(0,650,200, 150);
        g.fillRect(220,650,600, 150);
        Font f = new Font("Times New Roman",  Font.BOLD, 32);
        g.setFont(f);
        g.setColor(Color.BLUE);
        g.drawString("Inventory:",20,675);
        g.drawString("Messages:",  250, 675 );
        //if()



System.out.println(map.toString());
//
for(int t=0; t<WumpusMap.NUM_ROWS;t++)
{
    for(int u=0;u<WumpusMap.NUM_COLUMNS;u++)
    {
        g.drawImage(floor,(t*50)+150,(u*50)+100, null);
    }
}WumpusSquare[][] grid=map.getGrid();
for(int hi=0;hi<WumpusMap.NUM_COLUMNS;hi++)
        {
            for( int po=0;po<WumpusMap.NUM_ROWS;po++)
            {

if(grid[hi][po].isGold())
    g.drawImage(gold,po*50+150,hi *50+100,null);

                if(grid[hi][po].isStench())
                    g.drawImage(stench,po*50+150,hi *50+100,null);
                if(grid[hi][po].isPit())
                    g.drawImage(pit,hi*50+150,po*50+100,null);
                if(grid[hi][po].isBreeze())
                    g.drawImage(breeze,hi*50+150,po*50+100,null);

            }
        }

        System.out.print(map.getSquare(map.getWumpusCol(),map.getWumpusRow()).isWumpus());
        if(map.getSquare(map.getWumpusCol(),map.getWumpusRow()).isWumpus())
            g.drawImage(wumpus,(50*map.getWumpusCol())+150, (50*map.getWumpusRow())+100,null);
        g.drawImage(ladder, (50*map.getLadderCol())+150,(50*map.getLadderRow())+100,null);
if(map.getSquare(map.getWumpusCol(),map.getWumpusRow()).isDeadWumpus()==true)
g.drawImage(deadWumpus, (50*map.getWumpusCol())+150, (50*map.getWumpusRow())+100,null);
        if(player.getDirection()==WumpusPlayer.SOUTH)
        g.drawImage(playerDown, (50*player.getColPosition())+150,(50*player.getRowPosition())+100,null);
        if(player.getDirection()==WumpusPlayer.NORTH)
            g.drawImage(playerUp, (50*player.getColPosition())+150,(50*player.getRowPosition())+100,null);
        if(player.getDirection()==WumpusPlayer.EAST)
            g.drawImage(playerRight, (50*player.getColPosition())+150,(50*player.getRowPosition())+100,null);
        if(player.getDirection()==WumpusPlayer.WEST)
            g.drawImage(playerLeft, (50*player.getColPosition())+150,(50*player.getRowPosition())+100,null);
if(player.getArrow()==true)
        g.drawImage(arrow, 25, 700, null);
if(player.getGold()==true)
    g.drawImage(gold,100,700,null);
        System.out.print(status);


        if(player.getRowPosition()==map.getLadderRow() && player.getColPosition()==map.getLadderCol())
            messages.add("You bump into the ladder");
        else if( map.getSquare(player.getColPosition(), player.getRowPosition()).isGold()==true)
            messages.add("You see a glimmer");
        else if (map.getSquare(player.getColPosition(), player.getRowPosition()).isStench()==true ||map.getSquare(player.getColPosition(), player.getRowPosition()).isDeadWumpus()==true)
            messages.add("You smell a stench");
else if(map.getSquare(player.getColPosition(), player.getRowPosition()).isBreeze()==true)
    messages.add("You feel a breeze");
        for(int qwer=0;qwer<messages.size();qwer++)
        {
            System.out.println(messages);
            g.drawString(messages.get(qwer),250,700);
            if(messages.size()==2)
                g.drawString(messages.get(1),250,725);
            if(messages.size()==3)
                g.drawString(messages.get(2),250,750);

            messages.clear();
        }

for(int x=0;x<WumpusMap.NUM_COLUMNS;x++)
{
    for(int y=0;y<WumpusMap.NUM_ROWS;y++)

    {
        if(map.getSquare(x,y).isVisited()==false&&checked==false)
        {
            g.setColor(Color.BLACK);
            g.fillRect((50*x)+150,(50*y)+100,50,50);

        }
    }
}





    }
    public void mousePressed(MouseEvent e)
    {

    }
    public void mouseClicked(MouseEvent e)
    {

    }
    public void mouseReleased(MouseEvent e)
    {
    }
    public void mouseEntered(MouseEvent e)
    {
    }
    public void mouseExited(MouseEvent e)
    {
    }
    public void keyPressed(KeyEvent e)
    {

    }
    public void keyReleased(KeyEvent e)
    {
    }
    public void keyTyped(KeyEvent e) {

        char bob = e.getKeyChar();
        if(status==PLAYING)
        {
        if (player.getRowPosition()!=0&&bob == 'w') {
            player.setRowPosition(player.getRowPosition() - 1);
            player.setDirection(WumpusPlayer.NORTH) ;
            map.getSquare(player.getColPosition(),player.getRowPosition()).setVisited(true);

        }
        else if (player.getColPosition()!=9&&bob == 'd') {
            player.setColPosition(player.getColPosition() + 1);
            player.setDirection(WumpusPlayer.EAST);
            map.getSquare(player.getColPosition(),player.getRowPosition()).setVisited(true);
        }
        else if (player.getColPosition()!=0&&bob == 'a') {
            player.setColPosition(player.getColPosition() - 1);
            player.setDirection(WumpusPlayer.WEST) ;
            map.getSquare(player.getColPosition(),player.getRowPosition()).setVisited(true);
        }
        else if (player.getRowPosition()!=9&&bob == 's') {
            player.setRowPosition(player.getRowPosition() + 1);
            player.setDirection(WumpusPlayer.SOUTH) ;
            map.getSquare(player.getColPosition(),player.getRowPosition()).setVisited(true);
        }
        else if(player.getArrow()&&bob=='i')
        {
            if(map.getWumpusRow() < player.getRowPosition() &&map.getWumpusCol()==player.getColPosition()) {
                map.getSquare(map.getWumpusCol(), map.getWumpusRow()).setWumpus(false);
                map.getSquare(map.getWumpusCol(), map.getWumpusRow()).setDeadWumpus(true);
messages.add("You hear a scream.");
            }
            /***************************for(int y=player.getRowPosition();y>=0;y--)
            {
                if(map.getSquare(player.getColPosition(),y).isWumpus())
                {
                    map.getSquare(player.getColPosition(),y).setWumpus(false);
                    map.getSquare(player.getColPosition(),y).setDeadWumpus(true);
                }
            }

        }**************************************************/player.setDirection(WumpusPlayer.NORTH);
            player.setArrow(false);
        }
        else if(player.getArrow()&&bob=='l')
        {
            if(map.getWumpusCol() > player.getColPosition() &&map.getWumpusRow()==player.getRowPosition()) {
                map.getSquare(map.getWumpusCol(), map.getWumpusRow()).setWumpus(false);
                map.getSquare(map.getWumpusCol(), map.getWumpusRow()).setDeadWumpus(true);
                messages.add("You hear a scream.");

            }
           /************************ for(int y=player.getColPosition();y<10;y++)
            {
                if(map.getSquare(y,player.getRowPosition()).isWumpus())
                {
                    map.getSquare(y,player.getRowPosition()).setWumpus(false);
                    map.getSquare(y,player.getRowPosition()).setDeadWumpus(true);
                }
            }**********************/
            player.setDirection(WumpusPlayer.EAST);
            player.setArrow(false);
        }
        else if(player.getArrow()&&bob=='k')
        {
            if(map.getWumpusRow() > player.getRowPosition() &&map.getWumpusCol()==player.getColPosition()) {
                map.getSquare(map.getWumpusCol(), map.getWumpusRow()).setWumpus(false);
                map.getSquare(map.getWumpusCol(), map.getWumpusRow()).setDeadWumpus(true);
                messages.add("You hear a scream.");

            }
            player.setDirection(WumpusPlayer.SOUTH);
            player.setArrow(false);
        }



        else if(player.getArrow()&&bob=='j')
        {
            if(map.getWumpusCol() < player.getColPosition() &&map.getWumpusRow()==player.getRowPosition()) {
                map.getSquare(map.getWumpusCol(), map.getWumpusRow()).setWumpus(false);
                map.getSquare(map.getWumpusCol(), map.getWumpusRow()).setDeadWumpus(true);
                messages.add("You hear a scream.");

            }player.setDirection(WumpusPlayer.WEST);
            player.setArrow(false);
        }

        else if(bob=='*')
        {
                    if(checked==true)
                    {

                        checked=false;
                    }
                         else if(checked==false)
                    {

                        checked=true;
                    }



                }

        else if(player.getGold() && player.getColPosition()==map.getLadderCol() && player.getRowPosition() == map.getLadderRow() && bob=='c') {
            status = WON;
            messages.add("You have won the game!");
        }
        else if(map.getSquare(player.getColPosition(),player.getRowPosition()).isGold() && bob=='p') {
            map.getSquare(player.getColPosition(), player.getRowPosition()).setGold(false);
            player.setGold(true);

        }
        for(int q=0;q<10;q++) {
            for (int w = 0; w < 10; w++) {
                if ((player.getRowPosition()==map.getWumpusRow() && player.getColPosition()==map.getWumpusCol() &&  map.getSquare(map.getWumpusCol(), map.getWumpusRow()).isWumpus()==true)  )
                {
                    messages.add("You are eaten by the Wumpus");
                    status = DEAD;


                }
                else if((map.getSquare(q, w).isPit()  && player.getRowPosition() == q && player.getColPosition() == w))
                {
                    messages.add("You fell down a pit to your death");
                    status= DEAD;

                }



            }
        }
            //(map.getSquare(q, w).isWumpus() ||map.getSquare(q, w).isPit() ) && player.getRowPosition() == q && player.getColPosition() == w


        }
         if(bob =='n')
            reset();



        repaint();
    }
    public void addNotify()
    {
        // call super so the method still does what it was built to do
        super.addNotify();

        // requests focus so that key inputs are sent to this screen
        requestFocus();
    }

}
