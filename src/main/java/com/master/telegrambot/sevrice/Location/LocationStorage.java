package com.master.telegrambot.sevrice.Location;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LocationStorage {
    Double longitude;
    Double latitude;
}
