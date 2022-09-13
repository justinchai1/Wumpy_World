
/*JUstin Chai
Mr.Tully
Period 2
 */public class WumpusPlayer
{
    public  static  final int NORTH=0;
    public  static  final int EAST=1;
    public  static  final int SOUTH=2;
    public  static  final int WEST=3;
    public int direction;
    public boolean arrow;
    public boolean  gold;
    public int colPosition;
    public int rowPosition;
    public WumpusPlayer()
    {
        direction=0;
        gold=false;
        arrow=true;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public boolean getArrow() {
        return arrow;
    }

    public void setArrow(boolean arrow) {
        this.arrow = arrow;
    }

    public boolean getGold() {
        return gold;
    }

    public void setGold(boolean gold) {
        this.gold = gold;
    }

    public int getColPosition() {
        return colPosition;
    }

    public void setColPosition(int colPosition) {
        this.colPosition = colPosition;
    }

    public int getRowPosition() {
        return rowPosition;
    }

    public void setRowPosition(int rowPosition) {
        this.rowPosition = rowPosition;
    }
}
