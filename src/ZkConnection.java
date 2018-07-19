import java.io.IOException;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Version;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

public class ZkConnection {

	private static final int sessionTimeout = 30000;
	private static final String connectString = "192.168.40.20:2181,192.168.40.21:2181,192.168.40.22:2181";
	ZooKeeper zk = null;

	@Before
	public void init() throws Exception {
		zk = new ZooKeeper(connectString, sessionTimeout, new Watcher() {

			@Override
			public void process(WatchedEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println(arg0.getType());
				try {
					zk.getChildren("/", true);
				} catch (KeeperException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
	}

	public void create() throws Exception, InterruptedException {
		zk.create("/zk6", "myzk01".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
	}

	public void set() throws Exception, InterruptedException {
		zk.setData("/zk6", "myzk03".getBytes(),-1 );
	}

	public boolean exists() throws Exception, InterruptedException {
		Stat stat = zk.exists("/zk6", true);
		/*if (stat != null) {
			return true;
		} else {
			return false;
		}*/
		return stat != null ? true : false;
	}

	public static void main(String[] args) throws InterruptedException, Exception {
		ZkConnection connection = new ZkConnection();
		connection.init();
		if (connection.exists()) {
			connection.set();
		} else {
			connection.create();
		}
	}

}
