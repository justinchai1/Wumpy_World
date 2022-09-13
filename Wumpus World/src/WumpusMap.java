/*JUstin Chai
Mr.Tully
Period 2
 */

public class WumpusMap
{
    public static final int NUM_ROWS=10;
    public static final int NUM_COLUMNS=10;
    public static final int NUM_PITS=10;
    private WumpusSquare[][] grid=new WumpusSquare[NUM_ROWS][NUM_COLUMNS];
    private int ladderC;
    private int ladderR;
    private int goldC;
    private int goldR;
private int wumpusCol;
private int wumpusRow;

    public WumpusMap()
    {
        createMap();

    }
public void createMap() {
    for (int a = 0; a < 10; a++) {
        for (int s = 0; s < 10; s++) {
            grid[a][s] = new WumpusSquare();
        }
    }
   WumpusPlayer player=new WumpusPlayer();
//FOR THE PITS OF DOOM
    int x = 0;
    int y = 0;
    for (int k = 0; k < NUM_PITS; k++) {
        do {
            x = (int) (Math.random() * NUM_COLUMNS);
            y = (int) (Math.random() * NUM_ROWS);

        } while (grid[x][y].isPit());
        grid[x][y].setPit(true);
    }

//FOR THE BREEZE
   /*     if (grid[x][y].isPit() && x + 1 < 10)
            grid[x + 1][y].setBreeze(true);
        else if (grid[x][y].isPit() && x - 1 >= 0)
            grid[x - 1][y].setBreeze(true);
        else if (grid[x][y].isPit() && y + 1 < 10)
            grid[x][y + 1].setBreeze(true);
        else if (grid[x][y].isPit() && y - 1 >= 0)
            grid[x][y - 1].setBreeze(true);*/
    //FOR THE WUMPUS
    int o = 0;
    int p = 0;

    do {
        o = (int) (Math.random() * NUM_COLUMNS);
        p = (int) (Math.random() * NUM_ROWS);
    } while (grid[o][p].isPit());
    grid[p][o].setWumpus(true);

    //FOR THE STENCH

    if (grid[o][p].isWumpus() && grid[o+1][p].isPit()==false && o + 1 < 10)
        grid[o + 1][p].setStench(true);
    else if (grid[o][p].isWumpus() && grid[o-1][p].isPit()==false&&o - 1 >= 0)
        grid[o - 1][p].setStench(true);
    else if (grid[o][p].isWumpus() && grid[o][p+1].isPit()==false&&p + 1 < 10)
        grid[o][p + 1].setStench(true);
    else if (grid[o][p].isWumpus() && grid[o][p-1].isPit()==false&&p - 1 >= 0)
        grid[o][p - 1].setStench(true);
    /*for(int a=0;a< NUM_COLUMNS;a++)
    {
        for(int b=0;b<NUM_ROWS;b++)
        {
            if(grid[a+1][b].isPit()==true &&a+1<10)
                grid[a+1][b].setStench(false);
            if(grid[a-1][b].isPit()==true&&a-1>-1)
                grid[a-1][b].setStench(false);
            if(grid[a][b+1].isPit()==true&&b+1<10)
                grid[a][b+1].setStench(false);
            if(grid[a][b-1].isPit()==true&&b-1>-1)
                grid[a][b-1].setStench(false);
        }
    }*/


    int l = 0;
    int d = 0;
    do {
        l = (int) (Math.random() * NUM_COLUMNS);
        d = (int) (Math.random() * NUM_ROWS);
    } while (grid[d][l].isPit());
    grid[l][d].setGold(true);

    int e = 0;
    int r = 0;

    do {
        e = (int) (Math.random() * NUM_COLUMNS);
        r = (int) (Math.random() * NUM_ROWS);
    } while (grid[e][r].isPit() || grid[r][e].isGold() || grid[r][e].isWumpus());


    grid[r][e].setLadder(true);
    grid[r][e].setVisited(true);
wumpusCol=o;
wumpusRow=p;
    ladderC = e;
    ladderR = r;
    for (x = 0; x < 10; x++) {
        for (y = 0; y < 10; y++) {
            if (grid[y][x].isPit() == true) {
                if ( y < 9 &&grid[y + 1][x].isPit() == false )
                    grid[y + 1][x].setBreeze(true);
                if ( y > 0&&grid[y - 1][x].isPit() == false )
                    grid[y - 1][x].setBreeze(true);
                if ( x < 9&&grid[y][x + 1].isPit() == false )
                    grid[y][x + 1].setBreeze(true);
                if ( x > 0&&grid[y][x - 1].isPit() == false )
                    grid[y][x - 1].setBreeze(true);

            }
            if (grid[y][x].isWumpus() == true) {
                if ( y < 9&&grid[y + 1][x].isWumpus()== false  )
                    grid[y + 1][x].setStench(true);
                if ( y > 0&&grid[y - 1][x].isWumpus() == false  )
                    grid[y - 1][x].setStench(true);
                if ( x < 9&&grid[y][x + 1].isWumpus() == false  )
                    grid[y][x + 1].setStench(true);
                if (  x > 0&&grid[y][x - 1].isWumpus() == false)
                    grid[y][x - 1].setStench(true);
            }
        }
    }


}

    public static int getNumRows() {
        return NUM_ROWS;
    }

    public int getWumpusCol() {
        return wumpusCol;
    }

    public int getWumpusRow() {
        return wumpusRow;
    }

    public WumpusSquare[][] getGrid() {
        return grid;
    }

    public int getGoldC() {
    return goldC;
}

    public int getGoldR() {
        return goldR;
    }

    public int getLadderCol() {
        return ladderC;
    }

    public int getLadderRow() {
        return ladderR;
    }

    public WumpusSquare getSquare(int col, int row)
    {
if(col<=9 && row<=9)

{
    return grid[row][col];
}
else
    return null;
    }
    public String toString()
    {
String bob= " ";
for(int y=0; y<10; y++)
{
    bob+="\n";
    for(int x=0; x<10; x++)
    {

        bob+= grid[x][y].toString();
    }
}
return bob;
    }
}
