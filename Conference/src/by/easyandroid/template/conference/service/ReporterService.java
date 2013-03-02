package by.easyandroid.template.conference.service;

import java.util.ArrayList;
import java.util.List;

import by.easyandroid.template.conference.model.Reporter;

public class ReporterService extends AbstractEntityService<Reporter> {

	@Override
	public List<Reporter> getAll() {
		List<Reporter> result = new ArrayList<Reporter>();
		
		// TODO get reorters from xml file
		result.add(createReporter("������ �.�."));
		result.add(createReporter("������ �.�."));
		result.add(createReporter("������� �.�."));
		
		return result;
	}
	
	@Override
	public Reporter getById(long id) {
		// TODO Fake reporter now!
		return createReporter("������ �.�.");
	}
	
	private Reporter createReporter(String name) {
		Reporter reporter = new Reporter();
		reporter.setId("1");
		reporter.setName(name);
		reporter.setDescription("������� ���������� � ����� �������, ���������� ������� ����������.");
		reporter.setCompany("SomeCompany");
		reporter.setEmail("ivanov@somecompany.com");
		reporter.setPosition("������� ����������");
		
		return reporter;
	}	
}