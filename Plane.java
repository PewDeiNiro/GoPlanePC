import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Plane here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plane extends SmoothMover
{
    private final double MAX_SPEED = 4.5;
    private final double ACCELERATION = 0.2;
    private String vector = "W";
    private double speed = 0.0;
    private double x, y;
    public void act() 
    {
        keyBoardControl();
    }    
    
    public Plane(double x, double y, String url){
        setLocation(x, y);
        setImage(url);
        this.x = x;
        this.y = y;
    }
    
    public void keyBoardControl(){
        if (isW() && isA()){
            x = x - (speed / 1.5);
            y = y - (speed / 1.5);
            speed = Math.min(MAX_SPEED, (speed + ACCELERATION));
            setImage("images/planeWA.png");
        }
        else if (isW() && isD()){
            x = x + (speed / 1.5);
            y = y - (speed / 1.5);
            speed = Math.min(MAX_SPEED, (speed + ACCELERATION));
            setImage("images/planeWD.png");
        }
        else if (isS() && isA()){
            x = x - (speed / 1.5);
            y = y + (speed / 1.5);
            speed = Math.min(MAX_SPEED, (speed + ACCELERATION));
            setImage("images/planeSA.png");
        }
        else if (isS() && isD()){
            x = x + (speed / 1.5);
            y = y + (speed / 1.5);
            speed = Math.min(MAX_SPEED, (speed + ACCELERATION));
            setImage("images/planeSD.png");
        }
        else if (isW()){
            y -= speed;
            speed = Math.min(MAX_SPEED, (speed + ACCELERATION));
            setImage("images/planeW.png");
        }
        else if (isS()){
            y += speed;
            speed = Math.min(MAX_SPEED, (speed + ACCELERATION));
            setImage("images/planeS.png");
        }
        else if (isA()){
            x = x - speed;
            speed = Math.min(MAX_SPEED, (speed + ACCELERATION));
            setImage("images/planeA.png");
        }
        else if (isD()){
            x = x + speed;
            speed = Math.min(MAX_SPEED, (speed + ACCELERATION));
            setImage("images/planeD.png");
        }
        else{
            speed = Math.max(0, (speed - ACCELERATION));
        }
        setLocation(x, y);
    }
    
    public boolean isW(){
        return Greenfoot.isKeyDown("W") || Greenfoot.isKeyDown("Ц") || Greenfoot.isKeyDown("up") ? true : false;
    }
    
    public boolean isS(){
        return Greenfoot.isKeyDown("S") || Greenfoot.isKeyDown("Ы") || Greenfoot.isKeyDown("down") ? true : false;
    }
    
    public boolean isA(){
        return Greenfoot.isKeyDown("A") || Greenfoot.isKeyDown("Ф") || Greenfoot.isKeyDown("left") ? true : false;
    }
    
    public boolean isD(){
        return Greenfoot.isKeyDown("D") || Greenfoot.isKeyDown("В") || Greenfoot.isKeyDown("right") ? true : false;
    }
}
