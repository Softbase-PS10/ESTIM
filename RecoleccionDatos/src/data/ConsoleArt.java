package data;

import javax.xml.bind.annotation.XmlValue;

/**
 * @author ricardo
 *
 */
public class ConsoleArt {

        public String consoleArt;
       
        @XmlValue
        public String getConsoleArt() {
                return consoleArt;
        }
       
        public void setConsoleArt(String consoleArt) {
                this.consoleArt = consoleArt;
        }
}

