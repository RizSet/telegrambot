package com.master.telegrambot.api;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class InfoFromCOAPI {
    private String status;
    private DataInfo data;

    @Data
    @Builder
    public static class DataInfo {
        private Iaqi iaqi;
        @Data
        @Builder
        public static class Iaqi {
            private So2 so2;
            @Data
            @Builder
            public static class So2 {
                private String v;

            }
        }
    }

//    {
//        "status":"ok",
//            "data":{
//                "aqi":3,
//                "idx":8587,
//               "dominentpol":"so2",
//                "iaqi":{
//            "so2":{
//                "v":2.6
//            },"t":{
//                "v":9
//            },"w":{
//                "v":1
//            }
//        },"time":{
//            "s":"2023-11-15 22:00:00", "tz":"+02:00", "v":1700085600, "iso":"2023-11-15T22:00:00+02:00"
//        },"forecast":{
//            "daily":{
//                "o3":[{
//                    "avg":22, "day":"2023-11-15", "max":31, "min":16
//                },{
//                    "avg":17, "day":"2023-11-16", "max":25, "min":12
//                },{
//                    "avg":19, "day":"2023-11-17", "max":22, "min":11
//                },{
//                    "avg":21, "day":"2023-11-18", "max":26, "min":16
//                },{
//                    "avg":17, "day":"2023-11-19", "max":17, "min":17
//                }],"pm10":[{
//                    "avg":9, "day":"2023-11-15", "max":12, "min":5
//                },{
//                    "avg":9, "day":"2023-11-16", "max":17, "min":5
//                },{
//                    "avg":12, "day":"2023-11-17", "max":19, "min":8
//                },{
//                    "avg":6, "day":"2023-11-18", "max":7, "min":4
//                },{
//                    "avg":6, "day":"2023-11-19", "max":6, "min":6
//                }],"pm25":[{
//                    "avg":34, "day":"2023-11-15", "max":45, "min":17
//                },{
//                    "avg":33, "day":"2023-11-16", "max":57, "min":20
//                },{
//                    "avg":43, "day":"2023-11-17", "max":64, "min":28
//                },{
//                    "avg":22, "day":"2023-11-18", "max":29, "min":16
//                },{
//                    "avg":23, "day":"2023-11-19", "max":25, "min":23
//                }]}
//        },"debug":{
//            "sync":"2023-11-16T05:19:14+09:00"
//        }
//    }
//    }


}
