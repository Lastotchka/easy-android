package by.easyandroid.webapp.form.appCustomization.reporter;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import by.easyandroid.database.service.conference.ReporterService;
import by.easyandroid.database.service.exception.DatabaseServiceException;
import by.easyandroid.model.conference.Reporter;
import by.easyandroid.webapp.form.appCustomization.AbstractConferenceBaseForm;

@ManagedBean
@RequestScoped
public class ReportersForm extends AbstractConferenceBaseForm {

	@ManagedProperty(value = "#{createReporterDialog}")
	private CreateReporterDialog createReporterDialog;
	
	@ManagedProperty(value = "#{reporterService}")
	private ReporterService reporterService;
	
	private List<Reporter> reporters = new ArrayList<Reporter>(); 
	
	@Override
	public void init() throws Exception {
		super.init();
		// TODO load values from database, get request parameter conference id
		// TODO it's better to do that when enabling/disabling opening ConferenceForm
		// TODO check if selected conference belongs to user
		if (template != null) {
			reporters = template.getModel().getReporters();
		}
	}

	public void create(ActionEvent event) {
		Reporter reporter = new Reporter();
		reporter.setName(createReporterDialog.getName());
		reporter.setCompany(createReporterDialog.getCompany());
		reporter.setDescription(createReporterDialog.getDescription());
		reporter.setEmail(createReporterDialog.getEmail());
		reporter.setPosition(createReporterDialog.getPosition());
		
		try {
			if (template != null) {
				reporterService.add(reporter, template);
				createReporterDialog.close();
			}
		} catch (DatabaseServiceException e) {
			// TODO display error message
			e.printStackTrace();
		}
	}	
	
	public List<Reporter> getReporters() {
		return reporters;
	}

	public void setReporters(List<Reporter> reporters) {
		this.reporters = reporters;
	}

	public CreateReporterDialog getCreateReporterDialog() {
		return createReporterDialog;
	}

	public void setCreateReporterDialog(CreateReporterDialog createReporterDialog) {
		this.createReporterDialog = createReporterDialog;
	}

	public ReporterService getReporterService() {
		return reporterService;
	}

	public void setReporterService(ReporterService reporterService) {
		this.reporterService = reporterService;
	}
}