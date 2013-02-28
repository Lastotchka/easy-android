package by.easyandroid.template.conference.service;

import java.util.ArrayList;
import java.util.List;

import by.easyandroid.template.conference.model.Reporter;

public class ReporterService {

	public List<Reporter> getReporters() {
		List<Reporter> result = new ArrayList<Reporter>();
		
		// TODO get reorters from xml file
		result.add(addReporter("������ �.�."));
		result.add(addReporter("������ �.�."));
		result.add(addReporter("������� �.�."));
		
		return result;
	}
	
	private Reporter addReporter(String name) {
		Reporter reporter = new Reporter();
		reporter.setId("1");
		reporter.setName(name);
		reporter.setDescription("������� ���������� � ����� �������, ���������� ������� ����������.");
		
		return reporter;
	}
}