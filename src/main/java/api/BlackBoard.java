package api;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class BlackBoard {
	private static BlackBoard board;
	private final List<Port> clients = new ArrayList<>();
	
	private BlackBoard() {
		clients.add(GitClient.getClient());
		clients.add(DiscordClient.getClient());
		clients.add(SlackClient.getClient());
		clients.add(TravisClient.getClient());
		clients.add(TrelloClient.getClient());
		
		Clock.setClock(4000000, this);
	}
	
	private void ping() {
		for(Port p : clients) {
			if(!p.keepAlive()) {
				//TODO some form of error handling in here.
			}
		}
	}
	
	public static BlackBoard getInstance() {
		if(board == null) {
			board = new BlackBoard();
		}
		
		return board;
	}
	
	private static class Clock {
		private static void setClock(long ms, BlackBoard board) {
			Timer timer = new Timer();
			HeartBeat task = board.new HeartBeat();
			
			timer.scheduleAtFixedRate(task, ms, ms);
		}
	}
	
	private class HeartBeat extends TimerTask {

		@Override
		public void run() {
			board.ping();
		}
		
	}
}
