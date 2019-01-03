package com.cmg.saien.spider.entity;

import java.util.List;
import java.util.Map;
//{"manage": {"default": {"ip": "192.168.127.4", "mac": "748e.f8bd.c460", "state": "UP", "name": ""}},"ids":[1,3,4,5]}
public class TestEntity {


    private Map<String,manageItem> manage;
    private List<Integer> ids;

    public Map<String, manageItem> getManage() {
        return manage;
    }

    public void setManage(Map<String, manageItem> manage) {
        this.manage = manage;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    private static class manageItem {
        private String ip;
        private String mac;
        private String state;
        private String name;

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getMac() {
            return mac;
        }

        public void setMac(String mac) {
            this.mac = mac;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
