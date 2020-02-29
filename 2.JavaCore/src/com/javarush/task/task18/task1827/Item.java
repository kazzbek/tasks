package com.javarush.task.task18.task1827;

public class Item implements Comparable {

    public int id;
    String productName;
    double price;
    int quantity;
    static int maxID = 0;

    public Item(String s) {
        this.id = Integer.parseInt(s.substring(0, 8).trim());
        this.productName = s.substring(8, 38);
        this.price = Double.parseDouble(s.substring(38, 46).trim());
        this.quantity = Integer.parseInt(s.substring(46).trim());
        if (this.id > maxID) maxID = this.id;
    }

    public Item(String productName, double price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        id = ++maxID;
    }

    @Override
    public String toString() {
        /* старый длинный код
        StringBuffer stringBuffer = new StringBuffer();

        String stringid = String.valueOf(this.id);
        if (stringid.length() > 8)
            stringBuffer.append(stringid.substring(0, 7));
        else
            stringBuffer.append(this.id);
        while (stringBuffer.length() < 8) stringBuffer.append(" ");

        if (productName.length() > 30)
            stringBuffer.append(this.productName.substring(0, 29));
        else
            stringBuffer.append(productName);
        while (stringBuffer.length() < 38) stringBuffer.append(" ");


        String stringPrice = String.valueOf(this.price);
        if (stringPrice.length() > 8)
            stringBuffer.append(stringPrice.substring(0, 7));
        else
            stringBuffer.append(stringPrice);
        while (stringBuffer.length() < 46) stringBuffer.append(" ");

        String stringQuantity = String.valueOf(this.quantity);
        if (stringQuantity.length() > 4)
            stringBuffer.append(String.valueOf(this.quantity).substring(0, 3));
        else
            stringBuffer.append(stringQuantity);
        while (stringBuffer.length() < 50) stringBuffer.append(" ");
        */
        //одна короткая строчка подсмотренная в комментариях
        String forOut = String.format("%-8d%-30s%-8s%-4d", id, productName, price, quantity);
        return forOut;
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.id, ((Item) o).id);
    }
}
