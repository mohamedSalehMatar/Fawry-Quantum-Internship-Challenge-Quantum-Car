public class GasolineEngine implements Engine {
    private int engineSpeed = 0;

    @Override
    public void increase() {
        engineSpeed++;
    }

    @Override
    public void decrease() {
        if (engineSpeed > 0) engineSpeed--;
    }

    @Override
    public void setSpeed(int speed) {
        this.engineSpeed = speed;
    }

    @Override
    public int getSpeed() {
        return engineSpeed;
    }
}
