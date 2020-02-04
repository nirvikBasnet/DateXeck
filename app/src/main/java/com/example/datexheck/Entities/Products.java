package com.example.datexheck.Entities;

import java.io.Serializable;





    public class Products implements Serializable {


        public Long id;
        public String name;
        public String description;
        public Integer expDate;



        public Products(Long id, String name, String description, Integer expDate) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.expDate = expDate;

        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Integer getExpDate() {
            return expDate;
        }

        public void setExpDate(Integer expDate) {
            this.expDate = expDate;
        }



        @Override
        public String toString() {
            return "Products{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    ", ExpirationDate=" + expDate+
                    '}';
        }
    }


