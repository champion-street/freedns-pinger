package hu.pinger.freedns.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.rmi.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Scheduler {

    private static final Logger LOG = LoggerFactory.getLogger(Scheduler.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd.HH:mm:ss");

    @Autowired
    PingerService pingerService;

    @Scheduled(cron = "0 0 0 * * ?")
    public void startPing() throws UnknownHostException, IOException {
        LOG.info("Scheduled task started at {}", dateFormat.format(new Date()));
        // TODO
        // need the IP address
        pingerService.sendPingRequest("172.217.19.110");
    }

}
