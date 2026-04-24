public interface Engine {
    void increase();
    void decrease();
    void setSpeed(int speed);
    int getSpeed();

    default String getActiveEngineName() {
        return null;
    }
}
