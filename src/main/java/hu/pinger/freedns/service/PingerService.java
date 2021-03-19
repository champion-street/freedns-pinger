package hu.pinger.freedns.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Service
public class PingerService {

    public void sendPingRequest(String ipAddress) throws UnknownHostException, IOException{
        InetAddress freeDNSAddress = InetAddress.getByName(ipAddress);
        System.out.println("Sending ping request to " + ipAddress);
        if (freeDNSAddress.isReachable(5000)) {
            System.out.println("Host is reachable!");
        } else {
            System.out.println("Sorry! We can't reach to this host");
        }
    }

}
