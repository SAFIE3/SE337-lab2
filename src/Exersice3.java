import java.util.ArrayList;
import java.util.List;

class BomLineEx3 {
    private final String componentCode;
    private final long quantityPerUnit;
    private final int lossPercent;

    BomLineEx3(String componentCode, long quantityPerUnit, int lossPercent) {
        if (quantityPerUnit <= 0) {
            throw new IllegalArgumentException("quantityPerUnit must be positive");
        }
        if (lossPercent < 0 || lossPercent >= 100) {
            throw new IllegalArgumentException("lossPercent must be between 0 and 99");
        }
        this.componentCode = componentCode;
        this.quantityPerUnit = quantityPerUnit;
        this.lossPercent = lossPercent;
    }

    String componentCode() {
        return componentCode;
    }
}

class BomRevision {
    private final List<BomLineEx3> lines;

    BomRevision(List<BomLineEx3> lines) {
        this.lines = List.copyOf(lines);
    }

    List<BomLineEx3> lines() {
        return lines;
    }
}

class Exercise3 {
    public static void main(String[] args) {
        List<BomLineEx3> original = new ArrayList<>();
        original.add(new BomLineEx3("WOOD-A", 20, 5));

        BomRevision revision = new BomRevision(original);

        System.out.println("Before change:");
        System.out.println("Original size: " + original.size());
        System.out.println("Revision size: " + revision.lines().size());

        original.add(new BomLineEx3("GLUE-A", 2, 0));

        System.out.println("After change:");
        System.out.println("Original size: " + original.size());
        System.out.println("Revision size: " + revision.lines().size());

        // Test modification attempt (Uncomment to test):
        // revision.lines().clear();
    }
}
