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
	 * ������zk�Ŀͻ�������
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
	 * ��zk��Ⱥע���������Ϣ
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
	 * ҵ����
	 * 
	 * @throws InterruptedException
	 */
	public void handleBussiness(String hostname) throws InterruptedException {
		System.out.println(hostname + "start working.....");
		Thread.sleep(Long.MAX_VALUE);
	}

	public static void main(String[] args) throws Exception {

		// ��ȡzk����
		Test server = new Test();
		server.getConnect();

		// ����zk����ע���������Ϣ
		server.registerServer(args[0]);

		// ����ҵ����
		server.handleBussiness(args[0]);

	}
}
