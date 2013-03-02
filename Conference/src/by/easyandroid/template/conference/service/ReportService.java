package by.easyandroid.template.conference.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import by.easyandroid.template.conference.model.Report;
import by.easyandroid.template.conference.model.Reporter;
import by.easyandroid.template.conference.model.Section;

public class ReportService extends AbstractEntityService<Report> {

	@Override
	public List<Report> getAll() {
		List<Report> result = new ArrayList<Report>();
		
		// TODO get reports from xml file
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
		
		Reporter r = new Reporter();
		r.setName("������ �.�.");
		report.setReporter(r);
		report.setTime(new Date(2012, 10, 30, 10, 0));
		
		Section s = new Section();
		s.setName("������ �");
		report.setSection(s);
		
		return report;
	}
}