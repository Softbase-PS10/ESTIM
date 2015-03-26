package data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

/**
 * @author ricardo
 *
 */
public class Banner {

        private Integer width;
        private Integer height;
        private String banner;
       
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
         * @return the banner
         */
        @XmlValue
        public String getBanner() {
                return banner;
        }
       
        /**
         * @param banner the banner to set
         */
        public void setBanner(String banner) {
                this.banner = banner;
        }
}

