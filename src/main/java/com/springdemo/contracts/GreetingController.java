package com.springdemo.contracts;

import com.vsolv.appframework.GetJsonRequestParam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController
public class GreetingController {

    private final Logger logger = LogManager.getRootLogger();

    @GetMapping(value = "/")
    public String home() {

        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        logger.fatal("This is a fatal message");

        String timeStamp = Calendar.getInstance().getTime().toString();

        logger.info("Time Stamp : " + timeStamp);
        logger.info("Generate response with server time stamp");

        return "{\"data\":\"Hello Docker World! - " + timeStamp + "\"}";
    }

    @GetMapping(value = "/greeting",
            consumes = "application/json",
            produces = "application/json")
    public
    @ResponseBody
    GreetingQueryResult greeting(@GetJsonRequestParam GreetingQuery qry) {
        logger.error(qry);

        GreetingQuery q = qry;

        logger.error("---> " + q.getName());

        String name = "";

        if (qry == null) name = "World-1";
        else if (qry.getName() == null) name = "World-2";
        else name = qry.getName();

        String timeStamp = Calendar.getInstance().getTime().toString();
        String responseData = "Hello " + name + " " + qry.getAddress().getStreet() + "! - " + timeStamp;

        return new GreetingQueryResult(responseData);
    }

}