import org.testng.internal.EclipseInterface;

public class ExcelHandler {
	public static final String USERNAME = "用户名";
	public static final String PASSWORD = "密码";
	public static final String TITLE = "标题";
	public static final String PROJECT = "项目名称";
	public static final String DEVELOPER = "开发代表";
	public static final String SUBPROJECT = "子项目";
	public static final String PRODUCT = "产品系列";
	public static final String FIRSTC = "一级测试特性";
	public static final String SECONDC = "二级测试特性";
	public static final String VERSION = "版本";
	public static final String DESCRIBE = "详细描述";
	public static final String SERVERTITY = "严重性";
	public static final String TYPE = "类型";
	public static final String REPRODUCIBILITY = "可复现性";
	public static final String TESTCASE = "测试用例";
	public static final String TESTSOLUTION = "测试方案";
	public static final String STAGE = "发现阶段";
	public static final String ATTACHMENT = "相关附件";
			
	private String userName;//用户名
	private String passWord;//密码
	private String title;//标题
	private String project;//项目名称
	private String developer;//开发代表
	private String subProject;//子项目
	private String product;//产品系列
	private String firstCharacteristic;//一级特性
	private String secondCharacteristic;//二级特性
	private String version;//版本
	private String describe;//详细描述
	private String serverity;//严重性
	private String type;//类型
	private String reproducibility;//可复现性
	private String testCase;//测试用例
	private String testSolution;//测试方案
	private String stage;//发现阶段
	private String attachment;//相关附件
	


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
