import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class Test {
	private static final String connectString = "192.168.40.58:2181,192.168.40.59:2181,192.168.40.60:2181";
	private static final int sessionTimeout = 30000;
	private static final String parentNode = "/servers";

	private ZooKeeper zk = null;

	/**
	 * 创建到zk的客户端连接
	 * 
	 * @throws Exception
	 */
	public void getConnect() throws Exception {

	 zk = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
		@Override
		public void process(WatchedEvent event) {
			// TODO Auto-generated method stub
			System.out.println(event.getType() + "---" + event.getPath());
			try {
				zk.getChildren("/", true);
			} catch (Exception e) {
			}
		}
	});

	}

	/**
	 * 向zk集群注册服务器信息
	 * 
	 * @param hostname
	 * @throws Exception
	 */
	public void registerServer(String hostname) throws Exception {

		String create = zk.create(parentNode + "/server", hostname.getBytes(), Ids.OPEN_ACL_UNSAFE,
				CreateMode.EPHEMERAL_SEQUENTIAL);
		System.out.println(hostname + "is online.." + create);

	}

	/**
	 * 业务功能
	 * 
	 * @throws InterruptedException
	 */
	public void handleBussiness(String hostname) throws InterruptedException {
		System.out.println(hostname + "start working.....");
		Thread.sleep(Long.MAX_VALUE);
	}

	public static void main(String[] args) throws Exception {

		// 获取zk连接
		Test server = new Test();
		server.getConnect();

		// 利用zk连接注册服务器信息
		server.registerServer(args[0]);

		// 启动业务功能
		server.handleBussiness(args[0]);

	}
}
