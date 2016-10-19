package com.demon.retrofit2_1.bean;

import com.demon.retrofit2_1.http.BaseCallBean;

import java.util.List;

/**
 * @author Demon
 * @version V1.0
 * @Description: 用户个人信息
 * @date 2016年10月18日16:12:28
 */
public class UserBean extends BaseCallBean {

    private String bName;
    private String bPhone;
    private String bHeadImg;
    private String bIdCard;
    private String bBankCard;
    private String bAccount;
    private String bProfessional;
    private String bProfilePicture;
    private String bOrdersNum;
    private double bCommission;
    private int bLv;
    private int state;
    private String bReason;
    private int avgEvaluation;
    private List<?> listE;

    public String getBName() {
        return bName;
    }

    public void setBName(String bName) {
        this.bName = bName;
    }

    public String getBPhone() {
        return bPhone;
    }

    public void setBPhone(String bPhone) {
        this.bPhone = bPhone;
    }

    public String getBHeadImg() {
        return bHeadImg;
    }

    public void setBHeadImg(String bHeadImg) {
        this.bHeadImg = bHeadImg;
    }

    public String getBIdCard() {
        return bIdCard;
    }

    public void setBIdCard(String bIdCard) {
        this.bIdCard = bIdCard;
    }

    public String getBBankCard() {
        return bBankCard;
    }

    public void setBBankCard(String bBankCard) {
        this.bBankCard = bBankCard;
    }

    public String getBAccount() {
        return bAccount;
    }

    public void setBAccount(String bAccount) {
        this.bAccount = bAccount;
    }

    public String getBProfessional() {
        return bProfessional;
    }

    public void setBProfessional(String bProfessional) {
        this.bProfessional = bProfessional;
    }

    public String getBProfilePicture() {
        return bProfilePicture;
    }

    public void setBProfilePicture(String bProfilePicture) {
        this.bProfilePicture = bProfilePicture;
    }

    public String getBOrdersNum() {
        return bOrdersNum;
    }

    public void setBOrdersNum(String bOrdersNum) {
        this.bOrdersNum = bOrdersNum;
    }

    public double getBCommission() {
        return bCommission;
    }

    public void setBCommission(double bCommission) {
        this.bCommission = bCommission;
    }

    public int getBLv() {
        return bLv;
    }

    public void setBLv(int bLv) {
        this.bLv = bLv;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getBReason() {
        return bReason;
    }

    public void setBReason(String bReason) {
        this.bReason = bReason;
    }

    public int getAvgEvaluation() {
        return avgEvaluation;
    }

    public void setAvgEvaluation(int avgEvaluation) {
        this.avgEvaluation = avgEvaluation;
    }

    public List<?> getListE() {
        return listE;
    }

    public void setListE(List<?> listE) {
        this.listE = listE;
    }

}