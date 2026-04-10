package zadanie1b;
import zadanie1b.podlorza.*;

import java.util.Random;

public class Teren {
    private Podlorze[][] podloze;
    private Random random = new Random();
    private int width;
    private int height;

    public Teren(int width, int height) {
        if (width < 10){
            width = 10;
        } else if (width > 100) {
            width = 100;
        }

        if (height < 10){
            height = 10;
        } else if (width > 100) {
            height = 100;
        }
        this.width = width;
        this.height = height;
        this.podloze = new Podlorze[height][width];

        initPodloze();
    }

    private void initPodloze(){
        for (int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++){
                int choice = random.nextInt(6);
                this.podloze[i][j] = switch (choice) {
                    case 0 -> new GlebaKamienista();
                    case 1 -> new GlebaNiekamienista();
                    case 2 -> new PodmoklaLaka();
                    case 3 -> new Piasek();
                    case 4 -> new GlebaPylasta();
                    default -> new TerenWodny();
                };
            }
        }
    }

    private void modifyAtmosphere(){
        for(int i = 0; i<this.height; i++){
            for(int j = 0; j<this.width; j++){
                podloze[i][j].modifyTemperature(random.nextInt(-2, 4));
            }
        }
    }

    public boolean isInside(int x, int y) {
        boolean inside = y >= 0 && y < this.height && x >= 0 && x < this.width;
        if (!inside) {
            System.out.println("Wyjście poza strefę");
        }
        return inside;
    }

    public Podlorze getPole(int x,int y) {
        return podloze[x][y];
    }
}
