class InventoryService {
    void updateStock() {
        System.out.println("Stock updated");
    }
}

class MaterialPlannerEx6 {
    void calculateMaterialNeeds() {
        System.out.println("Material needs calculated");
    }
}

class InvoiceService {
    void createInvoice() {
        System.out.println("Invoice created");
    }
}

public class Exercise6 {
    public static void main(String[] args) {
        InventoryService inventory = new InventoryService();
        MaterialPlannerEx6 planner = new MaterialPlannerEx6();
        InvoiceService invoice = new InvoiceService();

        inventory.updateStock();
        planner.calculateMaterialNeeds();
        invoice.createInvoice();
    }
}