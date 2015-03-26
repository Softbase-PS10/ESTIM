package data;

import javax.xml.bind.annotation.XmlValue;

/**
 * @author ricardo
 *
 */
public class ControllerArt {

        private String controllerArt;
       
        @XmlValue
        public String getControllerArt() {
                return controllerArt;
        }
       
        public void setControllerArt(String controllerArt) {
                this.controllerArt = controllerArt;
        }
}
