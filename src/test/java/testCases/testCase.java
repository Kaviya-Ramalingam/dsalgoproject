package testCases;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObject.ArrayPage;
import pageObject.DataStructurePage;
import pageObject.GetStarted;
import pageObject.LinkedlistPage;
import pageObject.QueuePage;
import pageObject.GraphPage;
import pageObject.RegisterPage;
import pageObject.SigninPage;
import pageObject.StackPage;
import pageObject.TreePage;
import pageObject.homePage;
import utility.DPclass;

@Listeners(base.Listener.class)		
public class testCase extends BaseClass  {
	
	GetStarted gs = new GetStarted();
	homePage hp = new homePage();
	RegisterPage rp = new RegisterPage();
	SigninPage sp = new SigninPage();
	DataStructurePage ds = new DataStructurePage();
	GraphPage gp1 = new GraphPage();
	TreePage tp=new TreePage();
	QueuePage qp = new QueuePage();
	ArrayPage Ap = new ArrayPage();
	StackPage Sp = new StackPage();
	LinkedlistPage lp = new LinkedlistPage();
	
	@Test(priority=0)
	@Parameters({"browser"})
	public void launchBrowser(String browsername) {
		crossBrowser(browsername);
		
	}
	@Test(priority=1)
	public void launchUrl() throws IOException
	{
		
		setupApplication();
		gs.getstarted();
	}
	
	@Parameters({"string","string1"})
	@Test(priority=2)
	public void homepage(String string, String string1) throws InterruptedException, IOException
	{ 
		hp.getStartedhome(string);
		hp.displayErrorMsg();
		hp.dropdown(string1);
		hp.displayalertMsg();
		//hp.selectdropdown();
		hp.signIn();
		hp.register();
	}
	
	@Test(priority=3)
	public void RegisterPage() throws InterruptedException, IOException {
		rp.clickRegister();
		rp.verifyUserWarnMsg();
		rp.verifyPassWarnMsg();
		rp.verifyConPassWarnMsg();
		rp.Register();
	}
	
	@Test(priority=4,dataProvider = "Logindata",dataProviderClass = DPclass.class)
	public void login(String user,String pswd, String exp) throws InterruptedException {
		sp.login(user, pswd, exp);

	}
	
	@Test(priority=6,dataProvider= "codedata",dataProviderClass = DPclass.class)
	public void Array(String phythonCode) throws Exception {
		Ap.dropdown();
		Ap.performarray(phythonCode);
		Ap.practiceQarray(phythonCode);
		}
	
	@Test(priority=5,dataProvider= "codedata",dataProviderClass = DPclass.class)
	public void DataStructure(String phythonCode) throws Exception {
		ds.clickdatastructure();
		ds.AccessDS(phythonCode);
		//ds.PracticeQ();
		
	}
	
	@Test(priority=6,dataProvider= "codedata",dataProviderClass = DPclass.class)
	public void LinkedList(String phythonCode) throws IOException, InterruptedException {
		lp.clickLinkedlist();
		lp.AccessLinkedlist(phythonCode);
		lp.PracticeQ();
		
	}
	@Test(priority=6,dataProvider= "codedata",dataProviderClass = DPclass.class)
	public void queue(String phythonCode) throws Exception {
		qp.clickQue();
		qp.AccessQueue(phythonCode);
		qp.practiceQ();
	}
	
		
	@Test(priority=7,dataProvider= "codedata",dataProviderClass = DPclass.class)
	public void graph(String phythonCode) throws IOException, InterruptedException {
		
		gp1.clickGraph();
		gp1.AccessGraph(phythonCode);
		gp1.practiceQ();
		//gp2.
		//gp1.testInput(phythonCode);
		//gp.clickGraph();
		//Thread.sleep(1000);
		//gp.selectGraph(phythonCode);
		//Thread.sleep(1000);
		//gp.selectGraphRepresentation( phythonCode);
	}
	@Test(priority=8,dataProvider= "codedata",dataProviderClass = DPclass.class)
	public void tree(String phythonCode) throws IOException, InterruptedException {
		
		tp.clickTree();
		tp.Tree(phythonCode);
		tp.PracticeQ();
	}
	
	@Test(priority=9,dataProvider= "codedata",dataProviderClass = DPclass.class)
	public void stack(String phythonCode) throws IOException, InterruptedException {
		Sp.clickStack();
		Sp.AccessStack(phythonCode);
		Sp.PracticeQues();
		
	}
	
}	
	
	/*@Test(priority=4)
public void Graph() throws IOException, InterruptedException {
	graph.clickGraph();
	graph.AccessGraph();
	graph.practiceQ();
	}
	
	@Test(priority=5)
	public void tree() throws IOException, InterruptedException {
		tree.clickTree();
		tree.AccessTree();
		tree.PracticeQ();
	}*/



