import java.util.Map;

class InventorySnapshotEx5 {
    private final Map<String, Long> quantities;

    InventorySnapshotEx5(Map<String, Long> quantities) {
        this.quantities = Map.copyOf(quantities);
    }

    long available(String componentCode) {
        return quantities.getOrDefault(componentCode, 0L);
    }
}

// Part A: Dependency (InventorySnapshot is only passed into a method parameter)
class MaterialPlanner {
    void showWoodStock(InventorySnapshotEx5 stock) {
        System.out.println("Planner sees WOOD-A: " + stock.available("WOOD-A"));
    }
}

// Part B: Association (InventorySnapshot is stored in a class field)
class StockViewer {
    private final InventorySnapshotEx5 stock;

    StockViewer(InventorySnapshotEx5 stock) {
        this.stock = stock;
    }

    void showWood() {
        System.out.println("Viewer remembers WOOD-A: " + stock.available("WOOD-A"));
    }
}

public class Exercise5 {
    public static void main(String[] args) {
        InventorySnapshotEx5 stock = new InventorySnapshotEx5(Map.of("WOOD-A", 3000L));

        // Testing Dependency
        MaterialPlanner planner = new MaterialPlanner();
        planner.showWoodStock(stock);

        // Testing Association
        StockViewer viewer = new StockViewer(stock);
        viewer.showWood();
        viewer.showWood();
    }
}
