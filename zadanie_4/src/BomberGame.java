import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class BomberGame extends JPanel implements ActionListener {
    private List<Bomber> bombers;
    private List<Bomb> bombs;
    private List<Target> targets;
    private Timer timer;
    private Random random;

    public BomberGame() {
        this.setBackground(Color.WHITE);
        this.bombers = new ArrayList<>();
        this.bombs = new ArrayList<>();
        this.targets = new ArrayList<>();
        this.random = new Random();

        for (int i = 0; i < 60; i++){
            targets.add(new Target(1+ random.nextInt(40)*i,450,20));
        }

        bombers.add(new Bomber(0,100,1.5,random.nextInt(21)));
        bombers.add(new Bomber(0,250,1.0,random.nextInt(21)));
        bombers.add(new Bomber(0,150,2.0,random.nextInt(21)));

        timer = new Timer(16,this);
        timer.start();
    }

    public void refillBombers(){
        for (Bomber b: bombers){
            b.bombCount = random.nextInt(21);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(Color.GREEN);
        g2d.drawLine(0,470,getWidth(),470);

        g2d.setColor(Color.RED);
        for(Target t: targets){
            g2d.drawOval((int)t.x - t.radius,(int)t.y - t.radius,t.radius*2,t.radius*2);
        }

        g2d.setColor(Color.DARK_GRAY);
        for(Bomb b : bombs){
            g2d.fillOval((int)b.x - 3,(int)b.y - 3, 6,6);
        }

        for(Bomber b: bombers){
            g2d.setColor(Color.BLACK);
            g2d.drawRect((int)b.x,(int)b.y,(int)b.size,(int)b.size);
            g2d.drawString("Bombs: " + b.bombCount,(int)b.x + 50,(int)b.y + 25);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(Bomber b: bombers){
            b.x += b.speedX;

            if(b.bombCount > 0 && random.nextDouble() < 0.02){
                bombs.add(new Bomb(b.x + b.size/2, b.y + b.size, b.speedX * 0.5));
                b.bombCount--;
            }
        }

        for(Bomb b: bombs) {
            b.y += b.speedY;
            b.x += b.speedX;
        }
        repaint();
    }
}
