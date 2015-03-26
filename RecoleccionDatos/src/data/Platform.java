package data;

import java.net.URL;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author ricardo
 *
 */
@XmlRootElement
public class Platform {

	private Long id;
	private String name;
	private String alias;
	private String platformName;
	private URL youTubeConsole;
	private URL youTubeController;
	private String overview;
	private String developer;
	private String manufacturer;
	private String cpu;
	private String memory;
	private String graphics;
	private String sound;
	private String display;
	private String media;
	private Integer maxControllers;
	private Double rating;
	private List<Image> images;
	private String baseUrl;

	/**
	 * @return the id
	 */
	@XmlElement(name = "id")
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	@XmlElement(name = "name")
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the alias
	 */
	@XmlElement(name = "alias")
	public String getAlias() {
		return alias;
	}

	/**
	 * @param alias
	 *            the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * @return the platformName
	 */
	@XmlElement(name = "Platform")
	public String getPlatformName() {
		return platformName;
	}

	/**
	 * @param platformName
	 *            the platformName to set
	 */
	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}

	/**
	 * @return the youTubeConsole
	 */
	@XmlElement(name = "console")
	public URL getYouTubeConsole() {
		return youTubeConsole;
	}

	/**
	 * @param youTubeConsole
	 *            the youTubeConsole to set
	 */
	public void setYouTubeConsole(URL youTubeConsole) {
		this.youTubeConsole = youTubeConsole;
	}

	/**
	 * @return the youTubeController
	 */
	@XmlElement(name = "controller")
	public URL getYouTubeController() {
		return youTubeController;
	}

	/**
	 * @param youTubeController
	 *            the youTubeController to set
	 */
	public void setYouTubeController(URL youTubeController) {
		this.youTubeController = youTubeController;
	}

	/**
	 * @return the overview
	 */
	@XmlElement(name = "overview")
	public String getOverview() {
		return overview;
	}

	/**
	 * @param overview
	 *            the overview to set
	 */
	public void setOverview(String overview) {
		this.overview = overview;
	}

	/**
	 * @return the developer
	 */
	@XmlElement(name = "developer")
	public String getDeveloper() {
		return developer;
	}

	/**
	 * @param developer
	 *            the developer to set
	 */
	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	/**
	 * @return the manufacturer
	 */
	@XmlElement(name = "manufacturer")
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * @param manufacturer
	 *            the manufacturer to set
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	/**
	 * @return the cpu
	 */
	@XmlElement(name = "cpu")
	public String getCpu() {
		return cpu;
	}

	/**
	 * @param cpu
	 *            the cpu to set
	 */
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	/**
	 * @return the memory
	 */
	@XmlElement(name = "memory")
	public String getMemory() {
		return memory;
	}

	/**
	 * @param memory
	 *            the memory to set
	 */
	public void setMemory(String memory) {
		this.memory = memory;
	}

	/**
	 * @return the graphics
	 */
	@XmlElement(name = "graphics")
	public String getGraphics() {
		return graphics;
	}

	/**
	 * @param graphics
	 *            the graphics to set
	 */
	public void setGraphics(String graphics) {
		this.graphics = graphics;
	}

	/**
	 * @return the sound
	 */
	@XmlElement(name = "sound")
	public String getSound() {
		return sound;
	}

	/**
	 * @param sound
	 *            the sound to set
	 */
	public void setSound(String sound) {
		this.sound = sound;
	}

	/**
	 * @return the display
	 */
	@XmlElement(name = "display")
	public String getDisplay() {
		return display;
	}

	/**
	 * @param display
	 *            the display to set
	 */
	public void setDisplay(String display) {
		this.display = display;
	}

	/**
	 * @return the media
	 */
	@XmlElement(name = "media")
	public String getMedia() {
		return media;
	}

	/**
	 * @param media
	 *            the media to set
	 */
	public void setMedia(String media) {
		this.media = media;
	}

	/**
	 * @return the maxControllers
	 */
	@XmlElement(name = "maxcontrollers")
	public Integer getMaxControllers() {
		return maxControllers;
	}

	/**
	 * @param maxControllers
	 *            the maxControllers to set
	 */
	public void setMaxControllers(Integer maxControllers) {
		this.maxControllers = maxControllers;
	}

	/**
	 * @return the rating
	 */
	@XmlElement(name = "Rating")
	public Double getRating() {
		return rating;
	}

	/**
	 * @param rating
	 *            the rating to set
	 */
	public void setRating(Double rating) {
		this.rating = rating;
	}

	/**
	 * @return the images
	 */
	@XmlElement(name = "Images")
	public List<Image> getImages() {
		return images;
	}

	/**
	 * @param images
	 *            the images to set
	 */
	public void setImages(List<Image> images) {
		this.images = images;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String datos_pales() {
		
		return id + "%%" + name + "%%" + alias + "";

//		return id + "%%" + name + "%%" + alias + "%%" + overview
//				+ "%%" + developer + "%%" + cpu + "%%" + memory
//				+ "%%" + graphics + "%%" + sound + "%%" + display
//				+ "%%" + media + "%%" + maxControllers + "%%" + rating;
	}
}
