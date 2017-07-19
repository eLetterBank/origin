package com.springdemo.greeting.repositories;

import com.vsolv.appframework.repository.DataRepository;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class TimeRepository implements DataRepository {
    public String getServerTime()
    {
        return (Calendar.getInstance().getTime().toString());
    }
}
