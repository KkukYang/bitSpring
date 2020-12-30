package spring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

/**
 * create table product
 * (
 *     num      smallint primary key auto_increment,
 *     name     varchar(30),
 *     cnt      smallint,
 *     photos   varchar(1000),
 *     price    int,
 *     totprice int,
 *     writeday datetime
 * );
 */

public class ProductDto {
    private String num;
    private String name;
    private String cnt;
    private String photos;
    private String price;
    private String totprice;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    private Timestamp writeday;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnt() {
        return cnt;
    }

    public void setCnt(String cnt) {
        this.cnt = cnt;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTotprice() {
        return totprice;
    }

    public void setTotprice(String totprice) {
        this.totprice = totprice;
    }

    public Timestamp getWriteday() {
        return writeday;
    }

    public void setWriteday(Timestamp writeday) {
        this.writeday = writeday;
    }
}
