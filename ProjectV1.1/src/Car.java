public class Car {
    private int x;
    private int y;
    private static int speed = 1;
    private boolean isMoving;

    Car () {
        this.x = 0;
        this.y = 0;  
    }

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
