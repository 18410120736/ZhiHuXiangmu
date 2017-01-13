package com.ch.zhihuxiangmu.ui.zhihu.contract.bean;

import java.util.ArrayList;

/**
 * Created by 123 on 2017/1/11.
 */
public class ZhuanLan {
    private ArrayList<Data> data;

    public ArrayList<Data> getData() {
        return data;
    }

    public void setData(ArrayList<Data> others) {
        this.data = data;
    }

    public class Data{

        private String thumbnail;
        private String description;
        private String id;
        private String name;


        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
