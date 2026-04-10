package zadanie1b.podlorza;

public class TerenWodny extends PodlorzeZDotacją {

    public TerenWodny() {
        this.temperatura = random.nextInt(0, 24);
        this.dotacje = random.nextBoolean();
    }

    @Override
    public double getUpCurrent() {
        return this.temperatura/10 - random.nextInt();
    }
}
