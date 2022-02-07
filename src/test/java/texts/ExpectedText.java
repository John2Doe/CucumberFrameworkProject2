package texts;

import java.util.ArrayList;
import java.util.List;

public class ExpectedText {

    public static final String FamilyAlbum = "FamilyAlbum";
    public static final String name = "John Austin";
    public static final String quantity = "2";
    public static final String date = "02/07/2022";
    public static final String streetAdress = "11624 s natchez ave";
    public static final String city = "worth";
    public static final String state = "Illinois";
    public static final String zipCode = "60482";
    public static final String masterCard = "MasterCard";
    public static final String cardNumber = "123412341234";
    public static final String expireDate = "08/23";

    public static final List<String> orderInfos = new ArrayList<>();

    public List<String> getOrderInfos() {
        getOrderInfos().add(FamilyAlbum);
        getOrderInfos().add(name);
        getOrderInfos().add(quantity);
        getOrderInfos().add(date);
        getOrderInfos().add(streetAdress);
        getOrderInfos().add(city);
        getOrderInfos().add(state);
        getOrderInfos().add(zipCode);
        getOrderInfos().add(masterCard);
        getOrderInfos().add(cardNumber);
        getOrderInfos().add(expireDate);
        return orderInfos;
    }
}
