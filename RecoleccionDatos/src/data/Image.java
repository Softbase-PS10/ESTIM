package data;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author ricardo
 *
 */
@XmlRootElement(name = "Images")
public class Image {

        private List<FanArt> fanArt;
        private List<BoxArt> boxArt;
        private List<Banner> banners;
        private List<ScreenShot> screenShot;
        private List<Logo> logo;
        private List<String> consoleArt;
        private List<String> controllerArt;
       
        /**
         * @return the fanArt
         */
        @XmlElement(name = "fanart")
        public List<FanArt> getFanArt() {
                return fanArt;
        }
       
        /**
         * @param fanArt the fanArt to set
         */
        public void setFanArt(List<FanArt> fanArt) {
                this.fanArt = fanArt;
        }
       
        /**
         * @return the boxArt
         */
        @XmlElement(name = "boxart")
        public List<BoxArt> getBoxArt() {
                return boxArt;
        }
       
        /**
         * @param boxArt the boxArt to set
         */
        public void setBoxArt(List<BoxArt> boxArt) {
                this.boxArt = boxArt;
        }
       
        /**
         * @return the banners
         */
        @XmlElement(name = "banner")
        public List<Banner> getBanners() {
                return banners;
        }
       
        /**
         * @param banners the banners to set
         */
        public void setBanners(List<Banner> banners) {
                this.banners = banners;
        }
       
        /**
         * @return the screenShot
         */
        @XmlElement(name = "screenshot")
        public List<ScreenShot> getScreenShot() {
                return screenShot;
        }
       
        /**
         * @param screenShot the screenShot to set
         */
        public void setScreenShot(List<ScreenShot> screenShot) {
                this.screenShot = screenShot;
        }
       
        /**
         * @return the logo
         */
        @XmlElement(name = "clearlogo")
        public List<Logo> getLogo() {
                return logo;
        }
       
        /**
         * @param logo the logo to set
         */
        public void setLogo(List<Logo> logo) {
                this.logo = logo;
        }

        /**
         * @return the consoleArt
         */
        @XmlElement(name="consoleart")
        public List<String> getConsoleArt() {
                return consoleArt;
        }

        /**
         * @param consoleArt the consoleArt to set
         */
        public void setConsoleArt(List<String> consoleArt) {
                this.consoleArt = consoleArt;
        }

        /**
         * @return the controllerArt
         */
        @XmlElement(name="controllerart")
        public List<String> getControllerArt() {
                return controllerArt;
        }

        /**
         * @param controllerArt the controllerArt to set
         */
        public void setControllerArt(List<String> controllerArt) {
                this.controllerArt = controllerArt;
        }
}

