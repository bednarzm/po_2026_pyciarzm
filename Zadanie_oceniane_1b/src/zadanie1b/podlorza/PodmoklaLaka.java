package zadanie1b.podlorza;

public class PodmoklaLaka extends PodlorzeZDotacją {

    public PodmoklaLaka() {
        this.temperatura = random.nextInt(0, 24);
        this.dotacje = random.nextBoolean();
    }

    @Override
    public double getUpCurrent() {
        return this.temperatura/10 - random.nextInt(1,5);
    }
}
