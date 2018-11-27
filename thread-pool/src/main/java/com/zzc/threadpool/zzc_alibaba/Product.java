package com.zzc.threadpool.zzc_alibaba;

public class Product {
	/**
	 * 商品ID
	 */
	private int goodsId;
	/**
	 * 用户ID
	 */
    private int  buyerId;


public int getGoodsId() {
	return goodsId;
}
public void setGoodsId(int goodsId) {
	this.goodsId = goodsId;
}
public int getBuyerId() {
	return buyerId;
}
public void setBuyerId(int buyerId) {
	this.buyerId = buyerId;
}
Product(int a){
	this.goodsId=a;
}
@Override
public String toString() {
	return "Product [goodsId=" + goodsId + ", buyerId=" + buyerId + "]";
}

}
