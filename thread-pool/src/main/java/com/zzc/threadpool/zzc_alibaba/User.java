package com.zzc.threadpool.zzc_alibaba;

public class User {
    /**
     * 用户ID
     */
 private int buyerId;

public int getBuyerId() {
	return buyerId;
}

public void setBuyerId(int buyerId) {
	this.buyerId = buyerId;
}
 User(int buId){
	 this.buyerId=buId; 
 }
}
