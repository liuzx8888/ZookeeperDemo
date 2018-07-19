import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class ZKClients {
	private static final int sessionTimeout = 30000;
	private static final String connectString = "192.168.40.20:2181,192.168.40.21:2181,192.168.40.22:2181";
	ZooKeeper zk = null;

	public void init() throws Exception {
		zk = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
			@Override
			public void process(WatchedEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println(arg0.getType());
			}
		});
	}

}
