package data;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author ricardo
 *
 */
@XmlRootElement(name = "Data")
public class Data {

        private String baseImgUrl;
        private String basePlatformUrl;
        private PlatformWrapper platformWrapper;
        private List<Platform> platforms;
        private List<Game> games;

        /**
         * @return the basImgUrl
         */
        @XmlElement(name = "baseImgUrl")
        public String getBaseImgUrl() {
                return baseImgUrl;
        }

        /**
         * @param basImgUrl the basImgUrl to set
         */
        public void setBaseImgUrl(String baseImgUrl) {
                this.baseImgUrl = baseImgUrl;
        }
       
        @XmlElement(name="basePlatformUrl")
        public String getBasePlatformUrl() {
                return basePlatformUrl;
        }
       
        public void setBasePlatformUrl(String basePlatformUrl) {
                this.basePlatformUrl = basePlatformUrl;
        }
       
        @XmlElement(name="Platforms")
        public PlatformWrapper getPlatformWrapper() {
                return platformWrapper;
        }
       
        public void setPlatformWrapper(PlatformWrapper platformWrapper) {
                this.platformWrapper = platformWrapper;
        }
       
        /**
         * @return the platforms
         */
        @XmlElement(name="Platform")
        public List<Platform> getPlatforms() {
                return platforms;
        }

        /**
         * @param platforms the platforms to set
         */
        public void setPlatforms(List<Platform> platforms) {
                this.platforms = platforms;
        }

        /**
         * @return the games
         */
        @XmlElement(name="Game")
        public List<Game> getGames() {
                return games;
        }

        /**
         * @param games the games to set
         */
        public void setGames(List<Game> games) {
                this.games = games;
        }
       
        public static class PlatformWrapper {
                private List<Platform> platforms;
               
                @XmlElement(name="Platform")
                public List<Platform> getPlatforms() {
                        return platforms;
                }
               
                public void setPlatforms(List<Platform> platforms) {
                        this.platforms = platforms;
                }
        }
}


