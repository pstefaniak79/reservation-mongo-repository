package pl.pstefaniak.mongo;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class MBeansTest {
    public static void main(String[] args) {
        try {
            ObjectName objectName = new ObjectName("pl.pstefaniak:name=applicationInfo");
            MBeanServer server = ManagementFactory.getPlatformMBeanServer();
            server.registerMBean(new Game(), objectName);
        } catch (MalformedObjectNameException | InstanceAlreadyExistsException |
                MBeanRegistrationException | NotCompliantMBeanException e) {
            // handle exceptions
        }
        try {
            Thread.sleep(30000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}


interface GameMBean {

    public void playFootball(String clubName);

    public String getPlayerName();

    public void setPlayerName(String playerName);

}

class Game implements GameMBean {

    private String playerName;

    @Override
    public void playFootball(String clubName) {
        System.out.println(
                this.playerName + " playing football for " + clubName);
    }

    @Override
    public String getPlayerName() {
        System.out.println("Return playerName " + this.playerName);
        return playerName;
    }

    @Override
    public void setPlayerName(String playerName) {
        System.out.println("Set playerName to value " + playerName);
        this.playerName = playerName;
    }
}