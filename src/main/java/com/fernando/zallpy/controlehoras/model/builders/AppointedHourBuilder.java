package com.fernando.zallpy.controlehoras.model.builders;

import com.fernando.zallpy.controlehoras.model.AppointedHour;
import com.fernando.zallpy.controlehoras.model.AppointedHourId;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AppointedHourBuilder {

    private AppointedHour appointedHour;

    public AppointedHourBuilder() {
        appointedHour = new AppointedHour();
    }

    public AppointedHourBuilder withAppointedHourId(Long programmerId, Long projectId) {
        appointedHour.setAppointedHourId(new AppointedHourId(programmerId, projectId));
        return this;
    }

    public AppointedHourBuilder withHours(BigDecimal hours) {
        appointedHour.setHours(hours);
        return this;
    }
    public AppointedHourBuilder withDate(LocalDate date) {
        appointedHour.setDate(date);
        return this;
    }
    public AppointedHour build() {
        return appointedHour;
    }


}
