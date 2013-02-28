package by.easyandroid.template.conference.service;

import java.util.ArrayList;
import java.util.List;

import by.easyandroid.template.conference.model.Report;

public class ReportService {

	public List<Report> getReports() {
		List<Report> result = new ArrayList<Report>();
		
		// TODO get reorts from xml file
		result.add(addReport("������ ������"));
		result.add(addReport("������ ������ 2"));
		result.add(addReport("������ ������ 3"));
		result.add(addReport("������ ������ 4"));
		result.add(addReport("������ ������ 5"));
		result.add(addReport("������ ������ 6"));
		result.add(addReport("������ ������"));
		result.add(addReport("������ ������ 2"));
		result.add(addReport("������ ������ 3"));
		result.add(addReport("������ ������ 4"));
		result.add(addReport("������ ������ 5"));
		result.add(addReport("������ ������ 6"));		

		return result;
	}
	
	private Report addReport(String title) {
		Report report = new Report();
		report.setId("1");
		report.setTitle(title);
		return report;
	}
}