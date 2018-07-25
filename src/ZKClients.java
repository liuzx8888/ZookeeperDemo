import java.util.ArrayList;
import java.util.List;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ZKClients {
	private static final int sessionTimeout = 3000;
	private static final String connectString = "192.168.40.20:2181,192.168.40.21:2181,192.168.40.22:2181";
	ZooKeeper zk = null;
	private static final String nodepath = "/servers";
	public volatile List<String> ServicesList = new ArrayList<String>();

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

	private void getServiceList() throws KeeperException, InterruptedException {
		// TODO Auto-generated method stub
		List<String> childrens = zk.getChildren(nodepath, true);
		for (String str : childrens) {
			byte[] data = zk.getData(nodepath + "/" + str, true, null);
			ServicesList.add(new String(data));
		}
		System.out.println(ServicesList);
	}

	public static void main(String[] args) throws Exception {
		ZKClients zkClients = new ZKClients();
		zkClients.init();
		zkClients.getServiceList();

	}

}
