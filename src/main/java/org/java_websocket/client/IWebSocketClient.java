package org.java_websocket.client;

import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.NotYetConnectedException;

import org.java_websocket.IWebSocket;
import org.java_websocket.WebSocketFactory;
import org.java_websocket.IWebSocket.READYSTATE;
import org.java_websocket.client.WebSocketClient.WebSocketClientFactory;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;

public interface IWebSocketClient {

	/**
	 * Gets the URI that this WebSocketClient is connected to.
	 * 
	 * @return The <tt>URI</tt> for this WebSocketClient.
	 */
	public abstract URI getURI();

	/** Returns the protocol version this channel uses. */
	public abstract Draft getDraft();

	/**
	 * Starts a background thread that attempts and maintains a WebSocket
	 * connection to the URI specified in the constructor or via <var>setURI</var>.
	 * <var>setURI</var>.
	 */
	public abstract void connect();

	/**
	 * Same as connect but blocks until the websocket connected or failed to do so.<br>
	 * Returns whether it succeeded or not.
	 **/
	public abstract boolean connectBlocking() throws InterruptedException;

	public abstract void close();

	public abstract void closeBlocking() throws InterruptedException;

	/**
	 * Sends <var>text</var> to the connected WebSocket server.
	 * 
	 * @param text
	 *            The String to send to the WebSocket server.
	 */
	public abstract void send(String text) throws NotYetConnectedException;

	/**
	 * Sends <var>data</var> to the connected WebSocket server.
	 * 
	 * @param data
	 *            The Byte-Array of data to send to the WebSocket server.
	 */
	public abstract void send(byte[] data) throws NotYetConnectedException;

	/**
	 * This represents the state of the connection.
	 * You can use this method instead of
	 */
	public abstract READYSTATE getReadyState();

	public abstract void onCloseInitiated(int code, String reason);

	public abstract void onClosing(int code, String reason, boolean remote);

	public abstract IWebSocket getConnection();

	public abstract void setWebSocketFactory(WebSocketClientFactory wsf);

	public abstract WebSocketFactory getWebSocketFactory();

	public abstract void onOpen(ServerHandshake handshakedata);

	public abstract void onMessage(String message);

	public abstract void onClose(int code, String reason, boolean remote);

	public abstract void onError(Exception ex);

	public abstract void onMessage(ByteBuffer bytes);

}