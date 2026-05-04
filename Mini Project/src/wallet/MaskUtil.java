package wallet;

public final class MaskUtil {
    private MaskUtil() {
    }

    public static String maskUpiId(String upiId) {
        if (upiId == null || upiId.isBlank()) {
            return upiId;
        }

        int atIndex = upiId.indexOf('@');
        if (atIndex <= 1) {
            return upiId;
        }

        String prefix = upiId.substring(0, 1);
        String suffix = upiId.substring(atIndex);
        StringBuilder stars = new StringBuilder();
        for (int i = 1; i < atIndex; i++) {
            stars.append('*');
        }
        return prefix + stars + suffix;
    }
}
