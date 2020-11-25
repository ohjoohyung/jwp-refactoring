package kitchenpos.domain;

public class OrderMenu {
    private Long seq;
    private Long orderId;
    private Long menuId;
    private long quantity;

    public OrderMenu() {
    }

    public OrderMenu(Long orderId, Long menuId, long quantity) {
        this.orderId = orderId;
        this.menuId = menuId;
        this.quantity = quantity;
    }

    public OrderMenu(Long seq, Long orderId, Long menuId, long quantity) {
        this.seq = seq;
        this.orderId = orderId;
        this.menuId = menuId;
        this.quantity = quantity;
    }

    public Long getSeq() {
        return seq;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public long getQuantity() {
        return quantity;
    }
}