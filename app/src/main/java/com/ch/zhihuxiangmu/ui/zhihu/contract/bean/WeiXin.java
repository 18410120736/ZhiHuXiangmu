package com.ch.zhihuxiangmu.ui.zhihu.contract.bean;

import java.util.ArrayList;

/**
 * Created by 123 on 2017/1/13.
 */
public class WeiXin {
    private ArrayList<Stories> stories;

    public ArrayList<Stories> getStories() {
        return stories;
    }

    public void setStories(ArrayList<Stories> stories) {
        this.stories = stories;
    }

    public class Stories{
        private ArrayList<String> images;
        private String date;
        private String display_date;
        private String title;

        public ArrayList<String> getImages() {
            return images;
        }

        public void setImages(ArrayList<String> images) {
            this.images = images;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDisplay_date() {
            return display_date;
        }

        public void setDisplay_date(String display_date) {
            this.display_date = display_date;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
