public class WumpusSquare {
    private boolean ladder;
    private boolean gold;
    private boolean pit;
    private boolean breeze;
    private boolean wumpus;
    private boolean deadWumpus;
    private boolean stench;
    private boolean visited;
    public WumpusSquare()
    {
        ladder=false;
        gold=false;
        pit=false;
        wumpus=false;
        deadWumpus=false;
        stench=false;
        visited=false;
        breeze=false;

    }

    public boolean isLadder() {
        return ladder;
    }

    public void setLadder(boolean ladder) {
        this.ladder = ladder;
    }

    public boolean isGold() {
        return gold;
    }

    public void setGold(boolean gold) {
        this.gold = gold;
    }

    public boolean isPit() {
        return pit;
    }

    public void setPit(boolean pit) {
        this.pit = pit;
    }

    public boolean isBreeze() {
        return breeze;
    }

    public void setBreeze(boolean breeze) {
        this.breeze = breeze;
    }

    public boolean isWumpus() {
        return wumpus;
    }

    public void setWumpus(boolean wumpus) {
        this.wumpus = wumpus;
    }

    public boolean isDeadWumpus() {
        return deadWumpus;
    }

    public void setDeadWumpus(boolean deadWumpus) {
        this.deadWumpus = deadWumpus;
    }

    public boolean isStench() {
        return stench;
    }

    public void setStench(boolean stench) {
        this.stench = stench;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    public String toString()
    {
        if(ladder)
            return "L";
        else if(wumpus)
            return "W";
        else if(deadWumpus)
            return "D";
        else if(pit)
            return "P";
        else if(gold)
            return "G";
        else
            return "*";
    }
}
