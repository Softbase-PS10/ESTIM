/*
 * SOFTBASE - GRUPO 10
 * AUTORES:
 * 		-Alberto Blasco
 * 		-Diego Galvez
 * 		-Patricia Lazaro
 * 		-Alejandro Marquez
 * 		-Alejandro Royo
 * 		-Jaime Ruiz-Borau
 * DESCRIPCION: clase para el tratamiento de imagenes. Tiene metodos para
 * 				la obtencion de imagenes a partir de URLs y el cambio de
 * 				dimensiones de imagenes
 */
package controlador;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.ImageIO;

public class Imagenes {

	/* declaracion de atributos */
	private final static int WIDTH = 128;
	private final static int HEIGHT = 180;

	/* declaracion de metodos y funciones */

	/**
	 * @param url
	 *            : URL de la imagen
	 * @param escala
	 *            : factor por el que se multiplicara la dimension de la imagen
	 * @return la imagen de la URL con dimensiones (@param escala*128, @param
	 *         escala*180)
	 * @throws IOException
	 *             si se produce algun error en la obtencion de la imagen
	 */
	public static Image getIcon(String url, int escala) throws IOException {
		if (url == null){
			return null;
		}
		return Imagenes.getImage(url, WIDTH * escala, HEIGHT * escala);
	}

	/**
	 * @param url
	 *            : URL de la imagen
	 * @param width
	 *            : anchura de la imagen
	 * @param height
	 *            : altura de la imagen
	 * @return la imagen de @param url con @param width x @param height
	 *         dimensiones
	 * @throws IOException
	 *             si se produce algun error en la obtencion de la imagen
	 */
	public static Image getImage(String url, int width, int height)
			throws IOException {

		return Imagenes.resizeImage(Imagenes.Url2Image(url), width, height);
	}

	/**
	 * @param url
	 *            : URL de la imagen
	 * @return la imagen de @param url
	 * @throws IOException
	 *             si se produce algun error en la obtencion de la imagen
	 */
	public static BufferedImage Url2Image(String url) throws IOException {
		URL link = new URL(url);
		URLConnection conn = link.openConnection();
		conn.addRequestProperty("User-Agent",
				"Mozilla/5.0 (Windows NT 6.1;"
				+ " WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
		BufferedInputStream in = new BufferedInputStream(conn.getInputStream());
		ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
		int c;
		while ((c = in.read()) != -1) {
			byteArrayOut.write(c);
		}

		BufferedImage image = ImageIO.read(new ByteArrayInputStream(
				byteArrayOut.toByteArray()));

		return image;

	}

	/**
	 * @param image
	 *            : imagen que redimensionar
	 * @param width
	 *            : nueva anchura de la imagen
	 * @param height
	 *            : nueva altura de la imagen
	 * @return la imagen @param image con dimensiones @param width x @param
	 *         height
	 */
	public static BufferedImage resizeImage(final Image image, int width,
			int height) {
		final BufferedImage bufferedImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		final Graphics2D graphics2D = bufferedImage.createGraphics();
		graphics2D.setComposite(AlphaComposite.Src);
		graphics2D.drawImage(image, 0, 0, width, height, null);
		graphics2D.dispose();

		return bufferedImage;
	}
}
