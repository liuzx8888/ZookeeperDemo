import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ZKServices {
	private static final int sessionTimeout = 3000;
	private static final String connectString = "192.168.40.20:2181,192.168.40.21:2181,192.168.40.22:2181";
	ZooKeeper zk = null;
	private static final String nodepath = "/servers";

	public void init() throws Exception {
		zk = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
			@Override
			public void process(WatchedEvent arg0) {
				// TODO Auto-generated method stub
				try {
					zk.getChildren("/", true);
				} catch (KeeperException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	public Boolean exists(String node) throws KeeperException, InterruptedException {
		Stat stat = zk.exists(node, true);
		return stat != null ? true : false;
	}

	public void registerServer(String node, String hostname) throws KeeperException, InterruptedException {
		zk.create(node, hostname.getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
	}

	public void handleBussiness(String hostname) {
		System.out.println(hostname + "  is working...");

	}

	public static void main(String[] args) throws Exception {
		String nodelevel = nodepath + "/server";
		ZKServices services = new ZKServices();
		services.init();
		services.registerServer(nodelevel, args[0]);
		services.handleBussiness(args[0]);

	}
}
