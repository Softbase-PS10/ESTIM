package data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

/**
 * @author ricardo
 *
 */
public class BoxArt {

        private String side;
        private String thumbNail;
        private String boxArt;
        private Integer width;
        private Integer height;
       
        /**
         * @return the side
         */
        @XmlAttribute(name = "side")
        public String getSide() {
                return side;
        }
        /**
         * @param side the side to set
         */
        public void setSide(String side) {
                this.side = side;
        }
       
        /**
         * @return the thumbNail
         */
        @XmlAttribute(name = "thumb")
        public String getThumbNail() {
                return thumbNail;
        }
       
        /**
         * @param thumbNail the thumbNail to set
         */
        public void setThumbNail(String thumbNail) {
                this.thumbNail = thumbNail;
        }
       
        /**
         * @return the boxArt
         */
        @XmlValue
        public String getBoxArt() {
                return boxArt;
        }
       
        /**
         * @param boxArt the boxArt to set
         */
        public void setBoxArt(String boxArt) {
                this.boxArt = boxArt;
        }
       
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
}

