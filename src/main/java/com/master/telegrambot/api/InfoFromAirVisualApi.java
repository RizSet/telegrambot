package com.master.telegrambot.api;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class InfoFromAirVisualApi {
    private String status;
    private DataInfo data;

    @Data
    @Builder
    public static class DataInfo {
        private String city;
        private String state;
        private String country;
        private Current current;

        @Data
        @Builder
        public static class Current {
            private Pollution pollution;
            private Weather weather;
            @Data
            @Builder
            public static class Pollution {
                private int aqius;
            }
            @Data
            @Builder
            public static class Weather {
                private int tp;
            }
        }
    }

//    {
//        "status":"success"
//        "data":{
//        "city":"Khotiv"
//        "state":"Kyiv"
//        "country":"Ukraine"
//        "location":{
//            "type":"Point"
//            "coordinates":[30.518508, 50.407004]
//        }
//        "current":{
//            "pollution":{
//                "ts":"2023-11-11T15:00:00.000Z"
//                "aqius":84
//                "mainus":"p2"
//                "aqicn":42
//                "maincn":"p1"
//            }
//            "weather":{
//                "ts":"2023-11-11T15:00:00.000Z", "tp":8, "pr":1000, "hu":88, "ws":0.45, "wd":266, "ic":"10n"
//            }
//        }
//    }
//    }


}
