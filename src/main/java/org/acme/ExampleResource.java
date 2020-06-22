package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.sputnikdev.bluetooth.URL;
import org.sputnikdev.bluetooth.manager.*;
import org.sputnikdev.bluetooth.manager.impl.BluetoothManagerBuilder;

import java.util.Set;
import java.util.concurrent.ExecutionException;

@Path("/hello")
public class ExampleResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public boolean hello() throws ExecutionException, InterruptedException {

        BluetoothManager btm = new BluetoothManagerBuilder()
         .withBlueGigaTransport("^*.$")
                .withTinyBTransport(false)
          .withCombinedAdapters(true)
          .build();

        DeviceGovernor d=  btm.getDeviceGovernor(new URL("F0:B3:1E:D4:FC:D1"), true);


       /* BluetoothManager bluetoothManager = new BluetoothManagerBuilder()
                .withTinyBTransport(false)
                .withBlueGigaTransport("^*.$")
                .build();*/
                /*
                .getCharacteristicGovernor(new URL("/XX:XX:XX:XX:XX:XX/F7:EC:62:B9:CF:1F/"
                        + "0000180f-0000-1000-8000-00805f9b34fb/00002a19-0000-1000-8000-00805f9b34fb"*), true) */


        //Set<DiscoveredAdapter> adapters = bluetoothManager.getDiscoveredAdapters();
    /*    bluetoothManager.getDeviceGovernor(new URL("F0:B3:1E:D4:FC:D1"), true)
                .whenReady(CharacteristicGovernor::read)
                .thenAccept(data -> {
                    System.out.println("Battery level: " + data[0]);
                }).get();*/


        return d.isConnected();
    }
}