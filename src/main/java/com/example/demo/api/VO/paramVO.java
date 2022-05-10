package com.example.demo.api.VO;

import lombok.*;


@NoArgsConstructor
public class paramVO {

    @NoArgsConstructor
    public static class test2{
        private String name;
        private String subject;

        public String getName() {
            return name;
        }

        public String getSubject() {
            return subject;
        }


    }

    @NoArgsConstructor
    public static class test3{
        private int id;
        private String name;
        private String subject;

        public String getName() {
            return name;
        }

        public String getSubject() {
            return subject;
        }

        public int getId() {
            return id;
        }

    }

}
