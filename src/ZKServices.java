import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ZKServices {
	private static final int sessionTimeout = 30000;
	private static final String connectString = "192.168.40.58:2181,192.168.40.59:2181,192.168.40.60:2181";
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
		zk.create(node, hostname.getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
	}
	public void registerServer(String node) {
		zk.cre
	}
	

	public void handleBussiness(String hostname) {
		System.out.println(hostname + "  is working......");
	}

	public static void main(String[] args) throws Exception {
		String nodelevel = nodepath + "/server";

		ZKServices services = new ZKServices();
		services.init();

		if (services.exists(args[0])) {
			System.out.println(args[0] + "  is already exist");
		} else {
			services.registerServer(args[0]);
		}

		services.handleBussiness(args[0]);
	}
}
