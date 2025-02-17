package RandomPosition.member;

public enum Position {
    First(4),
    Second(8),
    Third(4);

    private final int capacity;

    Position(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isExceeding(int currentCount) {
        return currentCount > this.capacity;
    }
}
