public final class IntegerPower {
    
    private Values values = new Values();

    private static transient final short[] bit_set = {
            0, 1, 2, 2, 3, 3, 3, 3,
            4, 4, 4, 4, 4, 4, 4, 4,
            5, 5, 5, 5, 5, 5, 5, 5,
            5, 5, 5, 5, 5, 5, 5, 5,
            6, 6, 6, 6, 6, 6, 6, 6,
            6, 6, 6, 6, 6, 6, 6, 6,
            6, 6, 6, 6, 6, 6, 6, 6,
            6, 6, 6, 6, 6, 6, 6, 6
    };

    public IntegerPower(Values values) {
        this.values = values;

    }

    public long intPower() {
        // Edge cases and common use cases
        if(values.getBase() == -1) return 1 - 2 * (values.getExp() & 1);
        if(values.getBase() == 1) return 1;
        if(values.getBase() == 0 && values.getExp() == 0) throw new ArithmeticException("Cannot raise 0 to the 0th power! ");
        if(values.getBase() == 0) return 0;
        if(values.getExp() == 0) return 1;
        if(values.getExp() < 0) throw new ArithmeticException("Exponent cannot be negative! ");
        if(values.getExp() == 1) return values.getBase();
        if(values.getExp() > 63) throw new ArithmeticException("Overflow! ");

        long tmpbase = values.getBase();
        long result = 1;
        int set = bit_set[values.getExp()];

        if(set > 6)
            return result;

        for(int i = 0; i < set; i++) {
            if ((values.getExp() & 1) == 1) {
                result *= tmpbase;
            }
            int v = values.getExp();
            v >>= 1;
            values.setExp(v);
            tmpbase *= tmpbase;
        }

        return result;
    }
}
