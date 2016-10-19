package com.demon.retrofit2_1.bean;

import com.demon.retrofit2_1.http.BaseCallBean;

import java.util.List;

/**
 * @author Demon
 * @version V1.0
 * @Description: 价目表
 * @date 2016年10月18日16:15:17
 */
public class Price extends BaseCallBean {

    private String fPriceClassID;
    private String fPriceClassName;

    private List<SPriceClassListBean> sPriceClassList;

    public String getFPriceClassID() {
        return fPriceClassID;
    }

    public void setFPriceClassID(String fPriceClassID) {
        this.fPriceClassID = fPriceClassID;
    }

    public String getFPriceClassName() {
        return fPriceClassName;
    }

    public void setFPriceClassName(String fPriceClassName) {
        this.fPriceClassName = fPriceClassName;
    }

    public List<SPriceClassListBean> getSPriceClassList() {
        return sPriceClassList;
    }

    public void setSPriceClassList(List<SPriceClassListBean> sPriceClassList) {
        this.sPriceClassList = sPriceClassList;
    }

    public static class SPriceClassListBean {
        private String sPriceClassID;
        private String sPriceClassName;
        private double sellingPrice;
        private String sellingUnit;
        private String fPriceClassID;

        public String getSPriceClassID() {
            return sPriceClassID;
        }

        public void setSPriceClassID(String sPriceClassID) {
            this.sPriceClassID = sPriceClassID;
        }

        public String getSPriceClassName() {
            return sPriceClassName;
        }

        public void setSPriceClassName(String sPriceClassName) {
            this.sPriceClassName = sPriceClassName;
        }

        public double getSellingPrice() {
            return sellingPrice;
        }

        public void setSellingPrice(double sellingPrice) {
            this.sellingPrice = sellingPrice;
        }

        public String getSellingUnit() {
            return sellingUnit;
        }

        public void setSellingUnit(String sellingUnit) {
            this.sellingUnit = sellingUnit;
        }

        public String getFPriceClassID() {
            return fPriceClassID;
        }

        public void setFPriceClassID(String fPriceClassID) {
            this.fPriceClassID = fPriceClassID;
        }
    }
}
