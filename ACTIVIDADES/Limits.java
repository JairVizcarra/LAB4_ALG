class Limits {
    int start, end;
    int[] array;

    Limits(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    int length() {
        return end - start + 1;
    }

    int getMedian() {
        return array[(start + end) / 2];
    }
}
