package data;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author ricardo
 *
 */
@XmlRootElement
public class Game {
	private Long id;
	private String gameTitle;
	private String releaseDate;
	private Long platformId;
	private String platform;
	private String overview;
	private String rating;
	private List<Genre> genres;
	private String players;
	private String coOp;
	private String youTube;
	private String publisher;
	private String developer;
	private Double userRating;
	private Image images;
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
	 * @return the gameTitle
	 */
	@XmlElement(name = "GameTitle")
	public String getGameTitle() {
		return gameTitle;
	}

	/**
	 * @param gameTitle
	 *            the gameTitle to set
	 */
	public void setGameTitle(String gameTitle) {
		this.gameTitle = gameTitle;
	}

	/**
	 * @return the releaseDate
	 */
	@XmlElement(name = "ReleaseDate")
	public String getReleaseDate() {
		return releaseDate;
	}

	/**
	 * @param releaseDate
	 *            the releaseDate to set
	 */
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	/**
	 * @return the platformId
	 */
	@XmlElement(name = "PlatformId")
	public Long getPlatformId() {
		return platformId;
	}

	/**
	 * @param platformId
	 *            the platformId to set
	 */
	public void setPlatformId(Long platformId) {
		this.platformId = platformId;
	}

	/**
	 * @return the platform
	 */
	@XmlElement(name = "Platform")
	public String getPlatform() {
		return platform;
	}

	/**
	 * @param platform
	 *            the platform to set
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
	}

	/**
	 * @return the overview
	 */
	@XmlElement(name = "Overview")
	public String getOverview() {
		return overview;
	}

	/**
	 * @param overview
	 *            the overview to set
	 */
	public void setOverview(String overview) {
		this.overview = overview.replaceAll("\n", "").replaceAll("\"", "").replaceAll("\'", "");
	}

	/**
	 * @return the rating
	 */
	@XmlElement(name = "ESRB")
	public String getRating() {
		return rating;
	}

	/**
	 * @param rating
	 *            the rating to set
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}

	/**
	 * @return the genre
	 */
	@XmlElement(name = "Genres")
	public List<Genre> getGenres() {
		return genres;
	}

	/**
	 * @param genre
	 *            the genre to set
	 */
	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	/**
	 * @return the players
	 */
	@XmlElement(name = "Players")
	public String getPlayers() {
		return players;
	}

	/**
	 * @param players
	 *            the players to set
	 */
	public void setPlayers(String players) {
		this.players = players;
	}

	/**
	 * @return the coOp
	 */
	@XmlElement(name = "Co-op")
	public String getCoOp() {
		return coOp;
	}

	/**
	 * @param coOp
	 *            the coOp to set
	 */
	public void setCoOp(String coOp) {
		this.coOp = coOp;
	}

	/**
	 * @return the youTube
	 */
	@XmlElement(name = "Youtube")
	public String getYouTube() {
		if (youTube != null && youTube.contains("=")) {
			String formattedYouTube = youTube.replace("watch?v=", "/v/");
			return formattedYouTube;
		}

		return youTube;
	}

	/**
	 * @param youTube
	 *            the youTube to set
	 */
	public void setYouTube(String youTube) {
		this.youTube = youTube;
	}

	/**
	 * @return the publisher
	 */
	@XmlElement(name = "Publisher")
	public String getPublisher() {
		return publisher;
	}

	/**
	 * @param publisher
	 *            the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * @return the developer
	 */
	@XmlElement(name = "Developer")
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
	 * @return the userRating
	 */
	@XmlElement(name = "Rating")
	public Double getUserRating() {
		return userRating;
	}

	/**
	 * @param userRating
	 *            the userRating to set
	 */
	public void setUserRating(Double userRating) {
		this.userRating = userRating;
	}

	/**
	 * @return the images
	 */
	@XmlElement(name = "Images")
	public Image getImages() {
		return images;
	}

	/**
	 * @param images
	 *            the images to set
	 */
	public void setImages(Image images) {
		this.images = images;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public static class Genre {
		private String genre;

		/**
		 * @return the genre
		 */
		@XmlElement(name = "genre")
		public String getGenre() {
			return genre;
		}

		/**
		 * @param genre
		 *            the genre to set
		 */
		public void setGenre(String genre) {
			this.genre = genre;
		}
		
		public String toString(){
			return genre;
		}
	}

	@Override
	public String toString() {
		return id + ";;\"" + gameTitle + "\";;\"" + releaseDate + "\";;" 
				+ platformId + ";;\"" + overview + "\";;\"" + rating + "\";;\"" 
				+ players + "\";;\"" + publisher + "\";;\"" + developer;
	}

}
