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
		result.add(createReport("������ ������"));
		result.add(createReport("������ ������ 2"));
		result.add(createReport("������ ������ 3"));
		result.add(createReport("������ ������ 4"));
		result.add(createReport("������ ������ 5"));
		result.add(createReport("������ ������ 6"));
		result.add(createReport("������ ������"));
		result.add(createReport("������ ������ 2"));
		result.add(createReport("������ ������ 3"));
		result.add(createReport("������ ������ 4"));
		result.add(createReport("������ ������ 5"));
		result.add(createReport("������ ������ 6"));		

		return result;
	}
	
	@Override
	public Report getById(long id) {
		// TODO fake reporter now
		return createReport("�����-�� ������");
	}	
	
	private Report createReport(String title) {
		Report report = new Report();
		report.setId("1");
		report.setTitle(title);
		
		Reporter r = new Reporter();
		r.setName("������ �.�.");
		r.setDescription("������� ���������� � ����� �������");
		report.setReporter(r);
		report.setTime(new Date(2012, 10, 30, 10, 0));
		
		Section s = new Section();
		s.setName("������ �");
		report.setSection(s);
		
		report.setDesctiption("�������� ������-�� �������, �������� ����� ������� �����.");
		
		return report;
	}
}