public class HybridEngine implements Engine {
    private ElectronicEngine electric = new ElectronicEngine();
    private GasolineEngine gas = new GasolineEngine();
    private int engineSpeed = 0;

    @Override
    public void increase() {
        if (engineSpeed < 50) {
            electric.increase();
            engineSpeed = electric.getSpeed();
            gas.setSpeed(0);
        } else {
            gas.increase();
            engineSpeed = gas.getSpeed();
            electric.setSpeed(0);
        }
    }

    @Override
    public void decrease() {
        if (engineSpeed <= 50) {
            electric.decrease();
            engineSpeed = electric.getSpeed();
        } else {
            gas.decrease();
            engineSpeed = gas.getSpeed();
        }
    }

    @Override
    public void setSpeed(int speed) {
        this.engineSpeed = speed;
        if (speed < 50) {
            electric.setSpeed(speed);
            gas.setSpeed(0);
        } else {
            gas.setSpeed(speed);
            electric.setSpeed(0);
        }
    }

    @Override
    public int getSpeed() {
        return engineSpeed;
    }

    public String getActiveEngine() {
        if (engineSpeed < 50) {
            return "Electric";
        } else {
            return "Gasoline";
        }
    }

    @Override
    public String getActiveEngineName() {
        return getActiveEngine();
    }
}
