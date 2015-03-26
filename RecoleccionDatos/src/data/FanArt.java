package data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlValue;

/**
 * @author ricardo
 *
 */
public class FanArt {

        private FanArtOriginal original;
        private String thumbNail;
       
        /**
         * @return the original
         */
        @XmlElement(name = "original")
        public FanArtOriginal getOriginal() {
                return original;
        }

        /**
         * @param original the original to set
         */
        public void setOriginal(FanArtOriginal original) {
                this.original = original;
        }

        /**
         * @return the thumbNail
         */
        @XmlElement(name = "thumb")
        public String getThumbNail() {
                return thumbNail;
        }

        /**
         * @param thumbNail the thumbNail to set
         */
        public void setThumbNail(String thumbNail) {
                this.thumbNail = thumbNail;
        }
       
        public static class FanArtOriginal {
               
                private Integer width;
                private Integer height;
                private String original;
               
                /**
                 * @return the width
                 */
                @XmlAttribute(name = "width")
                public Integer getWidth() {
                        return width;
                }
               
                /**
                 * @param width the width to set
                 */
                public void setWidth(Integer width) {
                        this.width = width;
                }
               
                /**
                 * @return the height
                 */
                @XmlAttribute(name = "height")
                public Integer getHeight() {
                        return height;
                }
               
                /**
                 * @param height the height to set
                 */
                public void setHeight(Integer height) {
                        this.height = height;
                }

                /**
                 * @return the original
                 */
                @XmlValue
                public String getOriginal() {
                        return original;
                }

                /**
                 * @param original the original to set
                 */
                public void setOriginal(String original) {
                        this.original = original;
                }
        }
}

