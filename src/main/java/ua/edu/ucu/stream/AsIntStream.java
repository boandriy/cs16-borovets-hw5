package ua.edu.ucu.stream;

import ua.edu.ucu.function.*;

public class AsIntStream implements IntStream {

    private int[] values;

    private AsIntStream(int... values) {
        this.values = values;
    }

    public static IntStream of(int... values) {
        return new AsIntStream(values);
    }

    @Override
    public Double average() {
        if(values.length == 0){
            throw new IllegalArgumentException();
        }
        double avarage = 0;
        for(int i: values){
            avarage += i;
        }
        avarage = avarage / values.length;
        return avarage;
    }

    @Override
    public Integer max() {
        if(values.length == 0){
            throw new IllegalArgumentException();
        }
        Integer max=values[0];
        for(int i:values){
            if(i> max)
                max = i;
        }
        return max;
    }

    @Override
    public Integer min() {
        if(values.length == 0){
            throw new IllegalArgumentException();
        }
        Integer min = values[0];
        for(int i: values){
            if(i<min)
                min = i;
        }
        return min;
    }

    @Override
    public long count() {
        return values.length;
    }

    @Override
    public Integer sum() {
        if(values.length == 0){
            throw new IllegalArgumentException();
        }
        Integer sum = 0;
        for(int i : values){
            sum+=i;
        }
        return sum;
    }

    @Override
    public IntStream filter(IntPredicate predicate) {
        int[] filteredArray;

        int count = 0;
        for(int i = 0; i < values.length; i ++) {
            if (predicate.tests(values[i]))
                count++;
        }

        filteredArray = new int[count];

        count = 0;
        for(int i = 0; i < values.length; i ++) {
            if (predicate.tests(values[i])) {
                filteredArray[count] = values[i];
                count++;
            }
        }

        this.values = filteredArray;

        return this;
    }

    @Override
    public void forEach(IntConsumer action) {
        for(int i=0;i<values.length;i++){
            action.accept(values[i]);
        }
    }

    @Override
    public IntStream map(IntUnaryOperator mapper) {
        for(int i=0;i<values.length;i++){
            values[i] = mapper.apply(values[i]);
        }
        return this;
    }

    @Override
    public IntStream flatMap(IntToIntStreamFunction func) {
        for(int i: values){

        }
        return null;
    }

    @Override
    public int reduce(int identity, IntBinaryOperator op) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int[] toArray() {
        return values;
    }

}
