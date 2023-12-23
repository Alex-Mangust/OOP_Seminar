package Interfaces;

// Интерфейс iReturnOrder описывает процедуру возврата товаров
public interface iReturnOrder {
    /** Объявленый метод returnOrder, отвечающий за возврат товара */
    public String returnOrder();

    /** Объявленый метод receptionOrder, отвечающий за проверку возможности возврата товара */
    public boolean receptionOrder();
}
