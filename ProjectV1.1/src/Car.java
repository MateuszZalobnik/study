public class Car {
    private int x;
    private int y;
    private static int speed = 1;
    private boolean isMoving;

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getPositionX(){
        return this.x;
    }
    public int getPositionY(){
        return this.y;
    }
}   
