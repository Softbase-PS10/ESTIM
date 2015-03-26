package recoleccion;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import data.Data;
import data.Game;
import data.Platform;

/**
 * @author Ricardo Ocaña Leal
 *
 */
public class GamesDBConnector {

	private final String requestUrl = "http://thegamesdb.net/api/";

	/**
	 * Devuelve una lista de todas las plataformas en thegamesdb.net
	 * @return
	 */
	public List<Platform> getPlatformsList() {
		InputStream stream = createRequest("GetPlatformsList.php");
		Data data = getData(stream);

		try {
			stream.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return data.getPlatformWrapper().getPlatforms();
	}
	
	public List<Game> getPlatformGames (Long id){
		InputStream stream = createRequest("GetPlatformGames.php?platform=" + id);
		Data data = getData(stream);
		
		try {
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return data.getGames();
	}

	public Platform getPlatform(Long id) {
		InputStream stream = createRequest("GetPlatform.php?id=" + id);
		Data data = getData(stream);

		try {
			stream.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		Platform p = data.getPlatforms().get(0);
		p.setBaseUrl(data.getBaseImgUrl());
		return p;
	}

	public Game getGame(String id) {
		InputStream stream = createRequest("GetGame.php?id=" + id);
		Data data = getData(stream);

		try {
			stream.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		Game game = data.getGames().get(0);
		game.setBaseUrl(data.getBaseImgUrl());

		return game;
	}

	public List<Game> searchGames(String searchString) {
		InputStream stream = createRequest("GetGamesList.php?name="
				+ searchString);
		Data data = getData(stream);

		try {
			stream.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return data.getGames();
	}
	
	

	private InputStream createRequest(String requestParams) {
		String request = requestUrl + requestParams;
		HttpURLConnection connection = null;
		InputStream resultXMLStream = null;

		try {
			URL url = new URL(request);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection
					.setRequestProperty(
							"User-Agent",
							"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			connection.setRequestProperty("Accept", "application/xml");
			resultXMLStream = connection.getInputStream();
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return resultXMLStream;
	}

	private Data getData(InputStream inputStream) {
		Data data = null;

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Data.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			data = (Data) jaxbUnmarshaller.unmarshal(inputStream);
		} catch (JAXBException je) {
			je.printStackTrace();
		}

		return data;
	}
}
