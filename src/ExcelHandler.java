import org.testng.internal.EclipseInterface;

public class ExcelHandler {
	public static final String USERNAME = "�û���";
	public static final String PASSWORD = "����";
	public static final String TITLE = "����";
	public static final String PROJECT = "��Ŀ����";
	public static final String DEVELOPER = "��������";
	public static final String SUBPROJECT = "����Ŀ";
	public static final String PRODUCT = "��Ʒϵ��";
	public static final String FIRSTC = "һ����������";
	public static final String SECONDC = "������������";
	public static final String VERSION = "�汾";
	public static final String DESCRIBE = "��ϸ����";
	public static final String SERVERTITY = "������";
	public static final String TYPE = "����";
	public static final String REPRODUCIBILITY = "�ɸ�����";
	public static final String TESTCASE = "��������";
	public static final String TESTSOLUTION = "���Է���";
	public static final String STAGE = "���ֽ׶�";
	public static final String ATTACHMENT = "��ظ���";
			
	private String userName;//�û���
	private String passWord;//����
	private String title;//����
	private String project;//��Ŀ����
	private String developer;//��������
	private String subProject;//����Ŀ
	private String product;//��Ʒϵ��
	private String firstCharacteristic;//һ������
	private String secondCharacteristic;//��������
	private String version;//�汾
	private String describe;//��ϸ����
	private String serverity;//������
	private String type;//����
	private String reproducibility;//�ɸ�����
	private String testCase;//��������
	private String testSolution;//���Է���
	private String stage;//���ֽ׶�
	private String attachment;//��ظ���
	


	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	public void setSubProject(String subproject) {
		this.subProject = subproject;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public void setFirstCharacteristic(String firstCharacteristic) {
		this.firstCharacteristic = firstCharacteristic;
	}
	public void setSecondCharacteristic(String secondCharacteristic) {
		this.secondCharacteristic = secondCharacteristic;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public void setServerity(String serverity) {
		this.serverity = serverity;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setReproducibility(String reproducibility) {
		this.reproducibility = reproducibility;
	}
	public void setTestCase(String testCase) {
		this.testCase = testCase;
	}
	public void setTestSolution(String testSolution) {
		this.testSolution = testSolution;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public String getUserName() {
		return userName;
	}
	public String getPassWord() {
		return passWord;
	}

	public String getTitle() {
		return title;
	}
	public String getProject() {
		return project;
	}

	public String getDeveloper() {
		return developer;
	}

	public String getSubProject() {
		return subProject;
	}

	public String getProduct() {
		return product;
	}

	public String getFirstCharacteristic() {
		return firstCharacteristic;
	}

	public String getSecondCharacteristic() {
		return secondCharacteristic;
	}

	public String getVersion() {
		return version;
	}

	public String getDescribe() {
		return describe;
	}

	public String getServerity() {
		return serverity;
	}

	public String getType() {
		return type;
	}

	public String getReproducibility() {
		return reproducibility;
	}

	public String getTestCase() {
		return testCase;
	}

	public String getTestSolution() {
		return testSolution;
	}

	public String getStage() {
		return stage;
	}
	
	
	public String getAttachment() {
		return attachment;
	}

	@Override
	public String toString() {
		return userName + " " + passWord + " " + title + " " + project + " " + developer 
				+ " " + subProject + " " + product + " " + firstCharacteristic + " " + secondCharacteristic 
				+ " " + version + " " + describe + " " + serverity + " " + type + " " + reproducibility 
				+ " " + testCase + " " + testSolution + " " + stage + " " + attachment; 
	}


	

}
