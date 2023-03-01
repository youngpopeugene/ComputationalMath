import java.math.BigDecimal;
import java.text.NumberFormat;

public enum Format {
    DEFAULT {
        @Override
        public String fromFloat(final float floatValue) {
            return String.valueOf(floatValue);
        }
        @Override
        public String fromDouble(final double doubleValue) {
            return String.valueOf(doubleValue);
        }
        @Override
        public String fromBigDecimal(final BigDecimal bigDecimalValue) {
            return bigDecimalValue.toString();
        }
    },
    NO_EXPONENT {
        @Override
        public String fromFloat(final float floatValue) {
            return numberFormat.format(floatValue);
        }
        @Override
        public String fromDouble(final double doubleValue) {
            return numberFormat.format(doubleValue);
        }
        @Override
        public String fromBigDecimal(final BigDecimal bigDecimalValue) {
            return bigDecimalValue.toPlainString();
        }
    };

    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    static {
        numberFormat.setMaximumFractionDigits(Integer.MAX_VALUE);
        numberFormat.setGroupingUsed(false);
    }

    public abstract String fromFloat(final float floatValue);
    public abstract String fromDouble(final double doubleValue);
    public abstract String fromBigDecimal(final BigDecimal bigDecimalValue);
}
