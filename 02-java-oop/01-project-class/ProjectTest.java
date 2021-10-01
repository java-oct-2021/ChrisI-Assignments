public class ProjectTest {
	public static void main(String[] args) {
		Portfolio portfolio = new Portfolio();
		portfolio.addPortfolio(new Project("name1","description1",100));
		portfolio.addPortfolio(new Project("name2","description2",200));
		portfolio.addPortfolio(new Project("name3","description3__",300));
		portfolio.showPortfolio();
		System.out.println(portfolio.getPortfolioCost());
	}
}
