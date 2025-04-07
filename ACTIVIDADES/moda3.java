public int moda3(int[] array) {
    Limits p = new Limits(array, 0, array.length - 1);
    SetVectors homog = new SetVectors();
    SetVectors heterog = new SetVectors();
    heterog.insertar(p);

    while (heterog.longMayor() > homog.longMayor()) {
        p = heterog.mayor();
        int median = p.getMedian();

        int[] izq = new int[1];
        int[] der = new int[1];
        pivote2(p.array, median, p.start, p.end, izq, der);

        Limits p1 = new Limits(array, p.start, izq[0] - 1);
        Limits p2 = new Limits(array, izq[0], der[0] - 1);
        Limits p3 = new Limits(array, der[0], p.end);

        if (p1.start <= p1.end) heterog.insertar(p1);
        if (p3.start <= p3.end) heterog.insertar(p3);
        if (p2.start <= p2.end) homog.insertar(p2);
    }

    if (homog.estaVacio()) return array[0];
    Limits result = homog.mayor();
    return result.array[result.start];
}
