package mashine.a;

import mashine.a.tests.PornhubTest;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        Comp desktop = new Comp(Browser.CHROME,
                Platform.VISTA,
                "192.168.0.12",
                5566);

        Thread t1 = new Thread(new PornhubTest(desktop.driver));

        t1.start();
    }

    private static class Comp {
        private Browser browser;
        private Platform platform;
        private String ip;
        private int port;
        private WebDriver driver;

        public Comp(Browser browser, Platform platform, String ip, int port) throws MalformedURLException {
            this.browser = browser;
            this.platform = platform;
            this.ip = ip;
            this.port = port;

            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setBrowserName(browser.name().toLowerCase());
            capabilities.setPlatform(platform);

            driver = new RemoteWebDriver(
                    new URL("http://" + ip + ":" + port + "/wd/hub"),
                    capabilities
            );
        }
    }

    private enum Browser {
        CHROME,
        MOZILLA
    }
}
