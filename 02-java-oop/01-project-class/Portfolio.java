import java.util.ArrayList;
public class Portfolio {
	private ArrayList<Project> projects;
	public Portfolio() {
		this.projects = new ArrayList<Project>();
	}
	public void addPortfolio(Project project) {
		this.projects.add(project);
	}
	public void showPortfolio() {
		for (Project project: this.projects){
			System.out.println(project.elevatorPitch());
		}
	}
	public double getPortfolioCost() {
		double total = 0;
		for(Project project: this.projects) {
			total += project.getInitialCost();
		}
		return total;
	}
}
