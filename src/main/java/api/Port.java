package api;

public abstract class Port {
	/**This method must ping the given API interface, and check if it is still online.
	 * @return a boolean value indicating the status of the API in question. */
	protected abstract boolean keepAlive();
	
	/** */
	protected abstract Class getType();
}
