import java.util.PriorityQueue;

class SetVectors {
    PriorityQueue<Limits> set;

    SetVectors() {
        set = new PriorityQueue<>((a, b) -> Integer.compare(b.length(), a.length()));
    }

    void insertar(Limits p) {
        set.add(p);
    }

    Limits mayor() {
        return set.poll(); 
    }

    int longMayor() {
        if (set.isEmpty()) return 0;
        return set.peek().length();
    }

    boolean estaVacio() {
        return set.isEmpty();
    }

    void destruir() {
        set.clear();
    }
}
