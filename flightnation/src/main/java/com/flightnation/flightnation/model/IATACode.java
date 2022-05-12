package com.flightnation.flightnation.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum IATACode {
        SEA("SEA"),
        YYZ("YYZ"),
        YYT("YYT"),
        ANC("ANC"),
        LAX("LAX"),
        MIT("MIT"),
        LEW("LEW"),
        GDN("GDN"),
        KRK("KRK"),
        PPX("PPX");

        private String code;
        IATACode(String code){
                this.code = code;
        }

        @Override
        public String toString() {
                return code;
        }

        @JsonCreator
        public static IATACode create(String value){
                if(value == null){
                        throw new IllegalArgumentException();
                }
                for(IATACode w : values()){
                        if(value.equals(w.code)){
                                return w;
                        }
                }
                throw new IllegalArgumentException();
        }

}
